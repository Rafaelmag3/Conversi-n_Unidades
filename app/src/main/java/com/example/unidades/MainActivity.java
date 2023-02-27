package com.example.unidades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    private Button longitud, peso, temperatura, volumen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        longitud = findViewById(R.id.btn_longitud);
        peso = findViewById(R.id.btn_peso);
        temperatura = findViewById(R.id.btn_temperatura);
        volumen = findViewById(R.id.btn_volumen);

        longitud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Longitudes.class);
                startActivity(intent);
            }
        });
        peso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Peso.class);
                startActivity(intent);
            }
        });
        temperatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Temperatura.class);
                startActivity(intent);
            }
        });
        volumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Volumen.class);
                startActivity(intent);
            }
        });
    }
}
