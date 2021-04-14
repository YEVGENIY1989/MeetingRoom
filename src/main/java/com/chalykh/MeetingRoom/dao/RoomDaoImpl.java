package com.chalykh.MeetingRoom.dao;

import com.chalykh.MeetingRoom.domain.Reserv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RoomDaoImpl implements RoomDao {


    private final NamedParameterJdbcOperations jdbcOperations;

    @Autowired
    public RoomDaoImpl(NamedParameterJdbcOperations jdbcOperations){

        this.jdbcOperations = jdbcOperations;

    }


    @Override
    public long insert(Reserv reserv) {

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("user_id", 1);
        params.addValue("start_time", reserv.getStartTime());
        params.addValue("stop_time", reserv.getStopTime());
        params.addValue("date", reserv.getCurrentDate());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update("insert into reserv_info(start_time, stop_time,reserv_date, user_id) " +
                "values (:start_time, :stop_time, :date, :user_id)", params, keyHolder);
        return 1;
    }

    @Override
    public List<Reserv> getAll() {

        String sqlQuery = " select start_time, stop_time, reserv_date from reserv_info";

        return jdbcOperations.query(sqlQuery, new RoomDaoMapper());
    }


    private static class RoomDaoMapper implements RowMapper<Reserv>{

        @Override
        public Reserv mapRow(ResultSet resultSet, int i) throws SQLException {
            String startTime = resultSet.getString("start_time");
            String stopTime = resultSet.getString("stop_time");
            String currentDate = resultSet.getString("reserv_date");
            Reserv reserv = new Reserv(startTime, stopTime, currentDate);
            return reserv;
        }
    }

}
