
import java.util.Scanner;

public class SumaAcumulada {

    public static void main(String[] args) {
        // 1. Solicitud de número al usurio
        int limite = pedirEntero("Ingresa un número entero positivo: ");

        // 2. Proceso para realizar el calculo
        int sumaTotal = calcularSumaHastaN(limite);

        // 3. Mostrar resultado al usuario
        System.out.println("La suma de los números del 1 al " + limite + " es: " + sumaTotal);
    }

    /**
     * Solicita un número al usuari mediante la consola.
     * @param mensaje Texto que se mostrará al usuario.
     * @return El número entero ingresado.
     */
    public static int pedirEntero(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje);

        int numero = scanner.nextInt();
        return numero;
    }

    /**
     * Realiza la suma de 1 hasta el número dado.
     * @param n El límite superior de la suma.
     * @return La suma tptal.
     */
    public static int calcularSumaHastaN(int n) {
        int sumaAcumulada = 0;
        for (int i = 1; i <= n; i++) {
            sumaAcumulada += i;
        }
        return sumaAcumulada;
    }
}