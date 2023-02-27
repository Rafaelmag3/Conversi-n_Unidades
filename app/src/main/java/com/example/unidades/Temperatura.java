package com.example.unidades;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
public class Temperatura extends AppCompatActivity {
    private EditText editText;
    private TextView resultado;
    private Spinner spinner1;
    private Spinner spinner2;
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temperatura);

        // Obtener referencias a los views
        editText = findViewById(R.id.edit_text);
        resultado = findViewById(R.id.text_view_resultado);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        button = findViewById(R.id.button_convertir);

        // Obtener referencias a los views
        editText = findViewById(R.id.edit_text);
        resultado = findViewById(R.id.text_view_resultado);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        button = findViewById(R.id.button_convertir);


        // Crear adaptadores para los spinners
        // Creamos un ArrayAdapter para cada Spinner, utilizando los datos de las matrices de cadenas definidas en strings.xml
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.unidades_temperatura, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.unidades_temperatura, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        // Configurar el evento clic del botón de conversión
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener el valor a convertir del EditText
                String valorString = editText.getText().toString();
                if (!valorString.isEmpty()) {
                    double valor = Double.parseDouble(valorString);

                    // Obtener las unidades seleccionadas en los Spinners
                    String unidadOrigen = (String) spinner1.getSelectedItem();
                    String unidadDestino = (String) spinner2.getSelectedItem();

                    // Realizar la conversión y mostrar el resultado en el TextView
                    double resultadoConversion = convertir(valor, unidadOrigen, unidadDestino);
                    resultado.setText(String.format("%.6f", resultadoConversion));
                } else {
                    // Si no se ha ingresado un valor, mostrar un mensaje de error
                    Toast.makeText(Temperatura.this, "Por favor ingrese un valor", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private double convertir(double valor, String medida1, String medida2) {
        double resultado = 0;

        if (medida1.equals("Celsius")) {
            if (medida2.equals("Fahrenheit")) {
                resultado = valor * 1.8 + 32;
            } else if (medida2.equals("Kelvin")) {
                resultado = valor + 273.15;
            } else if (medida2.equals("Rankine")) {
                resultado = (valor + 273.15) * 1.8;
            } else {
                return valor;
            }
        } else if (medida1.equals("Fahrenheit")) {
            if (medida2.equals("Celsius")) {
                resultado = (valor - 32) / 1.8;
            } else if (medida2.equals("Kelvin")) {
                resultado = (valor + 459.67) / 1.8;
            } else if (medida2.equals("Rankine")) {
                resultado = valor + 459.67;
            } else {
                return valor;
            }
        } else if (medida1.equals("Kelvin")) {
            if (medida2.equals("Celsius")) {
                resultado = valor - 273.15;
            } else if (medida2.equals("Fahrenheit")) {
                resultado = valor * 1.8 - 459.67;
            } else if (medida2.equals("Rankine")) {
                resultado = valor * 1.8;
            } else {
                return valor;
            }
        } else if (medida1.equals("Rankine")) {
            if (medida2.equals("Celsius")) {
                resultado = (valor / 1.8) - 273.15;
            } else if (medida2.equals("Fahrenheit")) {
                resultado = valor - 459.67;
            } else if (medida2.equals("Kelvin")) {
                resultado = valor / 1.8;
            } else {
                return valor;
            }
        } else {
            return valor;
        }

        return resultado;
    }



}