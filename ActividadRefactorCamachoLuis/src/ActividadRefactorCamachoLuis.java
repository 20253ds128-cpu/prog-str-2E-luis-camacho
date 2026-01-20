
import java.util.Scanner;

public class ActividadRefactorCamachoLuis{

    public static double CANTIDAD_NUMEROS = 3;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = pedirEntero(scanner, "\nPrimer número: ");

        int b = pedirEntero(scanner, "Segundo número: ");

        int c = pedirEntero(scanner, "Tercer número: ");

        calcularEImprimirSuma(a, b, c);
        calcularEImprimirProm(a, b, c);

    }

    /**
     * Método que recibe un número ingresado por el usuario.
     *
     * @param scanner Lee la entrada del usuario.
     * @param mensaje Muestra el mensaje para pedir el 1er, 2do y 3er número.
     * @return Número entero introducido por el usuario.
     */
    public static int pedirEntero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    /**
     * Método que calcula e imprime el resultado de la suma de los 3 numeros.
     *
     * @param a Primer número.
     * @param b Segundo número.
     * @param c Tercer número.
     */
    public static void calcularEImprimirSuma(int a, int b, int c) {
        int suma = a + b + c;
        System.out.println("\nSuma = " + suma);
    }

    /**
     * Método que calcula el promedio dividiendo la suma entre la cantidad de numeros.
     *
     * @param a Primer número.
     * @param b Segundo número.
     * @param c Tercer número.
     */
    public static void calcularEImprimirProm(int a, int b, int c) {
        double promedio = (a + b + c) / CANTIDAD_NUMEROS;
        System.out.println("Promedio = " + promedio);
    }

}
