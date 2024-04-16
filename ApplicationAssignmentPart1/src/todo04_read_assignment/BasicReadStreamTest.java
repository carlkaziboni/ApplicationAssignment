package todo04_read_assignment;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BasicReadStreamTest {
    @Test
    public void testRead()
    {
        List<String> linesExpected = new ArrayList<>();
        linesExpected.add("name	Designing a Worksheet for Beginners (formative)");
        linesExpected.add("course	Inf1B");
        linesExpected.add("start	2024-02-05T12:00:00.0Z[Europe/London]");
        linesExpected.add("end	2024-02-15T12:00:00.0Z[Europe/London]");
        linesExpected.add("hours	14");
        try (InputStream file = new FileInputStream("ApplicationAssignmentPart1\\input\\AssignmentInf1B2.1Worksheet.tsv")) {
            List<String> linesActual = BasicReadStream.read(file);
            Assert.assertEquals(linesExpected, linesActual);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
