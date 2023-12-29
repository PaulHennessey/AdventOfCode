package com.advent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

class AppTest {

    @Test
    void singleValue() {
        assertEquals(32, App.getValue(singleItem1));
        assertEquals(32, App.getValue(singleItem2));
        assertEquals(32, App.getValue(singleItem3));        
        assertEquals(32, App.getValue(singleItem4));
        assertEquals(32, App.getValue(singleItem5));
        assertEquals(32, App.getValue(singleItem6));                
        assertEquals(31, App.getValue(singleItem7));
        assertEquals(31, App.getValue(singleItem8));
        assertEquals(31, App.getValue(singleItem9));                

    }

    @Test
    void threeValues() {
        assertEquals(67, App.getSum(smallList));
    }

    @Test
    void moreValues() {
        assertEquals(285, App.getSum(anotherList));
    }

    String singleItem1 = "3eehqv2";
    String singleItem2 = "ee3hqv2";
    String singleItem3 = "ee3h2qv";
    String singleItem4 = "threeeehqv2";
    String singleItem5 = "eethreehqv2";
    String singleItem6 = "eethreeh2qv";
    String singleItem7 = "threeeehqvtwone";
    String singleItem8 = "eethreehqvtwone";
    String singleItem9 = "eethreehtwoneqv";



     List<String> smallList = List.of(
    "threehqv2",
    "sxoneightoneckk9ldctxxnffqnzmjqvj",
    "1hggcqcstgpmg26lzxtltcgg");

     List<String> anotherList = List.of(
    "3eehqv2",
    "ee3hqv2",
    "ee3h2qv",
    "threeeehqv2",
    "eethreehqv2",
    "eethreeh2qv",
    "threeeehqvtwone",
    "eethreehqvtwone",
    "eethreehtwoneqv");

}