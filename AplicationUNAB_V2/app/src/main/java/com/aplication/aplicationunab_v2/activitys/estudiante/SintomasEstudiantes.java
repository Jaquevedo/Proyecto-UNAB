package com.aplication.aplicationunab_v2.activitys.estudiante;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.activitys.profesores.SintomasProfesores;

public class SintomasEstudiantes extends AppCompatActivity {
    private RadioButton si1, si2, si3, si4, si5, no1, no2, no3, no4, no5;
    Button update;
    int Counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sintomas_estudiantes);
        no1 = (RadioButton) findViewById(R.id.RadioBttnNo1Prof);
        no2 = (RadioButton) findViewById(R.id.RadioBttnNo2Prof);
        no3 = (RadioButton) findViewById(R.id.RadioBttnNo3Prof);
        no4 = (RadioButton) findViewById(R.id.RadioBttnNo4Prof);
        no5 = (RadioButton) findViewById(R.id.RadioBttnNo5Prof);

        si1 = (RadioButton) findViewById(R.id.RadioBttnSi1Prof);
        si2 = (RadioButton) findViewById(R.id.RadioBttnSi2Prof);
        si3 = (RadioButton) findViewById(R.id.RadioBttnSi3Prof);
        si4 = (RadioButton) findViewById(R.id.RadioBttnSi4Prof);
        si5 = (RadioButton) findViewById(R.id.RadioBttnSi5Prof);


        update= findViewById(R.id.bttnRegitSintom);
        //boolean stat1 = no1.isChecked();




    }

    public void viewOption(View view) {
        Counter = 0;

        if (si1.isChecked()){
            Counter++;
            Toast.makeText(SintomasEstudiantes.this, "Valor"+Counter, Toast.LENGTH_SHORT).show();

            Log.d("Sintomas", "Contador" + Counter);
        }
        if (si2.isChecked()){
            Counter++;
            Log.d("Sintomas", "Contador" + Counter);

        }
        if (si3.isChecked()){
            Counter++;
            Toast.makeText(SintomasEstudiantes.this, "Valor"+Counter, Toast.LENGTH_SHORT).show();
            Log.d("Sintomas", "Contador" + Counter);

        }
        if (si4.isChecked()){
            Counter ++;
            Log.d("Sintomas", "Contador" + Counter);

        }
        if (si5.isChecked()){
            Counter ++;
            Toast.makeText(SintomasEstudiantes.this, "Valor"+Counter, Toast.LENGTH_SHORT).show();
            Log.d("Sintomas", "Contador" + Counter);

        }
        if (Counter >= 3){
            //Toast.makeText(SintomasProfesores.this, "INHABILITADO", Toast.LENGTH_SHORT).show();


        }




    }

}
