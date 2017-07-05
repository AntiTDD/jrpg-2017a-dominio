package tests_dominio;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Guerrero;
import dominio.Hechicero;
import dominio.Humano;
import dominio.MyRandomStub;
import dominio.Orco;
import org.junit.Assert;
import org.junit.Test;

/**
 * The Class TestAsesino.
 * sirve para testear distintos atributos
 * del Asesino
 */
public class TestAsesino {

    /** atributos para que no aparezca el error.
    * de checkstyle "numero X es magico"*/
	private final int cien = 100,
                      cientocinco = 105,
                      noventaytres = 93,
                      veinticinco = 25,
                      veinte = 20,
                      treinta = 30;

    /** idem anteriores pero con floats. */
	private final float ceroPuntoTres = 0.3f,
			            unoPuntoCinco = 0.5f,
			            ceroPuntoDos = 0.2f,
			            ceroPunto45 = 0.45f,
			            ceroPuntoCinco = 0.5f,
			            ceroPunto01 = 0.01f;

	/**
	 * Test robar.
	 */
	@Test
	public void testRobar() {
	}

	/**
	 * Test critico.
	 */
	@Test
	public void testCritico() {
		Humano h = new Humano("Nicolas", new Asesino(), 1);
		Humano h2 = new Humano("Lautaro", new Hechicero(), 2);
		h.setTipoDeRandom(new MyRandomStub(1));
		h2.setTipoDeRandom(new MyRandomStub(1));

		Assert.assertEquals(cientocinco, h2.getSalud());
		h.habilidadCasta1(h2);
		Assert.assertTrue(noventaytres == h2.getSalud());
	}

	/**
	 * Test prob evasion.
	 */
	@Test
	public void testProbEvasion() {
		Humano h = new Humano("Nico", cien, cien,
                             veinticinco, veinte, treinta,
                             new Asesino(ceroPuntoDos, ceroPuntoTres,
                            		 unoPuntoCinco), 0, 1, 1);

		Assert.assertTrue(ceroPuntoTres
				== h.getCasta().getProbabilidadEvitarDaño());
		h.habilidadCasta2(null);
		Assert.assertEquals(ceroPunto45,
				h.getCasta().getProbabilidadEvitarDaño(),
				             ceroPunto01);
		h.habilidadCasta2(null);
		Assert.assertTrue(ceroPuntoCinco
				== h.getCasta().getProbabilidadEvitarDaño());
	}

	/**
	 * Que un asesino no pueda efectuar su habilidad 1 por no tener energia.
	 */
	@Test
	public void queUnAsesinoNoPuedaEfectuarSuHabilidad1PorNoTenerEnergia() {
		Elfo e = new Elfo("Legolas", new Asesino(), 1);
		Orco o = new Orco("Uruk-Hai", new Guerrero(), 1);
		e.bajarEnergia(cien); // Estaba e.setEnergia(0) //
		Assert.assertFalse(e.habilidadCasta1(o));
	}

	/**
	 * Que un asesino no pueda efectuar su habilidad 2 por no tener energia.
	 */
	@Test
	public void queUnAsesinoNoPuedaEfectuarSuHabilidad2PorNoTenerEnergia() {
		Elfo e = new Elfo("Legolas", new Asesino(), 1);
		Orco o = new Orco("Uruk-Hai", new Guerrero(), 1);
		e.bajarEnergia(cien); // Estaba e.setEnergia(0) //
		Assert.assertFalse(e.habilidadCasta2(o));
	}

	/**
	 * Test habilidad 3.
	 */
	@Test
	public void testHabilidad3() {
		Elfo e = new Elfo("Frodo Bolson", new Asesino(), 1);
		Assert.assertFalse(new Asesino().habilidad3(e, e));
	}
}
