package dominio;

  /**
  * Casta del personaje. Cualquier personaje puede tener cualquier casta y esta
  * clase es la de casta Guerrero. Ejemplo: Un Personje Orco puede ser tanto de
  * casta Asesino, como Guerrero o Hechicero. Idem para los personajes Elfo y
  * Humano.
  */
  public class Guerrero extends Casta {

  /**
  * Constructor de objetos de profesion Guerrero.
  * @param prob_crit Double que indica la probabilidad de meter un critico que
  * tiene este objeto.
  * @param evasion Double que indica la evasion que tiene este objeto.
  * @param daño_crit Double que indica el daño critico que tiene este objeto.
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

  // Ataque Doble
  /**
  * El presente metodo devuelve un booleano indicando si este objeto de casta
  * Guerrero le mete, o no, un ataque doble a su oponente que es un objeto
  * Peleable.
  * @param caster Objeto Personaje el cual ataca.
  * @param atacado Objeto Peleable el cual es el atacado.<br>Puede ser atacado
  * tanto un Personaje como un NPC, por ésto es un objeto Peleable.
  * @return Booleano que indica si se ejecuta un ataque doble.
  */
  public boolean habilidad1(Personaje caster, Peleable atacado) {
    final int diez = 10;
    if (caster.getEnergia() > diez) {  // PREGUNTAR: No se deberia tambien preguntar si el atacado tiene salud mayor a 0? O sea, en esta linea poner: "if(energia>10 && atacado.getSalud()>0" //
      caster.setEnergia(caster.getEnergia() - diez);
      final int dos = 2, cero = 0;
      if (atacado.serAtacado(caster.ataque * dos) > cero) {
        return true;
      }
    }
    return false;
  }

  // Aumentar Defensa
  /**
  * El presente metodo devuelve un booleano indicando si este objeto puede
  * aumentar la defensa del objeto Peleable que es el destinatario. Por ser
  * el destinatario un objeto Peleable, éste puede ser cualquier objeto
  * Personaje, como NPC o sí mismo.
  * @param caster Objeto Personaje el cual intenta subir la defensa.
  * @param atacado Objeto Peleable al cual se le intenta subir la defensa.<br>
  * La defensa puede ser aumentada tanto a un Personaje, como un NPC o sí mismo,
  * por ésto es un objeto Peleable.
  * @return Booleano que indica si se ejecuta el aumento de la defensa.
  */
  public boolean habilidad2(Personaje caster, Peleable atacado) {
    final int diez = 10;
    if (caster.getEnergia() > diez) {  // PREGUNTAR: No se deberia tambien preguntar si el atacado tiene salud mayor a 0? O sea, en esta linea poner: "if(energia>10 && atacado.getSalud()>0" //
      caster.setEnergia(caster.getEnergia() - diez);
      caster.setDefensa(caster.getDefensa() + caster.magia);
      return true;
    }
    return false;
  }

  // Ignorar Defensa
  /**
  * El presente metodo devuelve un booleano indicando si este objeto puede,
  * o no, atacar ignorando la defensa del objeto atacado.
  * @param caster Objeto de tipo Personaje el cual es quien ataca.
  * @param atacado Objeto de tipo Peleable el cual es el atacado.
  * @return Booleano que indica si este objeto pudo, o no, atacar al atacado
  * ignorando su defensa.
  */
  public boolean habilidad3(Personaje caster, Peleable atacado) {
    final int diez = 10;
    if (caster.getEnergia() > diez) {  // PREGUNTAR: No se deberia tambien preguntar si el atacado tiene salud mayor a 0? O sea, en esta linea poner: "if(energia>10 && atacado.getSalud()>0" //
      caster.setEnergia(caster.getEnergia() - diez);
      if (atacado instanceof Personaje) {
        int defensa_original = ((Personaje) atacado).getDefensa();
        final int cero = 0;
        ((Personaje) atacado).setDefensa(cero);  // NOTA: No me parece bien esta linea ya que momentaneamente le baja la defensa a 0 al atacado y, si esto corriese en un hilo y justo despues de ejecutar esta linea entra en ejecucion otro hilo que tambien este atacando a este mismo personaje, tambien recibiria otro golpe ignorandosele su defensa. //
        if (atacado.serAtacado(caster.ataque) > cero) {
          ((Personaje) atacado).setDefensa(defensa_original);
          return true;
        }
      }

    }
    return false;
  }
}
