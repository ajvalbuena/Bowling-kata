package main;

import java.util.ArrayList;
import java.util.List;

public class Game {
    int score;
    Frame[] frames = new Frame[10];
    int currentFrame;
    boolean spareFlag;
    List<Strike> strikes;

    public Game() {
        for (int i = 0; i < 10; i++) {
            this.frames[i] = new Frame();
        }
        strikes = new ArrayList<>();
    }

    public int score() {
        return this.score;
    }

    public void roll(int pinsBlockedDown) {
        this.play(pinsBlockedDown);
        this.score += this.frames[currentFrame].sumScore(pinsBlockedDown, this.spareFlag, this.strikes);
        this.spareFlag = this.frames[this.currentFrame].isSpareFlag();
        this.strikes = this.frames[this.currentFrame].strikes;
    }


    private void play(int pinsBlockedDown) {
        for (int frame = 0; frame < 10; frame++) {
            if (!this.frames[frame].isFrameCompleted()) {
                this.frames[frame].roll(pinsBlockedDown);
                this.currentFrame = frame;
                return;
            }
        }
    }


}
