package com.aplication.aplicationunab_v2.activitys.profesores;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.activitys.login.LoginActivity;

public class HistorialProfesores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_profesores);
    }

    public void viewOption(View view) {

        switch (view.getId()) {

            case R.id.btcatrasEst:
                Intent intentEstx = new Intent(HistorialProfesores.this, PerfilProfesores.class);
                startActivity(intentEstx);
                break;

            case R.id.btnHistLogEst:
                Intent intentHist = new Intent(HistorialProfesores.this, LoginActivity.class);
                startActivity(intentHist);
                break;
        }
    }
}