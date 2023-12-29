package com.advent;

import java.util.ArrayList;
import java.util.List;

public final class App 
{
    private App() 
    {}

    //Time:        56717999
//Distance:   334113513502430

    public static void main(String[] args) 
    {
        List<Race> races = new ArrayList<Race>();
        races.add(new Race(56717999, 334113513502430l));

        System.out.println("Number of ways: " + numberOfWays(races));
    }

    public static long numberOfWays(List<Race> races)
    {
        long numberOfWays = 1;
        for(Race race: races)
        {
            numberOfWays *= ways(race.getTime(), race.getRecord());
        }
        return numberOfWays;
    }
    
    public static long ways(long time, long record)
    {
        long ways = 0;

        for(long i = 0; i <= time; i++)
        {
            long speed = i;
            long distance = (time - i) * speed;
            if(distance > record)
            {
                ways++;
            }
        }
        return ways;
    }
}

