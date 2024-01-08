package com.paulhennessey.aoc2015.day9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class AppTest 
{
    App app = new App();
    
    @Test
    void testApp1() 
    {
        List<Location> input = List.of(new Location("London"));
        List<Route> expected = List.of(new Route(List.of(new Location("London"))));

        assertEquals(expected, app.permutations(input));
    }

    @Test
    void testApp2() 
    {
        List<Location> input = List.of(new Location("London"), new Location("Dublin"));

        Route perm1 = new Route(List.of(new Location("London"), new Location("Dublin")));
        Route perm2 = new Route(List.of(new Location("Dublin"), new Location("London")));

        List<Route> expected = new ArrayList<>();
        expected.add(perm1);
        expected.add(perm2);

        assertEquals(expected, app.permutations(input));
    }    

    @Test
    void testApp3() 
    {
        List<Location> input = List.of(new Location("London"), new Location("Dublin"), new Location("Belfast"));

        Route perm1 = new Route(List.of(new Location("London"), new Location("Dublin"), new Location("Belfast")));
        Route perm2 = new Route(List.of(new Location("London"), new Location("Belfast"), new Location("Dublin")));
        Route perm3 = new Route(List.of(new Location("Dublin"), new Location("London"), new Location("Belfast")));
        Route perm4 = new Route(List.of(new Location("Dublin"), new Location("Belfast"), new Location("London")));
        Route perm5 = new Route(List.of(new Location("Belfast"), new Location("London"), new Location("Dublin")));
        Route perm6 = new Route(List.of(new Location("Belfast"), new Location("Dublin"), new Location("London")));
        List<Route> expected = new ArrayList<>();
        expected.add(perm1);
        expected.add(perm2);
        expected.add(perm3);
        expected.add(perm4);
        expected.add(perm5);
        expected.add(perm6);

        List<Route> actual = app.permutations(input);
        assertEquals(expected, actual);
    }        

    @Test
    void testApp4() throws IOException 
    {
        Path path = Paths.get("src/test/java/com/paulhennessey/aoc2015/day9/smallinput.txt");        
        List<String> list = Files.readAllLines(path);

        Route perm1 = new Route(List.of(new Location("London"), new Location("Dublin"), new Location("Belfast")));
        Route perm2 = new Route(List.of(new Location("London"), new Location("Belfast"), new Location("Dublin")));
        Route perm3 = new Route(List.of(new Location("Dublin"), new Location("London"), new Location("Belfast")));
        Route perm4 = new Route(List.of(new Location("Dublin"), new Location("Belfast"), new Location("London")));
        Route perm5 = new Route(List.of(new Location("Belfast"), new Location("London"), new Location("Dublin")));
        Route perm6 = new Route(List.of(new Location("Belfast"), new Location("Dublin"), new Location("London")));
        List<Route> expected = new ArrayList<>();
        expected.add(perm1);
        expected.add(perm2);
        expected.add(perm3);
        expected.add(perm4);
        expected.add(perm5);
        expected.add(perm6);

        List<Location> locations = app.parseInput(list);
        List<Route> actual = app.permutations(locations);

        assertEquals(expected, actual);
    }            

    @Test
    void testApp5() throws IOException 
    {
        Path path = Paths.get("src/test/java/com/paulhennessey/aoc2015/day9/input.txt");
        List<String> list = Files.readAllLines(path);
        
        List<Location> locations = app.parseInput(list);
        List<Route> routes = app.permutations(locations);
        int distance = app.calculateShortestDistance(routes);

        assertEquals(141, distance);
    }                

    @Test
    void testApp6() throws IOException 
    {
        Path path = Paths.get("src/test/java/com/paulhennessey/aoc2015/day9/input.txt");
        List<String> list = Files.readAllLines(path);
        
        List<Location> locations = app.parseInput(list);
        List<Route> routes = app.permutations(locations);
        int distance = app.calculateLongestDistance(routes);

        assertEquals(736, distance);
    }                    
}
