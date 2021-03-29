package main;

import java.util.ArrayList;
import java.util.List;

public class Strike implements Bonus {
    List<Integer> nextTwoRollsScore = new ArrayList<>();

    @Override
    public void addRollScore(int pinsBlockedDown){
        this.nextTwoRollsScore.add(pinsBlockedDown);
    }

    @Override
    public boolean isStrikeScoreCompleted(){
        return this.nextTwoRollsScore.size() ==2;
    }

    @Override
    public boolean isNewStrike(){
       return this.getNextTwoRollsScore().isEmpty();
    }

    private List<Integer> getNextTwoRollsScore() {
        return nextTwoRollsScore;
    }
}
