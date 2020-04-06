package com.example.event_manager_app;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Participant.class}, version = 1)
public abstract  class ParticipantDatabase extends RoomDatabase {
    public abstract ParticipantDao ParticipantDao();
    public static ParticipantDatabase INSTANCE;

    public static ParticipantDatabase getParticipantDatabase(Context context)
    {
        if(INSTANCE == null)
        {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ParticipantDatabase.class , "participant-database").allowMainThreadQueries().allowMainThreadQueries().build();

        }

        return INSTANCE;

    }

    public static void destroyInstance()
    {
        INSTANCE = null;
    }
}
