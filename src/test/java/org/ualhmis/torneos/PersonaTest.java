package org.ualhmis.torneos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class PersonaTest {

    @Test
    void testCreacionValida() {
        LocalDate fecha = LocalDate.of(1990, 5, 20);
        Persona persona = new Persona("Juan", "Masculino", fecha);

        assertEquals("Juan", persona.getNombre());
        assertEquals("Masculino", persona.getGenero());
        assertEquals(fecha, persona.getFechaNacimiento());
    }

    @Test
    void testCreacionInvalida() {
        assertThrows(IllegalArgumentException.class, () -> new Persona("", "Masculino", LocalDate.of(1990, 5, 20)));
        assertThrows(IllegalArgumentException.class, () -> new Persona("Juan", "", LocalDate.of(1990, 5, 20)));
        assertThrows(IllegalArgumentException.class, () -> new Persona("Juan", "Masculino", null));
    }

    @Test
    void testCalcularEdad() {
        LocalDate fechaNacimiento = LocalDate.of(2000, 1, 1);
        Persona persona = new Persona("Ana", "Femenino", fechaNacimiento);
        int edadEsperada = LocalDate.now().getYear() - fechaNacimiento.getYear();

        assertEquals(edadEsperada, persona.calcularEdad());
    }

    @Test
    void testSettersValidos() {
        Persona persona = new Persona("Luis", "Masculino", LocalDate.of(1990, 1, 1));

        persona.setNombre("Pedro");
        persona.setGenero("Masculino");
        persona.setFechaNacimiento(LocalDate.of(1985, 12, 12));

        assertEquals("Pedro", persona.getNombre());
        assertEquals("Masculino", persona.getGenero());
        assertEquals(LocalDate.of(1985, 12, 12), persona.getFechaNacimiento());
    }

    @Test
    void testSettersInvalidos() {
        Persona persona = new Persona("Luis", "Masculino", LocalDate.of(1990, 1, 1));

        assertThrows(IllegalArgumentException.class, () -> persona.setNombre(""));
        assertThrows(IllegalArgumentException.class, () -> persona.setGenero(""));
        assertThrows(IllegalArgumentException.class, () -> persona.setFechaNacimiento(null));
    }

    @Test
    void testToString() {
        Persona persona = new Persona("Maria", "Femenino", LocalDate.of(1980, 6, 15));
        String esperado = "Persona [nombre=Maria, genero=Femenino, fechaNacimiento=1980-06-15]";

        assertEquals(esperado, persona.toString());
    }
}
