package org.ualhmis.torneos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TorneoConSedeTest {

    @Test
    void testCreacionValida() {
        Torneo torneo = new Torneo("Liga Regional", "Fútbol", "Juvenil", "Masculino", "Liga");
        Sede sede = new Sede("Estadio Central");
        TorneoConSede tcs = new TorneoConSede(torneo, sede);

        assertEquals(torneo, tcs.getTorneo());
        assertEquals(sede, tcs.getSede());
    }

    @Test
    void testCreacionInvalida() {
        Sede sede = new Sede("Estadio Central");
        Torneo torneo = new Torneo("Liga", "Fútbol", "Juvenil", "Masculino", "Liga");

        assertThrows(IllegalArgumentException.class, () -> new TorneoConSede(null, sede));
        assertThrows(IllegalArgumentException.class, () -> new TorneoConSede(torneo, null));
    }

    @Test
    void testValidarInstalacionesAdecuadas() {
        Torneo torneo = new Torneo("Liga Fútbol", "Fútbol", "Juvenil", "Masculino", "Liga");
        Sede sede = new Sede("Sede Fútbol");
        sede.agregarInstalacion(new Instalacion("Campo 1", "campo"));

        TorneoConSede tcs = new TorneoConSede(torneo, sede);
        assertTrue(tcs.validarInstalacionesAdecuadas());
    }

    @Test
    void testValidarInstalacionesNoAdecuadas() {
        Torneo torneo = new Torneo("Liga Fútbol", "Fútbol", "Juvenil", "Masculino", "Liga");
        Sede sede = new Sede("Sede Multiusos");
        sede.agregarInstalacion(new Instalacion("Pista Tenis", "pista"));

        TorneoConSede tcs = new TorneoConSede(torneo, sede);
        assertFalse(tcs.validarInstalacionesAdecuadas());
    }

    @Test
    void testValidarSinInstalaciones() {
        Torneo torneo = new Torneo("Liga Fútbol", "Fútbol", "Juvenil", "Masculino", "Liga");
        Sede sede = new Sede("Sede Vacía");

        TorneoConSede tcs = new TorneoConSede(torneo, sede);
        assertFalse(tcs.validarInstalacionesAdecuadas());
    }

    @Test
    void testSettersYToString() {
        Torneo torneo1 = new Torneo("T1", "Tenis", "Junior", "Femenino", "Grupos");
        Sede sede1 = new Sede("Sede 1");
        TorneoConSede tcs = new TorneoConSede(torneo1, sede1);

        Torneo torneo2 = new Torneo("T2", "Baloncesto", "Junior", "Femenino", "Liga");
        Sede sede2 = new Sede("Sede 2");

        tcs.setTorneo(torneo2);
        tcs.setSede(sede2);

        assertEquals(torneo2, tcs.getTorneo());
        assertEquals(sede2, tcs.getSede());
        assertTrue(tcs.toString().contains("Sede 2"));
    }
}
