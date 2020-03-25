package com.example.event_manager_app;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EventDao {
    @Query("SELECT * FROM events_table WHERE events_table.event_code IN (:codes)")
    LiveData<List<Event>> getAllEvents(List<String> codes);

    @Insert
    void insert(Event e);
}
