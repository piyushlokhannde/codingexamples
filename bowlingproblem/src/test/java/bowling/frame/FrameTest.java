package test.java.bowling.frame;

import main.java.bowling.exception.RollNotAllowedException;
import main.java.bowling.frame.Frame;
import main.java.bowling.frame.FrameScoreCalculator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import main.java.bowling.frame.FrameBuilder;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


/**
 * Created by devil jin on 4/10/2017.
 */
public class FrameTest {

    @Rule
    public ExpectedException exceptionGrabber = ExpectedException.none();

    @Test()
    public void testCalculateTotalScoreWhenBothGutter() throws RollNotAllowedException {
        Frame frame = FrameBuilder.getFrame(1);

        while(frame.hasNextRoll()){
            frame.setPinDownForCurrentRoll(0);
        }
        FrameScoreCalculator frameScoreCalculator = new FrameScoreCalculator();
        frameScoreCalculator.findScoreForFrame(frame);
        assertThat(frame.getFrameScore(),is(equalTo(0)));
    }

    @Test()
    public void testCalculateTotalScoreWhenFewPinsDownInBothStrike() throws RollNotAllowedException {
        Frame frame = FrameBuilder.getFrame(1);

       while (frame.hasNextRoll()){
            frame.setPinDownForCurrentRoll(1);
        }
        FrameScoreCalculator frameScoreCalculator = new FrameScoreCalculator();
        frameScoreCalculator.findScoreForFrame(frame);
        assertThat(frame.getFrameScore(),is(equalTo(2)));
    }


    @Test()
    public void testFrameHasSpare() throws RollNotAllowedException {
        Frame frame  = FrameBuilder.getFrame(1);
        if (frame.hasNextRoll()){
            frame.setPinDownForCurrentRoll(4);
        }
        if (frame.hasNextRoll()){
            frame.setPinDownForCurrentRoll(6);
        }
        assertThat(Boolean.TRUE,is(equalTo(frame.isSpare())));
        assertThat(Boolean.FALSE,is(equalTo(frame.isStrike())));

    }

    @Test
    public void testFrameHasStrike() throws RollNotAllowedException {
        Frame frame  = FrameBuilder.getFrame(1);
        if (frame.hasNextRoll()){
            frame.setPinDownForCurrentRoll(10);
        }
        if (frame.hasNextRoll()){
            frame.setPinDownForCurrentRoll(6);
        }

        assertThat(Boolean.FALSE,is(equalTo(frame.isSpare())));
        assertThat(Boolean.TRUE,is(equalTo(frame.isStrike())));
    }

  @Test
    public void testCalculateScoreWhenFrameHasScore() throws RollNotAllowedException {
      Frame frame  = FrameBuilder.getFrame(1);
      if (frame.hasNextRoll()){
          frame.setPinDownForCurrentRoll(4);
      }
      if (frame.hasNextRoll()){
          frame.setPinDownForCurrentRoll(6);
      }


      FrameScoreCalculator frameScoreCalculator = new FrameScoreCalculator();
      frameScoreCalculator.findScoreForFrame(frame);

      Frame frame2  =  FrameBuilder.getFrame(2);

      if (frame2.hasNextRoll()){
          frame2.setPinDownForCurrentRoll(4);
      }
      if (frame2.hasNextRoll()){
          frame2.setPinDownForCurrentRoll(0);
      }
      frame.nextFrame(frame2);
      frameScoreCalculator.findScoreForFrame(frame2);
      assertThat(frame.getFrameScore(),is(equalTo(14)));
      assertThat(frame2.getFrameScore(),is(equalTo(4)));
    }

     @Test
    public void testCalculateScoreWhenFrameHasStrike() throws RollNotAllowedException {
        Frame frame  = FrameBuilder.getFrame(1);
          if (frame.hasNextRoll()){
              frame.setPinDownForCurrentRoll(10);
          }



        FrameScoreCalculator frameScoreCalculator = new FrameScoreCalculator();
        frameScoreCalculator.findScoreForFrame(frame);

        Frame frame2  = FrameBuilder.getFrame(2);
          if (frame2.hasNextRoll()){
              frame2.setPinDownForCurrentRoll(4);
          }
          if (frame2.hasNextRoll()){
              frame2.setPinDownForCurrentRoll(2);
          }


        frame.nextFrame(frame2);
        frameScoreCalculator.findScoreForFrame(frame2);
        assertThat(frame.getFrameScore(),is(equalTo(16)));
        assertThat(frame2.getFrameScore(),is(equalTo(6)));
    }


