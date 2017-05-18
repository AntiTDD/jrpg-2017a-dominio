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
    Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

    Assert.assertTrue(e.getSalud() == 100);
    h.setTipoDeRandom(new MyRandomStub(1)); // Lo uso porque si no capaz sale la probabilidad de critico. //
    e.setTipoDeRandom(new MyRandomStub(1)); // Lo uso porque si no capaz sale la probabilidad de esquivar el golpe. //
    h.atacar(e); // Como ya no existe el metodo setSalud, solo queda bajarle la vida a golpes. //
    Assert.assertEquals(38, e.getSalud());
    h.habilidadCasta2(e); // Lo curo. Habiendo hecho la cuenta, lo cura por 45. //
    Assert.assertEquals(83, e.getSalud());
  }

  @Test
  public void testBolaDeFuego() {
    Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

    Assert.assertTrue(e.getSalud() == 100);
    if (h.habilidadCasta1(e))
      Assert.assertTrue(e.getSalud() < 100);
    else
      Assert.assertTrue(e.getSalud() == 100);
  }


  @Test
  public void testRobarEnergia_y_Salud() {
    Humano h = new Humano("Nico", 100, 100, 55, 20, 50, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
    h.setTipoDeRandom(new MyRandomStub(1)); // Lo uso porque si no capaz sale la probabilidad de critico. //
    e.setTipoDeRandom(new MyRandomStub(1)); // Lo uso porque si no capaz sale la probabilidad de esquivar el golpe. //

    Assert.assertTrue(e.getSalud() == 100);
    //h.setSalud(50);
    e.atacar(h);
    e.atacar(h); // Al poner 2 ataques, la salud de "h" baja mas que lo que despues se va a curar. //
    h.bajarEnergia(60); // Estaba e.setEnergia(50) //
    
    Assert.assertEquals(40, h.getEnergia());
    Assert.assertEquals(66, h.getSalud());
    
    h.habilidadCasta3(e);
    
    Assert.assertEquals(85, h.getEnergia());
    Assert.assertEquals(83, h.getSalud());
  }

  @Test
  public void queUnHechiceroNoPuedaEjecutarSuHabilidad1PorNoTenerEnergia() {
    Elfo e = new Elfo("Legolas",new Hechicero(),1);
    Orco o = new Orco("Uruk-Hai",new Asesino(),1);
    e.bajarEnergia(100); // Estaba e.setEnergia(0) //
    Assert.assertFalse(e.habilidadCasta1(o));
  }

  @Test
  public void queUnHechiceroNoPuedaEjecutarSuHabilidad2PorNoTenerEnergia() {
    Elfo e = new Elfo("Legolas",new Hechicero(),1);
    Orco o = new Orco("Uruk-Hai",new Asesino(),1);
    e.bajarEnergia(100); // Estaba e.setEnergia(0) //
    Assert.assertFalse(e.habilidadCasta2(o));
  }

  @Test
  public void queUnHechiceroNoPuedaEjecutarSuHabilidad3PorNoTenerEnergia() {
    Elfo e = new Elfo("Legolas",new Hechicero(),1);
    Orco o = new Orco("Uruk-Hai",new Asesino(),1);
    e.bajarEnergia(100); // Estaba e.setEnergia(0) //
    Assert.assertFalse(e.habilidadCasta3(o));
  }
}
