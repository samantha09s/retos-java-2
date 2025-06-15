package gestionordenes;

// Clase base para representar una orden genérica en planta industrial.
public abstract class OrdenProduccion {
    protected final String codigo;
    protected final int cantidad;

    public OrdenProduccion(String codigo, int cantidad) {
        this.codigo = codigo;
        this.cantidad = cantidad;
    }

    public abstract void mostrarResumen();

    public String getCodigo() {
        return codigo;
    }

    public int getCantidad() {
        return cantidad;
    }
}