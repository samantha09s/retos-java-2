package misionespacial;

import java.util.concurrent.Callable;

// Simula el sistema de navegación de la nave espacial.
public class SistemaNavegacion implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1200); // Simula el cálculo de trayectoria
        return "Navegación: trayectoria corregida con éxito.";
    }
}