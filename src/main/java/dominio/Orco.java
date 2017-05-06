package dominio;

/**
 * La clase Orco indica la raza del personaje y, por esto ultimo, extiende a la
 * clase abstracta Personaje.
 */
public class Orco extends Personaje {


  /**
  * Constructor de objetos de raza Orco.
  * @param nombre String que indica el nombre de este objeto.
  * @param casta Objeto de tipo Casta que indica la profesion a la que
  * pertenece este objeto.
  * @param id Entero que identifica univocamente a este objeto.
  */
  public Orco(String nombre, Casta casta, int id) {
    super(nombre, casta, id ,"Orco","Golpe Defensa","Mordisco de Vida");
    final int diez = 10;
    saludTope += diez;
    salud = saludTope;
    energia = energiaTope;
  }


  /**
  * Constructor de objetos de raza Orco.
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
  public Orco(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia,
      Casta casta, int experiencia, int nivel, int idPersonaje) {
    super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel,
        idPersonaje,"Orco","Golpe Defensa","Mordisco de Vida");
  }

  /**
  * El presente metodo devuelve un booleano que indica si este objeto Orco
  * puede, o no, asestar un golpe Defensa el cual es un golpe acorde a la
  * defensa que posee.<br>Como el atacado es un objeto Peleable, tanto los
  * objetos Personaje como los NPC, pueden ser atacados.
  * @param atacado Objeto Peleable el cual es el destinatario del golpe
  * Defensa, o sea, el atacado.
  * @return Booleano que indica si el golpe Defensa pudo llevarse a cabo o no.
  */
  public boolean habilidadRaza1(Peleable atacado) {
    final int diez = 10;
    if (this.getEnergia() > diez) {
      this.setEnergia(this.getEnergia() - diez);
      final int dos = 2, cero = 0;
      if (atacado.serAtacado(this.getDefensa() * dos) > cero) {
        return true;
      }
    }
    return false;
  }

  /**
  * El presente metodo devuelve un booleano que indica si este objeto Orco
  * puede, o no, asestar un Mordisco de Vida a su atacado el cual es un objeto
  * Peleable y por ende puede ser asestado tanto a objetos Personaje como a
  * NPC's.<br>
  * Cuando se logra efectuar Mordisco de Vida, el orco que lo asesta se cura a
  * sí mismo lo mismo que lo que daño a su atacado.
  * @param atacado Objeto Peleable el cual es el destinatario del Mordisco de
  * Vida, o sea, el atacado.
  * @return Booleano que indica si Mordisco de Vida pudo llevarse a cabo o no.
  */
  public boolean habilidadRaza2(Peleable atacado) {
    final int diez = 10;
    if (this.getEnergia() > diez) { 
      this.setEnergia(this.getEnergia() - diez);
      int daño_causado = atacado.serAtacado(this.getFuerza());
      final int cero = 0;
      if (daño_causado > cero) {
        this.serCurado(daño_causado);
        return true;
      }
    }
    return false;
  }
}
