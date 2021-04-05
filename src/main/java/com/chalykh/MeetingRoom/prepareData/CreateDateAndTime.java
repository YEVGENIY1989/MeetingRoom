package com.chalykh.MeetingRoom.prepareData;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class CreateDateAndTime {

    private List<String> arrayDayOfWeek;
    private List<String> timeOfDay;
    private List<String> dateWeek;


    public CreateDateAndTime(){

        arrayDayOfWeek = new ArrayList<>(8);
        arrayDayOfWeek.add("Время");
        arrayDayOfWeek.add("  Понедельник");
        arrayDayOfWeek.add("  Вторник");
        arrayDayOfWeek.add("  Среда");
        arrayDayOfWeek.add("  Четверг");
        arrayDayOfWeek.add("  Пятница");
        arrayDayOfWeek.add("  Суббота");
        arrayDayOfWeek.add("  Воскресенье");

        timeOfDay = new ArrayList<>(7);

        updatesDateOfWeek();

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

    public List<String> getDateWeek() {
        return dateWeek;
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
