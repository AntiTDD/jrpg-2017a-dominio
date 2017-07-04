package dominio;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NonPlayableCharacter extends PersonajePadre {

  private static final int dificultadAleatoria = -1;
  /**<p>
  *  Construye al NPC a partir de una dificultad Aleatoria estatica dada,
  *  si la dificultad aleatoria del parametro es igual a la aleatoria,
    *  le asignara un valor random entre 1 y 3 para setear los valores de
      *  fuerza, defensa y salud que seran distintos dependiendo del valor
        *  obtenido.
   </p>
   @param nombre para darle un nombre al NPC
   @param nivel para darle un nivel al NPC
   @param dificultadNPC la dificultad que va a tener

  */

  public NonPlayableCharacter(String nombre, int nivel, int dificultadNPC) {
    super(nombre);
    this.nivel = nivel;
    int dificultad;
    if (dificultadNPC == dificultadAleatoria) {
      dificultad = aleatorizador.obtenerEnteroAleatorioMenorQue(3);
    } else {
      dificultad = dificultadNPC;
    }

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
      default:
        break;
    }
  }

  public int otorgarExp() {
    return this.nivel * 30;
  }


  public void bajarFuerza(int plus) {
    if (plus <= fuerza) {
      fuerza -= plus;
    } else {
      fuerza = 0;
    }
  }


  /**
   * La probabilidad de golpe critico para todos los NPC sera del 15%.
   * de da�o menor, este se incrementara en un 50%.
   * De lo contrario, el ataque estara basado en la fuerza del NPC.
   * @param atacado se indica el personaje al cual se ataca
   * @return el ataque del personaje llamador (ataca)
   * al personaje atacad (recibido por param)
   */
  public int atacar(Peleable atacado) {
    if (aleatorizador.obtenerDoubleAleatorio() <= 0.15) {
      return atacado.serAtacado((int) (this.getAtaque() * 1.5));
    } else {
      return atacado.serAtacado(this.getAtaque());
    }
  }
  /**
   *
   * Cuando ataquen al NPC, el da�o se calcula en base a su defensa.
   * Si la defensa es mayor que su da�o no recibira el golpe.
   * Si el daño es mayor a la salud , su salud quedara en 0 sino se le restara
     * el daño.
     * @param daño es el daño que se recibe al ser atacado
     * @return devuelve el valor del daño
   */

  public int serAtacado(int daño) {
    if (aleatorizador.obtenerDoubleAleatorio() >= 0.15) {
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

  @Override
  public boolean esPersonaje() {
    return false;
  }


  /**
   * Este metodo actualiza los atributos
   *  de este objeto en base al item pasado por parametro.
   * @param i Item el cual modificara
   *  los valores de los atributos de este objeto.
   */
  @Override
  public void actualizarALaSubaAtributosPorItem(Item i) {
    HashMap<String, Integer> bonus = i.getBonus();
    Iterator<Map.Entry<String, Integer>> entradas = bonus.entrySet().iterator();
    while (entradas.hasNext()) {
      Map.Entry<String, Integer> entradaActual = entradas.next();
      switch (entradaActual.getKey()) {
        case "defensa":
          subirDefensa(entradaActual.getValue());
          break;
        case "ataque":
          subirFuerza(entradaActual.getValue());
          break;
        default:
      }
    }
  }


  /**
   * Este metodo actualiza los atributos de este objeto en base al item pasado
     * por parametro.
   * @param i Item el cual modificara los valores de los atributos de este
     * objeto.
   */
  @Override
  public void actualizarALaBajaAtributosPorItem(Item i) {
    HashMap<String, Integer> bonus = i.getBonus();
    Iterator<Map.Entry<String, Integer>> entradas = bonus.entrySet().iterator();
    while (entradas.hasNext()) {
      Map.Entry<String, Integer> entradaActual = entradas.next();
      switch (entradaActual.getKey()) {
        case "defensa":
          bajarDefensa(entradaActual.getValue());
          break;
        case "ataque":
          bajarFuerza(entradaActual.getValue());
          break;
        default:
      }
    }
  }
}
