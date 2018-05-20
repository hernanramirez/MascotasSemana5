package com.example.hernanr.mascotas.presenters;

import android.content.Context;

import com.example.hernanr.mascotas.Fragments.IMascotasListFragmentView;
import com.example.hernanr.mascotas.db.MascotasConstructor;
import com.example.hernanr.mascotas.models.Mascota;

import java.util.ArrayList;

public class MascotasListFragmentPresenter implements IMascotasListFragmentPresenter {

    private IMascotasListFragmentView iMascotasListFragmentView;
    private Context context;
    private MascotasConstructor mascotasConstructor;
    private ArrayList<Mascota> mascotas;

    public MascotasListFragmentPresenter(IMascotasListFragmentView iMascotasListFragmentView, Context context) {
        this.iMascotasListFragmentView = iMascotasListFragmentView;
        this.context = context;
        obtenerMascotaBaseDeDatos();
    }


    @Override
    public void obtenerMascotaBaseDeDatos() {

        mascotasConstructor = new MascotasConstructor(context);
        mascotas =  mascotasConstructor.obtenerDatos();
        mostrarMascotaRV();

    }

    @Override
    public void mostrarMascotaRV() {

        iMascotasListFragmentView.inicializarAdaptdorRV(iMascotasListFragmentView.crearAdaptador(mascotas));
        iMascotasListFragmentView.generarLinearLayoutVertical();

    }


}
