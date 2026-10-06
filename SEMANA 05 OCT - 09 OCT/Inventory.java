import java.util.LinkedList; // Importamos la clase LinkedList para crear nuestra estructura de datos en cadena
import java.util.List;       // Importamos la interfaz List para manejar la abstracción de colecciones

public class Inventory {
    // Declaramos nuestra variable 'products' que almacenará la LinkedList de objetos Product
    private List<Product> products;

    // CONSTRUCTOR: Se activa al hacer 'new Inventory()'. 
    // Reserva espacio en la memoria RAM creando la lista enlazada vacía para evitar errores de apuntador nulo.
    public Inventory() {
        products = new LinkedList<Product>();
    }

    // MÉTODO 1: AGREGAR PRODUCTO
    // Recibe los datos desde la consola, instancia un nuevo objeto 'Product' y lo engancha al final de la LinkedList
    public void addProduct(int id, String name, int existence, double price, String category) {
        Product p = new Product(id, name, existence, price, category); // Crea el objeto en memoria
        products.add(p); // Lo agrega al final de la lista enlazada con el método .add()
        System.out.println("Producto agregado con éxito!");
    }

    // MÉTODO 2: MODIFICAR PRECIO
    // Recorre la lista elemento por elemento; al coincidir el ID, usa el 'setPrice' para cambiar el costo
    public void updatePrice(int id, double newPrice) {
        boolean encontrado = false; // Variable de control (bandera) para saber si el ID existía
        for (Product p : products) { // Bucle for-each: toma un producto 'p' a la vez de la lista 'products'
            if (p.getId() == id) {   // Compara el ID del producto actual con el buscado
                p.setPrice(newPrice); // Aplica el setter para cambiar el precio de forma segura
                System.out.println("¡Precio actualizado correctamente!");
                encontrado = true;   // Marcamos que sí se encontró
                break;               // Rompemos el ciclo inmediatamente para no seguir buscando en vano
            }
        }
        if (!encontrado) { // Si la bandera siguió en 'false' tras recorrer toda la lista
            System.out.println("No se encontró un producto con ese ID.");
        }
    }

    // MÉTODO 3: SUMAR STOCK / REABASTECER
    // Pide la cantidad a ingresar ('quantity') y se la suma a la existencia previa del producto ('getExistence')
    public void addStock(int id, int quantity) {
        boolean encontrado = false;
        for (Product p : products) {
            if (p.getId() == id) {
                // Lee el stock guardado actualmente, le suma el nuevo número y actualiza el atributo con setExistence
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

    // MÉTODO 4: MOSTRAR INVENTARIO COMPLETO
    // Verifica si la lista tiene elementos; si los tiene, la recorre imprimiendo los atributos con los getters
    public void showInventory() {
        if (products.isEmpty()) { // .isEmpty() verifica si la LinkedList está vacía (devuelve true)
            System.out.println("\nEl inventario está vacío.");
        } else {
            System.out.println("\n--- LISTA DE PRODUCTOS ---");
            for (Product p : products) {
                // Obtenemos cada atributo con su correspondiente método GET
                System.out.println("ID: " + p.getId() + " | Nombre: " + p.getName() + 
                                   " | Stock: " + p.getExistence() + " | Precio: $" + p.getPrice() + 
                                   " | Categoría: " + p.getCategory());
            }
        }
    }

    // MÉTODO 5: MODIFICAR CATEGORÍA (RETO)
    // Recorre los nodos de la lista hasta hallar el ID e invoca 'setCategory'
    public void updateCategory(int idCategory, String newCategory) {
        boolean encontrado = false;
        for (Product p : products) {
            if (p.getId() == idCategory) {
                p.setCategory(newCategory); // Actualiza la cadena de texto de la categoría
                System.out.println("¡Categoría actualizada correctamente!");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró un producto con ese ID.");
        }
    }

    // MÉTODO 6: CONSULTAR POR ID (RETO)
    // Busca un único producto por su código de identificación y muestra su información detallada
    public void consultProductById(int idConsult) {
        boolean encontrado = false;
        for (Product p : products) {
            if (p.getId() == idConsult) {
                System.out.println("\n--- PRODUCTO ENCONTRADO ---");
                System.out.println("ID: " + p.getId() + " | Nombre: " + p.getName() + 
                                   " | Stock: " + p.getExistence() + " | Precio: $" + p.getPrice() + 
                                   " | Categoría: " + p.getCategory());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró un producto con ese ID.");
        }
    }
}