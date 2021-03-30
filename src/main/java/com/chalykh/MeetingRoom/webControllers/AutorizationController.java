package com.chalykh.MeetingRoom.webControllers;

import com.chalykh.MeetingRoom.dao.UserDao;
import com.chalykh.MeetingRoom.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String index(@ModelAttribute("user") User user, Model model){


        userDao.getPassword("Yevgeniy");



       // model.addAttribute("name", "Yevgeniy");
        return "loginUser.html";
    }

    @PostMapping()
    public String goToRoom(@ModelAttribute("user") User user){


        System.out.println(user.getPassword());
        return "room.html";
    }

}
