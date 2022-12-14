package com.example.appmovilunab;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class Listado_estudiantes extends AppCompatActivity {

    private View button;
    private TextView textView1;
    private TextView limpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_estudiantes);
    }

    @SuppressLint("NonConstantResourceId")
    public void viewHistorial(View view) {
        //textView1.setText("FUNCIONA");
        switch (view.getId()) {

            case R.id.btcatrasEst:

                Intent intentHist = new Intent(Listado_estudiantes.this, MainActivity.class);
                startActivity(intentHist);
                break;

            case R.id.EstDetails:
                Intent intentDetails = new Intent(Listado_estudiantes.this, Listado_docentes.class);
                startActivity(intentDetails);
                break;


        }


        // Do something in response to button click
    }
}
