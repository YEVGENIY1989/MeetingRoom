package com.chalykh.MeetingRoom.domain;

import java.util.ArrayList;
import java.util.List;

public class ReservInfo {

    private List<String> timeOfDay;
    private String startTime;
    private String stopTime;

    public ReservInfo(){

        timeOfDay = new ArrayList<>(24);

        for(int i = 0 ; i <= 24; i++){

            if(i < 10)
                timeOfDay.add(String.format("00:%02d", i));
            else
                timeOfDay.add(String.format("%02d:00", i));

        }

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
}
