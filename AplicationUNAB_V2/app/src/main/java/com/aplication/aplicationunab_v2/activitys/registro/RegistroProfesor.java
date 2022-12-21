package com.aplication.aplicationunab_v2.activitys.registro;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.PatternsCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.activitys.login.LoginActivity;
import com.aplication.aplicationunab_v2.models.Docentes;
import com.aplication.aplicationunab_v2.models.Estudiante;
import com.aplication.aplicationunab_v2.models.Persona;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistroProfesor extends AppCompatActivity {

    EditText nombre;
    EditText apellido;
    EditText programa;
    EditText password;
    EditText email;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    List<Persona> personas = new ArrayList<Persona>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_profesor);

        email = findViewById(R.id.txtCorreo);
        nombre = findViewById(R.id.txtNombre);
        apellido = findViewById(R.id.txtApellido);
        programa = findViewById(R.id.txtPrograma);
        password = findViewById(R.id.txtPass);

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
                    Log.w("RegistroProfesor", "NO SE CARGÓ EL DOC.", task.getException());
                }
            }
        });
    }

    public void viewOption(View view){

        switch (view.getId()){
            case R.id.Butt10:
                if (validacion()) {

                    String c1 = email.getText().toString();
                    String c2 = nombre.getText().toString();
                    String c3 = apellido.getText().toString();
                    String c4 = programa.getText().toString();
                    String c5 = password.getText().toString();
                    boolean noExisteCorreo = true;

                    for (Persona p : personas) {
                        if (p.getEmail().contentEquals(email.getText().toString())) {
                            noExisteCorreo = false;
                            break;
                        }
                    }

                    if (noExisteCorreo) {

                        Map<String, Object> e = new HashMap<>();
                        e.put("email", c1);
                        e.put("nombre", c2);
                        e.put("doc", c3);
                        e.put("programa", c4);
                        e.put("contraseña", c5);
                        e.put("estado", "Habilitado");
                        e.put("rol","Docente");

                        db.collection("Personas").add(e).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentReference> task) {
                                Toast.makeText(RegistroProfesor.this, "Docente " + c2 + " CREADO.", Toast.LENGTH_SHORT).show();
                                Intent intentProf = new Intent(RegistroProfesor.this, RegistroExitoso.class);
                                startActivity(intentProf);
                            }
                        });
                    } else {
                        Toast.makeText(RegistroProfesor.this, "Correo " + c1 + " ya existe.", Toast.LENGTH_SHORT).show();
                        Intent intentProf = new Intent(RegistroProfesor.this, LoginActivity.class);
                        startActivity(intentProf);
                    }

                }
                break;

            case R.id.imageView3:
                Intent intentEstx = new Intent(RegistroProfesor.this, HomeRegistro.class);
                startActivity(intentEstx);
                break;

            case R.id.imageView4:
                Intent intentHist = new Intent(RegistroProfesor.this, LoginActivity.class);
                startActivity(intentHist);
                break;
        }
    }

    private boolean validacion() {
        boolean answer = true;

        String c1 = email.getText().toString();
        String c2 = nombre.getText().toString();
        String c3 = apellido.getText().toString();
        String c4 = programa.getText().toString();
        String c5 = password.getText().toString();


        if (c1.isEmpty()) {
            email.setError("Completa correo");
            answer = false;
        } else if (!PatternsCompat.EMAIL_ADDRESS.matcher(c1).matches()) {
            email.setError("Correo no valido");
            answer = false;
        }

        if (c2.isEmpty()) {
            nombre.setError("Completa Nombre");
            answer = false;
        }

        if (c3.isEmpty()) {
            apellido.setError("Completa Apellido");
            answer = false;
        }

        if (c4.isEmpty()) {
            programa.setError("Completa Programa");
            answer = false;
        }

        if (c5.isEmpty()) {
            password.setError("Completa Contraseña");
            answer = false;
        }

        return answer;
    }
}