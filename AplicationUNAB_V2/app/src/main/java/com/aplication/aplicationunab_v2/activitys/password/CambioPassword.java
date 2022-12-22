package com.aplication.aplicationunab_v2.activitys.password;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.PatternsCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.activitys.estudiante.PerfilEstudiante;
import com.aplication.aplicationunab_v2.models.Persona;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CambioPassword extends AppCompatActivity {

    EditText actualPass;
    EditText newPass;
    EditText confirmNewPass;
    Button btnCambiarPass;
    String actPass = "";
    String idLoginUser = "";

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Persona persona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambio_password);

        actualPass = findViewById(R.id.InActualPass);
        newPass = findViewById(R.id.InNewPass);
        confirmNewPass = findViewById(R.id.ConfirmPw);
        btnCambiarPass = findViewById(R.id.BtnConfirmar);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            idLoginUser = bundle.getString("id");
        }

        db.collection("Personas").document(idLoginUser).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                persona = new Persona(
                        task.getResult().getId(),
                        task.getResult().getString("email"),
                        task.getResult().getString("nombre"),
                        task.getResult().getString("doc"),
                        task.getResult().getString("programa"),
                        task.getResult().getString("contraseña"),
                        task.getResult().getString("estado"),
                        task.getResult().getString("rol"));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(CambioPassword.this, "Hubo un problema con la actualizacion", Toast.LENGTH_SHORT).show();
                Log.w("Personas", "Error", e);
            }
        });

        btnCambiarPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validacion()) {
                    actPass = persona.getPassword();
                    if (actualPass.getText().toString().contentEquals(actPass)) {

                        persona.setPassword(newPass.getText().toString());

                        db.collection("Personas").document(idLoginUser).update("contraseña", persona.getPassword()).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(CambioPassword.this, "Se cambio con exito.", Toast.LENGTH_SHORT).show();
                                Intent intentRestaurar = new Intent(CambioPassword.this, FinCambioPassword.class);
                                startActivity(intentRestaurar);
                            }
                        });

                    } else {
                        actualPass.setText("");
                        actualPass.setError("Contraseña actual incorrecta");
                    }
                }
            }
        });
    }


    private boolean validacion() {

        boolean answer = true;

        String c1 = actualPass.getText().toString();
        String c2 = newPass.getText().toString();
        String c3 = confirmNewPass.getText().toString();


        if (c1.isEmpty()) {
            actualPass.setError("Completa campo");
            answer = false;
        }

        if (c2.isEmpty()) {
            newPass.setError("Completa campo");
            answer = false;
        }

        if (c3.isEmpty()) {
            confirmNewPass.setError("Completa campo");
            answer = false;
        }

        if (!c2.contentEquals(c3)) {
            newPass.setText("");
            confirmNewPass.setText("");
            confirmNewPass.setError("No coinciden las contraseñas");
            answer = false;
        }
        return answer;
    }
}