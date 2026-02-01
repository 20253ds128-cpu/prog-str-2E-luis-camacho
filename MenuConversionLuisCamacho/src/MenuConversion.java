import java.util.Scanner;

public class MenuConversion {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int opcion;
        int totalConversiones = 0;

        int contCelsiusF = 0;
        int contFahrenheitC = 0;
        int contKmMillas = 0;
        int contMillasKm = 0;

        do {
            mostrarMenu();
            opcion = leerOpcion(scanner);

            switch (opcion) {
                case 1:
                    double c = leerNumero(scanner, "Ingresa los °C: ");
                    double f = convertirCelsiusAFahrenheit(c);
                    System.out.println("Resultado: " + f + " °F");
                    contCelsiusF++;
                    totalConversiones++;
                    break;

                case 2:
                    double f2 = leerNumero(scanner, "Ingresa los °F: ");
                    double c2 = convertirFahrenheitACelsius(f2);
                    System.out.println("Resultado: " + c2 + " °C");
                    contFahrenheitC++;
                    totalConversiones++;
                    break;

                case 3:
                    double km = leerNumero(scanner, "Ingresa los Km: ");
                    double millas = convertirKmAMillas(km);
                    System.out.println("Resultado: " + millas + " Millas");
                    contKmMillas++;
                    totalConversiones++;
                    break;

                case 4:
                    double millas2 = leerNumero(scanner, "Ingresa las Millas: ");
                    double km2 = convertirMillasAKm(millas2);
                    System.out.println("Resultado: " + km2 + " Km");
                    contMillasKm++;
                    totalConversiones++;
                    break;

                case 5:
                    System.out.println("\n--- Resumen ---");
                    System.out.println("Total de conversiones: " + totalConversiones);
                    System.out.println("°C a °F: " + contCelsiusF);
                    System.out.println("°F a °C: " + contFahrenheitC);
                    System.out.println("Km a Millas: " + contKmMillas);
                    System.out.println("Millas a Km: " + contMillasKm);
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }

            System.out.println();

        } while (opcion != 5);

        scanner.close();
    }

    // ----- MENÚ -----
    public static void mostrarMenu() {
        System.out.println("Menú de conversiones");
        System.out.println("1. Convertir °C a °F");
        System.out.println("2. Convertir °F a °C");
        System.out.println("3. Convertir Km a Millas");
        System.out.println("4. Convertir Millas a Km");
        System.out.println("5. Salir");
    }

    // ----- VALIDACIONES -----
    public static int leerOpcion(Scanner scanner) {
        int opcion;

        while (true) {
            System.out.print("Opción: ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= 5) {
                    return opcion;
                } else {
                    System.out.println("La opción debe estar entre 1 y 5.");
                }
            } else {
                System.out.println("Debes ingresar un número.");
                scanner.next();
            }
        }
    }

    public static double leerNumero(Scanner scanner, String mensaje) {
        double numero;

        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextDouble()) {
                numero = scanner.nextDouble();
                return numero;
            } else {
                System.out.println("Entrada inválida. Ingresa un número.");
                scanner.next();
            }
        }
    }

    // ----- CONVERSIONES -----
    public static double convertirCelsiusAFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double convertirFahrenheitACelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double convertirKmAMillas(double km) {
        return km * 0.621371;
    }

    public static double convertirMillasAKm(double millas) {
        return millas / 0.621371;
    }
}
