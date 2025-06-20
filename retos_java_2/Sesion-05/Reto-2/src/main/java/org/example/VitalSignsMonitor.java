package org.example;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Random;

public class VitalSignsMonitor {

    private static final Random random = new Random();

    public static void main(String[] args) {

        Flux<String> patient1 = simulatePatientStream(1);
        Flux<String> patient2 = simulatePatientStream(2);
        Flux<String> patient3 = simulatePatientStream(3);

        Flux.merge(patient1, patient2, patient3)
            .onBackpressureBuffer(
                100,
                dropped -> System.err.println("💥 Evento descartado por presión: " + dropped)
            )
            .delayElements(Duration.ofSeconds(1))
            .publishOn(Schedulers.boundedElastic())
            .subscribe(
                System.out::println,
                error -> System.err.println("❌ Error en el flujo: " + error.getMessage())
            );

        try {
            Thread.sleep(60000); // Ejecutar durante 1 minuto
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static Flux<String> simulatePatientStream(int patientId) {
        return Flux.interval(Duration.ofMillis(300))
            .map(i -> generateVitalSigns(patientId))
            .filter(alert -> !alert.isEmpty());
    }

    private static String generateVitalSigns(int patientId) {
        int heartRate = random.nextInt(100) + 30;         // 30 - 130 bpm
        int systolic = random.nextInt(80) + 80;           // 80 - 160 mmHg
        int diastolic = random.nextInt(40) + 40;          // 40 - 80 mmHg
        int spo2 = random.nextInt(15) + 85;               // 85% - 100%

        StringBuilder alert = new StringBuilder();

        // Solo se alertan eventos clínicamente críticos

        if (heartRate < 50 || heartRate > 120) {
            alert.append("⚠️ Paciente ").append(patientId)
                .append(" - FC crítica: ").append(heartRate).append(" bpm\n");
        }

        if (systolic < 90 || systolic > 140 || diastolic < 60 || diastolic > 90) {
            alert.append("⚠️ Paciente ").append(patientId)
                .append(" - PA crítica: ").append(systolic).append("/")
                .append(diastolic).append(" mmHg\n");
        }

        if (spo2 < 90) {
            alert.append("⚠️ Paciente ").append(patientId)
                .append(" - SpO2 baja: ").append(spo2).append("%\n");
        }

        return alert.toString().trim();
    }
}