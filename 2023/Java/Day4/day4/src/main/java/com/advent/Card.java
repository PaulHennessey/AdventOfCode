package com.advent;

import java.util.ArrayList;
import java.util.List;

public class Card
{
    private int Id;
    private List<Integer> WinningNumbers;
    private List<Integer> MyNumbers;

    public Card(int id, List<Integer> winningNumbers, List<Integer> myNumbers) 
    {
        Id = id;
        WinningNumbers = winningNumbers;
        MyNumbers = myNumbers;
    }

    public int getId()
    {
        return Id;
    }

    public List<Integer> getWinningNumbers()
    {
        return WinningNumbers;
    }

    public List<Integer> getMyNumbers()
    {
        return MyNumbers;
    }

    public int countMatchingNumbers()
    {
        List<Integer> commonNumbers = new ArrayList<>(WinningNumbers);
        commonNumbers.retainAll(MyNumbers);

        return commonNumbers.size();
    }

}
