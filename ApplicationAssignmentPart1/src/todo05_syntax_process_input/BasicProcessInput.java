package todo05_syntax_process_input;

import java.util.ArrayList;
import java.util.List;

public class BasicProcessInput {
    private BasicProcessInput() {} // Makes this a utility class

    public static List<SplitInput> splitInput(List<String> fileLines) {
        /* TODO Use IntelliJ to change the method signature to have
                an extra parameter that specifies what pattern is used
                to split the input. This will make this method more general.
         */

        /* TODO Initialise splitLines with its final size
                 Note the apparent type on the left, the actual type on the right
         */
        List<SplitInput> splitLines = new ArrayList<>();

        /* TODO Iterate over the raw input, splitting, and saving
                the split input into the new structure.
                Try not to split the data component if it contains tabs.
         */

        /* TODO Design decision: where to remove blank lines from the
                processing stream?
                You could do it here, in which case "splitInput" might not
                be the clearest name.
                Or you could have another method that removes blank lines,
                in which case do you put it before or after splitInput?
         */

        /* TODO Optional but recommended:
                1. improve consistency by normalising the form categories
                2. handle lines that do not split
         */

        /* TODO If you are the kind of programmer who is worried by
                amount of memory that redundant copies of the input are occupying
                then you can set the variables pointing unwanted copies to be
                null to tell the JVM that their heap memory can be reclaimed.
                This might be useful if dealing with massive files but that is
                not going to happen in this assignment.
         */
        // Note: it is safe to return splitLines because it is a local variable
        return splitLines;
    }

    public static List<SplitInput> splitInputOnTab(List<String> fileLines){
        /* TODO Make this method call your revised splitInput, passing in
                the data and the pattern (a single tab) for splitting the
                input.
     */
        return splitInput(fileLines); // TODO Add the extra parameter
    }

    public static String normaliseCategory(String rawCommand) {
        /* TODO Make this method normalise the input
                For Part 1 you can decide what "normalise" means.
                Think about whether you want the input
                "timezone" and "TIMEZONE" and "timeZone" (and other variations)
                to become the same once normalised.
         */
        return rawCommand;
        /* TODO Tips: 1. Look through String's API by typing `rawCommand.`
                      2. You can make a small optimisation if you are
                         adjusting orthography and stripping extraneous
                         whitespace
         */
    }

    /* TODO Having normaliseCategory here means your code needs to "remember"
            to normalise categories before creating the object that stores
            a particular line. It also means you are designing in an
            imperative paradigm.
            Look in the Code Quality document for the example on potatoes.
            In the imperative paradigm you have a method that takes a potato
            as a parameter and boils it. An object-oriented potato knows how
            to boil itself. Use that analogy to think where the "best" place
            to have this method is and how to ensure it is always used.
            IntelliJ has tools to help you move members around.
     */
}
