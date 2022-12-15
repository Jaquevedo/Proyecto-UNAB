package com.example.appmovilunab;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Detalle_Estudiante extends AppCompatActivity {

    String x="FUNCIONA";
    TextView docData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_estudiante);
        Bundle extras = getIntent().getExtras();
        String d1 = extras.getString("dato");
        docData = (TextView) findViewById(R.id.nameData);
        docData.setText(d1);
    }
    public void viewHistorial(View view) {
        //textView.setText("FUNCIONA");
        switch (view.getId()){
            case R.id.btnBackEst:
            case R.id.btnHistoryEst:
                Intent intentHist=new Intent(Detalle_Estudiante.this, Listado_estudiantes.class);
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