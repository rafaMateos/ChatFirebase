package com.example.rmateos.preguntadosrafa.BussinesLogic;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.example.rmateos.preguntadosrafa.Models.Email;

import com.example.rmateos.preguntadosrafa.RoomDatabase.AppDatabase;

import java.util.List;

public class Repository {


    public void InsertEmail(Email email, Context context){

         AppDatabase.getInstanceDatabase(context).getQuestionDAO().insertEmail(email);

    }

    public void Update (Email email, Context contex){

        AppDatabase.getInstanceDatabase(contex).getQuestionDAO().updateEmail(email);

    }

    public void delete (Email email, Context contex){

        AppDatabase.getInstanceDatabase(contex).getQuestionDAO().deleteEmail(email);

    }

    public LiveData<List<Email>> selectEmail (Context context){

        return AppDatabase.getInstanceDatabase(context).getQuestionDAO().getListEmail();

    }

}
