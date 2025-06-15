package gestionhospitalaria;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Simula el acceso controlado a un recurso médico por parte de múltiples profesionales.
 */
public class SimuladorAccesoMedico {
    public static void main(String[] args) {
        System.out.println("🏥 Iniciando acceso a la Sala de cirugía...");

        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");

        List<String> profesionales = List.of(
                "Dra. Sánchez", "Dr. Gómez", "Enfermera López", "Dr. Ruiz", "Dra. Torres"
        );

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (String profesional : profesionales) {
            executor.submit(() -> salaCirugia.usar(profesional));
        }

        executor.shutdown();
    }
}