package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Guerrero;
import dominio.Hechicero;
import dominio.Humano;
import dominio.MyRandomStub;
import dominio.Orco;

/**
 * The Class TestOrco.
 */
public class TestOrco {
	   /** The cien. */
	   private final int cien = 100,
	               veinticinco = 25,
	               veinte = 20,
	               treinta = 30,
	               tres = 3,
	               cincuentaYCinco = 55,
	               cientoCinco = 105,
	               noventaYCinco = 95,
	               ochenta = 80,
	               cuarenta = 40;

	   /** The cero punto dos. */
	   private final float ceroPuntoDos = 0.2f,
	                       ceroPuntoTres = 0.3f,
	                       unoPuntoCinco = 1.5f;

  /**
   * Test golpe defensivo.
   */
  @Test
  public void testGolpeDefensivo() {
    Humano h = new Humano("Nicolas", new Guerrero(), 1);
    Orco o = new Orco("Hernan", new Guerrero(), 1);
    h.setTipoDeRandom(new MyRandomStub(1));
    o.setTipoDeRandom(new MyRandomStub(1));

    Assert.assertTrue(h.getSalud() == cientoCinco);
    if (o.habilidadRaza1(h)) {
      Assert.assertTrue(h.getSalud() == noventaYCinco);
    } else {
      Assert.assertTrue(o.getSalud() == cientoCinco);
    }
  }

  /**
   * Test mordisco de vida.
   */
  @Test
  public void testMordiscoDeVida() {
    Humano h = new Humano("Nico", cien, cien,
                          cincuentaYCinco, veinte, treinta, new Hechicero(
                          ceroPuntoDos, ceroPuntoTres, unoPuntoCinco), 0, 1, 1);
    Orco o = new Orco("Nico", cien, cien,
                      ochenta, veinte, treinta, new Asesino(ceroPuntoDos,
                      ceroPuntoTres, unoPuntoCinco), 0, 1, 1);

    Assert.assertTrue(h.getSalud() == cien);
    if (o.habilidadRaza2(h)) {
      Assert.assertEquals(cuarenta, h.getSalud());
      Assert.assertTrue(o.getSalud() == cien);
    } else {
      Assert.assertTrue(o.getSalud() == cien);
      Assert.assertTrue(h.getSalud() == cien);
    }
  }


  /**
   * Que un orco no pueda efectuar su habilidad raza 1 por no tener energia.
   */
  @Test
  public void queUnOrcoNoPuedaEfectuarSuHabilidadRaza1PorNoTenerEnergia() {
    Orco o = new Orco("Uruk-Hai", new Guerrero(), 1);
    Humano e = new Humano("Aragorn", new Guerrero(), 1);
    o.bajarEnergia(cien);
    Assert.assertFalse(o.habilidadRaza1(e));
  }


  /**
   * Que un orco no pueda efectuar su habilidad raza 2 por no tener energia.
   */
  @Test
  public void queUnOrcoNoPuedaEfectuarSuHabilidadRaza2PorNoTenerEnergia() {
    Orco o = new Orco("Uruk-Hai", new Guerrero(), 1);
    Humano e = new Humano("Aragorn", new Guerrero(), 1);
    o.bajarEnergia(cien);
    Assert.assertFalse(o.habilidadRaza2(e));
  }
}
