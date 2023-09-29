import java.util.LinkedList;

public class Usuario extends Persona {

    private LinkedList<Libro> libros;
    private Tipo tipo;

    public Usuario(String nombre, String dni, Tipo tipo) {
        super(nombre, dni);
        this.libros = new LinkedList<Libro>();
        this.tipo = tipo;
    }

    public LinkedList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(LinkedList<Libro> libros) {
        this.libros = libros;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return tipo + "[" + super.toString() + "libros=" + libros + ", tipo=" + tipo + "]";
    }
}