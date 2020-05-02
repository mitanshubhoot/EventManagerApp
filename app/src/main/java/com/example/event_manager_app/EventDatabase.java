package com.example.event_manager_app;

import android.app.Application;
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

    public static synchronized EventDatabase getEventDatabase(Application context)
    {
        if(INSTANCE == null)
        {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), EventDatabase.class,"Event-Database").allowMainThreadQueries().fallbackToDestructiveMigration().addCallback(roomcallback).build();
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
            Event e1 = new Event("TC-01","Hackathon",4,"oswalsakshi17@gmail.com",70000 , 50000 , 400 , "12/9/2020","Room : 1323A" , "Technical" , "This event is a hackathon to code,strategize and innovate some ingenious\n" +
                    "solutions to the most sought out real-life problem statements. This event is only for FY\n" +
                    "and SY students.");
            Event e2 = new Event("TC-02","Competetive-\nCoding",2,"oswalsakshi17@gmail.com",90000 , 30000 , 200 , "15/9/2020","Room : 1324D" , "Technical"," This event is a hackathon to code,strategize and innovate some ingenious\n" +
                    "solutions to the most sought out real-life problem statements. This event is only for TY\n" +
                    "and B-Tech students.");
            Event e3 = new Event("TC-03","Byte-Code",2,"oswalsakshi17@gmail.com",8000 , 3000 , 50 , "15/6/2020","Room : 2111" , "Technical"," This event will test your basic concepts of Python language and\n" +
                    "your programming skills.");
            Event e4 = new Event("TC-04","Cathalon",2,"oswalsakshi17@gmail.com",9000 , 4000 , 100 , "13/6/2020","Room : 1321D" , "Technical","This event will test your basic concepts of C and C++\n" +
                    "language and test your programming skills.");
            Event e5 = new Event("EC-01","Obstacle Race",2,"harjas.gandhi18@vit.edu",3000 , 1500 , 100 , "12/9/2020","Ground" , "Extra - Curricular" ,"This fast-paced race takes you through a series of physical obstacles, players must navigate through the obstacle while being timed. This obstacle course includes running, climbing, jumping, crawling and balancing elements with the aim of testing speed and endurance");
            Event e6 = new Event("EC-02","Treasure Hunt",2,"harjas.gandhi18@vit.edu",6000 , 4000 , 200 , "11/9/2020","Vit College" , "Extra - Curricular"," Adventurer’s set sail on a treasure hunt to find the one true treasure and take it all in the end, the hunt is on! The participants either take photographs of listed items or take on the challenge to complete the tasks given in the lists in the most creative manner. This search for the treasure involves a series of clues, solve one and move on to the other till you reach the very end faster than everyone to win it all.");
            Event e7 = new Event("EC-03","V-Rock",8,"samikshapatil18@gmail.com",10000 , 8000 , 300 , "10/9/2020","Audi" , "Extra - Curricular"," V-Rock is the ultimate battle of bands showcasing their creativity and unity through the art of music. Come and rock the stage with your talent and energize the crowd with your music!");
            Event e8 = new Event("EC-04","Footloose",9,"samikshapatil18@gmail.com",9000 , 5000 , 200 , "15/9/2020","Room : 1324D" , "Technical","Dance is the hidden language of the soul! You dance to express and not to impress! When you dance, you dance like nobody’s watching.\n" +
                    "\n" +
                    "Showcase your passion for dancing in this fun and challenging dance competition, Footloose.\n" +
                    "\n" +
                    " ");

            eventDao.insert(e1);
            eventDao.insert(e2);
            eventDao.insert(e3);
            eventDao.insert(e4);
            eventDao.insert(e5);
            eventDao.insert(e6);
            eventDao.insert(e7);
            eventDao.insert(e8);
            return null;
        }
    }

}
