package com.aplication.aplicationunab_v2.activitys.admin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.adapters.adapter;
import com.aplication.aplicationunab_v2.models.Persona;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ListaProfesoresAdmin extends AppCompatActivity {

    adapter adapter;
    Intent it;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_docentes);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        List<Persona> docentes = new ArrayList<Persona>();
        RecyclerView reciclerView = findViewById(R.id.RVdocentes);
        reciclerView.setLayoutManager(new LinearLayoutManager(this));

         db.collection("Personas").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
             CollectionReference database1 = db.collection("Personas");
             Query notCapitalQuery = database1.whereEqualTo("rol", true);
             //database1.whereIn("rol", ("docente", true);





             @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    for (QueryDocumentSnapshot document : task.getResult()){
                        Log.d("MainActivity", document.getId()+" => "+document.getData());

                        if(document.getString("rol").contentEquals("Docente")){
                            Persona docente = new Persona(
                                    document.getId(),
                                    document.getString("email"),
                                    document.getString("nombre"),
                                    document.getString("doc"),
                                    document.getString("programa"),
                                    document.getString("contraseña"),
                                    document.getString("estado"),
                                    document.getString("rol"));
                            docentes.add(docente);
                        }

                    }
                    adapter = new adapter(getApplicationContext(), docentes);
                    adapter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("MainActivity", "Presionado: "+ docentes.get(reciclerView.getChildAdapterPosition(view)).getNombres());
                            it =new Intent(context, DetallesProfesEstudiantes_Admin.class);

                            it.putExtra("docenteId",docentes.get(reciclerView.getChildAdapterPosition(view)).getuId());
                            it.putExtra("docenteName",docentes.get(reciclerView.getChildAdapterPosition(view)).getNombres());
                            it.putExtra("docenteDoc",docentes.get(reciclerView.getChildAdapterPosition(view)).getDocumento());
                            it.putExtra("docenteEmail",docentes.get(reciclerView.getChildAdapterPosition(view)).getEmail());
                            it.putExtra("docenteProg",docentes.get(reciclerView.getChildAdapterPosition(view)).getPrograma());
                            it.putExtra("docentePass",docentes.get(reciclerView.getChildAdapterPosition(view)).getPassword());
                            String stat = docentes.get(reciclerView.getChildAdapterPosition(view)).getEstado();
                            if (stat.equals("HABILITADO")){
                                it.putExtra("docenteEstado", "HABILITADO");
                            }else{
                                it.putExtra("docenteEstado", "INHABILITADO");

                            }

                            startActivity(it);
                        }
                    });
                    reciclerView.setAdapter(adapter);
                }else{
                    Log.w("MainActivity", "NO SE CARGÓ EL DOC.",task.getException());
                }
            }
        });
        context=getApplicationContext();
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