package org.ualhmis.torneos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;

class TorneoConSedeTest {

    @Test
    void testConstructorAndGetters() {
        Torneo torneo = new Torneo("Liga Regional", "Fútbol", "Juvenil", "Masculino", "Liga");
        Sede sede = new Sede("Estadio Central");
        TorneoConSede tcs = new TorneoConSede(torneo, sede);

        assertEquals(torneo, tcs.getTorneo());
        assertEquals(sede, tcs.getSede());
        
        // Test constructor con parámetros nulos
        assertThrows(IllegalArgumentException.class, () -> new TorneoConSede(null, sede));
        assertThrows(IllegalArgumentException.class, () -> new TorneoConSede(torneo, null));
    }

    @Test
    void testSetters() {
        Torneo torneo1 = new Torneo("T1", "Tenis", "Junior", "Femenino", "Grupos");
        Sede sede1 = new Sede("Sede 1");
        TorneoConSede tcs = new TorneoConSede(torneo1, sede1);

        Torneo torneo2 = new Torneo("T2", "Baloncesto", "Junior", "Femenino", "Liga");
        Sede sede2 = new Sede("Sede 2");

        tcs.setTorneo(torneo2);
        tcs.setSede(sede2);

        assertEquals(torneo2, tcs.getTorneo());
        assertEquals(sede2, tcs.getSede());
        
        // Test setters con valores nulos
        assertThrows(IllegalArgumentException.class, () -> tcs.setTorneo(null));
        assertThrows(IllegalArgumentException.class, () -> tcs.setSede(null));
    }

    @Test
    void testValidarInstalaciones() throws Exception {
        // Configuración para acceder al método privado
        Method metodoPrivado = TorneoConSede.class.getDeclaredMethod("esAdecuadaParaDeporte", String.class, String.class);
        metodoPrivado.setAccessible(true);
        TorneoConSede tcs = new TorneoConSede(
            new Torneo("T", "Fútbol", "J", "M", "L"), 
            new Sede("S")
        );

        // Prueba todos los casos del método privado
        assertTrue((boolean)metodoPrivado.invoke(tcs, "campo", "Fútbol"));
        assertTrue((boolean)metodoPrivado.invoke(tcs, "pabellón", "Baloncesto"));
        assertTrue((boolean)metodoPrivado.invoke(tcs, "pista", "Tenis"));
        assertFalse((boolean)metodoPrivado.invoke(tcs, "pista", "Fútbol"));
        assertFalse((boolean)metodoPrivado.invoke(tcs, "campo", "Voleibol"));

        // Prueba el método público con diferentes escenarios
        Torneo torneoFutbol = new Torneo("LF", "Fútbol", "J", "M", "L");
        Sede sedeAdecuada = new Sede("S1");
        sedeAdecuada.agregarInstalacion(new Instalacion("C1", "campo"));
        assertTrue(new TorneoConSede(torneoFutbol, sedeAdecuada).validarInstalacionesAdecuadas());

        Sede sedeInadecuada = new Sede("S2");
        sedeInadecuada.agregarInstalacion(new Instalacion("P1", "pista"));
        assertFalse(new TorneoConSede(torneoFutbol, sedeInadecuada).validarInstalacionesAdecuadas());

        Sede sedeVacia = new Sede("S3");
        assertFalse(new TorneoConSede(torneoFutbol, sedeVacia).validarInstalacionesAdecuadas());
    }

    @Test
    void testToString() {
        Torneo torneo = new Torneo("T1", "Tenis", "J", "F", "G");
        Sede sede = new Sede("S1");
        TorneoConSede tcs = new TorneoConSede(torneo, sede);
        
        String str = tcs.toString();
        assertTrue(str.contains("T1") && str.contains("S1") && str.contains("TorneoConSede"));
    }
}