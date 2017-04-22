package dominio;

import java.io.Serializable;
/** * Clase abstracta que engloba la casta a la que pertenece cada personaje en el juego.<br>
 *@param probabilidadGolpeCritico Un Double que representa la probabilidad que tiene el 
 *personaje de asestar un golpe critico. 
 *@param probabilidadEvitarDa�o Un Double que representa la probabilidad que tiene 
 *el personaje de evitar el da�o que otro personaje le atenta. 
 *@param da�oCrtico Un Double que representa el poder del golpe critico del 
 *personaje al asestar uno. 
 *@param nombreCasta Un String que representa el nombre de la casta a 
 *la que pertenece el personaje, 
 *
 *
 **/
public abstract class Casta implements Serializable {
	protected double probabilidadGolpeCritico;
	protected double probabilidadEvitarDa�o;
	protected double da�oCritico;
	protected String nombreCasta;

	protected String[] habilidadesCasta;

	public Casta() {
		this.probabilidadGolpeCritico = 0.2;
		this.probabilidadEvitarDa�o = 0.2;
		this.da�oCritico = 1.5;
	}

	public Casta(double prob_crit, double evasion, double da�o_crit) {
		this.probabilidadGolpeCritico = prob_crit;
		this.probabilidadEvitarDa�o = evasion;
		this.da�oCritico = da�o_crit;
	}
/** * El presente metodo abstracto devuelve un booleano indicando si la 
 * habilidad1 pudo ser llevada a cabo o no. * <br>Por ser metodo 
 * abstracto, esta habilidad muy posiblemente tenga comportamientos distintos 
 * en las distintas clases * que extiendan a esta clase. 
 * @param caster Objeto Personaje el cual ataca. * @param atacado Objeto Peleable el 
 * cual es el atacado. Puede ser atacado tanto un Personaje como un NPC, por �sto es un 
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
 * Puede ser atacado tanto un Personaje como un NPC, por �sto es un objeto Peleable. 
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

	public double getProbabilidadEvitarDa�o() {
		return probabilidadEvitarDa�o;
	}

	public void setProbabilidadEvitarDa�o(double probabilidadEvitarDa�o) {
		this.probabilidadEvitarDa�o = probabilidadEvitarDa�o;
	}

	public double getDa�oCritico() {
		return da�oCritico;
	}

	public void setDa�oCritico(double da�oCritico) {
		this.da�oCritico = da�oCritico;
	}
}
