package main.java.scheduler.event;

import main.java.scheduler.exception.InvalidEventException;

import java.time.LocalTime;

import static main.java.scheduler.ConferecneSchedulerConstant.*;

/**
 * Created by devil jin on 3/20/2017.
 */
public class EventFactory {

    public static Event getEventObjFromString(String talk) throws InvalidEventException{
        String timeString = talk.substring(talk.lastIndexOf(" "),talk.length()).trim();

        String time ;
        if(timeString.endsWith("min")) {
            time = timeString.substring(0,timeString.indexOf("min"));
        } else if(timeString.endsWith("lightning"))  {
            time  = LIGHTNING_EVENT_DURATION;
        } else {
            throw new InvalidEventException("Cannot parse the command "+talk);

        }

        return new Event(talk, time);
    }

    public static Event getEventObjForLunch() {
        Event eventObj = new Event(LUNCH_EVENT, LUNCH_DURATION);
        eventObj.setStartTime(LocalTime.of(LUNCH_HOUR,LUNCH_MINUTE));
        return eventObj;
    }

    public static Event getEventObjectForNetwork() {
        Event eventObj = new Event(NETWORK_EVENT, "00");
        eventObj.setStartTime(LocalTime.of(NETWORK_EVENT_HOUR,NETWORK_EVENT_MINUTE));
        return eventObj;
    }
}
