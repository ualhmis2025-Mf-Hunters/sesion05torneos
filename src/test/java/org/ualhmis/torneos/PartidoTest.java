package org.ualhmis.torneos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class PartidoTest {

    @Test
    void testCreacionValidaPartido() {
        Equipo equipo1 = new Equipo("Tigres", "Juvenil", "Masculino", new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10)));
        Equipo equipo2 = new Equipo("Leones", "Juvenil", "Masculino", new Entrenador("Ana", "Femenino", LocalDate.of(1985, 6, 20)));

        Partido partido = new Partido(equipo1, equipo2);

        assertEquals(equipo1, partido.getEquipo1());
        assertEquals(equipo2, partido.getEquipo2());
    }

    @Test
    void testCreacionInvalidaPartido() {
        Equipo equipo1 = new Equipo("Tigres", "Juvenil", "Masculino", new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10)));
        Equipo equipo2 = new Equipo("Leones", "Cadete", "Masculino", new Entrenador("Ana", "Femenino", LocalDate.of(1985, 6, 20)));

        assertThrows(IllegalArgumentException.class, () -> new Partido(equipo1, equipo2));
        assertThrows(IllegalArgumentException.class, () -> new Partido(null, equipo2));
    }

    @Test
    void testRegistrarResultadoValido() {
        Equipo equipo1 = new Equipo("Tigres", "Juvenil", "Masculino", new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10)));
        Equipo equipo2 = new Equipo("Leones", "Juvenil", "Masculino", new Entrenador("Ana", "Femenino", LocalDate.of(1985, 6, 20)));

        Partido partido = new Partido(equipo1, equipo2);
        partido.registrarResultado(3, 2);

        assertEquals(3, partido.getGolesEquipo1());
        assertEquals(2, partido.getGolesEquipo2());
    }

    @Test
    void testRegistrarResultadoInvalido() {
        Equipo equipo1 = new Equipo("Tigres", "Juvenil", "Masculino", new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10)));
        Equipo equipo2 = new Equipo("Leones", "Juvenil", "Masculino", new Entrenador("Ana", "Femenino", LocalDate.of(1985, 6, 20)));

        Partido partido = new Partido(equipo1, equipo2);

        assertThrows(IllegalArgumentException.class, () -> partido.registrarResultado(-1, 2));
        assertThrows(IllegalArgumentException.class, () -> partido.registrarResultado(2, -3));
    }

    @Test
    void testToString() {
        Equipo equipo1 = new Equipo("Tigres", "Juvenil", "Masculino", new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10)));
        Equipo equipo2 = new Equipo("Leones", "Juvenil", "Masculino", new Entrenador("Ana", "Femenino", LocalDate.of(1985, 6, 20)));

        Partido partido = new Partido(equipo1, equipo2);
        partido.registrarResultado(1, 1);

        String esperado = "Partido [equipo1=Tigres (1) vs equipo2=Leones (1)]";
        assertEquals(esperado, partido.toString());
    }

    @Test
void testSetters() {
    Equipo equipo1 = new Equipo("Tigres", "Juvenil", "Masculino", new Entrenador("Carlos", "Masculino", LocalDate.of(1980, 3, 10)));
    Equipo equipo2 = new Equipo("Leones", "Juvenil", "Masculino", new Entrenador("Ana", "Femenino", LocalDate.of(1985, 6, 20)));

    Partido partido = new Partido(equipo1, equipo2);

    Equipo nuevoEquipo1 = new Equipo("Águilas", "Juvenil", "Masculino", new Entrenador("Luis", "Masculino", LocalDate.of(1975, 1, 15)));
    Equipo nuevoEquipo2 = new Equipo("Halcones", "Juvenil", "Masculino", new Entrenador("Marta", "Femenino", LocalDate.of(1985, 7, 10)));
    
    partido.setEquipo1(nuevoEquipo1);
    partido.setEquipo2(nuevoEquipo2);
    partido.setGolesEquipo1(4);
    partido.setGolesEquipo2(3);

    assertEquals(nuevoEquipo1, partido.getEquipo1());
    assertEquals(nuevoEquipo2, partido.getEquipo2());
    assertEquals(4, partido.getGolesEquipo1());
    assertEquals(3, partido.getGolesEquipo2());
}

}
