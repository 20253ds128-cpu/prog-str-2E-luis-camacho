
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        int opc;
        Scanner sc = new Scanner(System.in);

        Persona [] personas = new Persona[3];
        InputValidator inputValidator = new InputValidator();

        do {
            System.out.println("Menú");
            System.out.println("1. Alta");
            System.out.println("2. Buscar por ID (solo activas)");
            System.out.println("3. Baja lógica por ID");
            System.out.println("4. Listar activas");
            System.out.println("5. Actualizar nombre por ID (solo activas)");
            System.out.println("0. Salir");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    int id = inputValidator.validarId("Ingresa el ID:", sc);
                    break;
                case 2:

                case 3:

                case 4:

                case 5:
            }

        } while (opc != 0);

    }
}
