package com.example.appmovilunab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Estudente_details extends AppCompatActivity {
    TextView nameData;
    TextView progData;
    TextView emailData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_estudiante);
        Bundle extras = getIntent().getExtras();
        String d1 = extras.getString("dato1");
        String d2 = extras.getString("dato1");
        String d3 = extras.getString("dato2");
        nameData = (TextView) findViewById(R.id.nameData);
        progData = (TextView) findViewById(R.id.progData);
        emailData = (TextView) findViewById(R.id.emailData);
        nameData.setText(d1);
        progData.setText(d2);
        emailData.setText(d3);

    }
}