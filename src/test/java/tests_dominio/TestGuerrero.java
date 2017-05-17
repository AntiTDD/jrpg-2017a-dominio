package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Guerrero;
import dominio.Hechicero;
import dominio.Humano;
import dominio.Orco;

public class TestGuerrero {

  @Test
  public void testDobleGolpe() {
    Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

    Assert.assertTrue(e.getSalud() == 100);
    if (h.habilidadCasta1(e))
        Assert.assertTrue(e.getSalud() < 100);
    else
        Assert.assertTrue(e.getSalud() == 100);
  }

  @Test
  public void testAutoDefensa() {
    Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);

    Assert.assertTrue(h.getDefensa() == 20);
    h.habilidadCasta2(null);
    Assert.assertTrue(h.getDefensa() == 65);
  }

  @Test
  public void testIgnoraDefensa() {
    Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

    Assert.assertTrue(e.getSalud() == 100);
    if (h.habilidadCasta3(e))
      Assert.assertTrue(e.getSalud() < 100);
    else
      Assert.assertTrue(e.getSalud() == 100);
  }

  @Test
  public void queUnGuerreroNoPuedaEjecutarSuHabilidad1PorNoTenerEnergia() {
    Elfo e = new Elfo("Legolas",new Guerrero(),1);
    Orco o = new Orco("Uruk-Hai",new Hechicero(),1);
    e.descensoDeEnergiaPorInicioDeAtaqueDeCasta(0); // Estaba e.setEnergia(0) //
    Assert.assertFalse(e.habilidadCasta1(o));
  }


  @Test
  public void queUnGuerreroNoPuedaEjecutarSuHabilidad2PorNoTenerEnergia() {
    Elfo e = new Elfo("Legolas",new Guerrero(),1);
    Orco o = new Orco("Uruk-Hai",new Hechicero(),1);
    e.descensoDeEnergiaPorInicioDeAtaqueDeCasta(0); // Estaba e.setEnergia(0) //
    Assert.assertFalse(e.habilidadCasta2(o));
  }


  @Test
  public void queUnGuerreroNoPuedaEjecutarSuHabilidad3PorNoTenerEnergia() {
    Elfo e = new Elfo("Legolas",new Guerrero(),1);
    Orco o = new Orco("Uruk-Hai",new Hechicero(),1);
    e.descensoDeEnergiaPorInicioDeAtaqueDeCasta(0); // Estaba e.setEnergia(0) //
    Assert.assertFalse(e.habilidadCasta3(o));
  }
}
