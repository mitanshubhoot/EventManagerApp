package com.example.event_manager_app;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface EventDao {
    @Transaction
    @Query("SELECT * FROM events_table WHERE events_table.event_code IN (:codes)")
    LiveData<List<Event>> getAllEvents(List<String> codes);

    @Insert
    void insert(Event e);

    @Query("SELECT * FROM events_table")
    List<Event> getInitialStatus();

    @Query("SELECT * FROM events_table WHERE events_table.event_code IN (SELECT DISTINCT(event_code) FROM participants_table where email_coord=:email)")
    LiveData<List<Event>> getEvents(String email);
}
