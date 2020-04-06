package com.example.event_manager_app;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Coordinator.class , version = 1)
public abstract class CoordinatorDatabase extends RoomDatabase {
    public abstract CoordinatorDao coordinatorDao();
    public static CoordinatorDatabase INSTANCE;
    public static CoordinatorDatabase getCoordinatorDatabase(Context context)
    {
        if(INSTANCE==null)
        {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext() , CoordinatorDatabase.class , "Coordinator-Database").fallbackToDestructiveMigration().addCallback(roomcallback).allowMainThreadQueries().build();


        }
        return INSTANCE;
    }

    public static RoomDatabase.Callback roomcallback = new RoomDatabase.Callback()
    {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateCoordinatordb(INSTANCE).execute();
        }
    };

    public static class PopulateCoordinatordb extends AsyncTask<Void , Void , Void >
    {
        public CoordinatorDao coordinatorDao;
        public PopulateCoordinatordb (CoordinatorDatabase db)
        {
            coordinatorDao = db.coordinatorDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            Coordinator v1 = new Coordinator("oswalsakshi17@gmail.com","Sakshi Oswal",7796534008l);
            Coordinator v3 = new Coordinator("muzammil.rahimi18@vit.edu","Muzammil Rahimi",9890498401l);
            Coordinator v4 = new Coordinator("jitendra.navigmare18@vit.edu","Jitendra Navigmare",9420362919l);
            coordinatorDao.insert(v1);
            coordinatorDao.insert(v3);
            coordinatorDao.insert(v4);

            return null;
        }

        public static void destroyInstance()
        {
            INSTANCE = null;
        }
    }
}
