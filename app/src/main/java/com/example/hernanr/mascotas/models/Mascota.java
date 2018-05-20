package com.example.hernanr.mascotas.models;

public class Mascota {

    private int id;
    private String nombre;
    private int foto;
    private int raiting;

    public Mascota(int id, String nombre, int foto) {
        this.id = id;
        this.foto = foto;
        this.nombre = nombre;
        this.raiting = 0;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getRaiting() { return raiting; }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

}
