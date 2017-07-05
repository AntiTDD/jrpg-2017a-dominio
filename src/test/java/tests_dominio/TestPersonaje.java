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



/**
 * The Class TestPersonaje.
 */
public class TestPersonaje {
       /** Se utilizan para evitar los problemas.
	    * del checkstyle "x es un numero magico" */
	   private final int cien = 100,
	               diez = 10,
	               quince = 15,
	               veinte = 20,
	               veintitres = 23,
	               tres = 3,
	               cuatro = 4,
	               cinco = 5,
	               cientoCinco = 105,
	               cientoDiez = 110,
	               doscientos = 200,
	               trescientos = 300,
	               setentaYNueve = 79,
	               diezmil = 10000,
	               noventaYSiete = 97,
	               noventaYTres = 93,
	               cuarenta = 40,
	               noventa = 90,
	               noventaYNueve = 99,
	               diezmillones = 10000000,
	               mil = 1000,
	               cienmillones = 100000000,
	               cuatroNoventa = 490,
	               cientoVeinte = 120,
	               quinientos = 500;


  /**
   * Test humano.
   */
  @Test
  public void testHumano() {
    Humano h = new Humano("Nicolas", new Guerrero(), 1);
    Assert.assertTrue(h.getSalud() == cientoCinco);
    Assert.assertTrue(h.getEnergia() == cientoCinco);
    Assert.assertTrue(h.getFuerza() == quince);
    Assert.assertTrue(h.getDestreza() == diez);
    Assert.assertTrue(h.getInteligencia() == diez);

    Humano h2 = new Humano("Lautaro", new Hechicero(), 2);
    Assert.assertTrue(h2.getSalud() == cientoCinco);
    Assert.assertTrue(h2.getEnergia() == cientoCinco);
    Assert.assertTrue(h2.getFuerza() == diez);
    Assert.assertTrue(h2.getDestreza() == diez);
    Assert.assertTrue(h2.getInteligencia() == quince);

    Humano h3 = new Humano("Hernan", new Asesino(), tres);
    Assert.assertTrue(h3.getSalud() == cientoCinco);
    Assert.assertTrue(h3.getEnergia() == cientoCinco);
    Assert.assertTrue(h3.getFuerza() == diez);
    Assert.assertTrue(h3.getDestreza() == quince);
    Assert.assertTrue(h3.getInteligencia() == diez);
  }

  /**
   * Test elfo.
   */
  @Test
  public void testElfo() {
    Elfo e = new Elfo("Nicolas", new Guerrero(), 1);
    Assert.assertTrue(e.getSalud() == cien);
    Assert.assertTrue(e.getFuerza() == quince);
    Assert.assertTrue(e.getDestreza() == diez);
    Assert.assertTrue(e.getInteligencia() == diez);

    Elfo e2 = new Elfo("Lautaro", new Hechicero(), 2);
    Assert.assertTrue(e2.getSalud() == cien);
    Assert.assertTrue(e2.getFuerza() == diez);
    Assert.assertTrue(e2.getDestreza() == diez);
    Assert.assertTrue(e2.getInteligencia() == quince);

    Elfo e3 = new Elfo("Hernan", new Asesino(), tres);
    Assert.assertTrue(e3.getSalud() == cien);
    Assert.assertTrue(e3.getFuerza() == diez);
    Assert.assertTrue(e3.getDestreza() == quince);
    Assert.assertTrue(e3.getInteligencia() == diez);
  }

  /**
   * Test orco.
   */
  @Test
  public void testOrco() {
    Orco o = new Orco("Nicolas", new Guerrero(), 1);
    Assert.assertTrue(o.getSalud() == cientoDiez);
    Assert.assertTrue(o.getEnergia() == cien);
    Assert.assertTrue(o.getFuerza() == quince);
    Assert.assertTrue(o.getDestreza() == diez);
    Assert.assertTrue(o.getInteligencia() == diez);

    Orco o2 = new Orco("Lautaro", new Hechicero(), 2);
    Assert.assertTrue(o2.getSalud() == cientoDiez);
    Assert.assertTrue(o2.getEnergia() == cien);
    Assert.assertTrue(o2.getFuerza() == diez);
    Assert.assertTrue(o2.getDestreza() == diez);
    Assert.assertTrue(o2.getInteligencia() == quince);

    Orco o3 = new Orco("Hernan", new Asesino(), tres);
    Assert.assertTrue(o3.getSalud() == cientoDiez);
    Assert.assertTrue(o3.getEnergia() == cien);
    Assert.assertTrue(o3.getFuerza() == diez);
    Assert.assertTrue(o3.getDestreza() == quince);
    Assert.assertTrue(o3.getInteligencia() == diez);
  }

