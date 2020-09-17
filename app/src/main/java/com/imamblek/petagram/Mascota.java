package com.imamblek.petagram;

public class Mascota {
    private String nombre;
    private String huesos;
    private int foto;


    public Mascota(int foto, String nombre, String huesos) {
        this.foto = foto;
        this.nombre = nombre;
        this.huesos = huesos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHuesos() {
        return huesos;
    }

    public void setHuesos(String huesos) { this.huesos = huesos; }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
