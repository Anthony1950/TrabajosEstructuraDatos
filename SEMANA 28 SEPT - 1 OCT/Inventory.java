import java.util.LinkedList;
import java.util.List;

public class Inventory {
    // Tu lista enlazada que venías practicando
    private List<Product> products;

    public Inventory() {
        products = new LinkedList<>();
    }

    // Opción 1: Agregar producto
    public void addProduct(int id, String name, int existence, double price) {
        Product p = new Product(id, name, existence, price);
        products.add(p);
        System.out.println("¡Producto agregado con éxito!");
    }

    // Opción 2: Modificar precio (busca por ID y cambia el precio)
    public void updatePrice(int id, double newPrice) {
        boolean encontrado = false;
        for (Product p : products) {
            if (p.getId() == id) {
                p.setPrice(newPrice);
                System.out.println("¡Precio actualizado correctamente!");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró un producto con ese ID.");
        }
    }

    // Opción 3: Sumar stock (busca por ID y suma existencias)
    public void addStock(int id, int quantity) {
        boolean encontrado = false;
        for (Product p : products) {
            if (p.getId() == id) {
                p.setExistence(p.getExistence() + quantity);
                System.out.println("¡Stock sumado correctamente!");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró un producto con ese ID.");
        }
    }

    // Opción 4: Ver productos en inventario
    public void showInventory() {
        if (products.isEmpty()) {
            System.out.println("\nEl inventario está vacío.");
        } else {
            System.out.println("\n--- LISTA DE PRODUCTOS ---");
            for (Product p : products) {
                System.out.println("ID: " + p.getId() + " | Nombre: " + p.getName() + 
                                   " | Stock: " + p.getExistence() + " | Precio: $" + p.getPrice());
            }
        }
    }
}