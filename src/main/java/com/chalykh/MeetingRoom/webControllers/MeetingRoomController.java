package com.chalykh.MeetingRoom.webControllers;


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

    @Autowired
    public MeetingRoomController(CreateDateAndTime dateAndTime){
        this.dateAndTime = dateAndTime;
    }

    @GetMapping()
    public String meetingRoom(Model model){

        ReservInfo reservInfo = new ReservInfo();

        model.addAttribute("reservInfo", reservInfo);
        model.addAttribute("reservTimeList", reservInfo.getTimeOfDay() );
        model.addAttribute("reserveList", dateAndTime.getReserveList());
        return "tableRoom.html";
    }

    @PostMapping()
    public String reserve(@ModelAttribute("reservInfo")ReservInfo reservInfo, Model mode){

        Reserv reserv = new Reserv();
        reserv.setStartTime(reservInfo.getStartTime());
        reserv.setStopTime(reservInfo.getStopTime());

        System.out.println(reserv.getStartTime() + " " + reserv.getStopTime());

        return "redirect:/meetingRoom";
    }


}
