
import java.util.Scanner;
import java.util.Random;

public class AdivinaNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random= new Random();

        int min = 1;
        int max = 100;

        int intentos = 0;
        int limIntentos = 7;

        int intentosMay = 0;
        int intentosMen = 0;

        int noNumericos = 0;

        int secreto = random.nextInt((max - min) + 1) + min;

        boolean gano = false;

        System.out.println("Adivina el número entre (" + min + "-" + max + ") " + "tienes: " + limIntentos + " intentos.");

        while (intentos < limIntentos && !gano) {
            int valor = obtenerNumeroValido(noNumericos,min, max, scanner, "Intento: " + (intentos + 1) + "\nTu número es: ");
            intentos ++;

            if (valor == secreto) {
                gano = true;
                System.out.println("Ganaste en el intento " + intentos);
                System.out.println("Fallaste " + ((intentosMen + intentosMen) - 1) + " veces.");


            } else if (valor > secreto) {
                intentosMay++;
                System.out.println("El número secreto es menor, vuelve a ingresar: ");
            } else if (valor < secreto) {
                intentosMen++;
                System.out.println("El número secreto es mayor, vuelve a ingresar: ");
            }

        }

        if (noNumericos > 0) {
            System.out.println("Ingresaste " + noNumericos + " datos no numéricos.");
        } else {
            System.out.println("No ingresaste datos no numéricos");
        }

    }

    public static int obtenerNumeroValido(int noNumericos, int min, int max, Scanner scanner, String mensaje) {
        int valor;
        while(true) {
            System.out.println(mensaje);
            if(scanner.hasNextInt()) {
                valor = scanner.nextInt();
                if(valor >= min && valor <= max) {
                    return valor;
                } else {
                    System.out.println("Número fuera de rango debe de ser entre " + min + " y" + max);
                }
            } else {
                System.out.println("El dato que ingresaste no es un número");
                scanner.next();
                noNumericos ++;
            }
        }
    }
}
