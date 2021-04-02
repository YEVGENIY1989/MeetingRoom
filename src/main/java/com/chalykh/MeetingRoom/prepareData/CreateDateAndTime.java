package com.chalykh.MeetingRoom.prepareData;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateDateAndTime {

    private List<String> arrayDayOfWeek;
    private List<String> timeOfDay;


    public CreateDateAndTime(){

        arrayDayOfWeek = new ArrayList<>(7);
        arrayDayOfWeek.add("Понедельник");
        arrayDayOfWeek.add("Вторник");
        arrayDayOfWeek.add("Среда");
        arrayDayOfWeek.add("Четверг");
        arrayDayOfWeek.add("Пятница");
        arrayDayOfWeek.add("Суббота");
        arrayDayOfWeek.add("Воскресенье");


    }


    public List<String> getArrayDayOfWeek() {
        return arrayDayOfWeek;
    }

    public void setArrayDayOfWeek(List<String> arrayDayOfWeek) {
        this.arrayDayOfWeek = arrayDayOfWeek;
    }

    public List<String> getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(List<String> timeOfDay) {
        this.timeOfDay = timeOfDay;
    }
}
