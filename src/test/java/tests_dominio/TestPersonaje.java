package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Guerrero;
import dominio.Hechicero;
import dominio.Humano;
import dominio.MyRandomStub;
import dominio.Orco;



public class TestPersonaje {

  @Test
  public void testHumano() {
    Humano h = new Humano("Nicolas", new Guerrero(), 1);
    Assert.assertTrue(h.getSalud() == 105);
    Assert.assertTrue(h.getEnergia() == 105);
    Assert.assertTrue(h.getFuerza() == 15);
    Assert.assertTrue(h.getDestreza() == 10);
    Assert.assertTrue(h.getInteligencia() == 10);

    Humano h2 = new Humano("Lautaro", new Hechicero(), 2);
    Assert.assertTrue(h2.getSalud() == 105);
    Assert.assertTrue(h2.getEnergia() == 105);
    Assert.assertTrue(h2.getFuerza() == 10);
    Assert.assertTrue(h2.getDestreza() == 10);
    Assert.assertTrue(h2.getInteligencia() == 15);

    Humano h3 = new Humano("Hernan", new Asesino(), 3);
    Assert.assertTrue(h3.getSalud() == 105);
    Assert.assertTrue(h3.getEnergia() == 105);
    Assert.assertTrue(h3.getFuerza() == 10);
    Assert.assertTrue(h3.getDestreza() == 15);
    Assert.assertTrue(h3.getInteligencia() == 10);
  }

  @Test
  public void testElfo() {
    Elfo e = new Elfo("Nicolas", new Guerrero(), 1);
    Assert.assertTrue(e.getSalud() == 100);
    Assert.assertTrue(e.getFuerza() == 15);
    Assert.assertTrue(e.getDestreza() == 10);
    Assert.assertTrue(e.getInteligencia() == 10);

    Elfo e2 = new Elfo("Lautaro", new Hechicero(), 2);
    Assert.assertTrue(e2.getSalud() == 100);
    Assert.assertTrue(e2.getFuerza() == 10);
    Assert.assertTrue(e2.getDestreza() == 10);
    Assert.assertTrue(e2.getInteligencia() == 15);

    Elfo e3 = new Elfo("Hernan", new Asesino(), 3);
    Assert.assertTrue(e3.getSalud() == 100);
    Assert.assertTrue(e3.getFuerza() == 10);
    Assert.assertTrue(e3.getDestreza() == 15);
    Assert.assertTrue(e3.getInteligencia() == 10);
  }

  @Test
  public void testOrco() {
    Orco o = new Orco("Nicolas", new Guerrero(), 1);
    Assert.assertTrue(o.getSalud() == 110);
    Assert.assertTrue(o.getEnergia() == 100);
    Assert.assertTrue(o.getFuerza() == 15);
    Assert.assertTrue(o.getDestreza() == 10);
    Assert.assertTrue(o.getInteligencia() == 10);
    
    Orco o2 = new Orco("Lautaro", new Hechicero(), 2);
    Assert.assertTrue(o2.getSalud() == 110);
    Assert.assertTrue(o2.getEnergia() == 100);
    Assert.assertTrue(o2.getFuerza() == 10);
    Assert.assertTrue(o2.getDestreza() == 10);
    Assert.assertTrue(o2.getInteligencia() == 15);

    Orco o3 = new Orco("Hernan", new Asesino(), 3);
    Assert.assertTrue(o3.getSalud() == 110);
    Assert.assertTrue(o3.getEnergia() == 100);
    Assert.assertTrue(o3.getFuerza() == 10);
    Assert.assertTrue(o3.getDestreza() == 15);
    Assert.assertTrue(o3.getInteligencia() == 10);
  }
  
