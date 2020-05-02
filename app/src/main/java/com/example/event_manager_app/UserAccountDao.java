package com.example.event_manager_app;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RoomWarnings;

@Dao

public interface UserAccountDao {

    @Insert

    void insert(UserAccount account);


    @Query("SELECT * FROM useraccounts WHERE useraccounts.email LIKE :email")
    UserAccount getAccount(String email);


    @Query("SELECT email FROM useraccounts WHERE useraccounts.email LIKE :email")
    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    String RegisterAccount(String email);
}