package com.paulhennessey.aoc2015.day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class WrapperTest 
{
     Path path = Paths.get("src/test/java/com/paulhennessey/aoc2015/day2/input.txt");
     Wrapper wrapper = new Wrapper();

    @Test
    void testApp1() 
    {
        assertEquals(58, wrapper.calculateArea("2x3x4"));
    }

    @Test
    void testApp2() 
    {
        assertEquals(43, wrapper.calculateArea("1x1x10"));
    }

    @Test
    void testApp3() throws IOException 
    {
        List<String> input = Files.readAllLines(path);
        assertEquals(1588178, wrapper.calculateTotalArea(input));
    }

    @Test
    void testApp4() 
    {
        assertEquals(34, wrapper.calculateRibbon("2x3x4"));
    }

    @Test
    void testApp5() 
    {
        assertEquals(14, wrapper.calculateRibbon("1x1x10"));
    }

    @Test
    void testApp6() throws IOException 
    {
        List<String> input = Files.readAllLines(path);
        assertEquals(3783758, wrapper.calculateTotalRibbon(input));
    }

}
