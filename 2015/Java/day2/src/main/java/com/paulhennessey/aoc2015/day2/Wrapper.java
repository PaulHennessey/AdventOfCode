package com.paulhennessey.aoc2015.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Wrapper
{
    static Path path = Paths.get("src/test/java/com/paulhennessey/aoc2015/day2/input.txt");

    public Wrapper()
    {}

    public static void main(String[] args) throws IOException
    {
        Wrapper wrapper = new Wrapper();
        List<String> input = Files.readAllLines(path);

        Instant start = Instant.now();
        int area = wrapper.calculateTotalArea(input);
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);

        System.out.println("Area: " + area + " Time: " + duration.toMillis() + "ms");

        start = Instant.now();
        int ribbon = wrapper.calculateTotalRibbon(input);
        end = Instant.now();
        duration = Duration.between(start, end);

        System.out.println("Ribbon: " + ribbon + " Time: " + duration.toMillis() + "ms");
    }



    public int calculateArea(String input)
    {
        List<Integer> sides = parseInput(input);

        return (3 * sides.get(0) * sides.get(1)) +
               (2 * sides.get(1) * sides.get(2)) +
               (2 * sides.get(2) * sides.get(0));
    }


    public int calculateTotalArea(List<String> input)
    {
        return input
            .stream()
            .mapToInt(this::calculateArea)
            .sum();
    }


    public int calculateRibbon(String input)
    {
        List<Integer> sides = parseInput(input);

        int ribbon = sides.get(0) + sides.get(0) + sides.get(1) + sides.get(1);
        int bow = sides.get(0) * sides.get(1) * sides.get(2);

        return ribbon + bow;
    }


    public int calculateTotalRibbon(List<String> input)
    {
        return input
            .stream()
            .mapToInt(this::calculateRibbon)
            .sum();
    }

    private List<Integer> parseInput(String input)
    {
        String[] dimensions = input.split("x");

        List<Integer> sides = new ArrayList<>();
        sides.add(Integer.parseInt(dimensions[0]));
        sides.add(Integer.parseInt(dimensions[1]));
        sides.add(Integer.parseInt(dimensions[2]));

        Collections.sort(sides);

        return sides;
    }

}
