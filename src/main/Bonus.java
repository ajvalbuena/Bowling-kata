package main;

import java.util.ArrayList;
import java.util.List;

public class Bonus {
    List<Integer> nextTwoRollsScore = new ArrayList<>();
    private final int bonusNextRolls ;

    public Bonus(int bonusNextRolls) {
        this.bonusNextRolls = bonusNextRolls;
    }

    public void addRollScore(int pinsBlockedDown){
        this.nextTwoRollsScore.add(pinsBlockedDown);
    }

    public boolean isStrikeScoreCompleted(){
        return this.nextTwoRollsScore.size() == bonusNextRolls;
    }

    public boolean isNewStrike(){
        return this.getNextTwoRollsScore().isEmpty();
    }

    private List<Integer> getNextTwoRollsScore() {
        return nextTwoRollsScore;
    }
}
