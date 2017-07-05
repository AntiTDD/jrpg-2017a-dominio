package dominio;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * The Class Personaje es usada para instanciar cada.
 * personaje existente en el juego. Contiene los atributos
 * minimos que debe poseer cada personaje
 */
public abstract class Personaje extends PersonajePadre implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** The energia. */
  protected int energia;

  /** The ataque. */
  protected int ataque;

  /** The magia. */
  protected int magia;

  /** The nombre raza. */
  protected String nombreRaza;

  /** The salud tope. */
  protected int saludTope;

  /** The energia tope. */
  protected int energiaTope;


  /** The destreza. */
  protected int destreza;

  /** The inteligencia. */
  protected int inteligencia;

  /** The casta. */
  protected Casta casta;

  /** The x. */
  protected int x;

  /** The y. */
  protected int y;

  /** The experiencia. */
  protected int experiencia;


  /** The id personaje. */
  protected int idPersonaje;

  /** The Constant HABILIDADES. */
  protected static final int HABILIDADES = 2;

  /** The clan. */
  protected Alianza clan = null;

  /** The tabla de niveles. */
  public static int tablaDeNiveles [];

  /** The habilidades raza. */
  protected String[] habilidadesRaza;
  private final int cientoUno = 101,
                    cien = 100,
                    doscientos = 200,
                    veinticinco = 25,
                    veinte = 20,
                    cuarenta = 40,
                    diez = 10,
                    cincuenta = 50,
                    mil = 1000;
  private final float unoPuntoCinco = 1.5f;

  /**
   * Gets the habilidades raza.
   *
   * @return the habilidades raza
   */
  public String[] getHabilidadesRaza() {
    return habilidadesRaza;
  }

  /**
   * Gets the habilidades casta.
   *
   * @return the habilidades casta
   */
  public String[] getHabilidadesCasta() {
    return casta.getHabilidadesCasta();
  }

  /**<p>
   * Carga una tabla para saber cuanta experiencia necesitara el personaje para
     * pasar de nivel.
   * </p>
   */
  public static void cargarTablaNivel() {
    Personaje.tablaDeNiveles = new int[101];
    Personaje.tablaDeNiveles[0] = 0;
    Personaje.tablaDeNiveles[1] = 0;
    for (int i = 2; i < 101; i++) {
      Personaje.tablaDeNiveles[i] = Personaje.tablaDeNiveles[i - 1] + 50;
    }
  }


  /**
   * Constructor de Personaje.
   * @param nombre String que hace referencia al nombre de este objeto.
   * @param casta Casta que refiere a la profesion que tiene este objeto.
   * @param id Int que identifica a este objeto.
   * @param raza String que refiere a que raza pertenece este objeto.
   * @param hab1 String que indica la primera de las dos habilidades de
     * este objeto.
   * @param hab2 String que indica la segunda de las dos habilidades de
     * este objeto.
   */
  public Personaje(String nombre, Casta casta,
		  int id, String raza, String hab1, String hab2) {
    super(nombre);
    this.casta = casta;
    this.idPersonaje = id;
    this.nombreRaza = raza;
    this.asignarHabilidades(hab1, hab2);
    experiencia = 0;
    nivel = 1;
    fuerza = diez;
    inteligencia = diez;
    destreza = diez;
    fuerza += casta.getBonusFuerza();
    inteligencia += casta.getBonusInteligencia();
    destreza += casta.getBonusDestreza();


    x = 0;
    y = 0;
    saludTope = cien;
    energiaTope = cien;

    ataque = this.calcularPuntosDeAtaque();
    defensa = this.calcularPuntosDeDefensa();
    magia = this.calcularPuntosDeMagia();
  }

  /**
   * .
   *
   * @param nombre the nombre
   * @param salud the salud
   * @param energia the energia
   * @param fuerza the fuerza
   * @param destreza the destreza
   * @param inteligencia the inteligencia
   * @param casta the casta
   * @param experiencia the experiencia
   * @param nivel the nivel
   * @param idPersonaje the id personaje
   * @param raza the raza
   * @param hab1 the hab 1
   * @param hab2 the hab 2
   */

  public Personaje(String nombre, int salud,
		  int energia, int fuerza, int destreza,
                   int inteligencia, Casta casta, int experiencia,
                   int nivel, int idPersonaje, String raza,
                   String hab1, String hab2) {

    super(nombre);
    this.salud = salud;
    this.energia = energia;
    this.fuerza = fuerza;
    this.destreza = destreza;
    this.inteligencia = inteligencia;
    this.casta = casta;

    this.experiencia = experiencia;
    this.nivel = nivel;

    this.saludTope = this.salud;
    this.energiaTope = this.energia;

    this.idPersonaje = idPersonaje;
    this.defensa = this.calcularPuntosDeDefensa();
    this.ataque = this.calcularPuntosDeAtaque();
    this.magia = this.calcularPuntosDeMagia();

    this.nombreRaza = raza;
    this.asignarHabilidades(hab1, hab2);
  }

  /**
   * Gets the nombre raza.
   *
   * @return the nombre raza
   */
  public String getNombreRaza() {
    return nombreRaza;
  }

  /**
   * Sets the nombre raza.
   *
   * @param nombreRaza the new nombre raza
   */
  public void setNombreRaza(String nombreRaza) {
    this.nombreRaza = nombreRaza;
  }

  /* (non-Javadoc)
   * @see dominio.Peleable#getAtaque()
   */
  public int getAtaque() {
    return ataque;
  }


  /**
   * Subir ataque.
   *
   * @param plus the plus
   */
  public void subirAtaque(int plus) {
    ataque += plus;
  }


  /**
   * Bajar ataque.
   *
   * @param plus the plus
   */
  public void bajarAtaque(int plus) {
    if (plus <= ataque) {
      ataque -= plus;
    } else {
      ataque = 0;
    }
  }


  /* (non-Javadoc)
   * @see dominio.Peleable#setAtaque(int)
   */
  public void setAtaque(int ataque) {
    this.ataque = ataque;
  }

  /**
   * Subir magia.
   *
   * @param plus the plus
   */
  public void subirMagia(int plus) {
    magia += plus;
  }

  /**
   * Bajar magia.
   *
   * @param plus the plus
   */
  public void bajarMagia(int plus) {
    if (plus <= magia) {
      magia -= plus;
    } else {
      magia = 0;
    }
  }

  /**
   * Gets the magia.
   *
   * @return the magia
   */
  public int getMagia() {
    return magia;
  }

  /**
   * Sets the magia.
   *
   * @param magia the new magia
   */
  public void setMagia(int magia) {
    this.magia = magia;
  }

  /**
   * Gets the clan.
   *
   * @return the clan
   */
  public Alianza getClan() {
    return clan;
  }

  /**
   * Sets the clan.
   *
   * @param clan the new clan
   */
  public void setClan(Alianza clan) {
    this.clan = clan;
    clan.añadirPersonaje(this);
  }

  /**
   * Subir energia.
   *
   * @param plus the plus
   */
  public void subirEnergia(int plus) {
    energia += plus;
  }

  /**
   * Se reduce la energia en relacion al costo de la habilidad utilizada.
   *
   * @param reduccion the reduccion
   */
  public void bajarEnergia(int reduccion) {
    if (reduccion <= energia) {
      energia -= reduccion;
    } else {
      energia = 0;
    }
  }

  /**
   * Gets the energia.
   *
   * @return the energia
   */
  public int getEnergia() {
    return energia;
  }

  /**
   * Gets the destreza.
   *
   * @return the destreza
   */
  public int getDestreza() {
    return destreza;
  }

  /**
   * Subir destreza.
   *
   * @param plus the plus
   */
  public void subirDestreza(int plus) {
    destreza += plus;
  }

  /**
   * Gets the inteligencia.
   *
   * @return the inteligencia
   */
  public int getInteligencia() {
    return inteligencia;
  }

  /**
   * Subir inteligencia.
   *
   * @param plus the plus
   */
  public void subirInteligencia(int plus) {
    inteligencia += plus;
  }

  /**
   * Gets the casta.
   *
   * @return the casta
   */
  public Casta getCasta() {
    return casta;
  }

  /**
   * Gets the experiencia.
   *
   * @return the experiencia
   */
  public int getExperiencia() {
    return experiencia;
  }

  /**
   * Subir experiencia.
   *
   * @param plus the plus
   */
  public void subirExperiencia(int plus) {
    experiencia += plus;
  }

  /**
   * Gets the id personaje.
   *
   * @return the id personaje
   */
  public int getIdPersonaje() {
    return idPersonaje;
  }

  /**
   * Gets the salud tope.
   *
   * @return the salud tope
   */
  public int getSaludTope() {
    return saludTope;
  }

  /**
   * Sets the salud tope.
   *
   * @param saludTope the new salud tope
   */
  public void setSaludTope(int saludTope) {
    this.saludTope = saludTope;
  }


  /**
   * Subir salud tope.
   *
   * @param plus the plus
   */
  public void subirSaludTope(int plus) {
    saludTope += plus;
  }

  /**
   * Bajar salud tope.
   *
   * @param plus the plus
   */
  public void bajarSaludTope(int plus) {
    if (plus <= saludTope) {
      saludTope -= plus;
    } else {
      saludTope = 0;
    }
  }

  /**
   * Gets the energia tope.
   *
   * @return the energia tope
   */
  public int getEnergiaTope() {
    return energiaTope;
  }

  /**
   * Sets the energia tope.
   *
   * @param energiaTope the new energia tope
   */
  public void setEnergiaTope(int energiaTope) {
    this.energiaTope = energiaTope;
  }


  /**
   * Subir energia tope.
   *
   * @param plus the plus
   */
  public void subirEnergiaTope(int plus) {
    energiaTope += plus;
  }

  /**
   * Bajar energia tope.
   *
   * @param plus the plus
   */
  public void bajarEnergiaTope(int plus) {
    if (plus <= energiaTope) {
      energiaTope -= plus;
    } else {
      energiaTope = 0;
    }
  }

  /**
   * Actualizar atributos personaje.
   *
   * @param datosActualizados the datos actualizados
   */
  public void actualizarAtributosPersonaje(
		  HashMap<String, Integer> datosActualizados) {
    salud = datosActualizados.get("salud");
    energia = datosActualizados.get("energia");
  }

  /**
   * <p>
   * Si la salud es mayor a 0, realizara el ataque en el cual se calculara
   * si es golpe critico o no dependiendo de la probabilidad de obtener
   * el mismo y la destreza.
   * </p>
   *
   * @param atacado the atacado
   * @return the int
   */

  public int atacar(Peleable atacado) {
    if (salud == 0) {
      return 0;
    }
    if (atacado.getSalud() > 0) {
      if (aleatorizador.obtenerDoubleAleatorio()
    		  <= this.casta.getProbabilidadGolpeCritico()
          + this.destreza / mil) {
        return atacado.serAtacado(this.golpe_critico());
      } else {
        return atacado.serAtacado(this.ataque);
      }
    }
    return 0;
  }


  /**
   * Golpe critico.
   *
   * @return the int
   */
  public int golpe_critico() {
    return (int) (this.ataque * this.getCasta().getDañoCritico());
  }

  /* (non-Javadoc)
   * @see dominio.Peleable#despuesDeTurno()
   */
  public void despuesDeTurno() {

  }

  /**
   * Puede atacar.
   *
   * @return true, if successful
   */
  public boolean puedeAtacar() {
    return energia > diez;
  }

  /**
   * Calcular puntos de ataque.
   *
   * @return the int
   */
  public int calcularPuntosDeAtaque() {
    return (int) (this.getFuerza() * unoPuntoCinco);
  }

  /**
   * Calcular puntos de defensa.
   *
   * @return the int
   */
  public int calcularPuntosDeDefensa() {
    return (int) (this.getDestreza());
  }

  /**
   * Calcular puntos de magia.
   *
   * @return the int
   */
  public int calcularPuntosDeMagia() {
    return (int) (this.getInteligencia() * unoPuntoCinco);
  }

  /**
   * Restablecer salud.
   */
  public void restablecerSalud() {
    this.salud = this.saludTope;
  }

  /**
   * Restablecer energia.
   */
  public void restablecerEnergia() {
    this.energia = this.energiaTope;
  }

  /**
   * Metodo el cual sirve para modificar los atributos ataque,
     * defensa y magia en base a la fuerza, destreza e inteligencia.
   */
  public void modificarAtributos() {
    this.ataque = this.calcularPuntosDeAtaque();
    this.defensa = this.calcularPuntosDeDefensa();
    this.magia = this.calcularPuntosDeMagia();
  }



  /**
   * <p> cuando ataquen al personaje, el da�o se calcula en base a su defensa.
   * Si la defensa es mayor que su daño no recibira el golpe.
   * si el daño es mayor a la salud , su salud quedara en 0 sino se le restara
   * el daño.
   * </p>
   *
   * @param daño the daño
   * @return the int
   */
  public int serAtacado(int daño) {
    if (aleatorizador.obtenerDoubleAleatorio()
    		>= this.getCasta().getProbabilidadEvitarDaño()) {
      daño -= this.defensa;
      if (daño > 0) {
        if (salud <= daño) {
          daño = salud;
          salud = 0;
        } else {
          salud -= daño;
        }
        return daño;
      }
      return 0;
    }
    return 0;
  }



  /**
   * Ser robado salud.
   *
   * @param daño the daño
   * @return the int
   */
  public int serRobadoSalud(int daño) {
    daño -= this.defensa;
    if (daño <= 0) {
      return 0;
    }
    if ((salud - daño) >= 0) {
      salud -= daño;
    } else {
      daño = salud;
      salud = 0;
    }
    return daño;
  }

  /**
   * Ser desernegizado.
   *
   * @param daño the daño
   * @return the int
   */
  public int serDesernegizado(int daño) {
    daño -= this.defensa;
    if (daño <= 0) {
      return 0;
    }

    if ((energia - daño) >= 0) {
      energia -= daño;
    } else {
      daño = energia;
      energia = 0;
    }
    return daño;
  }

  /**
   * <p> cura al personaje sin exceder su salud tope.</p>
   *
   * @param salud the salud
   */
  public void serCurado(int salud) {
    if ((this.salud + salud) <= this.saludTope) {
      this.salud += salud;
    } else {
      this.salud = this.saludTope;
    }
  }

  /**
   * <p> le otorga energia al personaje sin exceder su energia tope.</p>
   *
   * @param energia the energia
   */

  public void serEnergizado(int energia) {
    if ((this.energia + energia) <= this.energiaTope) {
      this.energia += energia;
    } else {
      this.energia = this.energiaTope;
    }
  }

  /**
   * Crear alianza.
   *
   * @param nombreAlianza the nombre alianza
   */
  public void crearAlianza(String nombreAlianza) {
    this.clan = new Alianza(nombreAlianza);
    this.clan.añadirPersonaje(this);
  }


  /**
   * Metodo el cual sirve para sacar a este objeto de su alianza.
   */
  public void salirDeAlianza() {
    if (this.clan != null) {
      this.clan.eliminarPersonaje(this);
      this.clan = null;
    }
  }


  /**
   * Metodo el cual sirve para que este objeto alíe a otro Personaje
   * a su actual alianza.
   *
   * @param nuevoAliado Personaje el cual va a ser ingresado a la alianza
   * @return true, if successful
   */
  public boolean aliar(Personaje nuevoAliado) {
    if (this.clan == null) {
      Alianza a = new Alianza("Alianza 1");
      this.clan = a;
      a.añadirPersonaje(this);
    }
    if (nuevoAliado.clan == null) {
      nuevoAliado.clan = this.clan;
      this.clan.añadirPersonaje(nuevoAliado);
      return true;
    } else {
      return false;
    }
  }



  /**
   * Asignar puntos skills.
   *
   * @param fuerza the fuerza
   * @param destreza the destreza
   * @param inteligencia the inteligencia
   */
  public void AsignarPuntosSkills(int fuerza, int destreza, int inteligencia) {
    if (this.fuerza + fuerza <= doscientos) {
      this.fuerza += fuerza;
    }
    if (this.destreza + destreza <= doscientos) {
      this.destreza += destreza;
    }
    if (this.inteligencia + inteligencia <= doscientos) {
      this.inteligencia += inteligencia;
    }
    this.modificarAtributos();
  }

  /**
   * <p> compara la experiencia que tiene con respecto a la tabla de nivel
   * para saber si el personaje puede subir de nivel.
   * </p>
   */
  public void subirNivel() {
    int acumuladorExperiencia = 0;
    if (this.nivel == cien) {
      return;
    }
    while (this.nivel != cien
      && (this.experiencia
    		  >= Personaje.tablaDeNiveles[this.nivel + 1]
    		  + acumuladorExperiencia)) {
      acumuladorExperiencia += Personaje.tablaDeNiveles[this.nivel + 1];
      this.nivel++;
      this.modificarAtributos();
      this.saludTope += veinticinco;
      this.energiaTope += veinte;
    }
    this.experiencia -= acumuladorExperiencia;
  }


  /**
   * Ganar experiencia.
   *
   * @param exp the exp
   * @return true, if successful
   */
  public boolean ganarExperiencia(int exp) {
    this.experiencia += exp;
    if (experiencia >= Personaje.tablaDeNiveles[this.nivel + 1]) {
      subirNivel();
      return true;
    }
    return false;
  }

  /* (non-Javadoc)
   * @see dominio.Peleable#otorgarExp()
   */
  public int otorgarExp() {
    return this.nivel * cuarenta;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#clone()
   */
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  /**
   * Distancia con.
   *
   * @param p the p
   * @return the double
   */
  public double distanciaCon(Personaje p) {
    return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
  }


  /**
   * Habilidad casta 1.
   *
   * @param atacado the atacado
   * @return true, if successful
   */
  public boolean habilidadCasta1(Peleable atacado) {
    return this.getCasta().habilidad1(this, atacado);
  }

  /**
   * Habilidad casta 2.
   *
   * @param atacado the atacado
   * @return true, if successful
   */
  public boolean habilidadCasta2(Peleable atacado) {
    return this.getCasta().habilidad2(this, atacado);
  }

  /**
   * Habilidad casta 3.
   *
   * @param atacado the atacado
   * @return true, if successful
   */
  public boolean habilidadCasta3(Peleable atacado) {
    return this.getCasta().habilidad3(this, atacado);
  }

  /**
   * Asignar habilidades.
   *
   * @param habilidad1 the habilidad 1
   * @param habilidad2 the habilidad 2
   */
  public void asignarHabilidades(String habilidad1, String habilidad2) {
    habilidadesRaza = new String[HABILIDADES];
    habilidadesRaza[0] = habilidad1;
    habilidadesRaza[1] = habilidad2;
  }

  /**
   * Habilidad raza 1.
   *
   * @param atacado the atacado
   * @return true, if successful
   */
  public abstract boolean habilidadRaza1(Peleable atacado);

  /**
   * Habilidad raza 2.
   *
   * @param atacado the atacado
   * @return true, if successful
   */
  public abstract boolean habilidadRaza2(Peleable atacado);

  /* (non-Javadoc)
   * @see dominio.PersonajePadre#esPersonaje()
   */
  @Override
  public boolean esPersonaje() {
    return true;
  }



  /* (non-Javadoc)
   * @see dominio.Peleable#actualizarALaSubaAtributosPorItem(dominio.Item)
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
          subirAtaque(entradaActual.getValue());
          break;
        case "magia":
          subirMagia(entradaActual.getValue());
          break;
        case "saludTope":
          subirSaludTope(entradaActual.getValue());
          break;
        case "energiaTope":
          subirEnergiaTope(entradaActual.getValue());
          break;
        default:
      }
    }
  }


  /* (non-Javadoc)
   * @see dominio.Peleable#actualizarALaBajaAtributosPorItem(dominio.Item)
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
          bajarAtaque(entradaActual.getValue());
          break;
        case "magia":
          bajarMagia(entradaActual.getValue());
          break;
        case "saludTope":
          bajarSaludTope(entradaActual.getValue());
          break;
        case "energiaTope":
          bajarEnergiaTope(entradaActual.getValue());
          break;
        default:
      }
    }
  }
}
