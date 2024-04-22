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
    private final String comment;
    private final String course;

    /* TODO (Much) later, try adding at least one more piece of optional
            information to test your design's flexibility, and how simple you
            can keep the constructor's parameters.
     */


    /* TODO Optional: check how you can stop other classes manipulating this
            private field. You don't need this exact field for the application,
            though you might want something similar to hold a grouping of some
            data. This exaple is here just to prove a point.
     */

    public Assignment(ZonedDateTime endDate, ZonedDateTime startDate, double hoursRequired, String name, String comment,
            String course) {
        this.endDate = endDate;
        this.startDate = startDate;
        this.hoursRequired = hoursRequired;
        this.name = name;
        this.comment = comment;
        this.course = course;
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

    public String getComment() {
        return comment;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Assignment other = (Assignment) obj;
        if (endDate == null) {
            if (other.endDate != null)
                return false;
        } else if (!endDate.equals(other.endDate))
            return false;
        if (startDate == null) {
            if (other.startDate != null)
                return false;
        } else if (!startDate.equals(other.startDate))
            return false;
        if (Double.doubleToLongBits(hoursRequired) != Double.doubleToLongBits(other.hoursRequired))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (comment == null) {
            if (other.comment != null)
                return false;
        } else if (!comment.equals(other.comment))
            return false;
        if (course == null) {
            if (other.course != null)
                return false;
        } else if (!course.equals(other.course))
            return false;
        return true;
    }
}
