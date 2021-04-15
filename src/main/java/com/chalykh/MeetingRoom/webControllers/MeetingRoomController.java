package com.chalykh.MeetingRoom.webControllers;


import com.chalykh.MeetingRoom.dao.RoomDao;
import com.chalykh.MeetingRoom.dao.RoomDaoImpl;
import com.chalykh.MeetingRoom.domain.Reserv;
import com.chalykh.MeetingRoom.domain.ReservInfo;
import com.chalykh.MeetingRoom.domain.User;
import com.chalykh.MeetingRoom.prepareData.CreateDateAndTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/meetingRoom")
public class MeetingRoomController {

    private CreateDateAndTime dateAndTime;
    private RoomDao roomDao;

    @Autowired
    public MeetingRoomController(CreateDateAndTime dateAndTime, RoomDao roomDao){
        this.dateAndTime = dateAndTime;
        this.roomDao = roomDao;
    }


    @PostMapping()
    public String reserve(@ModelAttribute("reservInfo")ReservInfo reservInfo, Model mode){

        Reserv reserv = new Reserv();
        reserv.setStartTime(reservInfo.getStartTime());
        reserv.setStopTime(reservInfo.getStopTime());
        reserv.setCurrentDate(reservInfo.getCurrentDate());

        roomDao.insert(reserv);

        System.out.println("In PostMapping " + reserv.getStartTime() + " " + reserv.getStopTime() + " " + reserv.getCurrentDate());

        return "redirect:/meetingRoom";
    }


    @GetMapping()
    public String meetingRoom(Model model){

        ReservInfo reservInfo = new ReservInfo();

        model.addAttribute("reservInfo", reservInfo);
        model.addAttribute("reservTimeList", reservInfo.getTimeOfDay() );
        model.addAttribute("dateWeek", reservInfo.getDateWeek());

        for(Reserv reserv : roomDao.getAll()){
            dateAndTime.setReserve(reserv);
        }

        model.addAttribute("reserveList", dateAndTime.getReserveList());

        for(Reserv reserv : roomDao.getAll()){
            System.out.println("in RowMapping " + reserv.getStartTime() + " " + reserv.getStopTime() + " " + reserv.getCurrentDate());
        }

        return "tableRoom.html";
    }



}
