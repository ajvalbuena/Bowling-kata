package main;

import java.util.ArrayList;
import java.util.List;

public class Game {
    int score;
    Frame[] frames = new Frame[10];
    int currentFrame;
    List<Bonus> bonuses;
    boolean gameCompleted;

    public Game() {
        for (int i = 0; i < 9; i++) {
            this.frames[i] = new RegularFrame();
        }
        this.frames[9] = new LastFrame();

        bonuses = new ArrayList<>();
        gameCompleted = false;
    }

    public int score() {
        return score;
    }

    public void roll(int pinsBlockedDown) {
        play(pinsBlockedDown);
        if (!gameCompleted) {
            score += frames[currentFrame].sumScore(pinsBlockedDown, bonuses);
            bonuses.add(frames[currentFrame].getFrameBonus());
        }
    }


    private void play(int pinsBlockedDown) {
        for (int frame = 0; frame < 10; frame++) {
            if (!frames[frame].isFrameCompleted()) {
                frames[frame].roll(pinsBlockedDown);
                currentFrame = frame;
                return;
            }
        }
        gameCompleted = this.currentFrame == 9 ? true : gameCompleted;
    }

}
