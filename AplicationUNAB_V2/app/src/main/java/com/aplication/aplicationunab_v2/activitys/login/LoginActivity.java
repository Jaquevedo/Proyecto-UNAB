package com.aplication.aplicationunab_v2.activitys.login;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.activitys.admin.PerfilAdmin;
import com.aplication.aplicationunab_v2.activitys.estudiante.PerfilEstudiante;
import com.aplication.aplicationunab_v2.activitys.password.RestaurarPassword;
import com.aplication.aplicationunab_v2.activitys.profesores.PerfilProfesores;
import com.aplication.aplicationunab_v2.activitys.registro.HomeRegistro;
import com.aplication.aplicationunab_v2.models.Persona;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    EditText user, password;

    //Todo: Datos provisionales
    Persona estudiante;
    Persona profesor;
    Persona admin;
    List<Persona> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = findViewById(R.id.username);
        password = findViewById(R.id.password);

        //Todo: traer esta informacion dela DB, DATOS PROVISIONALES
        estudiante = new Persona("1", "ja", "Juan Angel", "Quevedo", "N/A","1234","estudiante");
        profesor = new Persona("2", "ma","Miguel Angel", "Rodriguez", "N/A","1234","profesor");
        admin = new Persona("3", "s", "Samuel", "Perez", "N/A","1234","admin");

        items.add(estudiante);
        items.add(profesor);
        items.add(admin);
    }

    public void viewLogin(View view) {
        switch (view.getId()) {

            case R.id.registrar:
                Intent intentHist = new Intent(LoginActivity.this, HomeRegistro.class);
                startActivity(intentHist);
                break;

            case R.id.login:

                if (validacion()){

                    boolean ingreso = false;

                    for (Persona p: items) {
                        if (p.getUser().contentEquals(user.getText().toString()) && p.getPassword().contentEquals(password.getText().toString())){
                            ingreso = true;
                            switch (p.getRol()) {
                                case "estudiante":
                                    Intent intentEstu = new Intent(LoginActivity.this, PerfilEstudiante.class);
                                    startActivity(intentEstu);
                                    Toast.makeText(this, "Estudiantes", Toast.LENGTH_SHORT).show();
                                    break;
                                case "profesor":
                                    Intent intentProf = new Intent(LoginActivity.this, PerfilProfesores.class);
                                    startActivity(intentProf);
                                    Toast.makeText(this, "Profesores", Toast.LENGTH_SHORT).show();
                                    break;
                                case "admin":
                                    Intent intentAdmin = new Intent(LoginActivity.this, PerfilAdmin.class);
                                    startActivity(intentAdmin);
                                    Toast.makeText(this, "Admin", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                            break;
                        }
                    }

                    if (!ingreso){
                        user.setText("");
                        password.setText("");
                        Toast.makeText(this, "Usuaio o contra incorrectos", Toast.LENGTH_SHORT).show();
                    }

                }
                break;

            case R.id.forgetpass:
                Intent intentEst = new Intent(LoginActivity.this, RestaurarPassword.class);
                startActivity(intentEst);
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
}