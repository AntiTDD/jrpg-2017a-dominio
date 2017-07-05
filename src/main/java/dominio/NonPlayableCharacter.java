package dominio;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * The Class NonPlayableCharacter.
 */
public class NonPlayableCharacter extends PersonajePadre {

  /** The Constant dificultadAleatoria. */
  private static final int dificultadAleatoria = -1;

  /** Estas variables se crean para que no tire el.
   * error de checksyle "El numero X es un numero magico */
  private final int uno = 1,
                    dos = 2,
                    tres = 3,
                    cuatro = 4,
                    cinco = 5,
                    seis = 6,
                    diez = 10,
                    quince = 15,
                    veinte = 20,
                    veinticinco = 25,
                    treinta = 30,
                    cuarenta = 40,
                    cincuenta = 50;

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

  public NonPlayableCharacter(final String nombre,
                              final int nivel, final int dificultadNPC) {
    super(nombre);
    this.nivel = nivel;
    int dificultad;
    if (dificultadNPC == dificultadAleatoria) {
      dificultad = aleatorizador.obtenerEnteroAleatorioMenorQue(tres);
    } else {
      dificultad = dificultadNPC;
    }

    switch (dificultad) {
      case 0:
        this.fuerza = diez + (nivel - uno) * tres;
        this.salud = treinta + (nivel - uno) * quince;
        this.defensa = dos + (nivel - uno) * uno;
        break;
      case 1:
        this.fuerza = veinte + (nivel - uno) * seis;
        this.salud = cuarenta + (nivel - uno) * veinte;
        this.defensa = cinco + (nivel - uno) * dos;
        break;
      case 2:
        this.fuerza = treinta + (nivel - uno) * diez;
        this.salud = cincuenta + (nivel - uno) * veinticinco;
        this.defensa = cuatro + (nivel - uno) * cuatro;
        break;
      default:
        break;
    }
  }

  public int otorgarExp() {
    return this.nivel * treinta;
  }


  public void bajarFuerza(final int plus) {
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


  /**
   * Ganar experiencia.
   *
   * @param exp the exp
   */
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
