
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //INPUT
        double pesoKg = leerDoubleEnRango(sc, "Ingresa el peso (0.1 - 50.0): ", 0.1, 50.0);
        int distanciaKm = leerIntEnRango(sc, "Ingresa la distancia (1 - 2000): ", 1, 2000);
        int tipoServicio = leerIntEnRango(sc, "Tipo de servicio (1=Estandar, 2=Express): ", 1, 2);
        boolean esZonaRemota = leerBoolean(sc, "¿Es zona remota? (true/false): ");

        //PROCESS
        ShippingCalculator calc = new ShippingCalculator();

        double subtotal = calc.calcularSubtotal(pesoKg, distanciaKm, tipoServicio, esZonaRemota);
        double iva = calc.calcularIVA(subtotal);
        double total = calc.calcularTotal(subtotal, iva);

        //OUTPUT
        imprimirTicket(tipoServicio, pesoKg, distanciaKm, esZonaRemota, subtotal, iva, total);

    }

    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double valor;
        while (true) {
            System.out.println(msg);
            if (sc.hasNextDouble()) {
                valor = sc.nextDouble();
                if (valor >= min && valor <= max) {
                    return valor;
                } else {
                    System.out.println("Error: el número está fuera del rango.");
                }
            } else {
                System.out.println("Error: debes ingresar un número decimal.");
                sc.next();
            }
        }
    }

    public static boolean leerBoolean(Scanner sc, String msg) {
        while (true) {
            System.out.println(msg);
            if (sc.hasNextBoolean()) {
                return sc.nextBoolean();
            } else {
                System.out.println("Error: solo se acepta true o false.");
                sc.next();
            }
        }
    }

    public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int valor;
        while (true) {
            System.out.println(msg);
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                if (valor >= min && valor <= max) {
                    return valor;
                } else {
                    System.out.println("Error: el numro está fuera del rango.");
                }
            } else {
                System.out.println("Error: debes ingresar un número entero.");
                sc.next();
            }
        }
    }

    public static void imprimirTicket(int servicio, double peso, int distancia, boolean zonaRemota, double subtotal, double iva, double total) {
        System.out.println("------ TICKET DE ENVÍO ------");
        if (servicio == 1) {
            System.out.println("Servicio: Estandar");
        } else {
            System.out.println("Servicio: Express");
        }
        System.out.println("Peso (kg): " + peso);
        System.out.println("Distancia (km): " + distancia);
        System.out.println("Zona remota: " + zonaRemota);
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("IVA: $" + iva);
        System.out.println("Total: $" + total);
        System.out.println("---------------------------");
    }

}