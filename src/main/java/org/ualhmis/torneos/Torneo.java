package org.ualhmis.torneos;

import java.util.ArrayList;
import java.util.List;

class Torneo {
    private String nombre;
    private String deporte;
    private String categoria;
    private String modalidad;
    private String tipo;
    private List<Equipo> equipos;

    public Torneo(String nombre, String deporte, String categoria, String modalidad, String tipo) {
        if (nombre == null || nombre.trim().isEmpty() || deporte == null || deporte.trim().isEmpty()
                || categoria == null || modalidad == null || tipo == null)
            throw new IllegalArgumentException("Ningún dato del torneo puede ser nulo o vacío");

        this.nombre = nombre;
        this.deporte = deporte;
        this.categoria = categoria;
        this.modalidad = modalidad;
        this.tipo = tipo;
        this.equipos = new ArrayList<>();
    }

    public void registrarEquipo(Equipo equipo) {
        if (equipo == null)
            throw new IllegalArgumentException("El equipo no puede ser nulo");

        if (!equipo.getCategoria().equals(this.categoria) || !equipo.getModalidad().equalsIgnoreCase(this.modalidad)) {
            throw new IllegalArgumentException("El equipo no cumple con la categoría y modalidad del torneo");
        }
        if (!equipos.contains(equipo))
            equipos.add(equipo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    @Override
    public String toString() {
        return "Torneo [nombre=" + nombre + ", deporte=" + deporte + ", categoria=" + categoria
                + ", modalidad=" + modalidad + ", tipo=" + tipo + ", equipos=" + equipos + "]";
    }
}
