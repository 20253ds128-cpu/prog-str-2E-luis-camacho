
import java.sql.SQLOutput;
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
                    double IMC = calcularIMC(pesoKg, estaturaM);
                    System.out.println("IMC: " + IMC);
            }
        } while (opcion != 5);
    }

    public static double obtenerDouble(Scanner sc, String mensaje) {
        System.out.println(mensaje);
        return sc.nextDouble();
    }

    public static double calcularIMC(double pesoKg, double estaturaM) {
        return pesoKg/(estaturaM*estaturaM);
    }



}
