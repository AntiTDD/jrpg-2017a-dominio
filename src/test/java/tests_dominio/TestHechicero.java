package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Hechicero;
import dominio.Humano;
import dominio.MyRandomStub;
import dominio.Orco;

/**
 * The Class TestHechicero.
 */
public class TestHechicero {
	   /** The cien. */
	   private final int cien = 100,
	               veinticinco = 25,
	               veinte = 20,
	               treinta = 30,
	               tres = 3,
	               cincuentaycinco = 55,
	               cincuenta = 50,
	               ochentaYTres = 83,
	               sesenta = 60,
	               ochentaYCinco = 85,
	               cuarenta = 40,
	               treintaYOcho = 38,
	               sesentaYSeis = 66;

	   /** The cero punto dos. */
	   private final float ceroPuntoDos = 0.2f,
	                       ceroPuntoTres = 0.3f,
	                       unoPuntoCinco = 1.5f;

  /**
   * Test curar.
   */
  @Test
  public void testCurar() {
    Humano h = new Humano("Nico", cien, cien,
                 cincuentaycinco, veinte, treinta,
                 new Hechicero(ceroPuntoDos, ceroPuntoTres,
                		        unoPuntoCinco), 0, 1, 1);
    Elfo e = new Elfo("Nico", cien, cien, veinticinco,
                 veinte, treinta, new Asesino(ceroPuntoDos,
                		    ceroPuntoTres, unoPuntoCinco), 0, tres, 1);

    Assert.assertTrue(e.getSalud() == cien);
    h.setTipoDeRandom(new MyRandomStub(1));
    e.setTipoDeRandom(new MyRandomStub(1));
    h.atacar(e);
    Assert.assertEquals(treintaYOcho, e.getSalud());
    h.habilidadCasta2(e);
    Assert.assertEquals(ochentaYTres, e.getSalud());
  }

  /**
   * Test bola de fuego.
   */
  @Test
  public void testBolaDeFuego() {
    Humano h = new Humano("Nico", cien, cien, cincuentaycinco,
               veinte, treinta,
               new Hechicero(ceroPuntoDos, ceroPuntoTres,
            		         unoPuntoCinco), 0, 1, 1);
    Elfo e = new Elfo("Nico", cien, cien, veinticinco,
               veinte, treinta, new Asesino(ceroPuntoDos,
            		           ceroPuntoTres, unoPuntoCinco), 0, tres, 1);

    Assert.assertTrue(e.getSalud() == cien);
    if (h.habilidadCasta1(e)) {
      Assert.assertTrue(e.getSalud() < cien);
    } else {
      Assert.assertTrue(e.getSalud() == cien);
    }
  }


  /**
   * Test robar energia y salud.
   */
  @Test
  public void testRobarEnergiaYSalud() {
    Humano h = new Humano("Nico", cien, cien, cincuentaycinco, veinte,
    		cincuenta, new Hechicero(ceroPuntoDos,
    				    ceroPuntoTres, unoPuntoCinco), 0, 1, 1);
    Elfo e = new Elfo("Nico", cien, cien, veinticinco, veinte,
                     treinta, new Asesino(ceroPuntoDos,
                    		 ceroPuntoTres, unoPuntoCinco), 0, tres, 1);
    h.setTipoDeRandom(new MyRandomStub(1));
    e.setTipoDeRandom(new MyRandomStub(1));

    Assert.assertTrue(e.getSalud() == cien);
    e.atacar(h);
    e.atacar(h);
    h.bajarEnergia(sesenta);

    Assert.assertEquals(cuarenta, h.getEnergia());
    Assert.assertEquals(sesentaYSeis, h.getSalud());

    h.habilidadCasta3(e);

    Assert.assertEquals(ochentaYCinco, h.getEnergia());
    Assert.assertEquals(ochentaYTres, h.getSalud());
  }

  /**
   * Que un hechicero no pueda ejecutar su habilidad 1 por no tener energia.
   */
  @Test
  public void queUnHechiceroNoPuedaEjecutarSuHabilidad1PorNoTenerEnergia() {
    Elfo e = new Elfo("Legolas", new Hechicero(), 1);
    Orco o = new Orco("Uruk-Hai", new Asesino(), 1);
    e.bajarEnergia(cien);
    Assert.assertFalse(e.habilidadCasta1(o));
  }

  /**
   * Que un hechicero no pueda ejecutar su habilidad 2 por no tener energia.
   */
  @Test
  public void queUnHechiceroNoPuedaEjecutarSuHabilidad2PorNoTenerEnergia() {
        Elfo e = new Elfo("Legolas", new Hechicero(), 1);
        Orco o = new Orco("Uruk-Hai", new Asesino(), 1);
    e.bajarEnergia(cien);
    Assert.assertFalse(e.habilidadCasta2(o));
  }

  /**
   * Que un hechicero no pueda ejecutar su habilidad 3 por no tener energia.
   */
  @Test
  public void queUnHechiceroNoPuedaEjecutarSuHabilidad3PorNoTenerEnergia() {
    Elfo e = new Elfo("Legolas", new Hechicero(), 1);
    Orco o = new Orco("Uruk-Hai", new Asesino(), 1);
    e.bajarEnergia(cien);
    Assert.assertFalse(e.habilidadCasta3(o));
  }
}
