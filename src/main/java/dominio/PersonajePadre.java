package dominio;

public abstract class PersonajePadre implements Peleable{

  private String nombre;  
  protected int salud;
  protected int defensa;
  protected int fuerza;
  protected int nivel;

  public PersonajePadre(final String nom) {
    this.nombre = nom;
  }



  public int getSalud() {
    return salud;
  }

  public void setSalud(final int salud) {
    this.salud = salud;
  }

  public int getDefensa() {
    return defensa;
  }
 

  public void setDefensa(final int defensa) {
    this.defensa = defensa;
  } 

  public int getFuerza() {
    return fuerza;
  }

  public void setFuerza(final int fuerza) {
    this.fuerza = fuerza;
  }

  public int getNivel() {
    return nivel;
  }

  public void setNivel(final int nivel) {
    this.nivel = nivel;
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

}
