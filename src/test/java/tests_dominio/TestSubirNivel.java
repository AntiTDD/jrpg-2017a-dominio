package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Guerrero;
import dominio.Humano;
import dominio.Personaje;

/**
 * The Class TestSubirNivel.
 */
public class TestSubirNivel {

  /**Se utilzan para evitar problemas
   * con el checkstyle "x es un numero magico" */
  private final int cien = 100,
                    cincuenta = 50,
                    trescientosmil = 3000000,
                    ciento50 = 150,
                    tres = 3;

  /**
   * Test subirde nivel.
   */
  @Test
  public void testSubirdeNivel() {
    Personaje.cargarTablaNivel();
    Humano h = new Humano("Nicolas", new Guerrero(), 1);
    Assert.assertTrue(h.getNivel() == 1);
    h.ganarExperiencia(cincuenta);
    Assert.assertTrue(h.getNivel() == 2);
  }

  /**
   * Test nivel 100.
   */
  @Test
  public void testNivel100() {
    Personaje.cargarTablaNivel();
    Humano h = new Humano("Nicolas", new Guerrero(), 1);
    h.ganarExperiencia(trescientosmil);
    Assert.assertTrue(h.getNivel() == cien);
    h.subirNivel();
    Assert.assertTrue(h.getNivel() == cien);

  }

  /**
   * Test ganar mucha exp.
   */
  @Test
  public void testGanarMuchaExp() {
    Personaje.cargarTablaNivel();
    Humano h = new Humano("Nicolas", new Guerrero(), 1);
    Assert.assertTrue(h.getNivel() == 1);
    h.ganarExperiencia(ciento50);
    Assert.assertTrue(h.getNivel() == tres);
  }
}
