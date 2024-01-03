package com.paulhennessey.aoc2015.day6;

import java.awt.Point;

public class Location extends Point
{
    int width;
    public Location(int x, int y, int width) 
    {
        super(x, y);
        this.width = width;
    }

    public int convertToIndex()
    {
        return this.x + width * this.y;
    }
    
}
