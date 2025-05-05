public class Barco { // Clase de Batalla naval

    private int tamaño;
    private int fila;
    private int columna;
    private boolean horizontal;
    private boolean hundido;

    public Barco(int tamaño, int fila, int columna){ //Constructor del Barco
        this.tamaño = 0;
        this.fila = 0;
        this.columna = 0;
        this.horizontal = false;
        this.hundido = false;
    }

    public int getTamaño(){ //getters de los atributos
        return tamaño;
    }
    public int getFila(){
        return fila;
    }
    public int getColumna(){
        return columna;
    }
    public boolean getHorizontal(){
        return horizontal;
    }
    public boolean getHundido(){
        return hundido;
    }

    public void setTamaño(int tamaño){ //setters de los atributos 
        this.tamaño = tamaño;
    }
    public void setFila(int fila){
        this.fila = fila;
    }
    public void setColumna(int columna){
        this.columna = columna;
    }
    public void setHorizontal(boolean horizontal){
        this.horizontal = horizontal;
    }
    public void setHundido(boolean hundido){
        this.hundido = hundido;
    }
}
