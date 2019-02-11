package com.example.rmateos.preguntadosrafa.ViewModels;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.rmateos.preguntadosrafa.BussinesLogic.Repository;
import com.example.rmateos.preguntadosrafa.Models.Email;

import java.util.List;

public class ViewModel extends AndroidViewModel {

private Repository repository;
private LiveData<List<Email>> allEmails;

    public ViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository();
         allEmails = repository.selectEmail(application.getBaseContext());
    }

    public void insert(Email email, Context context){

        repository.InsertEmail(email,context);
    }

    public void update(Email email,Context context){
        repository.Update(email,context);
    }

    public void delete(Email email,Context context){
        repository.delete(email,context);
    }

    public LiveData<List<Email>> getAllEmails(Context context){

        return repository.selectEmail(context);
    }

}
