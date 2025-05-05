import java.util.Scanner;
public class BatallaNaval { // Clase de Batalla naval
    
    Tablero tablero = new Tablero();

    public void InicioBS(){

        Barco[] barcos = new Barco[4];

        barcos[0] = new Barco(1, 1, 3, 1); 
        barcos[1] = new Barco(3, 3, 1, 2); 
        barcos[2] = new Barco(0, 3, 1, 2); 
        barcos[3] = new Barco(0, 0, 4, 1); 


        colocarBarcos(tablero, barcos);

        tablero.mostrarTablero();

        while(quedanBarcos(tablero)) {
            atacar(tablero);
        }

        System.out.println("Fin del Juego");
        
    }

    public void colocarBarcos(Tablero tablero, Barco[] barcos){

        char[][] matriz = tablero.getTablero();

        for(int i = 0; i < barcos.length; i++){
            Barco barco = barcos[i];

            for(int fila = 0; fila < barco.getlargo(); fila++){
                for(int col = 0; col < barco.getAncho(); col++){

                    int ultimaFila = barco.getFila() + fila;
                    int ultimaColumna = barco.getColumna() + col;

                    if(ultimaFila < matriz.length && ultimaColumna < matriz[0].length){
                        matriz[ultimaFila][ultimaColumna] = 'B';
                    }
                }
            }

        }

    }
    
    public void atacar(Tablero tablero){

        Scanner input = new Scanner(System.in);
        char[][] matriz = tablero.getTablero();

        System.out.print("Ingrese fila (0 a 4): ");
        int fila = input.nextInt();
    
        System.out.print("Ingrese columna (0 a 4): ");
        int columna = input.nextInt();

        if(fila >= 0 && fila < 5 && columna >= 0 && columna <5){
            if(matriz[fila][columna] == 'B'){
                System.out.println("Tocado!");
                matriz[fila][columna] = 'X';
            }
            else if (matriz[fila][columna] == '~'){
                System.out.println("Agua! Intentalo de nuevo");
                matriz[fila][columna] = 'O';

            }
            else{
                System.out.println("Ya atacaste ahí");
            }
        }
        else{
            System.out.println("Coordenadas invalidas");
        }

        tablero.mostrarTablero();
    }


    public boolean quedanBarcos(Tablero tablero) {
        char[][] matriz = tablero.getTablero();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] == 'B') {
                    return true; // Aún queda al menos un barco
                }
            }
        }
        return false; // Todos hundidos

    }
    


}

