package com.paulhennessey.aoc2015.day17;

import java.io.IOException;
import java.util.List;
import junit.framework.TestCase;

public class AppTest
    extends TestCase
{
    App app = new App();

    public void testAppPart1_1() throws IOException
    {
        assertEquals(4, app.getCountPart(25, List.of(20, 15, 10, 5, 5), false));
    }

    public void testAppPart1_2() throws IOException
    {
        assertEquals(654, app.getCountPart(150, List.of(50, 44, 11, 49, 42, 46, 18, 32, 26, 40, 21, 7, 18, 43, 10, 47, 36, 24, 22, 40), false));
    }

    public void testAppPart2_1() throws IOException
    {
        assertEquals(3, app.getCountPart(25, List.of(20, 15, 10, 5, 5), true));
    }

    public void testAppPart2_2() throws IOException
    {
        assertEquals(57, app.getCountPart(150, List.of(50, 44, 11, 49, 42, 46, 18, 32, 26, 40, 21, 7, 18, 43, 10, 47, 36, 24, 22, 40), true));
    }

}
