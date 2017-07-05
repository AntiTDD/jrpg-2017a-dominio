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
 * The Class TestHumano.
 */
public class TestHumano {
	   /** The cien. */
	   private final int cien = 100,
	               veinticinco = 25,
	               veinte = 20,
	               treinta = 30,
	               tres = 3,
	               cincuentaYCinco = 55,
	               treintaYSiete = 37,
	               cincuenta = 50,
	               setenta = 70,
	               noventa = 90;

	   /** The cero punto dos. */
	   private final float ceroPuntoDos = 0.2f,
	                       ceroPuntoTres = 0.3f,
	                       unoPuntoCinco = 1.5f;

  /**
   * Test incentivar.
   */
  @Test
  public void testIncentivar() {
    Humano h = new Humano("Nico", cien, cien, cincuentaYCinco,
               veinte, treinta, new Hechicero(ceroPuntoDos,
            		   ceroPuntoTres, unoPuntoCinco), 0, 1, 1);
    Elfo e = new Elfo("Nico", cien, cien, veinticinco, veinte,
               treinta, new Asesino(ceroPuntoDos,
            		   ceroPuntoTres, unoPuntoCinco), 0, tres, 1);


    Assert.assertTrue(e.getAtaque() == treintaYSiete);
    h.habilidadRaza1(e);
    Assert.assertTrue(e.getAtaque() > treintaYSiete);
  }

  /**
   * Test golpe fatal.
   */
  @Test
  public void testGolpeFatal() {
    Humano h = new Humano("Nico", cien, cien, cincuentaYCinco, veinte,
               treinta, new Hechicero(ceroPuntoDos,
            		              ceroPuntoTres, unoPuntoCinco), 0, 1, 1);
    Elfo e = new Elfo("Nico", cien, cien, veinticinco, veinte,
               treinta, new Asesino(ceroPuntoDos, ceroPuntoTres,
            		     unoPuntoCinco), 0, tres, 1);

    Assert.assertTrue(h.getEnergia() == cien);
    Assert.assertTrue(e.getSalud() == cien);
    if (h.habilidadRaza2(e)) {
      Assert.assertTrue(e.getSalud() == setenta);
      Assert.assertTrue(h.getEnergia() == cincuenta);
    } else {
      Assert.assertTrue(h.getEnergia() == noventa);
      Assert.assertTrue(e.getSalud() == cien);
    }
  }

  /**
   * Que un humano no pueda efectuar su habilidad raza 1 por no tener energia.
   */
  @Test
  public void queUnHumanoNoPuedaEfectuarSuHabilidadRaza1PorNoTenerEnergia() {
    Humano e = new Humano("Aragorn", new Guerrero(), 1);
    Orco o = new Orco("Uruk-Hai", new Guerrero(), 1);
    e.bajarEnergia(cien); // Estaba e.setEnergia(0) //
    Assert.assertFalse(e.habilidadRaza1(o));
  }


  /**
   * Que un humano no pueda efectuar su habilidad raza 2 por no tener energia.
   */
  @Test
  public void queUnHumanoNoPuedaEfectuarSuHabilidadRaza2PorNoTenerEnergia() {
    Humano e = new Humano("Aragorn", new Guerrero(), 1);
    Orco o = new Orco("Uruk-Hai", new Guerrero(), 1);
    e.bajarEnergia(cien); // Estaba e.setEnergia(0) //
    Assert.assertFalse(e.habilidadRaza2(o));
  }
}
