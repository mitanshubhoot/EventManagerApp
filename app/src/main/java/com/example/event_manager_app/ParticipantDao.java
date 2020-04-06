package com.example.event_manager_app;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ParticipantDao {
    @Insert
    void insert(Participant p);
    @Insert
    void insert(Participant... partcipants);



    @Query("SELECT COUNT(*) FROM participants_table")
    int count_participants();

    @Query("SELECT DISTINCT(event_code) FROM participants_table where participants_table.email = :email")
    List<String> getEventCodes(String email);

    @Query("SELECT * FROM participants_table")
    List<Participant> getParticipants();

}
