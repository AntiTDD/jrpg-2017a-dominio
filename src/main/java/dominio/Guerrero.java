package dominio;

/**
 * Casta del personaje. Cualquier personaje puede tener cualquier casta y esta
 * clase es la de casta Guerrero. Ejemplo: Un Personje Orco puede ser tanto de
 * casta Asesino, como Guerrero o Hechicero. Idem para los personajes Elfo y
 * Humano.
 */
public class Guerrero extends Casta {

  private final int energiaMinima = 10; 
  private final int plusAtaque = 2;
  private final int vidaNula = 0;
  private final int defensaNula = 0;
  /**
  * Constructor de objetos de profesion Guerrero.
  * @param prob_crit Double que indica la probabilidad de meter un critico que
  * @param evasion Double que indica la evasion que tiene este objeto.
  * 
  * @param daño_crit Double que indica el da�o critico que tiene este objeto.
  */
  public Guerrero(double prob_crit, double evasion, double daño_crit) {
    super(prob_crit, evasion, daño_crit);
    this.nombreCasta = "Guerrero";
  }


  /**
  * Constructor de objetos de profesion Asesino.
  */
  public Guerrero() {
    super();
    this.nombreCasta = "Guerrero";

    final int cantTotalDeHabilidades = 3;
    habilidadesCasta = new String[cantTotalDeHabilidades];
    habilidadesCasta[0] = "Ataque Doble";
    habilidadesCasta[1] = "Aumentar Defensa";
    habilidadesCasta[2] = "Ignorar Defensa";
  }

  
  /**
  * El presente metodo devuelve un booleano indicando si este objeto de casta
  * Guerrero le mete, o no, un ataque doble a su oponente que es un objeto
  * Peleable.
  * @param caster Objeto Personaje el cual ataca.
  * @param atacado Objeto Peleable el cual es el atacado.<br>Puede ser atacado
  * @return Booleano que indica si se ejecuta un ataque doble.
  */
  public boolean habilidad1(Personaje caster, Peleable atacado) {  
    if (caster.getEnergia() > energiaMinima) {
      caster.setEnergia(caster.getEnergia() - energiaMinima);
      if (atacado.serAtacado(caster.ataque * plusAtaque) > vidaNula) {
        return true;
      }
    }
    return false;
  }
  
  /**
  * El presente metodo devuelve un booleano indicando si este objeto puede
  * aumentar la defensa del objeto Peleable que es el destinatario. Por ser
  * el destinatario un objeto Peleable, �ste puede ser cualquier objeto
  * Personaje, como NPC o s� mismo.
  * @param caster Objeto Personaje el cual intenta subir la defensa.
  * @param atacado Objeto Peleable al cual se le intenta subir la defensa.<br>
  * @return Booleano que indica si se ejecuta el aumento de la defensa.
  */
  public boolean habilidad2(Personaje caster, Peleable atacado) {
    if (caster.getEnergia() > energiaMinima) {
      caster.setEnergia(caster.getEnergia() - energiaMinima);
      caster.setDefensa(caster.getDefensa() + caster.magia);
      return true;
    }
    return false;
  }
  
  /**
  * El presente metodo devuelve un booleano indicando si este objeto puede,
  * o no, atacar ignorando la defensa del objeto atacado.
  * @param caster Objeto de tipo Personaje el cual es quien ataca.
  * @param atacado Objeto de tipo Peleable el cual es el atacado.
  * @return Booleano que indica si este objeto pudo, o no, atacar al atacado
  */
  public boolean habilidad3(Personaje caster, Peleable atacado) {
    if (caster.getEnergia() > energiaMinima) {
      caster.setEnergia(caster.getEnergia() - energiaMinima);
      if (((PersonajePadre) atacado).esPersonaje() == true) {
    	  int defensa_original = ((Personaje) atacado).getDefensa(); //PREGUNTAR: El casteo deberia ser (PersonajePadre) y hacer que PersonajePadre sea abstracta y que implemente Peleable. En tanto, NPC como Personaje deberian extender solamente a PersonajePadre (sin imeplementar nada mas que Serializable).
          ((Personaje) atacado).setDefensa(defensaNula); 
          if (atacado.serAtacado(caster.ataque) > defensaNula) {
            ((Personaje) atacado).setDefensa(defensa_original);
            return true;
          }
      }      

    }
    return false;
  }
}
