package com.example.event_manager_app;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import static com.example.event_manager_app.Coordinator.COORDINATOR_TABLE;


@Entity(tableName = COORDINATOR_TABLE)
public class Coordinator {


    public static final String COORDINATOR_TABLE = "Coordinators";

    @PrimaryKey
    @NonNull
    String email_coord;
    @ColumnInfo
    String name;
    @ColumnInfo
    long number;
    @ColumnInfo
    String Domain;

    @Ignore
    public Coordinator()
    {

    }

    public Coordinator(String email_coord, String name, long number) {
        this.email_coord = email_coord;
        this.name = name;
        this.number = number;
    }

    public static String getCoordinatorTable() {
        return COORDINATOR_TABLE;
    }

    public String getEmail_coord() {
        return email_coord;
    }

    public void setEmail_coord(String email_coord) {
        this.email_coord = email_coord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
}
