package com.chalykh.MeetingRoom.webControllers;

import com.chalykh.MeetingRoom.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AutorizationController {


    private UserDao userDao;

    @Autowired
    public AutorizationController(UserDao userDao){
        this.userDao = userDao;
    }

    @GetMapping
    public String index(Model model){


        userDao.getPassword("Yevgeniy");

        model.addAttribute("name", "Yevgeniy");
        return "login.html";
    }

}
