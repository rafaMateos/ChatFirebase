package com.example.rmateos.preguntadosrafa;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.rmateos.preguntadosrafa.BussinesLogic.Repository;
import com.example.rmateos.preguntadosrafa.Models.Question;
import com.example.rmateos.preguntadosrafa.ViewModels.ViewModel;

import java.util.ArrayList;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {


    ImageView montruo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        montruo = findViewById(R.id.imageView);

    }

    public void comer(View view){

        try{

            montruo.setImageResource(R.drawable.m2);

        }catch (Exception e){}

    }



}
