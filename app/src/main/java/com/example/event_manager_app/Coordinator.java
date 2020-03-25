package com.example.event_manager_app;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import static com.example.event_manager_app.Coordinator.COORDINATOR_TABLE;


@Entity(tableName = COORDINATOR_TABLE)
public class Coordinator {


    public static final String COORDINATOR_TABLE = "Coordinators";

    @PrimaryKey
    String email_coord;
    @ColumnInfo
    String name;
    @ColumnInfo
    String email;
    @ColumnInfo
    String Domainid;
    @ColumnInfo
    long number;

    public Coordinator()
    {

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDomainid() {
        return Domainid;
    }

    public void setDomainid(String domainid) {
        Domainid = domainid;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
}
