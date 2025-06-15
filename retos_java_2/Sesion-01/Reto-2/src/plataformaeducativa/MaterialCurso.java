package plataformaeducativa;

// Representa un material genérico dentro de un curso.
public abstract class MaterialCurso {
    protected final String titulo;
    protected final String autor;

    public MaterialCurso(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public abstract void mostrarDetalle();

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }
}
