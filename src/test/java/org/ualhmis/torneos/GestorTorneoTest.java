package org.ualhmis.torneos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

class GestorTorneosTest {

    @Test
    void testCrearYObtenerTorneos() {
        GestorTorneos gestor = new GestorTorneos();
        assertTrue(gestor.getTorneos().isEmpty());

        gestor.crearTorneo("Torneo 1", "Fútbol", "Juvenil", "Masculino", "Liga");
        gestor.crearTorneo("Torneo 2", "Baloncesto", "Cadete", "Femenino", "Eliminatoria");

        List<Torneo> torneos = gestor.getTorneos();
        assertEquals(2, torneos.size());

        Torneo t1 = torneos.get(0);
        assertEquals("Torneo 1", t1.getNombre());
        assertEquals("Fútbol", t1.getDeporte());

        Torneo t2 = torneos.get(1);
        assertEquals("Torneo 2", t2.getNombre());
        assertEquals("Baloncesto", t2.getDeporte());
    }

    @Test
    void testSetTorneos() {
        GestorTorneos gestor = new GestorTorneos();
        List<Torneo> lista = List.of(
                new Torneo("T1", "Fútbol", "Juvenil", "Masculino", "Liga"),
                new Torneo("T2", "Baloncesto", "Junior", "Femenino", "Grupos")
        );
        gestor.setTorneos(lista);

        assertEquals(2, gestor.getTorneos().size());
        assertEquals("T1", gestor.getTorneos().get(0).getNombre());

        assertThrows(IllegalArgumentException.class, () -> gestor.setTorneos(null));
    }

    @Test
    void testToString() {
        GestorTorneos gestor = new GestorTorneos();
        gestor.crearTorneo("Copa Primavera", "Tenis", "Absoluta", "Mixto", "Grupos");

        assertTrue(gestor.toString().contains("Copa Primavera"));
    }
}
