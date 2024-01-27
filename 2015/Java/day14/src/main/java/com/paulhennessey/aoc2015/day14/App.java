package com.paulhennessey.aoc2015.day14;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;

public class App
{
    public HashMap<String, Reindeer> ReindeerMap = new HashMap<String, Reindeer>();

    public App()
    {}

    public void parseInput(List<String> input)
    {
        input
            .forEach(this::parseLine);
    }

    private void parseLine(String line)
    {
        String[] parts = line.split(" ");
        String name = parts[0];
        int speed = Integer.parseInt(parts[3]);
        int duration = Integer.parseInt(parts[6]);
        int rest = Integer.parseInt(parts[13]);
        ReindeerMap.put(name, new Reindeer(name, speed, duration, rest));
    }

    public void runRace(int time)
    {
        IntStream.rangeClosed(1, time)
            .forEach(i -> {calculatePositions(i); awardPoints();});
    }

    private void calculatePositions(int second)
    {
        ReindeerMap
            .values()
            .forEach(r -> r.calculateCurrentPosition(second));
    }

    public int getResult(Function<Reindeer, Integer> func)
    {
        return ReindeerMap
            .values()
            .stream()
            .mapToInt(func::apply)  // returns stream of ints
            .max()                  // terminal operation that returns Optional instance
            .getAsInt();
    }

    public void awardPoints()
    {
        final int[] biggestDistance = {Integer.MIN_VALUE};
        List<String> leadingReindeer = new ArrayList<>();

        ReindeerMap
            .values()
            .forEach(reindeer ->
                {
                    if(reindeer.DistanceTravelled > biggestDistance[0])
                    {
                        biggestDistance[0] = reindeer.DistanceTravelled;
                        leadingReindeer.clear();
                        leadingReindeer.add(reindeer.Name);
                    }
                    else if(reindeer.DistanceTravelled == biggestDistance[0])
                    {
                        leadingReindeer.add(reindeer.Name);
                    }
                });


        leadingReindeer
            .forEach(name -> ReindeerMap.get(name).Points++);

    }
}
