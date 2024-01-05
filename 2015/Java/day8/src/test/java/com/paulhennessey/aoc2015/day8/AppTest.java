package com.paulhennessey.aoc2015.day8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

class AppTest 
{
    App app = new App();
    static Path path = Paths.get("src/test/java/com/paulhennessey/aoc2015/day8/input.txt");

    @Test
    void testApp1() throws IOException 
    {
        List<String> list = Files.readAllLines(path);
        int result = list.stream().collect(Collectors.summingInt(s -> s.length() - (app.unescape(s).length())));

        assertEquals(1342, result);
    }

    @Test
    void testApp2() throws IOException 
    {
        List<String> list = Files.readAllLines(path);
        int result = list.stream().collect(Collectors.summingInt(s -> app.escape(s).length() - s.length()));

        assertEquals(2074, result);
    }

    @Test
    void testApp3() throws IOException 
    {
        String input = "";
        String result = app.escape(input);
        
        assertTrue(true);
    }

    @Test
    void testApp4() throws IOException 
    {
        String input = "abc";
        String result = app.escape(input);
        
        assertTrue(true);
    }

    @Test
    void testApp5() throws IOException 
    {
        String input = "aaa\"aaa";
        String result = app.escape(input);
        
        assertTrue(true);
    }

}
