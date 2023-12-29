package com.paulhennessey.aoc2015.day3;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class Grid 
{ 
    static Path path = Paths.get("src/test/java/com/paulhennessey/aoc2015/day3/input.txt");

    private List<Location> santaLocations = new ArrayList<>();
    private Map<String, Integer> housesVisited = new HashMap<>();
    private int currentSanta = 0;

    public Grid(List<Location> locations)    
    {
        for(Location location : locations)
        {
            santaLocations.add(location);
            housesVisited.merge(location.toString(), 1, (v1, v2) -> v1 + v2);
        }
    }

    public void processInput(char[] input)
    {
        for(char c : input)
        {
            Location santa = santaLocations.get(currentSanta);

            switch (c) 
            {
                case '^' -> moveUp(santa);
                case 'v' -> moveDown(santa);
                case '>' -> moveRight(santa);
                case '<' -> moveLeft(santa);
            }

            incrementCurrentSanta();
        }
    }

    public int getHouseCount()
    {
        return housesVisited.size();
    }

    private void incrementCurrentSanta()
    {
        if(currentSanta + 1 < santaLocations.size())
        {
            currentSanta++;
        }
        else
        {
            currentSanta = 0;
        }
    }

    private void moveUp(Location santa)
    {
        santa.incrementY();
        updateHousesVisited(santa);
    }

    private void moveDown(Location santa)
    {
        santa.decrementY();
        updateHousesVisited(santa);
    }

    private void moveRight(Location santa)
    {
        santa.incrementX();
        updateHousesVisited(santa);
    }

    private void moveLeft(Location santa)
    {
        santa.decrementX();
        updateHousesVisited(santa);
    }

    private void updateHousesVisited(Location santa)
    {
        housesVisited.merge(santa.toString(), 1, (v1, v2) -> v1 + v2);
    }

    public static void main(String[] args) throws IOException 
    {
        List<Location> list = new ArrayList<Location>();
        list.add(new Location(0, 0));
        Grid grid = new Grid(list);

        char[] input = Files.readAllLines(path).get(0).toCharArray();
        
        Instant start = Instant.now();
        grid.processInput(input);
        int count = grid.getHouseCount();
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);

        System.out.println("Houses visited: " + count + " Time: " + duration.toMillis() + "ms");
    }
}
