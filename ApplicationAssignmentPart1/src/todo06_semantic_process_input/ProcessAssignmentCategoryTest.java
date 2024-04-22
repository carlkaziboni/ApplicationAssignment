package todo06_semantic_process_input;

import org.junit.Assert;
import org.junit.Test;

import todo02_assignments.Assignment;
import todo05_syntax_process_input.*;
import todo04_read_assignment.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.time.ZonedDateTime;

public class ProcessAssignmentCategoryTest {
    @Test
    public void testProcessCategories() {
        List<String> linesRead = new ArrayList<>();
        try {
            linesRead = BasicReadStream.read(new FileInputStream("ApplicationAssignmentPart1\\input\\AssignmentTest.tsv"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List<SplitInput> linesReadSplit = BasicProcessInput.splitInputOnTab(linesRead);
        List<Assignment> assignmentsActual = ProcessAssignmentCategory.processCategories(linesReadSplit);
        Assignment firAssignment = new Assignment(ZonedDateTime.parse("2024-05-10T12:00:00.0Z[Europe/London]"), ZonedDateTime.parse("2024-04-29T09:00:00.0Z[Europe/London]"), 14, null, "informal start 28 March; actual assessment done during the exam period after Easter", "Inf1B");
        List<Assignment> assignmentsExpected = new ArrayList<>();
        assignmentsExpected.add(firAssignment);
        assignmentsExpected.add(firAssignment);
        Assert.assertEquals(assignmentsExpected, assignmentsActual);
    }
}
