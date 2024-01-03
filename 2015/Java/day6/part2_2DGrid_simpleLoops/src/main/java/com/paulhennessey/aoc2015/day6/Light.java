package com.paulhennessey.aoc2015.day6;

public class Light 
{
    public int Brightness;
    
    public Light() 
    {
        Brightness = 0;
    }

    public void turnOn()
    {
        Brightness++;
    }

    public void turnOff()
    {
        Brightness = Brightness > 0 ? Brightness-1 : Brightness;
    }

    public void toggle()
    {
        Brightness += 2;
    }
}
