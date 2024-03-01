package com.paulhennessey.aoc2015.day18;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class App {
    boolean[][] grid1;
    boolean[][] grid2;
    boolean[][] currentGrid;
    boolean[][] otherGrid;
    int gridWidth;
    int gridHeight;

    public App(List<String> input)
    {
        gridWidth = input.get(0).length();
        gridHeight = input.size();

        grid1 = new boolean[gridHeight][gridWidth];
        grid2 = new boolean[gridHeight][gridWidth];

        IntStream.range(0, gridHeight)
                .forEach(row ->
                {
                    String line = input.get(row);
                    IntStream.range(0, gridWidth)
                            .forEach(col ->
                            {
                                grid1[row][col] = line.charAt(col) == '#';
                                grid2[row][col] = line.charAt(col) == '#';
                            });
                });

        currentGrid = grid1;
        otherGrid = grid2;
    }

    public int countOnLights()
    {
        AtomicInteger count = new AtomicInteger();

        IntStream.range(0, gridHeight)
                .forEach(row ->
                    IntStream.range(0, gridWidth)
                            .forEach(col -> count.addAndGet(currentGrid[row][col] ? 1 : 0)));

        return count.get();
    }

    public void runSimulation(int steps) {
        IntStream.range(0, steps)
                .forEach(step ->
                {
                    IntStream.range(0, gridWidth)
                            .forEach(row ->
                                IntStream.range(0, gridWidth)
                                        .forEach(col -> processCell(row, col)));
                    swapGrids();
                });
    }

    private void processCell(int row, int col)
    {
        if (isCorner(row, col) ||
           (currentGrid[row][col] && twoOrThreeNeighboursAreOn(row, col)) ||
           (!currentGrid[row][col] && exactlyThreeNeighboursAreOn(row, col)))
        {
            otherGrid[row][col] = true;
        }
        else
        {
            otherGrid[row][col] = false;
        }
    }

    private boolean isCorner(int row, int col)
    {
        return ((row == 0 && col == 0) ||
                (row == 0 && col == gridWidth - 1) ||
                (row == gridHeight - 1 && col == 0) ||
                (row == gridHeight - 1 && col == gridWidth - 1));
    }

    private boolean twoOrThreeNeighboursAreOn(int row, int col)
    {
        return howManyNeighboursAreOn(row, col) == 2 || howManyNeighboursAreOn(row, col) == 3;
    }

    private boolean exactlyThreeNeighboursAreOn(int row, int col)
    {
        return howManyNeighboursAreOn(row, col) == 3;
    }

    private int howManyNeighboursAreOn(int row, int col)
    {
        int howManyNeighboursAreOn = 0;

        howManyNeighboursAreOn += cellIsOn(row - 1, col - 1);
        howManyNeighboursAreOn += cellIsOn(row - 1, col);
        howManyNeighboursAreOn += cellIsOn(row - 1, col + 1);
        howManyNeighboursAreOn += cellIsOn(row, col - 1);
        howManyNeighboursAreOn += cellIsOn(row, col + 1);
        howManyNeighboursAreOn += cellIsOn(row + 1, col - 1);
        howManyNeighboursAreOn += cellIsOn(row + 1, col);
        howManyNeighboursAreOn += cellIsOn(row + 1, col + 1);

        return howManyNeighboursAreOn;
    }

    private int cellIsOn(int row, int col)
    {
        if (row < 0 || col < 0 || row == gridHeight || col == gridWidth || !currentGrid[row][col])
            return 0;
        else
            return 1;
    }

    private void swapGrids()
    {
        if (currentGrid == grid1)
        {
            currentGrid = grid2;
            otherGrid = grid1;
        }
        else
        {
            currentGrid = grid1;
            otherGrid = grid2;
        }
    }
}
