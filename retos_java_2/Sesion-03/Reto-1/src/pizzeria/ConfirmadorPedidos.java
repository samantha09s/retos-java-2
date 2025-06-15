package pizzeria;

import java.util.List;
import java.util.Optional;

/*
 * Punto de entrada del sistema de confirmación de pedidos.
 * Usa Optional y Stream API para manejar datos nulos de forma segura.
 */
public class ConfirmadorPedidos {
    public static void main(String[] args) {
        List<Pedido> pedidos = List.of(
                new Pedido("Ana", "domicilio", "555-1234"),
                new Pedido("Luis", "local", null),
                new Pedido("Sofía", "domicilio", "555-5678"),
                new Pedido("Carlos", "domicilio", null)
        );

        pedidos.stream()
                .filter(p -> "domicilio".equalsIgnoreCase(p.getTipoEntrega()))
                .map(Pedido::getTelefono)
                .flatMap(Optional::stream)
                .map(telefono -> "Confirmación enviada al número: " + telefono)
                .forEach(System.out::println);
    }
}