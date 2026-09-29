import java.util.Scanner;

public class InventoryApp {
    private Scanner sc;
    private Inventory inventory;

    public InventoryApp() {
        sc = new Scanner(System.in);
        inventory = new Inventory();
    }

    public void init() {
        int option;

        do {
            System.out.println("\n--- MENÚ DE INVENTARIO ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Modificar precio de un producto");
            System.out.println("3. Agregar inventario (Sumar stock)");
            System.out.println("4. Ver productos en inventario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción (1-5): ");

            option = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer del Enter

            switch (option) {
                case 1:
                    System.out.println("\n--- AGREGAR PRODUCTO ---");
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String name = sc.nextLine();
                    System.out.print("Existencia inicial: ");
                    int existence = sc.nextInt();
                    System.out.print("Precio: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    inventory.addProduct(id, name, existence, price);
                    break;

                case 2:
                    System.out.println("\n--- MODIFICAR PRECIO ---");
                    System.out.print("Ingrese el ID del producto: ");
                    int idPrice = sc.nextInt();
                    System.out.print("Ingrese el nuevo precio: ");
                    double newPrice = sc.nextDouble();
                    sc.nextLine();

                    inventory.updatePrice(idPrice, newPrice);
                    break;

                case 3:
                    System.out.println("\n--- SUMAR STOCK ---");
                    System.out.print("Ingrese el ID del producto: ");
                    int idStock = sc.nextInt();
                    System.out.print("Ingrese la cantidad a sumar: ");
                    int qty = sc.nextInt();
                    sc.nextLine();

                    inventory.addStock(idStock, qty);
                    break;

                case 4:
                    inventory.showInventory();
                    break;

                case 5:
                    System.out.println("Saliendo del sistema... ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida. Ingrese un número entre 1 y 5.");
            }
        } while (option != 5);
    }

    public static void main(String[] args) {
        InventoryApp app = new InventoryApp();
        app.init();
    }
}