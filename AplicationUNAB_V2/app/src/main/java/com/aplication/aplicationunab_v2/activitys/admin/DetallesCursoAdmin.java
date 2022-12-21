package com.aplication.aplicationunab_v2.activitys.admin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.activitys.login.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

public class DetallesCursoAdmin extends AppCompatActivity {
    EditText nameDocurse, horarioCurse, UIDoc, codCurse, lunes, martes, miercoles, jueves, viernes, sabado;
    TextView nameCurse;
    Button btnAct, btnBorr;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_curso_admin);

        nameDocurse = findViewById(R.id.nameData);
        UIDoc = findViewById(R.id.CUID);
        codCurse = findViewById(R.id.docData);
        nameCurse = findViewById(R.id.nameCurse);
        lunes = findViewById(R.id.lunesHorario);
        martes = findViewById(R.id.martesHorario);
        miercoles = findViewById(R.id.miercolesHorario);
        jueves = findViewById(R.id.jueveHorario);
        viernes = findViewById(R.id.viernesHorario);
        sabado = findViewById(R.id.sabadoHorario);
        context = getApplicationContext();


        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String Id = bundle.getString("docenteId");
            String cod = bundle.getString("curseCod");
            String curse = bundle.getString("nombreCurso");
            String Nombre = bundle.getString("docenteName");
            String lun = bundle.getString("lunesH");
            String mar = bundle.getString("martesH");
            String mie = bundle.getString("miercolesH");
            String jue = bundle.getString("juevesH");
            String vie = bundle.getString("viernesH");
            String sab = bundle.getString("sabadoH");


            nameDocurse.setText(Nombre);
            codCurse.setText(cod);
            nameCurse.setText(curse);
            UIDoc.setText(Id);
            lunes.setText(lun);
            martes.setText(mar);
            miercoles.setText(mie);
            jueves.setText(jue);
            viernes.setText(vie);
            sabado.setText(sab);

            Log.d("Curso", Id);



        }

//        View.OnClickListener EV = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                db.collection("Cursos").document(UIDoc.getText().toString()).update("nombre",nameDocurse.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        Toast.makeText(DetallesCursoAdmin.this, "Data updated", Toast.LENGTH_SHORT).show();
//                        Intent int1 = new Intent(DetallesCursoAdmin.this, ListaCursosAdmin.class);
//                        startActivity(int1);
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(DetallesCursoAdmin.this, "CANT UPDATE", Toast.LENGTH_SHORT).show();
//                        Log.w("Cursos", "Error", e);
//                    }
//                });
//
//            }
//        };
//        btnAct.setOnClickListener(EV);


   }





    public void viewOption(View view) {

        switch (view.getId()) {

            case R.id.btnUpdateEst:
                //Todo: se debe hacer la actualizacion de datos en la DB

                break;

            case R.id.btndeleteEst:
                //Todo: se debe eliminar los datos en la DB

                break;

            case R.id.btnBackEst:
                Intent intentAtras = new Intent(DetallesCursoAdmin.this, ListaCursosAdmin.class);
                startActivity(intentAtras);
                break;

            case R.id.btnLogoutEst:
                Intent intentHist = new Intent(DetallesCursoAdmin.this, LoginActivity.class);
                startActivity(intentHist);
                break;
        }
    }

}