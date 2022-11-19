package lab6p1_rodrigovasquez;

import java.util.Scanner;
import java.util.Random;

public class Lab6P1_RodrigoVasquez {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner jonSnow = new Scanner(System.in);
        boolean twitter = false;
        //Verification Badge :D
        do {
            System.out.print("1. Juego de la Vida\n2. Piedra, Papel, o...\n3. Blink-182\nIngrese que ejercicio ejecutar: ");
            int choice = jonSnow.nextInt();
            switch (choice) {
                case 1:
                    imprimirTablero(tableroVida());
                    twitter = true;
                    break;
                case 2:
                    System.out.print("Elija que quiere usar: ");
                    String fighter = jonSnow.next();
                    piedras(fighter);
                    twitter = true;
                    break;
                case 3:
                    int[][] test = blink();
                    imprimirMatrizBlink(test);
                    blinkLetras(test);
                    twitter = true;
                    break;
                default:
                    twitter = false;
            }
        } while (twitter);
    }

    public static String[][] tableroVida() {
        String[][] tablero = new String[8][8];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (i == 0 && j == 0) {
                    tablero[0][0] = "P";
                } else if (i == j && (i != 7 && j != 7)) {
                    tablero[i][j] = "+";
                    tablero[0][3] = "+";
                    tablero[0 + 1][3 + 1] = "+";
                    tablero[0 + 2][3 + 2] = "+";
                    tablero[0 + 3][3 + 3] = "+";
                    tablero[0 + 4][3 + 4] = "+";
                    tablero[3][0] = "+";
                    tablero[3 + 1][0 + 1] = "+";
                    tablero[3 + 2][0 + 2] = "+";
                    tablero[3 + 3][0 + 3] = "+";
                    tablero[3 + 4][0 + 4] = "+";
                } else if (i % 2 == 0 && j % 2 == 0) {
                    tablero[i][j] = "~";
                } else {
                    tablero[i][j] = " ";
                }
            }
        }
        int cont = 0;
        do {
            int fila = 0;
            int columna = 0;
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero[i].length; j++) {
                    if (tablero[i][j].equals("P")) {
                        fila = i;
                        columna = j;
                    }
                }
            }
            int dado = new Random().nextInt((6 - 1) + 1) + 1;
            for (int i = fila; i < tablero.length; i++) {
                for (int j = columna; j < tablero[i].length; j++) {
                    tablero[i][j] = " ";
                    if (j + dado < tablero[i].length) {
                        for (int k = 1; k <= dado; k++) {
                            if (k == dado) {
                                tablero[i][j + k] = "P";
                            } else {
                                tablero[i][j + k] = ">";
                            }
                        }
                    } else {
                        int contDado = 0;
                        for (int k = j; k < tablero[i].length; k++) {
                            for (int l = 1; l <= dado; l++) {
                                if (l == dado) {
                                    tablero[i][j + l] = "P";
                                } else {
                                    tablero[i][j + l] = ">";
                                }
                            }
                            contDado++;
                        }
                        int numDado = dado - contDado;
                        for (int k = 0; k < tablero[i].length; k++) {
                            for (int l = 1; l <= numDado; l++) {
                                if (l == numDado) {
                                    tablero[i + 1][k + l] = "P";
                                } else {
                                    tablero[i + 1][k + l] = ">";
                                }
                            }
                        }
                    }
                }
            }
        } while (tablero[7][7].equals(" ") && cont != 0);
        return tablero;
    }

    public static void imprimirTablero(String[][] tableroVida) {
        for (int i = 0; i < tableroVida.length; i++) {
            for (int j = 0; j < tableroVida[i].length; j++) {
                System.out.print("[" + tableroVida[i][j] + "]");
            }
            System.out.println("");
        }
    }

    public static void juegovida() {

    }

    public static void piedras(String fighter) {
        int[][] piedras = new int[5][5];
        piedras[0][0] = 6;
        piedras[0][1] = 0;
        piedras[0][2] = 2;
        piedras[0][3] = 0;
        piedras[0][4] = 4;
        piedras[1][0] = 0;
        piedras[1][1] = 6;
        piedras[1][2] = 1;
        piedras[1][3] = 3;
        piedras[1][4] = 1;
        piedras[2][0] = 2;
        piedras[2][1] = 1;
        piedras[2][2] = 6;
        piedras[2][3] = 2;
        piedras[2][4] = 4;
        piedras[3][0] = 0;
        piedras[3][1] = 3;
        piedras[3][2] = 2;
        piedras[3][3] = 6;
        piedras[3][4] = 3;
        piedras[4][0] = 4;
        piedras[4][1] = 1;
        piedras[4][2] = 4;
        piedras[4][3] = 3;
        piedras[4][4] = 6;
        int fila = 10;
        String newFighter = fighter.toLowerCase();
        switch (fighter) {
            case "tijeras":
                fila = 0;
                break;
            case "papel":
                fila = 1;
                break;
            case "roca":
                fila = 2;
                break;
            case "lagarto":
                fila = 3;
                break;
            case "spock":
                fila = 4;
                break;
        }
        int columna = new Random().nextInt((4 - 0) + 1) + 0;
        switch (columna) {
            case 0:
                System.out.println("La maquina eligió Tijeras");
                break;
            case 1:
                System.out.println("La maquina eligió Papel");
                break;
            case 2:
                System.out.println("La maquina eligió Roca");
                break;
            case 3:
                System.out.println("La maquina eligió Lagarto");
                break;
            case 4:
                System.out.println("La maquina eligió Spock");
                break;
        }
        int outcome = piedras[fila][columna];

        if (outcome == fila) {
            System.out.println("¡Jugador Gana!");
        } else if (fila == columna) {
            System.out.println("¡Empate!");
        } else {
            System.out.println("¡La máquina Gana!");
        }
    }

    public static int[][] blink() {
        Scanner magicEye = new Scanner(System.in);
        System.out.print("Ingrese el número de filas: ");
        int filas = magicEye.nextInt();
        System.out.print("Ingrese el número de columnas: ");
        int columnas = magicEye.nextInt();
        int[][] blink = new int[filas][columnas];
        for (int i = 0; i < blink.length; i++) {
            for (int j = 0; j < blink[i].length; j++) {
                blink[i][j] = new Random().nextInt((122 - 97) + 1) + 97;
            }
        }
        return blink;
    }

    public static void blinkLetras(int[][] matriz) {
        int contFilas = 0;
        int contColumnas = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                contColumnas++;
            }
            contFilas++;
        }
        char[][] matrizChar = new char[contFilas][contColumnas];
        for (int i = 0; i < matrizChar.length; i++) {
            for (int j = 0; j < matrizChar.length; j++) {
                int num = matriz[i][j];
                char letra = (char) num;
                matrizChar[i][j] = letra;
            }
        }
        for (int i = 0; i < matrizChar.length; i++) {
            for (int j = 0; j < matrizChar.length; j++) {
                System.out.print(matrizChar[i][j] + " " + "-" + " ");
            }
            System.out.println("");
        }
    }

    public static void imprimirMatrizBlink(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " " + "-" + " ");
            }
            System.out.println("");
        }
    }

}
