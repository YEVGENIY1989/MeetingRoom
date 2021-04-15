package com.chalykh.MeetingRoom.prepareData;

import com.chalykh.MeetingRoom.domain.Reserv;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class CreateDateAndTime {

    private List<String> arrayDayOfWeek;
    private List<String> timeOfDay;
    private List<String> dateWeek;
    private Map<String, Map<String, Boolean>> reserveList;
    private Reserv reserv;


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

        timeOfDay = new ArrayList<>(24);

        for(int i = 0 ; i <= 24; i++){

            if(i < 10)
                timeOfDay.add(String.format("00:%02d", i));
            else
                timeOfDay.add(String.format("%02d:00", i));

        }

        updatesDateOfWeek();
        createReserve();

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


    public void createReserve(){

        reserveList = new TreeMap<>();


        for(int i = 0; i < timeOfDay.size(); i++){

            TreeMap<String, Boolean> ceil = new TreeMap<>();
            boolean bool;
            for(int j = 0; j < 7; j++ ){
                String str = dateWeek.get(j);
                ceil.put(str, false);
            }
            String str = timeOfDay.get(i);
            reserveList.put(str, ceil);

        }


        /*for (String s : reserveList.keySet()){
            Map<String, Boolean> map = reserveList.get(s);
            for (String s1 : map.keySet()){
                System.out.println(map.get(s1));
            }
        }*/

    }

    public void setReserve(Reserv reserve){



    }

    public Map<String, Map<String, Boolean>> getReserveList() {
        return reserveList;
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
