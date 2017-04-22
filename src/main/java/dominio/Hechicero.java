package dominio;

/** * Casta del personaje. Cualquier personaje puede tener cualquier casta y 
 * esta clase es la de casta Hechocero. * Ejemplo: Un Personje Orco puede ser 
 * tanto de casta Asesino, como Guerrero o Hechicero. Idem para los personajes 
 * Elfo y Humano. 
 * 
 * 
 * 
 * */
public class Hechicero extends Casta {

	public Hechicero(double prob_crit, double evasion, double daño_crit) {
		super(prob_crit, evasion, daño_crit);
		this.nombreCasta = "Hechicero";
	}

	public Hechicero() {
		super();
		this.nombreCasta = "Hechicero";
		habilidadesCasta = new String[3];
		habilidadesCasta[0] = "Bola de Fuego";
		habilidadesCasta[1] = "Curar Aliado";
		habilidadesCasta[2] = "Robar Energia y Salud";
	}
/** * El presente metodo devuelve un booleano indicando si este 
 * objeto de casta Hechicero le mete a su atacado, * o no, un ataque con bola de fuego. 
 * El atacado es un objeto Peleable y por ende pueden ser atacados tanto
 * objetos Personaje como NPC's. 
 * @param caster Objeto Personaje el cual ataca. 
 * @param atacado Objeto Peleable el cual es el atacado.
 * <br>
 * Puede ser atacado tanto un Personaje como un NPC, 
 * por ésto es un objeto Peleable.
 * @return Booleano que indica si se ejecuta un ataque con bola de fuego. 
 * 
 * 
 * 
 * */
	// Bola de Fuego
	public boolean habilidad1(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado((int) (caster.calcularPuntosDeMagia() * 1.5)) > 0)
				return true;
		}
		return false;
	}
/** * El presente metodo devuelve un booleano indicando si este objeto de 
 * casta Hechicero puede, o no, curar a * un aliado o a si mismo. 
 * @param caster Objeto Personaje el cual intenta curar. 
 * @param atacado Objeto Peleable el cual es al que se intenta atacar.
 * <br>
 * Puede ser atacado tanto un Personaje como un NPC, por ésto es un objeto Peleable.
 * @return Booleano que indica si se ejecuta el heal sobre el aliado o sobre sí mismo. 
 * 
 * 
 * 
 * */
	// Curar Aliado
	public boolean habilidad2(Personaje caster, Peleable aliado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (aliado instanceof Personaje) {
				((Personaje) aliado).serCurado(caster.calcularPuntosDeMagia());
				return true;
			}
		}
		return false;
	}

	// Robar Energia y Salud
	public boolean habilidad3(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado instanceof Personaje) {
				int energia_robada = ((Personaje) atacado).serDesernegizado(caster.calcularPuntosDeMagia());
				int salud_robada = ((Personaje) atacado).serRobadoSalud(caster.calcularPuntosDeMagia() / 2);
				caster.serEnergizado(energia_robada);
				caster.serCurado(salud_robada);
				return true;
			}

		}
		return false;
	}
}
