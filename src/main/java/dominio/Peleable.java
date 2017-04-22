package dominio;
/**
 * 
 * <p> Interfaz (Contrato) que define las acciones que tendran los
 * 		Personajes ,no se pueden instanciar. Sus m�todos deben ser re-escritos por la clase que las implemente
 * 		Por ende cada personaje las podra definir a su manera.</p>
 * 
 */
public interface Peleable {
	/**
	 * 
	 * <p> Da�o que recibira el personaje cuando lo ataquen</p>
	 * 
	 */
	public int serAtacado(int da�o);
	
	/**
	 * 
	 * <p> Devuelve la salud</p>
	 * 
	 */
	public int getSalud();
	
	public void despuesDeTurno();
	public int atacar(Peleable atacado);
	public int otorgarExp();
	public int getAtaque();
	public void setAtaque(int ataque);
	public boolean estaVivo();
	public String getNombre();
}
