package dominio;

import java.io.Serializable;

public abstract class Personaje extends PersonajePadre implements Serializable {

  private static final long serialVersionUID = 1L;

  protected int energia;
  protected int ataque;
  protected int magia;
  
  protected String nombreRaza;
  
  protected int saludTope;
  protected int energiaTope;


  protected int destreza;
  protected int inteligencia;
  protected Casta casta;

  protected int x;
  protected int y;

  protected int experiencia;


  protected int idPersonaje;
  protected static final int HABILIDADES = 2;

  protected Alianza clan = null;
  public static int tablaDeNiveles[];

  protected String[] habilidadesRaza;

  public String[] getHabilidadesRaza() {
    return habilidadesRaza;
  }

  public String[] getHabilidadesCasta() {
    return casta.getHabilidadesCasta();
  }
  
  /**<p>
   * Carga una tabla para saber cuanta experiencia necesitara el personaje para pasar de nivel.
   * </p>
   */
  public static void cargarTablaNivel() {
    Personaje.tablaDeNiveles = new int[101];
    Personaje.tablaDeNiveles[0] = 0;
    Personaje.tablaDeNiveles[1] = 0;
    for (int i = 2; i < 101; i++)
      Personaje.tablaDeNiveles[i] = Personaje.tablaDeNiveles[i - 1] + 50;
  }

  /**.
   * 
   */
  
  public Personaje(String nombre, Casta casta, int id , String raza, String hab1,String hab2) {
    super(nombre);
    this.casta = casta;
    this.idPersonaje = id;
    this.nombreRaza = raza;
    this.asignarHabilidades(hab1, hab2);
    experiencia = 0;
    nivel = 1;
    fuerza = 10;
    inteligencia = 10;
    destreza = 10;
    fuerza += casta.getBonusFuerza();
    inteligencia += casta.getBonusInteligencia();
    destreza += casta.getBonusDestreza();
    
    
    x = 0;
    y = 0;
    saludTope = 100;
    energiaTope = 100;

    ataque = this.calcularPuntosDeAtaque();
    defensa = this.calcularPuntosDeDefensa();
    magia = this.calcularPuntosDeMagia();
  }

  /**.
   * 
   */
  
