package com.example.hernanr.mascotas.presenters;

import android.content.Context;

import com.example.hernanr.mascotas.db.MascotasConstructor;
import com.example.hernanr.mascotas.models.Mascota;

import java.util.ArrayList;


public class FavoritasPresenter implements IFavoritasPresenter {

    private IFavoritasView iFavoritasView;
    private Context context;
    private MascotasConstructor mascotasConstructor;
    private ArrayList<Mascota> mascotasFav;

    public FavoritasPresenter(IFavoritasView iFavoritasView, Context context) {
        this.iFavoritasView = iFavoritasView;
        this.context = context;
        obtenerMascotasFav();
    }
    @Override
    public void obtenerMascotasFav() {
        mascotasConstructor = new MascotasConstructor(context);
        mascotasFav = mascotasConstructor.obtenerFavoritos();
        mostrarMascotaFav();
    }
    @Override
    public void mostrarMascotaFav() {
        iFavoritasView.inicializarAdaptadorFav(iFavoritasView.crearAdaptadorFav(mascotasFav));
        iFavoritasView.generarLinearLayoutVerticalFav();
    }
}
