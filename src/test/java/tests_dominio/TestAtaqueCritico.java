package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.*;

/**
 * The Class TestAtaqueCritico.
 */
public class TestAtaqueCritico {

	/** Por el tema del numero magico del.
	 * chekstyle */
	private final float unoPuntoCinco = 1.5f;

	/**
	 * Testgolpe crit.
	 */
	@Test
	public void testgolpeCrit() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertEquals(h.getAtaque() * unoPuntoCinco,
				h.golpe_critico(), 1);
	}
}
