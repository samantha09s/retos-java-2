package gestionordenes;

// Orden personalizada, diseñada para un cliente específico.
public class OrdenPersonalizada extends OrdenProduccion {
    private final String cliente;

    public OrdenPersonalizada(String codigo, int cantidad, String cliente) {
        super(codigo, cantidad);
        this.cliente = cliente;
    }

    @Override
    public void mostrarResumen() {
        System.out.printf("🛠️ OrdenPersonalizada - Código: %s - Cantidad: %d - Cliente: %s%n", codigo, cantidad, cliente);
    }

    public String getCliente() {
        return cliente;
    }
}