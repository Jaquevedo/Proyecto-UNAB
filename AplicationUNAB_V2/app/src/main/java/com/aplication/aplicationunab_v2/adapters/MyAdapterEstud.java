package com.aplication.aplicationunab_v2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.models.SintomasEstud;

import java.util.List;

public class MyAdapterEstud extends RecyclerView.Adapter<MyViewHolderEstud> implements View.OnClickListener {

    Context context;
    List<SintomasEstud> items;
    View.OnClickListener listener;

    public MyAdapterEstud(Context context, List<SintomasEstud> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public void onClick(View view) {
        if (listener!=null) {
            listener.onClick(view);
        }
    }

    @NonNull
    @Override
    public MyViewHolderEstud onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        view.setOnClickListener((View.OnClickListener)this);
        return new MyViewHolderEstud(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderEstud holder, int position) {
        holder.fechaView.setText(items.get(position).getFecha());
        holder.rta1View.setText(items.get(position).getRtaP1Hist());
        holder.rta2View.setText(items.get(position).getRtaP2Hist());
        holder.rta3View.setText(items.get(position).getRtaP3Hist());
        holder.rta4View.setText(items.get(position).getRtaP4Hist());
        holder.rta5View.setText(items.get(position).getRtaP5Hist());
        holder.estadoView.setText(items.get(position).getEstadoHist());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setOnClickListener(View.OnClickListener listener1) {
        this.listener=listener1;
    }
}
