package com.example.event_manager_app;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import static com.example.event_manager_app.UserAccount.TABLE_NAME;




@Entity(tableName = TABLE_NAME)
public class UserAccount {

    public static final String TABLE_NAME = "useraccounts";

    @PrimaryKey(autoGenerate = true)
    int userid;
    @NonNull
    String email;
    int cid;
    int pid;

    public int getUserid() {
        return userid;
    }

    int vid;
    String password;
    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public UserAccount()
    {

    }
    public UserAccount(String email, String pwd)
    {
        this.email = email;
        this.password = pwd;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public int getCid() {
        return cid;
    }

    public int getPid() {
        return pid;
    }

    public int getVid() {
        return vid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }
}