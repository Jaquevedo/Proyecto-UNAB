package com.aplication.aplicationunab_v2.activitys.registro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.activitys.login.LoginActivity;

public class RegistroProfesor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_profesor);
    }

    public void viewOption(View view){

        switch (view.getId()){
            case R.id.Butt10:
                if (validacion()){
                    Intent intentProf = new Intent(RegistroProfesor.this, RegistroExitoso.class);
                    startActivity(intentProf);
                }
                break;

            case R.id.imageView3:
                Intent intentEstx = new Intent(RegistroProfesor.this, HomeRegistro.class);
                startActivity(intentEstx);
                break;

            case R.id.imageView4:
                Intent intentHist = new Intent(RegistroProfesor.this, LoginActivity.class);
                startActivity(intentHist);
                break;
        }
    }

    private boolean validacion() {
        //Todo: Realizar validacion de los datos

        return true;
    }
}