package com.paulhennessey.aoc2015.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class App {
    List<Sue> Sues = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public int getNumberPartOne(Map<String, Integer> tickerTape) {
        AtomicInteger number = new AtomicInteger();

        Sues.forEach(
                sue ->
                {
                    if (sue.isPossiblePartOne(tickerTape)) {
                        number.set(sue.getNumber());
                    }
                }
        );

        return number.get();
    }

    public int getNumberPartTwo(Map<String, Integer> tickerTape) {
        AtomicInteger number = new AtomicInteger();

        Sues.forEach(
                sue ->
                {
                    if (sue.isPossiblePartTwo(tickerTape)) {
                        number.set(sue.getNumber());
                    }
                }
        );

        return number.get();
    }

    public void parseInput(List<String> input) {
        input.forEach(this::parseLine);
    }

    private void parseLine(String line) {
        String[] parts1 = line.split(": ", 2);
        int number = parseNumber(parts1[0]);

        Map<String, Integer> map = parseMap(parts1[1]);
        Sues.add(new Sue(number, map));
    }

    private int parseNumber(String part) {
        String[] parts2 = part.split(" ");
        return Integer.parseInt(parts2[1]);
    }

    private Map<String, Integer> parseMap(String part) {
        Map<String, Integer> map = new HashMap<>();
        String[] parts3 = part.split(", ");

        Arrays.stream(parts3).forEach(str ->
        {
            String[] parts4 = str.split(": ");
            map.put(parts4[0], Integer.parseInt(parts4[1]));
        });

        return map;
    }

}
