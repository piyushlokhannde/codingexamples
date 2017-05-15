package main.java.bowling.frame;

import java.util.LinkedList;
import java.util.Queue;

import static main.java.bowling.BowlingGameConstants.TOTAL_FRAMES;

/**
 * Created by devil jin on 4/13/2017.
 */
public class FrameScoreCalculator {


    Queue<FrameScoreHelper> frameQueue  =  new LinkedList<>();

    private static int MAX_LIMIT_QUEUE = 2;

    public FrameScoreCalculator() {
    }

    public void findScoreForFrame(FrameScoreHelper currentFrame) {
        if(checkIfCurrentFrameIsNotStrikeORSpareOrLast(currentFrame)) {
            calculateFrameScoreAfterNonStrikeOrSpareFrame(currentFrame);
            frameScore(currentFrame, 0);
        } else if(currentFrame.isStrike()) {
            checkPreviousToPreviousFrameIsStrikeThenCalculateItsScore();
            frameQueue.add(currentFrame);
        } else if(currentFrame.isSpare()) {
            calculateFrameScoreAfterNonStrikeOrSpareFrame(currentFrame);
            frameQueue.add(currentFrame);
        }


    }

    private boolean checkIfCurrentFrameIsNotStrikeORSpareOrLast(FrameScoreHelper currentFrame){
        return ((!currentFrame.isStrike() && !currentFrame.isSpare())||
                currentFrame.getFrameNumber()== TOTAL_FRAMES);
    }

    private void checkPreviousToPreviousFrameIsStrikeThenCalculateItsScore() {
        if(frameQueue.size()==MAX_LIMIT_QUEUE) {
            FrameScoreHelper prevFrame = frameQueue.poll();
            prevFrame.setFrameScore(this.getScoreWhenNextTwoConsecutiveAreStrike(prevFrame));
        }    }

    private void calculateFrameScoreAfterNonStrikeOrSpareFrame(FrameScoreHelper currentFrame) {
        while(!frameQueue.isEmpty()) {
            FrameScoreHelper prevFrame = frameQueue.poll();
            if(frameQueue.peek() !=null && (frameQueue.peek().isSpare()|| frameQueue.peek().isStrike())) {
                frameScore(prevFrame, currentFrame.getPinDownScore(PinDown.FIRST));
            } else  {
                frameScore(prevFrame, 0);
            }
        }
    }

    private  int getScoreWhenNextTwoConsecutiveAreStrike(FrameScoreHelper currentFrame){
        return  nextFrameScore(PinDown.FIRST, currentFrame)
                +nextFrameScore(PinDown.FIRST, currentFrame.getNextFrame())
                +currentFrame.getPinDownScore(PinDown.FIRST);
    }


    private int getScoreWhenNextTwoFrameOneStrikeAnotherSpare(FrameScoreHelper currentFrame) {
        return this.getScoreWhenNextTwoConsecutiveAreStrike(currentFrame);
    }


    private void frameScore(FrameScoreHelper currentFrame, int externalScore) {
        int frameScore= 0;
            if(!currentFrame.isStrike() && !currentFrame.isSpare()) {
                frameScore = currentFrame.getPinDownScore(PinDown.TOTAL);
            }else if (currentFrame.isSpare()) {
                frameScore =  currentFrame.getPinDownScore(PinDown.TOTAL)+
                        nextFrameScore(PinDown.FIRST, currentFrame);
            } else if(currentFrame.isStrike()) {
                frameScore =  currentFrame.getPinDownScore(PinDown.TOTAL)
                        + nextFrameScore(PinDown.FIRST_AND_SECOND, currentFrame); ;
            }
        currentFrame.setFrameScore(frameScore+externalScore);
    }

    private int nextFrameScore(PinDown pinDownm ,FrameScoreHelper currentFrame) {
        if (currentFrame.getNextFrame() != null) {
            return  currentFrame.getNextFrame().getPinDownScore(pinDownm);
        }
        return 0;
    }

}
