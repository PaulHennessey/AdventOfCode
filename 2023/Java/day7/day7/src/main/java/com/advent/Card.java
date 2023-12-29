package com.advent;

public class Card 
{
    private Strength Strength;
    
    public Card(Strength strength) 
    {
        Strength = strength;
    }

    public Strength getStrength()
    {
        return this.Strength;
    }
}
