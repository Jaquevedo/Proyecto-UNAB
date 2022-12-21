package com.aplication.aplicationunab_v2.activitys.password;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.core.util.PatternsCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.activitys.admin.PerfilAdmin;
import com.aplication.aplicationunab_v2.activitys.estudiante.PerfilEstudiante;
import com.aplication.aplicationunab_v2.activitys.profesores.PerfilProfesores;
import com.aplication.aplicationunab_v2.models.Persona;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class RestaurarPassword extends AppCompatActivity {

    EditText email, confirmEmail;
    Button btnSolicitar;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    List<Persona> personas = new ArrayList<Persona>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurar_password);

        email = findViewById(R.id.InEmail);
        confirmEmail = findViewById(R.id.InConfirmEmail);
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

        btnSolicitar = findViewById(R.id.BtnRestaurar);
        btnSolicitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validacion()) {

                    boolean exixteCorreo = false;
                    String passToSend = "";

                    for (Persona p: personas) {
                        if (p.getEmail().contentEquals(email.getText().toString())){
                            exixteCorreo = true;
                            passToSend = p.getPassword();
                            break;
                        }
                    }

                    if (exixteCorreo){
                        limpiarCampos();
                        enviarMail(passToSend);
                        Intent intentRestaurar=new Intent(RestaurarPassword.this, FinRestaurarPassword.class);
                        startActivity(intentRestaurar);
                    }
                    else{
                        limpiarCampos();
                        Toast.makeText(RestaurarPassword.this, "Correo incorrecto", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }

    private boolean validacion() {

        boolean answer = true;

        String c1 = email.getText().toString();
        String c2 = confirmEmail.getText().toString();

        if (!c1.isEmpty() && !c2.isEmpty() && !c1.contentEquals(c2)){
            confirmEmail.setError("Correo no coincide");
            answer=false;
        }else {
            if(c1.isEmpty()){
                email.setError("Completa los datos");
                answer=false;
            } else if (!PatternsCompat.EMAIL_ADDRESS.matcher(c1).matches()){
                email.setError("Correo no valido");
                answer=false;
            }

            if(c2.isEmpty()){
                confirmEmail.setError("Completa los datos");
                answer=false;
            }else if (!PatternsCompat.EMAIL_ADDRESS.matcher(c2).matches()){
                confirmEmail.setError("Correo no valido");
                answer=false;
            }
        }

        return answer;
    }

    private void limpiarCampos(){
        email.setText("");
        confirmEmail.setText("");
    }

    private void enviarMail(String passToSend){
        //TODO: Realizar rutina para enviar correo

        Toast.makeText(RestaurarPassword.this, "Correo enviado", Toast.LENGTH_SHORT).show();
    }
}