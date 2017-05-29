package dominio;

public abstract class PersonajePadre implements Peleable {

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

  public int getDefensa() {
    return defensa;
  }
  
  public void subirDefensa(int plus) {
    defensa += plus;
  }
  
  public void bajarDefensa(int reduccion) {
    defensa -= reduccion;
  }
  
  
  public int getFuerza() {
    return fuerza;
  }
  
  public void subirFuerza(int plus) {
    fuerza += plus;
  }
  
  public int getNivel() {
    return nivel;
  }
  
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
