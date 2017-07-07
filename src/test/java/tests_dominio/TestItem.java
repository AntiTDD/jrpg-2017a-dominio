package tests_dominio;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

import dominio.Item;

public class TestItem {
	
	@Test
	public void testGettersYConstructores()
	{
		Item valhalla = new Item();
		Assert.assertEquals(0, valhalla.getId());
		Assert.assertEquals(0, (int)valhalla.getUbicEnElCuerpo());
		
		int id = 1;
		Integer ubicEnElCuerpo = 10;
		HashMap<String,Integer> bonus = new HashMap<String,Integer>();
		bonus.put("salud", 100);
		
		Item yggdrasill = new Item(id, bonus, ubicEnElCuerpo);
		Assert.assertEquals(1,  yggdrasill.getId());
		Assert.assertEquals(10,  (int)yggdrasill.getUbicEnElCuerpo());
		Assert.assertEquals(100, (int)yggdrasill.getBonus().get("salud"));
		
		Item otro = new Item(id, ubicEnElCuerpo);		
	}
	
	
	@Test
	public void testDeSetters()
	{
		Item valhalla = new Item();
		valhalla.setId(100);
		HashMap<String,Integer> bonus = new HashMap<String,Integer>();
		bonus.put("salud", 100);
		valhalla.setBonus(bonus);
		Assert.assertEquals(100, valhalla.getId());
		Assert.assertEquals(100, (int)valhalla.getBonus().get("salud"));
	}
	
	
	@Test
	public void testAgregarUnBonus()
	{
		Item valhalla = new Item();
		valhalla.agregarBonus("ataque", 100000);
		Assert.assertEquals(100000, (int)valhalla.getBonus().get("ataque"));
	}
	
	
	@Test
	public void testAgregarMasDeUnBonus()
	{
		Item valhalla = new Item();
		HashMap<String, Integer> bonus = new HashMap<String, Integer>();
		bonus.put("salud", 100000);
		bonus.put("ataque", 100000);
		valhalla.agregarBonus(bonus);
		Assert.assertEquals(100000, (int)valhalla.getBonus().get("salud"));
		Assert.assertEquals(100000, (int)valhalla.getBonus().get("ataque"));
	}
	
	
	@Test
	public void testModificarBonus()
	{
		Item valhalla = new Item();
		valhalla.agregarBonus("ataque", 100000);
		valhalla.modificarBonus("ataque", 10000000);
		Assert.assertEquals(10000000, (int)valhalla.getBonus().get("ataque"));
	}
	
	
	@Test
	public void testExisteAtributo()
	{
		Item valhalla = new Item();
		valhalla.agregarBonus("ataque", 100000);
		Assert.assertTrue(valhalla.existeAtributo("ataque"));
	}
}
