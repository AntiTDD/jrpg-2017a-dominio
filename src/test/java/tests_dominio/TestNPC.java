package tests_dominio;

import dominio.Guerrero;
import dominio.MyRandomStub;
import dominio.NonPlayableCharacter;
import dominio.Orco;
import org.junit.Assert;
import org.junit.Test;

/**
 * The Class TestNPC.
 */
public class TestNPC {
  private final int noventaYCinco = 95,
                    cien = 100,
                    unMillon = 1000000,
                    cientoDiez = 110,
                    diez = 10,
                    treinta = 30,
                    cienmil = 100000,
                    veinte = 20;
  /** The cero punto dos. */
  private final float ceroPuntoNueve = 0.2f,
                      unoPuntoCinco = 1.5f;
  /**
   * Test otorgar exp.
   */
  @Test
  public void testOtorgarExp() {
    NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, -1);
    Assert.assertTrue(treinta == npc.otorgarExp());
  }


  /**
   * Que al instanciar un npceste sea de dificultad 1.
   */
  @Test
  public void queAlInstanciarUnNpcesteSeaDeDificultad1() {
    NonPlayableCharacter npc = new NonPlayableCharacter("Elrond", noventaYCinco, 1);
    Assert.assertEquals(584, npc.getFuerza());
    Assert.assertEquals(1920, npc.getSalud());
    Assert.assertEquals(193, npc.getDefensa());
  }

  /**
   * Setear la fuerza en 80000.
   */
  @Test
  public void setearLaFuerzaEn80000() {
    NonPlayableCharacter npc = new NonPlayableCharacter(
                               "Elrond", noventaYCinco, 1);
    npc.subirFuerza(79416);
    Assert.assertEquals(80000, npc.getFuerza());
  }

  /**
   * Setear nombre Y obtener nombre.
   */
  @Test
  public void setearNombreYObtenerNombre() {
    NonPlayableCharacter npc = new NonPlayableCharacter(
                               "Elrond", noventaYCinco, 1);
    npc.setNombre("Arwen");
    Assert.assertEquals("Arwen", npc.getNombre());
  }

  /**
   * Obtener nivel.
   */
  @Test
  public void obtenerNivel() {
    NonPlayableCharacter npc = new NonPlayableCharacter("Elrond", cien, 1);
    //npc.setNivel(cien);
    Assert.assertEquals(cien, npc.getNivel());
  }


  /**
   * Setear defensa Y obtener defensa.
   */
  @Test
  public void setearDefensaYObtenerDefensa() {
    NonPlayableCharacter npc = new NonPlayableCharacter(
                               "Elrond", noventaYCinco, 1);
    npc.subirDefensa(999807); // estaba habia un npc.setDefensa(100000);
    Assert.assertEquals(unMillon, npc.getDefensa());
  }

  // Aca estaba el metodo setearSaludYObtenerSalud.
  //Como ya no hay setSalud, lo borre. //

  /**
   * Que el NPC con ataque 584 ataque A orco con defensa 10 Y salud 110.
   */
  @Test
  public void queElNPCConAtaque584AtaqueAOrcoConDefensa10YSalud110() {
    NonPlayableCharacter npc = new NonPlayableCharacter(
                               "Elrond", noventaYCinco, 1);
    Orco o = new Orco("Uruk-Hai", new Guerrero(), 1);
    npc.setTipoDeRandom(new MyRandomStub(1));
    o.setTipoDeRandom(new MyRandomStub(1));

    Assert.assertEquals(cientoDiez, npc.atacar(o));
  }

  /**
   * Que un npc con salud 40 Y defensa 5 sea atacado por un orco con golpe critico de 33 ataque.
   */
  @Test
  public void queUnNpcConSalud40YDefensa5seaAtacadoPorUnOrcoConGolpeCriticoDe33Ataque() {
    Orco o = new Orco("Uruk-Hai", new Guerrero(ceroPuntoNueve, ceroPuntoNueve, unoPuntoCinco), 1);
    NonPlayableCharacter npc = new NonPlayableCharacter(
          "Elrond recien nacido", 1, 1);
    o.setTipoDeRandom(new MyRandomStub(1));
    npc.setTipoDeRandom(new MyRandomStub(1));

    Assert.assertEquals(veinte, o.atacar(npc));
  }


  /**
   * Que un npc groso sea atacado por un orco muy pete Y le quite 0 de salud.
   */
  @Test
  public void queUnNpcGrosoSeaAtacadoPorUnOrcoMuyPeteYLeQuite0DeSalud() {
    Orco o = new Orco("Uruk-Hai", new Guerrero(), 1);
    NonPlayableCharacter npc = new NonPlayableCharacter(
                                "Elrond recien nacido", noventaYCinco, 1);
    Assert.assertEquals(0, o.atacar(npc));
  }

  /**
   * Test choreo porque no hay implementacion en el metodo.
   */
  @Test
  public void testChoreoPorqueNoHayImplementacionEnElMetodo() {
    new NonPlayableCharacter("Elrond", 1, 1).despuesDeTurno();
  }

  /**
   * Otro test choreo porque no hay implementacion en el metodo.
   */
  @Test
  public void otroTestChoreoPorqueNoHayImplementacionEnElMetodo() {
    new NonPlayableCharacter("Elrond", 1, 1).ganarExperiencia(diez);
  }

  /**
   * Setear ataque de npc.
   */
  @Test
  public void setearAtaqueDeNpc() {
    NonPlayableCharacter npc = new NonPlayableCharacter(
                                    "Elrond recien nacido", noventaYCinco, 1);
    npc.setAtaque(cienmil);
    Assert.assertEquals(cienmil, npc.getAtaque());
  }
}
