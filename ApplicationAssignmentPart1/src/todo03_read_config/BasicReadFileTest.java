package todo03_read_config;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import java.time.ZoneId;

public class BasicReadFileTest {

    @Test
    public void testSummaryView() {
        LineContent summary = new LineContent("output", "summary");
        List<LineContent> summaryViewExpected = new ArrayList<>();
        summaryViewExpected.add(summary);
        List<LineContent> summaryViewActual = BasicReadFile.getProcessedFileLines("ApplicationAssignmentPart1\\input\\summaryView.tsv");
        Assert.assertEquals(summaryViewExpected, summaryViewActual);
    }

    @Test
    public void testDefaultConfig()
    {
        LineContent timezone = new LineContent("timezone", ZoneId.of("Europe/London"));
        LineContent output = new LineContent("output", "summary");
        LineContent splash = new LineContent("splash", "show");
        List<LineContent> defaultConfig = new ArrayList<>();
        defaultConfig.add(timezone);
        defaultConfig.add(output);
        defaultConfig.add(splash);
        List<LineContent> defaultConfigActual = BasicReadFile.getProcessedFileLines("ApplicationAssignmentPart1\\input\\defaultConfig.tsv");
        Assert.assertEquals(defaultConfig, defaultConfigActual);
    }

    @Test
    public void testWeeklyView()
    {
        LineContent output = new LineContent("output", "daily");
        List<LineContent> weeklyView = new ArrayList<>();
        weeklyView.add(output);
        List<LineContent> weeklyViewActual = BasicReadFile.getProcessedFileLines("ApplicationAssignmentPart1\\input\\weeklyView.tsv");
        Assert.assertEquals(weeklyView, weeklyViewActual);
    }

    @Test
    public void testTester()
    {
        LineContent output = new LineContent("output", "summary");
        List<LineContent> tester = new ArrayList<>();
        for(int i = 0; i < 3; i++)
        {
            tester.add(output);
        }
        List<LineContent> testerActual = BasicReadFile.getProcessedFileLines("ApplicationAssignmentPart1\\input\\tester.tsv");
        Assert.assertEquals(tester, testerActual);
    }
}
