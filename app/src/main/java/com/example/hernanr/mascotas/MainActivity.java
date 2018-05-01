package com.example.hernanr.mascotas;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.hernanr.mascotas.Fragments.MascotaPerfilFragment;
import com.example.hernanr.mascotas.Fragments.MascotasListFragment;
import com.example.hernanr.mascotas.adapters.MascotaAdaptador;
import com.example.hernanr.mascotas.adapters.PageAdapter;
import com.example.hernanr.mascotas.models.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private TabLayout tabLayout;
    private RecyclerView listaMascotas;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.actionBar);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        if (toolbar != null) {
            toolbar.setNavigationIcon(R.drawable.ic_action_pet);
            toolbar.setTitle(R.string.app_name);
            setSupportActionBar(toolbar);
        }

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        setUpViewPager();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), "Hiciste Click en este botón!", Toast.LENGTH_SHORT).show();
                }
            });

        }

    }

    private ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new MascotasListFragment());
        fragments.add(new MascotaPerfilFragment());

        return fragments;
    }

    private void setUpViewPager(){

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.dog_house);
        tabLayout.getTabAt(1).setIcon(R.drawable.pet_face);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_acerca:

                View messageView = getLayoutInflater().inflate(R.layout.dialogo_acerca, null, false);

                AlertDialog.Builder dialogo_acerca = new AlertDialog.Builder(MainActivity.this);
                //dialogo_acerca.setIcon(R.drawable.footprint_black);
                dialogo_acerca.setTitle(R.string.app_name);
                dialogo_acerca.setView(messageView);
                dialogo_acerca.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.dismiss();

                    }
                });
                dialogo_acerca.create();

                dialogo_acerca.show();

                break;

            case R.id.action_contacto:
                Intent intent = new Intent(MainActivity.this, ContactoActivity.class);
                startActivity(intent);
                break;

            case R.id.mFavoritos:
                Intent i = new Intent(this, MascotasFavoritas.class);
                startActivity(i);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

}
