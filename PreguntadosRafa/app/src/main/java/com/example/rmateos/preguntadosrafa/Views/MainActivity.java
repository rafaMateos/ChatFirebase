package com.example.rmateos.preguntadosrafa.Views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.rmateos.preguntadosrafa.BussinesLogic.Repository;

import com.example.rmateos.preguntadosrafa.Fragments.PrincipalFragment;
import com.example.rmateos.preguntadosrafa.R;
import com.example.rmateos.preguntadosrafa.ViewModels.ViewModel;

import java.util.ArrayList;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

FrameLayout flecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flecha = findViewById(R.id.contenedor);

        PrincipalFragment myf = new PrincipalFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.contenedor,new PrincipalFragment());
        ft.commit();


    }




}