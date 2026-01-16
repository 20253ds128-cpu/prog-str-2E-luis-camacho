import java.util.Scanner;

public class Main {

    public static double IVA = 0.16;
    public static double UMBRAL_DESCUENTO = 1000;
    public static double DESCUENTO = 0.10;

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        double subtotal = obtenerDouble(sc, "Dame el subtotal: ");
        double total = calcularTotal(subtotal);

        System.out.println("Total: " + total);
    }

    public static double obtenerDouble(Scanner sc, String mensaje) {
        System.out.println(mensaje);
        return sc.nextDouble();
    }

    public static double calcularTotal(double subtotal) {

        double totalConIva = subtotal + (subtotal * IVA);
        return CalcularDescuento(totalConIva);
    }

    public static double CalcularDescuento(double total) {
        if (total > UMBRAL_DESCUENTO) {
            total = total - (total * DESCUENTO);
        }
        return total;
    }
}
