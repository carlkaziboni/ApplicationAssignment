package todo04_read_assignment;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BasicReadStream {
    private BasicReadStream() {}

    public static List<String> read(InputStream stream) {
        // Notice the apparent type on the left and the actual type on the right
        List<String> lines = new ArrayList<>();

        // TODO Use a BufferedReader to open the stream

        // TODO Use a try-with-resources statement
        // TODO Loop reading one line at a time until there are no more lines
        // TODO Append each line read to lines
        try
        (BufferedReader input = new BufferedReader(new InputStreamReader(stream)))
        {
            String inputRead;
            while((inputRead = input.readLine()) != null)
            {
                lines.add(inputRead);
            }
        }
        catch
        (IOException e)
        {
            System.err.println("Error");
        }
        // It is safe to return lines because it is a local variable
        return lines;
    }
}
