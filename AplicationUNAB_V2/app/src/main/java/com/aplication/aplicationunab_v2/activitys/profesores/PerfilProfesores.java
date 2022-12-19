package com.aplication.aplicationunab_v2.activitys.profesores;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.activitys.login.LoginActivity;
import com.aplication.aplicationunab_v2.activitys.password.CambioPassword;

public class PerfilProfesores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_profesores);
    }

    public void viewOption(View view) {

        switch (view.getId()) {

            case R.id.btnSintomas:
                Intent intentEst = new Intent(PerfilProfesores.this, SintomasProfesores.class);
                startActivity(intentEst);
                break;

            case R.id.btnHistoryEst:
                Intent intentAdmin = new Intent(PerfilProfesores.this, HistorialProfesores.class);
                startActivity(intentAdmin);
                break;

            case R.id.btnCursosProf:
                Intent intentCurso = new Intent(PerfilProfesores.this, ListadoCursosProfes.class);
                startActivity(intentCurso);
                break;

            case R.id.forgetpass:
                Intent intentProf = new Intent(PerfilProfesores.this, CambioPassword.class);
                startActivity(intentProf);
                break;

            case R.id.btnBackEst:
                Intent intentEstx = new Intent(PerfilProfesores.this, LoginActivity.class);
                startActivity(intentEstx);
                break;

            case R.id.btnLogoutEst:
                Intent intentHist = new Intent(PerfilProfesores.this, LoginActivity.class);
                startActivity(intentHist);
                break;
        }
    }
}