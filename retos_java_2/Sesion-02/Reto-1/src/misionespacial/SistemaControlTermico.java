package misionespacial;

import java.util.concurrent.Callable;

// Simula el sistema de control térmico.
public class SistemaControlTermico implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000); // Simula balanceo térmico
        return "Control térmico: temperatura estable (22°C).";
    }
}