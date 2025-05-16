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

    public void mostrarTablero(){      //Mostrar el tablero con o sin modificaciones, y con coordenadas
        System.out.print("   ");     //imprime un espacio en la esquina superior izq para imprimir bien el encabezado
        for(int c = 0; c < columnas; c++){
            System.out.print(c + "  ");     //Imprimir encabezado de columnas
        }
        System.out.println();

        for(int i = 0; i < filas; i++){
            System.out.print(i + "  ");       //imprimir el indice de las filas
            for(int j = 0; j < columnas; j++){
                System.out.print(tablero[i][j] + "  "); // espacio entre las casillas
            }
            System.out.println();
        }
    }

    public void tableroOculto() {           //metodo muy similar al anterior pero ocultando las B de los barcos
        System.out.print("   ");
        for (int c = 0; c < columnas; c++) {
            System.out.print(c + "  ");
        }
        System.out.println();

        for (int i = 0; i < filas; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < columnas; j++) {
                char espacio = tablero[i][j];
                if (espacio == 'B') {
                    System.out.print("~  "); // Oculta los barcos cambiando el simbolo
                } else {
                    System.out.print(espacio + "  "); 
                }
            }
            System.out.println();
        }
    }         
    
}

