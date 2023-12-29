package com.paulhennessey.aoc2015.day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.ArrayList;

class GridTest 
{
    Path path = Paths.get("src/test/java/com/paulhennessey/aoc2015/day3/input.txt");
    

    @Test
    void testApp1() 
    {
        // Arrange
        List<Location> list = new ArrayList<Location>();
        list.add(new Location(0, 0));
        Grid grid = new Grid(list);

        // Act
        char[] input = ">".toCharArray();
        grid.processInput(input);

        // Assert
        assertEquals(2, grid.getHouseCount());
    }

    @Test
    void testApp2() 
    {
        // Arrange
        List<Location> list = new ArrayList<Location>();
        list.add(new Location(0, 0));
        Grid grid = new Grid(list);

        // Act
        char[] input = "^>v<".toCharArray();
        grid.processInput(input);

        // Assert
        assertEquals(4, grid.getHouseCount());
    }

    @Test
    void testApp3() 
    {
        // Arrange
        List<Location> list = new ArrayList<Location>();
        list.add(new Location(0, 0));
        Grid grid = new Grid(list);

        // Act
        char[] input = "^v^v^v^v^v".toCharArray();
        grid.processInput(input);

        // Assert
        assertEquals(2, grid.getHouseCount());
    }

    @Test
    void testApp4() throws IOException 
    {
        // Arrange
        List<Location> list = new ArrayList<Location>();
        list.add(new Location(0, 0));
        Grid grid = new Grid(list);

        // Act
        char[] input = Files.readAllLines(path).get(0).toCharArray();
        grid.processInput(input);

        // Assert
        assertEquals(2572, grid.getHouseCount());
    }

    @Test
    void testApp5() 
    {
        // Arrange
        List<Location> list = new ArrayList<Location>();
        list.add(new Location(0, 0));
        list.add(new Location(0, 0));
        Grid grid = new Grid(list);

        // Act
        char[] input = "^v".toCharArray();
        grid.processInput(input);

        // Assert
        assertEquals(3, grid.getHouseCount());
    }

    @Test
    void testApp6() 
    {
        // Arrange
        List<Location> list = new ArrayList<Location>();
        list.add(new Location(0, 0));
        list.add(new Location(0, 0));
        Grid grid = new Grid(list);

        // Act
        char[] input = "^>v<".toCharArray();
        grid.processInput(input);

        // Assert
        assertEquals(3, grid.getHouseCount());        
    }    

    @Test
    void testApp7() 
    {
        // Arrange
        List<Location> list = new ArrayList<Location>();
        list.add(new Location(0, 0));
        list.add(new Location(0, 0));
        Grid grid = new Grid(list);

        // Act
        char[] input = "^v^v^v^v^v".toCharArray();
        grid.processInput(input);

        // Assert
        assertEquals(11, grid.getHouseCount());        
    }    

    @Test
    void testApp8() throws IOException 
    {
        // Arrange
        List<Location> list = new ArrayList<Location>();
        list.add(new Location(0, 0));
        list.add(new Location(0, 0));
        Grid grid = new Grid(list);

        // Act
        char[] input = Files.readAllLines(path).get(0).toCharArray();
        grid.processInput(input);

        // Assert
        assertEquals(2631, grid.getHouseCount());        
    }

}
