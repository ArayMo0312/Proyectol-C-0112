import java.util.Scanner;
public class BatallaNaval { // Clase de Batalla naval
    
    Tablero tableroJ1 = new Tablero();
    Tablero tableroJ2 = new Tablero();
    Scanner input = new Scanner(System.in);

    public void InicioBS(){

        GUI.limpiarPantalla();
        System.out.println();
        System.out.println("Bienvenidos a batalla naval!");
        System.out.println("(Si quiere ver las intrucciones presione 1, si desea continuar al juego presione 2)");

        int r = input.nextInt(); 

        if(r == 1){intrucciones();}     //Mostrar las instrucciones 

        input.nextLine();
        
        System.out.println();
        System.out.println("Listos para la batalla?");
        System.out.println("(Presione ENTER para comenzar)");
        System.out.println();

        input.nextLine();

        Jugadores();            //LLama al metodo jugadores

        boolean turno = true;

        while(quedanBarcos(tableroJ1) && quedanBarcos(tableroJ2)) {
            if(turno){
                System.out.println("Jugador 1 Ataca!");
                System.out.println("");
                System.out.println("(Tablero J2)");
                tableroJ2.tableroOculto();  //Muestra el tablero oculto del jugador 2
                System.out.println("");

                boolean acierto = atacar(tableroJ2);

                System.out.println("");
                System.out.println("(Tablero J2)");
                tableroJ2.tableroOculto();  //Muestra el tablero del jugador 2 post ataque
                System.out.println("");

                if(!acierto){
                    turno = false;
                    System.out.println("");
                    System.out.println("(Presione ENTER para continiar)");

                    input.nextLine();

                    GUI.limpiarPantalla();
                }
                else{

                    System.out.println("");
                    System.out.println("(Presione ENTER para volver a atacar!)");

                    input.nextLine();
                }


            }
            else{
                System.out.println("Jugador 2 Ataca!");
                System.out.println("");
                System.out.println("(Tablero J1)");
                tableroJ1.tableroOculto(); //Muestra el tablero oculto del jugador 1
                System.out.println("");

                boolean acierto = atacar(tableroJ1);

                System.out.println("");
                System.out.println("(Tablero J1)");
                tableroJ1.tableroOculto();  //Muestra el tablero del jugador1 post ataque
                System.out.println("");

                if(!acierto){
                    turno = true;
                    System.out.println("");
                    System.out.println("(Presione Enter para coninuar)");

                    input.nextLine();

                    GUI.limpiarPantalla();

                }
                else{

                    System.out.println("");
                    System.out.println("(Presione ENTER para volver a atacar!)");

                    input.nextLine();
                }

                
            }
        }
        if(!quedanBarcos(tableroJ2)){       //Al salir del while porque ya no quedan barcos en alun tablero anuncia al ganador!
            System.out.println("---------------EL ganador es el Jugador 1!!!!---------------"); 
            System.out.println("");
            System.out.println("......................Fin del juego.........................");
            System.out.println("");
        }
        else{
            System.out.println("---------------EL ganador es el Jugador 2!!!!---------------");
            System.out.println("");
            System.out.println("......................Fin del juego.........................");
            System.out.println("");
        }
        
    }

    public void colocarBarcos(Tablero tablero){

        char[][] matriz = tablero.getTablero();     //un tablero lleno de agua(~)

        int[] tamaños = {2, 2};       //Los tamaños delos barcos (Segun la direccion varian, mas adelante se seleccionara y se indentificara cual lado es el ancho y cual es el largo)
        Barco[] barcos = new Barco[tamaños.length];

        for(int i = 0; i < tamaños.length; i++){

            boolean colocado = false;       //No se han colocado los barcos
            
            while(!colocado){

                int fila;
                int columna;
                char direccion;
                boolean espacioLibre = true;

                System.out.println("Coloque el barco # " + (i + 1) + " con un tamaño de " + tamaños[i] + " casillas." );
                System.out.println("");
                System.out.println("(Tome en cuenta las dimensiones del barco y la disponibilidad de casillas antes de colocarlo)");
                System.out.println("");
                System.out.println("");
                System.out.println("Seleccione la fila (0 - 4): "); //Elige la fila

                fila = input.nextInt();

                if (fila < 0 || fila > 4 ) {            //prueba si es valido
                    System.out.println("Fila invalida, intente de nuevo.");
                    continue;
                }

                System.out.println("Seleccione la columna (0 - 4): "); //Elige la columna

                columna = input.nextInt();

                if (columna < 0 || columna > 4 ) {      //prueba si es valido
                    System.out.println("Columna invalida, intente de nuevo.");
                    continue;
                }

                System.out.println("Elija la direccion (H para horizontal, V para vertical): ");

                direccion = input.next().toUpperCase().charAt(0); //Elige la direccion horizontal o vertical y lo pasa a mayuscula si es necesario

                if(direccion != 'H' && direccion != 'V'){
                    System.out.println("Direccion invalida, intente de nuevo.");
                    continue;
                }

                int largo = (direccion == 'V') ? tamaños[i] : 1; // Largo tomara el valor del tamaño del barco o de 1 segun la direccion elegida
                int ancho = (direccion == 'H') ? tamaños[i] : 1; // Ancho tomara el valor del tamaño del barco o de 1 segun la direccion elegida



                if((fila + largo) > 5 || columna + ancho > 5){  //Prueba si la posicion del barco se encuentra en los limites del tablero 
                    System.out.println("EL barco sale de los limites del tablero intente de nuevo.");
                    continue;
                }

                //Aqui se comprueba si no hay otro barco en esa posicion o chocando entre si, recorre la matriz comprobando por Barcos "B"

                for(int f = 0; f < largo; f++) {
                    for(int c = 0; c < ancho; c++){
                        if(matriz[fila + f][columna + c] == 'B'){
                            espacioLibre = false;
                            break;
                        }
                    }
                }

                if(!espacioLibre){
                    System.out.println("El barco que desea colocar interfiere con la posicion de otro barco anteriormente colocado, intente de nuevo");
                    continue;
                }

                //Si no hay problema con los casos anteriores finalmente se coloca el barco en la posicion dada por el usuario

                for(int f = 0; f < largo; f++){
                    for(int c = 0 ; c < ancho; c++){
                        matriz[fila + f][columna + c] = 'B'; //Coloca la letra B en el tablero 
                    }
                }

                barcos[i] = new Barco(fila, columna, largo, ancho);
                colocado = true;

            }
        }

    }
    
