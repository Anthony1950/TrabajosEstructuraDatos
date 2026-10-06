public class Product {
    // Atributos privados del producto (Aplicamos el principio de Encapsulamiento)
    // Los declaramos 'private' para que nadie desde fuera de esta clase pueda modificarlos 
    private int id;
    private String name;
    private int existence;
    private double price;
    private String category; // Reto: Atributo adicional para clasificar el producto en una categoría

    // CONSTRUCTOR: Se ejecuta de manera automática cada vez que hacemos un 'new Product(...)'
    // Su trabajo es recibir los valores iniciales y asignarlos a las casillas de este producto específico
    public Product(int id, String name, int existence, double price, String category) {
        // La palabra reservada 'this' diferencia el atributo de la clase del parámetro recibido entre paréntesis
        this.id = id;                 // Guarda el ID asignado
        this.name = name;             // Guarda el nombre del producto
        this.existence = existence;   // Guarda la cantidad inicial en stock
        this.price = price;           // Guarda el precio unitario
        this.category = category;     // Guarda la categoría asignada
    }

    // GETTERS Y SETTERS: Son las puertas de acceso públicas para leer (get) o modificar (set) los datos privados
    
    // Asigna o cambia el ID del producto
    public void setId(int id) {
        this.id = id;
    }
    // Retorna el ID actual del producto para cuando necesitemos buscarlo o mostrarlo
    public int getId() {
        return id;
    }

    // Asigna o cambia el nombre del producto
    public void setName(String name) {
        this.name = name;
    }
    // Retorna el nombre actual del producto
    public String getName() {
        return name;
    }

    // Asigna o cambia la cantidad de stock disponible
    public void setExistence(int existence) {
        this.existence = existence;
    }
    // Retorna la cantidad de existencias acumuladas en inventario
    public int getExistence() {
        return existence;
    }

    // Asigna o cambia el precio del producto
    public void setPrice(double price) {
        this.price = price;
    }
    // Retorna el precio unitario del producto
    public double getPrice() {
        return price;
    }

    // Asigna o modifica la categoría del producto (parte del reto)
    public void setCategory(String category) {
        this.category = category;
    }
    // Retorna la categoría actual del producto
    public String getCategory() {
        return category;
    }
}