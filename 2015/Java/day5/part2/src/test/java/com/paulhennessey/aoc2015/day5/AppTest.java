package com.paulhennessey.aoc2015.day5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class AppTest
{
    Path path = Paths.get("src/test/java/com/paulhennessey/aoc2015/day5/input.txt");

    App app = new App();

    @Test
    void testApp1()
    {
        assertTrue(app.containsDoublePair("xyxy"));
    }

    @Test
    void testApp2()
    {
        assertTrue(app.containsDoublePair("aabcdefgaa"));
    }

    @Test
    void testApp3()
    {
        assertFalse(app.containsDoublePair("aaa"));
    }

    @Test
    void testApp4()
    {
        assertTrue(app.containsTriplet("xyx"));
    }

    @Test
    void testApp5()
    {
        assertTrue(app.containsTriplet("abcdefeghi"));
    }

    @Test
    void testApp6()
    {
        assertTrue(app.containsTriplet("aaa"));
    }

    @Test
    void testApp7()
    {
        assertTrue(app.stringIsNice("qjhvhtzxzqqjkmpb"));
    }

    @Test
    void testApp8()
    {
        assertTrue(app.stringIsNice("xxyxx"));
    }

    @Test
    void testApp9()
    {
        assertFalse(app.stringIsNice("uurcxstgmygtbstg"));
    }

    @Test
    void testApp10()
    {
        assertFalse(app.stringIsNice("ieodomkazucvgmuy"));
    }

    @Test
    void testApp12() throws IOException
    {
        List<String> input = Files.readAllLines(path);
        assertEquals(69, app.countNiceStrings(input));
    }


}
