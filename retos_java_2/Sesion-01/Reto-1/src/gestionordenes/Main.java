package gestionordenes;

import java.util.*;

// Punto de entrada del sistema de gestión de órdenes de producción.
public class Main {
    public static void main(String[] args) {
        List<OrdenMasa> masa = List.of(
                new OrdenMasa("A123", 500),
                new OrdenMasa("A124", 750)
        );

        List<OrdenPersonalizada> personalizadas = new ArrayList<>(List.of(
                new OrdenPersonalizada("P456", 100, "ClienteX"),
                new OrdenPersonalizada("P789", 150, "ClienteY")
        ));

        List<OrdenPrototipo> prototipos = List.of(
                new OrdenPrototipo("T789", 10, "Diseño"),
                new OrdenPrototipo("T790", 5, "Pruebas")
        );

        System.out.println("📋 Órdenes registradas:");
        GestorOrdenes.mostrarOrdenes(masa);
        System.out.println();

        System.out.println("📋 Órdenes registradas:");
        GestorOrdenes.mostrarOrdenes(personalizadas);
        System.out.println();

        System.out.println("📋 Órdenes registradas:");
        GestorOrdenes.mostrarOrdenes(prototipos);
        System.out.println();

        System.out.println("💰 Procesando órdenes personalizadas...");
        GestorOrdenes.procesarPersonalizadas(personalizadas, 200);
        System.out.println();

        System.out.println("📊 Resumen total de órdenes:");
        System.out.printf("🔧 Producción en masa: %d%n", masa.size());
        System.out.printf("🛠️ Personalizadas: %d%n", personalizadas.size());
        System.out.printf("🧪 Prototipos: %d%n", prototipos.size());
    }
}
