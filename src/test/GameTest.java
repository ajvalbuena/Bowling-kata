package test;

import main.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    @Test
    public void emptyGame (){
        Game game = new Game();
        assertEquals(game.score(), 0);
    }

    @Test
    public void gameWith1Roll (){
        Game game = new Game();
        game.roll(5);
        assertEquals(game.score(), 5);
    }
}
