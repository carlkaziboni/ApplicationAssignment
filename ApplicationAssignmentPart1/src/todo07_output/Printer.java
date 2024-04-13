package todo07_output;

import todo02_assignments.Assignment;
import todo06_semantic_process_input.Configuration;
import todo06_semantic_process_input.OutputConfig;

import java.math.BigDecimal;
import java.time.Duration;

public class Printer {
    /* TODO This class is a mess and should not be used as an example of
            good design. Eventually you should rewrite it (or start again).
            But first its purpose is to show you different components
            from elsewhere in the todo tasks and how they might be used.
     */
    /* TODO This class has been written in an imperative style: meaning there
            are parameters everywhere. Once you have got the functionality
            (more or less) working, you need to move the code into more
            appropriate places. Refresh your memory of the Code Quality document
            about potatoes. An imperative potato is passed as a parameter
            to a "boil" method (along with many other parameters such as cooking
            time, volume of water, amount of salt, amount of 10 other things
            that go in the water). An object-oriented potato knows how to boil
            itself, so it needs no parameters, it's simply a case of calling
            the potato's .boil() method. All the other information (volume of
            water, amount of this, that, and the other) is either already
            stored in the potato or is requested from other objects as needed.
            This means that an Assignment should know how to calculate its own
            duration and hours per day, and how to print itself. The application
            has a single configuration object so it can tell an Assignment
            what printing format to use.
     */
    /* TODO It's possible that Duration might not be the clearest class for
            calculating the days between dates. Feel free to use a different
            way.
     */

    // TODO Really you should use the application's sole configuration object.
    private static Configuration conf = new Configuration(OutputConfig.SUMMARY);

    public static void main(String[] args) {
        /* TODO Build a minimal Configuration:
                build a minimal one if you are starting with the output tasks
                otherwise build a fuller or full config if you are doing output
                last.
                You might be able to build it from input files.
         */
        // TODO conf = a proper configuration

        /* TODO Build a minimal Assignment:
                build a minimal one if you are starting with the output tasks
                otherwise build a fuller or full Assignment if you are doing
                output last.
                You might be able to build it from an input stream.
         */

        // TODO Remove this temporary declaration of hoursRequired
        BigDecimal hoursRequired = new BigDecimal(14);

        // TODO At some point you are doing to need proper information.
        //Assignment assignment = new Assignment(null, null, hoursRequired);

        // TODO Calculate the duration properly.
        Duration assignmentDuration =
                Duration.ofDays(6); // Nearly one week left

        //printWorkload(assignment, assignmentDuration, hoursRequired);
    }

    public static int hoursPerDay(Duration duration, BigDecimal totalHours) {
        /* Believe it or not, almost all the rest of the code
           in the entire application culminates in this
           single, (hopefully) simple(ish) line. Simple depending on the
           way you represent information and the library methods available to
           process them.
         */
        // TODO Calculate the hours per day
        return -1;
    }

    public static void printWorkload(Assignment assignment,
                                     Duration duration,
                                     BigDecimal hoursRequired) {
        /* TODO Transplant the technique or code from todo01_dates to calculate
                a duration between the start and end dates.
                Alternatively, don't bother with the Assignment object and
                just create a Duration from hard-coded dates.
         */


        /* TODO Switching on enums is neat, but it has the main weakness
                that when you add another element to the enum, you also have
                to remember (or know) to update this switch.
                A much better way is to add the functionality below directly
                into the enum.
         */
        switch ( conf.getOutputStyle() ) {
            case SUMMARY: {
                printSummary(assignment, duration, hoursRequired);
                break;
            }
            case DAILY: {
                printWeekly(assignment, duration, hoursRequired);
                break;
            }
            /* TODO You might need a way to gracefully handle unexpected input
                    that has somehow slipped through the filtering.
             */
            default: printSummary(assignment,duration,hoursRequired);
        }
    }

    public static void printSummary(Assignment assignment,
                                    Duration duration,
                                    BigDecimal hoursRequired) {
        /* TODO One of many problems with this method is that it is using
                a magic String rather than a proper constant for the template.
         */
        System.out.printf("Hours per day for this assignment %d%n",
                          hoursPerDay(duration, hoursRequired));
    }

    public static void printWeekly(Assignment assignment,
                                   Duration duration,
                                   BigDecimal hoursRequired) {

        // TODO This loop is just for testing: you need the real number of days.
        for ( int day = 1; day <= 7; day++ ) {
            /* TODO One of many problems with this method is that it is using
                    a magic String rather than a proper constant for the template.
             */
            System.out.printf("On day %d do %d hours%n",
                              day,
                              hoursPerDay(duration, hoursRequired));
        }
    }
}
