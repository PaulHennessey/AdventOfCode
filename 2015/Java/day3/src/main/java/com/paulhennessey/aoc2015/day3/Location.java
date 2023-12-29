package com.paulhennessey.aoc2015.day3;

import java.awt.Point;

public class Location extends Point
{
    public Location(int x, int y) 
    {
        super(x, y);
    }

    public void incrementX()
    {
        this.x++;
    }

    public void decrementX()
    {
        this.x--;
    }

    public void incrementY()
    {
        this.y++;
    }

    public void decrementY()
    {
        this.y--;
    }

    @Override
    public String toString() 
    {
        return String.valueOf(x) + "_" + String.valueOf(y);
    }

}
