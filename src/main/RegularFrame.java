package main;

import java.util.ArrayList;

public class RegularFrame extends Frame{
    int[] rolls = new int[2];

    public RegularFrame() {
        super();
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
            if(this.rolls[0] + this.rolls[1] == 10) {
                this.spare.add(new Spare());
            }
        }
    }

    private void createAStrikeInFrame() {
        this.rolls[0] = 10;
        this.rolls[1] = 0;
        this.strikes.add(new Strike());
    }


    public boolean isFrameCompleted() {
        return this.rolls[0] != -1 && this.rolls[1] != -1;
    }

}