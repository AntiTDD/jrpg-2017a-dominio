package dominio;

import java.util.LinkedList;

/**
 * <p> Clase que especifica una Alianza con los personajes que la componen</P>
 * 
 *
 */
//probar si sale mi username cuando commiteo

public class Alianza { 
	String nombre;
	LinkedList<Personaje> aliados;

	public Alianza(String nombre) {
		this.nombre = nombre;
		this.aliados = new LinkedList <Personaje>();
	}

	public LinkedList<Personaje> getAliados() {
		return aliados;
	}

	public void setAliados(LinkedList<Personaje> aliados) {
		this.aliados = aliados;
	}
	
	/**
	 * 
	 * <p> Este método retorna el nombre de la Alianza </p>
	 * @return String que indica el nombre de la alianza
	 */

	public String obtenerNombre(){
		return nombre;
	}
	
	/**
	 * 
	 * <p> Este método elimina un personaje de la alianza </p>
	 * @param pj el cual va a ser eliminado de la alianza
	 * 
	 */
	
	public void eliminarPersonaje(Personaje pj){
		aliados.remove(pj);
	}
	
	/**
	 * 
	 * <p> Este métopdo añade un personaje a la alianza </p>
	 * @param pj el cual se va a agregar a la alianza
	 */
	
	public void añadirPersonaje(Personaje pj){
		aliados.add(pj);
	}
}
