
import java.util.Scanner;

public class InputValidator {

    Scanner sc = new Scanner(System.in);

    public int validarId(String msg, Scanner sc) {
        while (true) {
            int valor;
            System.out.println(msg);
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                if (valor > 0) {
                    return valor;
                }
                System.out.println("El minimo es 0.");
            } else {
                System.out.println("El valor no es numérico");
                sc.next();
            }
        }

    }


}
