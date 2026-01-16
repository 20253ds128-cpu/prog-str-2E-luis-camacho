
import java.util.Scanner;

public class Main {

    public static int opcion = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Ingresa una opción (1-5): ");
            System.out.println("1. Calcular IMC");
            System.out.println("2. Calcular área de un rectángulo");
            System.out.println("3. Convertir °C a °F");
            System.out.println("4. Calcular area de un círculo");
            System.out.println("5. Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    double pesoKg = obtenerDouble(sc, "Ingresa tu peso en kg: ");
                    double estaturaM = obtenerDouble(sc, "Ingresa tu estatura en metros: ");
                    double imc = calcularIMC(pesoKg, estaturaM);
                    System.out.println("Tu IMC es: " + imc);
                    break;

                case 2:
                    double base = obtenerDouble(sc, "Ingresa la base del rectángulo: ");
                    double altura = obtenerDouble(sc, "Ingresa la altura del rectángulo: ");
                    double areaRect = calcularAreaRectangulo(base, altura);
                    System.out.println("Área del rectángulo: " + areaRect);
                    break;

                case 3:
                    double celsius = obtenerDouble(sc, "Ingresa los grados Celsius: ");
                    double fahrenheit = convertirCelsiusAFahrenheit(celsius);
                    System.out.println("Grados Fahrenheit: " + fahrenheit);
                    break;

                case 4:
                    double radio = obtenerDouble(sc, "Ingresa el radio del círculo: ");
                    double areaCirc = calcularAreaCirculo(radio);
                    System.out.println("Área del círculo: " + areaCirc);
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida, intenta de nuevo.");
            }

            System.out.println();

        } while (opcion < 5 && opcion > 0);

        sc.close();
    }

    /**
     * Solicita un valor decimal al usuario mostrando un mensaje.
     *
     * @param sc Scanner para leer datos
     * @param mensaje Mensaje que se muestra al usuario
     * @return valor double ingresado
     */
    public static double obtenerDouble(Scanner sc, String mensaje) {
        System.out.println(mensaje);
        return sc.nextDouble();
    }

    /**
     * Calcula el Índice de Masa Corporal (IMC).
     *
     * @param peso Peso en kilogramos
     * @param estatura Estatura en metros
     * @return valor del IMC
     */
    public static double calcularIMC(double peso, double estatura) {
        return peso / (estatura * estatura);
    }

    /**
     * Calcula el área de un rectángulo.
     *
     * @param base Base del rectángulo
     * @param altura Altura del rectángulo
     * @return área del rectángulo
     */
    public static double calcularAreaRectangulo(double base, double altura) {
        return base * altura;
    }

    /**
     * Convierte grados Celsius a Fahrenheit.
     *
     * @param celsius Grados Celsius
     * @return grados Fahrenheit
     */
    public static double convertirCelsiusAFahrenheit(double celsius) {
        return (celsius * 1.8) + 32;
    }

    /**
     * Calcula el área de un círculo.
     *
     * @param radio Radio del círculo
     * @return área del círculo
     */
    public static double calcularAreaCirculo(double radio) {
        return Math.PI * radio * radio;
    }
}
