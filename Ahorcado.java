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

    public int jugar(){ //inicia el juego
        Scanner scanner = new Scanner(System.in);
        boolean adivinó = false;
        int fallosEnEstaRonda = 0;

        System.out.println("--- Comienza el juego del Ahorcado! :) ---");

        while (intentosRestantes > 0 && !adivinó) { //Sólo se sigue jugando si aún le quedan intentos y no ha adivinado
            System.out.print("Palabra: ");
            for (int i = 0; i < progreso.length; i++){
                System.out.print(progreso[i] + " ");
            }

            System.out.println("\n Intentos restantes: " + intentosRestantes);
            System.out.print("Ingrese una letra: ");
            char letra = scanner.next().toLowerCase().charAt(0); //Lee la siguiente letra, en minuscula

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

     public static String pedirPalabraSecreta(String nombreJugador) { // método que verifica que la palabra no tenga caracteres especiales ni números y elimina espacios en blanco
        Scanner scanner = new Scanner(System.in);
        String palabra;
        while (true) {
            System.out.println(nombreJugador + ", ingrese la palabra secreta (solo letras, sin espacios ni números): ");
            palabra = scanner.nextLine().trim();

            if (!palabra.matches("[a-zA-Z]+")) {
                System.out.println("Entrada inválida. Ingrese solo letras sin espacios ni símbolos.");
            } else {
                break;
            }
        }
        return palabra;
    }

    public static int[] jugarRondaAhorcado(JugadorAhorcado jugador1, JugadorAhorcado jugador2) { //método que inicia la ronda de juego
        String palabra1 = pedirPalabraSecreta(jugador1.getNombre());
        GUI.limpiarPantalla();

        System.out.println("Turno de " + jugador2.getNombre());
        Ahorcado juego1 = new Ahorcado(palabra1);
        int fallosJugador2 = juego1.jugar();
        jugador2.agregarFallos(fallosJugador2);

        String palabra2 = pedirPalabraSecreta(jugador2.getNombre());
        GUI.limpiarPantalla();

        System.out.println("Turno de " + jugador1.getNombre());
        Ahorcado juego2 = new Ahorcado(palabra2);
        int fallosJugador1 = juego2.jugar();
        jugador1.agregarFallos(fallosJugador1);

        mostrarResultados(jugador1, jugador2, fallosJugador1, fallosJugador2);
        return new int[]{fallosJugador1, fallosJugador2};
    }

    public static void mostrarResultados(JugadorAhorcado jugador1, JugadorAhorcado jugador2, int fallos1, int fallos2) { //método para mostrar ganadores o empates y puntaje
        System.out.println("\n --- RESULTADOS DE LA RONDA ---");
        System.out.println(jugador1.getNombre() + " falló: " + fallos1 + " veces.");
        System.out.println(jugador2.getNombre() + " falló: " + fallos2 + " veces.");

        if (fallos1 < fallos2) {
            System.out.println("¡El ganador de esta ronda es: " + jugador1.getNombre() + "!");
        } else if (fallos1 > fallos2) {
            System.out.println("¡El ganador de esta ronda es: " + jugador2.getNombre() + "!");
        } else {
            System.out.println("¡Hubo un empate!");
        }

        System.out.println("\n --- PUNTAJE TOTAL ---");
        System.out.println(jugador1.getNombre() + ": " + jugador1.getFallosTotales() + " fallos acumulados.");
        System.out.println(jugador2.getNombre() + ": " + jugador2.getFallosTotales() + " fallos acumulados.");
    }
}

