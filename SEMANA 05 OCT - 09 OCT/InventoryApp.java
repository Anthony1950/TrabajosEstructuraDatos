import java.util.Scanner; // Importamos Scanner para leer las entradas del usuario desde la consola

public class InventoryApp {
    private Scanner sc;          // Objeto Scanner que capturará lo que escribas en el teclado
    private Inventory inventory; // Objeto Inventory que conectará esta interfaz con la lógica de la LinkedList

    // CONSTRUCTOR: Prepara las herramientas esenciales al arrancar la aplicación
    public InventoryApp() {
        sc = new Scanner(System.in); // Inicializamos el Scanner escuchando la entrada estándar (teclado)
        inventory = new Inventory(); // Inicializamos el administrador del inventario en la memoria
    }

    // EL MOTOR DEL MENÚ: Controla el flujo de la aplicación con un bucle do-while y un switch
    public void init() {
        int option; // Variable numérica donde guardaremos la opción que elija el usuario

        do {
            // Desplegamos visualmente las 7 opciones disponibles
            System.out.println("\n--- MENÚ DE INVENTARIO ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Modificar precio de un producto");
            System.out.println("3. Agregar inventario (Sumar stock)");
            System.out.println("4. Ver productos en inventario");
            System.out.println("5. Modificar categoría de un producto"); // Opción del Reto
            System.out.println("6. Consultar por ID de producto");         // Opción del Reto
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción (1-7): ");

            option = sc.nextInt(); // Capturamos el número entero ingresado por el usuario
            sc.nextLine(); // ¡IMPORTANTE! Limpiamos el buffer del teclado para absorber el "Enter" fantasma

            // Evaluamos la opción elegida para ejecutar el bloque correspondiente
            switch (option) {
                case 1: // AGREGAR PRODUCTO
                    System.out.println("\n--- AGREGAR PRODUCTO ---");
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // Limpiamos el buffer tras leer un número
                    
                    System.out.print("Nombre: ");
                    String name = sc.nextLine();
                    
                    System.out.print("Existencia inicial: ");
                    int existence = sc.nextInt();
                    
                    System.out.print("Precio: ");
                    double price = sc.nextDouble();
                    sc.nextLine(); // Limpiamos el buffer tras leer un decimal
                    
                    System.out.print("Categoría: ");
                    String category = sc.nextLine();

                    // Enviamos todos los datos capturados al método 'addProduct' de nuestro inventario
                    inventory.addProduct(id, name, existence, price, category);
                    break; // Cortamos la ejecución del switch

                case 2: // MODIFICAR PRECIO
                    System.out.println("\n--- MODIFICAR PRECIO ---");
                    System.out.print("Ingrese el ID del producto: ");
                    int idPrice = sc.nextInt();
                    
                    System.out.print("Ingrese el nuevo precio: ");
                    double newPrice = sc.nextDouble();
                    sc.nextLine(); // Limpieza de buffer

                    // Delegamos la actualización del precio al objeto 'inventory'
                    inventory.updatePrice(idPrice, newPrice);
                    break;

                case 3: // SUMAR STOCK
                    System.out.println("\n--- SUMAR STOCK ---");
                    System.out.print("Ingrese el ID del producto: ");
                    int idStock = sc.nextInt();
                    
                    System.out.print("Ingrese la cantidad a sumar: ");
                    int qty = sc.nextInt(); // 'qty' guarda la cantidad temporal de nuevas unidades
                    sc.nextLine(); // Limpieza de buffer

                    // Le pasamos el ID y la cantidad incremental al método 'addStock'
                    inventory.addStock(idStock, qty);
                    break;

                case 4: // VER INVENTARIO COMPLETO
                    // Simplemente invocamos el método que recorre e imprime la LinkedList
                    inventory.showInventory();
                    break;

                case 5: // MODIFICAR CATEGORÍA (RETO)
                    System.out.println("\n--- MODIFICAR CATEGORÍA ---");
                    System.out.print("Ingrese el ID del producto: ");
                    int idCategory = sc.nextInt();
                    sc.nextLine(); // Limpieza de buffer
                    
                    System.out.print("Ingrese la nueva categoría: ");
                    String newCategory = sc.nextLine();

                    // Enviamos la nueva cadena de texto al método 'updateCategory'
                    inventory.updateCategory(idCategory, newCategory);
                    break;

                case 6: // CONSULTAR POR ID (RETO)
                    System.out.println("\n--- CONSULTAR PRODUCTO POR ID ---");
                    System.out.print("Ingrese el ID del producto: ");
                    int idConsult = sc.nextInt();
                    sc.nextLine(); // Limpieza de buffer

                    // Buscamos e imprimimos el producto específico
                    inventory.consultProductById(idConsult);
                    break;

                case 7: // SALIR
                    System.out.println("Saliendo del sistema... ¡Hasta luego!");
                    break;

                default: // SEGURIDAD
                    // Se activa si el usuario ingresa un número fuera del rango 1-7
                    System.out.println("Opción inválida. Ingrese un número entre 1 y 7.");
            }
        } while (option != 7); // El bucle se repite siempre que la opción elegida SEA DIFERENTE de 7
    }

    // PUNTO DE ENTRADA PRINCIPAL: La máquina virtual de Java arranca a ejecutar el programa desde aquí
    public static void main(String[] args) {
        InventoryApp app = new InventoryApp(); // Creamos la instancia de la aplicación
        app.init();                            // Ponemos en marcha el menú interactivo
    }
}