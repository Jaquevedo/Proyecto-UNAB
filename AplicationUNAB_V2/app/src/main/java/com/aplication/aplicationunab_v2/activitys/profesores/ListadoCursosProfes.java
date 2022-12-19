package com.aplication.aplicationunab_v2.activitys.profesores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.activitys.login.LoginActivity;
import com.aplication.aplicationunab_v2.activitys.password.CambioPassword;

public class ListadoCursosProfes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_cursos_profes);
    }

    public void viewOption(View view) {

        switch (view.getId()) {

            case R.id.EstDetails:
                Intent intentDetalles = new Intent(ListadoCursosProfes.this, ListadoEstudiantesProfes.class);
                startActivity(intentDetalles);
                break;

            case R.id.btcatrasEst:
                Intent intentEstx = new Intent(ListadoCursosProfes.this, PerfilProfesores.class);
                startActivity(intentEstx);
                break;

            case R.id.btnHistLogEst:
                Intent intentHist = new Intent(ListadoCursosProfes.this, LoginActivity.class);
                startActivity(intentHist);
                break;
        }
    }

}