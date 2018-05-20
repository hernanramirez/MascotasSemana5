package com.example.hernanr.mascotas.adapters;


import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hernanr.mascotas.R;
import com.example.hernanr.mascotas.db.MascotasConstructor;
import com.example.hernanr.mascotas.models.Mascota;

import java.util.ArrayList;


public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>  {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {


        final Mascota mascota = mascotas.get(position);

        MascotasConstructor mascotasConstructor = new MascotasConstructor(activity);
        mascotasConstructor.darRaitingMascota(mascota);

        mascotaViewHolder.imgFotoCV.setImageResource(mascota.getFoto());
        mascotaViewHolder.nombreCV.setText(mascota.getNombre());
        mascotaViewHolder.textViewCVContador.setText(String.valueOf(mascotasConstructor.obtenerRaitingMascota(mascota)) + " Likes");

        mascotaViewHolder.imageButtonRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Like " + mascota.getNombre(), Toast.LENGTH_SHORT ).show();

                MascotasConstructor mascotasConstructor = new MascotasConstructor(activity);
                mascotasConstructor.darRaitingMascota(mascota);

                mascotaViewHolder.textViewCVContador.setText(Integer.toString(mascotasConstructor.obtenerRaitingMascota(mascota)) );


            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFotoCV;
        private TextView nombreCV;
        private ImageButton imageButtonRate;
        private TextView textViewCVContador;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoCV = (ImageView) itemView.findViewById(R.id.imgCVMascota);
            nombreCV = (TextView) itemView.findViewById(R.id.textViewCVNombre);
            imageButtonRate = (ImageButton) itemView.findViewById(R.id.imgCVRate);
            textViewCVContador = (TextView) itemView.findViewById(R.id.textViewCVContador);
        }
    }

}