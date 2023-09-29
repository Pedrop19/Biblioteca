import java.util.LinkedList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner ent = new Scanner(System.in);
        Scanner str = new Scanner(System.in);

        Libro libro = new Libro("Libro1", "Autor1", 1999, Estado.DISPONIBLE);
        Libro libro2 = new Libro("Libro2", "Autor2", 2000, Estado.DISPONIBLE);
        Libro libro3 = new Libro("Libro3", "Autor3", 2001, Estado.DISPONIBLE);
        Libro libro4 = new Libro("Libro4", "Autor4", 2002, Estado.DISPONIBLE);
        Libro libro5 = new Libro("Libro5", "Autor5", 2002, Estado.DISPONIBLE);

        Personal_Biblioteca personal_Biblioteca = new Personal_Biblioteca("Jose", "111X");
        personal_Biblioteca.addLibro(libro);
        personal_Biblioteca.addLibro(libro2);
        personal_Biblioteca.addLibro(libro3);
        personal_Biblioteca.addLibro(libro4);
        personal_Biblioteca.addLibro(libro5);

        int opc = 0;

        do {
            System.out.println("-- BIBLIOTECA MERIDA --");
            System.out.println("Eliga la operación [1-3]: ");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Reservar Libro");
            System.out.println("3. Devolver Libro");
            System.out.println("4. Mostrar informacion usuarios");
            System.out.println("5. Mostrar beneficios");
            System.out.println("6. Mostrar informacion libros");
            System.out.println("7. Salir");
            opc = ent.nextInt();

            switch (opc) {

                case 1:
                    System.out.println("-- REGISTRAR USUARIO --");
                    System.out.print("Introduzca el nombre: ");
                    String nombre = str.nextLine();
                    System.out.print("Introduce el dni: ");
                    String dni = str.nextLine();
                    System.out.println("Que tipo de usuario es? [1-2]");
                    System.out.println("1. Profesor 2. Estudiante");
                    int opc2 = ent.nextInt();
                    Tipo tipo = null;
                    switch (opc2) {
                        case 1:
                            tipo = Tipo.PROFESOR;
                            personal_Biblioteca.addUsuario(new Usuario(nombre, dni, tipo));
                            System.out.println("Profesor registrado correctamente");
                            break;
                        case 2:
                            tipo = Tipo.ESTUDIANTE;
                            personal_Biblioteca.addUsuario(new Usuario(nombre, dni, tipo));
                            System.out.println("Estudiante registrado correctamente");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("-- RESERVAR LIBRO --");
                    personal_Biblioteca.reservaLibro();
                    break;

                case 3:
                    System.out.println("-- DEVOLUCION LIBRO --");
                    personal_Biblioteca.devolucionLibro();
                    break;

                case 4:
                    System.out.println("-- INFORMACION DE USUARIOS REGISTRADOS --");
                    System.out.println(personal_Biblioteca.getUsuarios().toString());
                    break;

                case 5:
                    System.out.println("-- BENEFICIOS --");
                    System.out.println(personal_Biblioteca.getBeneficios());
                    break;

                case 6:
                    System.out.println("-- INFORMACION DE LIBROS --");
                    System.out.println(personal_Biblioteca.getLibros().toString());
                    break;

                case 7:
                    System.out.println("Saliendo de la app...");
                    break;

                default:
                    System.out.println("ERROR. Opción no valida.");
                    break;

            }

        } while (opc != 7);

    }
}