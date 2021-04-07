package com.chalykh.MeetingRoom.webControllers;


import com.chalykh.MeetingRoom.prepareData.CreateDateAndTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

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

        model.addAttribute("reserveList", dateAndTime.getReserveList());


        return "tableRoom.html";
    }

}
