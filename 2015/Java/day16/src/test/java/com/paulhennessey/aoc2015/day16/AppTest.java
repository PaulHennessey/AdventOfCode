package com.paulhennessey.aoc2015.day16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.TestCase;

public class AppTest
    extends TestCase
{
    App app = new App();

    public void testApp1() throws IOException {
        Path path = Paths.get("src/test/java/com/paulhennessey/aoc2015/day16/input.txt");
        List<String> list = Files.readAllLines(path);

        app.parseInput(list);

        Map<String, Integer> tickerTape = new HashMap<>();
        tickerTape.put("children", 3);
        tickerTape.put("cats", 7);
        tickerTape.put("samoyeds", 2);
        tickerTape.put("pomeranians", 3);
        tickerTape.put("akitas", 0);
        tickerTape.put("vizslas", 0);
        tickerTape.put("goldfish", 5);
        tickerTape.put("trees", 3);
        tickerTape.put("cars", 2);
        tickerTape.put("perfumes", 1);

        assertEquals(103, app.getNumberPartOne(tickerTape));
    }

    public void testApp2() throws IOException {
        Path path = Paths.get("src/test/java/com/paulhennessey/aoc2015/day16/input.txt");
        List<String> list = Files.readAllLines(path);

        app.parseInput(list);

        Map<String, Integer> tickerTape = new HashMap<>();
        tickerTape.put("children", 3);
        tickerTape.put("cats", 7);
        tickerTape.put("samoyeds", 2);
        tickerTape.put("pomeranians", 3);
        tickerTape.put("akitas", 0);
        tickerTape.put("vizslas", 0);
        tickerTape.put("goldfish", 5);
        tickerTape.put("trees", 3);
        tickerTape.put("cars", 2);
        tickerTape.put("perfumes", 1);

        assertEquals(405, app.getNumberPartTwo(tickerTape));
    }
}
