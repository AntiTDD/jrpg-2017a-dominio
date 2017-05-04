package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.*;

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
		Assert.assertTrue(e.getEnergia() == 110);
		Assert.assertTrue(e.getFuerza() == 15);
		Assert.assertTrue(e.getDestreza() == 10);
		Assert.assertTrue(e.getInteligencia() == 10);

		Elfo e2 = new Elfo("Lautaro", new Hechicero(), 2);
		Assert.assertTrue(e2.getSalud() == 100);
		Assert.assertTrue(e2.getEnergia() == 110);
		Assert.assertTrue(e2.getFuerza() == 10);
		Assert.assertTrue(e2.getDestreza() == 10);
		Assert.assertTrue(e2.getInteligencia() == 15);

		Elfo e3 = new Elfo("Hernan", new Asesino(), 3);
		Assert.assertTrue(e3.getSalud() == 100);
		Assert.assertTrue(e3.getEnergia() == 110);
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
	public void testeoGetySet(){
		Elfo e = new Elfo("Secchik",new Asesino(),23);
		Hechicero h = new Hechicero();
		
		e.setNombre("Lucas");
		e.setNombreRaza("Elfo Junior");
		e.setAtaque(40);
		e.setSalud(100);
		e.setEnergia(300);
		e.setCasta(h);
		e.setMagia(20);
		e.setNivel(99);
		e.setExperiencia(110);
		e.setIdPersonaje(24);
		e.setSaludTope(120);
		e.setEnergiaTope(120);
		e.setDestreza(42);
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
	public void testeoRestablecesSalud(){
		Elfo e = new Elfo("Secchik",new Asesino(),23);
		
		e.setSalud( 40);
		
		e.restablecerSalud();
		
		Assert.assertTrue(e.getSaludTope() == 100);
	}
	
	@Test
	public void testeoRestablecesEnergia(){
		Elfo e = new Elfo("Secchik",new Asesino(),23);
		
		e.setSalud( 40);
		
		e.restablecerEnergia();
		
		Assert.assertTrue(e.getEnergiaTope() == 110);
	}
	
	
}
