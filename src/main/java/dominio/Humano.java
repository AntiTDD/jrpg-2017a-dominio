package dominio;

/**
 * El proposito de la clase Humano es poder crear instancias con los atributos de 
 * saludTope, energiaTope, salud, energia, y nombreRaza. Con los metodos correspondientes a este personaje
 * 
 *
 */

public class Humano extends Personaje {

	public Humano(String nombre, Casta casta, int id) {
		super(nombre, casta, id);
		saludTope += 5;
		energiaTope += 5;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Humano";
	}

	public Humano(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel, int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		nombreRaza = "Humano";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Incentivar";
		habilidadesRaza[1] = "Golpe Fatal";
	}

	/**
	 * Este metodo permite usar la habilidad "Incentivar" si la energia del humano es mayor a 10
	 * en caso afirmativo, le resta 10 de energia al ser atacado, y ademas, le suma al nivel de ataque del atacado,
	 * el nivel de magia del humano
	 * 
	 * de lo contrario, devuelve que el humano no puede atacar
	 * 
	 * 
	 * @param atacado de tipo Peleable
	 * @return true o false de tipo boolean 
	 */

	public boolean habilidadRaza1(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			atacado.setAtaque(atacado.getAtaque() + this.getMagia());
			return true;
		}
		return false;
	}

	/**
	 * Este metodo permite usar la habilidad "Golpe Fatal" si la energia del humano es mayor a 10
	 * y ademas la salud del atacado divido 2 es mayor a 0
	 * 
	 * en caso afirmativo, retorna que se puede efectuar la habilidad y le resta 10 a la energia del humano
	 * 
	 * en caso negativo, le resta 10 a la energia del humano y retorna que no puede efectuar la habilidad
	 * 
	 * 
	 * @param atacado de tipo Peleable
	 * @return true o false de tipo boolean 
	 */
	
	public boolean habilidadRaza2(Peleable atacado) {
		if (this.getEnergia() > 10) {
			if (atacado.serAtacado(atacado.getSalud() / 2) > 0) {
				this.setEnergia(this.getEnergia() / 2);
				return true;
			}
		}
		this.setEnergia(this.getEnergia() - 10);
		return false;
	}
}
