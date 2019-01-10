package com.example.rafael.chatfirebase;

import android.content.Intent;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StartActivity extends AppCompatActivity {

    /** Elementos de la actividad*/
    Button login,register;
    TextView AboutMe;

    /** Elementos firebase*/
    FirebaseUser firebaseUser;


    /**
    Descripcion funcionamientos:

        Comprobacion para asi saber si el usuario tiene ya una sesion iniciada en la aplicacion
        Comprobaremos si el usuario esta registrado, si lo esta entrara directamente en la aplicacion.
        Si se deslogeara la aplicacion sabria que en ese momento no estaria activo.

    */
    @Override
    protected void onStart() {
        super.onStart();


        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if(firebaseUser != null){

            Intent intent = new Intent(StartActivity.this,MainActivity.class);
            startActivity(intent);
            finish();

        }

    }



    /** Metodo onCreate del ciclo de vida*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        AboutMe = findViewById(R.id.textView);

        //Click del boton login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this,LoginActivity.class));

            }
        });

        //Click del boton login
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this,RegisterActivity.class));
            }
        });



    }


    public void Aboutme(View v){

        Intent intent = new Intent(StartActivity.this,com.example.rafael.chatfirebase.AboutMe.class);
        startActivity(intent);

    }
}
