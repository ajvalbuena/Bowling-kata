package main;

import java.util.ArrayList;
import java.util.List;

public class Bonus {
    private final List<Integer> nextRollsScore = new ArrayList<>();
    private final int bonusNextRolls;

    private Bonus(int bonusNextRolls) {
        this.bonusNextRolls = bonusNextRolls;
    }

    public void addRollScore(int pinsBlockedDown) {
        this.nextRollsScore.add(pinsBlockedDown);
    }

    public boolean isBonusScoreCompleted() {
        return this.nextRollsScore.size() == bonusNextRolls;
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

    public static Bonus createBonus(int[] rolls) {
        if (rolls[0] == 10) return strike();
        if (rolls[0] + rolls[1] == 10) return spare();
        return noBonus();
    }
}
