package org.ualhmis.torneos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class JugadorTest {

    @Test
    void testCategoriaPorEdad() {
        Jugador infantil = new Jugador("Carlos", "Masculino", LocalDate.now().minusYears(10));
        assertEquals("Infantil", infantil.getCategoria());

        Jugador cadete = new Jugador("Luis", "Masculino", LocalDate.now().minusYears(13));
        assertEquals("Cadete", cadete.getCategoria());

        Jugador juvenil = new Jugador("Ana", "Femenino", LocalDate.now().minusYears(16));
        assertEquals("Juvenil", juvenil.getCategoria());

        Jugador junior = new Jugador("Pedro", "Masculino", LocalDate.now().minusYears(19));
        assertEquals("Junior", junior.getCategoria());

        Jugador absoluta = new Jugador("Marta", "Femenino", LocalDate.now().minusYears(25));
        assertEquals("Absoluta", absoluta.getCategoria());
    }

    @Test
    void testActualizarCategoria() {
        Jugador jugador = new Jugador("Maria", "Femenino", LocalDate.now().minusYears(11));
        assertEquals("Infantil", jugador.getCategoria());

        jugador.setFechaNacimiento(LocalDate.now().minusYears(16));
        jugador.actualizarCategoria();
        assertEquals("Juvenil", jugador.getCategoria());
    }

    @Test
    void testToString() {
        Jugador jugador = new Jugador("Maria", "Femenino", LocalDate.of(2000, 1, 1));
        String esperado = "Jugador [Persona [nombre=Maria, genero=Femenino, fechaNacimiento=2000-01-01], categoria=Absoluta]";

        assertEquals(esperado, jugador.toString());
    }
}
