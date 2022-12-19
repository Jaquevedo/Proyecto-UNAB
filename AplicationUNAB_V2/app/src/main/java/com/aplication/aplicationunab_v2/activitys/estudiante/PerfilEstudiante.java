package com.aplication.aplicationunab_v2.activitys.estudiante;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.activitys.login.LoginActivity;
import com.aplication.aplicationunab_v2.activitys.password.CambioPassword;

public class PerfilEstudiante extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_estudiante);
    }

    public void viewOption(View view) {

        switch (view.getId()) {

            case R.id.btnSintomas:
                Intent intentEst = new Intent(PerfilEstudiante.this, SintomasEstudiantes.class);
                startActivity(intentEst);
                break;

            case R.id.btnHistoryEst:
                Intent intentAdmin = new Intent(PerfilEstudiante.this, Historial.class);
                startActivity(intentAdmin);
                break;

            case R.id.forgetpass:
                Intent intentProf = new Intent(PerfilEstudiante.this, CambioPassword.class);
                startActivity(intentProf);
                break;

            case R.id.btnBackEst:
                Intent intentEstx = new Intent(PerfilEstudiante.this, LoginActivity.class);
                startActivity(intentEstx);
                break;

            case R.id.btnLogout:
                Intent intentHist = new Intent(PerfilEstudiante.this, LoginActivity.class);
                startActivity(intentHist);
                break;
        }
    }

}