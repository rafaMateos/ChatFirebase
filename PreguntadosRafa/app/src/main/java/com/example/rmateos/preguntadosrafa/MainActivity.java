package com.example.rmateos.preguntadosrafa;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.rmateos.preguntadosrafa.BussinesLogic.Repository;
import com.example.rmateos.preguntadosrafa.Models.Question;
import com.example.rmateos.preguntadosrafa.ViewModels.ViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewModel mViewModel;
    EditText questionIntro;
    ArrayList<Long> ret =  new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionIntro =  findViewById(R.id.question);

        mViewModel = ViewModelProviders.of(this).get(ViewModel.class);

        final Observer<String> questionObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {


            }
        };

        mViewModel.getQuestion().observe(this,questionObserver);

    }

    public void ClickGuardar(View view){

        String anwers = questionIntro.getText().toString();
        Question question =  new Question();

        question.setQuestion_body(questionIntro.getText().toString());
        question.setId(0);
        question.setAnwers(anwers);


        Repository gest = new Repository();
        gest.InsertQuest(question,view.getContext());


    }
}
