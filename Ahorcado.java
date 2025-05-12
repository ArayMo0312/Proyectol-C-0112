import java.util.Scanner;
public class Ahorcado {

    private String palabraSecreta;
    private char[] progreso;
    private int intentosRestantes;
    private final int intentosMaximos = 6;

    public Ahorcado (String palabraSecreta) {
        this.palabraSecreta = palabraSecreta.toLowerCase();
        this.intentosRestantes = intentosMaximos;
        this.progreso = new char [palabraSecreta.length()];

    for (int i = 0; i < progreso.length; i++) {
        progreso [i] = '_';
    }
    }

    public int jugar(){
        Scanner scanner = new Scanner(System.in);
        boolean adivinó = false;
        int fallosEnEstaRonda = 0;

        System.out.println("--- Comienza el juego del Ahorcado! :) ---");

        while (intentosRestantes > 0 && !adivinó) {
            System.out.print("Palabra: ");
            for (int i = 0; i < progreso.length; i++){
                char x = progreso [i]; //variable para guardar el valor en el array progreso
                System.out.print(progreso[i] + " ");
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
                fallosEnEstaRonda++;
                System.out.println("Letra incorrecta! :(");
                System.out.println();
            } else {
                System.out.println("Letra Correcta! :)");
                System.out.println();
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
        if (adivinó) {
            System.out.println("¡Adivinaste la palabra secreta!: " + palabraSecreta);
        } else {
            System.out.println("¡Perdiste! La palabra era: " + palabraSecreta);
        }
        return fallosEnEstaRonda;
    }
}

