package main.java.scheduler;

import main.java.scheduler.event.Event;
import main.java.scheduler.event.EventFactory;
import main.java.scheduler.track.Track;
import main.java.scheduler.track.TrackScheduler;

import java.time.LocalTime;
import java.util.*;

/**
 * Created by devil jin on 3/9/2017.
 */
public class ConferenceScheduler {

    private final Queue<Event> eventQueue = new LinkedList<>();

    private final List<Track> trackList =  new ArrayList<>();

    private final ConferenceQuery query = new ConferenceQuery();

    public ConferenceQuery getConferenceQuery() {
        return this.query;
    }

    public boolean addTask(String command) {
       try {
           eventQueue.add(EventFactory.getEventObjFromString(command));
       } catch (Exception e) {
           System.out.println(e);
           return false;
       }
        return true;
    }

    public void scheduleTasks() {

        if(trackList.isEmpty()) {
            trackList.add(new Track("Track1", new TrackScheduler()));
        }
        for(Event talk : eventQueue) {
            boolean isEventSchedule = false;
            for(Track track :trackList) {
                if(track.addTaskToTrack(talk)) {
                    isEventSchedule = true;
                    break;
                }
            }
            if(!isEventSchedule) {
                Track track = new Track("Track"+(trackList.size()+1), new TrackScheduler());
                track.addTaskToTrack(talk);
                trackList.add(track);
            }
        }

    }



    public   class ConferenceQuery {

        public LocalTime getStartTime(String talkName) {
            Optional<LocalTime> reduce = trackList.stream().map(e -> e.getStartTimeForTalk(talkName))
                    .filter(Objects::nonNull).findFirst();
            return reduce.isPresent() ? reduce.get() : null;
        }

        public String getTrackName(String eventName) {
            Optional<String> reduce =trackList.stream().map(e -> e.getTrackName(eventName))
                    .filter(Objects::nonNull).findFirst();
            return reduce.isPresent() ? reduce.get() : null;
        }

        public void printConferenceSchedule() {
            trackList.forEach(e-> {
                System.out.println(e.getTrackName());
               e.printEventList();
               System.out.print("");
                System.out.print("");
                System.out.print("");
            });
        }
    }

    public static void main(String[] args) {
        String talk = "Writing Fast Tests Against Enterprise Rails 60min;\n" +
                "Overdoing it in Python 45min;\n" +
                "Lua for the Masses 30min;\n" +
                "Ruby Errors from Mismatched Gem Versions 45min;\n" +
                "Common Ruby Errors 45min;\n" +
                "Rails for Python Developers lightning;\n" +
                "Communicating Over Distance 60min;\n" +
                "Accounting-Driven Development 45min;\n" +
                "Woah 30min;\n" +
                "Sit Down and Write 30min;\n" +
                "Pair Programming vs Noise 45min;\n" +
                "Rails Magic 60min;\n" +
                "Ruby on Rails: Why We Should Move On 60min;\n" +
                "Clojure Ate Scala (on my project) 45min;\n" +
                "Programming in the Boondocks of Seattle 30min;\n" +
                "Ruby vs. Clojure for Back-End Development 30min;\n" +
                "Ruby on Rails Legacy App Maintenance 60min;\n" +
                "A World Without HackerNews 30min;\n" +
                "User Interface CSS in Rails Apps 30min";
        ConferenceScheduler scheduler = new ConferenceScheduler();

        for(String task: talk.split(";\n") ) {

            if(!Objects.equals(task, "")) {
               //System.out.println(task);
                 scheduler.addTask(task.trim());
            }
        }

        scheduler.scheduleTasks();
        ConferenceScheduler.ConferenceQuery query = scheduler.getConferenceQuery();
        query.printConferenceSchedule();
    }
}
