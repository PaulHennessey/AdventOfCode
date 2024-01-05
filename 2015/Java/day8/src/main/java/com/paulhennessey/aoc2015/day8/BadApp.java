package com.paulhennessey.aoc2015.day8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BadApp 
{
    static Path path = Paths.get("src/test/java/com/paulhennessey/aoc2015/day8/input.txt");

    public BadApp() 
    {}

    // found this solution here: https://www.reddit.com/r/adventofcode/comments/3vw32y/day_8_solutions/
    // I don't think this is quite in the spirit of the problem, but it is giving the right count which is what was asked for
    // and it looks cool
    public static void main(String[] args) throws IOException 
    {
        List<String> input = Files.readAllLines(path);

        int literals = input.stream()
                .mapToInt(x -> x.length())
                .sum();

        // input.stream()
        //         .map(x -> x.replace("\\\\", "S")) // finds \\ and replaces with S
        //         .map(x -> x.replace("\\\"", "Q")) // find \" and replaces with Q               
        //         .map(x -> x.replaceAll("\"", "")) // removes any single "                
        //         .map(x -> x.replaceAll("\\\\x[0-9a-f]{2}", "X"))  // removes any hex ascii characters, e.g. \x27   
        //         .forEach(System.out::println);

        int memory = input.stream()
                .map(x -> x.replace("\\\\", "S"))
                .map(x -> x.replace("\\\"", "Q"))                
                .map(x -> x.replaceAll("\"", ""))
                .map(x -> x.replaceAll("\\\\x[0-9a-f]{2}", "X"))
                .mapToInt(x -> x.length())
                .sum();

         System.out.println("literals: " + literals);
         System.out.println("memory: " + memory);
         System.out.println("literals - memory " + (literals - memory));

        // part 2

        // int embiggen = input.stream()
        //         .map(x -> x.replace("\\\\", "S"))
        //         .map(x -> x.replace("\\\"", "QQQQ"))                
        //         .map(x -> x.replaceAll("\"", "BBB"))
        //         .map(x -> x.replaceAll("\\\\x[0-9a-f]{2}", "XXXXX"))
        //         .mapToInt(x -> x.length())
        //         .sum();

                int embiggen = input.stream()
                .map(x -> x.replaceAll("\\\\x[0-9a-f]{2}", "XXXXX"))
                .map(x -> x.replace("\\\"", "QQQQ"))
                .map(x -> x.replace("\\\\", "SSSS"))
                .mapToInt(x -> x.length() + 4)
                .sum();


        // int embiggen = input.stream()
        //         .map(x -> x.replaceAll("\\\\x[0-9a-f]{2}", "XXXXX"))
        //         .map(x -> x.replace("\\\"", "QQQQ"))
        //         .map(x -> x.replace("\\\\", "SSSS"))
        //         .map(x -> x.replaceAll("\"", "PP"))
        //         .mapToInt(x -> x.length())
        //         .sum();

        System.out.println("embiggen: " + embiggen);
        System.out.println("embiggen - literals: " + (embiggen - literals));
  
    }
}
