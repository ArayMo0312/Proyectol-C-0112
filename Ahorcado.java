import java.util.Scanner;
public class Ahorcado {

    private String palabraSecreta;
    private char[] progreso;
    private int intentosRestantes;
    private int intentosMaximos = 6;

    public Ahorcado (String palabraSecreta) {
        this.palabraSecreta = palabraSecreta.toLowerCase();
        this.intentosRestantes = intentosMaximos;
        this.progreso = new char [palabraSecreta.length()];

    for (int i = 0; i < progreso.length; i++) {
        progreso [i] = '_';
    }
    }

    public void jugar(){
        Scanner scanner = new Scanner(System.in);
        boolean adivinó = false;

        System.out.println("--- Comienza el juego del Ahorcado! :) ---");

        while (intentosRestantes > 0 && !adivinó) {
            System.out.print("Palabra: ");
            for (int i = 0; i < progreso.length; i++){
                char x = progreso [i]; //variable para guardar el valor en el array progreso
            }

            System.out.println("\n Intentos restantes: " + intentosRestantes);
            System.out.print("Ingrese una letra: ");
            char letra = scanner.next().toLowerCase().charAt(0);

            boolean letraCorrecta = false;
            for (int i = 0; i < palabraSecreta.length(); i++){
                if (palabraSecreta.charAt(i) == letra && progreso[i] == '_'){
                    progreso[i] = letra;
                    letraCorrecta = true;
                }
            }
            if (!letraCorrecta) {
                intentosRestantes--;
                System.out.println("Letra incorrecta! :(");
            } else {
                System.out.println("Letra Correcta! :)");
            }
            adivinó = true;
            for (int i = 0; i < progreso.length; i++){
                char x = progreso [i];
                if (x == '_'){
                    adivinó = false;
                    break;
                }
            }
        }
    }
}

