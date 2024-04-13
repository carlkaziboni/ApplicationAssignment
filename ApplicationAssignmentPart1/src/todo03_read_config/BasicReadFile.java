package todo03_read_config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.lang.Double;

public class BasicReadFile {
    /* One way to do this class is as a utility class.
       Such classes should not be instantiated.

       A private default constructor and having no other constructors prevents
       this class being instantiated easily.
     */
    private BasicReadFile() {} // Make the default constructor private

    public static List<String> read(String filename) {
        /* TODO Use a method in the Java "new IO" (nio) library
                that lets you read all a file's lines in a single call.
         */
        List<String> lines = new ArrayList<>();
        try {
         lines = Files.readAllLines(Path.of(filename));
        } catch (IOException e) {
         System.err.println("Error");
        }
        return lines;
        /* This method just calls a library method so it might seem
           superfluous: the code calling this method could have just
           called the library method directly. Think about why having this
           extra step reduces the knowledge required by whoever is writing
           the calling code, while increasing the flexibility should a
           different way of reading a file become necessary in future.
         */
    }

    public static List<LineContent> getProcessedFileLines(String filename) {
    /* TODO The return signature of the getProcessedFileLines is insufficient
            it forces another method to do further processing to "understand"
            the line's structure. You need to change from a List of String
            to a List of a class-of-your-own design that holds
            all of one line's content components already separated.
            Your class could include simple metadata about the line's contents.
     */
    /* TODO In future, processing file lines will need more information
            than just the filename. Consider how to pass this information
            neatly, extensibly, and robustly.
     */
    /* TODO Iterate over the lines read from the file, processing each line.
            Processing might mean: skipping blank lines
                                   splitting a line on its first tab
            Follow the guide for the basic line format.
     */
         List<String> lines = read(filename);
         Iterator<String> linesIterator = lines.iterator();
        /* Note the declaration of processedLines:
            "apparent" type on the left (the way the structure appears to the
                                         calling code)
            "actual" type on the right: so you can change the implementation
                                        without changing any of the calling code.
            The apparent type is more generic than the actual type.
         */
        List<LineContent> processedLines = new ArrayList<>();
        List<String> comments = new ArrayList<>();

        while (linesIterator.hasNext())
        {
         String current = linesIterator.next();
         if (!current.isBlank())
         {
            String[] currentSplit = current.strip().split("\t", 2);
            if (currentSplit[0].strip().equals("start") || currentSplit[0].equals("end"))
            {
               LineContent temp = new LineContent(currentSplit[0].strip(), ZonedDateTime.parse(currentSplit[1].strip()));
               processedLines.add(temp);   
            }
            else if (currentSplit[0].strip().equals("hours"))
            {
               LineContent temp = new LineContent(currentSplit[0].strip(), Double.parseDouble(currentSplit[1].strip()));
               processedLines.add(temp);
            }
            else if (currentSplit[0].strip().equals("comment"))
            {
               comments.add(currentSplit[1].strip());
            }
            else if (currentSplit[0].equals("timezone"))
            {
               LineContent temp = new LineContent(currentSplit[0].strip(), ZoneId.of(currentSplit[1].strip()));
               processedLines.add(temp);
            }
            else
            {
               LineContent temp = new LineContent(currentSplit[0].strip(), currentSplit[1].strip());
               processedLines.add(temp);
            }
         }
      }
         if (!comments.isEmpty()) {
            String commentsJoined = String.join("; ", comments);
            LineContent temp = new LineContent("comments", commentsJoined);
            processedLines.add(temp);
         }
        return processedLines;
        /* In case you are wondering, it is safe to return processedLines
           because it is a local variable not a field. Each time this method
           is called a new version of processedLines is created.
         */
    }
}