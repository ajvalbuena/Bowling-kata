package main;

import java.util.ArrayList;
import java.util.List;

public class RegularFrame implements Frame{
    int[] rolls = new int[2];
    boolean spareFlag;
    List<Strike> strikes;

    public RegularFrame() {
        for (int j = 0; j < 2; j++) {
            this.rolls[j] = -1;
        }
        strikes = new ArrayList<>();
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
        this.rolls[0] = 10;
        this.rolls[1] = 0;
        this.strikes.add(new Strike());
    }


    public int sumScore(int pinsBlockedDown, boolean spare, List<Strike> strikes) {
        int spareBonus = this.spareBonus(pinsBlockedDown, spare);
        int strikeBonus = this.strikeBonus(strikes, pinsBlockedDown);
        return spareBonus + strikeBonus + pinsBlockedDown;
    }

    private int spareBonus(int pinsBlockedDown, boolean spare) {
        return spare ? pinsBlockedDown : 0;
    }

    private int strikeBonus(List<Strike> previousStrikes, int pinsBlockedDown) {
        if (previousStrikes.isEmpty()) return 0;
        int strikesScore = 0;
        List<Strike> newStrikes = new ArrayList<>();
        this.addMyOwnStrike(newStrikes);
        for (Strike strike : previousStrikes) {
            if (!strike.isStrikeScoreCompleted()) {
                strike.addRollScore(pinsBlockedDown);
                newStrikes.add(strike);
                strikesScore += pinsBlockedDown;
            }
        }
        this.strikes = newStrikes;
        return strikesScore;
    }

    private void addMyOwnStrike(List<Strike> newStrikes) {
        this.strikes.forEach(strike -> {
            if (strike.isNewStrike()) {
                newStrikes.add(strike);
            }
        });
    }

    public boolean isFrameCompleted() {
        return this.rolls[0] != -1 && this.rolls[1] != -1;
    }

    public List<Strike> getStrikes() {
        return strikes;
    }

    public boolean isSpareFlag() {
        return spareFlag;
    }

}