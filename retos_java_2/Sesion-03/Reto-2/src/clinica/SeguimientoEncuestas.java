package clinica;

import java.util.List;
import java.util.Optional;

// Punto de entrada para el análisis de encuestas en múltiples sucursales.
public class SeguimientoEncuestas {
    public static void main(String[] args) {
        List<Sucursal> sucursales = List.of(
                new Sucursal("Centro", List.of(
                        new Encuesta("Luis", "El tiempo de espera fue largo", 2),
                        new Encuesta("Ana", null, 5)
                )),
                new Sucursal("Norte", List.of(
                        new Encuesta("Carlos", "La atención fue buena, pero la limpieza puede mejorar", 3),
                        new Encuesta("Sofía", null, 4)
                ))
        );

        sucursales.stream()
                .flatMap(sucursal -> sucursal.getEncuestas().stream()
                        .filter(e -> e.getCalificacion() <= 3)
                        .map(e -> e.getComentario()
                                .map(c -> "Sucursal " + sucursal.getNombre()
                                        + ": Seguimiento a paciente con comentario: \"" + c + "\""))
                        .flatMap(Optional::stream))
                .forEach(System.out::println);
    }
}