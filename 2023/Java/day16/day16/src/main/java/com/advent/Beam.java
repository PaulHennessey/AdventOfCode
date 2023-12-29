package com.advent;

import java.util.List;

public class Beam 
{
    public boolean Active;
    private List<Move> Moves;
    public int Id;

    public Beam(int id, List<Move> moves) 
    {
        Id = id;
        Moves = moves;
        Active = true;
    }

    public void moveTo(int row, int col, Direction direction, List<List<Tile>> grid, List<Beam> beams)
    {
        if(offGrid(row, col, grid))
        {
            return;
        }
        
        if(inLoop(row, col, direction))
        {
            return;
        }
        
        Moves.add(new Move(row, col, direction));
        
        Tile tile = grid.get(row).get(col);
        tile.energise();

        switch (tile.Type) 
        {
            case EMPTYSPACE -> {
                switch (direction) 
                {
                    case UP:    
                        moveTo(--row, col, direction, grid, beams);
                        break;
                    case DOWN:                        
                        moveTo(++row, col, direction, grid, beams);
                        break;
                    case RIGHT:                        
                        moveTo(row, ++col, direction, grid, beams);
                        break;
                    case LEFT:                        
                        moveTo(row, --col, direction, grid, beams);
                        break;
                }       
            }
            case RIGHTLEANINGMIRROR -> {
                switch (direction) 
                {
                    case UP:    
                        moveTo(row, ++col, Direction.RIGHT, grid, beams);
                        break;
                    case DOWN:                        
                        moveTo(row, --col, Direction.LEFT, grid, beams);
                        break;
                    case RIGHT:                        
                        moveTo(--row, col, Direction.UP, grid, beams);
                        break;
                    case LEFT:                        
                        moveTo(++row, col, Direction.DOWN, grid, beams);
                        break;
                }       
            }
            case LEFTLEANINGMIRROR -> {
                switch (direction) 
                {
                    case UP:    
                        moveTo(row, --col, Direction.LEFT, grid, beams);
                        break;
                    case DOWN:                        
                        moveTo(row, ++col, Direction.RIGHT, grid, beams);
                        break;
                    case RIGHT:                        
                        moveTo(++row, col, Direction.DOWN, grid, beams);
                        break;
                    case LEFT:                        
                        moveTo(--row, col, Direction.UP, grid, beams);
                        break;
                }       
            }
            case VERTICALSPLITTER -> {
                switch (direction) 
                {
                    case UP:    
                        moveTo(--row, col, direction, grid, beams);
                        break;
                    case DOWN:                        
                        moveTo(++row, col, direction, grid, beams);
                        break;
                    case RIGHT:
                    case LEFT:    
                        Beam newBeam = new Beam(beams.size()+1, this.Moves);
                        beams.add(newBeam);                    
                        moveTo(row+1, col, Direction.DOWN, grid, beams);
                        newBeam.moveTo(row-1, col, Direction.UP, grid, beams);
                        break;
                }       
            }
            case HORIZONTALSPLITTER -> {
                switch (direction) 
                {
                    case UP:    
                    case DOWN:   
                        Beam newBeam = new Beam(beams.size()+1, this.Moves);
                        beams.add(newBeam);                    
                        moveTo(row, col-1, Direction.LEFT, grid, beams);
                        newBeam.moveTo(row, col+1, Direction.RIGHT, grid, beams);
                        break;
                    case RIGHT:                        
                        moveTo(row, ++col, direction, grid, beams);
                        break;
                    case LEFT:                        
                        moveTo(row, --col, direction, grid, beams);
                        break;
                }       
            }
        };
    }

    private boolean offGrid(int row, int col, List<List<Tile>> grid)
    {
        return row < 0|| col < 0 || row >= grid.size() || col >= grid.get(0).size();
    }

    private boolean inLoop(int row, int col, Direction direction)
    {
        boolean result = false;

        for(Move move : Moves)
        {
            if(move.Row == row && move.Col == col && move.Direction == direction)
            {
                result = true;
            }
        }

        return result;
    }


}
