package com.aplication.aplicationunab_v2.activitys.registro;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.activitys.login.LoginActivity;

public class HomeRegistro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_registro);
    }

    public void viewOption(View view) {

        switch (view.getId()){
            case R.id.Butt1:
                Intent intentProf = new Intent(HomeRegistro.this, RegistroProfesor.class);
                startActivity(intentProf);
                break;

            case R.id.Butt2:
                Intent intentEst = new Intent(HomeRegistro.this, RegistroEstudiante.class);
                startActivity(intentEst);
                break;

            case R.id.Butt3:
                Intent intentAdmin = new Intent(HomeRegistro.this, RegistroAdministrador.class);
                startActivity(intentAdmin);
                break;

            case R.id.btnBack:
                Intent intentEstx = new Intent(HomeRegistro.this, LoginActivity.class);
                startActivity(intentEstx);
                break;

            case R.id.btnLogout:
                Intent intentHist = new Intent(HomeRegistro.this, LoginActivity.class);
                startActivity(intentHist);
                break;
        }

/*        switch (view.getId()) {

            case R.id.btnLogout:
                Intent intentHist = new Intent(HomeRegistro.this, LoginActivity.class);
                startActivity(intentHist);
                break;

            case R.id.Butt1:
                Intent intentProf = new Intent(HomeRegistro.this, List_profe.class);
                startActivity(intentProf);
                break;
            case R.id.Butt2:
                Intent intentEst = new Intent(HomeRegistro.this, Lista_Est.class);
                startActivity(intentEst);
                break;
            case R.id.btnBack:
                Intent intentEstx = new Intent(HomeRegistro.this, MainActivityINTENTO.class);
                startActivity(intentEstx);
                break;

//            case R.id.btnUpdateEst:
//                Intent intent =new Intent(MainActivity.this, ImageTextListViewActivity.class);
//                //intent.putExtra("dato", x);
//                startActivity(intent);
//                Context context= getApplicationContext();
//                CharSequence updateMsg = "¡Datos actualizados con éxito!";
//                int time = Toast.LENGTH_LONG;
//                Toast toast = Toast.makeText(context, updateMsg, time);
//                toast.setGravity(Gravity.CENTER, 0, 0 );
//
//                toast.show();
//                break;

            case R.id.Butt3:
                Context context2 = getApplicationContext();
                CharSequence deleteMsg = "¡Datos eliminados con éxito!";
                int time2 = Toast.LENGTH_LONG;
                Toast toast2 = Toast.makeText(context2, deleteMsg, time2);
                toast2.setGravity(Gravity.CENTER, 0, 0);


                toast2.show();
                break;


        }*/

    }
}