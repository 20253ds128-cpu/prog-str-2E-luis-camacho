

public class Main {
    public static void main(String[] args) {

        Persona[] personas = new Persona[3];

        Persona persona1 = new Persona();
        Persona persona2 = new Persona(2, "David");
        Persona persona3 = new Persona(3, "René");

        personas [0] = persona1;
        personas [1] = persona2;
        personas [2] = persona3;

        personas[0] = null;
        for (Persona persona : personas) {
            try {
                System.out.println("------------");
                System.out.println(persona.getId());
                System.out.println(persona.getName());
                System.out.println(persona.getisActive());
                System.out.println(persona);
            } catch (Exception a) {
                System.out.println("Hay un null");
            }




        }
    }
}