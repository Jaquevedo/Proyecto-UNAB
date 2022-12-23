package com.aplication.aplicationunab_v2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.models.SintomasProfe;

import java.util.List;

public class MyAdapterProfe extends RecyclerView.Adapter<MyViewHolderProfe> implements View.OnClickListener{

    Context context;
    List<SintomasProfe> items;
    View.OnClickListener listener;

    public MyAdapterProfe(Context context, List<SintomasProfe> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public void onClick(View view) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolderProfe onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.informe_historial_profesor, parent, false);
        view.setOnClickListener((View.OnClickListener)this);
        return new MyViewHolderProfe(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderProfe holder, int position) {
        holder.fecha.setText(items.get(position).getFechaP());
        holder.rta1.setText(items.get(position).getRtaP1HistP());
        holder.rta2.setText(items.get(position).getRtaP2HistP());
        holder.rta3.setText(items.get(position).getRtaP3HistP());
        holder.rta4.setText(items.get(position).getRtaP4HistP());
        holder.rta5.setText(items.get(position).getRtaP5HistP());
        holder.estado.setText(items.get(position).getEstadoHistP());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setOnClickListener(View.OnClickListener listener1) {
        this.listener=listener1;
    }
}
