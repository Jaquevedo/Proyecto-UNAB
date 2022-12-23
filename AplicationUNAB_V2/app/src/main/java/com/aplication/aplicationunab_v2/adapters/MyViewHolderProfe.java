package com.aplication.aplicationunab_v2.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aplication.aplicationunab_v2.R;

public class MyViewHolderProfe extends RecyclerView.ViewHolder {

    TextView fecha, rta1, rta2, rta3, rta4, rta5, estado;

    public MyViewHolderProfe(@NonNull View itemView) {
        super(itemView);

        fecha = itemView.findViewById(R.id.TxtFechaProf);
        rta1 = itemView.findViewById(R.id.TxtRta1Prof);
        rta2 = itemView.findViewById(R.id.TxtRta2Prof);
        rta3 = itemView.findViewById(R.id.TxtRta3Prof);
        rta4 = itemView.findViewById(R.id.TxtRta4Prof);
        rta5 = itemView.findViewById(R.id.TxtRta5Prof);
        estado = itemView.findViewById(R.id.TxtEstadoProf);
    }
}
