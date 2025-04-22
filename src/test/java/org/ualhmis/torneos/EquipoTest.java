package org.ualhmis.torneos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class EquipoTest {

    // Datos de prueba reutilizables
    private final Entrenador entrenadorBase = new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10));
    private final Jugador jugadorValido = new Jugador("Luis", "Masculino", LocalDate.of(2008, 7, 15));
    private final Jugador jugadorInvalidoGenero = new Jugador("Laura", "Femenino", LocalDate.of(2008, 7, 15));
    private final Jugador jugadorInvalidoCategoria = new Jugador("Pedro", "Masculino", LocalDate.of(2005, 1, 1)); // Asumiendo categoría diferente

    // Constructor tests
    @Test
    void testConstructorValido() {
        Equipo equipo = new Equipo("Tigres", "Juvenil", "Masculino", entrenadorBase);
        
        assertEquals("Tigres", equipo.getNombre());
        assertEquals("Juvenil", equipo.getCategoria());
        assertEquals("Masculino", equipo.getModalidad());
        assertEquals(entrenadorBase, equipo.getEntrenador());
        assertTrue(equipo.getJugadores().isEmpty());
        assertNull(equipo.getSegundoEntrenador());
    }

    @Test
    void testConstructorInvalido() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Equipo(null, "Juvenil", "Masculino", entrenadorBase));
        assertThrows(IllegalArgumentException.class, () -> 
            new Equipo("", "Juvenil", "Masculino", entrenadorBase));
        assertThrows(IllegalArgumentException.class, () -> 
            new Equipo("   ", "Juvenil", "Masculino", entrenadorBase));
        assertThrows(IllegalArgumentException.class, () -> 
            new Equipo("Tigres", null, "Masculino", entrenadorBase));
        assertThrows(IllegalArgumentException.class, () -> 
            new Equipo("Tigres", "Juvenil", null, entrenadorBase));
        assertThrows(IllegalArgumentException.class, () -> 
            new Equipo("Tigres", "Juvenil", "Masculino", null));
    }

    // Tests para agregarJugador
    @Test
    void testAgregarJugadorValido() {
        Equipo equipo = new Equipo("Tigres", "Juvenil", "Masculino", entrenadorBase);
        equipo.agregarJugador(jugadorValido);
        assertEquals(1, equipo.getJugadores().size());
        assertTrue(equipo.getJugadores().contains(jugadorValido));
    }

    @Test
    void testNoAgregarJugadorNulo() {
        Equipo equipo = new Equipo("Tigres", "Juvenil", "Masculino", entrenadorBase);
        equipo.agregarJugador(null);
        assertTrue(equipo.getJugadores().isEmpty());
    }

    @Test
    void testNoAgregarJugadorGeneroInvalido() {
        Equipo equipo = new Equipo("Tigres", "Juvenil", "Masculino", entrenadorBase);
        equipo.agregarJugador(jugadorInvalidoGenero);
        assertTrue(equipo.getJugadores().isEmpty());
    }

    @Test
    void testNoAgregarJugadorCategoriaInvalida() {
        Equipo equipo = new Equipo("Tigres", "Juvenil", "Masculino", entrenadorBase);
        equipo.agregarJugador(jugadorInvalidoCategoria);
        assertTrue(equipo.getJugadores().isEmpty());
    }

    @Test
    void testNoAgregarJugadorDuplicado() {
        Equipo equipo = new Equipo("Tigres", "Juvenil", "Masculino", entrenadorBase);
        equipo.agregarJugador(jugadorValido);
        equipo.agregarJugador(jugadorValido);
        assertEquals(1, equipo.getJugadores().size());
    }

    @Test
    void testAgregarJugadorGeneroCaseInsensitive() {
        Equipo equipo = new Equipo("Tigres", "Juvenil", "Masculino", entrenadorBase);
        Jugador jugador1 = new Jugador("Juan", "MASCULINO", LocalDate.of(2008, 7, 15));
        Jugador jugador2 = new Jugador("Pedro", "masculino", LocalDate.of(2008, 7, 15));
        
        equipo.agregarJugador(jugador1);
        equipo.agregarJugador(jugador2);
        
        assertEquals(2, equipo.getJugadores().size());
    }

    // Tests para setters
    @Test
    void testSettersBasicos() {
        Equipo equipo = new Equipo("Original", "Infantil", "Femenino", 
            new Entrenador("Pedro", "Masculino", LocalDate.of(1975, 5, 5)));
        
        equipo.setNombre("Renombrado");
        equipo.setCategoria("Cadete");
        equipo.setModalidad("Masculino");
        
        assertEquals("Renombrado", equipo.getNombre());
        assertEquals("Cadete", equipo.getCategoria());
        assertEquals("Masculino", equipo.getModalidad());
    }

    @Test
    void testSettersEntrenadores() {
        Equipo equipo = new Equipo("Tigres", "Juvenil", "Masculino", entrenadorBase);
        
        Entrenador nuevoEntrenador = new Entrenador("Marta", "Femenino", LocalDate.of(1988, 9, 12));
        equipo.setEntrenador(nuevoEntrenador);
        assertEquals(nuevoEntrenador, equipo.getEntrenador());
        
        Entrenador segundoEntrenador = new Entrenador("Laura", "Femenino", LocalDate.of(1990, 11, 22));
        equipo.setSegundoEntrenador(segundoEntrenador);
        assertEquals(segundoEntrenador, equipo.getSegundoEntrenador());
    }

    @Test
    void testSetterJugadores() {
        Equipo equipo = new Equipo("Tigres", "Juvenil", "Masculino", entrenadorBase);
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugadorValido);
        
        equipo.setJugadores(jugadores);
        assertEquals(1, equipo.getJugadores().size());
        assertTrue(equipo.getJugadores().contains(jugadorValido));
    }

    // Tests para equals y hashCode
    @Test
    void testEqualsMismoObjeto() {
        Equipo equipo = new Equipo("Tigres", "Juvenil", "Masculino", entrenadorBase);
        assertTrue(equipo.equals(equipo));
    }

    @Test
    void testEqualsObjetosIguales() {
        Equipo equipo1 = new Equipo("Tigres", "Juvenil", "Masculino", entrenadorBase);
        Equipo equipo2 = new Equipo("Tigres", "Juvenil", "Masculino", entrenadorBase);
        assertTrue(equipo1.equals(equipo2));
    }

    @Test
    void testEqualsDiferenteNombre() {
        Equipo equipo1 = new Equipo("Tigres", "Juvenil", "Masculino", entrenadorBase);
        Equipo equipo2 = new Equipo("Leones", "Juvenil", "Masculino", entrenadorBase);
        assertFalse(equipo1.equals(equipo2));
    }

    @Test
    void testEqualsDiferenteCategoria() {
        Equipo equipo1 = new Equipo("Tigres", "Juvenil", "Masculino", entrenadorBase);
        Equipo equipo2 = new Equipo("Tigres", "Senior", "Masculino", entrenadorBase);
        assertFalse(equipo1.equals(equipo2));
    }

    @Test
    void testEqualsDiferenteModalidad() {
        Equipo equipo1 = new Equipo("Tigres", "Juvenil", "Masculino", entrenadorBase);
        Equipo equipo2 = new Equipo("Tigres", "Juvenil", "Femenino", entrenadorBase);
        assertFalse(equipo1.equals(equipo2));
    }

    @Test
    void testEqualsConNull() {
        Equipo equipo = new Equipo("Tigres", "Juvenil", "Masculino", entrenadorBase);
        assertFalse(equipo.equals(null));
    }

    @Test
    void testEqualsDiferenteClase() {
        Equipo equipo = new Equipo("Tigres", "Juvenil", "Masculino", entrenadorBase);
        assertFalse(equipo.equals("No soy un equipo"));
    }

    // Tests para toString
    @Test
    void testToString() {
        Equipo equipo = new Equipo("Tigres", "Juvenil", "Masculino", entrenadorBase);
        String str = equipo.toString();
        
        assertTrue(str.contains("Tigres"));
        assertTrue(str.contains("Juvenil"));
        assertTrue(str.contains("Masculino"));
        assertTrue(str.contains("Carlos"));
        assertTrue(str.contains("segundoEntrenador=null"));
    }

    // Tests para asignarSegundoEntrenador
    @Test
    void testAsignarSegundoEntrenador() {
        Equipo equipo = new Equipo("Tigres", "Juvenil", "Masculino", entrenadorBase);
        
        assertNull(equipo.getSegundoEntrenador());
        
        Entrenador segundoEntrenador = new Entrenador("Juan", "Masculino", LocalDate.of(1985, 4, 15));
        equipo.asignarSegundoEntrenador(segundoEntrenador);
        
        assertEquals(segundoEntrenador, equipo.getSegundoEntrenador());
    }

    @Test
    void testAsignarSegundoEntrenadorNull() {
        Equipo equipo = new Equipo("Tigres", "Juvenil", "Masculino", entrenadorBase);
        equipo.asignarSegundoEntrenador(null);
        assertNull(equipo.getSegundoEntrenador());
    }
}