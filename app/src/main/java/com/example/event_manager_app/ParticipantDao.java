package com.example.event_manager_app;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ParticipantDao {
    @Insert
    void insert(Participant p);



    @Query("SELECT COUNT(*) FROM participants_table")
    int count_participants();

    @Query("SELECT DISTINCT(event_code) FROM participants_table where participants_table.email = :email")
    List<String> getEventCodes(String email);


    @Query("SELECT * FROM participants_table")
    LiveData<List<Participant>> getParticipants();

    @Query("UPDATE participants_table SET attendance= :attendance where id=:id")
    void AttendanceUpdater(boolean attendance , int id);

}
