package dominio;
/** * Casta del personaje. Cualquier personaje puede tener cualquier casta 
 * y esta clase es la de casta Asesino. * Ejemplo: Un Personje Orco puede 
 * ser tanto de casta Asesino, como Guerrero o Hechicero. 
 * Idem para los personajes * Elfo y Humano. 
 * 
 * 
 * */
public class Asesino extends Casta {

	public Asesino(double prob_crit, double evasion, double daño_crit) {
		super(prob_crit, evasion, daño_crit);
		this.nombreCasta="Asesino";
	}

	public Asesino() {
		super();
		this.nombreCasta="Asesino";
		habilidadesCasta = new String[3];
		habilidadesCasta[0] = "Golpe Critico";
		habilidadesCasta[1] = "Aumentar Evasion";
		habilidadesCasta[2] = "Robar";
	}

/** * El presente metodo devuelve un booleano indicando 
 * si este objeto de casta Asesino le mete, o no, 
 * un golpe * critico al atacado. 
 * @param caster Objeto Personaje el cual ataca. 
 * @param atacado Objeto Peleable el cual es el atacado.
 *  Puede ser atacado tanto un Personaje como un NPC, 
 *  por ésto es un objeto Peleable. 
 *  @return Booleano que indica si se ejecuta un golpe critico.
 *  
 *   
 *  */
	public boolean habilidad1(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado((int) (caster.ataque * caster.getCasta().getDañoCritico())) > 0)
				return true;
		}
		return false;
	}
/** * El presente metodo abstracto devuelve un booleano indicando si este 
 * objeto de casta Asesino puede * incrementar, o no, la evasion del objeto Peleable 
 * que es el objeto a quien se le intenta subir la evasion. 
 * @param caster Objeto Personaje el cual intenta subir la evasion. 
 * @param atacado Objeto Peleable al cual se le intenta subir la evasion. 
 * Esta evasion puede llegar a sí mismo, a cualquier objeto Personaje como a un NPC. 
 * @return Booleano que indica si este objeto pudo subir la evasion a su objeto destinatario. 
 * 
 * 
 * 
 * */
	public boolean habilidad2(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (this.getProbabilidadEvitarDaño() + 0.15 < 0.5)
				this.probabilidadEvitarDaño += 0.15;
			else
				this.probabilidadEvitarDaño = 0.5;
			return true;
		}
		return false;
	}

	public boolean habilidad3(Personaje caster, Peleable atacado) {
		return false;
	}
}
