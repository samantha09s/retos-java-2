package plataformaeducativa;

// Material de tipo ejercicio con estado de revisión.
public class Ejercicio extends MaterialCurso {
    private boolean revisado;

    public Ejercicio(String titulo, String autor, boolean revisado) {
        super(titulo, autor);
        this.revisado = revisado;
    }

    @Override
    public void mostrarDetalle() {
        System.out.printf("Ejercicio: '%s' - Autor: %s - Revisado: %s%n", titulo, autor, revisado ? "Sí" : "No");
    }

    public boolean isRevisado() {
        return revisado;
    }

    public void marcarRevisado() {
        this.revisado = true;
    }
}