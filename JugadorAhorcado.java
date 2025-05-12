public class JugadorAhorcado {
    private String nombre;
    private int fallosTotales;

    public JugadorAhorcado (String nombre){
        this.nombre = nombre;
        this.fallosTotales = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFallosTotales() {
        return fallosTotales;
    }

    public void agregarFallos(int fallos) {
        this.fallosTotales += fallos;
    }
}