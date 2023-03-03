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


public class Peso extends AppCompatActivity {
    private EditText editText;
    private TextView resultado;
    private Spinner spinner1;
    private Spinner spinner2;
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.peso);
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
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.unidades_peso, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.unidades_peso, android.R.layout.simple_spinner_item);
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
                    Toast.makeText(Peso.this, "Por favor ingrese un valor", Toast.LENGTH_SHORT).show();
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

        if (medida1.equals("Kilogramos")) {
            if (medida2.equals("Libras")) {
                resultado = valor * 2.20462;
            }else  if (medida2.equals("Gramos")){
                resultado = valor * 1000;
            } else if (medida2.equals("Onzas")) {
                resultado = valor * 35.274;
            } else if (medida2.equals("Toneladas")) {
                resultado = valor * 0.001;
            }else if (medida2.equals("Stone")) {
                resultado = valor * 0.157473;
            } else if (medida2.equals("Quilates")) {
                resultado = valor * 5000;
            } else {
                return valor;
            }
        } else if (medida1.equals("Libras")) {
            if (medida2.equals("Kilogramos")) {
                resultado = valor * 0.453592;
            } else if (medida2.equals("Onzas")) {
                resultado = valor * 16;
            } else if (medida2.equals("Gramos")) {
                resultado = valor * 453.592;
            } else if (medida2.equals("Stone")) {
                resultado = valor * 0.0714286;
            }  else if (medida2.equals("Quilates")) {
                resultado = valor * 2267.96;
            }  else if (medida2.equals("Toneladas")) {
                resultado = valor * 0.000453592;
            } else {
                return valor;
            }
        } else if (medida1.equals("Onzas")) {
            if (medida2.equals("Kilogramos")) {
                resultado = valor * 0.0283495;
            } else if (medida2.equals("Libras")) {
                resultado = valor * 0.0625;
            } else if (medida2.equals("Gramos")) {
                resultado = valor * 28.34;
            } else if (medida2.equals("Stone")) {
                resultado = valor * 0.004464;
            }  else if (medida2.equals("Toneladas")) {
                resultado = valor * 3.125;
            }  else if (medida2.equals("Quilates")) {
                resultado = valor * 141.748;
            } else {
                return valor;
            }
        } else if (medida1.equals("Toneladas")) {
            if (medida2.equals("Kilogramos")) {
                resultado = valor * 907.185;
            } else if (medida2.equals("Libras")) {
                resultado = valor * 2000;
            } else if (medida2.equals("Gramos")) {
                resultado = valor * 9071;
            }  else if (medida2.equals("Onzas")) {
                resultado = valor * 35274;
            }  else if (medida2.equals("Stone")) {
                resultado = valor * 142.857;
            }  else if (medida2.equals("Quilates")) {
                resultado = valor * 5000000;
            } else {
                return valor;
            }
        } else if (medida1.equals("Gramos")) {
            if (medida2.equals("Kilogramos")) {
                resultado = valor * 0.001;
            } else if (medida2.equals("Libras")) {
                resultado = valor * 0.00220462;
            } else if (medida2.equals("Onzas")) {
                resultado = valor * 0.035274;
            } else if (medida2.equals("Toneladas")) {
                resultado = valor * 1.102310;
            } else if (medida2.equals("Quilates")) {
                resultado = valor * 0.2;
            } else if (medida2.equals("Stones")) {
                resultado = valor * 0.000157473;
            } else {
                return valor;
            }
        } else if (medida1.equals("Quilates")) {
            if (medida2.equals("Kilogramos")) {
                resultado = valor * 0.0002;
            } else if (medida2.equals("Libras")) {
                resultado = valor * 0.000440925;
            } else if (medida2.equals("Onzas")) {
                resultado = valor * 0.00705479;
            } else if (medida2.equals("Toneladas")) {
                resultado = valor * 2.2046;
            } else if (medida2.equals("Stones")) {
                resultado = valor * 3.1495;
            } else if (medida2.equals("Gramos")) {
                resultado = valor * 0.2;
            } else {
                return valor;
            }
        } else if (medida1.equals("Stones")) {
            if (medida2.equals("Kilogramos")) {
                resultado = valor * 6.35029;
            } else if (medida2.equals("Libras")) {
                resultado = valor * 13.999;
            } else if (medida2.equals("Onzas")) {
                resultado = valor * 223.99;
            } else if (medida2.equals("Toneladas")) {
                resultado = valor * 0.00699;
            } else if (medida2.equals("Gramos")) {
                resultado = valor * 6350.295;
            } else {
                return valor;
            }
        }
        return resultado;
    }


}