package com.example.hernanr.mascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hernanr.mascotas.adapters.MascotaAdaptador;
import com.example.hernanr.mascotas.models.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar actionBar = (Toolbar) findViewById(R.id.actionbar);

        if (actionBar != null) {
            actionBar.setNavigationIcon(R.drawable.ic_action_pet);
            actionBar.setTitle(R.string.app_name);
            setSupportActionBar(actionBar);
        }


        listaMascotas = (RecyclerView) findViewById(R.id.recyclerListaMascotas);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(linearLayoutManager);
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public void inicializarAdaptador(){

        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);

    }

    public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.camaleon01, "Pepe"));
        mascotas.add(new Mascota(R.drawable.canario, "Solitario"));
        mascotas.add(new Mascota(R.drawable.beto, "Beto"));
        mascotas.add(new Mascota(R.drawable.pablo, "Pable"));
        mascotas.add(new Mascota(R.drawable.merlin, "Merlin"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.mAbout:

                break;
            case R.id.mFavoritos:
                Intent i = new Intent(this, MascotasFavoritas.class);
                startActivity(i);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

}
