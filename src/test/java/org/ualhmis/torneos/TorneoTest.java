package org.ualhmis.torneos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;

class TorneoTest {

    @Test
    void testCreacionValida() {
        Torneo torneo = new Torneo("Liga Sur", "Fútbol", "Juvenil", "Masculino", "Liga");
        assertEquals("Liga Sur", torneo.getNombre());
        assertEquals("Fútbol", torneo.getDeporte());
        assertEquals("Juvenil", torneo.getCategoria());
        assertEquals("Masculino", torneo.getModalidad());
        assertEquals("Liga", torneo.getTipo());
        assertTrue(torneo.getEquipos().isEmpty());
    }

    @Test
    void testRegistrarEquipoValido() {
        Torneo torneo = new Torneo("Liga Sur", "Fútbol", "Juvenil", "Masculino", "Liga");
        Equipo equipo = new Equipo("Tigres", "Juvenil", "Masculino", new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 1, 1)));

        torneo.registrarEquipo(equipo);
        assertEquals(1, torneo.getEquipos().size());
    }

    @Test
    void testRegistrarEquipoDuplicado() {
        Torneo torneo = new Torneo("Liga Sur", "Fútbol", "Juvenil", "Masculino", "Liga");
        Equipo equipo = new Equipo("Tigres", "Juvenil", "Masculino", new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 1, 1)));

        torneo.registrarEquipo(equipo);
        torneo.registrarEquipo(equipo);
        assertEquals(1, torneo.getEquipos().size());
    }

    @Test
    void testRegistrarEquipoInvalido() {
        Torneo torneo = new Torneo("Liga Sur", "Fútbol", "Juvenil", "Masculino", "Liga");
        Equipo equipoCategoria = new Equipo("Tigres", "Cadete", "Masculino", new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 1, 1)));
        Equipo equipoModalidad = new Equipo("Leonas", "Juvenil", "Femenino", new Entrenador("Ana", "Femenino", LocalDate.of(1985, 1, 1)));

        assertThrows(IllegalArgumentException.class, () -> torneo.registrarEquipo(equipoCategoria));
        assertThrows(IllegalArgumentException.class, () -> torneo.registrarEquipo(equipoModalidad));
        assertThrows(IllegalArgumentException.class, () -> torneo.registrarEquipo(null));
    }

    @Test
    void testSetters() {
        Torneo torneo = new Torneo("Inicial", "Tenis", "Cadete", "Mixto", "Grupos");

        torneo.setNombre("Final");
        torneo.setDeporte("Padel");
        torneo.setCategoria("Junior");
        torneo.setModalidad("Femenino");
        torneo.setTipo("Eliminatoria");
        ArrayList<Equipo> equipos = new ArrayList<>();
        torneo.setEquipos(equipos);

        assertEquals("Final", torneo.getNombre());
        assertEquals("Padel", torneo.getDeporte());
        assertEquals("Junior", torneo.getCategoria());
        assertEquals("Femenino", torneo.getModalidad());
        assertEquals("Eliminatoria", torneo.getTipo());
        assertEquals(equipos, torneo.getEquipos());
    }

    @Test
    void testToString() {
        Torneo torneo = new Torneo("Liga Norte", "Baloncesto", "Junior", "Mixto", "Grupos");
        assertTrue(torneo.toString().contains("Liga Norte"));
        assertTrue(torneo.toString().contains("Baloncesto"));
    }
}
