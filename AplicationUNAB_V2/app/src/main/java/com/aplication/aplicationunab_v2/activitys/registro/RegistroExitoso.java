package com.aplication.aplicationunab_v2.activitys.registro;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.activitys.admin.PerfilAdmin;
import com.aplication.aplicationunab_v2.activitys.estudiante.PerfilEstudiante;
import com.aplication.aplicationunab_v2.activitys.login.LoginActivity;
import com.aplication.aplicationunab_v2.activitys.password.RestaurarPassword;
import com.aplication.aplicationunab_v2.activitys.profesores.PerfilProfesores;
import com.aplication.aplicationunab_v2.models.Persona;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class RegistroExitoso extends AppCompatActivity {

    EditText user, password;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    List<Persona> personas = new ArrayList<Persona>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_exitoso);

        user = findViewById(R.id.EditTextUsuario);
        password = findViewById(R.id.EditTextPassword);
        limpiarCampos();

        db.collection("Personas").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.d("MainActivity", document.getId() + " => " + document.getData());
                        Persona persona = new Persona(
                                document.getId(),
                                document.getString("email"),
                                document.getString("nombre"),
                                document.getString("doc"),
                                document.getString("programa"),
                                document.getString("contraseña"),
                                document.getString("estado"),
                                document.getString("rol"));
                        personas.add(persona);
                    }
                } else {
                    Log.w("RegistroEstudiante", "NO SE CARGÓ EL DOC.", task.getException());
                }
            }
        });
    }

    public void viewLogin(View view) {
        switch (view.getId()) {

            case R.id.Butt11:

                if (validacion()){

                    boolean ingreso = false;

                    for (Persona p: personas) {
                        if (p.getEmail().contentEquals(user.getText().toString()) && p.getPassword().contentEquals(password.getText().toString())){
                            ingreso = true;
                            switch (p.getRol()) {
                                case "Estudiante":
                                    Intent intentEstu = new Intent(RegistroExitoso.this, PerfilEstudiante.class);
                                    startActivity(intentEstu);
                                    Toast.makeText(this, "Estudiantes", Toast.LENGTH_SHORT).show();
                                    break;
                                case "Docente":
                                    Intent intentProf = new Intent(RegistroExitoso.this, PerfilProfesores.class);
                                    startActivity(intentProf);
                                    Toast.makeText(this, "Profesores", Toast.LENGTH_SHORT).show();
                                    break;
                                case "Administrador":
                                    Intent intentAdmin = new Intent(RegistroExitoso.this, PerfilAdmin.class);
                                    startActivity(intentAdmin);
                                    Toast.makeText(this, "Admin", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                            break;
                        }
                    }

                    if (!ingreso){
                        limpiarCampos();
                        Toast.makeText(this, "Usuaio o contra incorrectos", Toast.LENGTH_SHORT).show();
                    }

                }

                break;

            case R.id.TextV13:
                Intent intentProf=new Intent(RegistroExitoso.this, RestaurarPassword.class);
                startActivity(intentProf);
                break;

        }
    }

    private boolean validacion() {

        //Todo: Realizar validacion de los datos
        boolean answer = true;

        String c1 = user.getText().toString();
        String c2 = password.getText().toString();


        if(c1.isEmpty()){
            user.setError("Completa los datos");
            answer=false;
        }

        if(c2.isEmpty()){
            password.setError("Completa los datos");
            answer=false;
        }

        return answer;
    }

    private void limpiarCampos(){
        user.setText("");
        password.setText("");
    }
}