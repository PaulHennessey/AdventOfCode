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
        assertFalse(app.containsDisallowedSubstrings("ugknbfddgicrmopn"));
    }

    @Test
    void testApp2()
    {
        assertTrue(app.containsDisallowedSubstrings("ugknbfabddgicrmopn"));
    }

    @Test
    void testApp3()
    {
        //assertEquals(false, app.containsConsecutiveCharacters("ugknbfbdagicrmopn"));
        assertFalse(app.containsConsecutiveCharacters("abca"));
    }

    @Test
    void testApp4()
    {
        assertTrue(app.containsConsecutiveCharacters("ugknbfabdggicrmopn"));
    }

    @Test
    void testApp5()
    {
        assertFalse(app.containsThreeVowels("gknbfabdgicrmpn"));
    }

    @Test
    void testApp6()
    {
        assertTrue(app.containsThreeVowels("ogknbfabdgicrmpn"));
    }

    @Test
    void testApp7()
    {
        assertTrue(app.stringIsNice("ugknbfddgicrmopn"));
    }

    @Test
    void testApp8()
    {
        assertTrue(app.stringIsNice("aaa"));
    }

    @Test
    void testApp9()
    {
        assertFalse(app.stringIsNice("jchzalrnumimnmhp"));
    }

    @Test
    void testApp10()
    {
        assertFalse(app.stringIsNice("haegwjzuvuyypxyu"));
    }

    @Test
    void testApp11()
    {
        assertFalse(app.stringIsNice("dvszwmarrgswjxmb"));
    }

    @Test
    void testApp12() throws IOException
    {
        List<String> input = Files.readAllLines(path);
        assertEquals(238, app.countNiceStrings(input));
    }


}
