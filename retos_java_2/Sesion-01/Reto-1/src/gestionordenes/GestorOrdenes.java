package gestionordenes;

import java.util.List;

// Métodos de utilidad para mostrar y procesar órdenes.
public class GestorOrdenes {

    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista) {
        lista.forEach(OrdenProduccion::mostrarResumen);
    }

    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional) {
        for (Object obj : lista) {
            if (obj instanceof OrdenPersonalizada personalizada) {
                System.out.printf("✅ Orden %s ajustada con costo adicional de $%d%n",
                        personalizada.getCodigo(), costoAdicional);
            }
        }
    }
}