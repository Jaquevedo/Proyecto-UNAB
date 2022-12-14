package com.example.appmovilunab;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.appmovilunab.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    Button Butt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);}

        public void viewOption(View view) {
            //textView.setText("FUNCIONA");
            switch (view.getId()){
                case R.id.btnBack:
                case R.id.btnLogout:
                    Intent intentHist=new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intentHist);
                    break;

                case R.id.Butt1:
                    Intent intentProf=new Intent(MainActivity.this, Listado_docentes.class);
                    startActivity(intentProf);
                    break;
                case R.id.Butt2:
                    Intent intentEst=new Intent(MainActivity.this, ImageTextListViewActivity.class);
                    startActivity(intentEst);
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

