package com.paulhennessey.aoc2015.day4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.NoSuchAlgorithmException;

class AppTest 
{
    @Test
    void testApp1() throws NoSuchAlgorithmException 
    {
        // Arrange
        App app = new App();

        // Act
        long lowestPositiveNumber = app.processKey("abcdef");

        // Assert
        assertEquals(609043, lowestPositiveNumber);
    }

    @Test
    void testApp2() throws NoSuchAlgorithmException 
    {
        // Arrange
        App app = new App();

        // Act
        long lowestPositiveNumber = app.processKey("ckczppom");

        // Assert
        assertEquals(3938038, lowestPositiveNumber);
    }    
}
