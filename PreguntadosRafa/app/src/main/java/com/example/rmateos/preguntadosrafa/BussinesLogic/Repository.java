package com.example.rmateos.preguntadosrafa.BussinesLogic;

import android.content.Context;

import com.example.rmateos.preguntadosrafa.Models.Question;
import com.example.rmateos.preguntadosrafa.RoomDatabase.AppDatabase;

import java.util.List;

public class Repository {

    public void InsertQuest(Question question, Context context){

         AppDatabase.getInstanceDatabase(context).getQuestionDAO().insertQuestion(question);

    }

    public Question[] select ( Context context){

        return AppDatabase.getInstanceDatabase(context).getQuestionDAO().getListQuestion();

    }

}
