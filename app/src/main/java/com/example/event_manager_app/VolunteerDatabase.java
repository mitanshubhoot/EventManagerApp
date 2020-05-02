package com.example.event_manager_app;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;




@Database(entities = Volunteer.class , version = 1)



public abstract class VolunteerDatabase extends RoomDatabase {
    public abstract VolunteerDao VolunteerDao();
    public static VolunteerDatabase INSTANCE;






    public static VolunteerDatabase getVolunteerDatabase(Context context)
    {
        if(INSTANCE == null)
        {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), VolunteerDatabase.class, "Volunteer-database").fallbackToDestructiveMigration().addCallback(roomcallback).allowMainThreadQueries().build();

        }

        return INSTANCE;

    }

    public static RoomDatabase.Callback roomcallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateVolunteerDB(INSTANCE).execute();
        }
    };

    public static class PopulateVolunteerDB extends AsyncTask<Void ,Void ,Void>
    {
        private VolunteerDao volunteerDao;
        public PopulateVolunteerDB(VolunteerDatabase db)
        {
            this.volunteerDao = db.VolunteerDao();
        }

        @Override


        protected Void doInBackground(Void... voids) {
            Volunteer v1 = new Volunteer("Ashok Gandhi","ashok.gandhi18@vit.edu","oswalsakshi17@gmail.com",7796534008l,0);
            Volunteer v2 = new Volunteer("Dev Patil","dev.patil17@vit.edu","oswalsakshi17@gmail.com",6702394567l,0);
            Volunteer v3 = new Volunteer("Rohan Shinde ","rohan.shinde19@vit.edu","oswalsakshi17@gmail.com",9987045934l,0);
            Volunteer v4 = new Volunteer("Isha Deol","isha.deol18@vit.edu","oswalsakshi17@gmail.com",9987603421l,0);
            Volunteer v5 = new Volunteer("Disha Agarwal","disha.agarwal@gmail.com","oswalsakshi17@gmail.com",7794502167l,0);
            Volunteer v6 = new Volunteer("Sameer Khatri","sameer.khatri14@gmail.com","oswalsakshi17@gmail.com",6945602219l,0);
            Volunteer v7 = new Volunteer("Rishab Ahuja","rishab.ahuja12@gmail.com","oswalsakshi17@gmail.com",9934120357l,0);
            Volunteer v8 = new Volunteer("Anand Jagdale","anand.jagdale17@gmail.com","oswalsakshi17@gmail.com",6978012456l,0);
            Volunteer v9 = new Volunteer("Arya Patil","arya.patil18@vit.edu","oswalsakshi17@gmail.com",8904673305l,0);
            Volunteer v10 = new Volunteer("Vishesh Jha","vishesh.jha1993@gmail.com","oswalsakshi17@gmail.com",98788645312l,0);
            Volunteer v11 = new Volunteer("Sumit Jain","sumit.jain16@vit.edu","oswalsakshi17@gmail.com",967942118455l,0);



            volunteerDao.insert(v1);
            volunteerDao.insert(v2);
            volunteerDao.insert(v3);
            volunteerDao.insert(v4);
            volunteerDao.insert(v5);
            volunteerDao.insert(v6);
            volunteerDao.insert(v7);
            volunteerDao.insert(v8);
            volunteerDao.insert(v9);
            volunteerDao.insert(v10);
            volunteerDao.insert(v11);



            return null;


        }
    }


    public static void destroyInstance()
    {
        INSTANCE = null;
    }


}

