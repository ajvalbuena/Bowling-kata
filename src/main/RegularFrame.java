package main;


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
            this.rolls[0] = 10;
            this.rolls[1] = 0;
        } else if (this.rolls[0] == -1) {
            this.rolls[0] = pinsBlockedDown;
        } else {
            this.rolls[1] = pinsBlockedDown;
        }
        this.frameBonus = Bonus.createBonus(rolls);
    }


    public boolean isFrameCompleted() {
        return this.rolls[0] != -1 && this.rolls[1] != -1;
    }

}