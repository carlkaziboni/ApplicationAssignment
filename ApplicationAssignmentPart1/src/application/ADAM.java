package application;

import static todo05_syntax_process_input.BasicProcessInput.splitInputOnTab;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import application.base.ConfigFileHandler;
import todo02_assignments.Assignment;
import todo03_read_config.*;
import todo05_syntax_process_input.*;
import todo06_semantic_process_input.*;
import todo07_output.Printer;
import todo04_read_assignment.*;

public class ADAM {
    private ConfigFileHandler configFileHandler;
    public Configuration configuration;

    public ADAM(String[] args) {
        System.err.println(
                "TODO Put application initialisation code here, then remove this message");

        // TODO Remove the following messages once you read and understood them.
        for ( String message : new String[]{
                "For the avoidance of doubt:",
                "you may change all the classes in Part 1 of this assignment",
                "as much as you wish", "EXCEPT",
                "1. you MUST leave this class called ADAM",
                "2. you MUST leave this class in the directory src/application"} ) {
            System.err.println(message);
        }

        /* TODO This is just a suggestion: farm out the task of handling
                (that is reading and processing) configuration files to another
                class. This example shows the class in a sub-package so that
                there aren't too many classes in one directory when the ADAM
                application is complete. Package design is up to you.
         */
        configFileHandler = new ConfigFileHandler(args);

        // TODO Depending on your design, you might need further initialisation.
        List<String> fileLinesRead = new ArrayList<>();
        for (String file : args) {
            List<String> temp = BasicReadFile.read(file);
            Iterator<String> tempIterator = temp.iterator();
            while (tempIterator.hasNext()) {
                fileLinesRead.add(tempIterator.next());
            } 
        }

        if (fileLinesRead.isEmpty()) {
            fileLinesRead = BasicReadFile.read("ApplicationAssignmentPart1\\input\\defaultConfig.tsv");
        }

        List<SplitInput> fileLinesSplit = splitInputOnTab(fileLinesRead);

        configuration = ProcessConfigCategory.processCategories(fileLinesSplit);

        /* TODO If you wish, make the call to run() explicit in the calling
                code in main(). This means any class instantiating an ADAM
                object would have to call run(). This would give them the chance
                to do things between instantiating the ADAM object and running
                it. If you want instantiating an ADAM to automatically run it,
                then you can make run() private.
         */
        run();
    }

    public void run() {
        /* TODO Once initialisation is complete (and successful) then
                run the main part of ADAM.
         */
        List<String> inputRead = BasicReadStream.read(System.in);

        List<SplitInput> inputSplit = BasicProcessInput.splitInputOnTab(inputRead);

        List<Assignment> assignments = ProcessAssignmentCategory.processCategories(inputSplit);

        Iterator<Assignment> assignmentsIterator = assignments.iterator();

        while (assignmentsIterator.hasNext()) {
            Assignment temp = assignmentsIterator.next();
            Printer.printWorkload(temp, configuration);
        }
        /* TODO Try to make the final version of this method look like
                an ordered "TO DO" list so most, maybe all, lines are
                just calling the next command needed.
                Depending on your design, you might need to use class fields,
                you might need to pass parameters between methods, or you
                might adopt a functional-esque style and nest some method
                calls.
         */
    }

    public static void main(String[] args) {
        // EITHER: you want an ADAM to automatically run:
        new ADAM(args.clone());
        // OR you want to run an ADAM explicitly:
        /*
        ADAM adamApp = new ADAM(args.clone());
        // Do things between initialisation and running
        adamApp.run();
        */
    }
}