    @Test
    public void tesCalculateScoreWhenLastFrameHasScore() throws RollNotAllowedException {

        FrameScoreCalculator frameScoreCalculator = new FrameScoreCalculator();
        Frame frame = FrameBuilder.getFrame(10);

        if (frame.hasNextRoll()){
            frame.setPinDownForCurrentRoll(5);
        }
        if (frame.hasNextRoll()){
            frame.setPinDownForCurrentRoll(5);
        }
        if (frame.hasNextRoll()){
            frame.setPinDownForCurrentRoll(5);
        }
        frameScoreCalculator.findScoreForFrame(frame);
        assertThat(frame.getFrameScore(),is(equalTo(15)));

    }




    @Test()
    public void testWhenThirdRollCalledForNotLastFrame() throws RollNotAllowedException{

        FrameScoreCalculator frameScoreCalculator = new FrameScoreCalculator();

        Frame frame = FrameBuilder.getFrame(1);

        if (frame.hasNextRoll()){
            frame.setPinDownForCurrentRoll(4);
        }
        if (frame.hasNextRoll()){
            frame.setPinDownForCurrentRoll(4);
        }

        if (frame.hasNextRoll()){
            frame.setPinDownForCurrentRoll(6);
        }
        frameScoreCalculator.findScoreForFrame(frame);
        assertThat(frame.getFrameScore(),is(equalTo(8)));
    }

    @Test()
    public void testExceptionWhenThirdRollCalledForLastFrameWhenNotStrikeORSpare() throws RollNotAllowedException {


        FrameScoreCalculator frameScoreCalculator = new FrameScoreCalculator();

        Frame frame = FrameBuilder.getFrame(10);

        if (frame.hasNextRoll()){
            frame.setPinDownForCurrentRoll(3);
        }
        if (frame.hasNextRoll()){
            frame.setPinDownForCurrentRoll(5);
        }

        if (frame.hasNextRoll()){
            frame.setPinDownForCurrentRoll(5);
        }
        frameScoreCalculator.findScoreForFrame(frame);
        assertThat(frame.getFrameScore(),is(equalTo(8)));

    }

    @Test
    public void testTwoFrameFirstIsStrikeFollowedBySpare() throws RollNotAllowedException {

        FrameScoreCalculator frameScoreCalculator = new FrameScoreCalculator();

        Frame frame = FrameBuilder.getFrame(1);
        if (frame.hasNextRoll()){
            frame.setPinDownForCurrentRoll(10);
        }


        frameScoreCalculator.findScoreForFrame(frame);

        Frame frame2 = FrameBuilder.getFrame(2);
        if (frame2.hasNextRoll()){
            frame2.setPinDownForCurrentRoll(6);
        }
        if (frame2.hasNextRoll()){
            frame2.setPinDownForCurrentRoll(4);
        }


        frame.nextFrame(frame2);
        frameScoreCalculator.findScoreForFrame(frame2);

        assertThat(frame.getFrameScore(),is(equalTo(20)));
    }
   @Test
    public void testFindScoreForFirstFrameWithThreeConsecutiveStrike() throws RollNotAllowedException  {

        FrameScoreCalculator frameScoreCalculator = new FrameScoreCalculator();

        Frame frame = FrameBuilder.getFrame(1);
        if (frame.hasNextRoll()){
            frame.setPinDownForCurrentRoll(10);
        }


        frameScoreCalculator.findScoreForFrame(frame);

        Frame frame2 = FrameBuilder.getFrame(2);
        if (frame2.hasNextRoll()){
            frame2.setPinDownForCurrentRoll(10);
        }


        frame.nextFrame(frame2);
        frameScoreCalculator.findScoreForFrame(frame2);

        Frame frame3 = FrameBuilder.getFrame(3);
        if (frame3.hasNextRoll()){
            frame3.setPinDownForCurrentRoll(10);
        }



        frame2.nextFrame(frame3);
        frameScoreCalculator.findScoreForFrame(frame3);
        assertThat(frame.getFrameScore(),is(equalTo(30)));

    }


