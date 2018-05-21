package com.example.hernanr.mascotas.presenters;

import com.example.hernanr.mascotas.adapters.MascotaAdaptador;
import com.example.hernanr.mascotas.models.Mascota;

import java.util.ArrayList;


public interface IFavoritasView {
    void generarLinearLayoutVerticalFav();
    MascotaAdaptador crearAdaptadorFav(ArrayList<Mascota> mascotasFav);
    void inicializarAdaptadorFav(MascotaAdaptador adapter);
}

