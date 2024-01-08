package com.paulhennessey.aoc2015.day9;

import java.util.List;
import java.util.Map;

public class Route 
{
    List<Location> Locations;    

    public Route() 
    {}

    public Route(List<Location> locations)
    {
        Locations = locations;
    }

    public int getDistance(Map<Pair, Integer> distances)
    {
        int distance = 0;
        for(int i = 0; i < Locations.size()-1; i++)
        {
            Pair pair = new Pair(Locations.get(i), Locations.get(i+1));
            distance += distances.get(pair);
        }

        return distance;
    }

    @Override
    public boolean equals(Object o) 
    {
        if (o == this)
            return true;
        if (!(o instanceof Route))
            return false;
        Route other = (Route)o;
        boolean locationsEqual = (this.Locations == null && other.Locations == null) || 
                                 (this.Locations != null && this.Locations.equals(other.Locations));

        return locationsEqual;
    }    

    @Override
    public final int hashCode() 
    {
        int result = 17;
        if (Locations != null) 
        {
            result = 31 * result + Locations.hashCode();
        }

        return result;
    }        
}