  /**
   * Testeo gety set.
   */
  @Test
  public void testeoGetySet() {
    Elfo e = new Elfo("Secchik", new Asesino(), veintitres);

    e.setNombre("Lucas");
    e.setNombreRaza("Elfo Junior");
    e.setAtaque(cuarenta);
    e.subirEnergia(doscientos);
    e.setMagia(veinte);
    e.subirExperiencia(cientoDiez);
    e.subirSaludTope(veinte);
    e.subirEnergiaTope(diez);
    e.subirInteligencia(cuatroNoventa);

    Assert.assertTrue(e.getNombre() == "Lucas");
    Assert.assertTrue(e.getNombreRaza() == "Elfo Junior");
    Assert.assertTrue(e.getAtaque() == cuarenta);
    Assert.assertTrue(e.getSalud() == cien);
    Assert.assertTrue(e.getEnergia() == trescientos);
    Assert.assertTrue(e.getCasta().getNombreCasta() == "Asesino");
    Assert.assertTrue(e.getMagia() == veinte);
    Assert.assertTrue(e.getNivel() == 1);
    Assert.assertTrue(e.getExperiencia() == cientoDiez);
    Assert.assertTrue(e.getIdPersonaje() == veintitres);
    Assert.assertTrue(e.getSaludTope() == cientoVeinte);
    Assert.assertTrue(e.getEnergiaTope() == cientoDiez);
    Assert.assertTrue(e.getHabilidadesCasta()[0] == "Golpe Critico");
    Assert.assertTrue(e.getHabilidadesCasta()[1] == "Aumentar Evasion");
    Assert.assertTrue(e.getHabilidadesCasta()[2] == "Robar");
    Assert.assertTrue(e.getHabilidadesRaza()[0] == "Golpe Level");
    Assert.assertTrue(e.getHabilidadesRaza()[1] == "Ataque Bosque");

  }

  /**
   * Testeo restableces salud.
   */
  @Test
  public void testeoRestablecesSalud() {
    Elfo e = new Elfo("Secchik", new Asesino(), veintitres);
    Orco o = new Orco("Uruk-Hai", new Guerrero(), 1);
    e.setTipoDeRandom(new MyRandomStub(1));
    o.setTipoDeRandom(new MyRandomStub(1));

    o.atacar(e);
    Assert.assertTrue(e.getSalud() < e.getSaludTope());
    e.restablecerSalud();

    Assert.assertTrue(e.getSaludTope() == cien);
  }


  /**
   * Testeo puedo atacar.
   */
  @Test
  public void testeoPuedoAtacar() {
    Elfo e = new Elfo("Secchik", new Asesino(), veintitres);

    e.bajarEnergia(setentaYNueve);

    Assert.assertTrue(e.puedeAtacar() == true);

  }


  /**
   * Testeo no puedo atacar.
   */
  @Test
  public void testeoNoPuedoAtacar() {
    Elfo e = new Elfo("Secchik", new Asesino(), veintitres);

    e.bajarEnergia(cien);

    Assert.assertTrue(e.puedeAtacar() == false);

  }

  /**
   * Testeo esta vivo.
   */
  @Test
  public void testeoEstaVivo() {
    Elfo e = new Elfo("Secchik", new Asesino(), veintitres);
    Orco o = new Orco("Uruk-Hai", diezmil, diezmil,
                      diezmil, diezmil, diezmil, new Guerrero(),
                      diezmil, diezmil, 1);
    e.setTipoDeRandom(new MyRandomStub(1));
    o.setTipoDeRandom(new MyRandomStub(1));

    Assert.assertTrue(e.estaVivo());

    o.atacar(e);

    Assert.assertFalse(e.estaVivo());
  }

  /**
   * Testeo ser curado.
   */
  @Test
  public void testeoSerCurado() {
    Elfo e = new Elfo("Secchik", new Asesino(), veintitres);
    Orco o = new Orco("Uruk-Hai", new Guerrero(), 1);
    e.setTipoDeRandom(new MyRandomStub(1));
    o.setTipoDeRandom(new MyRandomStub(1));

    o.atacar(e);
    Assert.assertEquals(noventaYTres, e.getSalud());

    e.serCurado(cuatro);

    Assert.assertTrue(e.getSalud() == noventaYSiete);
  }

