package com.paulhennessey.aoc2015.day7;

import java.util.function.IntBinaryOperator;
import java.util.HashMap;

public class Operator implements Element 
{
    HashMap<String, IntBinaryOperator> ops = new HashMap<>();
    
    IntBinaryOperator op;
    String title;
    Element left, right;

    public Operator(String title, Element left, Element right) 
    {
        ops.put("AND", (a, b) -> a & b);
        ops.put("OR", (a, b) -> a | b);
        ops.put("LSHIFT", (a, b) -> a << b);
        ops.put("RSHIFT", (a, b) -> a >> b);

        this.title = title;
        op = ops.get(title);
        this.left = left;
        this.right = right;

    }

    @Override
    public int getValue() 
    {
        return op.applyAsInt(left.getValue(), right.getValue());
    }
}
