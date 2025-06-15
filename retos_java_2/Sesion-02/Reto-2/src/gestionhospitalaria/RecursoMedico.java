package gestionhospitalaria;

import java.util.concurrent.locks.ReentrantLock;

/*
 * Representa un recurso médico exclusivo (ej. sala de cirugía).
 * Usa un ReentrantLock para asegurar acceso sincronizado.
 */
public class RecursoMedico {
    private final String nombre;
    private final ReentrantLock lock = new ReentrantLock();

    public RecursoMedico(String nombre) {
        this.nombre = nombre;
    }

    // Simula el uso del recurso por un profesional médico.
    public void usar(String profesional) {
        lock.lock();
        try {
            System.out.printf("👩‍⚕️ %s ha ingresado a %s%n", profesional, nombre);
            Thread.sleep(1000); // Simula uso del recurso
            System.out.printf("✅ %s ha salido de %s%n", profesional, nombre);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("❌ " + profesional + " fue interrumpido.");
        } finally {
            lock.unlock();
        }
    }
}