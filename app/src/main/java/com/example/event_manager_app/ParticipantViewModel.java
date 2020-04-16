package com.example.event_manager_app;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

public class ParticipantViewModel extends ViewModel {
    private ParticipantRepository participantRepository;

    public ParticipantViewModel(Context context)
    {
        participantRepository = ParticipantRepository.getInstance(ParticipantDatabase.getParticipantDatabase(context).ParticipantDao());

    }
    public void addParticipant(String name ,String event_code, String college,String year,String email,long contact)
    {
        participantRepository.insertParticipant(name , event_code , college , year , email , contact);
    }
    public int  GetCountParticipant()
    {
        return participantRepository.getCountParticipants();
    }
    public List<String> getEventCodes(String email)
    {
        return participantRepository.getEventCodes(email);
    }
    public LiveData<List<Participant>> getParticipants()
    {
        return participantRepository.getParticipants();
    }
    public void  AttendanceUpdater(boolean attendance , int id)
    {
        participantRepository.AttendanceUpdater(attendance , id);
    }

    public static class Factory implements ViewModelProvider.Factory {
        private final Context ctxt;

        Factory(Context ctxt) {
            this.ctxt=ctxt.getApplicationContext();
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return((T)new ParticipantViewModel(ctxt));
        }
    }
}
