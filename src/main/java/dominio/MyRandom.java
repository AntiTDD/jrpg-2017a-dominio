package dominio;

import java.util.Random;

public class MyRandom {

  /**
   * Metodo que devuelve un double al azar comprendido entre 0 y 1.
   * @return Double que indica el numero obtenido al azar.
   */
  public double obtenerDoubleAleatorio() {
	    return new Random().nextDouble();
	  }


  /**
   * Metodo que devuelve un entero al azar menor al pasado por parametro
     * y mayor o igual a 0.
   * @param maximo Entero que indica la cota superior del azar.
   * @return Entero que indica el numero obtenido al azar.
   */
  public int obtenerEnteroAleatorioMenorQue(int maximo) {
    return new Random().nextInt(maximo);
  }

}
