package com.paulhennessey.aoc2015.day16;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Sue {
    private final int Number;
    private Map<String, Integer> Compounds = new HashMap<String, Integer>();

    public Sue(int number, Map<String, Integer> compounds) {
        Number = number;
        Compounds = compounds;
    }

    public int getNumber() {
        return this.Number;
    }

    public boolean isPossiblePartOne(Map<String, Integer> tickerTape) {
        AtomicBoolean possible = new AtomicBoolean(true);

        tickerTape.entrySet().forEach(
                input ->
                {
                    String key = input.getKey();
                    int value = input.getValue();
                    if (Compounds.containsKey(key) && Compounds.get(key) != value) {
                        possible.set(false);
                    }
                }
        );

        return possible.get();
    }

    public boolean isPossiblePartTwo(Map<String, Integer> tickerTape) {
        AtomicBoolean possible = new AtomicBoolean(true);

        tickerTape.entrySet().forEach(
                input ->
                {
                    String key = input.getKey();
                    int value = input.getValue();
                    if (key == "cats" || key == "trees") {
                        if (Compounds.containsKey(key) && Compounds.get(key) <= value) {
                            possible.set(false);
                        }
                    } else if (key == "pomeranians" || key == "goldfish") {
                        if (Compounds.containsKey(key) && Compounds.get(key) >= value) {
                            possible.set(false);
                        }
                    } else {
                        if (Compounds.containsKey(key) && Compounds.get(key) != value) {
                            possible.set(false);
                        }
                    }
                }
        );

        return possible.get();
    }
}
