package com.paulhennessey.aoc2015.day13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class App
{
    public App()
    {}

    public int totalChangeInHappiness(List<Arrangement> arrangements)
    {
        int change = Integer.MIN_VALUE;

        for(Arrangement arrangement : arrangements)
        {
            int happiness = arrangement.happiness();
            if(happiness > change)
            {
                change = happiness;
            }
        }

        return change;
    }

     public List<Arrangement> permutations(List<Guest> guests)
    {
        List<Arrangement> arrangements = new ArrayList<>();

        if(guests.size() == 1)
        {
            arrangements.add(new Arrangement(guests));
            return arrangements;
        }

        for(Guest location : guests)
        {
            List<Guest> head = guests.subList(0, guests.indexOf(location));
            List<Guest> tail = guests.subList(guests.indexOf(location)+1, guests.size());

            List<Guest> shortList = new ArrayList<Guest>();
            shortList.addAll(head);
            shortList.addAll(tail);

            List<Arrangement> remaining = permutations(shortList);
            for(Arrangement arrangement : remaining)
            {
                List<Guest> newPermutation = new ArrayList<Guest>();
                newPermutation.add(location);
                newPermutation.addAll(arrangement.Guests);

                arrangements.add(new Arrangement(newPermutation));
            }
        }

        return arrangements;
    }

    private Guest findGuest(Collection<Guest> list, String name)
    {
        return list
                .stream()
                .filter(g -> g.Name.equals(name))
                .findAny()
                .orElse(null);
    }

    public List<Guest> parseInput(List<String> input)
    {
        String[] parts;
        List<Guest> guests = new ArrayList<>();

        for(String line : input)
        {
            parts = line.split(" ");
            String name = parts[0];
            int happiness = Integer.parseInt(parts[3]);
            if(parts[2].equals("lose"))
            {
                happiness = -happiness;
            }
            String neighbour = parts[10];
            neighbour = neighbour.substring(0, neighbour.length() - 1);

            Guest guest = findGuest(guests, name);
            if(guest == null)
            {
                guest = new Guest(name);
                guest.Neighbours.put(neighbour, happiness);
                guests.add(guest);
            }
            else
            {
                guest.Neighbours.put(neighbour, happiness);
            }
        }

        return guests;
    }

    public List<Guest> addMe(List<Guest> guests)
    {
        Guest me = new Guest("Paul");
        for(Guest neighbour : guests)
        {
            me.Neighbours.put(neighbour.Name, 0);
            neighbour.Neighbours.put(me.Name, 0);
        }
        guests.add(me);

        return guests;
    }

    public static void main(String[] args)
    {
        System.out.println("Hello World!");
    }
}
