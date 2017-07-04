package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Guerrero;
import dominio.Hechicero;
import dominio.Humano;
import dominio.MyRandomStub;
import dominio.Orco;

public class TestOrco {

  @Test
  public void testGolpeDefensivo() {
    Humano h = new Humano("Nicolas", new Guerrero(), 1);
    Orco o = new Orco("Hernan", new Guerrero(), 1);
    h.setTipoDeRandom(new MyRandomStub(1));
    o.setTipoDeRandom(new MyRandomStub(1));

    Assert.assertTrue(h.getSalud() == 105);
    if (o.habilidadRaza1(h)) {
      Assert.assertTrue(h.getSalud() == 95); 
    } else {
      Assert.assertTrue(o.getSalud() == 105);
    }
  }

  @Test
  public void testMordiscoDeVida() {
    Humano h = new Humano("Nico", 100, 100,
                          55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
    Orco o = new Orco("Nico", 100, 100,
                          80, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);

    Assert.assertTrue(h.getSalud() == 100);
    if (o.habilidadRaza2(h)) {
      Assert.assertEquals(40, h.getSalud());
      Assert.assertTrue(o.getSalud() == 100);
    } else {
      Assert.assertTrue(o.getSalud() == 100);
      Assert.assertTrue(h.getSalud() == 100);
    }
  }


  @Test
  public void queUnOrcoNoPuedaEfectuarSuHabilidadRaza1PorNoTenerEnergia() {
    Orco o = new Orco("Uruk-Hai", new Guerrero(), 1);
    Humano e = new Humano("Aragorn", new Guerrero(), 1);
    o.bajarEnergia(100);
    Assert.assertFalse(o.habilidadRaza1(e));
  }
  

  @Test
  public void queUnOrcoNoPuedaEfectuarSuHabilidadRaza2PorNoTenerEnergia() {
    Orco o = new Orco("Uruk-Hai", new Guerrero(), 1);
    Humano e = new Humano("Aragorn", new Guerrero(), 1);
    o.bajarEnergia(100);
    Assert.assertFalse(o.habilidadRaza2(e));
  }
}
