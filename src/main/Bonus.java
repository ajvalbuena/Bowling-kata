package main;

import java.util.ArrayList;
import java.util.List;

public class Bonus {
    private final List<Integer> nextRollsScore = new ArrayList<>();
    private final int bonusNextRollsSize;

    private Bonus(int bonusNextRollsSize) {
        this.bonusNextRollsSize = bonusNextRollsSize;
    }

    public static Bonus createBonus(int[] rolls) {
        if (rolls[0] == 10) return strike();
        if (rolls[0] + rolls[1] == 10) return spare();
        return noBonus();
    }

    public int scoreForBonus(int pinsBlockedDown) {
        if (!this.isBonusScoreCompleted()) {
            this.fillBonus(pinsBlockedDown);
            return pinsBlockedDown;
        }
        return 0;
    }

    private void fillBonus(int pinsBlockedDown) {
        this.nextRollsScore.add(pinsBlockedDown);
    }

    private boolean isBonusScoreCompleted() {
        return this.nextRollsScore.size() == bonusNextRollsSize;
    }

    private static Bonus strike() {
        return new Bonus(2);
    }

    private static Bonus spare() {
        return new Bonus(1);
    }

    public static Bonus noBonus() {
        return new Bonus(0);
    }

}
