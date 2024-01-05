package com.paulhennessey.aoc2015.day7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

class AppTest 
{
    App app = new App();

    @Test
    void testApp1() throws IOException 
    {
        app.buildCircuit();
        assertEquals(3176, app.getTestValue("a"));
    }

    @Test
    void testApp2() throws IOException 
    {
        
        app.buildCircuit();
        app.setTestValue("b");
        assertEquals(14710, app.getTestValue("a"));
    }

}
