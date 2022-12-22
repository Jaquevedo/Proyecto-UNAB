package com.aplication.aplicationunab_v2.activitys.estudiante;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.activitys.login.LoginActivity;
import com.aplication.aplicationunab_v2.adapters.MyAdapterEstud;

public class Historial extends AppCompatActivity {

    MyAdapterEstud adapterEstud;
    Intent it;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
    }

    public void viewOption(View view) {

        switch (view.getId()) {

            case R.id.btcatrasEst:
                Intent intentEstx = new Intent(Historial.this, PerfilEstudiante.class);
                startActivity(intentEstx);
                break;

            case R.id.btnHistLogEst:
                Intent intentHist = new Intent(Historial.this, LoginActivity.class);
                startActivity(intentHist);
                break;
        }
    }
}