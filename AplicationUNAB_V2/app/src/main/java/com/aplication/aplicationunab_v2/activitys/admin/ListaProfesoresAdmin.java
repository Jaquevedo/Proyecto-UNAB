package com.aplication.aplicationunab_v2.activitys.admin;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.adapters.adapter;
import com.aplication.aplicationunab_v2.models.docentes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ListaProfesoresAdmin extends AppCompatActivity {
    adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_docentes);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        List<docentes> docente = new ArrayList<docentes>();
        RecyclerView reciclerView = findViewById(R.id.RVdocentes);
        reciclerView.setLayoutManager(new LinearLayoutManager(this));

        db.collection("Docentes").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    for (QueryDocumentSnapshot document : task.getResult()){
                        Log.d("MainActivity", document.getId()+" => "+document.getData());
                        docentes namedocente = new docentes(document.getId(),document.getString("nombre"),document.getString("doc"),document.getString("email"),document.getString("estado"));
                        docente.add(namedocente);



                    }
                    adapter = new adapter(getApplicationContext(),docente);
                    reciclerView.setAdapter(adapter);
                }else{
                    Log.w("MainActivity", "NO SE CARGÓ EL DOC.",task.getException());
                }

            }
        });
    }
//
//    public void viewOption(View view) {
//
//        switch (view.getId()) {
//
//            case R.id.EstDetails:
//                Intent intentEst = new Intent(ListaProfesoresAdmin.this, DetallesProfesEstudiantes_Admin.class);
//                startActivity(intentEst);
//                break;
//
//            case R.id.btcatrasEst:
//                Intent intentEstx = new Intent(ListaProfesoresAdmin.this, PerfilAdmin.class);
//                startActivity(intentEstx);
//                break;
//
//            case R.id.btnHistLogEst:
//                Intent intentHist = new Intent(ListaProfesoresAdmin.this, LoginActivity.class);
//                startActivity(intentHist);
//                break;
//        }
//    }
}