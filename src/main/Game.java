package main;

public class Game {
    int score;
    int[][] frames = new int[10][2];
    int actualFrame;
    boolean spareFlag;
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
        this.isAnSpare();
        this.isAStrike(pinsBlockedDown);

    }

    private void sumScore(int pinsBlockedDown) {
        this.spareBonus(pinsBlockedDown);
        this.strikeBonus();
        this.score += pinsBlockedDown;
    }

    private void spareBonus(int pinsBlockedDown) {
        if (this.spareFlag) {
            this.score += pinsBlockedDown;
            this.spareFlag = false;
        }
    }

    private void strikeBonus() {
        if (this.strikeFlag & this.frames[this.actualFrame][1] != -1 ) {
            this.score += this.frames[this.actualFrame][0] + this.frames[this.actualFrame][1];
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

    private void isAnSpare() {
        if (this.frames[this.actualFrame][1] != -1) {
            this.spareFlag = this.frames[this.actualFrame][0] + this.frames[this.actualFrame][1] == 10;
        }
    }

    private void isAStrike(int pinsBlockedDown){
        if(pinsBlockedDown ==10){
            this.frames[this.actualFrame][1] = 0;
            this.strikeFlag = true;
        }

    }
}
