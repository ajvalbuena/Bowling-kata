package main;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.IntStream.range;

public class Game {
    private int score;
    private Frame[] frames = range(0, 10).mapToObj(Frame::createNewFrame).toArray(Frame[]::new);
    private int currentFrame;
    private List<Bonus> bonuses = new ArrayList<>();

    public int score() {
        return score;
    }

    public void roll(int pinsBlockedDown) {
        if(completeGame()) return;
        play(pinsBlockedDown);
        score += frames[currentFrame].sumScore(pinsBlockedDown, bonuses);
        bonuses.add(frames[currentFrame].getFrameBonus());
    }

    private boolean completeGame() {
        return currentFrame == 10 || (currentFrame == 9 && frames[currentFrame].isFrameCompleted());
    }

    private void play(int pinsBlockedDown) {
        for (int frame = 0; frame < 10; frame++) {
            if (!frames[frame].isFrameCompleted()) {
                frames[frame].roll(pinsBlockedDown);
                currentFrame = frame;
                return;
            }
        }
    }

}
