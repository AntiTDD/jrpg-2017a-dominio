package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Humano;
import dominio.Personaje;

public class TestNivelExp {
	   /** The cien. */
	   private final int cien = 100,
	               veinticinco = 25,
	               veinte = 20,
	               treinta = 30,
	               diezmil = 10000,
	               trescientos = 300,
	               cuatro = 4,
	               noventaYNueve = 99,
	               cuarentaYCinco = 45;

	   /** The cero punto dos. */
	   private final float ceroPuntoDos = 0.2f,
	                       ceroPuntoTres = 0.3f,
	                       unoPuntoCinco = 1.5f;

  /**
   * Test ganar exp.
   */
  @Test
  public void testGanarExp() {
    Personaje.cargarTablaNivel();
    Humano h = new Humano("Nico", cien, cien, veinticinco,
                           veinte, treinta, new Asesino(ceroPuntoDos,
                           ceroPuntoTres, unoPuntoCinco), 0, 1, 1);
    h.ganarExperiencia(cuarentaYCinco);
    Assert.assertTrue(h.getExperiencia() == cuarentaYCinco);
  }

  /**
   * Test subir nivel.
   */
  @Test
  public void testSubirNivel() {
    Personaje.cargarTablaNivel();
    Humano h = new Humano("Nico", cien, cien,
                         veinticinco, veinte, treinta, new Asesino(ceroPuntoDos,
                         ceroPuntoTres, unoPuntoCinco), 0, 1, 1);
    h.ganarExperiencia(trescientos);
    Assert.assertTrue(h.getNivel() == cuatro);
    Assert.assertTrue(h.getExperiencia() == 0);
  }

  /**
   * Test level 100.
   */
  @Test
  public void testLevel100() {
    Personaje.cargarTablaNivel();
    Humano h = new Humano("Nico", cien, cien, veinticinco, veinte,
                         treinta, new Asesino(ceroPuntoDos,
                         ceroPuntoTres, unoPuntoCinco), 0, noventaYNueve, 1);
    h.ganarExperiencia(diezmil);
    Assert.assertTrue(h.getNivel() == cien);
  }
}
