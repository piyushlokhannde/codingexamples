package main.java.scheduler.track;

import main.java.scheduler.event.Event;
import main.java.scheduler.event.EventFactory;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static main.java.scheduler.ConferecneSchedulerConstant.NETWORK_EVENT;

/**List
 * Created by devil jin on 3/10/2017.
 */
public class Track {

    private final TrackScheduler  trackScheduler;

    private final String trackName;

    private final Map<String,Event> taskList = new HashMap<>();

  final  private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("h:mm a");



    public Track(String trackName,TrackScheduler trackScheduler) {
        this.trackName = trackName;

        Event lunch = EventFactory.getEventObjForLunch();
        taskList.put(lunch.getEventName(), lunch);

        Event networking = EventFactory.getEventObjectForNetwork();
        taskList.put(networking.getEventName(),networking);
        this.trackScheduler = trackScheduler;

    }

    public String getTrackName() {
        return trackName;
    }


    public boolean addTaskToTrack(Event event) {

        if(trackScheduler.scheduleEvent(event, this)) {
            this.taskList.put(event.getEventName(), event);
            return true;
        }
        return false;

    }

    public LocalTime  getStartTimeForTalk(String eventName) {
        if( taskList.get(eventName) != null) {
            return taskList.get(eventName).getStartTime();
        }
        return  null;
    }

    public String getTrackName(String eventName) {
        if(taskList.get(eventName) != null) {
            return this.trackName;
        }
        return null;
    }

    public LocalTime getStartTimeForNetworkEvent() {
       return this.taskList.get(NETWORK_EVENT).getStartTime();
    }

    public void setStartTimeForNetworkEvent(LocalTime startTime) {
        this.taskList.get(NETWORK_EVENT).setStartTime(startTime);
    }

    public void printEventList() {
        Comparator<Event> comparator = Comparator.comparing(Event::getStartTime);
        taskList.values().stream().sorted(comparator).forEach(e-> System.out.println( e.getStartTime().format(fmt)+" "+ e.getEventName()));
    }
}
