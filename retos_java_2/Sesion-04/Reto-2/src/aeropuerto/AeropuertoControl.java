package aeropuerto;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/*
 * Simula el control de aterrizaje asincrónico en un aeropuerto internacional.
 */
public class AeropuertoControl {

    public static CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia("🛣️ Verificando pista...");
            return probabilidad(0.8);
        }).thenApply(resultado -> {
            System.out.println("🛣️ Pista disponible: " + resultado);
            return resultado;
        });
    }

    public static CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia("🌦️ Verificando clima...");
            return probabilidad(0.85);
        }).thenApply(resultado -> {
            System.out.println("🌦️ Clima favorable: " + resultado);
            return resultado;
        });
    }

    public static CompletableFuture<Boolean> verificarTraficoAereo() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia("🚦 Verificando tráfico aéreo...");
            return probabilidad(0.9);
        }).thenApply(resultado -> {
            System.out.println("🚦 Tráfico aéreo despejado: " + resultado);
            return resultado;
        });
    }

    public static CompletableFuture<Boolean> verificarPersonalTierra() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia("👷‍♂️ Verificando personal en tierra...");
            return probabilidad(0.95);
        }).thenApply(resultado -> {
            System.out.println("👷‍♂️ Personal disponible: " + resultado);
            return resultado;
        });
    }

    public static void main(String[] args) {
        System.out.println("🛫 Verificando condiciones para aterrizaje...");

        CompletableFuture<Boolean> pista = verificarPista();
        CompletableFuture<Boolean> clima = verificarClima();
        CompletableFuture<Boolean> trafico = verificarTraficoAereo();
        CompletableFuture<Boolean> personal = verificarPersonalTierra();

        CompletableFuture.allOf(pista, clima, trafico, personal)
            .thenRun(() -> {
                try {
                    boolean autorizado = pista.get() && clima.get() && trafico.get() && personal.get();
                    if (autorizado) {
                        System.out.println("🛬 Aterrizaje autorizado: todas las condiciones óptimas.");
                    } else {
                        System.out.println("🚫 Aterrizaje denegado: condiciones no óptimas.");
                    }
                } catch (Exception e) {
                    System.out.println("❌ Error en el procesamiento: " + e.getMessage());
                }
            }).join();
    }

    private static void simularLatencia(String mensaje) {
        try {
            System.out.println(mensaje);
            TimeUnit.SECONDS.sleep(2 + ThreadLocalRandom.current().nextInt(2));
        } catch (InterruptedException e) {
            throw new IllegalStateException("Error de latencia simulada", e);
        }
    }

    private static boolean probabilidad(double chance) {
        return ThreadLocalRandom.current().nextDouble() < chance;
    }
}