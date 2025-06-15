package pizzeria;

import java.util.Optional;

/*
 * Representa un pedido en la pizzería.
 * Maneja tipo de entrega y validación de teléfono de forma segura con Optional.
 */
public class Pedido {
    private final String cliente;
    private final String tipoEntrega;
    private final String telefono;

    public Pedido(String cliente, String tipoEntrega, String telefono) {
        this.cliente = cliente;
        this.tipoEntrega = tipoEntrega;
        this.telefono = telefono;
    }

    public String getCliente() {
        return cliente;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    /*
     * Retorna el número de teléfono si existe, de forma segura usando Optional.
     */
    public Optional<String> getTelefono() {
        return Optional.ofNullable(telefono);
    }
}