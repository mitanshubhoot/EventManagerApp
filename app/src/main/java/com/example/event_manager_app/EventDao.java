package com.example.event_manager_app;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EventDao {

    @Insert
    void insert(Event e);


    @Query("SELECT * FROM events_table WHERE event_code IN (:codes) ")
    List<Event> getEvents(List<String> codes);
}