    @Test
    public void testFindScoreForFirstFrameWithTwoFrameOneStrikeAndSpare() throws RollNotAllowedException {


        FrameScoreCalculator frameScoreCalculator = new FrameScoreCalculator();

        Frame frame = FrameBuilder.getFrame(1);
        if (frame.hasNextRoll()){
            frame.setPinDownForCurrentRoll(10);
        }


        frameScoreCalculator.findScoreForFrame(frame);


        Frame frame2 = FrameBuilder.getFrame(2);
        if (frame2.hasNextRoll()){
            frame2.setPinDownForCurrentRoll(10);
        }


        frame.nextFrame(frame2);


        frameScoreCalculator.findScoreForFrame(frame2);
        Frame frame3 = FrameBuilder.getFrame(3);
        if (frame3.hasNextRoll()){
            frame3.setPinDownForCurrentRoll(5);
        }
        if (frame3.hasNextRoll()){
            frame3.setPinDownForCurrentRoll(5);
        }


        frame2.nextFrame(frame3);
        frameScoreCalculator.findScoreForFrame(frame3);
        assertThat(frame.getFrameScore(),is(equalTo(25)));
        assertThat(frame2.getFrameScore(),is(equalTo(20)));


    }

    @Test
    public void test8_and_9_and_10_frameAreStrikeCalculateScore() throws RollNotAllowedException {

        Frame frame8 = FrameBuilder.getFrame(8);
        if (frame8.hasNextRoll()){
            frame8.setPinDownForCurrentRoll(10);
        }


        Frame frame9 = FrameBuilder.getFrame(9);

        if (frame9.hasNextRoll()){
            frame9.setPinDownForCurrentRoll(10);
        }
        frame8.nextFrame(frame9);


        Frame frame10 = FrameBuilder.getFrame(10);
        if (frame10.hasNextRoll()){
            frame10.setPinDownForCurrentRoll(10);
        }
        if (frame10.hasNextRoll()){
            frame10.setPinDownForCurrentRoll(10);
        }
        if (frame10.hasNextRoll()){
            frame10.setPinDownForCurrentRoll(10);
        }

        frame9.nextFrame(frame10);


        FrameScoreCalculator frameScoreCalculator = new FrameScoreCalculator();

        frameScoreCalculator.findScoreForFrame(frame8);
        frameScoreCalculator.findScoreForFrame(frame9);
        frameScoreCalculator.findScoreForFrame(frame10);

        assertThat(frame8.getFrameScore(),is(equalTo(30)));
        assertThat(frame9.getFrameScore(),is(equalTo(30)));
        assertThat(frame10.getFrameScore(),is(equalTo(30)));


    }


    @Test
    public void test8_and_9_Spare_and_10_strike_CalculateScore() throws RollNotAllowedException {

        Frame frame8 = FrameBuilder.getFrame(8);
        if (frame8.hasNextRoll()){
            frame8.setPinDownForCurrentRoll(10);
        }


        Frame frame9 = FrameBuilder.getFrame(9);
        if (frame9.hasNextRoll()){
            frame9.setPinDownForCurrentRoll(5);
        }
        if (frame9.hasNextRoll()){
            frame9.setPinDownForCurrentRoll(5);
        }
        frame8.nextFrame(frame9);


        Frame frame10 = FrameBuilder.getFrame(10);
        if (frame10.hasNextRoll()){
            frame10.setPinDownForCurrentRoll(10);
        }

        if (frame10.hasNextRoll()){
            frame10.setPinDownForCurrentRoll(10);
        }

        if (frame10.hasNextRoll()){
            frame10.setPinDownForCurrentRoll(10);
        }

        frame9.nextFrame(frame10);


        FrameScoreCalculator frameScoreCalculator = new FrameScoreCalculator();

        frameScoreCalculator.findScoreForFrame(frame8);
        frameScoreCalculator.findScoreForFrame(frame9);
        frameScoreCalculator.findScoreForFrame(frame10);

        assertThat(frame8.getFrameScore(),is(equalTo(20)));
        assertThat(frame9.getFrameScore(),is(equalTo(20)));
        assertThat(frame10.getFrameScore(),is(equalTo(30)));


    }


}