package main;

public interface Bonus {
    void addRollScore(int pinsBlockedDown);

    boolean isStrikeScoreCompleted();

    boolean isNewStrike();
}
