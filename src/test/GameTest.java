package test;

import main.Game;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    @Test
    public void emptyGame() {
        Game game = new Game();
        assertEquals(game.score(), 0);
    }

    @Test
    public void gameWith1Roll() {
        Game game = new Game();
        game.roll(5);
        assertEquals(game.score(), 5);
    }

    @Test
    public void gameWith1Frame() {
        Game game = new Game();
        game.roll(5);
        game.roll(3);
        assertEquals(game.score(), 8);
    }

    @Test
    public void gameWith4NormalFrames() {
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
    public void gameWith1Spare() {
        Game game = new Game();
        game.roll(8);
        game.roll(2);
        game.roll(5);
        game.roll(3);
        assertEquals(game.score(), 10 + (5) + 5 + 3);
    }

    @Test
    public void gameWith2Spare() {
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
        assertEquals(game.score(), 1 + 0 + 8 + 2 + (5) + 5 + 3 + 7 + 3 + (1) + 1);
    }

    @Test
    public void gameWith1Strike() {
        Game game = new Game();
        game.roll(10);
        game.roll(1);
        game.roll(3);
        assertEquals(game.score(), 10 + 1 + 3 + (1 + 3));
    }

    @Test
    public void gameWith2SeparatedStrikes() {
        Game game = new Game();
        game.roll(10);
        game.roll(1);
        game.roll(1);
        game.roll(3);
        game.roll(6);
        game.roll(10);
        game.roll(2);
        game.roll(2);
        assertEquals(game.score(), 10 + 1 + 1 + (1 + 1) + 3 + 6 + 10 + 2 + 2 + (2 + 2));
    }

    @Test
    public void gameWith2SeparatedStrikesAnd1Spare() {
        Game game = new Game();
        game.roll(10);
        game.roll(1);
        game.roll(1);
        game.roll(4);
        game.roll(6);
        game.roll(10);
        game.roll(2);
        game.roll(2);
        assertEquals(game.score(), 10 + 1 + 1 + (1 + 1) + 4 + 6 + 10 + (10) + 2 + 2 + (2 + 2));
    }

    @Test
    public void gameWith2StrikesTogether() {
        Game game = new Game();
        game.roll(1);
        game.roll(1);
        game.roll(10);
        game.roll(10);
        game.roll(1);
        game.roll(1);
        assertEquals(game.score(), 1 + 1 + 10 + (10 + 1) + 10 + (1 + 1) + 1 + 1);
    }

    @Test
    public void completedGameEasyFinal() {
        Game game = new Game();
        game.roll(3);
        game.roll(7);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(8);
        game.roll(2);
        game.roll(10);
        game.roll(5);
        game.roll(5);
        game.roll(1);
        game.roll(0);
        game.roll(2);
        game.roll(7);
        assertEquals(game.score(), 3 + 7 + (10) + 10 + (10 + 10) + 10 + (10 + 10) + 10 + (10 + 8) + 10 + (8 + 2) + 8 + 2 + (10) + 10 + (5 + 5) + 5 + 5 + (1) + 1 + 0 + 2 + 7);
    }

    @Test
    public void completedGameEndWithASpare() {
        Game game = new Game();
        int times = 0;
        while (times < 18) {
            game.roll(0);
            times++;
        }
        game.roll(8);
        game.roll(2);
        game.roll(3);

        assertEquals(game.score(), 0+8+2+3);
    }

    @Test
    public void trickGameEndWithASpare() {
        Game game = new Game();
        int times = 0;
        while (times < 18) {
            game.roll(0);
            times++;
        }
        game.roll(8);
        game.roll(2);
        game.roll(3);
        game.roll(3);

        assertEquals(game.score(), 0+8+2+3);
    }

    @Test
    public void completedGameEndWith1Strike() {
        Game game = new Game();
        int times = 0;
        while (times < 18) {
            game.roll(0);
            times++;
        }
        game.roll(10);
        game.roll(2);
        game.roll(3);

        assertEquals(game.score(), 0+10+2+3);
    }

    @Test
    public void completedGameEndWith2Strikes() {
        Game game = new Game();
        int times = 0;
        while (times < 18) {
            game.roll(0);
            times++;
        }
        game.roll(10);
        game.roll(10);
        game.roll(3);

        assertEquals(game.score(), 0+10+10+3);
    }

    @Test
    public void completedGameEndWith3Strikes() {
        Game game = new Game();
        int times = 0;
        while (times < 18) {
            game.roll(0);
            times++;
        }
        game.roll(10);
        game.roll(10);
        game.roll(10);

        assertEquals(game.score(), 0+10+10+10);
    }

    @Test
    public void highestScoreGame() {
        Game game = new Game();
        int times = 0;
        while (times < 12) {
            game.roll(10);
            times++;
        }

        assertEquals(game.score(), 300);
    }

}
