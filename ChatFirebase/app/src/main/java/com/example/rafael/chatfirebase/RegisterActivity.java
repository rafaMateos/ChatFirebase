package com.example.rafael.chatfirebase;

import android.content.Intent;
import android.icu.text.SymbolTable;
import android.support.annotation.NonNull;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    /** Elementos de actividad*/
    private Boolean canregister;
    private EditText username , email, password;
    private Button btn_register;

    /** Elementos de firebase*/
    private FirebaseAuth auth;
    private DatabaseReference reference;

    private int contMayusculas;
    private int contMinusculas;
    private int contNumeros;
    private boolean esVacio;
    private boolean contraMenorSeis;


    /** Metodo onCreate del ciclo de vida*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.pasword);
        btn_register = findViewById(R.id.btn_register);

        auth = FirebaseAuth.getInstance();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               canregister = ComprobarCampos();

               if(canregister) register(username.getText().toString(),email.getText().toString(),password.getText().toString());

            }
        });
    }

    /**Nombre: ComprobarCampos
    * Descripcion: Metodo el cual comprobara si los campos introducidos son correctos*/
    private Boolean ComprobarCampos() {

        boolean canRegister = false;
        esVacio = false;
        contraMenorSeis = false;
        String txt_username = username.getText().toString();
        String txt_email = email.getText().toString();
        String txt_password = password.getText().toString();



        char[] charArray = txt_password.toCharArray();

        for (int i = 0;  i< charArray.length; i++)
        {

            if(Character.isUpperCase(charArray[i])){

                contMayusculas++;
            }else{

                contMinusculas++;
            }

             if(Character.isDigit(charArray[i])){

                contNumeros++;
            }

        }

        if(TextUtils.isEmpty(txt_password) || TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_username)){

            Toast.makeText(RegisterActivity.this, "Tienes que rellenar todos los campos", Toast.LENGTH_SHORT).show();
            esVacio = true;

        }else if(txt_password.length() < 6) {

            Toast.makeText(RegisterActivity.this, "La contraseña debe de tener mas de 6 caracteres", Toast.LENGTH_SHORT).show();
            contraMenorSeis = true;

        }
        else if (!contraMenorSeis && !esVacio && contNumeros >= 1 && contMinusculas >= 1 && contMayusculas >= 1){

            canRegister = true;
        }else {

            Toast.makeText(this, "La contraseña debe contener mayusculas, minusculas y numeros", Toast.LENGTH_SHORT).show();
        }

        return canRegister;
    }


    /**Nombre: register
    * Descripcion: Metodo el cual registrar al usuario en la aplicacion, y guardara su informacion
    * en la base de datos de firebase.*/
    private void register(final String username, final String email, String pasword){

        auth.createUserWithEmailAndPassword(email,pasword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            FirebaseUser firebaseUser = auth.getCurrentUser();
                            String userId = firebaseUser.getUid();

                            reference = FirebaseDatabase.getInstance().getReference("Users").child(userId);

                            final HashMap<String,String> hashMap = new HashMap<>();
                            hashMap.put("id",userId);
                            hashMap.put("username",username);
                            hashMap.put("imageUrl","default");

                            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if(task.isSuccessful()){

                                        reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {

                                                if(task.isSuccessful()){

                                                    Toast.makeText(RegisterActivity.this, "Revisa el email para verificar: " + email, Toast.LENGTH_SHORT).show();
                                                   Intent intent = new Intent(getApplicationContext(),StartActivity.class);
                                                   startActivity(intent);
                                                }
                                            }
                                        });

                                    }else{

                                        Toast.makeText(RegisterActivity.this, "Compruba tu conex a internet", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });


                        }else{

                            Toast.makeText(RegisterActivity.this,"No pudiste registrarte",Toast.LENGTH_SHORT).show();

                        }
                    }
                });


    }
}
