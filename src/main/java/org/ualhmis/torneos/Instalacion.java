package org.ualhmis.torneos;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Instalacion {
    private String nombre;
    private String tipo;
    private Map<LocalDateTime, Partido> reservas;

    public Instalacion(String nombre, String tipo) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("Nombre no válido");
        if (tipo == null || tipo.trim().isEmpty())
            throw new IllegalArgumentException("Tipo no válido");

        this.nombre = nombre;
        this.tipo = tipo;
        this.reservas = new HashMap<>();
    }

    public boolean estaDisponible(LocalDateTime fechaHora) {
        return !reservas.containsKey(fechaHora);
    }

    public boolean asignarPartido(LocalDateTime fechaHora, Partido partido) {
        if (estaDisponible(fechaHora)) {
            reservas.put(fechaHora, partido);
            return true;
        }
        return false;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo == null || tipo.trim().isEmpty())
            throw new IllegalArgumentException("Tipo no válido");
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("Nombre no válido");
        this.nombre = nombre;
    }

    public Map<LocalDateTime, Partido> getReservas() {
        return reservas;
    }

    public void setReservas(Map<LocalDateTime, Partido> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Instalacion [nombre=" + nombre + ", tipo=" + tipo + ", reservas=" + reservas + "]";
    }
}
