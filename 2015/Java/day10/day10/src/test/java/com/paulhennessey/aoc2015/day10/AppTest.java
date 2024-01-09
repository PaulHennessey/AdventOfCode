package com.paulhennessey.aoc2015.day10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest 
{
    App app = new App();

    @Test
    void testApp1() 
    {        
        assertEquals("11", app.lookAndSay("1"));
    }

    @Test
    void testApp2() 
    {        
        assertEquals("21", app.lookAndSay("11"));
    }
    
    @Test
    void testApp3() 
    {        
        assertEquals("1211", app.lookAndSay("21"));
    }

    @Test
    void testApp4() 
    {        
        assertEquals("111221", app.lookAndSay("1211"));
    }

    @Test
    void testApp5() 
    {        
        assertEquals("312211", app.lookAndSay("111221"));
    }

    @Test
    void testApp6() 
    {        
        assertEquals(329356, app.forty("3113322113"));
    }

    @Test
    void testApp7() 
    {        
        assertEquals(4666278, app.fifty("3113322113"));
    }

}
