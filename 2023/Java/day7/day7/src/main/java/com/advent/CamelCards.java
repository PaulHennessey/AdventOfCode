package com.advent;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class CamelCards {

    private CamelCards() 
    {}

    public static void main(String[] args) 
    {
        System.out.println("Hello World!");
    }

    public static int findTotalWinnings(List<Hand> hands)
    {           
        int total = 0, rank = 1;  
        // List<Hand> handsSortedByEnum = hands;       
        // handsSortedByEnum.sort((h1, h2) -> h1.getStrength().compareTo(h2.getStrength()));
                
        hands.sort((h1, h2) -> h1.getStrength().compareTo(h2.getStrength()));
        if(hands.get(0).getStrength() ==  hands.get(1).getStrength())
        {
            hands.sort((h1, h2) -> h1.getFirstCard().compareTo(h2.getFirstCard()));        
            hands.sort((h1, h2) -> h1.getSecondCard().compareTo(h2.getSecondCard()));        
            hands.sort((h1, h2) -> h1.getThirdCard().compareTo(h2.getThirdCard()));        
            hands.sort((h1, h2) -> h1.getFourthCard().compareTo(h2.getFourthCard()));        
            hands.sort((h1, h2) -> h1.getFifthCard().compareTo(h2.getFifthCard()));        
        }



        // List<Hand> handsSortedByEnum = hands.stream()
        // .sorted(Comparator.comparing(Hand::getStrength))
        // .collect(Collectors.toList());

        for(Hand hand : hands)
        {
            total += hand.getBid() * rank++;
        }

        return total;
    }

}
