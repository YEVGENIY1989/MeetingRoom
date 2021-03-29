package com.chalykh.MeetingRoom.webControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AutorizationController {


    @GetMapping
    public String index(Model model){
        model.addAttribute("name", "Yevgeniy");
        return "login.html";
    }

}
