import java.util.Scanner;
public class GUI {

    Scanner input = new Scanner(System.in);
    int respuesta; //private getters y setters


    public void Inicio(){

        while(respuesta != 3){  //Se seguira el juego hasta que el usuario responda 3

            System.out.println("----------------------------ARCADE----------------------------");
            System.out.println("");
            System.out.println("----------------------Seleccione el juego---------------------");
            System.out.println("");
            System.out.println("                         1.Ahorcado                           ");
            System.out.println("                         2.Batalla Naval                      ");
            System.out.println("");
            System.out.println("              //presione 3 para salir del programa//          ");
            System.out.println("");
            System.out.println("");
            System.out.println("");

            respuesta = input.nextInt();

            if(respuesta == 1){   //Inicia El juego Ahorcado
                input.nextLine();

                System.out.println("Ingrese el nombre del jugador 1: ");
                String nombre1 = input.nextLine();
                JugadorAhorcado jugador1 = new JugadorAhorcado(nombre1);

                System.out.println("Ingrese el nombre del jugador 2: ");
                String nombre2 = input.nextLine();
                JugadorAhorcado jugador2 = new JugadorAhorcado(nombre2);

                boolean seguirJugando = true;
                while (seguirJugando){
                    int[] fallos = Ahorcado.jugarRondaAhorcado(jugador1, jugador2);
                    Ahorcado.mostrarResultados(jugador1, jugador2, fallos[0], fallos[1]);

                    
                    System.out.println("¿Desean jugar otra ronda? (s/n): ");
                    String continuar = input.nextLine().toLowerCase();
                    seguirJugando = continuar.equals("s");

                }
            }
            if(respuesta == 2){   //Inicia El juego Batalla Naval
                boolean jugar = true;
                while (jugar){

                    BatallaNaval juego = new BatallaNaval();

                    System.out.println("BATALLA NAVAL");
                    juego.InicioBS();

                    System.out.println("");
                    System.out.println("Desea jugar otra vez? (1.SI  -  2.No)");

                    respuesta = input.nextInt();

                    if (respuesta == 2){jugar = false;}     //confirmacion para jugar otra vez
                }
            }
        }

        System.out.println("Gracias por jugar!");

    }


    public static void limpiarPantalla(){                   //Metodo para simular una limpieza de pantalla
        for (int i = 0; i < 50; i++) {System.out.println();}
    }

}
