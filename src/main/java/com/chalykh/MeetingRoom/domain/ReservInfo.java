package com.chalykh.MeetingRoom.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ReservInfo {

    private List<String> timeOfDay;
    private String startTime;
    private String stopTime;
    private List<String> dateWeek;
    private String currentDate;

    public ReservInfo(){

        timeOfDay = new ArrayList<>(24);

        for(int i = 0 ; i <= 24; i++){

            if(i < 10)
                timeOfDay.add(String.format("00:%02d", i));
            else
                timeOfDay.add(String.format("%02d:00", i));

        }

        updatesDateOfWeek();

    }

    public List<String> getDateWeek() {
        return dateWeek;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public void updatesDateOfWeek(){

        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateWeek = new ArrayList<>(7);
        dateWeek.add(dateFormat.format(date));

        for(int i = 1; i < 7 ; i++){
            cal.add(Calendar.DAY_OF_WEEK, 1);
            date = cal.getTime();
            dateWeek.add(dateFormat.format(date));
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
