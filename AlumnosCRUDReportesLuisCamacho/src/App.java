import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        AlumnoManager manager = new AlumnoManager();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMENU");
            System.out.println("1. Alta alumno");
            System.out.println("2. Buscar por ID");
            System.out.println("3. Actualizar promedio");
            System.out.println("4. Baja lógica");
            System.out.println("5. Listar activos");
            System.out.println("6. Reportes");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1: manager.altaAlumno(); break;
                case 2: manager.buscarAlumno(); break;
                case 3: manager.actualizarPromedio(); break;
                case 4: manager.bajaLogica(); break;
                case 5: manager.listarActivos(); break;
                case 6: manager.reportes(); break;
                case 0: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}