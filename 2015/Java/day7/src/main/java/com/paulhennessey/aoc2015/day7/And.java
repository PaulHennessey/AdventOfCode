package com.paulhennessey.aoc2015.day7;

public class And implements Element
{
    private Element left, right;

    public And(Element left, Element right) 
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public int getValue() 
    {
        return left.getValue() & right.getValue();
    }
    
}
