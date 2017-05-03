package dominio;

/** * Casta del personaje. Cualquier personaje puede tener cualquier casta y 
 * esta clase es la de casta Guerrero. 
 * Ejemplo: Un Personje Orco puede ser tanto de casta Asesino, como Guerrero o 
 * Hechicero. Idem para los personajes * Elfo y Humano.
 * 
 */ 
 public class Guerrero extends Casta {

	public Guerrero(double prob_crit, double evasion, double daño_crit) {
		super(prob_crit, evasion, daño_crit);
		this.nombreCasta = "Guerrero";
	}

	public Guerrero() {
		super();
		this.nombreCasta = "Guerrero";

		habilidadesCasta = new String[3];
		habilidadesCasta[0] = "Ataque Doble";
		habilidadesCasta[1] = "Aumentar Defensa";
		habilidadesCasta[2] = "Ignorar Defensa";
	}
/** * El presente metodo devuelve un booleano indicando si este objeto
 *  de casta Guerrero le mete, o no, * un ataque doble a su oponente
 *   que es un objeto Peleable. 
 *   @param caster Objeto Personaje el cual ataca. 
 *   @param atacado Objeto Peleable el cual es el atacado.
 *   <br>
 *   Puede ser atacado tanto un Personaje como un NPC, por ésto es un objeto Peleable. 
 *   @return Booleano que indica si se ejecuta un ataque doble. 
 *   
 *   
 *   */
	public boolean habilidad1(Personaje caster, Peleable atacado) { 
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado(caster.ataque * 2) > 0)
				return true;
		}
		return false;
	}
/** * El presente metodo devuelve un booleano indicando si este objeto
 *  de casta Guerrero puede aumentar la defensa del objeto Peleable que 
 *  es el destinatario. Por ser el destinatario un objeto Peleable, éste puede 
 *  ser cualquier objeto Personaje, como NPC o sí mismo. 
 *  @param caster Objeto Personaje el cual intenta subir la defensa. 
 *  @param atacado Objeto Peleable al cual se le intenta subir la defensa.
 *  <br>
 *  La defensa puede ser aumentada tanto a un Personaje, 
 *  como un NPC o sí mismo, por ésto es un objeto Peleable. 
 *  @return Booleano que indica si se ejecuta el aumento de la defensa. 
 *  
 *  
 *  
 *  */
	public boolean habilidad2(Personaje caster, Peleable atacado) { 
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			caster.setDefensa(caster.getDefensa() + caster.magia);
			return true;
		}
		return false;
	}
	
	public boolean habilidad3(Personaje caster, Peleable atacado) { 
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado instanceof Personaje) {
				int defensa_original = ((Personaje) atacado).getDefensa();
				((Personaje) atacado).setDefensa(0);
				if (atacado.serAtacado(caster.ataque) > 0) {
					((Personaje) atacado).setDefensa(defensa_original);
					return true;
				}
			}

		}
		return false;
	}
}
