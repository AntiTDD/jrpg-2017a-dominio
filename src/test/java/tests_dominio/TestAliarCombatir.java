package tests_dominio;

import dominio.*;
import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Test;


public class TestAliarCombatir {

  @Test
  public void testCrearAlianza() {
    Humano h = new Humano("Nicolas",new Guerrero(),1);
    Humano h2 = new Humano("Lautaro",new Guerrero(),1);

    Assert.assertNull(h.getClan());
    Assert.assertNull(h2.getClan());
    h.aliar(h2);
    Assert.assertNotNull(h.getClan());
    Assert.assertNotNull(h2.getClan());
  }

  @Test
  public void testDañar() {
    Humano h = new Humano("Nicolas",new Guerrero(),1);
    Humano h2 = new Humano("Lautaro",new Asesino(),1);

    Assert.assertTrue(h.atacar(h2) > 0);
  }

  @Test
  public void testAliar() {
    Humano h = new Humano("Nicolas",new Guerrero(),1);
    Humano h2 = new Humano("Lautaro",new Guerrero(),1);
    Alianza a1 = new Alianza("Los CacheFC");

    Assert.assertNull(h2.getClan());
    Assert.assertNull(h.getClan());
    h.setClan(a1);
    Assert.assertNotNull(h.getClan());
    h.aliar(h2);
    Assert.assertTrue(h.getClan() == h2.getClan());
  }

  @Test
  public void obtenerYEstablecerAliadosAUnClan() {

    Humano h = new Humano("Gandalf",new Hechicero(),1);
    Elfo e = new Elfo("Legolas",new Asesino(), 1);
    Orco o = new Orco("Uruk-Hai",new Guerrero(),1);

    h.crearAlianza("La comunidad del anillo");
    h.aliar(e);
    h.aliar(o);
    
    Assert.assertEquals("Gandalf",h.getClan().getAliados().get(0).getNombre());
    Assert.assertEquals("Legolas",h.getClan().getAliados().get(1).getNombre());
    Assert.assertEquals("Uruk-Hai",h.getClan().getAliados().get(2).getNombre());
    
    o.salirDeAlianza();
    LinkedList<Personaje> aliados1 = h.getClan().getAliados();
    h.getClan().setAliados(aliados1);
    Assert.assertNotNull(h.getClan());
    Assert.assertNotNull(e.getClan());
    Assert.assertNull(o.getClan());
  }

  @Test
  public void obtenerElNombreCorrectoDeUnaAlianza() {
    Alianza ali1 = new Alianza("La comunidad del anillo");
    Assert.assertEquals("La comunidad del anillo", ali1.obtenerNombre());
  }

  @Test
  public void eliminarDeUnClanAUnMiembro() {
    Humano h = new Humano("Gandalf",new Hechicero(),1);
    Elfo e = new Elfo("Legolas",new Asesino(),1);
    h.aliar(e);
    e.salirDeAlianza();
    Assert.assertNull(e.getClan());
  }

}
