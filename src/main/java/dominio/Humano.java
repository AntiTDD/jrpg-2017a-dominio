package dominio;

/**
 * La clase Humano indica la raza del personaje y, por esto ultimo, extiende
 * a la clase abstracta Personaje.
 */
public class Humano extends Personaje {


  /**
  * Constructor de objetos de raza Humano.
  * @param nombre String que indica el nombre de este objeto.
  * @param casta Objeto de tipo Casta que indica la profesion a la que
  * pertenece este objeto.
  * @param id Entero que identifica univocamente a este objeto.
  */
  public Humano(String nombre, Casta casta, int id) {
    super(nombre, casta, id , "Humano" , "Incentivar" ,"Golpe Fatal");
    final int cinco = 5;
    saludTope += cinco;
    energiaTope += cinco;
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
  * pertenece este objeto.
  * @param experiencia Entero que indica la experiencia actual de este objeto.
  * @param nivel Entero que indica el nivel actual de este objeto.
  * @param idPersonaje Entero que identifica univocamente a este objeto.
  */
  public Humano(String nombre, int salud, int energia, int fuerza, int destreza,
      int inteligencia, Casta casta, int experiencia, int nivel, int idPersonaje) {
    super(nombre, salud, energia, fuerza, destreza, inteligencia, casta,
        experiencia, nivel, idPersonaje,"Humano" , "Incentivar" ,"Golpe Fatal");
  }

  /**
  * El presente metodo devuelve un booleano que indica si este objeto Humano
  * puede, o no, incentivar el ataque de cualquier otro objeto Peleable. Sea
  * éste un Humano, Elfo u Orco, como tambien un NPC o sí mismo.<br> Si se
  * puede incentivar, entonces el ataque del objeto incentivado es igual a su
  * ataque normal adicionado a la magia de este objeto (el Humano que
  * incentiva).
  * @param atacado Objeto Peleable el cual es el destinatario del incentivo
  * dado por this objeto.
  * @return Booleano que indica si el incentivo pudo llevarse a cabo o no.
  */
  public boolean habilidadRaza1(Peleable atacado) {
    final int diez = 10;
    if (this.getEnergia() > diez) {  
      this.setEnergia(this.getEnergia() - diez);
      atacado.setAtaque(atacado.getAtaque() + this.getMagia());
      return true;
    }
    return false;
  }
  
  /**
  * El presente metodo devuelve un booleano que indica si este objeto Humano
  * puede, o no, asestar un golpe fatal a su atacado que es un objeto Peleable.
  * @param atacado Objeto Peleable el cual es el destinatario del golpe fatal,
  * o sea, el atacado.
  * @return Booleano que indica si el golpe fatal pudo llevarse a cabo o no.
  */
  public boolean habilidadRaza2(Peleable atacado) {
    final int diez = 10;
    if (this.getEnergia() > diez) {
      final int dos = 2, cero = 0;
      if (atacado.serAtacado(atacado.getSalud() / dos) > cero) {
        this.setEnergia(this.getEnergia() / dos);
        return true;
      }
    }
    this.setEnergia(this.getEnergia() - diez);
    return false;
  }
}
