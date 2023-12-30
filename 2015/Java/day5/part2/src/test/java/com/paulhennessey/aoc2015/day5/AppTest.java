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
        assertEquals(true, app.containsDoublePair("xyxy"));
    }

    @Test
    void testApp2() 
    {        
        assertEquals(true, app.containsDoublePair("aabcdefgaa"));
    }

    @Test
    void testApp3() 
    {        
        assertEquals(false, app.containsDoublePair("aaa"));
    }

    @Test
    void testApp4() 
    {        
        assertEquals(true, app.containsTriplet("xyx"));
    }

    @Test
    void testApp5() 
    {        
        assertEquals(true, app.containsTriplet("abcdefeghi"));
    }

    @Test
    void testApp6() 
    {        
        assertEquals(true, app.containsTriplet("aaa"));
    }

    @Test
    void testApp7() 
    {        
        assertEquals(true, app.stringIsNice("qjhvhtzxzqqjkmpb"));
    }        

    @Test
    void testApp8() 
    {        
        assertEquals(true, app.stringIsNice("xxyxx"));
    }        

    @Test
    void testApp9() 
    {        
        assertEquals(false, app.stringIsNice("uurcxstgmygtbstg"));
    }        

    @Test
    void testApp10() 
    {        
        assertEquals(false, app.stringIsNice("ieodomkazucvgmuy"));
    }        

    @Test
    void testApp12() throws IOException 
    {
        List<String> input = Files.readAllLines(path);                
        assertEquals(69, app.countNiceStrings(input));
    }        

    
}
