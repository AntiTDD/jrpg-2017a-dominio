package dominio;

/**
 * La clase Elfo indica la raza del personaje y, por esto ultimo, extiende a la
 * clase abstracta Personaje.
 */
public class Elfo extends Personaje {


  /**
  * Constructor de objetos de raza Elfo.
  * @param nombre String que indica el nombre de este objeto.
  * @param casta Objeto de tipo Casta que indica la profesion a la que pertenece
  * este objeto.
  * @param id Entero que identifica univocamente a este objeto.
  */
  public Elfo(String nombre, Casta casta, int id) {
    super(nombre, casta, id);
    final int diez = 10;
    energiaTope += diez;
    salud = saludTope;
    energia = energiaTope;
    nombreRaza = "Elfo";

    habilidadesRaza = new String[2];
    habilidadesRaza[0] = "Golpe Level";
    habilidadesRaza[1] = "Ataque Bosque";
  }


  /**
  * Constructor de objetos de raza Elfo.
  * @param nombre String que indica el nombre de este objeto.
  * @param salud Entero que indica la salud de este objeto.
  * @param energia Entero que indica la energia de este objeto.
  * @param fuerza Entero que indica la fuerza de este objeto.
  * @param destreza Entero que indica la destreza de este objeto.
  * @param inteligencia Entero que indica la inteligencia de este objeto.
  * @param casta Objeto de tipo Casta que indica la profesion a la que pertenece
  * este objeto.
  * @param experiencia Entero que indica la experiencia actual de este objeto.
  * @param nivel Entero que indica el nivel actual de este objeto.
  * @param idPersonaje Entero que identifica univocamente a este objeto.
  */
  public Elfo(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia,
      Casta casta, int experiencia, int nivel, int idPersonaje) {
        super(nombre, salud, energia, fuerza, destreza, inteligencia, casta,
          experiencia, nivel, idPersonaje);

    nombreRaza = "Elfo";

    habilidadesRaza = new String[2];
    habilidadesRaza[0] = "Golpe Level";
    habilidadesRaza[1] = "Ataque Bosque";
  }

  // Golpe Level
  /**
  * El presente metodo devuelve un booleano que indica si este objeto Elfo
  * puede,o no, asestar un golpe que sea acorde a su nivel en el juego. Como el
  * atacado es un objeto Peleable, tanto los objetos Personaje como los NPC,
  * pueden ser atacados.
  * @param atacado Objeto Peleable el cual es el destinatario del golpe Level, o
  * sea, el atacado.
  * @return Booleano que indica si el golpe por nivel pudo llevarse a cabo o no.
  */
  public boolean habilidadRaza1(Peleable atacado) {
    final int diez = 10;
    if (this.getEnergia() > diez) {  // PREGUNTAR: No se deberia tambien preguntar si el atacado tiene salud mayor a 0? O sea, en esta linea poner: "if(energia>10 && atacado.getSalud()>0" //
      this.setEnergia(this.getEnergia() - diez);
      final int cero=0;
      if (atacado.serAtacado(this.getFuerza() + this.getNivel() * diez) > cero) { // PREGUNTAR: En vez de "this.getFuerza()" no deberia ser "this.getAtaque()" o "ataque"? //
        return true;
      }
    }
    return false;
  }

  // Ataque Bosque
  /**
  * El presente metodo devuelve un booleano que indica si este objeto Elfo
  * puede, o no, asestar un ataque Bosque. Como el atacado es un objeto
  * Peleable, tanto los objetos Personaje como los NPC, pueden ser atacados.
  * @param atacado Objeto Peleable el cual es el destinatario del ataque Bosque,
  * o sea, el atacado.
  * @return Booleano que indica si el ataque Bosque dañó al atacado, o no.
  */
  public boolean habilidadRaza2(Peleable atacado) {
    final int diez = 10;
    if (this.getEnergia() > diez) { // PREGUNTAR: No se deberia tambien preguntar si el atacado tiene salud mayor a 0? O sea, en esta linea poner: "if(energia>10 && atacado.getSalud()>0" //
      this.setEnergia(this.getEnergia() - diez);
      final int cero = 0;
      if (atacado.serAtacado((int) (this.magia)) > cero) {
        return true;
      }
    }
    return false;
  }
}
