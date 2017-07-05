package tests_dominio;

import org.junit.Test;

import dominio.*;
import org.junit.Assert;

/**
 * The Class TestAtributos.
 *
 * para testear la asignacion de puntos a
 * distintos personajes
 */
public class TestAtributos {

    /**  atributos para que no aparezca
    *  el error.
   * de checkstyle "numero X es magico */
    private final int diez = 10,
                      veintidos = 22,
                      quince = 15;

  /**
   * Test incrementar fuerza.
   */
  @Test
  public void testIncrementarFuerza() {
    Humano h = new Humano("Nicolas", new Guerrero(), 1);

    Assert.assertTrue(h.getAtaque() == veintidos);
    h.AsignarPuntosSkills(diez, 0, 0);
    Assert.assertTrue(h.getAtaque() > veintidos);
  }

  /**
   * Test incrementar destreza.
   */
  @Test
  public void testIncrementarDestreza() {
    Humano h = new Humano("Nicolas", new Guerrero(), 1);

    Assert.assertTrue(h.getDefensa() == diez);
    h.AsignarPuntosSkills(0, diez, 0);
    Assert.assertTrue(h.getDefensa() > diez);
  }

  /**
   * Test incrementar inteligencia.
   */
  @Test
  public void testIncrementarInteligencia() {
    Humano h = new Humano("Nicolas", new Guerrero(), 1);
    Assert.assertTrue(h.getMagia() == quince);
    h.AsignarPuntosSkills(0, 0, diez);
    Assert.assertTrue(h.getMagia() > quince);
  }
}
