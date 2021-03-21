package main;

import java.util.ArrayList;
import java.util.List;

public class Game {
    int score;
    Frame[] frames = new Frame[12];
    int currentFrame;
    boolean spareFlag;
    List<Strike> strikes;

    public Game() {
        for (int i = 0; i < 12; i++) {
            this.frames[i] = new Frame();
        }
        strikes = new ArrayList<>();
    }

    public int score() {
        return this.score;
    }

    public void roll(int pinsBlockedDown) {
        this.play(pinsBlockedDown);
        this.score += this.frames[currentFrame].sumScore(pinsBlockedDown, this.spareFlag, this.strikes);
        this.spareFlag = this.frames[this.currentFrame].isSpareFlag();
        this.strikes = this.frames[this.currentFrame].strikes;
        this.extraRollsInLastFrame();

    }


    private void play(int pinsBlockedDown) {
        for (int frame = 0; frame < 12; frame++) {
            if (!this.frames[frame].isFrameCompleted()) {
                this.frames[frame].roll(pinsBlockedDown);
                this.currentFrame = frame;
                return;
            }
        }
    }

    private void closeGame(int closeFrame){
        for (int frame = closeFrame; frame < 12; frame++) {
                this.frames[frame].roll(0);
        }
    }

    private void extraRollsInLastFrame (){
        if(this.currentFrame ==9 && this.frames[this.currentFrame].isFrameCompleted()){
            if(this.strikes.isEmpty() && !this.spareFlag){
                this.closeGame(10);
            }
        }
        if(this.currentFrame ==10 && this.frames[this.currentFrame].isFrameCompleted()){
            if(this.strikes.isEmpty() && !this.spareFlag){
                this.closeGame(11);
            }
        }
    }


}
