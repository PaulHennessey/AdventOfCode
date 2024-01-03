package com.paulhennessey.aoc2015.day7;

public class Literal implements Element 
{
    int value;

    public Literal(int value) 
    {
        this.value = value;
    }

    @Override
    public int getValue() 
    {
        return value;
    }
}
