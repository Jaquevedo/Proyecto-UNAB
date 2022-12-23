package com.aplication.aplicationunab_v2.activitys.estudiante;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.activitys.admin.DetallesCursoAdmin;
import com.aplication.aplicationunab_v2.activitys.login.LoginActivity;
import com.aplication.aplicationunab_v2.adapters.MyAdapterEstud;
import com.aplication.aplicationunab_v2.models.SintomasEstud;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Historial extends AppCompatActivity {

    MyAdapterEstud adapterEstud;
    Intent it;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        List<SintomasEstud> sintomasList = new ArrayList<SintomasEstud>();
        RecyclerView recyclerView = findViewById(R.id.RecyclerViewEstud);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db.collection("Sintomas").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.d("Historial", document.getId()+" => "+document.getData());
                        SintomasEstud e = new SintomasEstud(document.getId(), document.getString("fecha"), document.getString("rta1"), document.getString("rta2"), document.getString("rta3"), document.getString("rta4"), document.getString("rta5"), document.getString("estado"));
                        sintomasList.add(e);
                    }
                    adapterEstud = new MyAdapterEstud(getApplicationContext(),sintomasList);

                    adapterEstud.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {
                           Log.d("Historial", "Presionando: "+sintomasList.get(recyclerView.getChildAdapterPosition(view)).getFecha());
                           it = new Intent(context, PerfilEstudiante.class);

                           it.putExtra("idHistorial",sintomasList.get(recyclerView.getChildAdapterPosition(view)).getIdHistorial());
                           it.putExtra("fecha", sintomasList.get(recyclerView.getChildAdapterPosition(view)).getFecha());
                           it.putExtra("rtaP1Hist", sintomasList.get(recyclerView.getChildAdapterPosition(view)).getRtaP1Hist());
                           it.putExtra("rtaP2Hist", sintomasList.get(recyclerView.getChildAdapterPosition(view)).getRtaP2Hist());
                           it.putExtra("rtaP3Hist", sintomasList.get(recyclerView.getChildAdapterPosition(view)).getRtaP3Hist());
                           it.putExtra("rtaP4Hist", sintomasList.get(recyclerView.getChildAdapterPosition(view)).getRtaP4Hist());
                           it.putExtra("rtaP5Hist", sintomasList.get(recyclerView.getChildAdapterPosition(view)).getRtaP5Hist());
                           it.putExtra("estadoHist", sintomasList.get(recyclerView.getChildAdapterPosition(view)).getEstadoHist());
                           startActivity(it);
                        }
                    });
                    recyclerView.setAdapter(adapterEstud);
                }else {
                    Log.w("Historial", "Error cargando el documento", task.getException());
                }
            }
        });
        context=getApplicationContext();
    }

    public void viewOption(View view) {

        switch (view.getId()) {

            case R.id.BtnVolverHistEstud:
                Intent intentHistEstu = new Intent(Historial.this, PerfilEstudiante.class);
                startActivity(intentHistEstu);
                break;

            case R.id.BtnSalirHistEstud:
                Intent intentSalirHistEs = new Intent(Historial.this, LoginActivity.class);
                startActivity(intentSalirHistEs);
                break;
        }
    }
}