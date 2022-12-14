package com.example.appmovilunab;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Listado_docentes extends AppCompatActivity {
    private View button;
    private TextView textView1;
    private TextView limpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_docentes);
    }
    public void viewHistorialprofes(View view) {
        //textView1.setText("FUNCIONA");
        switch (view.getId()){
//
            case R.id.btcatrasEst:
                Intent intentHist=new Intent(Listado_docentes.this, MainActivity.class);
                startActivity(intentHist);
                break;
//            case R.id.btnHistLogProf:
//                Intent intentLogout=new Intent(ListadoProfes.this, LoginActivity.class);
//                startActivity(intentLogout);
//                break;
            case R.id.EstDetails:
                Intent intentDetails=new Intent(Listado_docentes.this, Detalle_docente.class);
                startActivity(intentDetails);
                break;




        }



        // Do something in response to button click
    }
}