package com.chalykh.MeetingRoom.dao;

import com.chalykh.MeetingRoom.domain.User;

public interface UserDao {


    public User getById(int id);
    public String getPassword(String name); // get password from DB by name

}
