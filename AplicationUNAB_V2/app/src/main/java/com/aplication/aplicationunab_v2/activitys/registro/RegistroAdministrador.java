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

public class RegistroAdministrador extends AppCompatActivity {

    EditText nombre;
    EditText documemto;
    EditText password;
    EditText email;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    List<Persona> personas = new ArrayList<Persona>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_administrador);

        //Adquirir elementos
        email = findViewById(R.id.txtCorreo);
        nombre = findViewById(R.id.txtNombre);
        documemto = findViewById(R.id.txtApellido);
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
                                document.getString("contrase??a"),
                                document.getString("estado"),
                                document.getString("rol"));
                        personas.add(persona);
                    }
                } else {
                    Log.w("RegistroAdministrador", "NO SE CARG?? EL DOC.", task.getException());
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
                    String c3 = documemto.getText().toString();
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
                        e.put("programa", "No aplica");
                        e.put("contrase??a", c5);
                        e.put("estado", "Habilitado");
                        e.put("rol","Administrador");

                        db.collection("Personas").add(e).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentReference> task) {
                                Toast.makeText(RegistroAdministrador.this, "Admin " + c2 + " CREADO.", Toast.LENGTH_SHORT).show();
                                Intent intentProf = new Intent(RegistroAdministrador.this, RegistroExitoso.class);
                                startActivity(intentProf);
                            }
                        });
                    } else {
                        Toast.makeText(RegistroAdministrador.this, "Correo " + c1 + " ya existe.", Toast.LENGTH_SHORT).show();
                        Intent intentProf = new Intent(RegistroAdministrador.this, LoginActivity.class);
                        startActivity(intentProf);
                    }

                }
                break;

            case R.id.imageView3:
                Intent intentEstx = new Intent(RegistroAdministrador.this, HomeRegistro.class);
                startActivity(intentEstx);
                break;

            case R.id.imageView4:
                Intent intentHist = new Intent(RegistroAdministrador.this, LoginActivity.class);
                startActivity(intentHist);
                break;
        }
    }

    private boolean validacion() {

        boolean answer = true;

        String c1 = email.getText().toString();
        String c2 = nombre.getText().toString();
        String c3 = documemto.getText().toString();
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
            documemto.setError("Completa Apellido");
            answer = false;
        }

        if (c5.isEmpty()) {
            password.setError("Completa Contrase??a");
            answer = false;
        }

        return answer;
    }
}