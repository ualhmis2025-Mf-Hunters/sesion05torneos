package org.ualhmis.torneos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;

class EquipoTest {

    @Test
    void testCreacionValidaEquipo() {
        Entrenador entrenador = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
        Equipo equipo = new Equipo("Tigres", "Juvenil", "Masculino", entrenador);

        assertEquals("Tigres", equipo.getNombre());
        assertEquals("Juvenil", equipo.getCategoria());
        assertEquals("Masculino", equipo.getModalidad());
        assertEquals(entrenador, equipo.getEntrenador());
    }

    @Test
    void testAgregarJugadorValido() {
        Entrenador entrenador = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
        Equipo equipo = new Equipo("Tigres", "Juvenil", "Masculino", entrenador);
        Jugador jugador = new Jugador("Luis", "Masculino", LocalDate.of(2008, 7, 15));

        equipo.agregarJugador(jugador);
        assertEquals(1, equipo.getJugadores().size());
        assertTrue(equipo.getJugadores().contains(jugador));
    }

    @Test
    void testNoAgregarJugadorDiferenteCategoriaOModalidad() {
        Entrenador entrenador = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
        Equipo equipo = new Equipo("Tigres", "Juvenil", "Masculino", entrenador);
        Jugador jugador = new Jugador("Laura", "Femenino", LocalDate.of(2008, 7, 15));

        equipo.agregarJugador(jugador);
        assertTrue(equipo.getJugadores().isEmpty());
    }

    @Test
    void testSetJugadores() {
        Equipo equipo = new Equipo("Aguilas", "Junior", "Femenino", new Entrenador("Ana", "Femenino", LocalDate.of(1985, 6, 20)));
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Lucia", "Femenino", LocalDate.of(2006, 4, 1)));

        equipo.setJugadores(jugadores);
        assertEquals(1, equipo.getJugadores().size());
    }

    @Test
    void testEqualsAndToString() {
        Entrenador entrenador = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
        Equipo equipo1 = new Equipo("Tigres", "Juvenil", "Masculino", entrenador);
        Equipo equipo2 = new Equipo("Tigres", "Juvenil", "Masculino", entrenador);

        assertEquals(equipo1, equipo2);
        assertEquals(equipo1.toString(), equipo2.toString());
    }

    @Test
void testSetters() {
    Equipo equipo = new Equipo("Original", "Infantil", "Femenino", new Entrenador("Pedro", "Masculino", LocalDate.of(1975, 5, 5)));

    equipo.setNombre("Renombrado");
    equipo.setCategoria("Cadete");
    equipo.setModalidad("Masculino");

    Entrenador nuevoEntrenador = new Entrenador("Marta", "Femenino", LocalDate.of(1988, 9, 12));
    equipo.setEntrenador(nuevoEntrenador);
    equipo.setSegundoEntrenador(new Entrenador("Laura", "Femenino", LocalDate.of(1990, 11, 22)));

    assertEquals("Renombrado", equipo.getNombre());
    assertEquals("Cadete", equipo.getCategoria());
    assertEquals("Masculino", equipo.getModalidad());
    assertEquals(nuevoEntrenador, equipo.getEntrenador());
    assertEquals("Laura", equipo.getSegundoEntrenador().getNombre());
}

}
