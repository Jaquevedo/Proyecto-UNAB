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
import com.aplication.aplicationunab_v2.adapters.adapter_cursos;
import com.aplication.aplicationunab_v2.models.cursos;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ListaCursosAdmin extends AppCompatActivity {

    adapter_cursos adapter;
    Intent it;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_cursos);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        List<cursos> curso = new ArrayList<cursos>();
        RecyclerView reciclerView = findViewById(R.id.RVdocentes);
        reciclerView.setLayoutManager(new LinearLayoutManager(this));

        db.collection("Cursos").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    for (QueryDocumentSnapshot document : task.getResult()){
                        Log.d("ListCurse", document.getId()+" => "+document.getData());
                        cursos namedocente = new cursos(document.getId(),document.getString("docente"),document.getString("codigo"),document.getString("curso"),document.getString("programa"), document.getString("lunes"),document.getString("martes"),document.getString("miercoles"),document.getString("jueves"),document.getString("viernes"),document.getString("sabado"));
                        curso.add(namedocente);
                    }
                    adapter = new adapter_cursos(getApplicationContext(),curso);

                    adapter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("Lista cursos", "Presionado: "+curso.get(reciclerView.getChildAdapterPosition(view)).getCurso());
                            it =new Intent(context, DetallesCursoAdmin.class);

                            it.putExtra("docenteId",curso.get(reciclerView.getChildAdapterPosition(view)).getUID());
                            it.putExtra("docenteName",curso.get(reciclerView.getChildAdapterPosition(view)).getDocente());
                            it.putExtra("curseName",curso.get(reciclerView.getChildAdapterPosition(view)).getCurso());
                            it.putExtra("curseCod",curso.get(reciclerView.getChildAdapterPosition(view)).getCodigo());
                            it.putExtra("nombreCurso",curso.get(reciclerView.getChildAdapterPosition(view)).getPrograma());
                            it.putExtra("lunesH",curso.get(reciclerView.getChildAdapterPosition(view)).getLunes());
                            it.putExtra("martesH",curso.get(reciclerView.getChildAdapterPosition(view)).getMartes());
                            it.putExtra("miercolesH",curso.get(reciclerView.getChildAdapterPosition(view)).getMiercoles());
                            it.putExtra("juevesH",curso.get(reciclerView.getChildAdapterPosition(view)).getJueves());
                            it.putExtra("viernesH",curso.get(reciclerView.getChildAdapterPosition(view)).getViernes());
                            it.putExtra("sabadoH",curso.get(reciclerView.getChildAdapterPosition(view)).getSabado());

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

//    public void viewOption(View view) {
//
//        switch (view.getId()) {
//
//            case R.id.EstDetails:
//                Intent intentEst = new Intent(ListaCursosAdmin.this, DetallesCursoAdmin.class);
//                startActivity(intentEst);
//                break;
//
//            case R.id.ListEstLgtBtn:
//                Intent intentHist = new Intent(ListaCursosAdmin.this, LoginActivity.class);
//                startActivity(intentHist);
//                break;
//        }
//    }
}