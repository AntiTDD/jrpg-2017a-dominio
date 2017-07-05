package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Guerrero;
import dominio.Hechicero;
import dominio.Humano;
import dominio.Orco;

/**
 * The Class TestElfo.
 * se utiliza para testear las distintas
 * ataques, defensas y habilidades
 * del elfo
 */
public class TestElfo {

   /** The cien. */
   private final int cien = 100,
               veinticinco = 25,
               veinte = 20,
               treinta = 30,
               tres = 3;

   /** The cero punto dos. */
   private final float ceroPuntoDos = 0.2f,
                       ceroPuntoTres = 0.3f,
                       unoPuntoCinco = 1.5f;
  /**
   * Test golpe level.
   */
  @Test
  public void testGolpeLevel() {
    Elfo e = new Elfo("Nico", cien,
                      cien, veinticinco, veinte, treinta,
                      new Asesino(ceroPuntoDos, ceroPuntoTres,
                                  unoPuntoCinco), 0, tres, 1);
    Humano h = new Humano("Nico", cien, cien,
               veinticinco, veinte, treinta,
               new Asesino(ceroPuntoDos, ceroPuntoTres,
                           unoPuntoCinco), 0, 1, 1);

    Assert.assertTrue(h.getSalud() == cien);
    if (e.habilidadRaza1(h)) {
      Assert.assertTrue(h.getSalud() < cien);
    } else {
      Assert.assertTrue(h.getSalud() == cien);
    }
  }

  /**
   * Test ataque bosque.
   */
  @Test
  public void testAtaqueBosque() {
    Elfo e = new Elfo("Nico", cien, cien, veinticinco, veinte,
                      treinta, new Asesino(ceroPuntoDos, ceroPuntoTres,
                                           unoPuntoCinco), 0, tres, 1);
    Humano h = new Humano("Nico", cien, cien,
                          veinticinco, veinte, treinta,
                          new Asesino(ceroPuntoDos, ceroPuntoTres,
                                      unoPuntoCinco), 0, 1, 1);

    Assert.assertTrue(h.getSalud() == cien);
    if (e.habilidadRaza2(h)) {
      Assert.assertTrue(h.getSalud() < cien);
    } else {
      Assert.assertTrue(h.getSalud() == cien);
    }
  }


  /**
   * Que un elfo no pueda efectuar su habilidad raza 1 por no tener energia.
   */
  @Test
  public void queUnElfoNoPuedaEfectuarSuHabilidadRaza1PorNoTenerEnergia() {
    Elfo e = new Elfo("Legolas", new Hechicero(), 1);
    Orco o = new Orco("Uruk-Hai", new Guerrero(), 1);
    e.bajarEnergia(cien);
    Assert.assertFalse(e.habilidadRaza1(o));
  }


  /**
   * Que un elfo no pueda efectuar su habilidad raza 2 por no tener energia.
   */
  @Test
  public void queUnElfoNoPuedaEfectuarSuHabilidadRaza2PorNoTenerEnergia() {
        Elfo e = new Elfo("Legolas", new Hechicero(), 1);
        Orco o = new Orco("Uruk-Hai", new Guerrero(), 1);
    e.bajarEnergia(cien);
    Assert.assertFalse(e.habilidadRaza2(o));
  }
}
