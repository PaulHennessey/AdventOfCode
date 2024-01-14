package com.paulhennessey.aoc2015.day12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

class AppTest 
{
    App app = new App();

    @Test
    void testApp() throws IOException 
    {
        int expected = app.sumAllNumbers();
        assertEquals(65402, expected);
    }
}
