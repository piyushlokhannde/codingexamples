package main.java.bowling.frame;

import main.java.bowling.BowlingGameConstants;
import main.java.bowling.exception.RollNotAllowedException;

/**
 * Created by devil jin on 4/11/2017.
 */
public class NormalFrame extends Frame {



    public NormalFrame(int frameNumber) {
        super(frameNumber);
    }

    @Override
    public void setPinDownForThirdRoll(int pinDownThirdRoll) throws RollNotAllowedException {
        throw  new  RollNotAllowedException("Third Roll not allowed for normal frame");
    }

    @Override
    public void setPinDownForFirstRoll(int pinDownFirstRoll) {

        super.setPinDownForFirstRoll(pinDownFirstRoll);
        if(isStrike()) {
            super.hasNextRoll =false;
        } else {
            super.hasNextRoll =true;
        }
    }



    @Override
    public void setPinDownForSecondRoll(int pinDownSecondRoll) {
        if(!this.strike ) {
            this.pinDownSecondRoll = pinDownSecondRoll;
            if((this.pinDownFirstRoll+ this.pinDownSecondRoll) == BowlingGameConstants.TOTAL_BOWLING_PINS) {
                this.spare = Boolean.TRUE;
            }
            super.hasNextRoll =false;
        }
    }



}
