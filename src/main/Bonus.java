package main;

import java.util.ArrayList;
import java.util.List;

public class Bonus {
    private final List<Integer> nextRollsScore = new ArrayList<>();
    private final int bonusNextRolls ;

    private Bonus(int bonusNextRolls) {
        this.bonusNextRolls = bonusNextRolls;
    }

    public void addRollScore(int pinsBlockedDown){
        this.nextRollsScore.add(pinsBlockedDown);
    }

    public boolean isBonusScoreCompleted(){
        return this.nextRollsScore.size() == bonusNextRolls;
    }

    public boolean isNewBonus(){
        return this.nextRollsScore.isEmpty();
    }

    public static Bonus strike(){
        return new Bonus(2);
    }
    public static Bonus spare(){
        return new Bonus(1);
    }
    public static Bonus noBonus(){
        return new Bonus(0);
    }
}
