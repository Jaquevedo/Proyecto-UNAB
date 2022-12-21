package com.aplication.aplicationunab_v2.activitys.estudiante;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.activitys.admin.DetallesEstudiantes_Admin;
import com.aplication.aplicationunab_v2.activitys.admin.ListaEstudiantesAdmin;
import com.aplication.aplicationunab_v2.activitys.login.LoginActivity;
import com.aplication.aplicationunab_v2.activitys.password.CambioPassword;
import com.aplication.aplicationunab_v2.models.Persona;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class PerfilEstudiante extends AppCompatActivity {

    TextView estado;
    TextView documento;
    TextView nombre;
    TextView programa;
    TextView email;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_estudiante);

        estado = findViewById(R.id.txtEstado);
        documento = findViewById(R.id.docData);
        nombre = findViewById(R.id.nameData);
        programa = findViewById(R.id.lunesHorario);
        email = findViewById(R.id.martesHorario);
        String idLoginUser = "";

        limpiarTextos();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            idLoginUser = bundle.getString("idEstudiante");
        }

        db.collection("Personas").document(idLoginUser).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                nombre.setText(task.getResult().getString("nombre"));
                documento.setText(task.getResult().getString("doc"));
                email.setText(task.getResult().getString("email"));
                programa.setText(task.getResult().getString("programa"));
                if (task.getResult().getString("estado").equals("INHABILITADO")){
                    estado.setText(task.getResult().getString("estado"));
                    estado.setTextColor(getResources().getColor(R.color.rojo));
                }else{
                    estado.setText(task.getResult().getString("estado"));
                    estado.setTextColor(getResources().getColor(R.color.verde_limon));

                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(PerfilEstudiante.this, "Hubo un problema con la actualizacion", Toast.LENGTH_SHORT).show();
                Log.w("Personas", "Error", e);
            }
        });
    }

    private void limpiarTextos() {
        estado.setText("");
        documento.setText("");
        nombre.setText("");
        programa.setText("");
        email.setText("");
    }

    public void viewOption(View view) {

        switch (view.getId()) {

            case R.id.btnSintomas:
                Intent intentEst = new Intent(PerfilEstudiante.this, SintomasEstudiantes.class);
                startActivity(intentEst);
                break;

            case R.id.btnHistoryEst:
                Intent intentAdmin = new Intent(PerfilEstudiante.this, Historial.class);
                startActivity(intentAdmin);
                break;

            case R.id.forgetpass:
                Intent intentProf = new Intent(PerfilEstudiante.this, CambioPassword.class);
                startActivity(intentProf);
                break;

            case R.id.btnBackEst:
                Intent intentEstx = new Intent(PerfilEstudiante.this, LoginActivity.class);
                startActivity(intentEstx);
                break;

            case R.id.btnLogoutEst:
                Intent intentHist = new Intent(PerfilEstudiante.this, LoginActivity.class);
                startActivity(intentHist);
                break;
        }
    }

}