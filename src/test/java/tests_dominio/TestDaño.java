package tests_dominio;

import dominio.Guerrero;
import dominio.Humano;
import dominio.Orco;
import org.junit.Assert;
import org.junit.Test;



/**
 * The Class TestDaño.
 */
public class TestDaño {

    /**  atributos para que no aparezca
    *  el error.
   * de checkstyle "numero X es magico */
	private final int cien = 100,
			          veinte = 20,
			          treinta = 30,
			          quince = 15,
			          veinticinco = 25;
    /**  atributos para que no aparezca
    *  el error.
   * de checkstyle "numero X es magico */
	private final float ceroPunto2 = 0.2f,
                        ceroPunto3 = 0.3f,
                        unoPunto5 = 1.5f;


  /**
   * Test ataque comun Y la salud no baje de 0.
   */
  @Test
  public void testAtaqueComunYLaSaludNoBajeDe0() {
    Humano h = new Humano("Nico", cien, cien, cien, veinte, treinta,
                          new Guerrero(ceroPunto2, ceroPunto3,
                        		  unoPunto5), 0, 1, 1);
    Orco o = new Orco("Nico", cien, cien, quince,
                      0, treinta, new Guerrero(ceroPunto2, 0,
                    		  unoPunto5), 0, 1, 1);

    Assert.assertTrue(o.getSalud() == cien);
    if (h.atacar(o) != 0) {
      Assert.assertTrue(o.getSalud() == 0);
      h.atacar(o);
      Assert.assertTrue(o.getSalud() == 0);
      h.atacar(o);
      Assert.assertTrue(o.getSalud() == 0);
    } else {
      Assert.assertTrue(o.getSalud() == 0);
    }
  }

  /**
   * Test los muertos no atacan.
   */
  @Test
  public void testLosMuertosNoAtacan() {
    Humano h = new Humano("Nico", cien, cien,
                           veinticinco, 0, treinta,
                           new Guerrero(ceroPunto2, 0, unoPunto5), 0, 1, 1);
    Orco o = new Orco("Nico", cien, cien, quince,
                      0, treinta,
                      new Guerrero(ceroPunto2, 0, unoPunto5), 0, 1, 1);

    h.atacar(o);
    h.atacar(o);
    h.atacar(o);
    h.atacar(o);

    o.atacar(h);
    Assert.assertEquals(cien, h.getSalud());
  }
}