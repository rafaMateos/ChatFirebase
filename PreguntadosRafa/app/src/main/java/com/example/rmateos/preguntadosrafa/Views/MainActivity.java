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

import com.example.rmateos.preguntadosrafa.Fragments.InsertarEmails;
import com.example.rmateos.preguntadosrafa.Fragments.PrincipalFragment;
import com.example.rmateos.preguntadosrafa.Fragments.SeeAllEmails;
import com.example.rmateos.preguntadosrafa.Models.Email;
import com.example.rmateos.preguntadosrafa.R;
import com.example.rmateos.preguntadosrafa.ViewModels.ViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

public static FrameLayout contenedor,contenedor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contenedor = findViewById(R.id.contenedor);
        contenedor2 = findViewById(R.id.contenedor2);

        FrameLayout frame = findViewById(R.id.contenedor2);

        if(frame != null){

            PrincipalFragment myf = new PrincipalFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.contenedor,new PrincipalFragment());
            ft.commit();

            SeeAllEmails myf1 = new SeeAllEmails();
            FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
            ft1.add(R.id.contenedor2,new SeeAllEmails());
            ft1.commit();


            InsertarEmails myf2 = new InsertarEmails();
            FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
            ft2.add(R.id.contenedor3,new InsertarEmails());
            ft2.commit();


        }else{

            PrincipalFragment myf = new PrincipalFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.contenedor,new PrincipalFragment());
            ft.commit();


        }







    }




}
