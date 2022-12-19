package com.aplication.aplicationunab_v2.activitys.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.activitys.login.LoginActivity;

public class ListaEstudiantesAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_estudiantes_admin);
    }

    public void viewOption(View view) {

        switch (view.getId()) {

            case R.id.EstDetails:
                Intent intentEst = new Intent(ListaEstudiantesAdmin.this, DetallesProfesEstudiantes_Admin.class);
                startActivity(intentEst);
                break;

            case R.id.btcatrasEst:
                Intent intentEstx = new Intent(ListaEstudiantesAdmin.this, PerfilAdmin.class);
                startActivity(intentEstx);
                break;

            case R.id.btnHistLogEst:
                Intent intentHist = new Intent(ListaEstudiantesAdmin.this, LoginActivity.class);
                startActivity(intentHist);
                break;
        }
    }

}