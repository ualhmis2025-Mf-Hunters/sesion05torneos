package org.ualhmis.torneos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

class SedeTest {

    @Test
    void testCreacionValida() {
        Sede sede = new Sede("Centro Deportivo");
        assertEquals("Centro Deportivo", sede.getNombre());
        assertTrue(sede.getInstalaciones().isEmpty());
    }

    @Test
    void testCreacionInvalida() {
        assertThrows(IllegalArgumentException.class, () -> new Sede(""));
        assertThrows(IllegalArgumentException.class, () -> new Sede(null));
    }

    @Test
    void testAgregarInstalacion() {
        Sede sede = new Sede("Polideportivo");
        Instalacion instalacion = new Instalacion("Pista 1", "pista");

        sede.agregarInstalacion(instalacion);
        List<Instalacion> instalaciones = sede.getInstalaciones();

        assertEquals(1, instalaciones.size());
        assertEquals("Pista 1", instalaciones.get(0).getNombre());
    }

    @Test
    void testAgregarInstalacionNula() {
        Sede sede = new Sede("Ciudad Deportiva");
        assertThrows(IllegalArgumentException.class, () -> sede.agregarInstalacion(null));
    }

    @Test
    void testSetters() {
        Sede sede = new Sede("Complejo A");
        sede.setNombre("Complejo B");
        assertEquals("Complejo B", sede.getNombre());

        List<Instalacion> lista = List.of(new Instalacion("Campo 1", "campo"));
        sede.setInstalaciones(lista);
        assertEquals(1, sede.getInstalaciones().size());

        assertThrows(IllegalArgumentException.class, () -> sede.setInstalaciones(null));
    }

    @Test
    void testToString() {
        Sede sede = new Sede("Sede Principal");
        assertTrue(sede.toString().contains("Sede Principal"));
    }
}
