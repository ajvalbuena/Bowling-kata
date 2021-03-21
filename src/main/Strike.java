package main;

import java.util.ArrayList;
import java.util.List;

public class Strike {
    List<Integer> nextTwoRollsScore = new ArrayList<>();

    public void addRollScore(int pinsBlockedDown){
        this.nextTwoRollsScore.add(pinsBlockedDown);
    }

    public boolean isStrikeScoreCompleted (){
        return this.nextTwoRollsScore.size() ==2;
    }

    public boolean isNewStrike(){
       return this.getNextTwoRollsScore().isEmpty();
    }

    public List<Integer> getNextTwoRollsScore() {
        return nextTwoRollsScore;
    }
}
