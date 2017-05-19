package dominio;

public abstract class PersonajePadre implements Peleable{

  protected String nombre;  
  protected int salud;
  protected int defensa;
  protected int fuerza;
  protected int nivel;
  protected MyRandom aleatorizador;

  public PersonajePadre(final String nom) {
    nombre = nom;
    aleatorizador = new MyRandom();
  }



  public int getSalud() {
    return salud;
  }
  
  /*
  public void setSalud(final int salud) {
    this.salud = salud;
  }
  */

  public int getDefensa() {
    return defensa;
  }
 
  /*
  public void setDefensa(final int defensa) {
    this.defensa = defensa;
  } 
  */
  
  public void subirDefensa(int plus) {
	 defensa += plus;
  }
  
  public void bajarDefensa(int reduccion) {
	 defensa -= reduccion;
  }
  
  
  public int getFuerza() {
    return fuerza;
  }
  /*
  public void setFuerza(final int fuerza) {
    this.fuerza = fuerza;
  }
  */
  
  public void subirFuerza(int plus) {
    fuerza += plus;
  }
  
  public int getNivel() {
    return nivel;
  }

  /*
  public void setNivel(final int nivel) {
    this.nivel = nivel;
  }
   */
  
  public boolean estaVivo() {
    return salud > 0;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  
  public abstract boolean esPersonaje();
  
  public void setTipoDeRandom(MyRandomStub aleatorizadorParaTesteos) {
    aleatorizador = aleatorizadorParaTesteos;
  }

}
