package com.aplication.aplicationunab_v2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.models.cursos;

import java.util.List;

public class adapter_cursos extends RecyclerView.Adapter<MyViewHolder> implements View.OnClickListener {
    Context context;
    List<cursos> items;
    View.OnClickListener listener;

    public adapter_cursos(Context context, List<cursos> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);

        }


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate((R.layout.item_view_cursos),parent,false);
        view.setOnClickListener((View.OnClickListener)this);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.nonView.setText(items.get(position).getCodigo());
        holder.proView.setText(items.get(position).getDocente());
        holder.mailView.setText(items.get(position).getCurso());

   }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void setOnClickListener(View.OnClickListener listener2){
        this.listener=listener2;

    }
}
