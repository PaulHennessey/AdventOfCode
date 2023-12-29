package com.paulhennessey.aoc.day21;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class AppTest 
{
    App app;
    List<String> input;
    
    @Test
    void testApp1() throws IOException 
    {
        input = Files.readAllLines(Paths.get("src/test/java/com/paulhennessey/aoc/day21/input.txt"));
        app = new App(input);
        app.runSimulation(6);
        app.showGrid();
        assertEquals(16, app.countPlots());
    }

    @Test
    void testApp2() throws IOException 
    {
        input = Files.readAllLines(Paths.get("src/test/java/com/paulhennessey/aoc/day21/biginput.txt"));
        app = new App(input);
        app.runSimulation(64);
        app.showGrid();
        assertEquals(3764, app.countPlots());
    }    
}
