package main.java.scheduler.event;

import java.time.LocalTime;

/**
 * Created by devil jin on 3/10/2017.
 */
public class Event {


    private final String eventName;

    private final Long duration;

    private LocalTime startTime;



    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public Event(String eventName, String time) {
        this.eventName = eventName;
        this.duration = Long.valueOf(time);

    }

    public Long getDuration() {
        return duration;
    }

    public String getEventName() {
        return eventName;
    }

}
