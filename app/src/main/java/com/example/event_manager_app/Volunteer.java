package com.example.event_manager_app;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Volunteer {
    @PrimaryKey()
    String vid;
    @ColumnInfo
    String name;
    @ColumnInfo
    String email;
    @ColumnInfo
    String email_coord;

    public Volunteer() {

    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_coord() {
        return email_coord;
    }

    public void setEmail_coord(String email_coord) {
        this.email_coord = email_coord;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    @ColumnInfo
    long number;

}
