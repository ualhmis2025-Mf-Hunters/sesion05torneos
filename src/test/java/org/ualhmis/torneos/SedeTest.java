package org.ualhmis.torneos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;

public class SedeTest {

    @Test
    void testSedeSinInstalaciones() {
        Sede sede = new Sede("Vacía");
        assertTrue(sede.getInstalaciones().isEmpty());
        assertEquals("Vacía", sede.getNombre());
    }

    @ParameterizedTest
    @CsvSource({
            "Campo A, campo",
            "Pabellón B, pabellón",
            "Pista C, pista"
    })
    void testAgregarInstalacionesConTipos(String nombre, String tipo) {
        Sede sede = new Sede("Centro Multiusos");
        Instalacion instalacion = new Instalacion(nombre, tipo);
        sede.agregarInstalacion(instalacion);

        assertEquals(1, sede.getInstalaciones().size());
        assertEquals(tipo, sede.getInstalaciones().get(0).getTipo());
        assertEquals(nombre, sede.getInstalaciones().get(0).getNombre());
    }
}
