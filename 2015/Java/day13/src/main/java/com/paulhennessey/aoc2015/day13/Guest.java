package com.paulhennessey.aoc2015.day13;

import java.util.HashMap;
import java.util.Map;

public class Guest
{
    public String Name;

    Map<String, Integer> Neighbours = new HashMap<String, Integer>();

    public Guest(String name)
    {
        Name = name;
    }

    public int happiness()
    {
        return Neighbours.values()
            .stream()
            .mapToInt(Integer::valueOf)
            .sum();
    }
}
