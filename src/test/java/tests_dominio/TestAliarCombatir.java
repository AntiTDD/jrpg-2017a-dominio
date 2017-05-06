package tests_dominio;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;
import dominio.*;

public class TestAliarCombatir {

	@Test
	public void testCrearAlianza(){
		Humano h = new Humano("Nicolas",new Guerrero(),1);
		Humano h2 = new Humano("Lautaro",new Guerrero(),1);
		
		Assert.assertNull(h.getClan());
		Assert.assertNull(h2.getClan());
		h.aliar(h2);
		Assert.assertNotNull(h.getClan());
		Assert.assertNotNull(h2.getClan());
	}
	
	@Test
	public void testDañar(){
		Humano h = new Humano("Nicolas",new Guerrero(),1);
		Humano h2 = new Humano("Lautaro",new Asesino(),1);
		
		Assert.assertTrue(h2.getSalud()==105);
		if(	h.atacar(h2)!=0)
			Assert.assertTrue(h2.getSalud()<105);
		else
			Assert.assertTrue(h2.getSalud()==105);
	}
	
	@Test
	public void testAliar(){
		Humano h = new Humano("Nicolas",new Guerrero(),1);
		Humano h2 = new Humano("Lautaro",new Guerrero(),1);
		Alianza a1= new Alianza("Los CacheFC");
		
		Assert.assertNull(h2.getClan());
		Assert.assertNull(h.getClan());
		h.setClan(a1);
		Assert.assertNotNull(h.getClan());
		h.aliar(h2);
		Assert.assertTrue(h.getClan()==h2.getClan());
	}
	
	@Test
	public void obtenerYEstablecerAliadosAUnClan()
	{
		Humano h=new Humano("Gandalf",new Hechicero(),1);
		Elfo e=new Elfo("Legolas",new Asesino(), 1);
		Orco o=new Orco("Uruk-Hai",new Guerrero(),1);
		
		Alianza ali1=new Alianza("La comunidad del anillo");
		h.setClan(ali1);
		h.aliar(e);
		h.aliar(o);
		
		LinkedList<Personaje> aliados1=ali1.getAliados();
		Assert.assertEquals("Gandalf",aliados1.get(0).getNombre());
		Assert.assertEquals("Legolas",aliados1.get(1).getNombre());
		Assert.assertEquals("Uruk-Hai",aliados1.get(2).getNombre());
		
		aliados1.clear();
		
		aliados1.add(h);
		aliados1.add(e);
		
		ali1.setAliados(aliados1);
		Assert.assertEquals("Gandalf", ali1.getAliados().get(0).getNombre());
		Assert.assertEquals("Legolas", ali1.getAliados().get(1).getNombre());		
	}
	
	
	@Test
	public void obtenerElNombreCorrectoDeUnaAlianza()
	{
		Alianza ali1=new Alianza("La comunidad del anillo");
		Assert.assertEquals("La comunidad del anillo", ali1.obtenerNombre());
	}
	
	
	@Test
	public void eliminarDeUnClanAUnMiembro()
	{
		Humano h=new Humano("Gandalf",new Hechicero(),1);
		Elfo e=new Elfo("Legolas",new Asesino(),1);
		h.aliar(e);
		e.salirDeAlianza();
		Assert.assertNull(e.getClan());
	}
	
}
