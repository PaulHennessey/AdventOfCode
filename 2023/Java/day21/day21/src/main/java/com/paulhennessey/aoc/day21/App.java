package com.paulhennessey.aoc.day21;

import java.util.List;

public class App 
{
    char[][] grid1;
    char[][] grid2;
    char[][] currentGrid;
    char[][] otherGrid;
    int gridWidth;
    int gridHeight;

        
    public App(List<String> input) 
    {
        gridWidth = input.get(0).length();
        gridHeight = input.size();

        grid1 = new char[gridHeight][gridWidth];
        grid2 = new char[gridHeight][gridWidth];

        for(int i = 0; i < gridHeight; i++)
        {
            String line = input.get(i);
            for(int j = 0; j < gridWidth; j++)
            {
                grid1[i][j] = line.charAt(j);
                grid2[i][j] = line.charAt(j);
            }
        }
    
        currentGrid = grid1;
        otherGrid = grid2;
    }

    public void runSimulation(int steps)
    {
        runFirstStep();
        runSteps(steps-1);
    }

    private void swapGrids()
    {
        if(currentGrid == grid1)
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

    private void runFirstStep()
    {
        for(int row = 0; row < gridHeight; row++)
        {
            for(int col = 0; col < gridWidth; col++)
            {
                if(currentGrid[row][col] == 'S')
                {
                    north(row, col);
                    east(row, col);
                    south(row, col);
                    west(row, col);
                    currentGrid[row][col] = '.';
                }
            }
        }
        swapGrids();
    }

    private void runSteps(int steps)
    {
        for(int step = 1; step <= steps; step++)
        {
            for(int row = 0; row < gridHeight; row++)
            {
                for(int col = 0; col < gridWidth; col++)
                {
                    if(currentGrid[row][col] == 'O')
                    {
                        north(row, col);
                        east(row, col);
                        south(row, col);
                        west(row, col);
                        currentGrid[row][col] = '.';
                    }
                }
            }
            swapGrids();
        }
    }


    private void north(int row, int col)
    {
        if(row > 0)
        {
            processPlot(row-1, col);
        }
    }

    private void east(int row, int col)
    {
        if(col < gridWidth-1)
        {
            processPlot(row, col+1);
        }
    }

    private void south(int row, int col)
    {
        if(row < gridHeight-1)
        {
            processPlot(row+1, col);
        }
    }


    private void west(int row, int col)
    {
        if(col > 0)
        {
            processPlot(row, col-1);
        }
    }

    private void processPlot(int row, int col)
    {
        if(otherGrid[row][col] == '.')
        {
            otherGrid[row][col] = 'O';
        }
    }

    public int countPlots()
    {
        int total = 0;
        
        for(int i = 0; i < gridHeight; i++)
        {
            for(int j = 0; j < gridWidth; j++)
            {
                if(currentGrid[i][j] == 'O')
                {
                    total++;
                }
            }
        }

        return total;
    }

    public void showGrid()
    {
        for(int i = 0; i < gridHeight; i++)
        {
            for(int j = 0; j < gridWidth; j++)
            {
                System.out.print(currentGrid[i][j]);
            }
            System.out.println();
        }
    }
}
