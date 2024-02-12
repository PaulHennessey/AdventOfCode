package com.paulhennessey.aoc2015.day15;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    App app = new App();

    @Test
    void testAppPart1() throws IOException {
        Path path = Paths.get("src/test/java/com/paulhennessey/aoc2015/day15/input.txt");
        List<String> list = Files.readAllLines(path);

        app.parseInput(list);
        app.buildCookies();

        assertEquals(13882464, app.getHighestScoringCookiePart1());
    }

    @Test
    void testAppPart2() throws IOException {
        Path path = Paths.get("src/test/java/com/paulhennessey/aoc2015/day15/input.txt");
        List<String> list = Files.readAllLines(path);

        app.parseInput(list);
        app.buildCookies();

        assertEquals(11171160, app.getHighestScoringCookiePart2());
    }
}
