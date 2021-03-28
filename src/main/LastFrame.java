package main;

import java.util.ArrayList;
import java.util.List;

public class LastFrame implements Frame {
    int[] rolls = new int[3];
    boolean spareFlag;
    List<Strike> strikes =  new ArrayList<>();

    public LastFrame() {
        for (int j = 0; j < 3; j++) {
            this.rolls[j] = -1;
        }
        strikes = new ArrayList<>();
    }

    @Override
    public void roll(int pinsBlockedDown) {
        if(this.rolls[0] == -1) this.rolls[0] = pinsBlockedDown;
        else if (this.rolls[1] == -1) {
            this.rolls[1] = pinsBlockedDown;
            this.closeExtraRoll();
        } else if (this.rolls[2] == -1) this.rolls[2] = pinsBlockedDown;

    }

    private void closeExtraRoll (){
        if(rolls[0] !=10 && rolls[1] !=10 && this.rolls[0] + this.rolls[1] != 10 )this.rolls[2] =0;
    }

    @Override
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

    @Override
    public boolean isFrameCompleted() {
        return this.rolls[0] != -1 && this.rolls[1] != -1 && this.rolls[2] != -1;
    }

    @Override
    public boolean isSpareFlag() {
        return spareFlag;
    }

    @Override
    public List<Strike> getStrikes() {
        return this.strikes;
    }
}
