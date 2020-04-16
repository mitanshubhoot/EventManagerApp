package com.example.event_manager_app;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import static com.example.event_manager_app.Participant.participants;

@Entity(tableName = participants)
public class Participant {
    @NonNull
    @ColumnInfo
    String name;

    @NonNull
    @ColumnInfo
    String event_code;
    @ColumnInfo
    String college;

    public int getId() {
        return id;
    }
    @NonNull
    @ColumnInfo
    String year;
    @NonNull
    @PrimaryKey(autoGenerate = true)
    int id ;
    @NonNull
    @ColumnInfo
    String email;

    @NonNull
    @ColumnInfo
    long contact;

    @ColumnInfo
    boolean attendance;


    public static final  String participants = "participants_table";

    @Ignore
    public Participant() {

    }

    public Participant(String name , String event_code, String college, String year ,String email , long contact ) {
        this.name = name;
        this.event_code = event_code;
        this.college = college;
        this.year = year;
        this.email = email;
        this.contact = contact;
        this.attendance = false;

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

    public boolean isAttendance() {
        return attendance;
    }


    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }

    public String getEvent_code() {
        return event_code;
    }

    public void setEvent_code(String event_code) {
        this.event_code = event_code;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
