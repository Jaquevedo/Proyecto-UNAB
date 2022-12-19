package com.aplication.aplicationunab_v2.activitys.admin;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.activitys.login.LoginActivity;

public class DetallesCursoAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_curso_admin);
    }

    public void viewOption(View view) {

        switch (view.getId()) {

            case R.id.btnUpdateEst:
                //Todo: se debe hacer la actualizacion de datos en la DB

                break;

            case R.id.btndeleteEst:
                //Todo: se debe eliminar los datos en la DB

                break;

            case R.id.btnBackEst:
                Intent intentAtras = new Intent(DetallesCursoAdmin.this, ListaCursosAdmin.class);
                startActivity(intentAtras);
                break;

            case R.id.btnLogoutEst:
                Intent intentHist = new Intent(DetallesCursoAdmin.this, LoginActivity.class);
                startActivity(intentHist);
                break;
        }
    }

}