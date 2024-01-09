package com.paulhennessey.aoc2015.day10;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    public App() 
    {}

    public int forty(String input)
    {
        for(int i = 0; i < 40; i++)
        {
            input = lookAndSay(input);
        }

        return input.length();
    }

    public int fifty(String input)
    {
        for(int i = 0; i < 50; i++)
        {
            input = lookAndSay(input);
        }

        return input.length();
    }

    public String lookAndSay(String input)
    {
        List<List<Character>> inputMatrix = new ArrayList<>();

        List<Character> row = new ArrayList<>();
        inputMatrix.add(row);
        row.add(input.charAt(0));

        for(int i = 1; i < input.length(); i++)
        {
            if(input.charAt(i) != input.charAt(i-1))
            {
                row = new ArrayList<>();
                inputMatrix.add(row);
            }
            row.add(input.charAt(i));
        }

        return buildString(inputMatrix);
    }

    private String buildString(List<List<Character>> inputMatrix)
    {
        StringBuilder sb = new StringBuilder();
        for(List<Character> row : inputMatrix)
        {
            String count = Integer.toString(row.size());
            String value = String.valueOf(row.get(0));
            sb.append(count);
            sb.append(value);
        }

        return sb.toString();
    }
}
