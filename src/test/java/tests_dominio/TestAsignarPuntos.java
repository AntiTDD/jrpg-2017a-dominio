package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Guerrero;
import dominio.Humano;
import dominio.Personaje;

/**
 * The Class TestAsignarPuntos.
 * para testear la asignacion de puntos a
 * distintos personajes
 */
public class TestAsignarPuntos {

    /**  atributos para que no aparezca
    *  el error.
   * de checkstyle "numero X es magico */
	private final int cientocinco = 105,
                      cincuenta = 50,
                      ciento30 = 130,
                      ciento99 = 199,
                      diez = 10,
                      ciento25 = 125;

	/**
	 * Test aumentar salud_tope.
	 */
	@Test
	public void testAumentarSaludTope() {
		Personaje.cargarTablaNivel();

		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertTrue(h.getSaludTope() == cientocinco);
		h.ganarExperiencia(cincuenta);
		Assert.assertTrue(h.getSaludTope() == ciento30);
	}

	/**
	 * Test aumentar energia tope.
	 */
	@Test
	public void testAumentarEnergiaTope() {
		Personaje.cargarTablaNivel();

		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertTrue(h.getEnergiaTope() == cientocinco);
		h.ganarExperiencia(cincuenta);
		Assert.assertTrue(h.getEnergiaTope() == ciento25);
	}

	/**
	 * Test mas de 200 puntos.
	 */
	@Test
	public void testMasDe200Puntos() {
		Humano h = new Humano("Nicolas", diez,
                              diez, ciento99, ciento99, ciento99,
                              new Guerrero(), diez, diez, 1);
		h.AsignarPuntosSkills(2, 2, 2);
		Assert.assertTrue(h.getFuerza() == ciento99);
		Assert.assertTrue(h.getDestreza() == ciento99);
		Assert.assertTrue(h.getInteligencia() == ciento99);
	}
}
