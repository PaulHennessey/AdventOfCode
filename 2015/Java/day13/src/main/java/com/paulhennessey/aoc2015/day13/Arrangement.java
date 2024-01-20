package com.paulhennessey.aoc2015.day13;

import java.util.List;

public class Arrangement
{
    List<Guest> Guests;

    public Arrangement()
    {}

    public Arrangement(List<Guest> guests)
    {
        Guests = guests;
    }

    public int happiness()
    {
        int happiness = 0;
        for(int i = 0; i < Guests.size(); i++)
        {
            Guest guest = Guests.get(i);
            Guest left, right;
            if(i == 0)
            {
                left = Guests.get(Guests.size() - 1);
            }
            else
            {
                left = Guests.get(i - 1);
            }
            if(i == Guests.size() - 1)
            {
                right = Guests.get(0);
            }
            else
            {
                right = Guests.get(i + 1);
            }

            happiness += guest.Neighbours.get(left.Name);
            happiness += guest.Neighbours.get(right.Name);
        }

        return happiness;
    }
}
