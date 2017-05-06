package dominio;

import java.io.Serializable;

/**
 * Clase abstracta que engloba la casta a la que pertenece cada personaje en el
 * juego.<br>
 */
  public abstract class Casta implements Serializable {

  protected double probabilidadGolpeCritico;
  protected double probabilidadEvitarDa�o;
  protected double da�oCritico;
  protected String nombreCasta;
  protected String[] habilidadesCasta;


  /**
  * Constructor de objetos Casta los cuales modelan todo lo concerniente a las
  * distintas profesiones de los personajes.
  */
  public Casta() {
    final float ceroPuntoDos = 0.2f;
    final float unoPuntoCinco = 1.5f;
    this.probabilidadGolpeCritico = ceroPuntoDos;
    this.probabilidadEvitarDa�o = ceroPuntoDos;
    this.da�oCritico = unoPuntoCinco;
  }


  /**
  * Constructor de objetos Casta los cuales modelan todo lo concerniente a las
  * distintas profesiones de los personajes.
  * @param prob_crit Double que indica la chance que tiene este objeto de meter
  * un golpe critico.
  * @param evasion Double que indica la evasion de este objeto.
  * @param da�o_crit Double que indica el da�o critico de este objeto.
  */
  public Casta(double prob_crit, double evasion, double da�o_crit) {
    this.probabilidadGolpeCritico = prob_crit;
    this.probabilidadEvitarDa�o = evasion;
    this.da�oCritico = da�o_crit;
  }

  /**
  * El presente metodo abstracto devuelve un booleano indicando si la habilidad1
  * pudo ser llevada a cabo o no.<br>Por ser metodo abstracto, esta habilidad
  * muy posiblemente tenga comportamientos distintos en las distintas clases que
  * extiendan a esta clase.
  * @param caster Objeto Personaje el cual ataca.
  * @param atacado Objeto Peleable el cual es el atacado. Puede ser atacado
  * tanto un Personaje como un NPC, por �sto es un objeto Peleable.
  * @return Booleano que indica si se ejecuta la habilidad1, o no.
  */
  public abstract boolean habilidad1(Personaje caster, Peleable atacado);

  /**
  * El presente metodo abstracto devuelve un booleano indicando si la habilidad2
  * pudo ser llevada a cabo o no.<br>Por ser metodo abstracto, esta habilidad
  * muy posiblemente tenga comportamientos distintos en las distintas clases que
  * extiendan a esta clase.
  * @param caster Objeto Personaje el cual ataca.
  * @param atacado Objeto Peleable el cual es el atacado. Puede ser atacado
  * tanto un Personaje como un NPC, por �sto es un objeto Peleable.
  * @return Booleano que indica si se ejecuta la habilidad2, o no.
  */
  public abstract boolean habilidad2(Personaje caster, Peleable atacado);


  /**
  * El presente metodo abstracto devuelve un booleano indicando si la
  * habilidad2 pudo ser llevada a cabo o no.<br>Por ser metodo abstracto,
  * esta habilidad muy posiblemente tenga comportamientos distintos en las
  * distintas clases que extiendan a esta clase.
  * @param caster Objeto Personaje el cual ataca.
  * @param atacado Objeto Peleable el cual es el atacado. Puede ser atacado
  * tanto un Personaje como un NPC, por �sto es un objeto Peleable.
  * @return Booleano que indica si se ejecuta la habilidad2, o no.
  */
  public abstract boolean habilidad3(Personaje caster, Peleable atacado);

 /**
  * mejorarAtributoCasta va a ser sobreescrita en las clases hijas
  * @param personaje
  */
 public abstract void mejorarAtributoCasta(Personaje personaje);

  /**
  * Metodo el cual sirve para obtener el nombre de este objeto.<br>
  * Devuelve un String indicando el nombre.
  * @return String indicando el nombre de este objeto.
  */
  public String getNombreCasta() {
    return this.nombreCasta;
  }


  /**
  * Metodo el cual sirve para obtener todas las habilidades de profesion de
  * este objeto.<br>Devuelve un array de String indicando todas las habilidades.
  * @return Array de String indicando las habilidades de profesion de este
  * objeto.
  */
  public String[] getHabilidadesCasta() {
    return habilidadesCasta;
  }


  /**
  * Metodo el cual sirve para obtener la probabilidad de da�o critico de este
  * objeto.<br>Devuelve un double indicando la probabilidad.
  * @return Double indicando la probabilidad de da�o critico de este objeto.
  */
  public double getProbabilidadGolpeCritico() {
    return probabilidadGolpeCritico;
  }


  /**
  * Metodo el cual sirve para establecer la probabilidad de golpe critico de
  * este objeto.<br>Devuelve un void.
  * @param probabilidadGolpeCritico Double que indica la probabilidad de golpe
  * critico a ser establecido en este objeto.
  */
  public void setProbabilidadGolpeCritico(double probabilidadGolpeCritico) {
    this.probabilidadGolpeCritico = probabilidadGolpeCritico;
  }


  /**
  * Metodo el cual sirve para obtener la probabilidad de este objeto de evitar
  * el da�o.<br>Devuelve un double indicando la probabilidad de evitar el da�o
  * critico.
  * @return Double indicando la probabilidad que tiene este objeto de evitar
  * el da�o critico.
  */
  public double getProbabilidadEvitarDa�o() {
    return probabilidadEvitarDa�o;
  }


  /**
  * Metodo el cual sirve para establecer la probabilidad de este objeto de
  * evitar el da�o.<br>Devuelve un void.
  * @param probabilidadEvitarDa�o Double que indica la probabilidad de evitar el
  * da�o a ser establecido en este objeto.
  */
  public void setProbabilidadEvitarDa�o(double probabilidadEvitarDa�o) {
    this.probabilidadEvitarDa�o = probabilidadEvitarDa�o;
  }


  /**
  * Metodo el cual sirve para obtener el da�o critico de este objeto.<br>
  * Devuelve un double indicando la el da�o critico.
  * @return Double indicando el da�o critico de este objeto.
  */
  public double getDa�oCritico() {
    return da�oCritico;
  }


  /**
  * Metodo el cual sirve para establecer el da�o critico de este objeto.<br>
  * Devuelve un void.
  * @param da�oCritico Double que indica el da�o critico a ser establecido en
  * este objeto.
  */
  public void setDa�oCritico(double da�oCritico) {
    this.da�oCritico = da�oCritico;
  }
}
