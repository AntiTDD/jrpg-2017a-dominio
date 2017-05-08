package dominio;

  /**
  * Casta del personaje. Cualquier personaje puede tener cualquier casta y esta
  * clase es la de casta Guerrero. Ejemplo: Un Personje Orco puede ser tanto de
  * casta Asesino, como Guerrero o Hechicero. Idem para los personajes Elfo y
  * Humano.
  */
  public class Guerrero extends Casta {
	  
	  private final int ENERGIA_MINIMA = 10; 
	  private final int PLUS_ATAQUE = 2;
	  private final int VIDA_NULA = 0;
	  private final int DEFENSA_NULA = 0;
  /**
  * Constructor de objetos de profesion Guerrero.
  * @param prob_crit Double que indica la probabilidad de meter un critico que
  * tiene este objeto.
  * @param evasion Double que indica la evasion que tiene este objeto.
  * @param da�o_crit Double que indica el da�o critico que tiene este objeto.
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
   * Sobreescritura de la funcion abstracta para mejorar la fuerza del guerrero
   */
  
  public void mejorarAtributoCasta(Personaje personaje){
	  personaje.fuerza += personaje.casta.getBonusFuerza();
  }

  
  /**
  * El presente metodo devuelve un booleano indicando si este objeto de casta
  * Guerrero le mete, o no, un ataque doble a su oponente que es un objeto
  * Peleable.
  * @param caster Objeto Personaje el cual ataca.
  * @param atacado Objeto Peleable el cual es el atacado.<br>Puede ser atacado
  * tanto un Personaje como un NPC, por �sto es un objeto Peleable.
  * @return Booleano que indica si se ejecuta un ataque doble.
  */
  public boolean habilidad1(Personaje caster, Peleable atacado) {  
    if (caster.getEnergia() > ENERGIA_MINIMA) {
      caster.setEnergia(caster.getEnergia() - ENERGIA_MINIMA);
      if (atacado.serAtacado(caster.ataque * PLUS_ATAQUE) > VIDA_NULA) {
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
  * La defensa puede ser aumentada tanto a un Personaje, como un NPC o s� mismo,
  * por �sto es un objeto Peleable.
  * @return Booleano que indica si se ejecuta el aumento de la defensa.
  */
  public boolean habilidad2(Personaje caster, Peleable atacado) {
    if (caster.getEnergia() > ENERGIA_MINIMA) {
      caster.setEnergia(caster.getEnergia() - ENERGIA_MINIMA);
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
  * ignorando su defensa.
  */
  public boolean habilidad3(Personaje caster, Peleable atacado) {
    if (caster.getEnergia() > ENERGIA_MINIMA) {
      caster.setEnergia(caster.getEnergia() - ENERGIA_MINIMA);
     
    int defensa_original = ((Personaje) atacado).getDefensa();
    ((Personaje) atacado).setDefensa(DEFENSA_NULA); 
        if (atacado.serAtacado(caster.ataque) > DEFENSA_NULA) {
          ((Personaje) atacado).setDefensa(defensa_original);
          return true;
        }
      

    }
    return false;
  }
}
