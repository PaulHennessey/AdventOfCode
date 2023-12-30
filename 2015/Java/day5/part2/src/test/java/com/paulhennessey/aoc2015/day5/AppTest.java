package com.paulhennessey.aoc2015.day5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(false, app.containsDisallowedSubstrings("ugknbfddgicrmopn"));
    }

    @Test
    void testApp2() 
    {        
        assertEquals(true, app.containsDisallowedSubstrings("ugknbfabddgicrmopn"));
    }    

    @Test
    void testApp3() 
    {   
        //assertEquals(false, app.containsConsecutiveCharacters("ugknbfbdagicrmopn"));     
        assertEquals(false, app.containsConsecutiveCharacters("abca"));
    }        

    @Test
    void testApp4() 
    {        
        assertEquals(true, app.containsConsecutiveCharacters("ugknbfabdggicrmopn"));
    }            

    @Test
    void testApp5() 
    {        
        assertEquals(false, app.containsThreeVowels("gknbfabdgicrmpn"));
    }        

    @Test
    void testApp6() 
    {        
        assertEquals(true, app.containsThreeVowels("ogknbfabdgicrmpn"));
    }        

    @Test
    void testApp7() 
    {        
        assertEquals(true, app.stringIsNice("ugknbfddgicrmopn"));
    }        

    @Test
    void testApp8() 
    {        
        assertEquals(true, app.stringIsNice("aaa"));
    }        

    @Test
    void testApp9() 
    {        
        assertEquals(false, app.stringIsNice("jchzalrnumimnmhp"));
    }        

    @Test
    void testApp10() 
    {        
        assertEquals(false, app.stringIsNice("haegwjzuvuyypxyu"));
    }        

    @Test
    void testApp11() 
    {        
        assertEquals(false, app.stringIsNice("dvszwmarrgswjxmb"));
    }        

    @Test
    void testApp12() throws IOException 
    {
        List<String> input = Files.readAllLines(path);                
        assertEquals(238, app.countNiceStrings(input));
    }        

    
}
