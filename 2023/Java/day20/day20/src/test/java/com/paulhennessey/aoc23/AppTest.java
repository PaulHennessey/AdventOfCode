package com.paulhennessey.aoc23;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class AppTest 
{
    Headquarters headquarters;
    List<String> input;
    
    @Test
    void testApp() throws IOException 
    {
        input = Files.readAllLines(Paths.get("src/test/java/com/paulhennessey/aoc23/input1.txt"));
        headquarters = new Headquarters(input);
        headquarters.pushButton();
        assertEquals(1, headquarters.countPulses());
    }
}
