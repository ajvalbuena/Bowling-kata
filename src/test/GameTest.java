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

    @Test
    public void gameWith1Frame(){
        Game game = new Game();
        game.roll(5);
        game.roll(3);
        assertEquals(game.score(), 8);
    }

    @Test
    public void gameWith4NormalFrames(){
        Game game = new Game();
        game.roll(5);
        game.roll(3);
        game.roll(1);
        game.roll(2);
        game.roll(7);
        game.roll(1);
        game.roll(2);
        game.roll(3);
        assertEquals(game.score(), 24);
    }
}
