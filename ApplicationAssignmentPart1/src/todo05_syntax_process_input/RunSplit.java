package todo05_syntax_process_input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RunSplit {
    public static void main(String[] args) {
        // Note: apparent type on the left, actual type on the right
        final List<String> rawLines = new ArrayList<>();

        /* TODO Hard-coded simple examples are provided.
                Try making them "trickier" such as by adding errant spaces
         */
        rawLines.addAll(Arrays.asList("c1\td1", "c2\td2", "c3\td3"));

        List<SplitInput> splits = BasicProcessInput.splitInput(rawLines);

        // TODO Print the splits to see that you retained all the input
    }
}
