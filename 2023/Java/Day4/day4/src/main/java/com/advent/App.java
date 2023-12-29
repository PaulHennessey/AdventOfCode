package com.advent;

import java.util.List;

public final class App {

    private App() 
    {}

    public static int getPoints(List<Card> cards)
    {
        int points = 0;

        for(Card card: cards)
        {
            points += (int)Math.pow(2, card.countMatchingNumbers()-1);
        }

        return points;
    }

    public static int getCount(List<Card> cards)
    {
        for(int index = 0; index < cards.size()-1; index++)
        {
            Card card = cards.get(index);
            int matchCount = card.countMatchingNumbers();

            copyCards(cards, card, matchCount);
        }

        return cards.size();
    }

    private static void copyCards(List<Card> cards, Card card, int matchCount)
    {
        for(int copyCount = 1; copyCount <= matchCount; copyCount++)
        {                
            Card oldCard = findCard(cards, card.getId()+copyCount);
            cards.add(new Card(oldCard.getId(), oldCard.getWinningNumbers(), oldCard.getMyNumbers()));
        }
    }

    private static Card findCard(List<Card> cards, int id)
    {
        Card c = null;
        for(Card card: cards)
        {
            if(card.getId() == id)
            {
                c = new Card(card.getId(), card.getWinningNumbers(), card.getMyNumbers());
                break;
            }
        }
        return c;
    }
}
