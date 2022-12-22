package com.aplication.aplicationunab_v2.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aplication.aplicationunab_v2.R;

public class MyViewHolderEstud extends RecyclerView.ViewHolder  {

    TextView fechaView, rta1View, rta2View, rta3View, rta4View, rta5View, estadoView;

    public MyViewHolderEstud(@NonNull View itemView) {
        super(itemView);

        fechaView = itemView.findViewById(R.id.TxtFechaEstu);
        rta1View = itemView.findViewById(R.id.TxtRta1Estu);
        rta2View = itemView.findViewById(R.id.TxtRta2Estu);
        rta3View = itemView.findViewById(R.id.TxtRta3Estu);
        rta4View = itemView.findViewById(R.id.TxtRta4Estu);
        rta5View = itemView.findViewById(R.id.TxtRta5Estu);
        estadoView = itemView.findViewById(R.id.TxtEstadoEstu);
    }
}
