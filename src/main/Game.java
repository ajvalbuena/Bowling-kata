package main;

public class Game {
    int score;
    int[][] frames = new int[10][2];
    int actualFrame;
    boolean strikeFlag;

    public Game() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 2; j++) {
                this.frames[i][j] = -1;
            }
        }
    }

    public int score() {
        return this.score;
    }

    public void roll(int pinsBlockedDown) {
        this.createFrame(pinsBlockedDown);
        this.sumScore(pinsBlockedDown);
        this.isAStrike();

    }

    private void sumScore(int pinsBlockedDown) {
        this.strikeBonus(pinsBlockedDown);
        this.score += pinsBlockedDown;
    }

    private void strikeBonus(int pinsBlockedDown) {
        if (this.strikeFlag) {
            this.score += pinsBlockedDown;
            this.strikeFlag = false;
        }
    }

    private void createFrame(int pinsBlockedDown) {
        for (int frame = 0; frame < 10; frame++) {
            for (int roll = 0; roll < 2; roll++) {
                if (this.frames[frame][roll] == -1) {
                    this.frames[frame][roll] = pinsBlockedDown;
                    this.actualFrame = frame;
                    return;
                }
            }
        }
    }

    private void isAStrike() {
        if (this.frames[this.actualFrame][1] != -1) {
            this.strikeFlag = this.frames[this.actualFrame][0] + this.frames[this.actualFrame][1] == 10;
        }
    }
}
