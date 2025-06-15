package plataformaeducativa;

// Material de tipo video con duración en minutos.
public class Video extends MaterialCurso {
    private final int duracion;

    public Video(String titulo, String autor, int duracion) {
        super(titulo, autor);
        this.duracion = duracion;
    }

    @Override
    public void mostrarDetalle() {
        System.out.printf("Video: '%s' - Autor: %s - Duración: %d min%n", titulo, autor, duracion);
    }

    public int getDuracion() {
        return duracion;
    }
}