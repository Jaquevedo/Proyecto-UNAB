package com.aplication.aplicationunab_v2.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aplication.aplicationunab_v2.R;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView, checkView;
    TextView nonView, proView, mailView;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView= itemView.findViewById(R.id.icon);
        checkView=itemView.findViewById(R.id.check);
        nonView = itemView.findViewById(R.id.title);
        proView = itemView.findViewById(R.id.descDocente);
        mailView = itemView.findViewById(R.id.desCurse);
    }
}
