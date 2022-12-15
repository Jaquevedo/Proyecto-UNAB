package com.example.appmovilunab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Estudente_details extends AppCompatActivity {
    TextView docData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_estudiante);
        Bundle extras = getIntent().getExtras();
        String d1 = extras.getString("dato");
        docData = (TextView) findViewById(R.id.nameData);
        docData.setText(d1);
    }
}