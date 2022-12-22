package com.aplication.aplicationunab_v2.activitys.admin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.activitys.login.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

public class DetallesEstudiantes_Admin extends AppCompatActivity {

    EditText nameDoc, docDoc, emailDoc,progDoc,UIDoc, passDoc;
    TextView statDoc;
    Button btnAct, btnBorr;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_profes_estudiantes_admin);

        nameDoc=findViewById(R.id.nameData);
        docDoc=findViewById(R.id.docData);
        emailDoc=findViewById(R.id.martesHorario);
        progDoc=findViewById(R.id.lunesHorario);
        btnAct=findViewById(R.id.btnUpdateEst);
        btnBorr=findViewById(R.id.btndeleteEst);
        UIDoc=findViewById(R.id.uidt);
        passDoc=findViewById(R.id.passData);
        statDoc=findViewById(R.id.statusDoc);
        context=getApplicationContext();

        FirebaseFirestore db= FirebaseFirestore.getInstance();

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            String Id = bundle.getString("docenteId");
            String email = bundle.getString("docenteEmail");
            String Nombre = bundle.getString("docenteName");
            String prog = bundle.getString("docenteProg");
            String doc = bundle.getString("docenteDoc");
            String pass = bundle.getString("docentePass");
            String status = bundle.getString("docenteEstado");

            nameDoc.setText(Nombre);
            docDoc.setText(doc);
            emailDoc.setText(email);
            progDoc.setText(prog);
            UIDoc.setText(Id);
            passDoc.setText(pass);
            if (status.equals("INHABILITADO")){
                statDoc.setText(status);
                statDoc.setTextColor(getResources().getColor(R.color.rojo));
            }else{
                statDoc.setText(status);
                statDoc.setTextColor(getResources().getColor(R.color.verde_limon));

            }

            Log.d("Docentes", Id);
        }
        View.OnClickListener ev = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.collection("Personas").document(UIDoc.getText().toString()).update("nombre",nameDoc.getText().toString(),"pass",passDoc.getText().toString(),"doc",docDoc.getText().toString(),"email",emailDoc.getText().toString(),"programa",progDoc.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(DetallesEstudiantes_Admin.this, "Datos Actualizados", Toast.LENGTH_SHORT).show();
                        Intent it1 = new Intent(DetallesEstudiantes_Admin.this, ListaEstudiantesAdmin.class);
                        startActivity(it1);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(DetallesEstudiantes_Admin.this, "Hubo un problema con la actualizacion", Toast.LENGTH_SHORT).show();
                        Log.w("Personas","Error", e);
                    }
                });
            }
        };
        btnAct.setOnClickListener(ev);
        btnBorr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DetallesEstudiantes_Admin.this);
                builder.setMessage("¿Desea eliminar los datos del estudiante?").setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        db.collection("Personas").document(UIDoc.getText().toString()).delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(context, "¡Estudiante eliminado de la base de datos!", Toast.LENGTH_SHORT).show();
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

            case R.id.btnHistoryEst:
                Intent intentEstx = new Intent(DetallesEstudiantes_Admin.this, HistorialProfesEstudiantes_Admin.class);
                startActivity(intentEstx);
                break;

            case R.id.btndeleteEst:
                //Todo: se debe eliminar los datos en la DB

                break;

            case R.id.btnLogoutEst:
                Intent intentHist = new Intent(DetallesEstudiantes_Admin.this, LoginActivity.class);
                startActivity(intentHist);
                break;
            case R.id.BackListDoc:
                Intent intentback = new Intent(DetallesEstudiantes_Admin.this, ListaEstudiantesAdmin.class);
                startActivity(intentback);
                break;
        }
    }
}