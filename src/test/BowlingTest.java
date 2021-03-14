package test;

import main.Bowling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingTest {

    @Test
    public void emptyGame (){
        Bowling bowling = new Bowling();
        assertEquals(bowling.score(0), 0);
    }
}
