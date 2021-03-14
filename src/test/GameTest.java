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

    @Test
    public void gameWith1Spare(){
        Game game = new Game();
        game.roll(8);
        game.roll(2);
        game.roll(5);
        game.roll(3);
        assertEquals(game.score(), 10+5+5+3);
    }

    @Test
    public void gameWith2Spare(){
        Game game = new Game();
        game.roll(1);
        game.roll(0);
        game.roll(8);
        game.roll(2);
        game.roll(5);
        game.roll(3);
        game.roll(7);
        game.roll(3);
        game.roll(1);
        assertEquals(game.score(), 1+0+8+2+(5)+5+3+7+3+(1)+1);
    }

    @Test
    public void gameWith1Strike(){
        Game game = new Game();
        game.roll(10);
        game.roll(1);
        game.roll(1);
        assertEquals(game.score(), 10+1+1+(1+1));

    }
}
