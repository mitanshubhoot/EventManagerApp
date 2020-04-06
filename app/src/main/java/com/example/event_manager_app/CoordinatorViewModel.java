package com.example.event_manager_app;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class CoordinatorViewModel extends ViewModel {
    private CoordinatorRepository coordinatorRepository;
    public CoordinatorViewModel(Context context)
    {
        coordinatorRepository = coordinatorRepository.getInstance(CoordinatorDatabase.getCoordinatorDatabase(context).coordinatorDao());
    }
    public void insert(Coordinator c)
    {
        coordinatorRepository.insert(c);
    }
    public static class Factory implements ViewModelProvider.Factory {
        private final Context ctxt;

        Factory(Context ctxt) {
            this.ctxt=ctxt.getApplicationContext();
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return((T)new CoordinatorViewModel(ctxt));
        }
    }
}
