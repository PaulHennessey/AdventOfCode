package com.advent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

class CamelCardsTest {


    @Test
    void testFiveOfAKind() 
    {
        Hand hand = new Hand(fiveOfAKind(), 0);
        assertEquals(Type.FIVEOFAKIND, hand.getStrength());
    }        

    @Test
    void testFourOfAKind() 
    {
        Hand hand = new Hand(fourOfAKind(), 0);
        assertEquals(Type.FOUROFAKIND, hand.getStrength());
    }    

    @Test
    void testFullHouse() 
    {
        Hand hand = new Hand(fullHouse(), 0);
        assertEquals(Type.FULLHOUSE, hand.getStrength());
    }    

    @Test
    void testThreeOfAKind() 
    {
        Hand hand = new Hand(threeOfAKind1(), 0);
        assertEquals(Type.THREEOFAKIND, hand.getStrength());
    }    

    @Test
    void testTwoPair() 
    {
        Hand hand = new Hand(twoPair1(), 0);
        assertEquals(Type.TWOPAIR, hand.getStrength());
    }    

    @Test
    void testOnePair() 
    {
        Hand hand = new Hand(onePair(), 0);
        assertEquals(Type.ONEPAIR, hand.getStrength());
    }    

    @Test
    void testHighCard() 
    {
        Hand hand = new Hand(highCard(), 0);
        assertEquals(Type.HIGHCARD, hand.getStrength());
    }

    @Test
    void testHands() 
    {
        List<Hand> hands = new ArrayList<>(){{
            add(new Hand(onePair(), 765));
            add(new Hand(threeOfAKind1(), 684));
            add(new Hand(twoPair1(), 28));
            add(new Hand(twoPair2(), 220));           
            add(new Hand(threeOfAKind2(), 483));
        }};

        assertEquals(6440, CamelCards.findTotalWinnings(hands));
    }    

    private List<Card> highCard()
    {
        List<Card> cards = new ArrayList<>(){{
            add(new Card(Strength.JACK));
            add(new Card(Strength.ACE));
            add(new Card(Strength.EIGHT));
            add(new Card(Strength.SEVEN));
            add(new Card(Strength.QUEEN));                                                
        }};

        return cards;
    }

    private List<Card> onePair()
    {
        List<Card> cards = new ArrayList<>(){{
            add(new Card(Strength.THREE));
            add(new Card(Strength.TWO));
            add(new Card(Strength.TEN));
            add(new Card(Strength.THREE));
            add(new Card(Strength.KING));                                                
        }};

        return cards;
    }    

    private List<Card> twoPair1()
    {
        List<Card> cards = new ArrayList<>(){{
            add(new Card(Strength.KING));
            add(new Card(Strength.KING));
            add(new Card(Strength.SIX));
            add(new Card(Strength.SEVEN));
            add(new Card(Strength.SEVEN));                                                
        }};

        return cards;
    }        

    private List<Card> twoPair2()
    {
        List<Card> cards = new ArrayList<>(){{
            add(new Card(Strength.KING));
            add(new Card(Strength.TEN));
            add(new Card(Strength.JACK));
            add(new Card(Strength.JACK));
            add(new Card(Strength.TEN));                                                
        }};

        return cards;
    }        

    private List<Card> threeOfAKind1()
    {
        List<Card> cards = new ArrayList<>(){{
            add(new Card(Strength.TEN));
            add(new Card(Strength.FIVE));
            add(new Card(Strength.FIVE));
            add(new Card(Strength.JACK));
            add(new Card(Strength.FIVE));                                                
        }};

        return cards;
    }            

    private List<Card> threeOfAKind2()
    {
        List<Card> cards = new ArrayList<>(){{
            add(new Card(Strength.QUEEN));
            add(new Card(Strength.QUEEN));
            add(new Card(Strength.QUEEN));
            add(new Card(Strength.JACK));
            add(new Card(Strength.ACE));                                                
        }};

        return cards;
    }            

    private List<Card> fullHouse()
    {
        List<Card> cards = new ArrayList<>(){{
            add(new Card(Strength.TEN));
            add(new Card(Strength.ACE));
            add(new Card(Strength.ACE));
            add(new Card(Strength.TEN));
            add(new Card(Strength.ACE));                                                
        }};


        return cards;
    }                

    private List<Card> fourOfAKind()
    {
        List<Card> cards = new ArrayList<>(){{
            add(new Card(Strength.ACE));
            add(new Card(Strength.ACE));
            add(new Card(Strength.ACE));
            add(new Card(Strength.ACE));
            add(new Card(Strength.EIGHT));                                                
        }};

        return cards;
    }                    

    private List<Card> fiveOfAKind()
    {
        List<Card> cards = new ArrayList<>(){{
            add(new Card(Strength.ACE));
            add(new Card(Strength.ACE));
            add(new Card(Strength.ACE));
            add(new Card(Strength.ACE));
            add(new Card(Strength.ACE));                                                
        }};

        return cards;
    }                        
}
