
import java.util.Scanner;

public class actividadIfElseTarifa {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa tu edad: ");
        int edad = sc.nextInt();

        if (edad < 0 || edad > 120) {
            System.out.println("Edad inválida.");
        } else {

            System.out.println("¿Eres estudiante? S/N");
            String respuesta = sc.next();

            boolean esEstudiante;

            if (respuesta.equalsIgnoreCase("S")) {
                esEstudiante = true;
            } else {
                esEstudiante = false;
            }

            int tarifa = calcularTarifa(edad, esEstudiante);

            System.out.println("Edad: " + edad);
            System.out.println("Es estudiante: " + esEstudiante);
            System.out.println("Tarifa final: " + tarifa);

        }

        sc.close();
    }

    /**
     * Calcula la tarifa final en base a la edad y en si es estudiante.
     * @param edad Edad ingresada del usuario.
     * @param esEstudiante Indica si el usuario es estudiante.
     * @return La tarifa final calculada segun las condiciones.
     */
    public static int calcularTarifa(int edad, boolean esEstudiante) {
        int tarifa;

        if (edad < 12) {
            tarifa = 50;
        } else if (edad <= 17) {
            if (esEstudiante) {
                tarifa = 60;
            } else {
                tarifa = 80;
            }
        } else {
            if (esEstudiante) {
                tarifa = 90;
            } else {
                tarifa = 120;
            }
        }

        return tarifa;
    }
}
