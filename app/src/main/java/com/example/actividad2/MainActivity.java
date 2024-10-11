package com.example.actividad2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText fechaInicio, fechaFin;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vincular los elementos de la interfaz con las variables Java
        fechaInicio = findViewById(R.id.fechaInicio);
        fechaFin = findViewById(R.id.fechaFin);
        resultTextView = findViewById(R.id.resultTextView);
    }

    // Función para calcular la diferencia de años entre las dos fechas
    public void calcularAnios(View view) {
        try {
            // Obtener las fechas de los campos de entrada
            String fechaInicioStr = fechaInicio.getText().toString();
            String fechaFinStr = fechaFin.getText().toString();

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaInicioDate = formato.parse(fechaInicioStr);
            Date fechaFinDate = formato.parse(fechaFinStr);

            // Obtener los calendarios para las dos fechas
            Calendar inicio = Calendar.getInstance();
            inicio.setTime(fechaInicioDate);

            Calendar fin = Calendar.getInstance();
            fin.setTime(fechaFinDate);

            // Calcular la diferencia de años
            int aniosDiferencia = fin.get(Calendar.YEAR) - inicio.get(Calendar.YEAR);

            // Ajustar si la fecha de fin es anterior al cumpleaños en el año
            if (fin.get(Calendar.DAY_OF_YEAR) < inicio.get(Calendar.DAY_OF_YEAR)) {
                aniosDiferencia--;
            }

            // Mostrar el resultado
            resultTextView.setText("La diferencia es: " + aniosDiferencia + " años.");
        } catch (Exception e) {
            // Si hay un error en la entrada, mostrar mensaje de error
            resultTextView.setText("Por favor, introduce fechas válidas (dd/mm/aaaa).");
        }
    }
}
