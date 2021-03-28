package main;

import java.util.List;

public interface Frame {

    void roll(int pinsBlockedDown);
    int sumScore(int pinsBlockedDown, boolean spare, List<Strike> strikes);
    boolean isFrameCompleted();
    boolean isSpareFlag();
    List<Strike> getStrikes();


}
