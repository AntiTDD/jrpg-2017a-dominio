package dominio;

/**
 * Casta del personaje. Cualquier personaje puede tener cualquier casta y esta
 * clase es la de casta Guerrero. Ejemplo: Un Personje Orco puede ser tanto de
 * casta Asesino, como Guerrero o Hechicero. Idem para los personajes Elfo y
 * Humano.
 */
public class Guerrero extends Casta {

  private static final long serialVersionUID = 1L;
  private final int energiaMinima = 10;
  private final int plusAtaque = 2;
  private final int vidaNula = 0;
  private final int defensaNula = 0;
  /**
  * Constructor de objetos de profesion Guerrero.
  * @param probCrit Double que indica la probabilidad de meter un critico que
  * @param evasion Double que indica la evasion que tiene este objeto.
  *
  * @param dañoCrit Double que indica el da�o critico que tiene este objeto.
  */
  public Guerrero(double probCrit, double evasion, double dañoCrit) {
    super(probCrit, evasion, dañoCrit);
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
      caster.bajarEnergia(energiaMinima);
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
      caster.bajarEnergia(energiaMinima);
      caster.subirDefensa(caster.getMagia());
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
      caster.bajarEnergia(energiaMinima);
      if (((PersonajePadre) atacado).esPersonaje() == true) {
        int defensaOriginal = ((Personaje) atacado).getDefensa();
        ((Personaje) atacado).bajarDefensa(((Personaje) atacado).getDefensa());
        if (atacado.serAtacado(caster.ataque) > defensaNula) {
          ((Personaje) atacado).subirDefensa(defensaOriginal);
          return true;
        }
      }

    }
    return false;
  }
}
