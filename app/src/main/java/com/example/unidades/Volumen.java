package com.example.unidades;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Volumen extends AppCompatActivity {
    private EditText editText;
    private TextView resultado;
    private Spinner spinner1;
    private Spinner spinner2;
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volumen);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.unidades_volumen, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.unidades_volumen, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        // Configurar el evento clic del bot??n de conversi??n
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

                    // Realizar la conversi??n y mostrar el resultado en el TextView
                    double resultadoConversion = convertir(valor, unidadOrigen, unidadDestino);
                    resultado.setText(String.format("%.6f", resultadoConversion));
                } else {
                    // Si no se ha ingresado un valor, mostrar un mensaje de error
                    Toast.makeText(Volumen.this, "Por favor ingrese un valor", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            // Navegar a la actividad lista_videos al presionar el bot??n de regreso en la ActionBar
            Intent intent = new Intent(this, MainActivity.class);
            // Agregar la bandera FLAG_ACTIVITY_CLEAR_TOP al intent para reiniciar la actividad anterior
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private double convertir(double valor, String medida1, String medida2) {
        double resultado = 0;

        if (medida1.equals("Litros")) {
            if (medida2.equals("Mililitros")) {
                resultado = valor * 1000;
            } else if (medida2.equals("Metros c??bicos")) {
                resultado = valor / 1000;
            } else if (medida2.equals("Cent??metros c??bicos")) {
                resultado = valor * 1000;
            } else {
                return valor;
            }
        } else if (medida1.equals("Mililitros")) {
            if (medida2.equals("Litros")) {
                resultado = valor / 1000;
            } else if (medida2.equals("Metros c??bicos")) {
                resultado = valor / 1000000;
            } else if (medida2.equals("Cent??metros c??bicos")) {
                resultado = valor;
            } else {
                return valor;
            }
        } else if (medida1.equals("Metros c??bicos")) {
            if (medida2.equals("Litros")) {
                resultado = valor * 1000;
            } else if (medida2.equals("Mililitros")) {
                resultado = valor * 1000000;
            } else if (medida2.equals("Cent??metros c??bicos")) {
                resultado = valor * 1000000;
            } else {
                return valor;
            }
        } else if (medida1.equals("Cent??metros c??bicos")) {
            if (medida2.equals("Litros")) {
                resultado = valor / 1000;
            } else if (medida2.equals("Mililitros")) {
                resultado = valor;
            } else if (medida2.equals("Metros c??bicos")) {
                resultado = valor / 1000000;
            } else {
                return valor;
            }
        }

        return resultado;
    }

}