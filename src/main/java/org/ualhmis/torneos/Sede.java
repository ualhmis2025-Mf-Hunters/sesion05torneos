package org.ualhmis.torneos;

import java.util.ArrayList;
import java.util.List;

public class Sede {
    private String nombre;
    private List<Instalacion> instalaciones;

    public Sede(String nombre) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("El nombre de la sede no puede estar vacío");

        this.nombre = nombre;
        this.instalaciones = new ArrayList<>();
    }

    public void agregarInstalacion(Instalacion instalacion) {
        if (instalacion == null)
            throw new IllegalArgumentException("La instalación no puede ser nula");

        instalaciones.add(instalacion);
    }

    public List<Instalacion> getInstalaciones() {
        return instalaciones;
    }

    public void setInstalaciones(List<Instalacion> instalaciones) {
        if (instalaciones == null)
            throw new IllegalArgumentException("La lista de instalaciones no puede ser nula");
        this.instalaciones = instalaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("El nombre de la sede no puede estar vacío");
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Sede [nombre=" + nombre + ", instalaciones=" + instalaciones + "]";
    }
}
