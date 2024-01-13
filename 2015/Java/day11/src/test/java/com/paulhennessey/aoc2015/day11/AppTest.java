package com.paulhennessey.aoc2015.day11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest 
{
    App app = new App();

    @Test
    void testApp1() 
    {
        assertEquals("xz", app.incrementPassword("xy"));
    }

    @Test
    void testApp2() 
    {
        assertEquals("ya", app.incrementPassword("xz"));
    }
    
    @Test
    void testApp3() 
    {
        assertEquals("yb", app.incrementPassword("ya"));
    }

    @Test
    void testApp4() 
    {
        assertEquals("abcdffaa", app.generateNewPassword("abcdefgh"));
    }

    @Test
    void testApp5() 
    {
        assertEquals(false, app.passwordIsValid("hijklmmn"));
    }    

    @Test
    void testApp6() 
    {
        assertEquals(false, app.passwordIsValid("abbcegjk"));
    }    
    
    @Test
    void testApp9() 
    {
        assertEquals("ghjaabcc", app.generateNewPassword("ghijklmn"));
    }

    @Test
    void testApp10() 
    {
        assertEquals("cqjxxyzz", app.generateNewPassword("cqjxjnds"));
    }

    @Test
    void testApp11() 
    {
        assertEquals("cqkaabcc", app.generateNewPassword("cqjxxyzz"));
    }
    
}
