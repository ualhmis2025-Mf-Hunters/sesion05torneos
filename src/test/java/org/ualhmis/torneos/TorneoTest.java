package org.ualhmis.torneos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;

class TorneoTest {

    // Datos de prueba reutilizables
    private final Entrenador entrenador = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 1, 1));
    private final Equipo equipoValido = new Equipo("Tigres", "Juvenil", "Masculino", entrenador);
    private final Equipo equipoCategoriaInvalida = new Equipo("Tigres", "Senior", "Masculino", entrenador);
    private final Equipo equipoModalidadInvalida = new Equipo("Leonas", "Juvenil", "Femenino", 
        new Entrenador("Ana", "Femenino", LocalDate.of(1985, 1, 1)));

    // Constructor tests
    @Test
    void testConstructorValido() {
        Torneo torneo = new Torneo("Liga Sur", "Fútbol", "Juvenil", "Masculino", "Liga");
        
        assertEquals("Liga Sur", torneo.getNombre());
        assertEquals("Fútbol", torneo.getDeporte());
        assertEquals("Juvenil", torneo.getCategoria());
        assertEquals("Masculino", torneo.getModalidad());
        assertEquals("Liga", torneo.getTipo());
        assertTrue(torneo.getEquipos().isEmpty());
    }

    @Test
    void testConstructorInvalido() {
        // Test para cada parámetro individualmente
        assertThrows(IllegalArgumentException.class, () -> 
            new Torneo(null, "Fútbol", "Juvenil", "Masculino", "Liga"));
        assertThrows(IllegalArgumentException.class, () -> 
            new Torneo("", "Fútbol", "Juvenil", "Masculino", "Liga"));
        assertThrows(IllegalArgumentException.class, () -> 
            new Torneo("   ", "Fútbol", "Juvenil", "Masculino", "Liga"));
        assertThrows(IllegalArgumentException.class, () -> 
            new Torneo("Liga Sur", null, "Juvenil", "Masculino", "Liga"));
        assertThrows(IllegalArgumentException.class, () -> 
            new Torneo("Liga Sur", "", "Juvenil", "Masculino", "Liga"));
        assertThrows(IllegalArgumentException.class, () -> 
            new Torneo("Liga Sur", "   ", "Juvenil", "Masculino", "Liga"));
        assertThrows(IllegalArgumentException.class, () -> 
            new Torneo("Liga Sur", "Fútbol", null, "Masculino", "Liga"));
        assertThrows(IllegalArgumentException.class, () -> 
            new Torneo("Liga Sur", "Fútbol", "Juvenil", null, "Liga"));
        assertThrows(IllegalArgumentException.class, () -> 
            new Torneo("Liga Sur", "Fútbol", "Juvenil", "Masculino", null));
    }

    // Tests para registrarEquipo
    @Test
    void testRegistrarEquipoValido() {
        Torneo torneo = new Torneo("Liga Sur", "Fútbol", "Juvenil", "Masculino", "Liga");
        torneo.registrarEquipo(equipoValido);
        assertEquals(1, torneo.getEquipos().size());
    }

    @Test
    void testRegistrarEquipoCaseInsensitive() {
        Torneo torneo = new Torneo("Liga Sur", "Fútbol", "Juvenil", "Masculino", "Liga");
        Equipo equipo = new Equipo("Tigres", "Juvenil", "MASCULINO", entrenador);
        
        torneo.registrarEquipo(equipo);
        assertEquals(1, torneo.getEquipos().size());
    }

    @Test
    void testNoRegistrarEquipoDuplicado() {
        Torneo torneo = new Torneo("Liga Sur", "Fútbol", "Juvenil", "Masculino", "Liga");
        torneo.registrarEquipo(equipoValido);
        torneo.registrarEquipo(equipoValido);
        assertEquals(1, torneo.getEquipos().size());
    }

    @Test
    void testRegistrarEquipoCategoriaInvalida() {
        Torneo torneo = new Torneo("Liga Sur", "Fútbol", "Juvenil", "Masculino", "Liga");
        assertThrows(IllegalArgumentException.class, () -> 
            torneo.registrarEquipo(equipoCategoriaInvalida));
    }

    @Test
    void testRegistrarEquipoModalidadInvalida() {
        Torneo torneo = new Torneo("Liga Sur", "Fútbol", "Juvenil", "Masculino", "Liga");
        assertThrows(IllegalArgumentException.class, () -> 
            torneo.registrarEquipo(equipoModalidadInvalida));
    }

    @Test
    void testRegistrarEquipoNulo() {
        Torneo torneo = new Torneo("Liga Sur", "Fútbol", "Juvenil", "Masculino", "Liga");
        assertThrows(IllegalArgumentException.class, () -> 
            torneo.registrarEquipo(null));
    }

    // Tests para setters
    @Test
    void testSettersValidos() {
        Torneo torneo = new Torneo("Inicial", "Tenis", "Cadete", "Mixto", "Grupos");
        ArrayList<Equipo> equipos = new ArrayList<>();
        equipos.add(equipoValido);

        torneo.setNombre("Final");
        torneo.setDeporte("Pádel");
        torneo.setCategoria("Junior");
        torneo.setModalidad("Femenino");
        torneo.setTipo("Eliminatoria");
        torneo.setEquipos(equipos);

        assertEquals("Final", torneo.getNombre());
        assertEquals("Pádel", torneo.getDeporte());
        assertEquals("Junior", torneo.getCategoria());
        assertEquals("Femenino", torneo.getModalidad());
        assertEquals("Eliminatoria", torneo.getTipo());
        assertEquals(1, torneo.getEquipos().size());
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