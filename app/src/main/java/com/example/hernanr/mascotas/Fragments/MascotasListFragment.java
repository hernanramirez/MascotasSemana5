package com.example.hernanr.mascotas.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hernanr.mascotas.R;
import com.example.hernanr.mascotas.adapters.MascotaAdaptador;
import com.example.hernanr.mascotas.models.Mascota;
import com.example.hernanr.mascotas.presenters.IMascotasListFragmentPresenter;
import com.example.hernanr.mascotas.presenters.MascotasListFragmentPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MascotasListFragment extends Fragment implements IMascotasListFragmentView {

    ArrayList<Mascota> mascotas;
    RecyclerView listaMascotas;

    private IMascotasListFragmentPresenter presenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.recycleview_mascotas, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        presenter = new MascotasListFragmentPresenter(this, getContext());

        return v;
    }


    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador =  new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptdorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);

    }
}
