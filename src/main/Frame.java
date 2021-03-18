package main;

public class Frame {
    boolean spareFlag;
    boolean strikeFlag;

    int[] rolls = new int[2];

    public Frame() {
        for (int j = 0; j < 2; j++) {
            this.rolls[j] = -1;
        }
    }

    public void roll(int pinsBlockedDown) {
        if (pinsBlockedDown == 10) {
            this.rolls[0] = pinsBlockedDown;
            this.rolls[1] = 0;
            this.strikeFlag = true;
        } else if (this.rolls[0] == -1) {
            this.rolls[0] = pinsBlockedDown;
        } else {
            this.rolls[1] = pinsBlockedDown;
            this.spareFlag = this.rolls[0] + this.rolls[1] == 10;
        }
    }


    public int sumScore(int pinsBlockedDown, boolean spare, boolean strike) {
        int spareBonus = this.spareBonus(pinsBlockedDown, spare);
        int strikeBonus = this.strikeBonus(strike);
        return spareBonus + strikeBonus + pinsBlockedDown;
    }

    private int spareBonus(int pinsBlockedDown, boolean spare) {
        if (spare) {
            return pinsBlockedDown;
        }
        return 0;
    }

    private int strikeBonus(boolean strike) {

        if (strike & this.rolls[1] == -1) {
            this.strikeFlag = true;
            return this.rolls[0];
        } else if (strike & this.rolls[1] != -1) {
            this.strikeFlag = false;
            return this.rolls[1];
        } else {
            return 0;
        }
    }

    public boolean isFrameCompleted() {
        return this.rolls[0] != -1 && this.rolls[1] != -1;
    }


    public boolean isSpareFlag() {
        return spareFlag;
    }

    public boolean isStrikeFlag() {
        return strikeFlag;
    }
}