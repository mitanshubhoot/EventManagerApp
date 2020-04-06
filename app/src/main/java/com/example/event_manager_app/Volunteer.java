package com.example.event_manager_app;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = Volunteer.volunteer)
public class Volunteer {
    @PrimaryKey(autoGenerate = true)
    int vid;
    @ColumnInfo
    String name;
    @ColumnInfo
    String email;
    @ColumnInfo
    String email_coord;
    @ColumnInfo
    int noOfHoursPublicity;
    @ColumnInfo
    long number;

    public static final  String volunteer = "Volunteer_table";


    public Volunteer( String name, String email, String email_coord, long number , int noOfHoursPublicity) {
        this.vid = vid;
        this.name = name;
        this.email = email;
        this.email_coord = email_coord;
        this.number = number;
        this.noOfHoursPublicity = noOfHoursPublicity;

    }

    public int getNoOfHoursPublicity() {
        return noOfHoursPublicity;
    }

    public void setNoOfHoursPublicity(int noOfHoursPublicity) {
        this.noOfHoursPublicity = noOfHoursPublicity;
    }

    public static String getVolunteer() {
        return volunteer;
    }
    @Ignore
    public Volunteer() {

    }

    public int getVid() {
        return vid;
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


}
