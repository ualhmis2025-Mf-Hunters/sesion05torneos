package org.ualhmis.torneos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Stream;

public class InstalacionTest {

    @Test
    void testNombreYTipo() {
        Instalacion i = new Instalacion("Pista 0", "pista");
        assertEquals("Pista 0", i.getNombre());
        assertEquals("pista", i.getTipo());
    }

    @ParameterizedTest
    @MethodSource("horariosDisponibles")
    void testDisponibilidadHorarios(LocalDateTime horaLibre, LocalDateTime horaOcupada) {
        Instalacion i = new Instalacion("Pabellón 1", "pabellón");

        Partido partido = new Partido(
                new Equipo("E1", "Juvenil", "Masculino", new Entrenador("A", "M", LocalDate.of(1980, 1, 1))),
                new Equipo("E2", "Juvenil", "Masculino", new Entrenador("B", "M", LocalDate.of(1980, 1, 1))));

        assertTrue(i.estaDisponible(horaLibre));
        assertTrue(i.asignarPartido(horaLibre, partido));
        assertFalse(i.estaDisponible(horaLibre));
        assertFalse(i.asignarPartido(horaLibre, partido)); // doble reserva
        assertTrue(i.estaDisponible(horaOcupada)); // hora distinta libre
    }

    static Stream<LocalDateTime[]> horariosDisponibles() {
        return Stream.of(
                new LocalDateTime[] { LocalDateTime.of(2025, 5, 10, 8, 0), LocalDateTime.of(2025, 5, 10, 9, 0) },
                new LocalDateTime[] { LocalDateTime.of(2025, 5, 10, 23, 0), LocalDateTime.of(2025, 5, 11, 0, 0) } // límite
                                                                                                                  // noche
        );
    }
}
