package main;

import java.util.ArrayList;
import java.util.List;

public class Game {
    int score;
    Frame[] frames = new Frame[10];
    int currentFrame;
    List<Bonus> spare;
    List<Bonus> bonuses;
    boolean gameCompleted;

    public Game() {
        for (int i = 0; i < 9; i++) {
            this.frames[i] = new RegularFrame();
        }
        this.frames[9] = new LastFrame();

        bonuses = new ArrayList<>();
        spare = new ArrayList<>();

        gameCompleted =false;
    }

    public int score() {
        return this.score;
    }

    public void roll(int pinsBlockedDown) {
        this.play(pinsBlockedDown);
       if(!gameCompleted) {
           this.score += this.frames[currentFrame].sumScore(pinsBlockedDown, bonuses);
           this.bonuses = this.frames[this.currentFrame].getStrikes();
       }

    }


    private void play(int pinsBlockedDown) {
        for (int frame = 0; frame < 10; frame++) {
            if (!this.frames[frame].isFrameCompleted()) {
                this.frames[frame].roll(pinsBlockedDown);
                this.currentFrame = frame;
                return;
            }

        }
        if (this.currentFrame == 9) {
            this.gameCompleted = true;
        }
    }

}
