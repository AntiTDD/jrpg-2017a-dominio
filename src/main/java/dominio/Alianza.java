package dominio;

import java.util.LinkedList;

/**Clase que especifica una Alianza con los personajes que la componen.
 * 
 * 
 *
 */



public class Alianza { 
  String nombre;
  LinkedList<Personaje> aliados;

  public Alianza(String nombre) {
    this.nombre = nombre;
    this.aliados = new LinkedList<Personaje>();
  }

  public LinkedList<Personaje> getAliados() { 
    return aliados;
  }

  public void setAliados(LinkedList<Personaje> aliados) {
    this.aliados = aliados;
  }

  /**Este metodo retorna el nombre de la Alianza.
   * 
   *
   *
   */

  public String obtenerNombre() {
    return nombre;
  }

  /** Este metodo elimina un personaje de la alianza.
   * 
   *
   * @param pj el cual va a ser eliminado de la alianza
   * 
   */

  public void eliminarPersonaje(Personaje pj) {
    aliados.remove(pj);
  }

  /**
   * 
   * <p> Este metopdo añade un personaje a la alianza. </p>
   * @param pj el cual se va a agregar a la alianza
   */
  
  public void añadirPersonaje(Personaje pj) {
    aliados.add(pj);
  }
}