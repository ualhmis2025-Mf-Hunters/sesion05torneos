package org.ualhmis.torneos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TorneoConSedeTest {

    @Test
    void testAsociacionTorneoSede() {
        Torneo torneo = new Torneo("Liga Norte", "Tenis", "Junior", "Mixto", "Grupos");
        Sede sede = new Sede("Sede Norte");

        TorneoConSede torneoConSede = new TorneoConSede(torneo, sede);

        assertEquals(torneo, torneoConSede.getTorneo());
        assertEquals(sede, torneoConSede.getSede());
    }

    @ParameterizedTest
    @CsvSource({
            "Fútbol, campo, true",
            "Baloncesto, pabellón, true",
            "Tenis, pista, true",
            "Fútbol, pista, false",
            "Tenis, pabellón, false"
    })
    void testValidacionCompatibilidadDeporteYInstalacion(String deporte, String tipoInstalacion, boolean esperado) {
        Torneo torneo = new Torneo("Torneo Param", deporte, "Junior", "Masculino", "Eliminatoria");
        Sede sede = new Sede("Sede Test");

        sede.agregarInstalacion(new Instalacion("Instalacion 1", tipoInstalacion));
        TorneoConSede tcs = new TorneoConSede(torneo, sede);

        assertEquals(esperado, tcs.validarInstalacionesAdecuadas());
    }

    @Test
    void testTorneoSinInstalacionesEnSede() {
        Torneo torneo = new Torneo("Torneo sin instalaciones", "Fútbol", "Junior", "Masculino", "Grupos");
        Sede sede = new Sede("Sede vacía");
        TorneoConSede torneoConSede = new TorneoConSede(torneo, sede);

        assertFalse(torneoConSede.validarInstalacionesAdecuadas());
    }
}
