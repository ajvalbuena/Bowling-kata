package main;

public class Frame {
    boolean spareFlag;
    Strike strike;
    int[] rolls = new int[2];

    public Frame() {
        for (int j = 0; j < 2; j++) {
            this.rolls[j] = -1;
        }
    }

    public void roll(int pinsBlockedDown) {
        if (pinsBlockedDown == 10) {
            this.createAStrikeInFrame();
        } else if (this.rolls[0] == -1) {
            this.rolls[0] = pinsBlockedDown;
        } else {
            this.rolls[1] = pinsBlockedDown;
            this.spareFlag = this.rolls[0] + this.rolls[1] == 10;
        }
    }

    private void createAStrikeInFrame() {
        this.strike = new Strike();
        this.rolls[0] = 10;
        this.rolls[1] = 0;
    }


    public int sumScore(int pinsBlockedDown, boolean spare, Strike strike) {
        int spareBonus = this.spareBonus(pinsBlockedDown, spare);
        int strikeBonus = this.strikeBonus(strike, pinsBlockedDown);
        return spareBonus + strikeBonus + pinsBlockedDown;
    }

    private int spareBonus(int pinsBlockedDown, boolean spare) {
        return spare ? pinsBlockedDown : 0;
    }

    private int strikeBonus(Strike strike, int pinsBlockedDown) {
        if (strike !=null && !strike.isStrikeScoreCompleted()) {
            strike.nextTwoRollsScore.add(pinsBlockedDown);
            this.strike = strike;
            return pinsBlockedDown;
        }
        return 0;


    }

    public boolean isFrameCompleted() {
        return this.rolls[0] != -1 && this.rolls[1] != -1;
    }


    public boolean isSpareFlag() {
        return spareFlag;
    }

}