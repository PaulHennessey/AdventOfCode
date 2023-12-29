package com.paulhennessey.aoc2015.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;

public class Building 
{
    static Path path = Paths.get("./day1/src/test/java/com/paulhennessey/aoc2015/day1/input.txt");
 
    public Building()
    {}

    public int getFloor(char[] input)
    {
        int floor = 0;

        for(int i = 0; i < input.length; i++)
        {
            floor += moveBetweenFloors(input[i]);
        }

        return floor;
    }

    public int getBasement(char[] input)
    {
        int floor = 0, basement = 0;

        for(int i = 0; i < input.length; i++)
        {
            floor += moveBetweenFloors(input[i]);

            if(floor == -1)
            {
                basement = i+1;
                break;
            }
        }
        return basement;
    }

    private int moveBetweenFloors(char c)
    {
        if(c == '(')
        {
            return 1;
        }
        
        return -1;
    }

    public static void main(String[] args) throws IOException
    {
        Building app = new Building();
        char[] input = Files.readAllLines(path).get(0).toCharArray();
        
        Instant start = Instant.now();
        app.getFloor(input);       
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);

        System.out.println("Elapsed time: " + timeElapsed.toNanos() + "ns");

        start = Instant.now();
        app.getBasement(input);       
        end = Instant.now();
        timeElapsed = Duration.between(start, end);

        System.out.println("Elapsed time: " + timeElapsed.toNanos() + "ns");
    }
}
