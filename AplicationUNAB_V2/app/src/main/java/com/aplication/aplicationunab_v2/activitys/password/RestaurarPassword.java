package com.aplication.aplicationunab_v2.activitys.password;

import android.content.Intent;
import android.support.v4.util.PatternsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.activitys.login.LoginActivity;

import java.util.regex.PatternSyntaxException;

public class RestaurarPassword extends AppCompatActivity {

    EditText email, confirmEmail;
    Button btnSolicitar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurar_password);

        email = findViewById(R.id.InEmail);
        confirmEmail = findViewById(R.id.InConfirmEmail);
        btnSolicitar = findViewById(R.id.BtnRestaurar);

        btnSolicitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validacion()) {
                    // TODO: hacer solicitud
                    Intent intentRestaurar=new Intent(RestaurarPassword.this, FinRestaurarPassword.class);
                    startActivity(intentRestaurar);
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
}