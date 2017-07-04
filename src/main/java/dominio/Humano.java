package dominio;

/**
 * La clase Humano indica la raza del personaje y, por esto ultimo, extiende
 * a la clase abstracta Personaje.
 */
public class Humano extends Personaje {


  private static final long serialVersionUID = 1L;
  /** The Constant ENERGIA_MINIMA se usa para setear.
   *  un valor default de la energia minima */
  private static final int ENERGIA_MINIMA = 10;
  /** The Constant VIDA_NULA. setea valor default */
  private static final int VIDA_NULA = 0;
  /** The Constant PLUS_HUMANO. setea un valor default */
  private static final int PLUS_HUMANO = 5;

  /**
  * Constructor de objetos de raza Humano.
  * @param nombre String que indica el nombre de este objeto.
  * @param casta Objeto de tipo Casta que indica la profesion a la que
  * @param id Entero que identifica univocamente a este objeto.
  */
  public Humano(String nombre, Casta casta, int id) {
    super(nombre, casta, id, "Humano", "Incentivar", "Golpe Fatal");
    saludTope += PLUS_HUMANO;
    energiaTope += PLUS_HUMANO;
    salud = saludTope;
    energia = energiaTope;
  }


  /**
  * Constructor de objetos de raza Humano.
  * @param nombre String que indica el nombre de este objeto.
  * @param salud Entero que indica la salud de este objeto.
  * @param energia Entero que indica la energia de este objeto.
  * @param fuerza Entero que indica la fuerza de este objeto.
  * @param destreza Entero que indica la destreza de este objeto.
  * @param inteligencia Entero que indica la inteligencia de este objeto.
  * @param casta Objeto de tipo Casta que indica la profesion a la que
  * @param experiencia Entero que indica la experiencia actual de este objeto.
  * @param nivel Entero que indica el nivel actual de este objeto.
  * @param idPersonaje Entero que identifica univocamente a este objeto.
  */
  public Humano(String nombre, int salud, int energia, int fuerza, int destreza,
      int inteligencia, Casta casta, int experiencia,
      int nivel, int idPersonaje) {
    super(nombre, salud, energia, fuerza, destreza, inteligencia, casta,
        experiencia, nivel, idPersonaje, "Humano",
        "Incentivar", "Golpe Fatal");
  }

  /**
  * El presente metodo devuelve un booleano que indica si este objeto Humano
  * puede, o no, incentivar el ataque de cualquier otro objeto Peleable. Sea
  * �ste un Humano, Elfo u Orco, como tambien un NPC o s� mismo.<br> Si se
  * puede incentivar, entonces el ataque del objeto incentivado es igual a su
  * ataque normal adicionado a la magia de este objeto (el Humano que
  * incentiva).
  * @param atacado Objeto Peleable el cual es el destinatario del incentivo
  * @return Booleano que indica si el incentivo pudo llevarse a cabo o no.
  */
  public boolean habilidadRaza1(Peleable atacado) {
    if (this.getEnergia() > ENERGIA_MINIMA) {
      this.bajarEnergia(ENERGIA_MINIMA);
      atacado.setAtaque(atacado.getAtaque() + this.getMagia());
      return true;
    }
    return false;
  }


  /**
  * El presente metodo devuelve un booleano que indica si este objeto Humano
  * puede, o no, asestar un golpe fatal a su atacado que es un objeto Peleable.
  * @param atacado Objeto Peleable el cual es el destinatario del golpe fatal.
  * @return Booleano que indica si el golpe fatal pudo llevarse a cabo o no.
  */
  public boolean habilidadRaza2(Peleable atacado) {
    if (this.getEnergia() > ENERGIA_MINIMA) {
      if (atacado.serAtacado(atacado.getSalud() / 2) > VIDA_NULA) {
        this.bajarEnergia(this.getEnergia() / 2);
        return true;
      }
    }
    this.bajarEnergia(ENERGIA_MINIMA);
    return false;
  }
}
