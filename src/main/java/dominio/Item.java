package dominio;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Item { // PREGUNTAR: Asumo que un item no modifica "fuerza", sino "ataque". Y en caso de que un NPC tenga equipado un item con modificacion de "ataque", le subo la fuerza ya que en éstos la fuerza es proporcional al "ataque". 
	
  private Integer id;
  private String nombre;
  private HashMap<String,Integer> bonus;
  private Integer ubicEnElCuerpo;

  /**
   * Constructor de objetos Item
   * @param id Integer que identifica a este objeto.
   * @param nombre String con el nombre del Item.
   * @param bonus HashMap<String,Integer> cuya clave es un String que refiere
     * a un atributo y un Integer que es el valor del incremento (o decremento)
       * de ese atributo.
   * @param ubicacion Integer que refiere a la posicion de este objeto en el
     * cuerpo del Personaje.
   */
  public Item(Integer id, String nombre, HashMap<String,Integer> bonus, Integer ubicEnElCuerpo) {
    this.id = id;
    this.nombre = nombre;
    this.bonus = bonus;
    this.ubicEnElCuerpo = ubicEnElCuerpo;
  }


  /**
  * Constructor de objetos Item
  * @param id Integer que identifica a este objeto.
  * @param nombre String con el nombre del Item.
  * @param ubicacion Integer que refiere a la posicion de este objeto en el cuerpo
  * del Personaje.
  */
  public Item(Integer id, String nombre, Integer ubicEnElCuerpo) {
    this.id = id;
    this.nombre = nombre;
    this.ubicEnElCuerpo = ubicEnElCuerpo;
  }

  public Integer getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public Integer getUbicEnElCuerpo() {
    return ubicEnElCuerpo;
  }

  public HashMap<String, Integer> getbonus() {
    return bonus;
  }


  /**
   * Metodo que sirve para agregar un solo atributo a este objeto.
   * @param atributo String que refiere al atributo a ser seteado.
   * @param cant Integer que contiene el valor con el cual el atributo sera iniciado.
   */
  public void agregarBonus(String atributo, Integer cant) {
    bonus.put(atributo, cant); // Por HashMap no permitir claves duplicadas, en caso de que se quisiese ingresar un atributo (clave) que ya existe en "bonus", simplemente no se agrega sin tirar error ni nada. //
  }


  /**
  * Metodo que sirve para agregar más de un atributo a este objeto.
  * @param hashDebonus HashMap<String,Integer> cuya clave contiene el atributo
    * a ser seteado e Integer que contiene el valor que tendra dicho atributo.
  */
  public void agregarBonus(HashMap<String,Integer> hashDebonus) {
    Iterator<Map.Entry<String,Integer>> entradas = hashDebonus.entrySet().iterator();
    while (entradas.hasNext()) {
      Map.Entry<String, Integer> entradaActual = entradas.next();
      bonus.put(entradaActual.getKey(), entradaActual.getValue()); // En caso de que alguna clave de "hashDebonus" estuviese tambien en "bonus", al hacer este put no estaria ingresandose esa entrada porque HashMap no permite claves repetidas. //
    }
  }

  /*// NO BORRAR. La dejo comentada porque no estoy seguro que se pueda modificar el bonus de los atributos. //
  public void modificarBonus(String atributo, Integer cant) {
    bonus.replace(atributo, cant);
  }
  */
  
  /**
   * Metodo que sirve para saber si este objeto ya contiene cierto atributo.
   * @param atributo String que refiere al atributo por el que se pregunta si existe.
   * @return Boolean indicando si el atributo existe o no.
   */
  public boolean existeAtributo(String atributo) {
    return bonus.containsKey(atributo);
  }

}
