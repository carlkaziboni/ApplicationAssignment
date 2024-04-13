package todo02_assignments;

import java.time.Duration;
import java.time.ZonedDateTime;

public class Assignment {
    /* Compulsory information */
    private final ZonedDateTime endDate;
    private final ZonedDateTime startDate;
    private final double hoursRequired; // use a primitive type if you want

    /* Optional information */
    // The name of the assignment, but it can have no name
    private final String name; // TODO The initialisation of name needs altering

    /* TODO (Much) later, try adding at least one more piece of optional
            information to test your design's flexibility, and how simple you
            can keep the constructor's parameters.
     */


    /* TODO Optional: check how you can stop other classes manipulating this
            private field. You don't need this exact field for the application,
            though you might want something similar to hold a grouping of some
            data. This exaple is here just to prove a point.
     */

    public Assignment(ZonedDateTime endDate,
                      ZonedDateTime startDate,
                      double hoursRequired) {
        // Separate parameters per item works but is not a neat technique

        this.endDate       = endDate;
        this.startDate     = startDate;
        this.hoursRequired = hoursRequired;
        this.name          = "";
    }

    public Assignment(ZonedDateTime endDate, ZonedDateTime startDate, double hoursRequired, String name)
    {
        this.endDate       = endDate;
        this.startDate     = startDate;
        this.hoursRequired = hoursRequired;
        this.name          = name;
    }

    // getters for immutable objects can safely return the original object

    public ZonedDateTime getStartDate() {return startDate;}
    public String getName() {return name;}
    public ZonedDateTime getEndDate() {return endDate;}

    /* TODO This getter is potentially unsafe,
            though BigDecimal has no public methods for altering its state,
            so don't worry about it. Getters for primitive types are safe.
     */
    public double getHoursRequired() {return hoursRequired;}

    public Duration getDuration(){
        long timeBetween = Duration.between(this.startDate, this.endDate).toDays();
        return Duration.ofDays(timeBetween); // 7 days left: loads of time!
    }
}
