package com.paulhennessey.aoc2015.day5;

import java.io.Console;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class App
{
    public App()
    {}

    private boolean processRegex(String regex, String input)
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    public boolean containsDoublePair(String s)
    {
        return processRegex("(..).*\\1", s);
    }

    public boolean containsTriplet(String s)
    {
        return processRegex("(.).\\1", s);
    }

    public boolean stringIsNice(String s)
    {
        return containsDoublePair(s) && containsTriplet(s);
    }

    public int countNiceStrings(List<String> input)
    {
        AtomicInteger count = new AtomicInteger();

        input.forEach(line ->
        {
            if(stringIsNice(line))
            {
                count.getAndIncrement();
            }
        });

        return count.get();
    }

    public static void main(String[] args){
        Console console = System.console();
        if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }
        while (true) {

            Pattern pattern =
            Pattern.compile(console.readLine("%nEnter your regex: "));

            Matcher matcher =
            pattern.matcher(console.readLine("Enter input string to search: "));

            boolean found = false;
            while (matcher.find()) {
                console.format("I found the text" +
                    " \"%s\" starting at " +
                    "index %d and ending at index %d.%n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());
                found = true;
            }
            if(!found){
                console.format("No match found.%n");
            }
        }
    }
}
