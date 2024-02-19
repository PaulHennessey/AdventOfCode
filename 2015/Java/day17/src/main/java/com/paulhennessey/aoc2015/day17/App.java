package com.paulhennessey.aoc2015.day17;

import java.util.List;
import java.util.stream.Collectors;
import org.paukov.combinatorics3.Generator;

public class App {
    private List<List<Integer>> getCombinations(int volume, List<Integer> containers) {
        return Generator.combination(containers)
                .simple(volume)
                .stream()
                .collect(Collectors.toList());
    }

    private int getSum(List<Integer> list) {
        return list
                .stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }

    public int getCountPart(int eggNogVolume, List<Integer> containerVolumes, boolean isPartTwo) {
        int containersRequired = 0;

        for (int containerCount = 1; containerCount <= containerVolumes.size(); containerCount++) {
            for (List<Integer> combination : getCombinations(containerCount, containerVolumes)) {
                containersRequired = getSum(combination) == eggNogVolume ? containersRequired + 1 : containersRequired;
            }

            if (isPartTwo && containersRequired > 0)
                break;
        }

        return containersRequired;
    }
}
