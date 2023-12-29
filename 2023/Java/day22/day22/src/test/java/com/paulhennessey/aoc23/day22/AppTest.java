package com.paulhennessey.aoc23.day22;

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
    void testApp() throws IOException 
    {
        input = Files.readAllLines(Paths.get("src/test/java/com/paulhennessey/aoc23/day22/input.txt"));
        app = new App(input);
        app.dropBricks();
        assertEquals(5, app.countBricks());
    }
}
