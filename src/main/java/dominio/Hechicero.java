package dominio;

  /**
  * Casta del personaje. Cualquier personaje puede tener cualquier casta y esta
  * clase es la de casta Hechocero.<br>Ejemplo: Un Personje Orco puede ser tanto
  * de casta Asesino, como Guerrero o Hechicero. Idem para los personajes Elfo y
  * Humano.
  */
  public class Hechicero extends Casta {

  /**
  * Constructor de objetos de profesion Guerrero.
  * @param prob_crit Double que indica la probabilidad de meter un critico que
  * tiene este objeto.
  * @param evasion Double que indica la evasion que tiene este objeto.
  * @param daño_crit Double que indica el daño critico que tiene este objeto.
  */
  public Hechicero(double prob_crit, double evasion, double daño_crit) {
    super(prob_crit, evasion, daño_crit);
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
  * tanto un Personaje como un NPC, por ésto es un objeto Peleable.
  * @return Booleano que indica si se ejecuta un ataque con bola de fuego.
  */
  public boolean habilidad1(Personaje caster, Peleable atacado) {
    final int diez = 10;
    if (caster.getEnergia() > diez) { 
      caster.setEnergia(caster.getEnergia() - diez);
      final float unoPuntoCinco = 1.5f;
      final int cero = 0;
      if (atacado.serAtacado((int) (caster.calcularPuntosDeMagia()
        * unoPuntoCinco)) > cero) {
        return true;
      }
    }
    return false;
  }
  
 public void mejorarAtributoCasta(Personaje personaje){
	  personaje.setInteligencia(personaje.getInteligencia() + 5);
  }

  
  /**
  * El presente metodo devuelve un booleano indicando si este objeto puede,
  * o no, curar a un aliado o a si mismo.
  * @param caster Objeto Personaje el cual intenta curar.
  * @param aliado Objeto Peleable el cual es al que se intenta curar.<br>Puede
  * ser curado tanto un Personaje como un NPC, por ésto es un objeto Peleable.
  * @return Booleano que indica si se ejecuta el heal sobre el aliado o sobre
  * sí mismo.
  */
  public boolean habilidad2(Personaje caster, Peleable aliado) {
    final int diez = 10;
    if (caster.getEnergia() > diez) {
      caster.setEnergia(caster.getEnergia() - diez);
      ((Personaje) aliado).serCurado(caster.calcularPuntosDeMagia());
        return true;
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
    final int diez = 10;
    if (caster.getEnergia() > diez) {
      caster.setEnergia(caster.getEnergia() - diez);
      
      int energia_robada = ((Personaje) atacado).serDesernegizado(caster.calcularPuntosDeMagia());
      final int dos = 2;
      
      int salud_robada = ((Personaje) atacado).serRobadoSalud(
      
      caster.calcularPuntosDeMagia() / dos);
      caster.serEnergizado(energia_robada);
      caster.serCurado(salud_robada);
      return true;
    }
    
    return false;
  }
}
