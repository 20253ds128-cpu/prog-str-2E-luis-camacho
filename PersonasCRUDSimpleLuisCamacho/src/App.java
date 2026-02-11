import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        InputValidator iv = new InputValidator(sc);
        PersonaService service = new PersonaService();

        int opcion;

        do {
            mostrarMenu();
            opcion = iv.leerOpcionMenu();

            switch (opcion) {
                case 1:
                    service.alta(iv);
                    break;
                case 2:
                    service.buscar(iv);
                    break;
                case 3:
                    service.baja(iv);
                    break;
                case 4:
                    service.listarActivas();
                    break;
                case 5:
                    service.actualizar(iv);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida, intenta otra vez.");
            }

        } while (opcion != 0);

        sc.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1) Alta");
        System.out.println("2) Buscar por ID (solo activas)");
        System.out.println("3) Baja logica por ID");
        System.out.println("4) Listar activas");
        System.out.println("5) Actualizar nombre por ID");
        System.out.println("0) Salir");
    }
}