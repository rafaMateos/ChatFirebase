package com.example.rmateos.preguntadosrafa.ViewModels;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.example.rmateos.preguntadosrafa.BussinesLogic.Repository;
import com.example.rmateos.preguntadosrafa.Models.Question;

import java.util.List;

public class ViewModel extends android.arch.lifecycle.ViewModel {

    private Repository repository =  new Repository();
    private MutableLiveData<String> IntroQuestion;

    public void InsertarQuestion(Question question,Context context){

        repository.InsertQuest(question,context);

    }

    public MutableLiveData<String> getQuestion(){

        if(IntroQuestion == null){

            IntroQuestion = new MutableLiveData<String>();
        }

        return IntroQuestion;
    }
}
