
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Dame el peso");
        double p = sc.nextDouble();
        System.out.println("Dame la altura");
        double a= sc.nextDouble();
        double i= p/ (a*a);
        System.out.println("IMC: "+i);

        System.out.println("Clasificación");
        if(i<18.5) System.out.println("Peso bajo");
        else if(i<25) System.out.println("Medio");
        else if(i<30) System.out.println("sobre peso");
        else System.out.println("Obesidad");

    }
}
