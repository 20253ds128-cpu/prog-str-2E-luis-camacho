import java.util.Scanner;

public class ActividadSwitchCalculadora {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("----- CALCULADORA -----");
        System.out.println("1) Sumar");
        System.out.println("2) Restar");
        System.out.println("3) Multiplicar");
        System.out.println("4) Dividir");

        System.out.print("Ingrese una opción: ");
        int opcion = scanner.nextInt();

        System.out.print("Ingrese el valor de a: ");
        double a = scanner.nextDouble();

        System.out.print("Ingrese el valor de b: ");
        double b = scanner.nextDouble();

        switch (opcion) {
            case 1:
                System.out.println("Operación elegida: Suma");
                mostrarDatos(a, b);
                System.out.println("Resultado: " + sumar(a, b));
                break;

            case 2:
                System.out.println("Operación elegida: Resta");
                mostrarDatos(a, b);
                System.out.println("Resultado: " + restar(a, b));
                break;

            case 3:
                System.out.println("Operación elegida: Multiplicación");
                mostrarDatos(a, b);
                System.out.println("Resultado: " + multiplicar(a, b));
                break;

            case 4:
                System.out.println("Operación elegida: División");
                mostrarDatos(a, b);
                if (b == 0) {
                    System.out.println("No se puede dividir entre cero");
                } else {
                    System.out.println("Resultado: " + dividir(a, b));
                }
                break;

            default:
                System.out.println("Opción inválida");
                break;
        }

        scanner.close();
    }

    /**
     * Suma dos números.
     *
     * @param a primer valor
     * @param b segundo valor
     * @return resultado de la suma
     */
    public static double sumar(double a, double b) {
        return a + b;
    }

    /**
     * Resta dos números.
     *
     * @param a primer valor
     * @param b segundo valor
     * @return resultado de la resta
     */
    public static double restar(double a, double b) {
        return a - b;
    }

    /**
     * Multiplica dos números.
     *
     * @param a primer valor
     * @param b segundo valor
     * @return resultado de la multiplicación
     */
    public static double multiplicar(double a, double b) {
        return a * b;
    }

    /**
     * Divide dos números.
     *
     * @param a numerador
     * @param b denominador
     * @return resultado de la división
     */
    public static double dividir(double a, double b) {
        return a / b;
    }

    /**
     * Muestra los valores ingresados por el usuario.
     *
     * @param a valor a
     * @param b valor b
     */
    public static void mostrarDatos(double a, double b) {
        System.out.println("Valor a: " + a);
        System.out.println("Valor b: " + b);
    }
}
