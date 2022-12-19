package com.aplication.aplicationunab_v2.activitys.password;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.activitys.login.LoginActivity;

public class FinRestaurarPassword extends AppCompatActivity {

    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin_restaurar_password);

        btnVolver = findViewById(R.id.BtnVolverEmailEnviado);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentVolver=new Intent(FinRestaurarPassword.this, LoginActivity.class);
                startActivity(intentVolver);
            }
        });
    }
}