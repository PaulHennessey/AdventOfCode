package com.paulhennessey.aoc2015.day18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import junit.framework.TestCase;

public class AppTest
        extends TestCase {
    App app;
    List<String> input;

    public AppTest(String testName) {
        super(testName);
    }

    public void testApp1() throws IOException {
        input = Files.readAllLines(Paths.get("src/test/java/com/paulhennessey/aoc2015/day18/input.txt"));
        app = new App(input);
        app.runSimulation(100);
        assertEquals(781, app.countOnLights());
    }
}
