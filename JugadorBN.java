public class JugadorBN {
  private String nombre;
  private Tablero tablero;
  private Barco[] barcos;

  public JugadorBN(String nombre) {
    this.nombre = nombre;
    this.tablero = new Tablero();
    this.barcos = new Barco[4]; // 2 barcos de 2, 1 de 3 y 1 de 4
  }

  public String getNombre() {
    return nombre;
  }

  public Tablero getTablero() {
    return tablero;
  }

  public Barco[] getBarcos() {
    return barcos;
  }

  public void setBarcos(int i, Barco barco) {
    if (i >= 0 && i < barcos.length) {
      barcos[i] = barco;
    }
  }
}
