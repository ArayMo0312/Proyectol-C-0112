import java.util.Scanner;
public class GUI {

    Scanner input = new Scanner(System.in);
    int respuesta;


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
                
            }
            if(respuesta == 2){   //Inicia El juego Batalla Naval
                BatallaNaval juego = new BatallaNaval();
                juego.InicioBS();
            }
        }

    }
    
}
