package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void testgetPlayerName() {
        assertEquals("Name", new Player("Name").getPlayerName());
        assertEquals("Tom", new Player("Tom").getPlayerName());
    }

    @Test
    void testgetGames() {
        assertEquals(0, new Player("Name").getGames());
    }


}