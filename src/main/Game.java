package main;

import java.util.ArrayList;
import java.util.List;
import static java.util.stream.IntStream.range;

public class Game {
    private int score;
    private Frame[] frames = range(0,10).mapToObj(Frame::createNewFrame).toArray(Frame[]::new);
    private int currentFrame;
    private List<Bonus> bonuses;
    private boolean gameCompleted;

    public Game() {
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
