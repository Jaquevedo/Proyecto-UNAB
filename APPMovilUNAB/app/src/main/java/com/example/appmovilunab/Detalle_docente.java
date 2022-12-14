package com.example.appmovilunab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class Detalle_docente extends AppCompatActivity {

    String x="FUNCIONA";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_docente);
    }
    public void viewHistorial(View view) {
        //textView.setText("FUNCIONA");
        switch (view.getId()){
            case R.id.btnBackEst:
            case R.id.btnHistoryEst:
                Intent intentHist=new Intent(Detalle_docente.this, Listado_docentes.class);
                startActivity(intentHist);
                break;

//            case R.id.btnLogoutEst:
//                Intent intentBack=new Intent(Detalle_Estudiante.this, LoginActivity.class);
//                startActivity(intentBack);
//                break;
//            case R.id.btnUpdateEst:
//                Intent intent =new Intent(Detalle_Estudiante.this, ImageTextListViewActivity.class);
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
            case R.id.btndeleteEst:
                Context context2= getApplicationContext();
                CharSequence deleteMsg = "¡Datos eliminados con éxito!";
                int time2 = Toast.LENGTH_LONG;
                Toast toast2 = Toast.makeText(context2, deleteMsg, time2);
                toast2.setGravity(Gravity.CENTER, 0, 0 );


                toast2.show();
                break;


        }

    }
}