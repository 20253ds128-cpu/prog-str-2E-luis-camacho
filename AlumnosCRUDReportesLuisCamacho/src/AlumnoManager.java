import java.util.Scanner;

public class AlumnoManager {
    private Alumno[] alumnos = new Alumno[25];
    private int contador = 0;

    private Scanner sc = new Scanner(System.in);

    // Para vaalidar si el ID ya existe
    private boolean idExiste(int id) {
        for (int i = 0; i < contador; i++) {
            if (alumnos[i].getId() == id && alumnos[i].isActivo()) {
                return true;
            }
        }
        return false;
    }

    // Método para el alta de alumno
    public void altaAlumno() {
        if (contador >= alumnos.length) {
            System.out.println("No se pueden agregar más alumnos");
            return;
        }

        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        if (id <= 0) {
            System.out.println("ID debe ser mayor a 0.");
            return;
        }
        if (idExiste(id)) {
            System.out.println("ID ya existe.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        if (nombre.isEmpty()) {
            System.out.println("Nombre no puede estar vacío");
            return;
        }

        System.out.print("Promedio: ");
        double promedio = sc.nextDouble();
        if (promedio < 0 || promedio > 10) {
            System.out.println("Promedio debe estar entre 0 y 10");
            return;
        }

        alumnos[contador++] = new Alumno(id, nombre, promedio);
        System.out.println("Alumno agregado correctamente.");
    }

    // Metodo para buscar por ID solo a los activos
    public void buscarAlumno() {
        System.out.print("ID a buscar: ");
        int id = sc.nextInt();
        for (int i = 0; i < contador; i++) {
            if (alumnos[i].getId() == id && alumnos[i].isActivo()) {
                System.out.println("ID: " + alumnos[i].getId());
                System.out.println("Nombre: " + alumnos[i].getNombre());
                System.out.println("Promedio: " + alumnos[i].getPromedio());
                return;
            }
        }
        System.out.println("Alumno no encontrado o inactivo.");
    }

    // Metodo para actualizar promedio por ID solo a los estudiantes activos
    public void actualizarPromedio() {
        System.out.print("ID a actualizar: ");
        int id = sc.nextInt();
        for (int i = 0; i < contador; i++) {
            if (alumnos[i].getId() == id && alumnos[i].isActivo()) {
                System.out.print("Nuevo promedio: ");
                double nuevoProm = sc.nextDouble();
                if (nuevoProm < 0 || nuevoProm > 10) {
                    System.out.println("Promedio debe estar entre 0 y 10");
                    return;
                }
                alumnos[i].setPromedio(nuevoProm);
                System.out.println("Promedio actualizado");
                return;
            }
        }
        System.out.println("Alumno no encontrado o inactivo.");
    }

    // Baja lógica por ID
    public void bajaLogica() {
        System.out.print("ID a dar de baja: ");
        int id = sc.nextInt();
        for (int i = 0; i < contador; i++) {
            if (alumnos[i].getId() == id && alumnos[i].isActivo()) {
                alumnos[i].setActivo(false);
                System.out.println("Alumno dado de baja lógicamente");
                return;
            }
        }
        System.out.println("El alumno no fue encontrado o está inactivo");
    }

    // Listar activos
    public void listarActivos() {
        System.out.println("Alumnos activos:");
        for (int i = 0; i < contador; i++) {
            if (alumnos[i].isActivo()) {
                System.out.println(alumnos[i].getId() + " - " + alumnos[i].getNombre() + " - " + alumnos[i].getPromedio());
            }
        }
    }


    public void reportes() {
        double suma = 0;
        int totalActivos = 0;
        Alumno mayor = null;
        Alumno menor = null;
        int alumnos8 = 0;

        for (int i = 0; i < contador; i++) {
            if (alumnos[i].isActivo()) {
                totalActivos++;
                suma += alumnos[i].getPromedio();
                if (mayor == null || alumnos[i].getPromedio() > mayor.getPromedio()) {
                    mayor = alumnos[i];
                }
                if (menor == null || alumnos[i].getPromedio() < menor.getPromedio()) {
                    menor = alumnos[i];
                }
                if (alumnos[i].getPromedio() >= 8.0) alumnos8++;
            }
        }

        if (totalActivos == 0) {
            System.out.println("No hay alumnos activos.");
            return;
        }

        System.out.println("Promedio general: " + (suma / totalActivos));
        System.out.println("Mayor promedio: " + mayor.getId() + " - " + mayor.getNombre() + " - " + mayor.getPromedio());
        System.out.println("Menor promedio: " + menor.getId() + " - " + menor.getNombre() + " - " + menor.getPromedio());
        System.out.println("Cantidad con promedio >= 8.0: " + alumnos8);
    }
}