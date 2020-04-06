package com.example.event_manager_app;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface VolunteerDao {
    @Query("SELECT * FROM volunteer_table where volunteer_table.email_coord = :email")
    List<Volunteer> getAllVolunteers(String email);

    @Insert
    void insert(Volunteer v);
    /*
    @Update("MODIFY")
    void update(); */

}
