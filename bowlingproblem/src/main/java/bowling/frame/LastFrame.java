package main.java.bowling.frame;

import main.java.bowling.BowlingGameConstants;
import main.java.bowling.exception.RollNotAllowedException;

/**
 * Created by devil jin on 4/12/2017.
 */
public class LastFrame extends  Frame {

    @Override
    public void setPinDownForFirstRoll(int pinDownFirstRoll) {
        super.setPinDownForFirstRoll(pinDownFirstRoll);
        super.hasNextRoll =true;
    }

    public LastFrame() {
        super(BowlingGameConstants.TOTAL_FRAMES);
    }

    @Override
    public void setPinDownForSecondRoll(int pinDownSecondRoll) {
        this.pinDownSecondRoll = pinDownSecondRoll;
        if((this.pinDownFirstRoll+ this.pinDownSecondRoll) == BowlingGameConstants.TOTAL_FRAMES) {
            this.spare = Boolean.TRUE;
        }
        if(isSpare() ||isStrike()) {
            super.hasNextRoll =true;
        } else {
            super.hasNextRoll = false;
        }
    }

    @Override
    public void setPinDownForThirdRoll(int pinDownThirdRoll) throws RollNotAllowedException {
        super.hasNextRoll =false;
        if(super.strike || super.spare) {
            super.pinDownThirdRoll = pinDownThirdRoll;
        } else {
            throw new RollNotAllowedException("Can not roll third time. As it is not strike");
        }
    }


}
