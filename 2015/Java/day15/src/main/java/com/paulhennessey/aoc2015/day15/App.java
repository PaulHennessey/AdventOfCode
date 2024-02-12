package com.paulhennessey.aoc2015.day15;

import java.util.*;
import java.util.stream.IntStream;
import org.jetbrains.annotations.NotNull;

public class App {
    public HashMap<String, Ingredient> Ingredients = new HashMap<String, Ingredient>();
    private final List<Cookie> Cookies = new ArrayList<>();
    private final int Teaspoons = 100;

    public App() {
    }

    public void buildCookies() {
        IntStream.rangeClosed(0, Teaspoons)
            .forEach(Sprinkles ->
            {
                IntStream.rangeClosed(0, Teaspoons - Sprinkles)
                    .forEach(PeanutButter ->
                    {
                        IntStream.rangeClosed(0, Teaspoons - (Sprinkles + PeanutButter))
                            .forEach(Frosting ->
                            {
                                IntStream.rangeClosed(0, Teaspoons - (Sprinkles + PeanutButter + Frosting))
                                    .forEach(Sugar ->
                                    {
                                        if (Sprinkles + PeanutButter + Frosting + Sugar == Teaspoons) {
                                            Cookies.add(new Cookie(Sprinkles, PeanutButter, Frosting, Sugar));
                                        }
                                    });
                            });
                    });
            });
    }

    public int getHighestScoringCookiePart1() {
        int highestScore = 0;

        for (Cookie cookie : Cookies) {
            int score = cookie.score(Ingredients);
            if (score > highestScore) {
                highestScore = score;
            }
        }

        return highestScore;
    }

    public int getHighestScoringCookiePart2() {
        int highestScore = 0;

        for (Cookie cookie : Cookies) {
            int score = cookie.score(Ingredients);
            int calories = cookie.calories(Ingredients);
            if (calories == 500 && score > highestScore) {
                highestScore = score;
            }
        }

        return highestScore;
    }

    public void parseInput(@NotNull List<String> input) {
        input
            .forEach(this::parseLine);
    }

    private void parseLine(@NotNull String line) {
        String[] parts = line.split(": ");
        String name = parts[0];
        String[] properties = parts[1].split(", ");

        Ingredients.put(
            name,
            new Ingredient(
                getPropertyValue(properties[0]),
                getPropertyValue(properties[1]),
                getPropertyValue(properties[2]),
                getPropertyValue(properties[3]),
                getPropertyValue(properties[4])
            ));
    }

    private int getPropertyValue(@NotNull String property) {
        String[] propArray = property.split(" ");
        return Integer.parseInt(propArray[1]);
    }
}
