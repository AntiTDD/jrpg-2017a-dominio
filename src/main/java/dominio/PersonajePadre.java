package dominio;

import java.util.HashSet;
import java.util.Iterator;

public abstract class PersonajePadre implements Peleable {

  protected String nombre;
  protected int salud;
  protected int defensa;
  protected int fuerza;
  protected int nivel;
  protected MyRandom aleatorizador;
  protected HashSet<Item> inventario;

  public PersonajePadre(final String nom) {
    nombre = nom;
    aleatorizador = new MyRandom();
    inventario = new HashSet<Item>();
  }



  public int getSalud() {
    return salud;
  }
  
  /* NO BORRAR. Lo dejo comentado porque tengo duda de si una instancia NPC no deberia de tener tambien su propia saludTope para que, en el caso de que a este NPC se lo equipe con un item que sube la saludTope, éste pueda recibir esa suba ya que "salud" es la salud actual y no la tope. //
  public void subirSaludTope(int plus) {
    saludTope += plus;
  }

  public void bajarSaludTope(int plus) {
    saludTope -= plus;
  }
  */

  public int getDefensa() {
    return defensa;
  }

  public void subirDefensa(int plus) {
    defensa += plus;
  }

  public void bajarDefensa(int reduccion) {
    if (reduccion <= defensa) {
      defensa -= reduccion;
    } else {
      defensa = 0;
    }
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

  public boolean agregarItem(Item i) {
    Integer ubicEnElCuerpoDeItemAAgregar = i.getUbicEnElCuerpo();
    Iterator<Item> items = inventario.iterator();
    while (items.hasNext()) {
      Item aux = items.next();
      if (aux.getUbicEnElCuerpo() == ubicEnElCuerpoDeItemAAgregar) {
        return false;
      }
    }

    inventario.add(i);
    actualizarALaSubaAtributosPorItem(i);
    return true;
  }

  public void soltarItem(Integer id) {
    Iterator<Item> items = inventario.iterator();
    while (items.hasNext()) {
      Item aux = items.next();
      if (aux.getId() == id) {
        inventario.remove(aux);
        actualizarALaBajaAtributosPorItem(aux);
        break;
      }
    }
  }

}
