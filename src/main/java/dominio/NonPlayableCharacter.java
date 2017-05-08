package dominio;

public class NonPlayableCharacter extends PersonajePadre implements Peleable {

	
	private static final int dificultadAleatoria = -1;
/**<p>
 *  Construye al NPC a partir de una dificultad Aleatoria estatica dada,
 *  si la dificultad aleatoria del parametro es igual a la aleatoria, le asignara
 *  un valor random entre 1 y 3 para setear los valores de fuerza, defensa y salud que seran
 *  distintos dependiendo del valor obtenido.
   </p>
 */
	public NonPlayableCharacter(String nombre, int nivel, int dificultadNPC) {
		super (nombre);
		this.nivel = nivel;
		int dificultad;
		if (dificultadNPC == dificultadAleatoria)
			dificultad = MyRandom.nextInt(3);
		else
			dificultad = dificultadNPC;

		switch (dificultad) {
		case 0:
			this.fuerza = 10 + (nivel - 1) * 3;
			this.salud = 30 + (nivel - 1) * 15;
			this.defensa = 2 + (nivel - 1) * 1;
			break;
		case 1:
			this.fuerza = 20 + (nivel - 1) * 6;
			this.salud = 40 + (nivel - 1) * 20;
			this.defensa = 5 + (nivel - 1) * 2;
			break;
		case 2:
			this.fuerza = 30 + (nivel - 1) * 10;
			this.salud = 50 + (nivel - 1) * 25;
			this.defensa = 4 + (nivel - 1) * 4;
			break;

		}
	}

	public int otorgarExp() {
		return this.nivel * 30;
	}

	
	/**
	 * 
	 * <p> 
	 * La probabilidad de golpe critico para todos los NPC sera del 15%, por lo que siempre que obtenga un valor
	 * de da�o menor, este se incrementara en un 50%.
	 * De lo contrario, el ataque estara basado en la fuerza del NPC.
	 * </p>
	 * 
	 */
	
	public int atacar(Peleable atacado) {
		if (MyRandom.nextDouble() <= 0.15) {
			return atacado.serAtacado((int) (this.getAtaque() * 1.5));
		} else
			return atacado.serAtacado(this.getAtaque());
	}
	/**
	 * 
	 * <p> cuando ataquen al NPC, el da�o se calcula en base a su defensa, pero esta sera la mitad que la de un personaje jugable.
	 *	Si la defensa es mayor que su da�o no recibira el golpe.
	 * 	si el da�o es mayor a la salud , su salud quedara en 0 sino se le restara el da�o.
	 * </p>
	 * 
	 */

	public int serAtacado(int daño) {
		if (MyRandom.nextDouble() >= 0.15) {
			daño -= this.getDefensa() / 2;
			if (daño > 0) {
				salud -= daño;
				return daño;
			}
			return 0;
		}
		return 0;
	}

	public void despuesDeTurno() { }

	public void ganarExperiencia(int exp) {

	}
	
	                        
	
	public int getAtaque() {
	    return fuerza;
	}                        
	
	public void setAtaque(int ataque) {
	    this.fuerza = ataque;
	}

	
}
