package com.aplication.aplicationunab_v2.activitys.profesores;

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
import com.aplication.aplicationunab_v2.activitys.login.LoginActivity;
import com.aplication.aplicationunab_v2.adapters.MyAdapterProfe;
import com.aplication.aplicationunab_v2.models.SintomasProfe;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class HistorialProfesores extends AppCompatActivity {

    MyAdapterProfe adapterProfe;
    Intent it;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_profesores);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        List<SintomasProfe> sintomasListP = new ArrayList<SintomasProfe>();
        RecyclerView recyclerView = findViewById(R.id.RecyclerViewProf);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db.collection("Sintomas").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.d("HistorialProfesores", document.getId()+" => "+document.getData());
                        SintomasProfe e = new SintomasProfe(document.getId(), document.getString("fecha"), document.getString("rta1"), document.getString("rta2"), document.getString("rta3"), document.getString("rta4"), document.getString("rta5"), document.getString("estado"));
                        sintomasListP.add(e);
                    }
                    adapterProfe = new MyAdapterProfe(getApplicationContext(),sintomasListP);

                    adapterProfe.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("HistorialProfesores", "Presionando: "+sintomasListP.get(recyclerView.getChildAdapterPosition(view)).getFechaP());
                            it = new Intent(context, PerfilProfesores.class);

                            it.putExtra("idHistorialP",sintomasListP.get(recyclerView.getChildAdapterPosition(view)).getIdHistorialP());
                            it.putExtra("fechaP", sintomasListP.get(recyclerView.getChildAdapterPosition(view)).getFechaP());
                            it.putExtra("rtaP1HistP", sintomasListP.get(recyclerView.getChildAdapterPosition(view)).getRtaP1HistP());
                            it.putExtra("rtaP2HistP", sintomasListP.get(recyclerView.getChildAdapterPosition(view)).getRtaP2HistP());
                            it.putExtra("rtaP3HistP", sintomasListP.get(recyclerView.getChildAdapterPosition(view)).getRtaP3HistP());
                            it.putExtra("rtaP4HistP", sintomasListP.get(recyclerView.getChildAdapterPosition(view)).getRtaP4HistP());
                            it.putExtra("rtaP5HistP", sintomasListP.get(recyclerView.getChildAdapterPosition(view)).getRtaP5HistP());
                            it.putExtra("estadoHistP", sintomasListP.get(recyclerView.getChildAdapterPosition(view)).getEstadoHistP());
                            startActivity(it);
                        }
                    });
                    recyclerView.setAdapter(adapterProfe);
                }else {
                    Log.w("HistorialProfesores", "Error cargando el documento", task.getException());
                }
            }
        });
        context=getApplicationContext();
    }

    public void viewOption(View view) {

        switch (view.getId()) {

            case R.id.BtnVolverHistProf:
                Intent intentHistProf = new Intent(HistorialProfesores.this, PerfilProfesores.class);
                startActivity(intentHistProf);
                break;

            case R.id.BtnSalirHistProf:
                Intent intentSalirHistPr = new Intent(HistorialProfesores.this, LoginActivity.class);
                startActivity(intentSalirHistPr);
                break;
        }
    }
}