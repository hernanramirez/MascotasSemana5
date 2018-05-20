package com.example.hernanr.mascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.hernanr.mascotas.adapters.MascotaAdaptador;
import com.example.hernanr.mascotas.models.Mascota;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotasFAV;
    private RecyclerView listaMascotasFAV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota_favorita);

        Toolbar actionBar = (Toolbar) findViewById(R.id.actionBar);

        if (actionBar != null) {
            //actionBar.setNavigationIcon(R.drawable.ic_action_pet);
            actionBar.setTitle(R.string.app_name);
            setSupportActionBar(actionBar);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listaMascotasFAV = (RecyclerView) findViewById(R.id.recyclerListaMascotasFAV);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotasFAV.setLayoutManager(linearLayoutManager);
        inicializarListaMascotas();
        inicializarAdaptador();

    }


    public void inicializarAdaptador(){

        MascotaAdaptador adaptador = new MascotaAdaptador(mascotasFAV, this);
        listaMascotasFAV.setAdapter(adaptador);

    }

    public void inicializarListaMascotas() {

        mascotasFAV = new ArrayList<Mascota>();

        /*
        mascotasFAV.add(new Mascota(R.drawable.canario, "Solitario"));
        mascotasFAV.add(new Mascota(R.drawable.camaleon01, "Pepe"));
        mascotasFAV.add(new Mascota(R.drawable.beto, "Beto"));
        mascotasFAV.add(new Mascota(R.drawable.pablo, "Pable"));
        mascotasFAV.add(new Mascota(R.drawable.merlin, "Merlin"));
        */
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_activity_2, menu);
        return true;

    }

}
