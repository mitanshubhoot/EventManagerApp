package com.example.event_manager_app;

import androidx.lifecycle.LiveData;

import java.util.List;


public class ParticipantRepository {

    private final ParticipantDao participantDao;
    private static ParticipantRepository instance;
    private LiveData<Participant> participantLiveData;

    private ParticipantRepository(ParticipantDao participantDao)
    {
        this.participantDao = participantDao;
    }

    public static ParticipantRepository getInstance(ParticipantDao participantDao)
    {
        if(instance == null)
        {
            instance = new ParticipantRepository(participantDao);
        }
        return instance;
    }

    public void insertParticipant(String name ,String event_code, String college,String year,String email,long contact)
    {
        Participant p = new Participant(name , event_code , college , year , email , contact);
        participantDao.insert(p);
    }
    public int getCountParticipants()
    {
        return participantDao.count_participants();
    }
    public List<String> getEventCodes(String email)
    {
        return participantDao.getEventCodes(email);
    }

    public void  AttendanceUpdater(boolean attendance , int id)
    {
        participantDao.AttendanceUpdater(attendance , id);
    }

    public LiveData<List<Participant>> getParticipants()
    {
        return participantDao.getParticipants();
    }
}