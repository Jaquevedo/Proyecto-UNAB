package com.aplication.aplicationunab_v2.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aplication.aplicationunab_v2.R;
import com.aplication.aplicationunab_v2.models.Docentes;

import java.util.List;

public class adapter extends RecyclerView.Adapter<MyViewHolder> implements View.OnClickListener {
    Context context;
    List<Docentes> items;
    View.OnClickListener listener;

    public adapter(Context context, List<Docentes> items) {
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
        View view = LayoutInflater.from(context).inflate((R.layout.item_view),parent,false);
        view.setOnClickListener((View.OnClickListener)this);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        int ico;
        String hab= items.get(position).getEstado();
        if (hab.equals("INHABILITADO")){
            //holder.checkView.setImageResource(R.drawable.inhabilitado);
            Log.d("adapter", hab+" estate");
            ico = R.drawable.inhabilitado;
        }else{

            //holder.checkView.setImageResource(R.drawable.habilitado);
            Log.d("adapter", "Estado "+ hab);
            ico = R.drawable.habilitado;
        }


        holder.nonView.setText(items.get(position).getNombre());
        holder.proView.setText(items.get(position).getDoc());
        holder.mailView.setText(items.get(position).getEmail());
        holder.imageView.setImageResource(R.drawable.banana);
        String habi = items.get(position).getEmail();
        holder.checkView.setImageResource(ico);
        Log.d("adapter", "Email ="+ habi+" Estado "+hab);


//
   }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void setOnClickListener(View.OnClickListener listener2){
        this.listener=listener2;

    }
}
