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
 * The Class TestGuerrero.
 * se utiliza para testear las distintas
 * ataques, defensas y habilidades
 * del guerrero
 */
public class TestGuerrero {
	   /** The cien. */
	   private final int cien = 100,
	               veinticinco = 25,
	               veinte = 20,
	               treinta = 30,
	               tres = 3,
	               sesentaycinco = 65;

	   /** The cero punto dos. */
	   private final float ceroPuntoDos = 0.2f,
	                       ceroPuntoTres = 0.3f,
	                       unoPuntoCinco = 1.5f;

  /**
   * Test doble golpe.
   */
  @Test
  public void testDobleGolpe() {
    Humano h = new Humano("Nico", cien, cien,
                          veinticinco, veinte, treinta,
                          new Guerrero(ceroPuntoDos, ceroPuntoDos,
                        		       unoPuntoCinco), 0, 1, 1);
    Elfo e = new Elfo("Nico", cien, cien, veinticinco, veinte,
                      treinta, new Asesino(ceroPuntoDos, ceroPuntoTres,
                    		               unoPuntoCinco), 0, tres, 1);

    Assert.assertTrue(e.getSalud() == cien);
    if (h.habilidadCasta1(e)) {
      Assert.assertTrue(e.getSalud() < cien);
    } else {
      Assert.assertTrue(e.getSalud() == cien);
    }
  }

  /**
   * Test auto defensa.
   */
  @Test
  public void testAutoDefensa() {
    Humano h = new Humano("Nico", cien, cien,
                          veinticinco, veinte, treinta,
                          new Guerrero(ceroPuntoDos, ceroPuntoTres,
                        		  unoPuntoCinco), 0, 1, 1);

    Assert.assertTrue(h.getDefensa() == veinte);
    h.habilidadCasta2(null);
    Assert.assertTrue(h.getDefensa() == sesentaycinco);
  }

  /**
   * Test ignora defensa.
   */
  @Test
  public void testIgnoraDefensa() {
    Humano h = new Humano("Nico", cien, cien,
               veinticinco, veinte, treinta,
               new Guerrero(ceroPuntoDos, ceroPuntoTres,
            		   unoPuntoCinco), 0, 1, 1);
    Elfo e = new Elfo("Nico", cien, cien, veinticinco,
               veinte, treinta,
               new Asesino(ceroPuntoDos, ceroPuntoTres,
            		   unoPuntoCinco), 0, tres, 1);

    Assert.assertTrue(e.getSalud() == cien);
    if (h.habilidadCasta3(e)) {
      Assert.assertTrue(e.getSalud() < cien);
    } else {
      Assert.assertTrue(e.getSalud() == cien);
    }
  }

  /**
   * Que un guerrero no pueda ejecutar su habilidad 1 por no tener energia.
   */
  @Test
  public void queUnGuerreroNoPuedaEjecutarSuHabilidad1PorNoTenerEnergia() {
    Elfo e = new Elfo("Legolas", new Guerrero(), 1);
    Orco o = new Orco("Uruk-Hai", new Hechicero(), 1);
    e.bajarEnergia(cien);
    Assert.assertFalse(e.habilidadCasta1(o));
  }


  /**
   * Que un guerrero no pueda ejecutar su habilidad 2 por no tener energia.
   */
  @Test
  public void queUnGuerreroNoPuedaEjecutarSuHabilidad2PorNoTenerEnergia() {
    Elfo e = new Elfo("Legolas", new Guerrero(), 1);
    Orco o = new Orco("Uruk-Hai", new Hechicero(), 1);
    e.bajarEnergia(cien);
    Assert.assertFalse(e.habilidadCasta2(o));
  }


  /**
   * Que un guerrero no pueda ejecutar su habilidad 3 por no tener energia.
   */
  @Test
  public void queUnGuerreroNoPuedaEjecutarSuHabilidad3PorNoTenerEnergia() {
    Elfo e = new Elfo("Legolas", new Guerrero(), 1);
    Orco o = new Orco("Uruk-Hai", new Hechicero(), 1);
    e.bajarEnergia(cien);
    Assert.assertFalse(e.habilidadCasta3(o));
  }
}
