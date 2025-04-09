package org.ualhmis.torneos;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Instalacion {
    private String nombre;
    private String tipo; // campo, pabellón, pista
    private Map<LocalDateTime, Partido> reservas;

    public Instalacion(String nombre, String tipo) {
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

    public String getNombre() {
        return nombre;
    }
}
