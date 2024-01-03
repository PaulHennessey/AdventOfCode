package com.paulhennessey.aoc2015.day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public final class App 
{
    static Path path = Paths.get("src/test/java/com/paulhennessey/aoc2015/day6/input.txt");

    //Light[] grid = new Light[1000000];
    List<Light> grid = new ArrayList<>();
    List<Location> locations = new ArrayList<>();
    int width = 1000, height = 1000;

    public App() 
    {
        grid = Arrays.asList(new Light[1000000]);
    }

    private void setLocations(String bottomLeftCoordinate, String topRightCoordinate)
    {
        String[] coordArray = bottomLeftCoordinate.split(",");
        int bottomLeftX = Integer.parseInt(coordArray[0]);
        int bottomLeftY = Integer.parseInt(coordArray[1]);

        coordArray = topRightCoordinate.split(",");
        int topRightX = Integer.parseInt(coordArray[0]);
        int topRightY = Integer.parseInt(coordArray[1]);

        for(int x = bottomLeftX; x <= topRightX; x++)
        {
            for(int y = bottomLeftY; y <= topRightY; y++)
            {
                locations.add(new Location(x, y, width));
            }
        }
    }

    private void toggle()
    {
        List<Integer> ids  = locations.stream()                                    
                                      .map(location -> location.convertToIndex())
                                      .collect(Collectors.toList());

        IntStream.range(0, grid.size())
                 .filter(i -> ids.contains(i))
                 .mapToObj(i -> grid.get(i))
                 .forEach(i -> i.toggle());
    }

    private void turnOn()
    {        
        List<Integer> ids  = locations.stream()                                    
                                      .map(location -> location.convertToIndex())
                                      .collect(Collectors.toList());

        IntStream.range(0, grid.size())
                 .filter(i -> ids.contains(i))
                 .mapToObj(i -> grid.get(i))
                 .forEach(i -> i.turnOn());

    }

    private void turnOff()
    {
        List<Integer> ids  = locations.stream()                                    
                                      .map(location -> location.convertToIndex())
                                      .collect(Collectors.toList());

        IntStream.range(0, grid.size())
                 .filter(i -> ids.contains(i))
                 .mapToObj(i -> grid.get(i))
                 .forEach(i -> i.turnOff());
    }

    
    public void processInstructions() throws IOException
    {
        List<String> input = Files.readAllLines(path);
        input.stream()
             .forEach(line -> processInstruction(line));
    }

    public void processInstruction (String instruction)
    {
        String[] parts = instruction.trim().split(" ");
        if(parts[0].equals("toggle"))
        {
            setLocations(parts[1], parts[3]);
            toggle();
        }
        else if(parts[1].equals("on"))
        {
            setLocations(parts[2], parts[4]);
            turnOn();
        }
        else
        {
            setLocations(parts[2], parts[4]);
            turnOff();
        }        
        locations.clear();
    }

    public int totalBrightness()
    {
        AtomicInteger brightness = new AtomicInteger(0);
        //int brightness = 0;
        
        grid.stream().forEach(light -> brightness.getAndIncrement());

        // for(int i = 0; i < 1000000; i++)
        // {
        //     brightness += grid[i].Brightness;
        // }

        return brightness.get();
    }

    public static void main(String[] args) throws IOException 
    {
        Instant start = Instant.now();        
        App app = new App();
        app.processInstructions();
        Instant end = Instant.now();
        
        System.out.println("Duration: " + Duration.between(start, end).toMillis() + "ms");
    }
}
