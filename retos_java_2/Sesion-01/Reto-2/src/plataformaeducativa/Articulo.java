package plataformaeducativa;

// Material de tipo artículo con conteo de palabras.
public class Articulo extends MaterialCurso {
    private final int palabras;

    public Articulo(String titulo, String autor, int palabras) {
        super(titulo, autor);
        this.palabras = palabras;
    }

    @Override
    public void mostrarDetalle() {
        System.out.printf("Artículo: '%s' - Autor: %s - Palabras: %d%n", titulo, autor, palabras);
    }

    public int getPalabras() {
        return palabras;
    }
}