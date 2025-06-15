package misionespacial;

import java.util.concurrent.Callable;

// Simula el sistema de comunicaciones.
public class SistemaComunicaciones implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(600); // Simula el establecimiento de enlace
        return "Comunicaciones: enlace con estación terrestre establecido.";
    }
}