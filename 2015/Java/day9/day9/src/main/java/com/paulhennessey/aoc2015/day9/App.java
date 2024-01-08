package com.paulhennessey.aoc2015.day9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App 
{    
    Map<Pair, Integer> distances = new HashMap<Pair, Integer>();

    public int calculateShortestDistance(List<Route> routes)
    {
        int shortestDistance = Integer.MAX_VALUE;

        for(Route route : routes)
        {
            int distance = route.getDistance(distances);
            if(distance < shortestDistance)
            {
                shortestDistance = distance;
            }
        }

        return shortestDistance;
    }

    public int calculateLongestDistance(List<Route> routes)
    {
        int longestDistance = Integer.MIN_VALUE;

        for(Route route : routes)
        {
            int distance = route.getDistance(distances);
            if(distance > longestDistance)
            {
                longestDistance = distance;
            }
        }

        return longestDistance;
    }

    public List<Route> permutations(List<Location> locations)
    {
        List<Route> routes = new ArrayList<>();

        if(locations.size() == 1)
        {
            routes.add(new Route(locations));
            return routes;
        }

        for(Location location : locations)
        {
            List<Location> head = locations.subList(0, locations.indexOf(location));
            List<Location> tail = locations.subList(locations.indexOf(location)+1, locations.size());

            List<Location> shortList = new ArrayList<Location>();
            shortList.addAll(head);
            shortList.addAll(tail);

            List<Route> remaining = permutations(shortList);
            for(Route route : remaining)
            {
                List<Location> newPermutation = new ArrayList<Location>();
                newPermutation.add(location);
                newPermutation.addAll(route.Locations);

                routes.add(new Route(newPermutation));
            }
        }

        return routes;
    }

    public List<Location> parseInput(List<String> input)
    {
        String[] parts;
        List<Location> locations = new ArrayList<>();

        for(String line : input)
        {
            parts = line.split(" ");
            Location start = new Location(parts[0]);
            Location end = new Location(parts[2]);
            int distance = Integer.parseInt(parts[4]);

            if(!locations.contains(start))
            {
                locations.add(start);
            }

            if(!locations.contains(end))
            {
                locations.add(end);
            }            

            distances.put(new Pair(start, end), distance);
            distances.put(new Pair(end, start), distance);
        }

        return locations;
    }
}
