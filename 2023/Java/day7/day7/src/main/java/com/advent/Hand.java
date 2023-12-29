package com.advent;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Hand 
{
    private List<Card> Cards;
    private int Bid;

    public Hand(List<Card> cards, int bid) 
    {
        Cards = cards;
        Bid = bid;
    }

    public int getBid()
    {
        return Bid;
    }
    
    public Strength getFirstCard()
    {
        return Cards.get(0).getStrength();
    }

    public Strength getSecondCard()
    {
        return Cards.get(1).getStrength();
    }

    public Strength getThirdCard()
    {
        return Cards.get(2).getStrength();
    }

    public Strength getFourthCard()
    {
        return Cards.get(3).getStrength();
    }

    public Strength getFifthCard()
    {
        return Cards.get(4).getStrength();
    }

    public Type getStrength()
    {
        List<Card> cardsSortedByEnum = Cards.stream()
            .sorted(Comparator.comparing(Card::getStrength))
            .collect(Collectors.toList());

        if(fiveOfAKind(cardsSortedByEnum))
        {        
            return Type.FIVEOFAKIND;
        }
        else if(fourOfAKind(cardsSortedByEnum))
        {        
            return Type.FOUROFAKIND;
        }
        else if(fullHouse(cardsSortedByEnum))
        {        
            return Type.FULLHOUSE;
        }
        else if(threeOfAKind(cardsSortedByEnum))
        {        
            return Type.THREEOFAKIND;
        }
        else if(twoPair(cardsSortedByEnum))
        {        
            return Type.TWOPAIR;
        }
        else if(onePair(cardsSortedByEnum))
        {        
            return Type.ONEPAIR;
        }

        return Type.HIGHCARD;
    }

    private boolean fiveOfAKind(List<Card> coll)
    {
        return  (coll.get(0).getStrength() == coll.get(1).getStrength()) && 
                (coll.get(1).getStrength() == coll.get(2).getStrength()) && 
                (coll.get(2).getStrength() == coll.get(3).getStrength()) && 
                (coll.get(3).getStrength() == coll.get(4).getStrength());
    }

    private boolean fourOfAKind(List<Card> coll)
    {
        return  ((coll.get(0).getStrength() == coll.get(1).getStrength()) && 
                (coll.get(1).getStrength() == coll.get(2).getStrength()) && 
                (coll.get(2).getStrength() == coll.get(3).getStrength()) && 
                (coll.get(3).getStrength() != coll.get(4).getStrength())) 
                ||
                ((coll.get(0).getStrength() != coll.get(1).getStrength()) && 
                (coll.get(1).getStrength() == coll.get(2).getStrength()) && 
                (coll.get(2).getStrength() == coll.get(3).getStrength()) && 
                (coll.get(3).getStrength() == coll.get(4).getStrength()));
    }    

    private boolean fullHouse(List<Card> coll)
    {
        return  ((coll.get(0).getStrength() == coll.get(1).getStrength()) && (coll.get(1).getStrength() == coll.get(2).getStrength()) &&
                (coll.get(3).getStrength() == coll.get(4).getStrength()))
                ||
                ((coll.get(2).getStrength() == coll.get(3).getStrength()) && (coll.get(3).getStrength() == coll.get(4).getStrength()) &&
                (coll.get(0).getStrength() == coll.get(1).getStrength()));
    }        

    private boolean threeOfAKind(List<Card> coll)
    {
        return  ((coll.get(0).getStrength() == coll.get(1).getStrength()) && (coll.get(1).getStrength() == coll.get(2).getStrength()) &&
                (coll.get(3).getStrength() != coll.get(4).getStrength()))
                ||
                ((coll.get(1).getStrength() == coll.get(2).getStrength()) && (coll.get(2).getStrength() == coll.get(3).getStrength()) &&
                (coll.get(0).getStrength() != coll.get(4).getStrength()))
                ||
                ((coll.get(2).getStrength() == coll.get(3).getStrength()) && (coll.get(3).getStrength() == coll.get(4).getStrength()) &&
                (coll.get(0).getStrength() != coll.get(1).getStrength()));
    }            

    private boolean twoPair(List<Card> coll)
    {
        return  (coll.get(0).getStrength() == coll.get(1).getStrength() && coll.get(2).getStrength() == coll.get(3).getStrength())
                ||
                (coll.get(0).getStrength() == coll.get(1).getStrength() && coll.get(3).getStrength() == coll.get(4).getStrength())
                ||
                (coll.get(1).getStrength() == coll.get(2).getStrength() && coll.get(3).getStrength() == coll.get(4).getStrength());
    }                

    private boolean onePair(List<Card> coll)
    {
        return  (coll.get(0).getStrength() == coll.get(1).getStrength())
                ||
                (coll.get(1).getStrength() == coll.get(2).getStrength())
                ||
                (coll.get(2).getStrength() == coll.get(3).getStrength())
                ||
                (coll.get(3).getStrength() == coll.get(4).getStrength());
    }                    
}
