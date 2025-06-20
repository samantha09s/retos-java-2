package com.inventario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class InventarioApp {

    public static void main(String[] args) {
        SpringApplication.run(InventarioApp.class, args);
    }

    @Bean
    CommandLineRunner run(ProductoRepository repo) {
        return args -> {
            repo.saveAll(List.of(
                create("Laptop Lenovo", "Portátil de alto rendimiento", 12500),
                create("Mouse Logitech", "Mouse inalámbrico", 350),
                create("Teclado Mecánico", "Teclado retroiluminado", 950),
                create("Monitor", "Monitor 24 pulgadas", 3200)
            ));

            printSection("📦 Productos con precio mayor a 500:", repo.findByPrecioGreaterThan(500));
            printSection("🔍 Productos que contienen 'lap':", repo.findByNombreContainingIgnoreCase("lap"));
            printSection("🎯 Productos con precio entre 400 y 1000:", repo.findByPrecioBetween(400, 1000));
            printSection("📘 Productos cuyo nombre empieza con 'm':", repo.findByNombreStartingWithIgnoreCase("m"));
        };
    }

    private void printSection(String title, List<Producto> productos) {
        System.out.println("\n" + title);
        if (productos.isEmpty()) {
            System.out.println("   ⚠️ Ningún producto encontrado.");
        } else {
            productos.forEach(p -> System.out.printf("   - ID: %-2d | Nombre: %-20s | Precio: $%.2f%n",
                    p.getId(), p.getNombre(), p.getPrecio()));
        }
    }

    private Producto create(String nombre, String descripcion, double precio) {
        Producto p = new Producto();
        p.setNombre(nombre);
        p.setDescripcion(descripcion);
        p.setPrecio(precio);
        return p;
    }
}