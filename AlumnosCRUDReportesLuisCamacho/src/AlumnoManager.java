import java.util.Scanner;

public class AlumnoManager {

    Alumno[] alumnos = new Alumno[25];
    int contador = 0;
    Scanner sc = new Scanner(System.in);

    public void altaAlumno() {

        if (contador >= alumnos.length) {
            System.out.println("Arreglo lleno.");
            return;
        }

        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (id <= 0) {
            System.out.println("ID inválido.");
            return;
        }

        // verificar repetido
        for (int i = 0; i < contador; i++) {
            if (alumnos[i].id == id) {
                System.out.println("ID repetido.");
                return;
            }
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        if (nombre.equals("")) {
            System.out.println("Nombre vacío.");
            return;
        }

        System.out.print("Promedio: ");
        double promedio = sc.nextDouble();

        if (promedio < 0 || promedio > 10) {
            System.out.println("Promedio inválido.");
            return;
        }

        alumnos[contador] = new Alumno(id, nombre, promedio);
        contador++;

        System.out.println("Alumno agregado.");
    }

    public void buscarAlumno() {

        System.out.print("ID a buscar: ");
        int id = sc.nextInt();

        for (int i = 0; i < contador; i++) {
            if (alumnos[i].id == id && alumnos[i].activo) {
                System.out.println("Nombre: " + alumnos[i].nombre);
                System.out.println("Promedio: " + alumnos[i].promedio);
                return;
            }
        }

        System.out.println("No encontrado.");
    }

    public void actualizarPromedio() {

        System.out.print("ID a actualizar: ");
        int id = sc.nextInt();

        for (int i = 0; i < contador; i++) {
            if (alumnos[i].id == id && alumnos[i].activo) {

                System.out.print("Nuevo promedio: ");
                double nuevo = sc.nextDouble();

                if (nuevo >= 0 && nuevo <= 10) {
                    alumnos[i].promedio = nuevo;
                    System.out.println("Actualizado.");
                } else {
                    System.out.println("Promedio inválido.");
                }

                return;
            }
        }

        System.out.println("No encontrado.");
    }

    public void bajaLogica() {

        System.out.print("ID a dar de baja: ");
        int id = sc.nextInt();

        for (int i = 0; i < contador; i++) {
            if (alumnos[i].id == id && alumnos[i].activo) {
                alumnos[i].activo = false;
                System.out.println("Baja realizada.");
                return;
            }
        }

        System.out.println("No encontrado.");
    }

    public void listarActivos() {

        System.out.println("Alumnos activos:");

        for (int i = 0; i < contador; i++) {
            if (alumnos[i].activo) {
                System.out.println(alumnos[i].id + " - " +
                        alumnos[i].nombre + " - " +
                        alumnos[i].promedio);
            }
        }
    }

    public void reportes() {

        double suma = 0;
        int total = 0;
        double mayor = -1;
        double menor = 11;
        int mayores8 = 0;

        for (int i = 0; i < contador; i++) {
            if (alumnos[i].activo) {

                suma += alumnos[i].promedio;
                total++;

                if (alumnos[i].promedio > mayor) {
                    mayor = alumnos[i].promedio;
                }

                if (alumnos[i].promedio < menor) {
                    menor = alumnos[i].promedio;
                }

                if (alumnos[i].promedio >= 8.0) {
                    mayores8++;
                }
            }
        }

        if (total > 0) {
            System.out.println("Promedio general: " + (suma / total));
            System.out.println("Mayor promedio: " + mayor);
            System.out.println("Menor promedio: " + menor);
            System.out.println("Cantidad >= 8: " + mayores8);
        } else {
            System.out.println("No hay alumnos activos.");
        }
    }
}