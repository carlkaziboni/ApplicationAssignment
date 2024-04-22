package todo06_semantic_process_input;

import todo02_assignments.Assignment;
import todo05_syntax_process_input.SplitInput;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static todo05_syntax_process_input.BasicProcessInput.normaliseCategory;

public class ProcessAssignmentCategory {
    // NOTE: Utility class, so do not instantiate

    /*
     * TODO Note the call to normaliseCategory is imported from another todo task.
     * Doing this is computationally less efficient than normalising the
     * Strings manually but it guarantees compliance with the normalisation
     * standard.
     */
    public static final String NAME_ASSIGNMENT = normaliseCategory("name");
    public static final String NAME_COURSE = normaliseCategory("course");
    public static final String NAME_START = normaliseCategory("start");
    public static final String NAME_END = normaliseCategory("end");
    public static final String NAME_COMMENTS = normaliseCategory("comment");
    public static final String NAME_BEGIN = normaliseCategory("begin");
    public static final String NAME_HOURS = normaliseCategory("hours");

    // TODO Add more constants as you add more categories

    private ProcessAssignmentCategory() {
    } // Utility class: do not instantiate

    public static List<Assignment> processCategories(List<SplitInput> splitLines) {
        // Note this uses the SplitInput class from the syntax processing tasks
        // Note this uses the Assignment class from the assignments task

        List<Assignment> assignments = new ArrayList<>();

        // TODO Use these (and others) to save the components to build an Assignment
        String name = null;
        String course = null;
        ZonedDateTime start = null;
        ZonedDateTime end = null;
        String comment = null;
        BigDecimal hours = new BigDecimal(0);

        for (SplitInput splitLine : splitLines) {
            /*
             * TODO You have another problem: the stream of assignment information
             * will contain the details for multiple assignments: how do you
             * decide where one assignments stops and the next starts?
             */
            /*
             * TODO Even if you have already removed blank lines,
             * consider having robustness against them in this method
             * just in case the input has been created unofficially.
             */

            // Note: Saving a repeated method call can be faster
            String category = splitLine.category();

            /*
             * TODO There is no semantic checking of the data but
             * there should be. The requirements vary for each category.
             * Ensure this processCategories method does not become
             * unduly long.
             */
            /*
             * TODO This technique of acting on the input is basic but works.
             * See if you can find a neater way.
             * Given the similarity to
             */
            if (category.equals(NAME_ASSIGNMENT)) {
                // TODO Save the assignment name.
                name = splitLine.data();
            } else if (category.equals(NAME_COURSE)) {
                // TODO Save the course name.
                course = splitLine.data();
            } else if (category.equals(NAME_START)) {
                /*
                 * TODO Save the start date: you might need the default timezone
                 * from the configuration.
                 */
                try {
                    start = ZonedDateTime.parse(splitLine.data());
                } catch (Exception e) {
                    System.err.println("BLAH BLAH");
                }
            } else if (category.equals(NAME_END)) {
                /*
                 * TODO Save the end date: you might need the default timezone
                 * from the configuration.
                 */
                try {
                    end = ZonedDateTime.parse(splitLine.data());
                } catch (Exception e) {
                    System.err.println("BLAH BLAH BLAH");
                }
            } else if (category.equals(NAME_HOURS)) {
                hours = new BigDecimal(splitLine.data());
            } else if (category.equals(NAME_COMMENTS)){
                if (comment == null)
                {
                    comment = splitLine.data();
                    continue;
                }
                comment = comment + "; " + splitLine.data();

            }else if (category.equals(NAME_BEGIN) && (splitLines.indexOf(splitLine) == 0)) {

                continue;

            } else if (category.equals(NAME_BEGIN) && (start != null) && (end != null)
                    && (!hours.equals(new BigDecimal(0)))) {

                assignments.add(new Assignment(end, start, hours.doubleValue(), name, comment, course));
                end = null;
                start = null;
                hours = new BigDecimal(0);
                name = null;
                comment = null;
                course = null;

            } else {
                /*
                 * TODO You need to do better than this for unrecognised categories
                 * Do not use Exceptions.
                 */
                System.err.printf(
                        "Assignment category >%s< unrecognised (data >%s<)%n",
                        category,
                        splitLine.data());
            }

            // TODO Try to find a better way to build an Assignment object
        }
        if ((start != null) && (end != null) && (!hours.equals(new BigDecimal(0)))) {

            assignments.add(new Assignment(end, start, hours.doubleValue(), name, comment, course));

        }
        return assignments;
    }
}
