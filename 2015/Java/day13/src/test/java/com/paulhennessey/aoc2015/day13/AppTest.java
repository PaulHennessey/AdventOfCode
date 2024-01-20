package com.paulhennessey.aoc2015.day13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class AppTest
{
    App app = new App();

    @Test
    void testApp1() throws IOException
    {
        Path path = Paths.get("src/test/java/com/paulhennessey/aoc2015/day13/smallinput.txt");
        List<String> list = Files.readAllLines(path);

        List<Guest> guests = app.parseInput(list);
        List<Arrangement> arrangements = app.permutations(guests);
        assertEquals(330, app.totalChangeInHappiness(arrangements));
    }

    @Test
    void testApp2() throws IOException
    {
        Path path = Paths.get("src/test/java/com/paulhennessey/aoc2015/day13/input.txt");
        List<String> list = Files.readAllLines(path);

        List<Guest> guests = app.parseInput(list);
        List<Arrangement> arrangements = app.permutations(guests);
        assertEquals(618, app.totalChangeInHappiness(arrangements));
    }

    @Test
    void testApp3() throws IOException
    {
        Path path = Paths.get("src/test/java/com/paulhennessey/aoc2015/day13/input.txt");
        List<String> list = Files.readAllLines(path);

        List<Guest> guests = app.parseInput(list);
        guests = app.addMe(guests);
        List<Arrangement> arrangements = app.permutations(guests);
        assertEquals(601, app.totalChangeInHappiness(arrangements));
    }
}
