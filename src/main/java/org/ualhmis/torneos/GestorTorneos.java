package org.ualhmis.torneos;

import java.util.ArrayList;
import java.util.List;

public class GestorTorneos {
    private List<Torneo> torneos;

    public GestorTorneos() {
        this.torneos = new ArrayList<>();
    }

    public void crearTorneo(String nombre, String deporte, String categoria, String modalidad, String tipo) {
        Torneo torneo = new Torneo(nombre, deporte, categoria, modalidad, tipo);
        torneos.add(torneo);
    }

    public List<Torneo> getTorneos() {
        return torneos;
    }

    public void setTorneos(List<Torneo> torneos) {
        if (torneos == null)
            throw new IllegalArgumentException("La lista de torneos no puede ser nula");
        this.torneos = torneos;
    }

    @Override
    public String toString() {
        return "GestorTorneos [torneos=" + torneos + "]";
    }
}
