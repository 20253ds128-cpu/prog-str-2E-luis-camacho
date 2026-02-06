import java.util.Scanner;

public class InputValidator {

    public static String leerTextoNoVacio(Scanner sc, String msg) {
        String texto;
        while (true) {
            System.out.print(msg);
            texto = sc.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("Error: el texto no puede estar vacío.");
        }
    }

    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        while (true) {
            System.out.print(msg);
            if (sc.hasNextDouble()) {
                double valor = sc.nextDouble();
                if (valor >= min && valor <= max) {
                    sc.nextLine();
                    return valor;
                }
            } else {
                sc.next();
            }
            System.out.println("Error: ingresa un número entre " + min + " y " + max);
        }
    }

    public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            if (sc.hasNextInt()) {
                int valor = sc.nextInt();
                if (valor >= min && valor <= max) {
                    sc.nextLine();
                    return valor;
                }
            } else {
                sc.next();
            }
            System.out.println("Error: ingresa un entero entre " + min + " y " + max);
        }
    }

    public static boolean leerBoolean(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            if (sc.hasNextBoolean()) {
                boolean valor = sc.nextBoolean();
                sc.nextLine();
                return valor;
            } else {
                sc.next();
                System.out.println("Error: escribe solo true o false.");
            }
        }
    }
}