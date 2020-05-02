package com.example.event_manager_app;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import static com.example.event_manager_app.Event.table_name;


@Entity(tableName = table_name)
public class Event {

    @NonNull
    @PrimaryKey
    String event_code;
    @ColumnInfo
    String event_name;
    @ColumnInfo
    String email_coord;
    @ColumnInfo
    long Winner_prize;
    @ColumnInfo
    long Runner_prize;
    @ColumnInfo
    long entry_fee;
    @ColumnInfo
    String date;
    @ColumnInfo
    String venue;
    @ColumnInfo
    String domain;



    public static String getTable_name() {
        return table_name;
    }



    public static final String table_name = "events_table";




    public String getDomain() {
        return domain;
    }


    public void setDomain(String domain) {
        this.domain = domain;
    }


    public Event() {

    }

    public Event(String event_code ,String event_name ,String email_coord ,long winner_prize,long runner_prize ,long entry_fee ,String date , String venue , String domain)
    {

        this.event_name = event_name;
        this.event_code = event_code;
        this.email_coord = email_coord;
        this.Winner_prize = winner_prize;
        this.Runner_prize = runner_prize;
        this.entry_fee = entry_fee;
        this.date = date ;
        this.venue = venue;
        this.domain = domain;
    }


    public String getEvent_code() {
        return event_code;
    }

    public void setEvent_code(String event_code) {
        this.event_code = event_code;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getEmail_coord() {
        return email_coord;
    }

    public void setEmail_coord(String email_coord) {
        this.email_coord = email_coord;
    }

    public long getWinner_prize() {
        return Winner_prize;
    }

    public void setWinner_prize(long winner_prize) {
        Winner_prize = winner_prize;
    }

    public long getRunner_prize() {
        return Runner_prize;
    }

    public void setRunner_prize(long runner_prize) {
        Runner_prize = runner_prize;
    }

    public long getEntry_fee() {
        return entry_fee;
    }

    public void setEntry_fee(long entry_fee) {
        this.entry_fee = entry_fee;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
}
