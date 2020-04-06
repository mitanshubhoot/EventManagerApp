package com.example.event_manager_app;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface CoordinatorDao {
    @Insert
    void insert(Coordinator c);


}
