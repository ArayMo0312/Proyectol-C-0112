public class Barco { // Clase de Batalla naval

    private int fila;
    private int columna;
    private int largo;
    private int ancho;


    public Barco(int fila, int columna, int largo, int ancho){ //Constructor del Barco
        this.fila = fila;
        this.columna = columna;
        this.largo = largo;
        this.ancho = ancho;

    }

    public int getFila(){ //getters de los atributos
        return fila;
    }
    public int getColumna(){
        return columna;
    }
    public int getLargo(){
        return largo;
    }
    public int getAncho(){
        return ancho;
    }


    public void setFila(int fila){ //setters de los atributos 
        this.fila = fila;
    }
    public void setColumna(int columna){
        this.columna = columna;
    }
    public void setlargo(int largo){
        this.largo = largo;
    }
    public void setAncho(int ancho){
        this.ancho = ancho;
    }


}
