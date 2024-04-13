package todo06_semantic_process_input;

import todo02_assignments.Assignment;
import todo05_syntax_process_input.SplitInput;

import java.util.ArrayList;
import java.util.List;

public class RunSemanticProcessing {
    public static void main(String[] args) {
        /* TODO Create a class with a single instance that holds
                the application's configuration.
                That design pattern is known as a Singleton
                and there are numerous ways to implement it.
                Reference it as a field in this class.
         */

        processConfiguration(args);

        List<Assignment> assignments = processAssignments();
    }

    private static void processConfiguration(String[] args) {
        // TODO You might want to use the command-line arguments

        // TODO Create a List of lines (sensible or otherwise) to process
        List<SplitInput> configurationLines = new ArrayList<>();
        for ( String configurationCategory : new String[]{"output",
                                                          "timezone",
                                                          "comment"} ) {
            configurationLines.add(new SplitInput(configurationCategory,
                                                  "you need customised config data per item"));
        }

        ProcessConfigCategory.processCategories(configurationLines);
    }

    private static List<Assignment> processAssignments() {
        // TODO Create a List of lines (sensible or otherwise) to process
        List<SplitInput> assignmentLines = new ArrayList<>();
        for ( String assignmentCategory : new String[]{"name", "course",
                                                       "start", "end"} ) {
            assignmentLines.add(new SplitInput(assignmentCategory,
                                               "you need customised assignment data per item"));
        }

        return ProcessAssignmentCategory.processCategories(assignmentLines);
    }
}
