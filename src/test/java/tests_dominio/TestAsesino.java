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

public class TestAsesino {

	@Test
	public void testRobar() {
	}

	@Test
	public void testCritico() {
		Humano h = new Humano("Nicolas", new Asesino(), 1);
		Humano h2 = new Humano("Lautaro", new Hechicero(), 2);
		h.setTipoDeRandom(new MyRandomStub(1));
		h2.setTipoDeRandom(new MyRandomStub(1));

		Assert.assertEquals(105, h2.getSalud());
		h.habilidadCasta1(h2);
		Assert.assertTrue(93 == h2.getSalud());
	}

	/**
	 * Test prob evasion.
	 */
	@Test
	public void testProbEvasion() {
		Humano h = new Humano("Nico", 100, 100,
                             25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);

		Assert.assertTrue(0.3 ==
				h.getCasta().getProbabilidadEvitarDaño());
		h.habilidadCasta2(null);
		Assert.assertEquals(0.45,
				h.getCasta().getProbabilidadEvitarDaño(), 0.01);
		h.habilidadCasta2(null);
		Assert.assertTrue(0.5 ==
				h.getCasta().getProbabilidadEvitarDaño());
	}

	@Test
	public void queUnAsesinoNoPuedaEfectuarSuHabilidad1PorNoTenerEnergia() {
		Elfo e = new Elfo("Legolas", new Asesino(), 1);
		Orco o = new Orco("Uruk-Hai", new Guerrero(), 1);
		e.bajarEnergia(100); // Estaba e.setEnergia(0) //
		Assert.assertFalse(e.habilidadCasta1(o));
	}

	@Test
	public void queUnAsesinoNoPuedaEfectuarSuHabilidad2PorNoTenerEnergia() {
		Elfo e = new Elfo("Legolas", new Asesino(), 1);
		Orco o = new Orco("Uruk-Hai", new Guerrero(), 1);
		e.bajarEnergia(100); // Estaba e.setEnergia(0) //
		Assert.assertFalse(e.habilidadCasta2(o));
	}

	@Test
	public void testHabilidad3() {
		Elfo e = new Elfo("Frodo Bolson", new Asesino(), 1);
		Assert.assertFalse(new Asesino().habilidad3(e, e));
	}
}
