package com.example.hernanr.mascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hernanr.mascotas.models.Mascota;

import java.util.ArrayList;


public class MascotasDB extends SQLiteOpenHelper {
    private Context context;

    public MascotasDB(Context context) {
        super(context, ConstantesDB.DATABASE_NAME, null, ConstantesDB.DATABASE_VERSION);
        this.context = context;
    }


    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaContacto = "CREATE TABLE " + ConstantesDB.TABLE_MASCOTAS + "(" +
                ConstantesDB.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesDB.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                ConstantesDB.TABLE_MASCOTAS_FOTO + " INTEGER" +
                ")";

        String queryCrearTablaLikesContacto = "CREATE TABLE " + ConstantesDB.TABLE_RAITING_MASCOTAS + "(" +
                ConstantesDB.TABLE_RAITING_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesDB.TABLE_RAITING_MASCOTAS_ID + " INTEGER, " +
                ConstantesDB.TABLE_RAITING_MASCOTAS_NUMERO + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesDB.TABLE_RAITING_MASCOTAS_ID + ") " +
                "REFERENCES " + ConstantesDB.TABLE_MASCOTAS + "(" + ConstantesDB.TABLE_MASCOTAS_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaContacto);

        db.execSQL(queryCrearTablaLikesContacto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + ConstantesDB.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesDB.TABLE_RAITING_MASCOTAS);
        onCreate(db);

    }

    public ArrayList<Mascota> obtenerMascotas() {

        ArrayList<Mascota> mascotaArrayList = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesDB.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {
            Mascota mascota = new Mascota(
                    registros.getInt(0),
                    registros.getString(1),
                    registros.getInt(2)
            );

            String queryRaiting = "SELECT COUNT(" + ConstantesDB.TABLE_RAITING_MASCOTAS_NUMERO + ") as likes " +
                    " FROM " + ConstantesDB.TABLE_RAITING_MASCOTAS +
                    " WHERE " + ConstantesDB.TABLE_RAITING_MASCOTAS_ID + "=" + mascota.getId();

            Cursor registrosRaiting = db.rawQuery(queryRaiting, null);
            if (registrosRaiting.moveToNext()) {
                mascota.setRaiting(registrosRaiting.getInt(0));
            } else {
                mascota.setRaiting(0);
            }
            registrosRaiting.close();
            mascotaArrayList.add(mascota);

        }

        registros.close();
        db.close();

        return mascotaArrayList;
    }

    public void insertarMascota(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesDB.TABLE_MASCOTAS, null, contentValues);
        db.close();
    }

    public void insertarRaitingMascota(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesDB.TABLE_RAITING_MASCOTAS, null, contentValues);
        db.close();
    }


    public int obtenerRaitingMascota(Mascota mascota) {
        int raiting = 0;

        String query = "SELECT COUNT(" + ConstantesDB.TABLE_RAITING_MASCOTAS_NUMERO + ") " +
                "FROM " + ConstantesDB.TABLE_RAITING_MASCOTAS + " " +
                "WHERE " + ConstantesDB.TABLE_RAITING_MASCOTAS_ID + "=" + mascota.getId();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()) {
            raiting = registros.getInt(0);
        }

        registros.close();

        db.close();

        return raiting;
    }

    public boolean mascotasVacio() {

        Boolean TablaVacia = true;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + ConstantesDB.TABLE_MASCOTAS, null);

        if (cursor.getCount() > 0) {
            TablaVacia = false;
        }
        cursor.close();
        db.close();
        return TablaVacia;
    }

    public ArrayList<Mascota> obtenerMascotasFavoritas() {


        ArrayList<Mascota> mascotaArrayList = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesDB.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {
            Mascota mascota = new Mascota(
                    registros.getInt(0),
                    registros.getString(1),
                    registros.getInt(2)
            );

            /*
            String queryRaiting = "SELECT COUNT(" + ConstantesDB.TABLE_RAITING_MASCOTAS_NUMERO + ") as likes " +
                    " FROM " + ConstantesDB.TABLE_RAITING_MASCOTAS +
                    " WHERE " + ConstantesDB.TABLE_RAITING_MASCOTAS_ID + "=" + mascota.getId();

            Cursor registrosRaiting = db.rawQuery(queryRaiting, null);
            if (registrosRaiting.moveToNext()) {
                mascota.setRaiting(registrosRaiting.getInt(0));
            } else {
                mascota.setRaiting(0);
            }
            registrosRaiting.close();
            */
            mascotaArrayList.add(mascota);

        }

        registros.close();
        db.close();

        return mascotaArrayList;


        /*

        ArrayList<Mascota> puppyList = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesDB.TABLE_MASCOTAS + " " +
                "WHERE " + ConstantesDB.TABLE_MASCOTAS_ID + " IN (" +
                "SELECT " + ConstantesDB.TABLE_RAITING_MASCOTAS_ID + " FROM " + ConstantesDB.TABLE_RAITING_MASCOTAS + " " +
                "GROUP BY " + ConstantesDB.TABLE_RAITING_MASCOTAS_ID + " ORDER BY " + ConstantesDB.TABLE_RAITING_MASCOTAS_ID + " DESC " +
                "LIMIT 5)";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {
            Mascota mascota = new Mascota(
                    registros.getInt(0),
                    registros.getString(1),
                    registros.getInt(2)
            );

            String queryRaiting = "SELECT COUNT(" + ConstantesDB.TABLE_RAITING_MASCOTAS_NUMERO + ") as likes " +
                    " FROM " + ConstantesDB.TABLE_RAITING_MASCOTAS +
                    " WHERE " + ConstantesDB.TABLE_RAITING_MASCOTAS_ID + "=" + mascota.getId();

            Cursor registrosRaiting = db.rawQuery(queryRaiting, null);
            if (registrosRaiting.moveToNext()) {
                mascota.setRaiting(registrosRaiting.getInt(0));
            } else {
                mascota.setRaiting(0);
            }
            registrosRaiting.close();
            puppyList.add(mascota);

        }
        registros.close();
        db.close();

        return puppyList;

        */

    }
}
