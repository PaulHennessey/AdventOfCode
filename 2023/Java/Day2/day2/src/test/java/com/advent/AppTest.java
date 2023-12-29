package com.advent;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AppTest {

    App app;

    @BeforeAll
    public void Init(){
        app = new App();
    }

    @Test
    void TestPossibleBasic() {
        assertEquals(true, app.Possible(1, 2, 3));
    }

    @Test
    void TestPossibleMax() {
        assertEquals(true, app.Possible(12, 13, 14));
    }

    @Test
    void TestPossibleRedTooBig() {
        assertEquals(false, app.Possible(13, 13, 14));
    }

    @Test
    void TestPossibleGreenTooBig() {
        assertEquals(false, app.Possible(12, 14, 14));
    }

    @Test
    void TestPossibleBlueTooBig() {
        assertEquals(false, app.Possible(12, 13, 15));
    }

    @Test
    void TestPossibleAllTooBig() {
        assertEquals(false, app.Possible(13, 14, 15));
    }

    @Test
    void TestSetBasic() {
        assertEquals(true, app.ProcessSet("8 red, 1 blue, 1 green"));
    }

    @Test
    void TestSetRedTooBig() {
        assertEquals(false, app.ProcessSet("13 red, 1 blue, 1 green"));
    }

    @Test
    void TestSetGreenTooBig() {
        assertEquals(false, app.ProcessSet("8 red, 1 blue, 14 green"));
    }

    @Test
    void TestSetBlueTooBig() {
        assertEquals(false, app.ProcessSet("8 red, 15 blue, 1 green"));
    }

    @Test
    void testGameBasic() {
        assertEquals(true, app.ProcessGame("1 blue, 1 red; 10 red; 8 red, 1 blue, 1 green; 1 green, 5 blue"));
    }

    @Test
    void testGameFirstGameFalse() {
        assertEquals(false, app.ProcessGame("1 blue, 1 red; 13 red; 8 red, 1 blue, 1 green; 1 green, 5 blue"));
    }

    @Test
    void testGameSecondGameFalse() {
        assertEquals(false, app.ProcessGame("1 blue, 1 red; 10 red; 8 red, 15 blue, 1 green; 1 green, 5 blue"));
    }    

    @Test
    void testGameThirdGameFalse() {
        assertEquals(false, app.ProcessGame("1 blue, 1 red; 10 red; 8 red, 5 blue, 1 green; 16 green, 5 blue"));
    }    

    @Test
    void testGameAllGamesFalse() {
        assertEquals(false, app.ProcessGame("1 blue, 15 red; 10 red; 8 red, 15 blue, 1 green; 16 green, 5 blue"));
    }    

    @Test
    void testGamesBasic() {
        List<String> gamesList = List.of("Game 1: 1 blue, 1 red; 10 red; 8 red, 1 blue, 1 green; 1 green, 5 blue");

        assertEquals(1, app.ProcessGames(gamesList));
    }

    @Test
    void testProcessGamesPowerOneGame() {
        List<String> gamesList = List.of("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");

        assertEquals(48, app.ProcessGamesPower(gamesList));
    }

    @Test
    void testProcessGamesPowerFiveGames() {
        List<String> gamesList = List.of(
        "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
        "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
        "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
        "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
        "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
        );

        assertEquals(2286, app.ProcessGamesPower(gamesList));
    }



}
