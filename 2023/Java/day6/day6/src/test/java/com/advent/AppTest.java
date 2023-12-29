package com.advent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

class AppTest {

    @Test
    void testApp1() {
        assertEquals(4, App.ways(7, 9));
    }

    @Test
    void testApp2() {
        assertEquals(8, App.ways(15, 40));
    }
    
    @Test
    void testApp3() {
        assertEquals(9, App.ways(30, 200));
    }    

    @Test
    void testApp4() {
        assertEquals(9, App.ways(71530, 940200));
    }    

    @Test
    void testApp5() {
        List<Race> races = new ArrayList<Race>();
        races.add(new Race(7, 9));
        races.add(new Race(15, 40));
        races.add(new Race(30, 200));

        assertEquals(288, App.numberOfWays(races));
    }    

}
