package com.example.hernanr.mascotas.Fragments;

import com.example.hernanr.mascotas.adapters.MascotaAdaptador;
import com.example.hernanr.mascotas.models.Mascota;

import java.util.ArrayList;

public interface IMascotasListFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptdorRV(MascotaAdaptador adaptador);
}
