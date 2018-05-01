package com.example.hernanr.mascotas.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hernanr.mascotas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MascotaPerfilFragment extends Fragment {


    public MascotaPerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mascota_perfil, container, false);
    }

}
