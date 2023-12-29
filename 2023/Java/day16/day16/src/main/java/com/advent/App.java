package com.advent;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    List<List<Tile>> grid = new ArrayList<>();
    List<Beam> beams = new ArrayList<>();
    int MaximumEnergisedTiles;

    public App(List<String> input) 
    {
        input.forEach(line -> 
        {
            List<Tile> row = new ArrayList<>();

            line.chars().forEach(c -> 
            {
                row.add(new Tile((char)c));
            });

            grid.add(row);
        });
    }

    public void maximiseEnergisedTiles()
    {
        checkTopRow();
        checkBottomRow();
        checkLeftmostColumn();
        checkRightmostColumn();
    }

    public void startSimulation(int row, int col, Direction direction)
    {    
        Beam beam  = new Beam(beams.size()+1, new ArrayList<Move>());  
        beams.add(beam);
        beam.moveTo(row, col, direction, grid, beams);
    }

    public int countEnergisedTiles()
    {
        int count = 0;

        for(List<Tile> row : grid)
        {
            for(Tile tile : row)
            {
                if(tile.energised)
                {
                    count++;
                }
            }
        }

        return count;
    }

    private void clearGrid()
    {
        for(List<Tile> row : grid)
        {
            for(Tile tile : row)
            {
                tile.energised = false;
            }
        }   
    }

    private void checkTopRow()
    {
        for(int col = 0; col < grid.get(0).size(); col++)
        {
            startSimulation(0, col, Direction.DOWN);

            int count = countEnergisedTiles();
            if(count > MaximumEnergisedTiles)
            {
                MaximumEnergisedTiles = count;
            }
            
            clearGrid();
        }
    }

    private void checkBottomRow()
    {
        for(int col = 0; col < grid.get(0).size(); col++)
        {
            startSimulation(grid.size()-1, col, Direction.UP);

            int count = countEnergisedTiles();
            if(count > MaximumEnergisedTiles)
            {
                MaximumEnergisedTiles = count;
            }

            clearGrid();
        }
    }

    private void checkLeftmostColumn()
    {
        for(int row = 0; row < grid.size(); row++)
        {
            startSimulation(row, 0, Direction.RIGHT);

            int count = countEnergisedTiles();
            if(count > MaximumEnergisedTiles)
            {
                MaximumEnergisedTiles = count;
            }

            clearGrid();
        }
    }

    private void checkRightmostColumn()
    {
        for(int row = 0; row < grid.size(); row++)
        {
            startSimulation(row, grid.size()-1, Direction.LEFT);

            int count = countEnergisedTiles();
            if(count > MaximumEnergisedTiles)
            {
                MaximumEnergisedTiles = count;
            }

            clearGrid();
        }
    }

}
