package dominio;

public class MyRandom {

	static final float VALOR = 0.49f;
	static final int ENTERO = 1;
  /**
  * Metodo que devuelve siempre el mismo double, el 0.49.
  * @return Double con valor 0.49.
  */
  public static double nextDouble() {
    return VALOR;
  }


  /**
 * Metodo que devuelve el valor de lo pasado por parametro menos 1.
 * @param val Un numero entero.
 * @return Entero con valor val menos 1.
 */
  public static int nextInt(int val) {
    return val - ENTERO;
  }

}
