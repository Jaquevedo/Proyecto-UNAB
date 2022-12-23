package com.aplication.aplicationunab_v2.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aplication.aplicationunab_v2.R;

public class MyViewHolderEstud extends RecyclerView.ViewHolder  {

    TextView fecha, rta1, rta2, rta3, rta4, rta5, estado;

    public MyViewHolderEstud(@NonNull View itemView) {
        super(itemView);

        fecha = itemView.findViewById(R.id.TxtFechaEstu);
        rta1 = itemView.findViewById(R.id.TxtRta1Estu);
        rta2 = itemView.findViewById(R.id.TxtRta2Estu);
        rta3 = itemView.findViewById(R.id.TxtRta3Estu);
        rta4 = itemView.findViewById(R.id.TxtRta4Estu);
        rta5 = itemView.findViewById(R.id.TxtRta5Estu);
        estado = itemView.findViewById(R.id.TxtEstadoEstu);
    }
}
