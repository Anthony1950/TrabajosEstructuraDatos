public class Product {
    private int id;
    private String name;
    private int existence;
    private double price;

 // Constructor de la clase Product que inicializa los atributos de un producto con los valores proporcionados.

    public Product(int id, String name, int existence, double price) {
        this.id = id;
        this.name = name;
        this.existence = existence;
        this.price = price;
    }
// Set realiza las funciones de asignar valores a las variables privadas de la clase Product,
//  mientras que los métodos get permiten obtener los valores de esas variables. 
// Esto sigue el principio de encapsulación en la programación orientada a objetos, 
// donde los atributos de una clase se mantienen privados y se accede a ellos a través de métodos públicos.
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setExistence(int existence) {
        this.existence = existence;
    }
    public int getExistence() {
        return existence;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }

    


}