  public Personaje(String nombre, int salud, int energia, int fuerza, int destreza,
                   int inteligencia, Casta casta, int experiencia, 
                   int nivel, int idPersonaje , String raza , String hab1, String hab2) {

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

  public String getNombreRaza() {
    return nombreRaza;
  }

  public void setNombreRaza(String nombreRaza) {
    this.nombreRaza = nombreRaza;
  }

  public int getAtaque() {
    return ataque;
  }

  public void setAtaque(int ataque) {
    this.ataque = ataque;
  }

  public int getMagia() {
    return magia;
  }

  public void setMagia(int magia) {
    this.magia = magia;
  }

  public Alianza getClan() {
    return clan;
  }

  public void setClan(Alianza clan) {
    this.clan = clan;
    clan.añadirPersonaje(this);
  }

  /*
  public void setEnergia(int energia) {
    this.energia = energia;
  }
  */
  
  public void subirEnergia(int plus) { //Nuevo//
    energia += plus;
  }
  
  public void bajarEnergia(int reduccion) {
    if (reduccion <= energia) {
      energia -= reduccion;
    } else {
      energia = 0;
    }
  }
  

  public int getEnergia() {
    return energia;
  }

/*
  public void setFuerza(int fuerza) {
    this.fuerza = fuerza;
  }
*/
  public int getDestreza() {
    return destreza;
  }
/*
  public void setDestreza(int destreza) {
    this.destreza = destreza;
  }
*/
  
  public void subirDestreza(int plus) {
	  destreza += plus;
  }
  
  public int getInteligencia() {
    return inteligencia;
  }

  public void setInteligencia(int inteligencia) {
    this.inteligencia = inteligencia;
  }

  public Casta getCasta() {
    return casta;
  }

  public void setCasta(Casta casta) {
    this.casta = casta;
  }

  public int getExperiencia() {
    return experiencia;
  }

  public void setExperiencia(int experiencia) {
    this.experiencia = experiencia;
  }



  public int getIdPersonaje() {
    return idPersonaje;
  }

  public void setIdPersonaje(int idPersonaje) {
    this.idPersonaje = idPersonaje;
  }


  public int getSaludTope() {
    return saludTope;
  }

  public void setSaludTope(int saludTope) {
    this.saludTope = saludTope;
  }

  public int getEnergiaTope() {
    return energiaTope;
  }

  public void setEnergiaTope(int energiaTope) {
    this.energiaTope = energiaTope;
  }
  /**<p>
   * Si la salud es mayor a 0, realizara el ataque en el cual se calculara si es golpe critico o no
   * dependiendo de la probabilidad de obtener el mismo y la destreza.
   * </p>
   */
  
  public int atacar(Peleable atacado) {
    if (salud == 0)
      return 0;
    if (atacado.getSalud() > 0) {
      if (aleatorizador.obtenerDoubleAleatorio() <= this.casta.getProbabilidadGolpeCritico() 
          + this.destreza / 1000) {
        return atacado.serAtacado(this.golpe_critico());
      } else {
        return atacado.serAtacado(this.ataque);
      }
    }
    return 0;
  }


  public int golpe_critico() {
    return (int) (this.ataque * this.getCasta().getDañoCritico());
  }

  public void despuesDeTurno() {

  }

  public boolean puedeAtacar() {
    return energia > 10;
  }

  public int calcularPuntosDeAtaque() {
    return (int) (this.getFuerza() * 1.5);
  }

  public int calcularPuntosDeDefensa() {
    return (int) (this.getDestreza());
  }

  public int calcularPuntosDeMagia() {
    return (int) (this.getInteligencia() * 1.5);
  }

  public void restablecerSalud() {
    this.salud = this.saludTope;
  }

  public void restablecerEnergia() {
    this.energia = this.energiaTope;
  }

  /**.
   *
   */
  
  public void modificarAtributos() {
    this.ataque = this.calcularPuntosDeAtaque();
    this.defensa = this.calcularPuntosDeDefensa();
    this.magia = this.calcularPuntosDeMagia();
  }



  /**
   * 
   * <p> cuando ataquen al personaje, el da�o se calcula en base a su defensa.
   *Si la defensa es mayor que su daño no recibira el golpe.
   *si el daño es mayor a la salud , su salud quedara en 0 sino se le restara el daño.
   * </p>
   * 
   */

  public int serAtacado(int daño) {
    if (aleatorizador.obtenerDoubleAleatorio() >= this.getCasta().getProbabilidadEvitarDaño()) {
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



  public int serRobadoSalud(int daño) {
    daño -= this.defensa;
    if (daño <= 0)
      return 0;
    if ((salud - daño) >= 0)
      salud -= daño;
    else {
      daño = salud;
      salud = 0;
    }
    return daño;
  }

  public int serDesernegizado(int daño) {
    daño -= this.defensa;
      if (daño <= 0)
        return 0;
      if ((energia - daño) >= 0)
        energia -= daño;
    else {
      daño = energia;
      energia = 0;
    }
    return daño;
  }

  /**
   * 
   * <p> cura al personaje sin exceder su salud tope.</p>
   * 
   */
  public void serCurado(int salud) {
    if ((this.salud + salud) <= this.saludTope)
      this.salud += salud;
    else
      this.salud = this.saludTope;
  }

  /**
   * 
   * <p> le otorga energia al personaje sin exceder su energia tope.</p>
   * 
   */

  public void serEnergizado(int energia) {
    if ((this.energia + energia) <= this.energiaTope)
      this.energia += energia;
    else
      this.energia = this.energiaTope;
  }

  public void crearAlianza(String nombre_alianza) {
    this.clan = new Alianza(nombre_alianza);
    this.clan.añadirPersonaje(this);
  }

  /**
   * 
   * <p> .</p>
   * 
   */
  
  public void salirDeAlianza() {
    if (this.clan != null) {
      this.clan.eliminarPersonaje(this);
      this.clan = null;
    }
  }
  
  /**
   * 
   * <p> .</p>
   * 
   */

  public boolean aliar(Personaje nuevo_aliado) {
    if (this.clan == null) {
      Alianza a = new Alianza("Alianza 1");
      this.clan = a;
      a.añadirPersonaje(this);
    }  
    if (nuevo_aliado.clan == null) {
      nuevo_aliado.clan = this.clan;
      this.clan.añadirPersonaje(nuevo_aliado);
      return true;
    } else
      return false;
  }

  /**
   * 
   * <p> .</p>
   * 
   */
  
  public void AsignarPuntosSkills(int fuerza, int destreza, int inteligencia) {
    if (this.fuerza + fuerza <= 200)
      this.fuerza += fuerza;
    if (this.destreza + destreza <= 200)
      this.destreza += destreza;
    if (this.inteligencia + inteligencia <= 200)
      this.inteligencia += inteligencia;
    this.modificarAtributos();
  }

  /**
   * 
   * <p> compara la experiencia que tiene con respecto a la tabla de nivel
   * para saber si el personaje puede subir de nivel.
   * </p>
   * 
   */

  public void subirNivel() {
    int acumuladorExperiencia = 0;
    if (this.nivel == 100) {
      return;
    }
    while (this.nivel != 100
      && (this.experiencia >= Personaje.tablaDeNiveles[this.nivel + 1] + acumuladorExperiencia)) {
      acumuladorExperiencia += Personaje.tablaDeNiveles[this.nivel + 1];
      this.nivel++;
      this.modificarAtributos();
      this.saludTope += 25;
      this.energiaTope += 20;
    }
    this.experiencia -= acumuladorExperiencia;
  }

  /**
   * 
   * <p> .</p>
   * 
   */
  
  public boolean ganarExperiencia(int exp) {
    this.experiencia += exp;
    if (experiencia >= Personaje.tablaDeNiveles[this.nivel + 1]) {
      subirNivel();
      return true;
    }
    return false;
  }

  public int otorgarExp() {
    return this.nivel * 40;
  }

  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  public double distanciaCon(Personaje p) {
    return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
  }

  
  public boolean habilidadCasta1(Peleable atacado) {
    return this.getCasta().habilidad1(this, atacado);
  }

  public boolean habilidadCasta2(Peleable atacado) {
    return this.getCasta().habilidad2(this, atacado);
  }

  public boolean habilidadCasta3(Peleable atacado) {
    return this.getCasta().habilidad3(this, atacado);
  }

  /**
   * 
   * <p> .</p>
   * 
   */
  
  public void asignarHabilidades(String habilidad1,String habilidad2) { 
    habilidadesRaza = new String [HABILIDADES];
    habilidadesRaza[0] = habilidad1;
    habilidadesRaza[1] = habilidad2;
  }

  public abstract boolean habilidadRaza1(Peleable atacado);

  public abstract boolean habilidadRaza2(Peleable atacado);
  
  @Override
  public boolean esPersonaje()
  {
	  return true;
  }
}
