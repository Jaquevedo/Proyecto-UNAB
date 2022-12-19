package com.aplication.aplicationunab_v2.activitys.profesores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.activitys.login.LoginActivity;

public class ListadoEstudiantesProfes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_estudiantes_profes);
    }

    public void viewOption(View view) {

        switch (view.getId()) {

            case R.id.btcatrasEst:
                Intent intentEstx = new Intent(ListadoEstudiantesProfes.this, ListadoCursosProfes.class);
                startActivity(intentEstx);
                break;

            case R.id.btnHistLogEst:
                Intent intentHist = new Intent(ListadoEstudiantesProfes.this, LoginActivity.class);
                startActivity(intentHist);
                break;
        }
    }
}