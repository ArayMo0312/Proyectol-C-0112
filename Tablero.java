public class Tablero { // Clase de Batalla naval
    
    int filas = 5;
    int columnas = 5;

    private char[][] tablero = new char[filas][columnas];

    public char[][] getTablero(){
        return tablero;
    }
    public void setTablero(char[][] tablero){
        this.tablero = tablero;
    }
    
    public Tablero(){                //Llenar tablero

        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                tablero[i][j] = '~';
            }
        }
    }
    public void mostrarTablero(){      //Mostrar el tablero
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    
}

