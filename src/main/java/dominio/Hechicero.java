package dominio;

/**
  * Casta del personaje. Cualquier personaje puede tener cualquier casta y esta
  * clase es la de casta Hechocero.<br>Ejemplo: Un Personje Orco puede ser tanto
  * de casta Asesino, como Guerrero o Hechicero. Idem para los personajes Elfo y
  * Humano.
  */
public class Hechicero extends Casta {  
  private static final long serialVersionUID = 1L;
  private static final int ENERGIA_MINIMA = 10; 
  private static final float PLUS_MAGIA = 1.5f;
  private static final int ATAQUE_NULO = 0;
  /**
  * Constructor de objetos de profesion Guerrero.
  * @param prob_crit Double que indica la probabilidad de meter un critico que
  * @param evasion Double que indica la evasion que tiene este objeto.
  * @param daño_crit Double que indica el daño critico que tiene este objeto.
  */
  
  public Hechicero(double probCrit, double evasion, double dañoCrit) {
    super(probCrit, evasion, dañoCrit);
    this.nombreCasta = "Hechicero";
  }


  /**
  * Constructor de objetos de profesion Asesino.
  */
  public Hechicero() {
    super();
    this.nombreCasta = "Hechicero";
    final int cantTotalDeHabilidades = 3;
    habilidadesCasta = new String[cantTotalDeHabilidades];
    habilidadesCasta[0] = "Bola de Fuego";
    habilidadesCasta[1] = "Curar Aliado";
    habilidadesCasta[2] = "Robar Energia y Salud";
  }

  /**
  * El presente metodo devuelve un booleano indicando si este objeto le mete a
  *  su atacado, o no, un ataque con bola de fuego. El atacado es un objeto
  *  Peleable y por ende pueden ser atacados tanto objetos Personaje como NPC's.
  * @param caster Objeto Personaje el cual ataca.
  * @param atacado Objeto Peleable el cual es el atacado.<br>Puede ser atacado
  * @return Booleano que indica si se ejecuta un ataque con bola de fuego.
  */
  public boolean habilidad1(Personaje caster, Peleable atacado) {
    if (caster.getEnergia() > ENERGIA_MINIMA) { 
      caster.bajarEnergia(ENERGIA_MINIMA);
      if (atacado.serAtacado((int) (caster.calcularPuntosDeMagia()
          * PLUS_MAGIA)) > ATAQUE_NULO) {
        return true;
      }
    }
    return false;
  }

  
  /**
  * El presente metodo devuelve un booleano indicando si este objeto puede,
  * o no, curar a un aliado o a si mismo.
  * @param caster Objeto Personaje el cual intenta curar.
  * @param aliado Objeto Peleable el cual es al que se intenta curar.<br>Puede
  * @return Booleano que indica si se ejecuta el heal sobre el aliado o sobre
  */
  public boolean habilidad2(Personaje caster, Peleable aliado) {
    if (caster.getEnergia() > ENERGIA_MINIMA) {
      caster.bajarEnergia(ENERGIA_MINIMA);
      if (((PersonajePadre)aliado).esPersonaje() == true) {
        ((Personaje) aliado).serCurado(caster.calcularPuntosDeMagia());
        return true;
      }
    }
    return false;
  }

  /**
  * El presente metodo devuelve un booleano indicando si este objeto puede,
  * o no, robar energia y salud al objeto atacado.
  * @param caster Objeto Personaje el cual ataca.
  * @param atacado Objeto Peleable el cual es el atacado.
  * @return Booleano que indica si se ejecuta el robo de energia y salud, o no.
  */
  public boolean habilidad3(Personaje caster, Peleable atacado) {
    if (caster.getEnergia() > ENERGIA_MINIMA) {
      caster.bajarEnergia(ENERGIA_MINIMA);
      if (((PersonajePadre)atacado).esPersonaje() == true) {
        int energiaRobada = ((Personaje) atacado).serDesernegizado(
            caster.calcularPuntosDeMagia());
        int saludRobada = ((Personaje) atacado).serRobadoSalud(
            caster.calcularPuntosDeMagia() / 2);
        caster.serEnergizado(energiaRobada);
        caster.serCurado(saludRobada);
        return true; 
      }      
    }    
    return false;
  }
}
