package com.aplication.aplicationunab_v2.activitys.admin;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.activitys.login.LoginActivity;

public class ListaCursosAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cursos_admin);
    }

    public void viewOption(View view) {

        switch (view.getId()) {

            case R.id.EstDetails:
                Intent intentEst = new Intent(ListaCursosAdmin.this, DetallesCursoAdmin.class);
                startActivity(intentEst);
                break;

            case R.id.btcatrasEst:
                Intent intentEstx = new Intent(ListaCursosAdmin.this, PerfilAdmin.class);
                startActivity(intentEstx);
                break;

            case R.id.btnHistLogEst:
                Intent intentHist = new Intent(ListaCursosAdmin.this, LoginActivity.class);
                startActivity(intentHist);
                break;
        }
    }
}