package org.ualhmis.torneos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

class InstalacionTest {

    @Test
    void testCreacionInstalacionValida() {
        Instalacion i = new Instalacion("Pista Central", "pista");
        assertEquals("Pista Central", i.getNombre());
        assertEquals("pista", i.getTipo());
    }

    @Test
    void testCreacionInstalacionInvalida() {
        assertThrows(IllegalArgumentException.class, () -> new Instalacion("", "pista"));
        assertThrows(IllegalArgumentException.class, () -> new Instalacion("Nombre", ""));
        assertThrows(IllegalArgumentException.class, () -> new Instalacion(null, "pista"));
        assertThrows(IllegalArgumentException.class, () -> new Instalacion("Nombre", null));
    }

    @Test
    void testAsignacionYDisponibilidad() {
        Instalacion i = new Instalacion("Campo A", "campo");
        Equipo e1 = new Equipo("E1", "Juvenil", "Masculino", new Entrenador("A", "Masculino", LocalDate.of(1980, 1, 1)));
        Equipo e2 = new Equipo("E2", "Juvenil", "Masculino", new Entrenador("B", "Masculino", LocalDate.of(1980, 1, 1)));
        Partido p = new Partido(e1, e2);

        LocalDateTime fecha = LocalDateTime.of(2025, 6, 10, 10, 0);
        assertTrue(i.estaDisponible(fecha));
        assertTrue(i.asignarPartido(fecha, p));
        assertFalse(i.estaDisponible(fecha));
        assertFalse(i.asignarPartido(fecha, p)); // doble reserva
    }

    @Test
    void testSetters() {
        Instalacion i = new Instalacion("Pista", "pista");
        i.setNombre("Pista Nueva");
        i.setTipo("nuevo tipo");

        assertEquals("Pista Nueva", i.getNombre());
        assertEquals("nuevo tipo", i.getTipo());

        assertThrows(IllegalArgumentException.class, () -> i.setNombre(""));
        assertThrows(IllegalArgumentException.class, () -> i.setTipo(" "));
        assertThrows(IllegalArgumentException.class, () -> i.setNombre(null));
        assertThrows(IllegalArgumentException.class, () -> i.setTipo(null));
    }

    @Test
    void testToString() {
        Instalacion i = new Instalacion("Pabellón 1", "pabellón");
        assertTrue(i.toString().contains("Pabellón 1"));
        assertTrue(i.toString().contains("pabellón"));
    }

    @Test
    void testSetAndGetReservas() {
        Instalacion i = new Instalacion("Campo A", "campo");
        Equipo e1 = new Equipo("E1", "Juvenil", "Masculino", new Entrenador("A", "Masculino", LocalDate.of(1980, 1, 1)));
        Equipo e2 = new Equipo("E2", "Juvenil", "Masculino", new Entrenador("B", "Masculino", LocalDate.of(1980, 1, 1)));
        Partido p = new Partido(e1, e2);

        LocalDateTime fecha1 = LocalDateTime.of(2025, 6, 10, 10, 0);
        LocalDateTime fecha2 = LocalDateTime.of(2025, 6, 10, 12, 0);

        Map<LocalDateTime, Partido> reservas = new HashMap<>();
        reservas.put(fecha1, p);
        reservas.put(fecha2, p);

        i.setReservas(reservas);

        Map<LocalDateTime, Partido> reservasObtenidas = i.getReservas();

        assertNotNull(reservasObtenidas, "Las reservas no deben ser nulas");
        assertEquals(2, reservasObtenidas.size(), "El número de reservas debe ser 2");
        assertTrue(reservasObtenidas.containsKey(fecha1), "Debe contener la reserva para la fecha1");
        assertTrue(reservasObtenidas.containsKey(fecha2), "Debe contener la reserva para la fecha2");
        assertEquals(p, reservasObtenidas.get(fecha1), "El partido asignado para fecha1 no es correcto");
        assertEquals(p, reservasObtenidas.get(fecha2), "El partido asignado para fecha2 no es correcto");
    }

    
    
}
