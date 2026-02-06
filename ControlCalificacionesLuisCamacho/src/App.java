import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GradeService service = new GradeService();

        // ===== INPUT =====
        String nombre = InputValidator.leerTextoNoVacio(sc, "Nombre del alumno: ");

        double p1 = InputValidator.leerDoubleEnRango(sc, "Parcial 1 (0-100): ", 0, 100);
        double p2 = InputValidator.leerDoubleEnRango(sc, "Parcial 2 (0-100): ", 0, 100);
        double p3 = InputValidator.leerDoubleEnRango(sc, "Parcial 3 (0-100): ", 0, 100);

        int asistencia = InputValidator.leerIntEnRango(sc, "Asistencia (0-100): ", 0, 100);

        boolean entregoProyecto = InputValidator.leerBoolean(sc, "¿Entregó proyecto? (true/false): ");

        // ===== PROCESO =====
        double promedio = service.calcularPromedio(p1, p2, p3);
        double finalCalif = service.calcularFinal(promedio, asistencia);
        String estado = service.determinarEstado(finalCalif, asistencia, entregoProyecto);

        // ===== OUTPUT =====
        imprimirReporte(nombre, p1, p2, p3, promedio, asistencia, entregoProyecto, finalCalif, estado);

        sc.close();
    }

    public static void imprimirReporte(
            String nombre,
            double p1, double p2, double p3,
            double promedio,
            int asistencia,
            boolean entregoProyecto,
            double finalCalif,
            String estado
    ) {
        System.out.println("\n------ REPORTE FINAL ------");
        System.out.println("Alumno: " + nombre);
        System.out.println("Parciales: " + p1 + ", " + p2 + ", " + p3);
        System.out.printf("Promedio parciales: %.2f%n", promedio);
        System.out.println("Asistencia: " + asistencia + "%");
        System.out.println("Entregó proyecto: " + entregoProyecto);
        System.out.printf("Calificación final: %.2f%n", finalCalif);
        System.out.println("Estado: " + estado);
    }
}