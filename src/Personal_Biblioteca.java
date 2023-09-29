import java.util.LinkedList;
import java.util.Scanner;

public class Personal_Biblioteca extends Persona {

    private double beneficios;
    private LinkedList<Libro> libros;
    private LinkedList<Usuario> usuarios;

    public Personal_Biblioteca(String nombre, String dni) {
        super(nombre, dni);
        this.beneficios = 0;
        this.libros = new LinkedList<Libro>();
        this.usuarios = new LinkedList<Usuario>();
    }

    public double getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(double beneficios) {
        this.beneficios = beneficios;
    }

    public LinkedList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(LinkedList<Libro> libros) {
        this.libros = libros;
    }

    public LinkedList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(LinkedList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void addLibro(Libro l) {
        libros.add(l);
    }

    @Override
    public String toString() {
        return "Personal_Biblioteca [" + super.toString() + "beneficios=" + beneficios + "]";
    }

    public void addUsuario(Usuario u) {
        usuarios.add(u);
    }

    public void reservaLibro() {

        Scanner str = new Scanner(System.in);
        System.out.println("Introduce tu dni: ");
        String dni = str.nextLine();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getDni().equals(dni)) {
                System.out.println("Introduce el título del libro: ");
                String titulo = str.nextLine();
                for (int j = 0; j < libros.size(); j++) {
                    if (libros.get(j).getTitulo().equals(titulo) && libros.get(j).getEstado() != Estado.RESERVADO) {
                        libros.get(j).setEstado(Estado.RESERVADO);
                        System.out.println("Libro Reservado Correctamente");
                        if (usuarios.get(i).getTipo() == Tipo.PROFESOR) {
                            usuarios.get(i).getLibros().add(libros.get(j));
                            if (usuarios.get(i).getLibros().size() > 3)
                                beneficios += 2.75;
                        } else if (usuarios.get(i).getTipo() == Tipo.ESTUDIANTE)
                            beneficios += 0.50;
                    } else if (libros.get(j).getEstado() == Estado.RESERVADO)
                        System.out.println("Libro ya reservado");
                    
                }
            }
        }
    }

    public void devolucionLibro() {
        Scanner str = new Scanner(System.in);
        System.out.println("Introduce tu dni: ");
        String dni = str.nextLine();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getDni().equals(dni)) {
                System.out.println("Introduce el título del libro: ");
                String titulo = str.nextLine();
                for (int j = 0; j < libros.size(); j++) {
                    if (libros.get(j).getTitulo().equals(titulo)) {
                        libros.get(j).setEstado(Estado.DISPONIBLE);
                        usuarios.get(i).getLibros().remove(libros.get(j));
                        System.out.println("Libro devuelto correctamente");
                    }
                }
            }
        }
    }
}