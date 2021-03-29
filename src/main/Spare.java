package main;

import java.util.ArrayList;
import java.util.List;

public class Spare {

    List<Integer> nextTwoRollsScore = new ArrayList<>();

    public void addRollScore(int pinsBlockedDown){
        this.nextTwoRollsScore.add(pinsBlockedDown);
    }

    public boolean isStrikeScoreCompleted (){
        return this.nextTwoRollsScore.size() ==1;
    }
}
