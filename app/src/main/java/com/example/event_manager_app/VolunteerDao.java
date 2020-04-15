package com.example.event_manager_app;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface VolunteerDao {
    @Query("SELECT * FROM volunteer_table where volunteer_table.email_coord = :email")
    LiveData<List<Volunteer>> getAllVolunteers(String email);

    @Insert
    void insert(Volunteer v);

    @Query("UPDATE volunteer_table SET noOfHoursPublicity=:no_hours_publicty where vid=:id ")
    void update_hours(int id , int no_hours_publicty);

}