    public boolean atacar(Tablero tablero){            //metodo para atacar un tablero

        Scanner input = new Scanner(System.in);
        char[][] matriz = tablero.getTablero();

        

        boolean tiroValido = false;

        while(!tiroValido){ // en caso de que se salga de las coordenadas se puede disparar otra vez
            
            System.out.print("Ingrese fila (0 a 4): "); //pide las coordenadas aqui
            int fila = input.nextInt();
    
            System.out.print("Ingrese columna (0 a 4): "); //y aqui
            int columna = input.nextInt();
        
            if(fila >= 0 && fila < 5 && columna >= 0 && columna <5){ //Comprueba la coordenada y reacciona segun lo golpeado
                tiroValido = true;

                if(matriz[fila][columna] == 'B'){
                    System.out.println("Tocado! Juega de nuevo!");
                    matriz[fila][columna] = 'X';
                    return true;
                }
                else if (matriz[fila][columna] == '~'){
                    System.out.println("Agua!");
                    matriz[fila][columna] = 'O';
                    return false;
                }
                else{
                    System.out.println("Ya atacaste ahí");
                }
            }
            else{
                System.out.println("");
                System.out.println("Coordenadas invalidas, intente otra vez");
                System.out.println("");
            }

        }   
        return false; // Solo por seguridad
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

    public void Jugadores(){


        System.out.println("Jugador 1, coloca los barcos en el tablero");
        System.out.println();

        colocarBarcos(tableroJ1);       // El jugador 1 coloca los barcos respectivos

        System.out.println("Tablero del Jugador 1:");
        tableroJ1.mostrarTablero();     //imprime el tablero para ver la colocacion
        System.out.println("(Presione ENTER para continuar)");
        input.nextLine();
        input.nextLine();
        GUI.limpiarPantalla();

        System.out.println("Jugador 2, coloca los barcos en el tablero");
        System.out.println();

        colocarBarcos(tableroJ2);       // El jugador  coloca los barcos respectivos

        System.out.println("Tablero del Jugador 2:");
        tableroJ2.mostrarTablero();     //imprime el tablero para ver la colocacion
        System.out.println("(Presione ENTER para continuar)");  
        input.nextLine();
        input.nextLine();
        GUI.limpiarPantalla();

    }

    public void intrucciones(){     //Intrucciones basicas del juego 
        System.out.println();
        System.out.println("--------------INSTRUCCIONES--------------");
        System.out.println();
        System.out.println("1.Cada jugador cuenta con un lado del tablero y 4 barcos de diferentes tamaños.");
        System.out.println();
        System.out.println("1.Los jugadores deberan colocar los barcos en cada lado de su tablero.");
        System.out.println();
        System.out.println("2.Una vez colocados, atacaran una coordenanda del tablero, una vez por turno.");
        System.out.println();
        System.out.println("3.Si el ataque impacta a una nave enemiga se marcara en el tablero con una 'X'.");
        System.out.println();
        System.out.println("4.Si de lo contario, el ataque falla, se marcara en el tablero con una'O'.");
        System.out.println();
        System.out.println("5.El primer jugador en acabar con todaslas naves enemigas es el ganador!!!");
        System.out.println();
        System.out.println();

        input.nextLine();

        System.out.println("(Presione ENTER para continuar)");

    }

}

