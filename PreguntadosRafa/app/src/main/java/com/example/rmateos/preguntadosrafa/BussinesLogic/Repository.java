package com.example.rmateos.preguntadosrafa.BussinesLogic;

import android.content.Context;

import com.example.rmateos.preguntadosrafa.Models.Email;

import com.example.rmateos.preguntadosrafa.RoomDatabase.AppDatabase;

import java.util.List;

public class Repository {

    public void InsertQuest(Email email, Context context){

         AppDatabase.getInstanceDatabase(context).getQuestionDAO().insertEmail(email);

    }

    public Email[] selectEmail ( Context context){

        return AppDatabase.getInstanceDatabase(context).getQuestionDAO().getListEmail();

    }

}
