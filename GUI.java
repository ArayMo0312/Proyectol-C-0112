import java.util.Scanner;
public class GUI {

    Scanner input = new Scanner(System.in);
    int respuesta; //private getters y setters


    public void Inicio(){

        while(respuesta != 3){  //Se seguira el jueg hasta que el usuario responda 3

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
                    System.out.println(jugador1.getNombre() + ", ingrese la palabra secreta: ");
                    String palabra1 = input.nextLine();
                    limpiarPantalla();

                    System.out.println("Turno de " + jugador2.getNombre());
                    Ahorcado juego1 = new Ahorcado (palabra1);
                    int fallosJugador2 = juego1.jugar();
                    jugador2.agregarFallos(fallosJugador2);

                    System.out.println(jugador2.getNombre() + ", ingrese la palabra secreta: ");
                    String palabra2 = input.nextLine();
                    limpiarPantalla();

                    System.out.println("Turno de " + jugador1.getNombre());
                    Ahorcado juego2= new Ahorcado (palabra2);
                    int fallosJugador1 = juego2.jugar();
                    jugador1.agregarFallos(fallosJugador1);

                    System.out.println("\n --- RESULTADOS DE LA RONDA ---");
                    System.out.println(jugador1.getNombre() + " falló: " + fallosJugador1 + " veces.");
                    System.out.println(jugador2.getNombre() + " falló: " + fallosJugador2 + " veces.");

                    if (fallosJugador1 < fallosJugador2){
                        System.out.println("¡El ganador de esta ronda es: " + jugador1.getNombre() + "!");
                    }else if (fallosJugador1 > fallosJugador2){
                        System.out.println("¡El ganador de esta ronda es: " + jugador2.getNombre() + "!");
                    }else{
                        System.out.println("¡Hubo un empate!");
                    }
                    System.out.println("\n --- PUNTAJE TOTAL ---");
                    System.out.println(jugador1.getNombre() + ": " + jugador1.getFallosTotales() + " fallos acumulados.");
                    System.out.println(jugador2.getNombre() + ": " + jugador2.getFallosTotales() + " fallos acumulados.");
                    
                    System.out.println("¿Desean jugar otra ronda? (s/n): ");
                    String continuar = input.nextLine().toLowerCase();
                    seguirJugando = continuar.equals("s");
                    input.nextLine();

                }
            }
            if(respuesta == 2){   //Inicia El juego Batalla Naval
                BatallaNaval juego = new BatallaNaval();

                    System.out.println("BATALLA NAVAL");
                juego.InicioBS();
            }
        }

    }
    public void limpiarPantalla(){
        for (int i = 0; i < 50; i++) {System.out.println();}
    }

}
