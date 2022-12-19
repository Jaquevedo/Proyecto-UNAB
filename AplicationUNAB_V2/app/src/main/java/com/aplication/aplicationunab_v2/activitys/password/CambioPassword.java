package com.aplication.aplicationunab_v2.activitys.password;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aplication.aplicationunab_v2.R;

public class CambioPassword extends AppCompatActivity {

    Button btnCambiarPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambio_password);

        btnCambiarPass = findViewById(R.id.BtnConfirmar);
        btnCambiarPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validacion()) {
                    // TODO: hacer solicitud
                    Intent intentRestaurar=new Intent(CambioPassword.this, FinCambioPassword.class);
                    startActivity(intentRestaurar);
                }
            }
        });
    }


    private boolean validacion() {

        boolean answer = true;

//        String c1 = email.getText().toString();
//        String c2 = confirmEmail.getText().toString();
//
//        if (!c1.isEmpty() && !c2.isEmpty() && !c1.contentEquals(c2)){
//            confirmEmail.setError("Correo no coincide");
//            answer=false;
//        }else {
//            if(c1.isEmpty()){
//                email.setError("Completa los datos");
//                answer=false;
//            } else if (!PatternsCompat.EMAIL_ADDRESS.matcher(c1).matches()){
//                email.setError("Correo no valido");
//                answer=false;
//            }
//
//            if(c2.isEmpty()){
//                confirmEmail.setError("Completa los datos");
//                answer=false;
//            }else if (!PatternsCompat.EMAIL_ADDRESS.matcher(c2).matches()){
//                confirmEmail.setError("Correo no valido");
//                answer=false;
//            }
//        }

        return answer;
    }
}