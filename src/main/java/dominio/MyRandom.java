package dominio;

public class MyRandom {

  /**
  * Metodo que devuelve siempre el mismo double, el 0.49.
  * @return Double con valor 0.49.
  */
  public static double nextDouble() {
    final float ceroPuntoCuarentaYNueve = 0.49f;
    return ceroPuntoCuarentaYNueve;
  }


  /**
 * Metodo que devuelve el valor de lo pasado por parametro menos 1.
 * @param val Un numero entero.
 * @return Entero con valor val menos 1.
 */
  public static int nextInt(int val) {
    final int uno = 1;
    return val - uno;
  }

}
