package com.paulhennessey.aoc2015.day5;

import java.io.Console;
import java.util.List;
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

    public boolean containsDisallowedSubstrings(String s)
    {
        return processRegex("(ab|cd|pq|xy)", s);
    }

    public boolean containsConsecutiveCharacters(String s)
    {
        return processRegex("(.)\\1", s);
    }

    public boolean containsThreeVowels(String s)
    {
        return processRegex("(.*[aeiou]){3,}", s);
    }

    public boolean stringIsNice(String s)
    {
        if(!containsDisallowedSubstrings(s) && containsConsecutiveCharacters(s) && containsThreeVowels(s))
        {
            return true;    
        }

        return false;
    }

    public int countNiceStrings(List<String> input)
    {
        int count = 0;

        for(String line : input)
        {
            if(stringIsNice(line))
            {
                count++;
            }
        }

        return count;
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
