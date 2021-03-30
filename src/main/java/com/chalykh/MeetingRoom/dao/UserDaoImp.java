package com.chalykh.MeetingRoom.dao;

import com.chalykh.MeetingRoom.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImp implements UserDao {

    private final NamedParameterJdbcOperations jdbcOperations;

    @Autowired
    public UserDaoImp(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }


    @Override
    public User getById(int id) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("id", id);
        User user = jdbcOperations.queryForObject("select * from user_meeting_room where user_id= :id",
                params, new UserMapper());

        return user;

    }

    @Override
    public String getPassword(String name) {

        final Map<String, Object> params = new HashMap<>(1);

        params.put("names", name);

        User user = jdbcOperations.queryForObject("select * from user_meeting_room where name= :names",
                params, new UserMapper());

        System.out.println(user.getPassword());

        return null;
    }



    private static class UserMapper implements RowMapper<User> {


        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");
            return new User(name, password);
        }
    }


}
