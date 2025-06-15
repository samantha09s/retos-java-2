package gestionordenes;

// Orden de tipo prototipo, en fase de desarrollo.
public class OrdenPrototipo extends OrdenProduccion {
    private final String faseDesarrollo;

    public OrdenPrototipo(String codigo, int cantidad, String faseDesarrollo) {
        super(codigo, cantidad);
        this.faseDesarrollo = faseDesarrollo;
    }

    @Override
    public void mostrarResumen() {
        System.out.printf("🧪 OrdenPrototipo - Código: %s - Cantidad: %d - Fase: %s%n", codigo, cantidad, faseDesarrollo);
    }

    public String getFaseDesarrollo() {
        return faseDesarrollo;
    }
}