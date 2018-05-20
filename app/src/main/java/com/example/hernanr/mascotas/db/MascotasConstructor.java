package com.example.hernanr.mascotas.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.hernanr.mascotas.R;
import com.example.hernanr.mascotas.models.Mascota;

import java.util.ArrayList;

public class MascotasConstructor {

    private static final int RAITING = 1;
    private Context context;

    public MascotasConstructor(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() {
        MascotasDB db = new MascotasDB(context);

        if (db.mascotasVacio()) {
            insertarCincoMascotas(db);
        }

        return  db.obtenerMascotas();
    }

    public ArrayList<Mascota> obtenerFavoritos() {
        MascotasDB db = new MascotasDB(context);
        return  db.obtenerMascotasFavoritas();
    }


    public void darRaitingMascota(Mascota mascota){
        MascotasDB db = new MascotasDB(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_RAITING_MASCOTAS_ID, mascota.getId());
        contentValues.put(ConstantesDB.TABLE_RAITING_MASCOTAS_NUMERO, RAITING);
        db.insertarRaitingMascota(contentValues);
    }

    public int obtenerRaitingMascota(Mascota mascota){
        MascotasDB db = new MascotasDB(context);
        return db.obtenerRaitingMascota(mascota);
    }

    public void insertarCincoMascotas(MascotasDB db) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_NOMBRE, "Solitario");
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_FOTO, R.drawable.canario);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_NOMBRE, "Beto");
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_FOTO, R.drawable.beto);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_NOMBRE, "Genius");
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_FOTO, R.drawable.camaleon01);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_NOMBRE, "Ferna");
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_FOTO, R.drawable.ferna);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_NOMBRE, "Pable");
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_FOTO, R.drawable.pablo);

    }


}
