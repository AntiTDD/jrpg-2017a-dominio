package dominio;

public interface Peleable {
  /**
  * Definicion de metodo el cual sirve a efectos de calcular el da�o recibido
  * por parte de un atacante.<br>
  * Devuelve un entero indicando el da�o sufrido.
  * @param daño Entero que indica el daño con el que pega quien ataca.
  * @return Un entero que indica el daño que ha sufrido el objeto atacado.
  */
  public int serAtacado(int daño);


  /**
  * Definicion de metodo el cual sirve a efectos de saber la salud con que
  * cuenta este objeto.<br>Devuelve un entero indicando la salud de �ste.
  * @return Un entero indicando la salud de este objeto.
  */
  public int getSalud();


  /**
  * PREGUNTAR: Qu� hace este metodo? Ni siquiera esta implementado en ningun
  * lado.
  */
  public void despuesDeTurno();


  /**
  * Definicion de metodo el cual sirve para que un objeto que implemente esta
  * interfaz, ataque a otro objeto que tambien extienda esta interfaz.<br>
  * Devuelve un entero indicando cuanto fue el da�o que este objeto le causa al
  * objeto atacado.
  * @param atacado Objeto Peleable el cual sufre el ataque de este objeto.
  * @return Un entero indicando el da�o propiciado al objeto atacado.
  */
  public int atacar(Peleable atacado);


  /**
  * Definicion de metodo el cual sirve para subir la experiencia que tiene este
  * objeto.<br>Devuelve un entero indicando si este objeto subi� de nivel cosa
  * la cual me parece mal por lo explicado en NOTA de la implementacion de este
  * metodo en Personaje. //
  * @return Un entero indicando si este objeto subi� de nivel.
  */
  public int otorgarExp();


  /**
  * Definicion de metodo el cual sirve para obtener el ataque de este objeto.
  * <br>Devuelve un entero indicando su ataque.
  * @return Un entero indicando el ataque de este objeto.
  */
  public int getAtaque();


  /**
  * Definicion de metodo el cual sirve para establecer el ataque de este objeto.
  * <br>Este metodo no devuelve nada.
  * @param ataque Entero que representa el ataque a establecer en este objeto.
  */
  public void setAtaque(int ataque);


  /**
  * Definicion de metodo el cual sirve para saber si este objeto esta vivo o no.
  * Devuelve un booleano indicando si est� vivo.
  * @return Un booleano indicando si este objeto est� vivo.
  */
  public boolean estaVivo();


  /**
  * Definicion de metodo el cual sirve para obtener el nombre de este objeto.
  * Devuelve un String con su nombre.
  * @return Un String que representa el nombre de este objeto.
  */
  public String getNombre();

  /**
   * Definicion de metodo el cual sirve para agregar un item a este objeto.
  */
  public boolean agregarItem(Item i);  

  /**
   * Definicion de metodo el cual sirve para actualizar los atributos luego de agregar un 
     * item a este objeto.
   * @param i Item el cual tiene los bonus a ser incrementados en los atributos de este objeto.
   */
  public void actualizarALaSubaAtributosPorItem(Item i);

  /**
   * Definicion de metodo el cual sirve para actualizar los atributos luego de borrarle un 
     * item a este objeto.
   * @param i Item el cual tiene los bonus a ser decrementados en los atributos de este objeto.
   */
  public void actualizarALaBajaAtributosPorItem(Item i);

  /**
   * Definicion de metodo el cual sirve para que este objeto suelte, por decision propia, un item
     * de su inventario.
   * @param id Integer el cual identifica el item a eliminar de su inventario.
   */
  public void soltarItem(Integer id);
}
