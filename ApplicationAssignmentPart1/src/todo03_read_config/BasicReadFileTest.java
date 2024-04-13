package todo03_read_config;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class BasicReadFileTest {

    @Test
    public void testSummaryView() {
        LineContent summary = new LineContent("output", "summary");
        List<LineContent> summaryViewExpected = new ArrayList<>();
        summaryViewExpected.add(summary);
        List<LineContent> summaryViewActual = BasicReadFile.getProcessedFileLines("ApplicationAssignmentPart1\\input\\summaryView.tsv");
        boolean result = summaryViewExpected.equals(summaryViewActual);
        Assert.assertTrue(result);
    }

}
