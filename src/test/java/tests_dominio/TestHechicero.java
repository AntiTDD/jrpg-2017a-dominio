package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Hechicero;
import dominio.Humano;
import dominio.MyRandomStub;
import dominio.Orco;

public class TestHechicero {

  @Test
  public void testCurar() {
    Humano h = new Humano("Nico", 100, 100,
                 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
    Elfo e = new Elfo("Nico", 100, 100, 25,
                 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

    Assert.assertTrue(e.getSalud() == 100);
    h.setTipoDeRandom(new MyRandomStub(1));
    e.setTipoDeRandom(new MyRandomStub(1));
    h.atacar(e);
    Assert.assertEquals(38, e.getSalud());
    h.habilidadCasta2(e);
    Assert.assertEquals(83, e.getSalud());
  }

  /**
   * Test bola de fuego.
   */
  @Test
  public void testBolaDeFuego() {
    Humano h = new Humano("Nico", 100, 100, 55,
               20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
    Elfo e = new Elfo("Nico", 100, 100, 25,
               20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

    Assert.assertTrue(e.getSalud() == 100);
    if (h.habilidadCasta1(e)) {
      Assert.assertTrue(e.getSalud() < 100);
    } else {
      Assert.assertTrue(e.getSalud() == 100);
    }
  }


  /**
   * Test robar energia y salud.
   */
  @Test
  public void testRobarEnergia_y_Salud() {
    Humano h = new Humano("Nico", 100, 100, 55, 20,
                         50, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
    Elfo e = new Elfo("Nico", 100, 100, 25, 20,
                     30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
    h.setTipoDeRandom(new MyRandomStub(1));
    e.setTipoDeRandom(new MyRandomStub(1));

    Assert.assertTrue(e.getSalud() == 100);
    e.atacar(h);
    e.atacar(h);
    h.bajarEnergia(60);

    Assert.assertEquals(40, h.getEnergia());
    Assert.assertEquals(66, h.getSalud());

    h.habilidadCasta3(e);

    Assert.assertEquals(85, h.getEnergia());
    Assert.assertEquals(83, h.getSalud());
  }

  /**
   * Que un hechicero no pueda ejecutar su habilidad 1 por no tener energia.
   */
  @Test
  public void queUnHechiceroNoPuedaEjecutarSuHabilidad1PorNoTenerEnergia() {
    Elfo e = new Elfo("Legolas", new Hechicero(), 1);
    Orco o = new Orco("Uruk-Hai", new Asesino(), 1);
    e.bajarEnergia(100);
    Assert.assertFalse(e.habilidadCasta1(o));
  }

  @Test
  public void queUnHechiceroNoPuedaEjecutarSuHabilidad2PorNoTenerEnergia() {
        Elfo e = new Elfo("Legolas", new Hechicero(), 1);
        Orco o = new Orco("Uruk-Hai", new Asesino(), 1);
    e.bajarEnergia(100);
    Assert.assertFalse(e.habilidadCasta2(o));
  }

  @Test
  public void queUnHechiceroNoPuedaEjecutarSuHabilidad3PorNoTenerEnergia() {
    Elfo e = new Elfo("Legolas", new Hechicero(), 1);
    Orco o = new Orco("Uruk-Hai", new Asesino(), 1);
    e.bajarEnergia(100);
    Assert.assertFalse(e.habilidadCasta3(o));
  }
}
