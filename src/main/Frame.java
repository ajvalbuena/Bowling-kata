package main;

import java.util.ArrayList;
import java.util.List;

public abstract class Frame {
    List<Spare> spare;
    List<Strike> strikes;

    public Frame() {
        strikes = new ArrayList<>();
        spare = new ArrayList<>();
    }

    public int sumScore(int pinsBlockedDown, List<Spare> spare, List<Strike> strikes) {
        int spareBonus = this.spareBonus(pinsBlockedDown, spare);
        int strikeBonus = this.strikeBonus(strikes, pinsBlockedDown);
        return spareBonus + strikeBonus + pinsBlockedDown;
    }


    private int spareBonus(int pinsBlockedDown, List<Spare> spare) {
        if (spare.isEmpty()) return 0;
        for (Spare s : spare) {
            if (!s.isStrikeScoreCompleted()) {
                s.addRollScore(pinsBlockedDown);
                return pinsBlockedDown;
            }
        }
        return 0;
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

    public List<Spare>  getSpare() {
        return new ArrayList<>(this.spare);
    }


    public List<Strike> getStrikes() {
        return new ArrayList<>(this.strikes);
    }


    abstract public void roll(int pinsBlockedDown);

    abstract public boolean isFrameCompleted();


}
