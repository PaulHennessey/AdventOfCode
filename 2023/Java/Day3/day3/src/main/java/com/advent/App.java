package com.advent;

import java.util.ArrayList;
import java.util.List;

public class App {

    private List<Integer> numbers = new ArrayList<Integer>();
    private StringBuilder number = new StringBuilder();
    private List<Location> locations = new ArrayList<Location>();

    public void main(String[] args) 
    {}

    public int getSum(List<String> list)
    {
        for(int y = 0; y < list.size(); y++)
        {
            if(y == 0)
                processFirstRow(list.get(y), list.get(y+1));
            else if (y == list.size()-1)
                processLastRow(list.get(y-1), list.get(y));
            else
                processRow(list.get(y-1), list.get(y), list.get(y+1));
        }

        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public void processFirstRow(String row, String nextRow)
    {
        for(int x = 0; x < row.length(); x++)
        {
            checkCoordinate(row, x);

            if(needToProcessLocations(locations, row, x))
            {
                for(Location location: locations)
                {
                    if(firstRowBeginningIsAdjacent(location, row, nextRow) || 
                       firstRowEndIsAdjacent(location, row, nextRow) || 
                       firstRowMiddleIsAdjacent(location, row, nextRow))
                    {
                        numbers.add(Integer.parseInt(number.toString()));
                        break;
                    }                    
                }
                locations.clear();
                number.delete(0, number.length());
            }
        }
    }

    public void processLastRow(String prevRow, String row)
    {
        for(int x = 0; x < row.length(); x++)
        {
            checkCoordinate(row, x);

            if(needToProcessLocations(locations, row, x))
            {
                for(Location location: locations)
                {
                    if(lastRowBeginningIsAdjacent(location, prevRow, row) || 
                       lastRowEndIsAdjacent(location, prevRow, row) ||  
                       lastRowMiddleIsAdjacent(location, prevRow, row))
                    {
                        numbers.add(Integer.parseInt(number.toString()));
                        break;
                    }                    
                }
                locations.clear();
                number.delete(0, number.length());
            }
        }

    }

    public void processRow(String prevRow, String row, String nextRow)
    {
        for(int x = 0; x < row.length(); x++)
        {
            checkCoordinate(row, x);

            if(needToProcessLocations(locations, row, x))
            {
                for(Location location: locations)
                {
                    if(rowBeginningIsAdjacent(location, prevRow, row, nextRow) || 
                       rowEndIsAdjacent(location, prevRow, row, nextRow) ||  
                       rowMiddleIsAdjacent(location, prevRow, row, nextRow))
                    {
                        numbers.add(Integer.parseInt(number.toString()));
                        break;
                    }                    
                }
                locations.clear();
                number.delete(0, number.length());
            }
        }
    }

    private void checkCoordinate(String row, int x)
    {
        if(Character.isDigit(row.charAt(x)))
        {
            number.append(row.charAt(x));
            locations.add(new Location(x, 0));
        }
    }

    private boolean needToProcessLocations(List<Location> locations, String row, int x)
    {
        return !locations.isEmpty() && (x == row.length()-1 || !Character.isDigit(row.charAt(x)));
    }

    private boolean IsSymbol(Character c)
    {
        return !Character.isDigit(c) && !c.equals('.');
    }

    private boolean atBeginningOfRow(Location location)
    {
        return location.X == 0;
    }

    private boolean atEndOfRow(Location location, String row)
    {
        return location.X == row.length()-1;
    }

    private boolean firstRowBeginningIsAdjacent(Location location, String row, String nextRow)
    {
        return  atBeginningOfRow(location) && 
                (IsSymbol(row.charAt(location.X+1)) || 
                IsSymbol(nextRow.charAt(location.X)) ||
                IsSymbol(nextRow.charAt(location.X+1)));
    }

    private boolean firstRowEndIsAdjacent(Location location, String row, String nextRow)
    {
        return  atEndOfRow(location, row) && 
                (IsSymbol(row.charAt(location.X-1)) || 
                IsSymbol(nextRow.charAt(location.X)) ||
                IsSymbol(nextRow.charAt(location.X-1)));
    }

    private boolean firstRowMiddleIsAdjacent(Location location, String row, String nextRow)
    {
        return  !atBeginningOfRow(location) &&
                !atEndOfRow(location, row) &&  
                (IsSymbol(row.charAt(location.X-1)) || 
                IsSymbol(row.charAt(location.X+1)) || 
                IsSymbol(nextRow.charAt(location.X-1)) ||
                IsSymbol(nextRow.charAt(location.X)) ||
                IsSymbol(nextRow.charAt(location.X+1)));
    }

    private boolean lastRowBeginningIsAdjacent(Location location, String prevRow, String row)
    {
        return  atBeginningOfRow(location) && 
                (IsSymbol(row.charAt(location.X+1)) || 
                IsSymbol(prevRow.charAt(location.X)) ||
                IsSymbol(prevRow.charAt(location.X+1)));
    }

    private boolean lastRowEndIsAdjacent(Location location, String prevRow, String row)
    {
        return  atEndOfRow(location, row) && 
                (IsSymbol(row.charAt(location.X-1)) || 
                IsSymbol(prevRow.charAt(location.X)) ||
                IsSymbol(prevRow.charAt(location.X-1)));
    }

    private boolean lastRowMiddleIsAdjacent(Location location, String prevRow, String row)
    {
        return  !atBeginningOfRow(location) &&
                !atEndOfRow(location, row) && 
                (IsSymbol(row.charAt(location.X-1)) || 
                IsSymbol(row.charAt(location.X+1)) || 
                IsSymbol(prevRow.charAt(location.X-1)) ||
                IsSymbol(prevRow.charAt(location.X)) ||
                IsSymbol(prevRow.charAt(location.X+1)));
    }

    private boolean rowBeginningIsAdjacent(Location location, String prevRow, String row, String nextRow)
    {
        return  atBeginningOfRow(location) && 
                (IsSymbol(prevRow.charAt(location.X)) ||
                IsSymbol(prevRow.charAt(location.X+1)) ||
                IsSymbol(row.charAt(location.X+1)) || 
                IsSymbol(nextRow.charAt(location.X)) ||
                IsSymbol(nextRow.charAt(location.X+1)));
    }

    private boolean rowEndIsAdjacent(Location location, String prevRow, String row, String nextRow)
    {
        return  atEndOfRow(location, row) && 
                (IsSymbol(prevRow.charAt(location.X)) ||
                IsSymbol(prevRow.charAt(location.X-1)) ||
                IsSymbol(row.charAt(location.X-1)) || 
                IsSymbol(nextRow.charAt(location.X)) ||
                IsSymbol(nextRow.charAt(location.X-1)));
    }

    private boolean rowMiddleIsAdjacent(Location location, String prevRow, String row, String nextRow)
    {
        return  !atBeginningOfRow(location) &&
                !atEndOfRow(location, row) && 
                (IsSymbol(prevRow.charAt(location.X-1)) ||
                IsSymbol(prevRow.charAt(location.X)) ||
                IsSymbol(prevRow.charAt(location.X+1)) ||
                IsSymbol(row.charAt(location.X-1)) || 
                IsSymbol(row.charAt(location.X+1)) || 
                IsSymbol(nextRow.charAt(location.X-1)) ||
                IsSymbol(nextRow.charAt(location.X)) ||
                IsSymbol(nextRow.charAt(location.X+1)));
    }    
}

