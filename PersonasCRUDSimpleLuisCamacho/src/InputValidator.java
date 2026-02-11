import java.util.Scanner;

public class InputValidator {

    private Scanner sc;

    public InputValidator(Scanner sc) {
        this.sc = sc;
    }

    public int leerOpcionMenu() {
        int op;

        while (true) {
            System.out.print("Opcion: ");
            try {
                op = Integer.parseInt(sc.nextLine());
                return op;
            } catch (Exception e) {
                System.out.println("Opcion invalida.");
            }
        }
    }

    public int leerEnteroPositivo(String mensaje) {
        int num;

        while (true) {
            System.out.print(mensaje);
            try {
                num = Integer.parseInt(sc.nextLine());
                if (num > 0) {
                    return num;
                } else {
                    System.out.println("El id debe ser mayor a 0.");
                }
            } catch (Exception e) {
                System.out.println("Debes ingresar un numero valido.");
            }
        }
    }

    public String leerNombre(String mensaje) {
        String texto;

        while (true) {
            System.out.print(mensaje);
            texto = sc.nextLine().trim();

            if (!texto.equals("")) {
                return texto;
            } else {
                System.out.println("El nombre no puede estar vacio.");
            }
        }
    }


}