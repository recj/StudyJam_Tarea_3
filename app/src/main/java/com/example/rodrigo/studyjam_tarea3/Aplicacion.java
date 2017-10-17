package com.example.rodrigo.studyjam_tarea3;

import java.io.Serializable;

/**
 * Created by Rodrigo on 16/10/2017.
 */

public class Aplicacion implements Serializable {

    private int imagen;
    private String nombre, descripcion;

    public Aplicacion (int imagen, String nombre, String descripcion) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
