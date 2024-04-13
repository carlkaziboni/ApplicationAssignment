package todo01_dates;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DeadlineDates {
    // TODO Set the default time zone to "Europe/London"
    public static final String DEFAULT_TIMEZONE = "Europe/London";

    public static void main(String[] args) {
        /* NOTE: items are printed between ">" and "<" symbols
                 so you can see whether nothing / empty string is being printed
         */


        // TODO Set the timezone object to use "Europe/London" as the zone.
        ZoneId timezone = ZoneId.of(DEFAULT_TIMEZONE);
        System.out.printf("%9s >%s<%n", "ZoneId", timezone);

        // TODO Get the current time and date: its value changes each time the program is run
        ZonedDateTime now = ZonedDateTime.now();
        System.out.printf("%9s >%s<%n", "now start", now);


        /* NOTE: You use the `timezone` variable in all the following objects,
                 so ensure your `timezone` variable is correctly set.
         */

        // TODO Set this to be noon, 18 March 2024, using `int`s
        ZonedDateTime startDate = ZonedDateTime.of(2024, 3, 18, 12, 0, 0, 0, timezone);
        System.out.printf("%9s >%s<%n", "startDate", startDate);

        // TODO Set this to be noon, 18 March 2024, using a String
        ZonedDateTime startDateString = ZonedDateTime.parse("2024-03-12T12:00:00+00:00[" + DEFAULT_TIMEZONE + "]");
        System.out.printf("%9s >%s<%n", "startDate", startDateString);


        // TODO Set this to be noon, 28 March 2024, using `int`s
        ZonedDateTime deadline1 = ZonedDateTime.of(2024, 3, 28, 12, 0, 0, 0, timezone);
        System.out.printf("%9s >%s<%n", "deadline1", deadline1);

        // TODO Set this to be noon, 28 March 2024, using a String
        ZonedDateTime deadline1String = ZonedDateTime.parse("2024-03-28T12:00:00+00:00[" + DEFAULT_TIMEZONE + "]");
        System.out.printf("%9s >%s<%n", "deadline1", deadline1String);


        // TODO Set this to be midnight, 1 November 2024, using `int`s
        ZonedDateTime deadline2 = ZonedDateTime.of(2024, 11, 1, 0, 0, 0, 0, timezone);
        System.out.printf("%9s >%s<%n", "deadline2", deadline2);

        // TODO Set this to be midnight, 1 November 2024, using a String
        ZonedDateTime deadline2String = ZonedDateTime.parse("2024-11-01T00:00:00+00:00[" + DEFAULT_TIMEZONE + "]");
        System.out.printf("%9s >%s<%n", "deadline2", deadline2String);


        // TODO Calculate the duration between the startDate and deadline1
        Duration assignment1Remaining = Duration.between(startDate, deadline1);
        System.out.printf("%9s >%s<%n", "duration1", assignment1Remaining);

        // TODO Calculate the duration between the startDateString and deadline1String
        Duration assignment1StrRemaining = Duration.between(startDate, deadline1String);
        System.out.printf("%9s >%s<%n", "duration1", assignment1StrRemaining);


        //TODO Calculate the number of days between startdate1 and the deadline
        long days1Left = assignment1Remaining.toDays();
        System.out.printf("%9s >%d< days%n", "days1left", days1Left);

        System.out.printf("%9s That should say 10 days left%n", "");


        // TODO Calculate the duration between the startDate and deadline2
        Duration assignment2Remaining = Duration.between(startDate, deadline2);
        System.out.printf("%9s >%s<%n", "duration2", assignment2Remaining);

        // TODO Calculate the duration between the startDate and deadline2String
        Duration assignment2StrRemaining = Duration.between(startDate, deadline2String);
        System.out.printf("%9s >%s<%n", "duration2", assignment2StrRemaining);

        //TODO Calculate the number of days between startdate1 and the deadline
        long days2Left = assignment2Remaining.toDays();
        System.out.printf("%9s >%d< days%n", "days2left", days2Left);

        System.out.printf("%9s That should say 227 days left%n", "");


        // TODO Get the current time again, this time for the end of the program
        ZonedDateTime nowEnd = ZonedDateTime.now();
        System.out.printf("%9s >%s<%n", "now end", nowEnd);

        // TODO Show how long it took this program to run in nano seconds
        long runLength = Duration.between(now, nowEnd).toNanos();
        System.out.printf("%9s >%s< nano seconds%n", "run time", runLength);

        /* TODO Optional: test a range of times and dates so you feel
                comfortable. Consider testing the number of hours between two
                dates. Consider edge cases: what happens either side of
                daylight saving, or when the end date is before the start date.
         */
    }
}
