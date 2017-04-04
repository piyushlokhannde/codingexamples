package main.java.scheduler.track;

import main.java.scheduler.event.Event;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static main.java.scheduler.ConferecneSchedulerConstant.*;

/**
 * Created by devil jin on 3/22/2017.
 */
public class TrackScheduler {

    private long morningSessonTimeLeft = TOTAL_MORNING_SESSION_TIME;

    private LocalTime mStrartTime = LocalTime.of(MORNING_SESSION_HOUR_START, MORNING_SESSION_MINUTE_START);

    private long eveningSessionTimeLeft = TOTAL_EVENING_SESSION_TIME;

    private LocalTime eStartTime = LocalTime.of(TOTAL_EVENING_HOUR_START, TOTAL_EVENING_MINUTE_START);

    public boolean scheduleEvent(Event event, Track track) {
        if(morningSessonTimeLeft >=  event.getDuration()) {
            event.setStartTime(mStrartTime);
            this.morningSessonTimeLeft = this.morningSessonTimeLeft - event.getDuration();
            mStrartTime = mStrartTime.plus(event.getDuration(), ChronoUnit.MINUTES);
            return true;
        } else if(this.eveningSessionTimeLeft >= event.getDuration()) {
            event.setStartTime(eStartTime);
            this.eveningSessionTimeLeft = this.eveningSessionTimeLeft - event.getDuration();
            eStartTime = eStartTime.plus(event.getDuration(), ChronoUnit.MINUTES);
            if(track.getStartTimeForNetworkEvent().isBefore(eStartTime)){
                track.setStartTimeForNetworkEvent(LocalTime.of(eStartTime.getHour(),eStartTime.getMinute()));
            }
            return true;
        }
        return false;
    }
}
