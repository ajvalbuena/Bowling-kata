package main;

import java.util.ArrayList;
import java.util.List;

public class Spare implements Bonus {

    List<Integer> nextTwoRollsScore = new ArrayList<>();

    @Override
    public void addRollScore(int pinsBlockedDown){
        this.nextTwoRollsScore.add(pinsBlockedDown);
    }

    @Override
    public boolean isStrikeScoreCompleted(){
        return this.nextTwoRollsScore.size() ==1;
    }

    @Override
    public boolean isNewStrike(){
        return this.getNextTwoRollsScore().isEmpty();
    }

    private List<Integer> getNextTwoRollsScore() {
        return nextTwoRollsScore;
    }
}
