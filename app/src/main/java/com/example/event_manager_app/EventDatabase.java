package com.example.event_manager_app;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities ={Event.class} , version = 1)
public abstract class EventDatabase extends RoomDatabase {
    public abstract EventDao EventDao();
    public static EventDatabase INSTANCE;

    public static synchronized EventDatabase getEventDatabase(Context context)
    {
        if(INSTANCE == null)
        {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), EventDatabase.class, "Event-database").fallbackToDestructiveMigration().addCallback(roomcallback).build();
        }

        return INSTANCE;

    }

    public static void destroyInstance()
    {
        INSTANCE = null;
    }

    public static RoomDatabase.Callback roomcallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(INSTANCE).execute();
        }
    };
    public static class PopulateDbAsyncTask extends AsyncTask<Void , Void , Void >{
        private EventDao eventDao;

        public PopulateDbAsyncTask(EventDatabase db) {
            this.eventDao = db.EventDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Event e1 = new Event("TC-01","Hackathon","oswalsakshi17@gmail.com",70000 , 50000 , 400 , "12/9/2020","Room : 1323A" , "Technical");
            Event e2 = new Event("TC-02","Competetive-Coding","oswalsakshi17@gmail.com",90000 , 30000 , 200 , "15/9/2020","Room : 1324D" , "Technical");
            eventDao.insert(e1);
            eventDao.insert(e2);
            return null;
        }
    }

}
