package todo03_read_config;

import java.time.ZoneId;
import java.lang.Object;

public class LineContent {
    private final String title;
    private final String stringData;
    private final ZoneId timeZoneData;

    public LineContent(String title, String stringData)
    {
        this.title = title;
        this.stringData = stringData;
        this.timeZoneData = null;
    }

    public LineContent(String title, ZoneId timeZoneData) {
        this.title = title;
        this.stringData = null;
        this.timeZoneData = timeZoneData;
    }

    public String getTitle() {
        return title;
    }

    public String getStringData() {
        return stringData;
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
        if (timeZoneData == null) {
            if (other.timeZoneData != null)
                return false;
        } else if (!timeZoneData.equals(other.timeZoneData))
            return false;
        return true;
    }
}
