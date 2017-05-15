package main.java.bowling.frame;

/**
 * Created by devil jin on 5/9/2017.
 */
public interface FrameScoreHelper extends   FrameIterator {

    Boolean isStrike();

    Boolean isSpare();

   int getFrameNumber();

   void setFrameScore(int frameScore);

   int getPinDownScore(PinDown pinDown);
}
