package com.advent;

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
        input = Files.readAllLines(Paths.get("src/test/java/com/advent/input.txt"));
        app = new App(input);
        assertEquals(1, 1);
    }
}

