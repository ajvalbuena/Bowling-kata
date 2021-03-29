package main;

import java.util.ArrayList;
import java.util.List;

public abstract class Frame {
    List<Bonus> bonuses;

    public Frame() {
        bonuses = new ArrayList<>();
    }

    public int sumScore(int pinsBlockedDown, List<Bonus> bonuses) {
        int spareBonus = strikeBonus(bonuses, pinsBlockedDown);
        return spareBonus + pinsBlockedDown;
    }


    private int strikeBonus(List<Bonus> previousBonuses, int pinsBlockedDown) {
        if (previousBonuses.isEmpty()) return 0;
        int strikesScore = 0;
        List<Bonus> newBonuses = new ArrayList<>();
        this.addMyOwnStrike(newBonuses);
        for (Bonus bonus : previousBonuses) {
            if (!bonus.isStrikeScoreCompleted()) {
                bonus.addRollScore(pinsBlockedDown);
                newBonuses.add(bonus);
                strikesScore += pinsBlockedDown;
            }
        }
        this.bonuses = newBonuses;
        return strikesScore;
    }

    private void addMyOwnStrike(List<Bonus> newBonuses) {
        this.bonuses.forEach(bonus -> {
            if (bonus.isNewStrike()) {
                newBonuses.add(bonus);
            }
        });
    }


    public List<Bonus> getBonuses() {
        return new ArrayList<>(bonuses);
    }


    abstract public void roll(int pinsBlockedDown);

    abstract public boolean isFrameCompleted();


}
