package dominio;

/**
 * 
 * El proposito de la clase Orco es poder crear instancias con los atributos de 
 * saludTope, salud, energia, y nombreRaza. Con los metodos correspondientes a este personaje
 *
 */

public class Orco extends Personaje {

	public Orco(String nombre, Casta casta, int id) {
		super(nombre, casta, id);
		saludTope += 10;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Orco";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Defensa";
		habilidadesRaza[1] = "Mordisco de Vida";
	}

	public Orco(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel, int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		nombreRaza = "Orco";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Defensa";
		habilidadesRaza[1] = "Mordisco de Vida";
	}

	/**
	 * 
	 * Este metodo permite al orco realizar el "golpe de defensa" si tiene energia mayor a 10
	 * 
	 * en caso a firmativo, le resta 10 de energia, 
	 * y luego verifica si la defensa del orco * 2, es mayor a 0 
	 * si esto esto ocurre, efectua la habilidad con exito
	 * 
	 * @param atacado del tipo Peleable
	 * @return true o false del tipo boolean
	 * 
	 */
	public boolean habilidadRaza1(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			if (atacado.serAtacado(this.getDefensa() * 2) > 0)
				return true;
		}
		return false;
	}

	/**
	 * Este metodo permite al orco realizar el "Mordisco de vida"  si tiene la energia mayor a 10
	 * en caso a firmativo, le resta 10 de energia, 
	 * 
	 * el orco se podra curar el solo si tiene fuerza mayor a 0, y devolvera true
	 * 
	 * en caso de que tenga energia menor a 10, devuelve false
	 * 
	 * @param atacado del tipo Peleable
	 * @return true o false del tipo boolean
	 */
	
	public boolean habilidadRaza2(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			int daño_causado = atacado.serAtacado(this.getFuerza());
			if (daño_causado > 0) {
				this.serCurado(daño_causado);
				return true;
			}
		}
		return false;
	}
}
