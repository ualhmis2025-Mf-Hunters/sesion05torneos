package org.ualhmis.torneos;

import java.time.LocalDate;
class Persona {
    private String nombre;
    private String genero;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, String genero, LocalDate fechaNacimiento) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        if (genero == null || genero.trim().isEmpty())
            throw new IllegalArgumentException("El género no puede estar vacío");
        if (fechaNacimiento == null)
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula");

        this.nombre = nombre;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        if (genero == null || genero.trim().isEmpty())
            throw new IllegalArgumentException("El género no puede estar vacío");
        this.genero = genero;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null)
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula");
        this.fechaNacimiento = fechaNacimiento;
    }

    public int calcularEdad() {
        return LocalDate.now().getYear() - fechaNacimiento.getYear();
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", genero=" + genero + ", fechaNacimiento=" + fechaNacimiento + "]";
    }
}
