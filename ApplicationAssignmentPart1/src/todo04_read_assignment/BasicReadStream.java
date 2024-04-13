package todo04_read_assignment;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class BasicReadStream {
    private BasicReadStream() {}

    public static List<String> read(InputStream stream) {
        // Notice the apparent type on the left and the actual type on the right
        List<String> lines = new ArrayList<>();

        // TODO Use a BufferedReader to open the stream

        // TODO Use a try-with-resources statement
        // TODO Loop reading one line at a time until there are no more lines
        // TODO Append each line read to lines

        // It is safe to return lines because it is a local variable
        return lines;
    }
}