  @Test
  public void testeoGetySet() {
    Elfo e = new Elfo("Secchik",new Asesino(),23);
    Hechicero h = new Hechicero();

    e.setNombre("Lucas");
    e.setNombreRaza("Elfo Junior");
    e.setAtaque(40);
    //e.setSalud(100);
    e.descensoDeEnergiaPorInicioDeAtaqueDeCasta(300); // Estaba e.setEnergia(300) //
    e.setCasta(h);
    e.setMagia(20);
    e.setNivel(99);
    e.setExperiencia(110);
    e.setIdPersonaje(24);
    e.setSaludTope(120);
    e.setEnergiaTope(120);
    //e.setDestreza(42);
    e.setInteligencia(500);

    Assert.assertTrue(e.getNombre() == "Lucas");
    Assert.assertTrue(e.getNombreRaza() == "Elfo Junior");
    Assert.assertTrue(e.getAtaque() == 40);
    Assert.assertTrue(e.getSalud() == 100);
    Assert.assertTrue(e.getEnergia() == 300);
    Assert.assertTrue(e.getCasta() == h);
    Assert.assertTrue(e.getMagia() == 20);
    Assert.assertTrue(e.getNivel() == 99);
    Assert.assertTrue(e.getExperiencia() == 110);
    Assert.assertTrue(e.getIdPersonaje() == 24);
    Assert.assertTrue(e.getSaludTope() == 120);
    Assert.assertTrue(e.getEnergiaTope() == 120);
    Assert.assertTrue(e.getHabilidadesCasta()[0] == "Bola de Fuego");
    Assert.assertTrue(e.getHabilidadesCasta()[1] == "Curar Aliado");
    Assert.assertTrue(e.getHabilidadesCasta()[2] == "Robar Energia y Salud");
    Assert.assertTrue(e.getHabilidadesRaza()[0] == "Golpe Level");
    Assert.assertTrue(e.getHabilidadesRaza()[1] == "Ataque Bosque");

  }

  @Test
  public void testeoRestablecesSalud() {
    Elfo e = new Elfo("Secchik",new Asesino(),23);
    Orco o = new Orco("Uruk-Hai",new Guerrero(),1);

    //e.setSalud(40);
    o.atacar(e);
    Assert.assertTrue(e.getSalud() < e.getSaludTope());
    e.restablecerSalud();

    Assert.assertTrue(e.getSaludTope() == 100);
  }


  @Test
  public void testeoPuedoAtacar() { 
    Elfo e = new Elfo("Secchik",new Asesino(),23);

    e.descensoDeEnergiaPorInicioDeAtaqueDeCasta(11); // Estaba e.setEnergia(11) //

    Assert.assertTrue(e.puedeAtacar() == true);

  }


  @Test
  public void testeoNoPuedoAtacar() { 
    Elfo e = new Elfo("Secchik",new Asesino(),23);

    e.descensoDeEnergiaPorInicioDeAtaqueDeCasta(0); // Estaba e.setEnergia(0) //

    Assert.assertTrue(e.puedeAtacar() == false);

  }

  @Test
  public void testeoEstaVivo() { 
    Elfo e = new Elfo("Secchik",new Asesino(),23);
    Orco o = new Orco("Uruk-Hai",10000,10000,10000,10000,10000,new Guerrero(),10000,10000,1);
    e.setTipoDeRandom(new MyRandomStub(1));
    o.setTipoDeRandom(new MyRandomStub(1));
    
    Assert.assertTrue(e.estaVivo());
    
    o.atacar(e);
    
    Assert.assertFalse(e.estaVivo());
  }
  
  @Test
  public void testeoSerCurado() {
    Elfo e = new Elfo("Secchik",new Asesino(),23);
    Orco o = new Orco("Uruk-Hai",new Guerrero(),1);
    e.setTipoDeRandom(new MyRandomStub(1));
    o.setTipoDeRandom(new MyRandomStub(1));

    //e.setSalud(20);
    o.atacar(e);
    Assert.assertEquals(93, e.getSalud());
    
    e.serCurado(4);

    Assert.assertTrue(e.getSalud() == 97);
  }

  @Test
  public void testeoSerCuradoTope() {
	 
    Elfo e = new Elfo("Secchik",new Asesino(),23);
	Orco o = new Orco("Uruk-Hai",new Guerrero(),1);
    e.setTipoDeRandom(new MyRandomStub(1));
    o.setTipoDeRandom(new MyRandomStub(1));

    o.atacar(e);
    Assert.assertEquals(93, e.getSalud());
    
    e.serCurado(500);

    Assert.assertTrue(e.getSalud() == 100);
  }

