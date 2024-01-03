package com.paulhennessey.aoc2015.day6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

class AppTest 
{
    @Test
    void testApp1() throws IOException 
    {
        App app = new App();
        app.processInstructions();
        assertEquals(17836115, app.totalBrightness());
    }

    @Test
    void testApp2() throws IOException 
    {
        App app = new App();
        app.processInstruction("turn on 0,0 through 0,0");
        assertEquals(1, app.totalBrightness());
    }    

    @Test
    void testApp3() throws IOException 
    {
        App app = new App();
        app.processInstruction("toggle 0,0 through 999,999");
        assertEquals(2000000, app.totalBrightness());
    }        
}
