package com.paulhennessey.aoc2015.day15;

import java.util.Map;

public class Cookie {

    private final int Sprinkles;
    private final int PeanutButter;
    private final int Frosting;
    private final int Sugar;

    public Cookie(int sprinkles, int peanutButter, int frosting, int sugar) {
        Sprinkles = sprinkles;
        PeanutButter = peanutButter;
        Frosting = frosting;
        Sugar = sugar;
    }

    public int score(Map<String, Ingredient> Ingredients) {
        int capacity = Ingredients.get("Sprinkles").getCapacity() * Sprinkles +
            Ingredients.get("PeanutButter").getCapacity() * PeanutButter +
            Ingredients.get("Frosting").getCapacity() * Frosting +
            Ingredients.get("Sugar").getCapacity() * Sugar;

        int durability = Ingredients.get("Sprinkles").getDurability() * Sprinkles +
            Ingredients.get("PeanutButter").getDurability() * PeanutButter +
            Ingredients.get("Frosting").getDurability() * Frosting +
            Ingredients.get("Sugar").getDurability() * Sugar;

        int flavour = Ingredients.get("Sprinkles").getFlavour() * Sprinkles +
            Ingredients.get("PeanutButter").getFlavour() * PeanutButter +
            Ingredients.get("Frosting").getFlavour() * Frosting +
            Ingredients.get("Sugar").getFlavour() * Sugar;

        int texture = Ingredients.get("Sprinkles").getTexture() * Sprinkles +
            Ingredients.get("PeanutButter").getTexture() * PeanutButter +
            Ingredients.get("Frosting").getTexture() * Frosting +
            Ingredients.get("Sugar").getTexture() * Sugar;

        capacity = Math.max(capacity, 0);
        durability = Math.max(durability, 0);
        flavour = Math.max(flavour, 0);
        texture = Math.max(texture, 0);

        return capacity * durability * flavour * texture;
    }

    public int calories(Map<String, Ingredient> Ingredients) {

        return Ingredients.get("Sprinkles").getCalories() * Sprinkles +
            Ingredients.get("PeanutButter").getCalories() * PeanutButter +
            Ingredients.get("Frosting").getCalories() * Frosting +
            Ingredients.get("Sugar").getCalories() * Sugar;
    }
}
