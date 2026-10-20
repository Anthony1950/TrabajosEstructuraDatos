import java.util.*;


public class RegistroEstudiantes {
    public static void main(String[] args) {
        //Paso 1 crear el vector
        Vector <String> estudiantes = new Vector<>(4);
        estudiantes.add("Juan Pérez");
        estudiantes.add("María López");
        estudiantes.add("Carlos García");
        System.out.println(estudiantes);

        //PASO 2: Comparar con un arreglo
        String[] arreglo = {"Juan Pérez", "María López", "Carlos García"};
        //imprime el segundo elemento del arreglo
        System.out.println(arreglo[1]);
        //imprime el segundo elemento del vector
        System.out.println(estudiantes.get(1));
        //imprime el tamaño del arreglo
        System.out.println(arreglo.length);
        //imprime el tamaño del vector
        System.out.println(estudiantes.size());

        //arreglo [3] = "Ana Torres"; //No se puede agregar un elemento a un arreglo


        //PASO 3 CONSUKTAR POR INDICE
        //¿QUE IMPRIME CADA ITEM?
        
         // Imprime el primer elemento del vector
        System.out.println(estudiantes.get(0));
        // Imprime el primer elemento del arreglo
        System.out.println(arreglo[0]);

        // PASO 4: TAMAÑO VS CAPACIDAD
        // Imprime el tamaño del vector
        System.out.println("Tamaño del vector: " + estudiantes.size());
        // Imprime la capacidad del vector
        System.out.println("Capacidad del vector: " + estudiantes.capacity());


        //RETO de usar los metodos add, get, set, remove, size, capacity con un vector de 10 elementos
        Vector <String> v = new Vector<>(2);
        v.add("Ana Torres");
        v.add("Luis Martínez");
        v.add("Sofía Ramírez");
        System.out.println("Tamaño del vector v: " + v.size());
        System.out.println("Capacidad del vector v: " + v.capacity());

        //Crear un vector de 10 elementos que use add, get, set, remove, size, capacity
       System.out.println("Reto ");
        Vector <String> v2 = new Vector<>(10);
        // Agregar elementos al vector v2
        v2.add("Ana Torres");
        v2.add("Luis Martínez");
        v2.add("Sofía Ramírez");
        v2.add("Juan Pérez");
        v2.add("María López");
        v2.add("Samuel Gómez");
        v2.add("Micola Fernández");
        v2.add("Laura Sánchez");
        v2.add("Pedro Jiménez");
        v2.add("Mariela Torres");
        //imprimir el vector v2
        System.out.println("Vector v2: " + v2);
        //setear el segundo elemento del vector v2 por "Samanta Lopeza"
        v2.set(1, "Samanta Lopeza");
        //imprimir el vector v2
        System.out.println("Vector v2 después de setear el segundo elemento: " + v2);
        //eliminar el primer elemento del vector v2
        v2.remove(0);
        //imprimir el vector v2
        System.out.println("Vector v2 después de eliminar el primer elemento: " + v2);
        //get el tercer elemento del vector v2
        System.out.println("Tercer elemento del vector v2: " + v2.get(2));

        System.out.println("Tamaño del vector v2: " + v2.size());
        System.out.println("Capacidad del vector v2: " + v2.capacity());
        

    }
}