  /**
   * Testeo ser curado tope.
   */
  @Test
  public void testeoSerCuradoTope() {
    Elfo e = new Elfo("Secchik", new Asesino(), veintitres);
    Orco o = new Orco("Uruk-Hai", new Guerrero(), 1);
    e.setTipoDeRandom(new MyRandomStub(1));
    o.setTipoDeRandom(new MyRandomStub(1));

    o.atacar(e);
    Assert.assertEquals(noventaYTres, e.getSalud());

    e.serCurado(quinientos);

    Assert.assertTrue(e.getSalud() == cien);
  }

  /**
   * Testeo distancias.
   */
  @Test
  public void testeoDistancias() {
    Elfo e1 = new Elfo("Secchik", new Asesino(), veintitres);
    Elfo e2 = new Elfo("ElfoRand", new Asesino(), veintitres);

    Assert.assertTrue(e1.distanciaCon(e2) == 0);

  }

  /**
   * Testeo alianza.
   */
  @Test
  public void testeoAlianza() {
    Elfo e1 = new Elfo("Secchik", new Asesino(), veintitres);

    e1.crearAlianza("AntiTDD");

    Assert.assertTrue(e1.getClan().obtenerNombre() == "AntiTDD");

    e1.salirDeAlianza();

    Assert.assertTrue(e1.getClan() == null);

  }


  /**
   * Test defensa.
   */
  @Test
  public void testDefensa() {
    Elfo e = new Elfo("Secchik", new Asesino(), veintitres);
    e.subirDefensa(noventa);
    Assert.assertTrue(e.serAtacado(noventaYNueve) == 0);
    Assert.assertTrue(e.serRobadoSalud(noventaYNueve) == 0);
    Assert.assertTrue(e.serDesernegizado(noventaYNueve) == 0);
  }

  /**
   * Test robo de vida.
   */
  @Test
  public void testRoboDeVida() {
    Elfo e = new Elfo("Secchik", new Asesino(), veintitres);
    e.bajarDefensa(cinco);
    Assert.assertTrue(e.serRobadoSalud(cien) == noventa);
    Assert.assertTrue(e.getSalud() == diez);
  }

  /**
   * Test robo de energia.
   */
  @Test
  public void testRoboDeEnergia() {
    Elfo e = new Elfo("Secchik", new Asesino(), veintitres);
    e.bajarEnergia(noventa);
    Assert.assertTrue(e.serDesernegizado(cien) == diez);
    Assert.assertTrue(e.getEnergia() == 0);
  }

  /**
   * Test tener clan.
   */
  @Test
  public void testTenerClan() {
    Elfo e1 = new Elfo("Secchi", new Asesino(), 1);
    Elfo e2 = new Elfo("Mica", new Asesino(), 2);
    Elfo e3 = new Elfo("Kandangar", new Asesino(), tres);

    Assert.assertTrue(e2.aliar(e3) == true);
    Assert.assertTrue(e1.aliar(e2) == false);
  }

  /**
   * Test despues de turno.
   */
  @Test
  public void testDespuesDeTurno() {
    Elfo e1 = new Elfo("Secchi", new Asesino(), 1);
    e1.despuesDeTurno();
  }


  /**
   * Que un personaje con alta probabilidad de evitar el daño no pueda ser atacado.
   */
  @Test
  public void queUnPersonajeConAltaProbabilidadDeEvitarElDañoNoPuedaSerAtacado() {
    Elfo e1 = new Elfo("Secchi", new Asesino(), 1);
    Elfo e2 = new Elfo("La mole Moli", new Guerrero(mil, diezmillones, mil), 1);
    Assert.assertEquals(0, e1.atacar(e2));
  }


  /**
   * Que A un personaje se le llene la barrita de energia.
   */
  @Test
  public void queAUnPersonajeSeLeLleneLaBarritaDeEnergia() {
    Elfo e1 = new Elfo("Secchi", new Asesino(), 1);
    e1.bajarEnergia(e1.getEnergia() / 2);
    Assert.assertNotEquals(e1.getEnergiaTope(), e1.getEnergia());
    e1.serEnergizado(cienmillones);
    Assert.assertEquals(e1.getEnergiaTope(), e1.getEnergia());
  }


  /**
   * Que un personaje quede sin clan cuando pida salir.
   */
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
