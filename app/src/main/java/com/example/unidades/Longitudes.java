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
public class Longitudes extends AppCompatActivity {
    private EditText editText;
    private TextView resultado;
    private Spinner spinner1;
    private Spinner spinner2;
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_longitudes);
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
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.unidades_longitud, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.unidades_longitud, android.R.layout.simple_spinner_item);
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
                    Toast.makeText(Longitudes.this, "Por favor ingrese un valor", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            // Navegar a la actividad lista_videos al presionar el botón de regreso en la ActionBar
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

        if (medida1.equals("Centímetros")) {
            if (medida2.equals("Pulgadas")) {
                resultado = valor * 0.393701;
            } else if (medida2.equals("Pies")) {
                resultado = valor * 0.0328084;
            } else if (medida2.equals("Metros")) {
                resultado = valor * 0.01;
            } else if (medida2.equals("Yardas")) {
                resultado = valor * 0.0109361;
            } else if (medida2.equals("Millas")) {
                resultado = valor * 0.00000621371;
            } else if (medida2.equals("Kilómetros")) {
                resultado = valor * 0.00001;
            }
            else {
                return valor;
            }
        }  else if (medida1.equals("Pulgadas")) {
            if (medida2.equals("Centímetros")) {
                resultado = valor * 2.54;
            } else if (medida2.equals("Pies")) {
                resultado = valor * 0.0833333;
            } else if (medida2.equals("Metros")) {
                resultado = valor * 0.0254;
            } else if (medida2.equals("Yardas")) {
                resultado = valor * 0.0277778;
            } else if (medida2.equals("Millas")) {
                resultado = valor * 0.0000157828;
            } else if (medida2.equals("Kilómetros")) {
                resultado = valor * 0.0000254;
            }
            else {
                return valor;
            }
        }  else if (medida1.equals("Pies")) {
            if (medida2.equals("Centímetros")) {
                resultado = valor * 30.48;
            } else if (medida2.equals("Pulgadas")) {
                resultado = valor * 12;
            } else if (medida2.equals("Metros")) {
                resultado = valor * 0.3048;
            } else if (medida2.equals("Yardas")) {
                resultado = valor * 0.333333;
            } else if (medida2.equals("Millas")) {
                resultado = valor * 0.000189394;
            } else if (medida2.equals("Kilómetros")) {
                resultado = valor * 0.0003048;
            }
            else {
                return valor;
            }
        } else if (medida1.equals("Metros")) {
            if (medida2.equals("Centímetros")) {
                resultado = valor * 100;
            } else if (medida2.equals("Pulgadas")) {
                resultado = valor * 39.3701;
            } else if (medida2.equals("Pies")) {
                resultado = valor * 3.28084;
            } else if (medida2.equals("Yardas")) {
                resultado = valor * 1.09361;
            } else if (medida2.equals("Millas")) {
                resultado = valor * 0.000621371;
            } else if (medida2.equals("Kilómetros")) {
                resultado = valor * 0.001;
            }
            else {
                return valor;
            }
        } else if (medida1.equals("Yardas")) {
            if (medida2.equals("Centímetros")) {
                resultado = valor * 91.44;
            } else if (medida2.equals("Pulgadas")) {
                resultado = valor * 36;
            } else if (medida2.equals("Pies")) {
                resultado = valor * 3;
            } else if (medida2.equals("Metros")) {
                resultado = valor * 0.9144;
            }else  if (medida2.equals("Kilómetros")){
                resultado = valor * 0.0009144;
            }

            else {
                return valor;
            }
        }  else if (medida1.equals("Kilómetros")) {
            if (medida2.equals("Centímetros")) {
                resultado = valor * 100000;
            } else if (medida2.equals("Pulgadas")) {
                resultado = valor * 39370.1;
            } else if (medida2.equals("Pies")) {
                resultado = valor * 3280.841;
            } else if (medida2.equals("Metros")) {
                resultado = valor * 1000;
            } else if (medida2.equals("Yardas")){
                resultado = valor * 1093.61;
            } else if (medida2.equals("Millas")) {
                resultado = valor * 0.621371;
            } else {
                return valor;
            }
        }else if (medida1.equals("Millas")){
            if (medida2.equals("Centímetros")) {
                resultado = valor * 100000;
            } else if (medida2.equals("Pulgadas")) {
                resultado = valor * 39370.1;
            } else if (medida2.equals("Pies")) {
                resultado = valor * 3280.841;
            } else if (medida2.equals("Metros")) {
                resultado = valor * 1000;
            } else if (medida2.equals("Yardas")){
                resultado = valor * 1093.61;
            } else if (medida2.equals("Kilómetros")){
                resultado = valor * 1.60934;
            } else {
                return valor;
            }
        }
        return resultado;
    }
}
