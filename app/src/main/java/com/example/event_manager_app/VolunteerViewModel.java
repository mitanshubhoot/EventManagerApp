package com.example.event_manager_app;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

public class VolunteerViewModel extends ViewModel {
    private VolunteerRepository volunteerRepository;
    public VolunteerViewModel(Context context)
    {
        volunteerRepository = volunteerRepository.getInstance(VolunteerDatabase.getVolunteerDatabase(context).VolunteerDao());

    }
    public List<Volunteer> getAllVolunteers(String email)
    {
        return volunteerRepository.getAllVolunteers(email);

    }
    public static class Factory implements ViewModelProvider.Factory {
        private final Context ctxt;

        Factory(Context ctxt) {
            this.ctxt=ctxt.getApplicationContext();
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return((T)new VolunteerViewModel(ctxt));
        }
    }
}