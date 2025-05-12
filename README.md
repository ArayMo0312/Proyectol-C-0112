# Proyecto 1 - Arcade de Batalla Naval y Ahorcado

Este proyecto de Programación I permite jugar dos juegos clásicos en consola: **Batalla Naval** y **Ahorcado**, desarrollados en Java. Ambos juegos están diseñados para dos jugadores, alternando turnos, validación de entradas y condiciones de victoria.

## Ejecucion del pograma

1. Abrí el proyecto en tu IDE (Blue J, Visual Studio, etc).
2. Ejecutá la clase Main.java.
3. Aparecerá un menú con tres opciones:
    - 1. Ahorcado
    - 2. Batalla Naval
    - 3. Salir
4. Ingresá el número del juego que querés jugar y seguí las instrucciones en consola.

---

## Juegos incluidos

### Ahorcado
- Jugador 1 escribe una palabra secreta.
- Jugador 2 intenta adivinarla, letra por letra.
- Tiene 6 oportunidades de error antes de perder.
- Luego se invierten los roles.
- Se pueden jugar múltiples rondas y se muestra un resumen de fallos y quién ganó.
- Al finalizar las rondas se puede reiniciar el juego con nuevos jugadores.

### Batalla Naval
- Cada jugador coloca 4 barcos de diferentes tamaños.
- Los barcos se colocan en un tablero de 5x5, eligiendo dirección (horizontal o vertical).
- Durante el juego:
    - Si acertás el disparo (Tocado!), jugás de nuevo.
    - Si fallás (Agua!), el turno pasa al otro jugador.
- El juego termina cuando un jugador hunde todos los barcos del otro.
- Podés jugar varias partidas seguidas si así lo deseás.

---

## Clases del Proyecto

- Main.java – Punto de entrada del programa.
- GUI.java – Muestra el menú prncipal y controla el flujo general de los juegos.
- Ahorcado.java – Contiene la lógica del juego de ahorcado.
- JugadorAhorcado.java – Clase para llevar registro de nombre y fallos de cada jugador.
- BatallaNaval.java – controla el flujo del juego naval: colocar barcos, turnos, ataques.
- Barco.java – Representa un barco con posición, largo y ancho.
- Tablero.java – Representa la matriz 5x5 de cada jugador y métodos para mostrarla.
- README.md – Este archivo de ayuda.
- Archivo de decisiones.txt – Documento donde explicamos acuerdos, diseño y mejoras futuras.

---

## Requisitos

- Java 8 o superior.
- Entrada y salida en consola (Scanner y System.out.print).
- Código modular, limpio y separado.

---

## Créditos

Desarrollado por:
- [David Araya Montero] – [C4C553]
- [Nombre 2] – [Carné]

Para el curso de **Programación I**, grupo C0112, ciclo 2025-1.