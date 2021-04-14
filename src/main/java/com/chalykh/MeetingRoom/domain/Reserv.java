package com.chalykh.MeetingRoom.domain;

import java.util.ArrayList;
import java.util.List;

public class Reserv {

    private String startTime;
    private String stopTime;
    private List<String> timeOfDay;
    private String currentDate;


    public Reserv(String startTime, String stopTime, String currentDate) {
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.currentDate = currentDate;
    }

    public Reserv(){

        timeOfDay = new ArrayList<>(24);

        for(int i = 0 ; i <= 24; i++){

            if(i < 10)
                timeOfDay.add(String.format("00:%02d", i));
            else
                timeOfDay.add(String.format("%02d:00", i));

        }


    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    public List<String> getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(List<String> timeOfDay) {
        this.timeOfDay = timeOfDay;
    }
}
