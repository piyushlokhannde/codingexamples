package main.java.bowling.frame;

import main.java.bowling.exception.RollNotAllowedException;

/**
 * Created by devil jin on 5/9/2017.
 */
public interface FrameGameBridge extends  FrameIterator {

    int getFrameScore();

    void setPinDownForCurrentRoll(int scoreForCurrentRoll) throws RollNotAllowedException;

    boolean hasNextRoll();

    Frame getNextFrame();

    FrameScoreHelper getFrameScoreHelper();

}
