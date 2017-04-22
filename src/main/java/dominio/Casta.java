package dominio;

import java.io.Serializable;
/** * Clase abstracta que engloba la casta a la que pertenece cada personaje en el juego.<br>
 *@param probabilidadGolpeCritico Un Double que representa la probabilidad que tiene el 
 *personaje de asestar un golpe critico. 
 *@param probabilidadEvitarDaño Un Double que representa la probabilidad que tiene 
 *el personaje de evitar el daño que otro personaje le atenta. 
 *@param dañoCrtico Un Double que representa el poder del golpe critico del 
 *personaje al asestar uno. 
 *@param nombreCasta Un String que representa el nombre de la casta a 
 *la que pertenece el personaje, 
 *
 *
 **/
public abstract class Casta implements Serializable {
	protected double probabilidadGolpeCritico;
	protected double probabilidadEvitarDaño;
	protected double dañoCritico;
	protected String nombreCasta;

	protected String[] habilidadesCasta;

	public Casta() {
		this.probabilidadGolpeCritico = 0.2;
		this.probabilidadEvitarDaño = 0.2;
		this.dañoCritico = 1.5;
	}

	public Casta(double prob_crit, double evasion, double daño_crit) {
		this.probabilidadGolpeCritico = prob_crit;
		this.probabilidadEvitarDaño = evasion;
		this.dañoCritico = daño_crit;
	}
/** * El presente metodo abstracto devuelve un booleano indicando si la 
 * habilidad1 pudo ser llevada a cabo o no. * <br>Por ser metodo 
 * abstracto, esta habilidad muy posiblemente tenga comportamientos distintos 
 * en las distintas clases * que extiendan a esta clase. 
 * @param caster Objeto Personaje el cual ataca. * @param atacado Objeto Peleable el 
 * cual es el atacado. Puede ser atacado tanto un Personaje como un NPC, por ésto es un 
 * objeto Peleable. * @return Booleano que indica si se ejecuta la habilidad1, o no. 
 * 
 * 
 * */
	public abstract boolean habilidad1(Personaje caster, Peleable atacado);
/** * El presente metodo abstracto devuelve un booleano indicando si la habilidad2 
 * pudo ser llevada a cabo o no. 
 * <br>
 * Por ser metodo abstracto, esta habilidad muy 
 * posiblemente tenga comportamientos distintos en las distintas clases 
 * que extiendan a esta clase. 
 * @param caster Objeto Personaje el cual ataca. 
 * @param atacado Objeto Peleable el cual es el atacado. 
 * Puede ser atacado tanto un Personaje como un NPC, por ésto es un objeto Peleable. 
 * @return Booleano que indica si se ejecuta la habilidad2, o no. 
 * 
 * 
 * */
	public abstract boolean habilidad2(Personaje caster, Peleable atacado);

	public abstract boolean habilidad3(Personaje caster, Peleable atacado);

	public String getNombreCasta() {
		return this.nombreCasta;
	}

	public String[] getHabilidadesCasta() {
		return habilidadesCasta;
	}

	public double getProbabilidadGolpeCritico() {
		return probabilidadGolpeCritico;
	}

	public void setProbabilidadGolpeCritico(double probabilidadGolpeCritico) {
		this.probabilidadGolpeCritico = probabilidadGolpeCritico;
	}

	public double getProbabilidadEvitarDaño() {
		return probabilidadEvitarDaño;
	}

	public void setProbabilidadEvitarDaño(double probabilidadEvitarDaño) {
		this.probabilidadEvitarDaño = probabilidadEvitarDaño;
	}

	public double getDañoCritico() {
		return dañoCritico;
	}

	public void setDañoCritico(double dañoCritico) {
		this.dañoCritico = dañoCritico;
	}
}
