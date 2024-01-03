package com.paulhennessey.aoc2015.day7;

import java.util.HashMap;

public class SubNode implements Element 
{
    String name;
    HashMap<String, Node> vars;

    public SubNode(String name, HashMap<String, Node> vars) 
    {
        this.name = name;
        this.vars = vars;
    }

    @Override
    public int getValue() {
        return vars.get(name).getValue();
    }
}