  @Test
  public void testeoDistancias() { 
    Elfo e1 = new Elfo("Secchik",new Asesino(),23);
    Elfo e2 = new Elfo("ElfoRand",new Asesino(),23);

    Assert.assertTrue(e1.distanciaCon(e2) == 0);

  }

  @Test
  public void testeoAlianza() { 
    Elfo e1 = new Elfo("Secchik",new Asesino(),23);

    e1.crearAlianza("AntiTDD");

    Assert.assertTrue(e1.getClan().obtenerNombre() == "AntiTDD");

    e1.salirDeAlianza();

    Assert.assertTrue(e1.getClan() == null);

  }


  @Test
  public void testDefensa() {
    Elfo e = new Elfo("Secchik", new Asesino(), 23);
    e.setDefensa(100);
    Assert.assertTrue(e.serAtacado(99) == 0);
    Assert.assertTrue(e.serRobadoSalud(99) == 0);
    Assert.assertTrue(e.serDesernegizado(99) == 0);
  }
  
  @Test
  public void testRoboDeVida() {
    Elfo e = new Elfo("Secchik", new Asesino(), 23);
    //e.setSalud(10);
    e.setDefensa(10);
    Assert.assertTrue(e.serRobadoSalud(100) == 90);
    Assert.assertTrue(e.getSalud() == 10);
  }

  @Test
  public void testRoboDeEnergia() {
    Elfo e = new Elfo("Secchik", new Asesino(), 23);
    e.descensoDeEnergiaPorInicioDeAtaqueDeCasta(10); // Estaba e.setEnergia(10) //
    e.setDefensa(10);
    Assert.assertTrue(e.serDesernegizado(100) == 10);
    Assert.assertTrue(e.getEnergia() == 0);
  }

  @Test
  public void testTenerClan() {
    Elfo e1 = new Elfo("Secchi", new Asesino(), 1);
    Elfo e2 = new Elfo("Mica", new Asesino(), 2);
    Elfo e3 = new Elfo("Kandangar", new Asesino(), 3);

    Assert.assertTrue(e2.aliar(e3) == true);
    Assert.assertTrue(e1.aliar(e2) == false);
  }

  @Test
  public void testDespuesDeTurno() {
    Elfo e1 = new Elfo("Secchi", new Asesino(), 1);
    e1.despuesDeTurno();
  }


  @Test
  public void queUnPersonajeConAltaProbabilidadDeEvitarElDañoNoPuedaSerAtacado() {
    Elfo e1 = new Elfo("Secchi", new Asesino(), 1);
    Elfo e2 = new Elfo("La mole Moli",new Guerrero(1000,10000000,1000),1);
    Assert.assertEquals(0, e1.atacar(e2));
  }


  @Test
  public void queAUnPersonajeSeLeLleneLaBarritaDeEnergia() {
    Elfo e1 = new Elfo("Secchi", new Asesino(), 1);
    e1.descensoDeEnergiaPorInicioDeAtaqueDeCasta(e1.getEnergia() / 2); // Estaba e1.setEnergia(e1.getEnergia() / 2) //
    Assert.assertNotEquals(e1.getEnergiaTope(), e1.getEnergia());
    e1.serEnergizado(100000000);
    Assert.assertEquals(e1.getEnergiaTope(), e1.getEnergia());
  }


  @Test
  public void queUnPersonajeQuedeSinClanCuandoPidaSalir() {
    Elfo e1 = new Elfo("Secchi", new Asesino(), 1);
    Elfo e2 = new Elfo("Mica", new Asesino(), 2);
    e1.crearAlianza("Eapepe");
    e1.aliar(e2);
    Assert.assertNotNull(e1.getClan());
    Assert.assertNotNull(e2.getClan());
    e2.salirDeAlianza();
    Assert.assertNull(e2.getClan());
  }
}
