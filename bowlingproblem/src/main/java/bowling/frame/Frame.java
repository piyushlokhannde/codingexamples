package main.java.bowling.frame;

import main.java.bowling.BowlingGameConstants;
import main.java.bowling.exception.RollNotAllowedException;

/**
 * This class represent the frame.
 */
public abstract class  Frame implements FrameGameBridge,  FrameScoreHelper {

    protected int frameNumber;

    protected int pinDownFirstRoll;

    protected int pinDownSecondRoll;

    protected int pinDownThirdRoll;

    protected Boolean spare= Boolean.FALSE;

    protected Boolean strike=Boolean.FALSE;

    protected Frame nextFrame ;

    protected int frameScore;

    protected boolean hasNextRoll = true;

    private int currentRoll = 1;

    public Frame getNextFrame() {
        return nextFrame;
    }

    public Frame(int frameNumber) {
        this.frameNumber =frameNumber;
    }

    protected void setPinDownForFirstRoll(int pinDownFirstRoll) {
        this.pinDownFirstRoll = pinDownFirstRoll;
        if(this.pinDownFirstRoll == BowlingGameConstants.TOTAL_BOWLING_PINS) {
            this.strike = Boolean.TRUE;
        }
    }
    public int getPinDownScore(PinDown pinDown){
       int score =0;
       switch (pinDown) {
           case FIRST: {
               score = this.pinDownFirstRoll;
           }break;
           case FIRST_AND_SECOND: {
               score =this.pinDownFirstRoll+ this.pinDownSecondRoll;
           }break;
           case TOTAL: {
               score = this.pinDownFirstRoll+ this.pinDownSecondRoll+ this.pinDownThirdRoll;
           }break;
       }
       return score;
    }

    protected abstract void setPinDownForSecondRoll(int pinDownSecondRoll);


    public Boolean isSpare() {
        return this.spare;
    }

    public FrameScoreHelper getFrameScoreHelper() {
        return this;
    }

    public Boolean isStrike() {
        return this.strike;
    }

    public void nextFrame(Frame nextFrame) {
        this.nextFrame  = nextFrame;
    }

    protected  abstract void setPinDownForThirdRoll(int pinDownThirdRoll) throws RollNotAllowedException;

    public int getFrameScore() {
        return this.frameScore;
    }

    public int getFrameNumber() {
        return this.frameNumber;
    }

    public void setFrameScore(int frameScore) {
        this.frameScore = frameScore;
    }


    public void setPinDownForCurrentRoll(int pinDown)  throws RollNotAllowedException {
        if(hasNextRoll) {
            if(currentRoll ==1) {
                setPinDownForFirstRoll(pinDown);
            } else if(currentRoll ==2) {
                setPinDownForSecondRoll(pinDown);
            } else if(currentRoll ==3) {
                setPinDownForThirdRoll(pinDown);
            }
            currentRoll++;
        }
    }

    public  boolean hasNextRoll() {
        return hasNextRoll;
    }


   /* public int getCurrentRoll() {
        return  this.currentRoll;
    }

    public int currentRoll() {
      return this.currentRoll;
    }
    */

}
