package dominio;

public class Elfo extends Personaje {
	/**
	 * 
	 * <p> Constructor de la Clase Elfo hereda atributos basicos de personaje </p>
	 * 
	 */
	public Elfo(String nombre, Casta casta, int id) {
		super(nombre, casta, id);
		energiaTope += 10;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Elfo";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Level";
		habilidadesRaza[1] = "Ataque Bosque";
	}
	
	/**
	 * 
	 * <p>Segundo Constructor de la Clase Elfo hereda de personaje </p>
	 * 
	 */

	public Elfo(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel,
			int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta,
				experiencia, nivel, idPersonaje);
		nombreRaza = "Elfo";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Level";
		habilidadesRaza[1] = "Ataque Bosque";
	}
	
	/**
	 * 
	 * <p> Si la energia es mayor a 10 podra usar la habilidad golpe level
	 * 		restandole 10 de energia, en el cual al daño de su ataque,
	 * 		se le suma como daño su nivel actual * 10  </p>
	 * 
	 */
	// Golpe Level
	public boolean habilidadRaza1(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			if (atacado.serAtacado(this.getFuerza() + this.getNivel() * 10) > 0)
				return true;
		}
		return false;
	}
	
	/**
	 * 
	 * <p> Si la energia es mayor a 10 podra usar la habilidad Ataque Bosque
	 * 		restandole 10 de energia, inflingiendo daño Magico </p>
	 * 
	 */

	// Ataque Bosque
	public boolean habilidadRaza2(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			if (atacado.serAtacado((int) (this.magia)) > 0)
				return true;
		}
		return false;
	}
}
