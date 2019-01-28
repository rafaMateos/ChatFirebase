package com.example.rafael.loteriasshared;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Integer> numero = new ArrayList<>();
    TextView numeroGanador, dineroGanado;
    Button comprobar;
    String listString = "";
    EditText numeroIntro;
    int cantidadGanadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0; i<9; i++){
            numero.add((int)(Math.random() * 8) + 1);
        }

        for (Integer s : numero)
        {
            listString += s;
        }

        //Guardamos en el archivo
       SharedPreferences preferences = getSharedPreferences("numeroGanador",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("ganador",listString);
        editor.commit();

        numeroGanador = findViewById(R.id.NumeroGanador);
        dineroGanado = findViewById(R.id.DineroGanado);
        comprobar = findViewById(R.id.comprobar);
        numeroIntro = findViewById(R.id.editText2);
        comprobar.setOnClickListener(this);
    }


    public void volverAJugar(){


    numero.clear();
    listString = "";
        for(int i = 0; i<9; i++){
            numero.add((int)(Math.random() * 8) + 1);
        }

        for (Integer s : numero)
        {
            listString += s;
        }

        SharedPreferences preferences = getSharedPreferences("numeroGanador",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("ganador",listString);
        editor.commit();

    }
    @Override
    public void onClick(View v) {


        numeroGanador.setVisibility(View.GONE);
        dineroGanado.setVisibility(View.GONE);

        SharedPreferences preferences = getSharedPreferences("numeroGanador",MODE_PRIVATE);
        String numero = preferences.getString("ganador","No existe na");

        if(numeroIntro.length() <9){
            Toast.makeText(this, "Nueve digitos para jugar nene", Toast.LENGTH_SHORT).show();
        }else{

            char[] num = numeroIntro.getText().toString().toCharArray();
            char[] numGanador = numero.toCharArray();

            if(num[8] == numGanador[8]){

                cantidadGanadora = 5;
                numeroGanador.setVisibility(View.VISIBLE);
                dineroGanado.setVisibility(View.VISIBLE);
                numeroGanador.setText(numero.toString());
                dineroGanado.setText(cantidadGanadora + " Eurazos");
                Toast.makeText(this, "Acertaste el ultimo numero", Toast.LENGTH_SHORT).show();
                volverAJugar();


            }else if(numGanador.equals(num)){

                cantidadGanadora = 150000;
                numeroGanador.setVisibility(View.VISIBLE);
                dineroGanado.setVisibility(View.VISIBLE);
                numeroGanador.setText(numero.toString());
                dineroGanado.setText(cantidadGanadora + " Eurazos");
                Toast.makeText(this, "Los Acertaste todos!!!", Toast.LENGTH_SHORT).show();
                volverAJugar();


            }else if((num[8] == numGanador[8]) && (num[7] == numGanador[7])){

                cantidadGanadora = 50;
                numeroGanador.setVisibility(View.VISIBLE);
                dineroGanado.setVisibility(View.VISIBLE);
                numeroGanador.setText(numero.toString());
                dineroGanado.setText(cantidadGanadora + " Eurazos");
                Toast.makeText(this, "Acertaste los dos ultimos numeros", Toast.LENGTH_SHORT).show();
                volverAJugar();

            }


            else{

                numeroGanador.setVisibility(View.VISIBLE);
                numeroGanador.setText(numero.toString());
                Toast.makeText(this, "No ganaste na", Toast.LENGTH_SHORT).show();
                volverAJugar();
            }

        }


    }
}
