package com.example.rafael.chatfirebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.rengwuxian.materialedittext.MaterialEditText;

public class LoginActivity extends AppCompatActivity {

    /** Elementos de la actividad*/
    private EditText email,password;
    private Button btn_login;

    /** Elementos firebase*/
    private FirebaseAuth auth;


    /** Metodo on create del ciclo de vida*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();

        email = findViewById(R.id.email);
        password = findViewById(R.id.pasword);
        btn_login = findViewById(R.id.btn_login);

        //Click del boton login
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ComprobarCamposDeLogueo();

            }
        });
    }


    /**Nombre: ComprobarCamposLogueo
    * Descripcion: Metodo el cual nos comprobara si los campos introducidos son correctos,
    *               si lo fueran te introducirias en la aplicacion.
    *               Si no lo fueran no lo haria y avisaria al usuario.
    * */
    private void ComprobarCamposDeLogueo() {

        String txt_email = email.getText().toString();
        String txt_pasword = password.getText().toString();

        if(TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_pasword)){

            Toast.makeText(LoginActivity.this, "Todos los campos deben de estar rellenos", Toast.LENGTH_SHORT).show();

        } else{

            auth.signInWithEmailAndPassword(txt_email,txt_pasword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful()){

                        Toast.makeText(LoginActivity.this, "Autenticacion fallida!!", Toast.LENGTH_SHORT).show();
                    }else{

                        checkIfEmailVerified();
                    }
                }
            });

        }

    }

    private void checkIfEmailVerified()
    {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user.isEmailVerified())
        {
            // user is verified, so you can finish this activity or send user to activity which you want.
            finish();
            Toast.makeText(LoginActivity.this, "Successfully logged in", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);

            startActivity(intent);
            finish();

        }
        else
        {

            Toast.makeText(this, "Verifica tu Email, revisa tu bandeja de entrada", Toast.LENGTH_SHORT).show();

        }
    }
}
