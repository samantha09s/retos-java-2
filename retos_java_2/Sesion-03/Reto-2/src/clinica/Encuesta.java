package clinica;

import java.util.Optional;

// Representa una encuesta de satisfacción de un paciente.
public class Encuesta {
    private final String paciente;
    private final String comentario;
    private final int calificacion;

    public Encuesta(String paciente, String comentario, int calificacion) {
        this.paciente = paciente;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    public String getPaciente() {
        return paciente;
    }

    public Optional<String> getComentario() {
        return Optional.ofNullable(comentario);
    }

    public int getCalificacion() {
        return calificacion;
    }
}