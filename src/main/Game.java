package main;

public class Game {
    int score;
    Frame[] frames = new Frame[10];
    int actualFrame;
    boolean spareFlag;
    boolean strikeFlag;
    Strike strike;

    public Game() {
        for (int i = 0; i < 10; i++) {
            this.frames[i] = new Frame();
        }
    }

    public int score() {
        return this.score;
    }

    public void roll(int pinsBlockedDown) {
        this.play(pinsBlockedDown);
        this.score += this.frames[actualFrame].sumScore(pinsBlockedDown, this.spareFlag, this.strikeFlag);
        this.spareFlag = this.frames[this.actualFrame].isSpareFlag();
        this.strikeFlag = this.frames[this.actualFrame].isStrikeFlag();
    }


    private void play(int pinsBlockedDown) {
        for (int frame = 0; frame < 10; frame++) {
            if (!this.frames[frame].isFrameCompleted()) {
                this.frames[frame].roll(pinsBlockedDown);
                this.actualFrame = frame;
                return;
            }
        }
    }


}
