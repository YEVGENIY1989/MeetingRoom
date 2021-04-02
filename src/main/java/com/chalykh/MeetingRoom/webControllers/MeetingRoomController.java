package com.chalykh.MeetingRoom.webControllers;


import com.chalykh.MeetingRoom.prepareData.CreateDateAndTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("meetingRoom")
public class MeetingRoomController {


    private CreateDateAndTime createDateAndTime;

    @Autowired
    public MeetingRoomController(CreateDateAndTime createDateAndTime){

        this.createDateAndTime = createDateAndTime;


    }

    @GetMapping
    public String meetingRoom(Model model){


        model.addAttribute("day", createDateAndTime.getArrayDayOfWeek());


        return "room.html";
    }

}
