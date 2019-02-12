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

import com.example.rmateos.preguntadosrafa.Fragments.EnviarEmail;
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
    public EditText titulo;
    public EditText destinatario;
    public EditText contenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contenedor = findViewById(R.id.contenedor);
        contenedor2 = findViewById(R.id.contenedor2);

        ViewModel viewModelEditar;
        FrameLayout frame = findViewById(R.id.contenedor2);

        //Cargamos el fragment principal.(El de los botoncicos para hacer el crud)
        PrincipalFragment myf = new PrincipalFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.contenedor,new PrincipalFragment());
        ft.commit();

        viewModelEditar = ViewModelProviders.of(this).get(ViewModel.class);


        if(frame == null){

            //Estaremos observando la propiedad del viewModel para cuando cambie que la actividad se encargue de
            //cambiar el fragment, segun el id del boton pulsado.

            ViewModel viewModel = ViewModelProviders.of(this).get(ViewModel.class);
            viewModel.getBotonPulsado().observe(this, new Observer<Integer>() {
                @Override
                public void onChanged(@Nullable Integer integer) {

                    switch (integer){

                        case R.id.bnt_ver:

                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.contenedor, new SeeAllEmails());
                            transaction.addToBackStack(null);
                            transaction.commit();
                            break;

                        case R.id.Btn_Insertar:

                            FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                            transaction2.replace(R.id.contenedor, new InsertarEmails());
                            transaction2.addToBackStack(null);
                            transaction2.commit();
                            break;


                        case R.id.bnt_Editar:
                             FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
                             transaction3.replace(R.id.contenedor, new EnviarEmail());
                             transaction3.addToBackStack(null);
                             transaction3.commit();
                             break;


                    }

                }
            });


            //Y si no (es decir, que sea la pantalla mas grande de 600sw) cargar los fragments para ver el funciona-
            //mientos general de la aplicacion.

        }else{


            PrincipalFragment myf5 = new PrincipalFragment();
            FragmentTransaction ft5 = getSupportFragmentManager().beginTransaction();
            ft5.add(R.id.contenedor,new PrincipalFragment());
            ft5.commit();

            SeeAllEmails myf1 = new SeeAllEmails();
            FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
            ft1.add(R.id.contenedor2,new SeeAllEmails());
            ft1.commit();


            ViewModel viewModel = ViewModelProviders.of(this).get(ViewModel.class);

            viewModel.getBotonPulsado().observe(this, new Observer<Integer>() {
                @Override
                public void onChanged(@Nullable Integer integer) {

                    switch (integer){

                        case R.id.Btn_Insertar:

                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.contenedor3, new InsertarEmails());
                            transaction.addToBackStack(null);
                            transaction.commit();
                            break;

                        case R.id.bnt_Editar:

                            FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                            transaction2.replace(R.id.contenedor3, new EnviarEmail());
                            transaction2.addToBackStack(null);
                            transaction2.commit();
                            break;


                    }

                }
            });

        }





    }




}
