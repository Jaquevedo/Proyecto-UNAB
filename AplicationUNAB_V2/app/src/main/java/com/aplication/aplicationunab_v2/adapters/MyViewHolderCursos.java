package com.aplication.aplicationunab_v2.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aplication.aplicationunab_v2.R;

public class MyViewHolderCursos extends RecyclerView.ViewHolder {

    TextView nonView, proView, mailView;


    public MyViewHolderCursos(@NonNull View itemView) {
        super(itemView);

        nonView = itemView.findViewById(R.id.title);
        proView = itemView.findViewById(R.id.desCurse);
        mailView = itemView.findViewById(R.id.descDocente);
    }
}
