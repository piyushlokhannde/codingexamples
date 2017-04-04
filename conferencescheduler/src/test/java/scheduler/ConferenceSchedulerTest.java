package test.java.scheduler;

import main.java.scheduler.ConferenceScheduler;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.SECONDS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
/**
 * Created by devil jin on 3/9/2017.
 */
public class ConferenceSchedulerTest {


    @Test
    public void scheduleSingleTaskInConference() {
        String talk = "Writing Fast Tests Against Enterprise Rails 60min";
        ConferenceScheduler scheduler = new ConferenceScheduler();
        scheduler.addTask(talk);
        scheduler.scheduleTasks();
        ConferenceScheduler.ConferenceQuery query = scheduler.getConferenceQuery();
        assertThat(LocalTime.of(9, 00).compareTo(query.getStartTime(talk)),
                anyOf(equalTo(0), equalTo(1)));

    }

    @Test
    public void scheduleTwoTaskInConference() {
        String talk1 = "Writing Fast Tests Against Enterprise Rails 60min";
        String talk2 = "Overdoing it in Python 60min";
        ConferenceScheduler scheduler = new ConferenceScheduler();
        scheduler.addTask(talk1);
        scheduler.addTask(talk2);
        scheduler.scheduleTasks();
        ConferenceScheduler.ConferenceQuery query = scheduler.getConferenceQuery();
        LocalTime startTime1 = query.getStartTime(talk1);
        LocalTime startTime2 = query.getStartTime(talk2);
        assertThat(Boolean.FALSE, is(startTime1.equals(startTime2)));
        assertThat(Math.abs(startTime1.getHour() - startTime2.getHour())
                , greaterThanOrEqualTo(1));

    }

    @Test
    public void scheduleTwoTaskInTowDifferentSession() {
        String talk1 = "Writing Fast Tests Against Enterprise Rails 180min";
        String talk2 = "Overdoing it in Python 60min";
        ConferenceScheduler scheduler = new ConferenceScheduler();
        scheduler.addTask(talk1);
        scheduler.addTask(talk2);
        scheduler.scheduleTasks();
        ConferenceScheduler.ConferenceQuery query = scheduler.getConferenceQuery();
        LocalTime startTime1 = query.getStartTime(talk1);
        LocalTime startTime2 = query.getStartTime(talk2);
        assertThat(Boolean.FALSE, is(startTime1.equals(startTime2)));
        assertThat(Math.abs(startTime1.getHour() - startTime2.getHour())
                , greaterThanOrEqualTo(4));
    }

    @Test
    public void scheduleNetworkEventAfterFourInTheEvening() {
        String talk1 = "Writing Fast Tests Against Enterprise Rails 180min";
        String talk2 = "Overdoing it in Python 180min";
        String talk3 = "Overdoing it in java 30min";
        ConferenceScheduler scheduler = new ConferenceScheduler();
        scheduler.addTask(talk1);
        scheduler.addTask(talk2);
        scheduler.addTask(talk3);
        scheduler.scheduleTasks();
        ConferenceScheduler.ConferenceQuery query = scheduler.getConferenceQuery();
        LocalTime networkStartTime = query.getStartTime("Networking Event");
        assertThat(networkStartTime
                , is(equalTo(LocalTime.of(16, 30))));
    }

    @Test
    public void scheduleEventsMoreThanSingleTrack() {
        String talk1 = "Writing Fast Tests Against Enterprise Rails 180min";
        String talk2 = "Overdoing it in Python 180min";
        String talk3 = "Overdoing it in java 30min";
        String talk4 = "Overdoing it in .Net 80min";
        ConferenceScheduler scheduler = new ConferenceScheduler();
        scheduler.addTask(talk1);
        scheduler.addTask(talk2);
        scheduler.addTask(talk3);
        scheduler.addTask(talk4);
        scheduler.scheduleTasks();
        ConferenceScheduler.ConferenceQuery query = scheduler.getConferenceQuery();
        String trackName = query.getTrackName(talk4);
        assertThat(trackName, is(equalTo("Track2")));
        assertThat(LocalTime.of(9, 00).compareTo(query.getStartTime(talk4)),
                anyOf(equalTo(0), equalTo(-1)));
    }



    @Test
    public void scheduleLightningEvents() {
        String talk1 = "Rails for Python Developers lightning";
        String talk2 = "Rails for Java Developers lightning";
        ConferenceScheduler scheduler = new ConferenceScheduler();
        scheduler.addTask(talk1);
        scheduler.addTask(talk2);
        scheduler.scheduleTasks();
        ConferenceScheduler.ConferenceQuery query = scheduler.getConferenceQuery();
        LocalTime startTime1 = query.getStartTime(talk1);
        LocalTime startTime2 = query.getStartTime(talk2);
        assertThat(Boolean.FALSE, is(startTime1.equals(startTime2)));
      long timeDiff = Math.abs(Duration.between(startTime1, startTime2).get(SECONDS));
        assertThat(Long.valueOf(timeDiff).intValue() , greaterThanOrEqualTo(300));

    }

    @Test
    public void testIfInvalidEventNameIsAddedToConference() {
        String talk1 = "Writing Fast Tests Against Enterprise Rails 180";
        ConferenceScheduler scheduler = new ConferenceScheduler();
        assertThat(scheduler.addTask(talk1), is(equalTo(Boolean.FALSE)));
      //  scheduler.addTask(talk1);
    }

    @Test
    public void testValidEventNameIsAddedToConference() {
        String talk1 = "Writing Fast Tests Against Enterprise Rails 180min";
        String talk2 = "Rails for Java Developers lightning";
        String talk3 = "Rails for Java Developers";

        ConferenceScheduler scheduler = new ConferenceScheduler();
        assertThat(scheduler.addTask(talk1), is(equalTo(Boolean.TRUE)));
        assertThat(scheduler.addTask(talk3), is(equalTo(Boolean.FALSE)));
        assertThat(scheduler.addTask(talk2), is(equalTo(Boolean.TRUE)));

    }
}