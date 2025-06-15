package misionespacial;

import java.util.List;
import java.util.concurrent.*;

// Simula la ejecución paralela de sistemas en una misión espacial.
public class SimuladorMisionEspacial {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("🚀 Simulación de misión espacial iniciada...");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Lista de tareas a ejecutar concurrentemente
        List<Callable<String>> sistemas = List.of(
                new SistemaNavegacion(),
                new SistemaSoporteVital(),
                new SistemaControlTermico(),
                new SistemaComunicaciones()
        );

        // Ejecutar y recolectar resultados
        List<Future<String>> resultados = executor.invokeAll(sistemas);

        for (Future<String> resultado : resultados) {
            System.out.println("🛰️ " + resultado.get());
        }

        executor.shutdown();

        System.out.println("✅ Todos los sistemas reportan estado operativo.");
    }
}