package com.paulhennessey.aoc2015.day14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest
{
    App app = new App();
    Path path = Paths.get("src/test/java/com/paulhennessey/aoc2015/day14/input.txt");
    private List<String> list;

    @BeforeEach
    void init() throws IOException
    {
        list = Files.readAllLines(path);
    }

    @Test
    void testApp1()
    {
        app.parseInput(list);
        app.runRace(2503);
        app.awardPoints();

        assertEquals(1084, app.getResult(Reindeer::getPoints));
    }

    @Test
    void testApp2()
    {
        app.parseInput(list);
        app.runRace(2503);

        assertEquals(2696, app.getResult(Reindeer::getDistanceTravelled));
    }

}
