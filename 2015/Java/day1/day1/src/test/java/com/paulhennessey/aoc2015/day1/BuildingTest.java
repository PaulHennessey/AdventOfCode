package com.paulhennessey.aoc2015.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class BuildingTest 
{
    Path path = Paths.get("src/test/java/com/paulhennessey/aoc2015/day1/input.txt");
    Building app = new Building();
    
    @Test
    void testApp1() throws IOException
    {   
        char[] input = Files.readAllLines(path).get(0).toCharArray();
        assertEquals(232, app.getFloor(input));
    }

    @Test
    void testApp2()
    {
        assertEquals(0, app.getFloor("(())".toCharArray()));
    }    

    @Test
    void testApp3()
    {
        assertEquals(3, app.getFloor("))(((((".toCharArray()));
    }    
    
    @Test
    void testApp4()
    {
        assertEquals(-3, app.getFloor(")())())".toCharArray()));
    }    

    @Test
    void testApp5()
    {
        assertEquals(1, app.getBasement(")".toCharArray()));
    }        

    @Test
    void testApp6()
    {
        assertEquals(5, app.getBasement("()())".toCharArray()));
    }        

    @Test
    void testApp7() throws IOException 
    {
        char[] input = Files.readAllLines(path).get(0).toCharArray();
        assertEquals(1783, app.getBasement(input));
    }
}
