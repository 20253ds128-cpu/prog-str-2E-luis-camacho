public class PersonaService {

    private Persona[] personas = new Persona[20];
    private int contador = 0;

    public void alta(InputValidator iv) {

        if (contador >= personas.length) {
            System.out.println("No hay espacio.");
            return;
        }

        int id = iv.leerEnteroPositivo("ID: ");

        if (existeId(id)) {
            System.out.println("No se puede repetir el ID.");
            return;
        }

        String nombre = iv.leerNombre("Nombre: ");

        Persona nueva = new Persona(nombre, id);
        personas[contador] = nueva;
        contador++;

        System.out.println("Persona agregada.");
    }

    public void buscar(InputValidator iv) {

        int id = iv.leerEnteroPositivo("ID a buscar: ");

        for (int i = 0; i < contador; i++) {
            if (personas[i].getId() == id && personas[i].isActive()) {
                System.out.println("Encontrada: ID: " +
                        personas[i].getId() +
                        " - Nombre: " +
                        personas[i].getName());
                return;
            }
        }

        System.out.println("Persona no encontrada o inactiva.");
    }

    public void baja(InputValidator iv) {

        int id = iv.leerEnteroPositivo("ID a dar de baja: ");

        for (int i = 0; i < contador; i++) {
            if (personas[i].getId() == id && personas[i].isActive()) {
                personas[i].setActive(false);
                System.out.println("Baja realizada.");
                return;
            }
        }

        System.out.println("Persona no encontrada o ya inactiva.");
    }

    public void listarActivas() {

        System.out.println("\n--- PERSONAS ACTIVAS ---");

        boolean hay = false;

        for (int i = 0; i < contador; i++) {
            if (personas[i].isActive()) {
                System.out.println("ID: " +
                        personas[i].getId() +
                        " - Nombre: " +
                        personas[i].getName());
                hay = true;
            }
        }

        if (!hay) {
            System.out.println("No hay personas activas.");
        }
    }

    public void actualizar(InputValidator iv) {

        int id = iv.leerEnteroPositivo("ID a actualizar: ");

        for (int i = 0; i < contador; i++) {
            if (personas[i].getId() == id && personas[i].isActive()) {

                String nuevoNombre = iv.leerNombre("Nuevo nombre: ");
                personas[i].setName(nuevoNombre);

                System.out.println("Nombre actualizado.");
                return;
            }
        }

        System.out.println("Persona no encontrada o inactiva.");
    }

    private boolean existeId(int id) {

        for (int i = 0; i < contador; i++) {
            if (personas[i].getId() == id) {
                return true;
            }
        }

        return false;
    }
}