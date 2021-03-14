package main;

public class Game {
    int score;

    public int score () {
        return this.score;
    }

    public void roll(int pinsBlockedDown) {
        this.score += pinsBlockedDown;
    }
}
