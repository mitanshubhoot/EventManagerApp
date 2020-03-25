package com.example.event_manager_app;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


public class LoginViewModel extends ViewModel {

    private UserRepository userRepository;

    public LoginViewModel(Context context) {

        userRepository = UserRepository.getInstance(UserAccountDatabase.getAppDatabase(context).userAccountDao());
    }

    void createUser(String email, String password)
    {
        userRepository.insertUser(email, password);
    }

    boolean checkValidLogin(String email, String password)
    {
        return userRepository.isValidAccount(email, password);
    }
    boolean checkValidRegister(String email)
    {
        return userRepository.isValidRegister(email);
    }

    public static class Factory implements ViewModelProvider.Factory {
        private final Context ctxt;

        Factory(Context ctxt) {
            this.ctxt=ctxt.getApplicationContext();
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return((T)new LoginViewModel(ctxt));
        }
    }
}