package com.paulhennessey.aoc2015.day6;

import java.awt.Point;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public final class App 
{
    static Path path = Paths.get("src/test/java/com/paulhennessey/aoc2015/day6/input.txt");

    boolean[][] grid = new boolean[1000][1000];
    Point firstPoint = new Point();
    Point secondPoint = new Point();

    public App() 
    {}

    private void setPoints(String firstCoordinate, String secondCoordinate)
    {
        String[] coordArray = firstCoordinate.split(",");
        firstPoint.x = Integer.parseInt(coordArray[0]);
        firstPoint.y = Integer.parseInt(coordArray[1]);

        coordArray = secondCoordinate.split(",");
        secondPoint.x = Integer.parseInt(coordArray[0]);
        secondPoint.y = Integer.parseInt(coordArray[1]);
    }

    private void toggle()
    {
        for(int x = firstPoint.x; x <= secondPoint.x; x++)
        {
            for(int y = firstPoint.y; y <= secondPoint.y; y++)
            {
                grid[x][y] = grid[x][y] == true ? false : true;
            }
        }
    }

    private void turnOn()
    {
        for(int x = firstPoint.x; x <= secondPoint.x; x++)
        {
            for(int y = firstPoint.y; y <= secondPoint.y; y++)
            {
                grid[x][y] = true;
            }
        }
    }

    private void turnOff()
    {
        for(int x = firstPoint.x; x <= secondPoint.x; x++)
        {
            for(int y = firstPoint.y; y <= secondPoint.y; y++)
            {
                grid[x][y] = false;
            }
        }
    }

    
    public void processInstructions() throws IOException
    {
        List<String> input = Files.readAllLines(path);

        for(String line : input)
        {
            processInstruction(line);
        }
    }

    public void processInstruction (String instruction)
    {
        String[] parts = instruction.trim().split(" ");
        if(parts[0].equals("toggle"))
        {
            setPoints(parts[1], parts[3]);
            toggle();
        }
        else if(parts[1].equals("on"))
        {
            setPoints(parts[2], parts[4]);
            turnOn();
        }
        else
        {
            setPoints(parts[2], parts[4]);
            turnOff();
        }        
    }

    public int countLitLights()
    {
        int count = 0;
        
        for(int i = 0; i < 1000; i++)
        {
            for(int j = 0; j < 1000; j++)
            {
                count = grid[i][j] == true ? count + 1 : count;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException 
    {
        App app = new App();
        app.processInstructions();
        System.out.println("Hello World!");
    }
}
