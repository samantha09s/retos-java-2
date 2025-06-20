package com.inventario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventarioApp {
    public static void main(String[] args) {
        SpringApplication.run(InventarioApp.class, args);
    }

    @Bean
    CommandLineRunner run(ProductoRepository productoRepo, MarcaRepository marcaRepo) {
        return args -> {
            Marca apple = marcaRepo.save(new Marca("🍏 Apple"));
            Marca samsung = marcaRepo.save(new Marca("📱 Samsung"));

            productoRepo.save(new Producto("iPhone 15", "Teléfono de alta gama", 18000, apple));
            productoRepo.save(new Producto("iPad Pro", "Tablet profesional", 22000, apple));
            productoRepo.save(new Producto("Galaxy S23", "Smartphone premium", 17000, samsung));
            productoRepo.save(new Producto("Smart TV", "Televisor 4K UHD", 8500, samsung));

            System.out.println("""
=======================================
📦 INVENTARIO AGRUPADO POR MARCA
=======================================
""");
            marcaRepo.findAll().forEach(marca -> {
                System.out.println(marca.getNombre() + ":");
                productoRepo.findAll().stream()
                    .filter(p -> p.getMarca().getId().equals(marca.getId()))
                    .forEach(p -> System.out.printf("   • %-20s | $%,.2f%n", p.getNombre(), p.getPrecio()));
                System.out.println();
            });
        };
    }
}