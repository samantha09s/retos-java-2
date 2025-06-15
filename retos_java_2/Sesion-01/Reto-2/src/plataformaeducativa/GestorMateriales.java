package plataformaeducativa;

import java.util.List;
import java.util.function.Predicate;

// Utilidades para mostrar, filtrar y procesar materiales educativos.
public class GestorMateriales {

    public static void mostrarMateriales(List<? extends MaterialCurso> materiales) {
        materiales.forEach(MaterialCurso::mostrarDetalle);
    }

    public static void contarDuracionVideos(List<? extends Video> videos) {
        int total = videos.stream().mapToInt(Video::getDuracion).sum();
        System.out.println("Duración total de videos: " + total + " minutos");
    }

    public static void marcarEjerciciosRevisados(List<? super Ejercicio> materiales) {
        for (Object obj : materiales) {
            if (obj instanceof Ejercicio ejercicio && !ejercicio.isRevisado()) {
                ejercicio.marcarRevisado();
                System.out.printf("✅ Ejercicio '%s' marcado como revisado.%n", ejercicio.getTitulo());
            }
        }
    }

    public static void filtrarPorAutor(List<? extends MaterialCurso> materiales, Predicate<MaterialCurso> filtro) {
        materiales.stream().filter(filtro).forEach(MaterialCurso::mostrarDetalle);
    }
}