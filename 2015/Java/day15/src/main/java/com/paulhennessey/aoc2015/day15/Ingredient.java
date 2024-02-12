package com.paulhennessey.aoc2015.day15;

public class Ingredient {
    private final int Capacity;
    private final int Durability;
    private final int Flavour;
    private final int Texture;
    private final int Calories;

    public Ingredient(int capacity, int durability, int flavour, int texture, int calories) {
        Capacity = capacity;
        Durability = durability;
        Flavour = flavour;
        Texture = texture;
        Calories = calories;
    }

    public int getCapacity() {
        return Capacity;
    }

    public int getDurability() {
        return Durability;
    }

    public int getFlavour() {
        return Flavour;
    }

    public int getTexture() {
        return Texture;
    }

    public int getCalories() {
        return Calories;
    }
}
