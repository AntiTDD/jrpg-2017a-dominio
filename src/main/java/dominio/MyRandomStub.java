package dominio;

public class MyRandomStub extends MyRandom {

  private int numero;

  public MyRandomStub(int numero) {
    this.numero = numero;
  }

  /**
   * Metodo que devuelve el valor del parametro al haber creado este objeto.
   * @return Devuelve un Double el cual
   *  es el double con que se instancio este objeto.
   * @throws ArithmeticException para tratar una excepcion
   */
  public double obtenerDoubleAleatorio() throws ArithmeticException {

    return numero;
  }
 

  /**
   * Metodo que devuelve un entero el cual es el mismo con el que se
     * construyo el metodo.
   * @param maximo Entero que aca no sirve para nada mas que para sobreescribir
     * este metodo por el de MyRandom.
   * @return Entero que indica el valor de parametro cuando se construyo este
     * objeto.
   */
  public int obtenerEnteroAleatorioMenorQue(int maximo) {

    return numero; // Asi como devuelvo
    //numero, podria devolver cualquier otro. //
  }
}
