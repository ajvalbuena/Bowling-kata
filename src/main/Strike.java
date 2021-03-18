package main;

import java.util.ArrayList;
import java.util.List;

public class Strike {
    List<Integer> nextTwoRollsScore = new ArrayList<>();

    public boolean isStrikeScoreCompleted (){
        return this.nextTwoRollsScore.size() ==2;
    }
}
