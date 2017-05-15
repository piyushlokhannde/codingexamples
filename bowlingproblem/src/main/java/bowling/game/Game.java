package main.java.bowling.game;

import main.java.bowling.exception.RollNotAllowedException;
import main.java.bowling.frame.FrameBuilder;
import main.java.bowling.frame.FrameGameBridge;
import main.java.bowling.frame.FrameScoreCalculator;

/**
 * Created by devil jin on 4/19/2017.
 */
public class Game {


    private FrameGameBridge currentFrame;
    private FrameGameBridge initialFrame;
    private FrameScoreCalculator frameScoreCalculator = new FrameScoreCalculator();

    public Game() {
        currentFrame =  initialFrame = FrameBuilder.createFramesForTenFrameGame();
    }


    public void setScoreForTheCurrentRoll(int scoreForCurrentRoll) {

        try {
            currentFrame.setPinDownForCurrentRoll(scoreForCurrentRoll);
            moveToNextFrame();
        } catch (RollNotAllowedException e) {
            e.printStackTrace();
        }

    }

    private void moveToNextFrame() {
        if(!currentFrame.hasNextRoll()
                )  {
            frameScoreCalculator.findScoreForFrame(currentFrame.getFrameScoreHelper());
            currentFrame = currentFrame.getNextFrame();
        }
    }

    public int getGameScore() {
        FrameGameBridge frameToSum  = initialFrame;
         int sum =0;
         while(frameToSum != null) {
               sum += frameToSum.getFrameScore();
               frameToSum = frameToSum.getNextFrame();
        }
        return  sum;
    }

    public boolean hasNextRoll() {
        if(currentFrame  != null) {
          return  currentFrame.hasNextRoll();
        } else  {
            return false;
        }

    }
}
