package main;

import java.util.List;

public abstract class Frame {

    public int sumScore(int pinsBlockedDown, List<Bonus> previousBonuses) {
        return pinsBlockedDown + bonusScore(previousBonuses, pinsBlockedDown);
    }

    public static Frame createNewFrame (int index){
        if(index ==9) return new LastFrame();
        return new RegularFrame();
    }

    private int bonusScore(List<Bonus> previousBonuses, int pinsBlockedDown) {
        if (previousBonuses.isEmpty()) return 0;
        int strikesScore = 0;
        for (Bonus bonus : previousBonuses) {
            strikesScore += bonus.scoreForBonus(pinsBlockedDown);
        }
        return strikesScore;
    }

    abstract public Bonus roll(int pinsBlockedDown);

    abstract public boolean isFrameCompleted();


}
