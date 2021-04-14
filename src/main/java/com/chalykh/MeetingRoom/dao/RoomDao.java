package com.chalykh.MeetingRoom.dao;

import com.chalykh.MeetingRoom.domain.Reserv;

import java.util.List;

public interface RoomDao {

    public long insert(Reserv reserv);

    public List<Reserv> getAll();

}
