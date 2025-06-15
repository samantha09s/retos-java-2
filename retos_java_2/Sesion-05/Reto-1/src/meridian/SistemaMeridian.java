package meridian;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

// Simula monitoreo reactivo y concurrente de subsistemas en una ciudad inteligente.
public class SistemaMeridian {

    private final Random random = new Random();
    private final AtomicInteger semaforoRojoContador = new AtomicInteger();

    // Inicia los flujos que monitorean condiciones críticas del sistema urbano.
    public void iniciar() {
        System.out.println("🔄 Iniciando monitoreo reactivo de Meridian Prime...");

        Flux<String> sensoresTrafico = Flux.interval(Duration.ofMillis(500))
                .map(i -> random.nextInt(101))
                .filter(nivel -> nivel > 70)
                .map(nivel -> "🚗 Alerta: Congestión del " + nivel + "% en Avenida Solar")
                .onBackpressureBuffer()
                .subscribeOn(Schedulers.parallel());

        Flux<String> contaminacionAire = Flux.interval(Duration.ofMillis(600))
                .map(i -> random.nextInt(101))
                .filter(pm -> pm > 50)
                .map(pm -> "🌫️ Alerta: Contaminación alta (PM2.5: " + pm + " ug/m3)")
                .subscribeOn(Schedulers.parallel());

        Flux<String> accidentesViales = Flux.interval(Duration.ofMillis(800))
                .map(i -> {
                    String[] prioridades = {"Baja", "Media", "Alta"};
                    return prioridades[random.nextInt(prioridades.length)];
                })
                .filter("Alta"::equals)
                .map(p -> "🚑 Emergencia vial: Accidente con prioridad " + p)
                .subscribeOn(Schedulers.parallel());

        Flux<String> trenesMaglev = Flux.interval(Duration.ofMillis(700))
                .map(i -> random.nextInt(11))
                .filter(delay -> delay > 5)
                .map(delay -> "🚝 Tren maglev con retraso crítico: " + delay + " minutos")
                .onBackpressureBuffer()
                .subscribeOn(Schedulers.parallel());

        Flux<String> semaforos = Flux.interval(Duration.ofMillis(400))
                .map(i -> {
                    String[] estados = {"Verde", "Amarillo", "Rojo"};
                    return estados[random.nextInt(estados.length)];
                })
                .filter(estado -> {
                    if ("Rojo".equals(estado)) {
                        return semaforoRojoContador.incrementAndGet() >= 3;
                    } else {
                        semaforoRojoContador.set(0);
                        return false;
                    }
                })
                .map(e -> "🚦 Semáforo en Rojo detectado 3 veces seguidas en cruce Norte")
                .subscribeOn(Schedulers.parallel());

        Flux.merge(sensoresTrafico, contaminacionAire, accidentesViales, trenesMaglev, semaforos)
                .doOnNext(System.out::println)
                .subscribe();

        try {
            Thread.sleep(10000); // Simula ejecución por 10 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}