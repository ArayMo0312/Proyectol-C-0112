public class BattleShip {
    
    int filas = 5;
    int columnas = 5;

    char[][] tablero = new char[filas][columnas];

    public BattleShip(){                //Llenar tablero

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

