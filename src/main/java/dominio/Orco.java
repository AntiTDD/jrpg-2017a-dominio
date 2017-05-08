package dominio;

/**
 * La clase Orco indica la raza del personaje y, por esto ultimo, extiende a la
 * clase abstracta Personaje.
 */
public class Orco extends Personaje {


  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ENERGIA_MINIMA = 10;
	private static final int VIDA_NULA = 0;
	private static final int ATAQUE_NULO = 0;

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
    if (this.getEnergia() > ENERGIA_MINIMA) {
      this.setEnergia(this.getEnergia() - ENERGIA_MINIMA);
      if (atacado.serAtacado(this.getDefensa() * 2) > VIDA_NULA) {
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
  * s� mismo lo mismo que lo que da�o a su atacado.
  * @param atacado Objeto Peleable el cual es el destinatario del Mordisco de
  * Vida, o sea, el atacado.
  * @return Booleano que indica si Mordisco de Vida pudo llevarse a cabo o no.
  */
  public boolean habilidadRaza2(Peleable atacado) {
    if (this.getEnergia() > ENERGIA_MINIMA) { 
      this.setEnergia(this.getEnergia() - ENERGIA_MINIMA);
      int daño_causado = atacado.serAtacado(this.getFuerza());
      if (daño_causado > ATAQUE_NULO) {
        this.serCurado(daño_causado);
        return true;
      }
    }
    return false;
  }
}
