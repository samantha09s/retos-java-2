package gestionordenes;

// Orden de producción en masa.
public class OrdenMasa extends OrdenProduccion {
    public OrdenMasa(String codigo, int cantidad) {
        super(codigo, cantidad);
    }

    @Override
    public void mostrarResumen() {
        System.out.printf("🔧 OrdenMasa - Código: %s - Cantidad: %d%n", codigo, cantidad);
    }
}