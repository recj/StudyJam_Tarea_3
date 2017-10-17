package com.example.rodrigo.studyjam_tarea3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo on 16/10/2017.
 */

public class AplicacionAdapter extends RecyclerView.Adapter<AplicacionAdapter.AplicacionViewholder> {

    List<Aplicacion> dataset;
    Context context;
    onAplicacionSelectedListener onAplicacionSelectedListener;


    public interface onAplicacionSelectedListener{
        void onAplicacionSelected(Aplicacion aplicacion);
    }
    public AplicacionAdapter(Context context, onAplicacionSelectedListener onAplicacionSelectedListener) {
        this.context = context;
        this.dataset = new ArrayList<>();
        this.onAplicacionSelectedListener = onAplicacionSelectedListener;
    }

    @Override
    public AplicacionViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_apps,parent,false);
        return new AplicacionViewholder(view);
    }
    @Override
    public void onBindViewHolder(AplicacionViewholder holder, int position) {
        Aplicacion aplicacion = dataset.get(position);
        holder.nombre.setText(aplicacion.getNombre());
        holder.imagen.setImageResource(aplicacion.getImagen());

        holder.setOnAplicacionSelectedListener(aplicacion, onAplicacionSelectedListener);
    }
    @Override
    public int getItemCount() {
        return dataset.size();
    }
    public class AplicacionViewholder extends RecyclerView.ViewHolder {

        View cardView;
        ImageView imagen;
        TextView nombre;

        public AplicacionViewholder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_main);
            imagen = itemView.findViewById(R.id.imagen_item);
            nombre = itemView.findViewById(R.id.texto_item);
        }

        public void setOnAplicacionSelectedListener(final Aplicacion aplicacion, final onAplicacionSelectedListener onAplicacionSelectedListener) {
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onAplicacionSelectedListener.onAplicacionSelected(aplicacion);
                }
            });
        }
    }

    public void setDataset(List<Aplicacion> aplicacion) {
        if (aplicacion == null){
            dataset = new ArrayList<>();
        }
        else{
            dataset = aplicacion;
        }
        notifyDataSetChanged();
    }




}
