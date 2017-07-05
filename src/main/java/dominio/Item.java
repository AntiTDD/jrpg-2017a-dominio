package dominio;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * The Class Item se utiliza para manejar.
 *  todos los items creados en el juego
 */
public class Item { /* PREGUNTAR: Asumo que un
 item no modifica "fuerza", sino "ataque".
 Y en caso de que un NPC tenga equipado un item con modificacion
  de "ataque", le subo la fuerza ya que en éstos
 la fuerza es proporcional al "ataque".*/

  /** The id. */
 private int id;

  /** The bonus. */
  private HashMap<String, Integer> bonus;

  /** The ubic en el cuerpo. */
  private Integer ubicEnElCuerpo;

  /**
   * Instantiates a new item.
   */
  public Item() {
      id = 0;
      ubicEnElCuerpo = 0;
  }
  /**
   * Constructor de objetos Item.
   * @param id Integer que identifica a este objeto.
   * @param bonus HashMap<String,Integer> cuya clave es un String que refiere
     * a un atributo y un Integer que es el valor del incremento (o decremento)
       * de ese atributo.
   * @param ubicEnElCuerpo Integer que refiere
   *  a la posicion de este objeto en el
     * cuerpo del Personaje.
   */
  public Item(Integer id, HashMap<String, Integer>
          bonus, Integer ubicEnElCuerpo) {
    this.id = id;
    this.bonus = bonus;
    this.ubicEnElCuerpo = ubicEnElCuerpo;
  }


  /**
  * Constructor de objetos Item.
  * @param id Integer que identifica a este objeto.
  * @param ubicEnElCuerpo Integer que refiere
  *  a la posicion de este objeto en el cuerpo
  * del Personaje.
  */
  public Item(Integer id, Integer ubicEnElCuerpo) {
    this.id = id;
    this.ubicEnElCuerpo = ubicEnElCuerpo;
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(int id) {
     this.id = id;
  }

  /**
   * Gets the ubic en el cuerpo.
   *
   * @return the ubic en el cuerpo
   */
  public Integer getUbicEnElCuerpo() {
    return ubicEnElCuerpo;
  }

  /**
   * Sets the bonus.
   *
   * @param bonus the bonus
   */
  public void setBonus(HashMap<String, Integer> bonus) {
     this.bonus = bonus;
  }

  /**
   * Gets the bonus.
   *
   * @return the bonus
   */
  public HashMap<String, Integer> getBonus() {
    return bonus;
  }


  /**
   * Metodo que sirve para agregar un solo atributo a este objeto.
   * @param atributo String que refiere al atributo a ser seteado.
   * @param cant Integer que contiene el valor
   *  con el cual el atributo sera iniciado.
   */
  public void agregarBonus(String atributo, Integer cant) {
    bonus.put(atributo, cant); /* Por HashMap no permitir
     claves duplicadas, en caso de que se quisiese ingresar
      un atributo (clave) que ya existe en "bonus",
       simplemente no se agrega sin tirar error ni nada. */
  }


  /**
  * Metodo que sirve para agregar más de un atributo a este objeto.
  * @param hashDebonus HashMap<String,Integer> cuya clave contiene el atributo
    * a ser seteado e Integer que contiene el valor que tendra dicho atributo.
  */
  public void agregarBonus(HashMap<String, Integer> hashDebonus) {
    Iterator<Map.Entry<String, Integer>> entradas
    = hashDebonus.entrySet().iterator();

    while (entradas.hasNext()) {
      Map.Entry<String, Integer> entradaActual = entradas.next();
      bonus.put(entradaActual.getKey(),
          entradaActual.getValue());
      /* En caso de que alguna clave de "hashDebonus"
       *  estuviese tambien en "bonus", al hacer este put no estaria
       *   ingresandose esa entrada porque
       *    HashMap no permite claves repetidas. */
    }
  }

  /*// NO BORRAR. La dejo comentada porque no estoy
   *  seguro que se pueda modificar el bonus de los atributos. //
  public void modificarBonus(String atributo, Integer cant) {
    bonus.replace(atributo, cant);
  }
  */

  /**
   * Metodo que sirve para saber si este objeto ya contiene cierto atributo.
   * @param atributo String que refiere
   *  al atributo por el que se pregunta si existe.
   * @return Boolean indicando si el atributo existe o no.
   */
  public boolean existeAtributo(String atributo) {
    return bonus.containsKey(atributo);
  }

}
