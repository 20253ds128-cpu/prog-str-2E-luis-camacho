
import java.util.Scanner;

public class menuConversion {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int opcion = 0;
        int primerNum = 0;
        int segundoNum = 0;

        do {
            System.out.println("Bienvenido al menú de opciones, elige una opción: ");
            mostrarMenu();

            System.out.println("Opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opcion Invalida!");
            }


        } while (opcion != 5);

    }

    public static void mostrarMenu(){
        System.out.println("1. Convertir °C a °F");
        System.out.println("2. Convertir °F a °C");
        System.out.println("3. Convertir km a mill");
        System.out.println("4. Convertir mill a km");
        System.out.println("5. Salir");
    }
}
