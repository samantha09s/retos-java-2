package misionespacial;

import java.util.concurrent.Callable;

// Simula el sistema de soporte vital.
public class SistemaSoporteVital implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(800); // Simula chequeo de oxígeno y presión
        return "Soporte vital: presión y oxígeno dentro de parámetros normales.";
    }
}