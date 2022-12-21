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
        btnAct=findViewById(R.id.btnUpdateEst);
        btnBorr=findViewById(R.id.btndeleteEst);
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

        View.OnClickListener EV = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.collection("Cursos").document(UIDoc.getText().toString()).update("nombre",nameDocurse.getText().toString(), "codigo", codCurse.getText().toString(), "lunes", lunes.getText().toString(),"martes", martes.getText().toString(), "miercoles",miercoles.getText().toString(),"jueves", jueves.getText().toString(),"viernes", viernes.getText().toString(), "sabado", sabado.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(DetallesCursoAdmin.this, "Data updated", Toast.LENGTH_SHORT).show();
                        Intent int1 = new Intent(DetallesCursoAdmin.this, ListaCursosAdmin.class);
                        startActivity(int1);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(DetallesCursoAdmin.this, "CANT UPDATE", Toast.LENGTH_SHORT).show();
                        Log.w("Cursos", "Error", e);
                    }
                });

            }
        };
        btnAct.setOnClickListener(EV);
        btnBorr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DetallesCursoAdmin.this);
                builder.setMessage("¿Desea eliminar el curso?").setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        db.collection("Cursos").document(UIDoc.getText().toString()).delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(context, "¡Curso eliminado de la base de datos!", Toast.LENGTH_SHORT).show();
                                Intent it = new Intent(context, ListaEstudiantesAdmin.class);
                                startActivity(it);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("est","Error "+ e);
                            }
                        });
                    }
                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();
            }
        });



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