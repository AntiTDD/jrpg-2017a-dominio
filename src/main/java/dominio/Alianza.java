package dominio;

import java.util.LinkedList;

public class Alianza {
    String nombre;
    LinkedList<Personaje> aliados;

  /**
   * Constructor de Alianza la cual refleja los Personajes que la componen.
   * @param nombre String el cual es el nombre de esta Alianza.
   */
  public Alianza(String nombre) {
    this.nombre = nombre;
    this.aliados = new LinkedList<Personaje>();
  }


  /**
   * Metodo que sirve para saber la lista de aliados.
   * @return LinkedList<Personaje> con cada uno de los aliados que componen
     * esta Alianza.
   */
  public LinkedList<Personaje> getAliados() {
    return new LinkedList<Personaje>(aliados);
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
   * @param pj el cual va a ser eliminado de la alianza
   */
  public void eliminarPersonaje(Personaje pj) {
    aliados.remove(pj);
  }

  /**
   * Este metodo añade un personaje a la alianza.
   * @param pj el cual se va a agregar a la alianza
   */
  public void añadirPersonaje(Personaje pj) {
    aliados.add(pj);
  }
}