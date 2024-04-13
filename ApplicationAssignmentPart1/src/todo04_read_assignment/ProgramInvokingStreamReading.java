package todo04_read_assignment;

import java.util.List;

public class ProgramInvokingStreamReading {
    public static void main(String[] args) {

        /* TODO While it is ok to type a few examples, it is much better
                to redirect from a file: faster, easier, and more consistent.
                After you have run this class once, you can right-click
                the play button next to the `main` method and
                "Modify Run Configuration...".
                Under "Modify options" choose "Redirect input" and pick
                a file to read.
                Instead of keep changing files, create a new file
                `assignmentTest.tsv` and use that for all input.
                When you want to change the input, just paste new contents
                into that file.
         */

        List<String> fileLines = BasicReadStream.read(System.in);
        System.out.println(fileLines);
    }
}
