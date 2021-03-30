package main;

public class LastFrame extends Frame {
    int[] rolls = new int[3];

    public LastFrame() {
        super();
        for (int j = 0; j < 3; j++) {
            this.rolls[j] = -1;
        }
    }

    @Override
    public void roll(int pinsBlockedDown) {
        if (this.rolls[0] == -1) {
            this.rolls[0] = pinsBlockedDown;
        } else if (this.rolls[1] == -1) {
            this.rolls[1] = pinsBlockedDown;
            this.closeExtraRoll();
        } else if (this.rolls[2] == -1) {
            this.rolls[2] = pinsBlockedDown;
        }

    }

    private void closeExtraRoll() {
        if (rolls[0] != 10 && rolls[1] != 10 && this.rolls[0] + this.rolls[1] != 10) this.rolls[2] = 0;
    }


    @Override
    public boolean isFrameCompleted() {
        return this.rolls[0] != -1 && this.rolls[1] != -1 && this.rolls[2] != -1;
    }

}
