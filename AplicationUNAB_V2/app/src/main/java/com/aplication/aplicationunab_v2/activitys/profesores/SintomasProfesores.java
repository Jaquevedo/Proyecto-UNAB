package com.aplication.aplicationunab_v2.activitys.profesores;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.activitys.estudiante.PerfilEstudiante;
import com.aplication.aplicationunab_v2.activitys.estudiante.SintomasEstudiantes;
import com.aplication.aplicationunab_v2.activitys.login.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SintomasProfesores extends AppCompatActivity {

    RadioButton si1, si2, si3, si4, si5, no1, no2, no3, no4, no5;
    TextView fecha;
    Button update;
    String id, rta1, rta2, rta3, rta4, rta5, estado;
    int Counter;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sintomas_profesores);

        no1 = (RadioButton) findViewById(R.id.RadioBtnNo1Profes);
        no2 = (RadioButton) findViewById(R.id.RadioBtnNo2Profess);
        no3 = (RadioButton) findViewById(R.id.RadioBtnNo3Profess);
        no4 = (RadioButton) findViewById(R.id.RadioBtnNo4Profess);
        no5 = (RadioButton) findViewById(R.id.RadioBtnNo5Profess);
        si1 = (RadioButton) findViewById(R.id.RadioBtnSi1Profess);
        si2 = (RadioButton) findViewById(R.id.RadioBtnSi2Profess);
        si3 = (RadioButton) findViewById(R.id.RadioBtnSi3Profess);
        si4 = (RadioButton) findViewById(R.id.RadioBtnSi4Profess);
        si5 = (RadioButton) findViewById(R.id.RadioBtnSi5Profess);
        fecha = findViewById(R.id.TxtDateProf);
        update= findViewById(R.id.BtnRegistSintomProf);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            id = bundle.getString("id");
        }

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validar()){
                    generarRespuesta();
                    conteo();

                    Map<String, Object> e = new HashMap<>();
                    e.put("id", id);
                    e.put("fecha", fecha.getText().toString());
                    e.put("rta1", rta1);
                    e.put("rta2", rta2);
                    e.put("rta3", rta3);
                    e.put("rta4", rta4);
                    e.put("rta5", rta5);
                    e.put("estado", estado);

                    db.collection("Sintomas").add(e).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentReference> task) {
                            Toast.makeText(SintomasProfesores.this, "Sintoma registrado", Toast.LENGTH_SHORT).show();
                        }
                    });

                    db.collection("Personas").document(id).update("estado", estado).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Intent intentProf = new Intent(SintomasProfesores.this, PerfilProfesores.class);
                            intentProf.putExtra("idProfe", id);
                            startActivity(intentProf);
                        }
                    });

                }
            }
        });


    }

    private void generarRespuesta() {
        if(si1.isChecked()){
            rta1 = "si";
        }
        else{
            rta1 = "No";
        }

        if(si2.isChecked()){
            rta2 = "si";
        }
        else{
            rta2 = "No";
        }

        if(si3.isChecked()){
            rta3 = "si";
        }
        else{
            rta3 = "No";
        }

        if(si4.isChecked()){
            rta4 = "si";
        }
        else{
            rta4 = "No";
        }

        if(si5.isChecked()){
            rta5 = "si";
        }
        else{
            rta5 = "No";
        }
    }

    private boolean validar() {
        boolean answer = true;

        if(!si1.isChecked() && !no1.isChecked()){
            si1.setError("Selecciona una opcion");
            no1.setError("Selecciona una opcion");
            answer = false;
        }

        if(!si2.isChecked() && !no2.isChecked()){
            si2.setError("Selecciona una opcion");
            no2.setError("Selecciona una opcion");
            answer = false;
        }

        if(!si3.isChecked() && !no3.isChecked()){
            si3.setError("Selecciona una opcion");
            no3.setError("Selecciona una opcion");
            answer = false;
        }

        if(!si4.isChecked() && !no4.isChecked()){
            si4.setError("Selecciona una opcion");
            no4.setError("Selecciona una opcion");
            answer = false;
        }

        if(!si5.isChecked() && !no5.isChecked()){
            si5.setError("Selecciona una opcion");
            no5.setError("Selecciona una opcion");
            answer = false;
        }

        return answer;
    }

    public void conteo() {
        Counter = 0;

        if (si1.isChecked()){
            Counter++;
        }
        if (si2.isChecked()){
            Counter++;
        }
        if (si3.isChecked()){
            Counter++;
        }
        if (si4.isChecked()){
            Counter ++;
        }
        if (si5.isChecked()){
            Counter ++;
        }

        if (Counter >= 3){
            estado = "INHABILITADO";
        }
        else {
            estado = "HABILITADO";
        }
    }

    public void viewOption(View view) {

        switch (view.getId()) {

            case R.id.BtnVolvSintomProfe:
                Intent intentSintHisP = new Intent(SintomasProfesores.this, PerfilProfesores.class);
                startActivity(intentSintHisP);
                break;

            case R.id.BtnSalirSintomProfe:
                Intent intentSalirSintP = new Intent(SintomasProfesores.this, LoginActivity.class);
                startActivity(intentSalirSintP);
                break;
        }
    }

}