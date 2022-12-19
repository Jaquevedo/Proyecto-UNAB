package com.aplication.aplicationunab_v2.activitys.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.activitys.login.LoginActivity;
import com.aplication.aplicationunab_v2.activitys.password.CambioPassword;
import com.aplication.aplicationunab_v2.activitys.profesores.HistorialProfesores;
import com.aplication.aplicationunab_v2.activitys.profesores.ListadoCursosProfes;
import com.aplication.aplicationunab_v2.activitys.profesores.PerfilProfesores;
import com.aplication.aplicationunab_v2.activitys.profesores.SintomasProfesores;

public class PerfilAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_admin);
    }

    public void viewOption(View view) {

        switch (view.getId()) {

            case R.id.btnGestionProfes:
                Intent intentEst = new Intent(PerfilAdmin.this, ListaProfesoresAdmin.class);
                startActivity(intentEst);
                break;

            case R.id.btnGestionEstu:
                Intent intentAdmin = new Intent(PerfilAdmin.this, ListaEstudiantesAdmin.class);
                startActivity(intentAdmin);
                break;

            case R.id.btnGestionCurso:
                Intent intentCurso = new Intent(PerfilAdmin.this, ListaCursosAdmin.class);
                startActivity(intentCurso);
                break;

            case R.id.forgetpass:
                Intent intentProf = new Intent(PerfilAdmin.this, CambioPassword.class);
                startActivity(intentProf);
                break;

            case R.id.btnBack:
                Intent intentEstx = new Intent(PerfilAdmin.this, LoginActivity.class);
                startActivity(intentEstx);
                break;

            case R.id.btnLogout:
                Intent intentHist = new Intent(PerfilAdmin.this, LoginActivity.class);
                startActivity(intentHist);
                break;
        }
    }
}