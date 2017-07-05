package dominio;

import java.io.Serializable;

/**
 * Clase abstracta que engloba la casta a la que pertenece cada personaje
   * en el juego.
 *
 */
public abstract class Casta implements Serializable {


  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** The probabilidad golpe critico. */
  protected double probabilidadGolpeCritico;

  /** The probabilidad evitar daño. */
  protected double probabilidadEvitarDaño;

  /** The daño critico. */
  protected double dañoCritico;

  /** The nombre casta. */
  protected String nombreCasta;

  /** The habilidades casta. */
  protected String[] habilidadesCasta;


  /**
  * Constructor de objetos Casta los cuales modelan todo lo concerniente a las
  * distintas profesiones de los personajes.
  */
  public Casta() {
    final float ceroPuntoDos = 0.2f;
    final float unoPuntoCinco = 1.5f;
    final int cinco = 5;
    this.probabilidadGolpeCritico = ceroPuntoDos;
    this.probabilidadEvitarDaño = ceroPuntoDos;
    this.dañoCritico = unoPuntoCinco;
  }


  /**
  * Constructor de objetos Casta los cuales modelan todo lo concerniente a las
  * distintas profesiones de los personajes.
  * un golpe critico.
  * @param probCrit Double que indica la chance que tiene este objeto de meter
  * @param evasion Double que indica la evasion de este objeto.
  * @param dañoCrit Double que indica el da�o critico de este objeto.
  */
  public Casta(final double probCrit,
               final double evasion, final double dañoCrit) {
    this.probabilidadGolpeCritico = probCrit;
    this.probabilidadEvitarDaño = evasion;
    this.dañoCritico = dañoCrit;
  }

  /**
  * El presente metodo abstracto devuelve un booleano indicando si la habilidad1
  * pudo ser llevada a cabo o no.<br>Por ser metodo abstracto, esta habilidad
  * muy posiblemente tenga comportamientos distintos en las distintas clases que
  * extiendan a esta clase.
  * @param caster Objeto Personaje el cual ataca.
  * @param atacado Objeto Peleable el cual es el atacado. Puede ser atacado
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
  * @return Booleano que indica si se ejecuta la habilidad2, o no.
  */
  public abstract boolean habilidad3(Personaje caster, Peleable atacado);


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
  */

  public void setProbabilidadGolpeCritico(final double probabilidadGolpeCritico) {
    this.probabilidadGolpeCritico = probabilidadGolpeCritico;
  }


  /**
  * Metodo el cual sirve para obtener la probabilidad de este objeto de evitar
  * el daño.<br>Devuelve un double indicando la probabilidad de evitar el da�o
  * critico.
  * @return Double indicando la probabilidad que tiene este objeto de evitar
  */

  public double getProbabilidadEvitarDaño() {
    return probabilidadEvitarDaño;
  }


  /**
  * Metodo el cual sirve para establecer la probabilidad de este objeto de
  * evitar el daño.<br>Devuelve un void.
  * @param probabilidadEvitarDaño Double que indica la probabilidad de evitar el
  */
  public void setProbabilidadEvitarDaño(double probabilidadEvitarDaño) {
    this.probabilidadEvitarDaño = probabilidadEvitarDaño;
  }


  /**
  * Metodo el cual sirve para obtener el daño critico de este objeto.<br>
  * Devuelve un double indicando la el daño critico.
  * @return Double indicando el da�o critico de este objeto.
  */
  public double getDañoCritico() {
    return dañoCritico;
  }


  /**
  * Metodo el cual sirve para establecer el daño critico de este objeto.<br>
  * Devuelve un void.
  * @param dañoCritico Double que indica el daño critico a ser establecido en
  */
  public void setDañoCritico(double dañoCritico) {
    this.dañoCritico = dañoCritico;
  }



  /**
   * Gets the bonus fuerza.
   *
   * @return the bonus fuerza
   */
  public int getBonusFuerza() {
    if (nombreCasta.equals("Guerrero")) {
      return 5;
    }

    return 0;
  }

  /**
   * Gets the bonus destreza.
   *
   * @return the bonus destreza
   */
  public int getBonusDestreza() {
    if (nombreCasta.equals("Asesino")) {
      return 5;
    }

    return 0;
  }

  /**
   * Gets the bonus inteligencia.
   *
   * @return the bonus inteligencia
   */
  public int getBonusInteligencia() {
    if (nombreCasta.equals("Hechicero")) {
      return 5;
    }

    return 0;
  }
}
