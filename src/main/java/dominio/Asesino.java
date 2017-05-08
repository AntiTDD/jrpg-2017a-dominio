package dominio;

  /**
  * Casta del personaje. Cualquier personaje puede tener cualquier casta y esta
  * clase es la de casta Asesino.<br>Ejemplo: Un Personje Orco puede ser tanto
  * de casta Asesino, como Guerrero o Hechicero. Idem para los personajes
  * Elfo y Humano.
  */
  public class Asesino extends Casta {
	  
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int ENERGIA_MINIMA = 10;
	private final float PLUS_EVITAR_CRITICO =0.15f;
	private final float PLUS_EVITAR_DAÑO = 0.5f;

  /**
  * Constructor de objetos de profesion Asesino.
  * @param prob_crit Double que indica la probabilidad de meter un critico que
  * tiene este objeto.
  * @param evasion Double que indica la evasion que tiene este objeto.
  * @param da�o_crit Double que indica el da�o critico que tiene este objeto.
  */
  public Asesino(double prob_crit, double evasion, double daño_crit) {
    super(prob_crit, evasion, daño_crit);
    this.nombreCasta = "Asesino";
  }
  

  /**
  * Constructor de objetos de profesion Asesino.
  */
  public Asesino() {
    super();
    this.nombreCasta = "Asesino";
    final int cantTotalDeHabilidadesDeCasta = 3;
    habilidadesCasta = new String[cantTotalDeHabilidadesDeCasta];
    habilidadesCasta[0] = "Golpe Critico";
    habilidadesCasta[1] = "Aumentar Evasion";
    habilidadesCasta[2] = "Robar";
  }

  /**
  * El presente metodo devuelve un booleano indicando si este objeto de casta
  * Asesino le mete, o no, un golpe critico al atacado.
  * @param caster Objeto Personaje el cual ataca.
  * @param atacado Objeto Peleable el cual es el atacado. Puede ser atacado
  * tanto un Personaje como un NPC, por �sto es un objeto Peleable.
  * @return Booleano que indica si se ejecuta un golpe critico.
  */
  public boolean habilidad1(Personaje caster, Peleable atacado) {
    if (caster.getEnergia() > ENERGIA_MINIMA) {  
      caster.setEnergia(caster.getEnergia() - ENERGIA_MINIMA);
      if (atacado.serAtacado((int) (caster.ataque * caster.getCasta().getDañoCritico())) > 0) {
        return true;
      }
    }
    return false;
  }

  /**
  * El presente metodo devuelve un booleano indicando si este objeto puede
  * incrementar, o no, la evasion del objeto Peleable que es el objeto a
  * quien se le intenta subir la evasion.
  * @param caster Objeto Personaje el cual intenta subir la evasion.
  * @param atacado Objeto Peleable al cual se le intenta subir la evasion.
  * Esta evasion puede llegar a s� mismo, a cualquier objeto Personaje como
  * a un NPC.
  * @return Booleano que indica si este objeto pudo subir la evasion a su
  * objeto destinatario.
  */
  public boolean habilidad2(Personaje caster, Peleable atacado) {
    if (caster.getEnergia() > ENERGIA_MINIMA) {
      caster.setEnergia(caster.getEnergia() - ENERGIA_MINIMA);
      if (this.getProbabilidadEvitarDaño() + PLUS_EVITAR_CRITICO < PLUS_EVITAR_DAÑO) {
        this.probabilidadEvitarDaño += PLUS_EVITAR_CRITICO;
      } else {
        this.probabilidadEvitarDaño = PLUS_EVITAR_DAÑO;
      }
      return true;
    }
    return false;
  }

  /**
  * El presente metodo devuelve un booleano indicando si este objeto puede,
  * o no, robar al objeto atacado.
  * @param caster Objeto de tipo Personaje el cual es quien ataca.
  * @param atacado Objeto de tipo Peleable el cual es el atacado.
  * @return Booleano que indica si este objeto pudo realizar el robo, o no.
  */
  public boolean habilidad3(Personaje caster, Peleable atacado) {
    return false;
  }

  public void mejorarAtributoCasta(Personaje personaje) {
  }
}
