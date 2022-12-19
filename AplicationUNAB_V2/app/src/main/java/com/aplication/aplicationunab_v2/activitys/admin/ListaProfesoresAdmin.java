package com.aplication.aplicationunab_v2.activitys.admin;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.activitys.login.LoginActivity;

public class ListaProfesoresAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_profesores_admin);
    }

    public void viewOption(View view) {

        switch (view.getId()) {

            case R.id.EstDetails:
                Intent intentEst = new Intent(ListaProfesoresAdmin.this, DetallesProfesEstudiantes_Admin.class);
                startActivity(intentEst);
                break;

            case R.id.btcatrasEst:
                Intent intentEstx = new Intent(ListaProfesoresAdmin.this, PerfilAdmin.class);
                startActivity(intentEstx);
                break;

            case R.id.btnHistLogEst:
                Intent intentHist = new Intent(ListaProfesoresAdmin.this, LoginActivity.class);
                startActivity(intentHist);
                break;
        }
    }
}