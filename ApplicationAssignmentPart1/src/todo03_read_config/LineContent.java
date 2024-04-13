package todo03_read_config;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.lang.Object;

public class LineContent {
    private final String title;
    private final String stringData;
    private final ZonedDateTime timeData;
    private final double doubleData;
    private final ZoneId timeZoneData;

    public LineContent(String title, String stringData)
    {
        this.title = title;
        this.stringData = stringData;
        this.timeData = null;
        this.doubleData = 0.0d;
        this.timeZoneData = null;
    }

    public LineContent(String title, ZonedDateTime timedata)
    {
        this.title = title;
        this.stringData = null;
        this.timeData = timedata;
        this.doubleData = 0.0d;
        this.timeZoneData = null;
    }

    public LineContent(String title, double doubleData)
    {
        this.title = title;
        this.stringData = null;
        this.timeData = null;
        this.doubleData = doubleData;
        this.timeZoneData = null;
    }

    public LineContent(String title, ZoneId timeZoneData) {
        this.title = title;
        this.stringData = null;
        this.timeData = null;
        this.doubleData = 0.0d;
        this.timeZoneData = timeZoneData;
    }

    public String getTitle() {
        return title;
    }

    public String getStringData() {
        return stringData;
    }

    public ZonedDateTime getTimeData() {
        return timeData;
    }

    public double getDoubleData() {
        return doubleData;
    }

    public ZoneId getTimeZoneData() {
        return timeZoneData;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LineContent other = (LineContent) obj;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (stringData == null) {
            if (other.stringData != null)
                return false;
        } else if (!stringData.equals(other.stringData))
            return false;
        if (timeData == null) {
            if (other.timeData != null)
                return false;
        } else if (!timeData.equals(other.timeData))
            return false;
        if (Double.doubleToLongBits(doubleData) != Double.doubleToLongBits(other.doubleData))
            return false;
        if (timeZoneData == null) {
            if (other.timeZoneData != null)
                return false;
        } else if (!timeZoneData.equals(other.timeZoneData))
            return false;
        return true;
    }
}
