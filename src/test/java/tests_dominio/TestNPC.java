package tests_dominio;

import dominio.Guerrero;
import dominio.NonPlayableCharacter;
import dominio.Orco;
import org.junit.Assert;
import org.junit.Test;

public class TestNPC {

  @Test
  public void testOtorgarExp() {
    NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, -1);
    Assert.assertTrue(30 == npc.otorgarExp());
  }


  @Test
  public void queAlInstanciarUnNpcesteSeaDeDificultad1() {
    NonPlayableCharacter npc = new NonPlayableCharacter("Elrond",95,1);
    Assert.assertEquals(584, npc.getFuerza());
    Assert.assertEquals(1920, npc.getSalud());
    Assert.assertEquals(193, npc.getDefensa());
  }

  @Test
  public void setearLaFuerzaEn80000() {
    NonPlayableCharacter npc = new NonPlayableCharacter("Elrond",95,1);
    npc.setFuerza(80000);
    Assert.assertEquals(80000, npc.getFuerza());
  }

  @Test
  public void setearNombreYObtenerNombre() {
    NonPlayableCharacter npc = new NonPlayableCharacter("Elrond",95,1);
    npc.setNombre("Arwen");
    Assert.assertEquals("Arwen", npc.getNombre());
  }

  @Test
  public void setearNivelYObtenerNivel() {
    NonPlayableCharacter npc = new NonPlayableCharacter("Elrond",95,1);
    npc.setNivel(100);
    Assert.assertEquals(100, npc.getNivel());
  }


  @Test
  public void setearDefensaYObtenerDefensa() {
    NonPlayableCharacter npc = new NonPlayableCharacter("Elrond",95,1);
    npc.setDefensa(1000000);
    Assert.assertEquals(1000000,npc.getDefensa());
  }

  // Aca estaba el metodo setearSaludYObtenerSalud. Como ya no hay setSalud, lo borre. //

  @Test
  public void queElNPCConAtaque584AtaqueAOrcoConDefensa10YSalud110() {
    NonPlayableCharacter npc = new NonPlayableCharacter("Elrond",95,1);
    Orco o = new Orco("Uruk-Hai",new Guerrero(),1);
    Assert.assertEquals(110, npc.atacar(o));
  }
  
  @Test
  public void queUnNpcConSalud40YDefensa5seaAtacadoPorUnOrcoConGolpeCriticoDe33Ataque() {
    Orco o = new Orco("Uruk-Hai",new Guerrero(0.9,0.9,1.5),1);
    NonPlayableCharacter npc = new NonPlayableCharacter("Elrond recien nacido",1,1);
    Assert.assertEquals(31, o.atacar(npc));
  }


  @Test
  public void queUnNpcGrosoSeaAtacadoPorUnOrcoMuyPeteYLeQuite0DeSalud() {
    Orco o = new Orco("Uruk-Hai",new Guerrero(),1);
    NonPlayableCharacter npc = new NonPlayableCharacter("Elrond recien nacido",95,1);
    Assert.assertEquals(0, o.atacar(npc));
  }

  @Test
  public void testChoreoPorqueNoHayImplementacionEnElMetodo() {
    new NonPlayableCharacter("Elrond",1,1).despuesDeTurno();
  }

  @Test
  public void otroTestChoreoPorqueNoHayImplementacionEnElMetodo() {
    new NonPlayableCharacter("Elrond",1,1).ganarExperiencia(10);
  }
  
  @Test
  public void setearAtaqueDeNpc() {
    NonPlayableCharacter npc = new NonPlayableCharacter("Elrond recien nacido",95,1);
    npc.setAtaque(100000);
    Assert.assertEquals(100000, npc.getAtaque());
  }
}
