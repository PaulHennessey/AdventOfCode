package com.paulhennessey.aoc2015.day7;

public class Negation implements Element 
{
    Element orig;

    public Negation(Element orig) 
    {
        this.orig = orig;
    }

    @Override
    public int getValue() 
    {        
        return ~orig.getValue();
    }
}
