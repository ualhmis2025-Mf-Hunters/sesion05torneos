package org.ualhmis.torneos;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class SedeTest {

    @Test
    void testConstructorValido() {
        Sede sede = new Sede("Centro Deportivo");
        assertEquals("Centro Deportivo", sede.getNombre());
        assertTrue(sede.getInstalaciones().isEmpty());
    }

    @Test
    void testConstructorInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Sede(""));
        assertThrows(IllegalArgumentException.class, () -> new Sede("   "));
        assertThrows(IllegalArgumentException.class, () -> new Sede(null));
    }

    @Test
    void testAgregarInstalacion() {
        Sede sede = new Sede("Polideportivo");
        Instalacion instalacion1 = new Instalacion("Pista 1", "pista");
        Instalacion instalacion2 = new Instalacion("Pista 2", "pista");

        sede.agregarInstalacion(instalacion1);
        sede.agregarInstalacion(instalacion2);
        
        List<Instalacion> instalaciones = sede.getInstalaciones();
        assertEquals(2, instalaciones.size());
        assertTrue(instalaciones.contains(instalacion1));
        assertTrue(instalaciones.contains(instalacion2));
    }

    @Test
    void testAgregarInstalacionNula() {
        Sede sede = new Sede("Ciudad Deportiva");
        assertThrows(IllegalArgumentException.class, () -> sede.agregarInstalacion(null));
    }

    @Test
    void testSetNombre() {
        Sede sede = new Sede("Original");
        
        sede.setNombre("Nuevo Nombre");
        assertEquals("Nuevo Nombre", sede.getNombre());
        
        assertThrows(IllegalArgumentException.class, () -> sede.setNombre(""));
        assertThrows(IllegalArgumentException.class, () -> sede.setNombre("   "));
        assertThrows(IllegalArgumentException.class, () -> sede.setNombre(null));
    }

    @Test
    void testSetInstalaciones() {
        Sede sede = new Sede("Complejo A");
        List<Instalacion> instalaciones = new ArrayList<>();
        instalaciones.add(new Instalacion("Campo 1", "campo"));
        instalaciones.add(new Instalacion("Pabellón", "pabellón"));

        sede.setInstalaciones(instalaciones);
        assertEquals(2, sede.getInstalaciones().size());
        
        assertThrows(IllegalArgumentException.class, () -> sede.setInstalaciones(null));
    }

    @Test
    void testToString() {
        Sede sede = new Sede("Sede Principal");
        sede.agregarInstalacion(new Instalacion("Pista Central", "pista"));
        
        String str = sede.toString();
        assertTrue(str.contains("Sede Principal"));
        assertTrue(str.contains("Pista Central"));
        assertTrue(str.contains("instalaciones="));
    }
}