package com.aplication.aplicationunab_v2.activitys.registro;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.activitys.login.LoginActivity;

public class RegistroAdministrador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_administrador);
    }

    public void viewOption(View view){

        switch (view.getId()){
            case R.id.Butt10:
                if (validacion()){
                    //Todo: Realizar el registro en DB

                    Intent intentProf = new Intent(RegistroAdministrador.this, RegistroExitoso.class);
                    startActivity(intentProf);
                }
                break;

            case R.id.imageView3:
                Intent intentEstx = new Intent(RegistroAdministrador.this, HomeRegistro.class);
                startActivity(intentEstx);
                break;

            case R.id.imageView4:
                Intent intentHist = new Intent(RegistroAdministrador.this, LoginActivity.class);
                startActivity(intentHist);
                break;
        }
    }

    private boolean validacion() {
        //Todo: Realizar validacion de los datos

        return true;
    }
}