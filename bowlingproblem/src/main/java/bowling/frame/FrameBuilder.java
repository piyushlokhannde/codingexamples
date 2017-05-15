package main.java.bowling.frame;

import main.java.bowling.BowlingGameConstants;

/**
 * Created by devil jin on 5/8/2017.
 */
public class FrameBuilder {


    public static FrameGameBridge createFramesForTenFrameGame() {
        Frame initialFrame = getFrame(1);
        Frame previousFrame =initialFrame;
        for(int i=2;i <= BowlingGameConstants.TOTAL_FRAMES;i++) {
            Frame frame = getFrame(i);
            if(previousFrame !=null) {
                previousFrame.nextFrame(frame);
            }
            previousFrame = frame;
        }
        return initialFrame;
    }


    public static Frame getFrame(int frameNumber) {
        if(frameNumber < BowlingGameConstants.TOTAL_FRAMES){
            return new NormalFrame(frameNumber);
        } else  {
            return  new LastFrame();
        }
    }
}
