package com.paulhennessey.aoc2015.day7;

public class Node implements Element
{
    Element value;
    Integer cached = null; // the cache makes sure we only get it once

    public void setValue(Element value) 
    {
        this.value = value;
    }
    
    @Override
    public int getValue() 
    {            
        if (cached == null)
            cached = value.getValue();
        return cached;
    }
}

