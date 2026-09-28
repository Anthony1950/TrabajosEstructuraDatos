import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.LinkedList;

public class Listas_enlazadas {
    public static void main(String[] args) {
        LinkedList<String> Materias = new LinkedList<>();{
            Materias.add("Matematicas");
            Materias.add("Ingles");
            Materias.add("Bases de datos");
            Materias.add("Redes");

            // RECORRO LA LISTA CON UN FOR EACH
            System.out.println("LISTA DE MATERIAS: ");
            Materias.forEach(System.out::println);

            // AGREGAR ALGORITMO AL COMIENZO Y AL FINAL DE LA LISTA
            Materias.addFirst("Algoritmos");
            Materias.addLast("Inteligencia Artificial");

            System.out.println("\nLISTA DE MATERIAS DESPUES DE AGREGAR AL INICIO Y AL FINAL:");
            Materias.forEach(System.out::println);

            // MOSTRAR EL ELEMENTO 3
            System.out.println("\nELEMENTO 3: ");
            System.out.println(Materias.get(3));

            System.out.println("PRIMER ELEMENTO: ");
            System.out.println(Materias.getFirst());

            System.out.println("ULTIMO ELEMENTO: ");
            System.out.println(Materias.getLast());

            System.out.println("\nEsta la materia Ingles en la lista?");    
            System.out.println(Materias.contains("Ingles") ? "Si esta" : "No esta");

            // Buscar el indice de la lista
            int indice = Materias.indexOf("Matematicas");

            // Lista antes de modificar
            System.out.println("\nLista antes de modificar: " + Materias);

            if (indice != -1) {
                // Se modifica con set el dato en esa posicion
                Materias.set(indice, "Matematicas Aplicadas");
                System.out.println("Lista modificada: " + Materias);
            } else {
                System.out.println("No se encuentra"); 
            }

            // Eliminar un dato con el nombre
            Materias.remove("Ingles");
            System.out.println("\nEliminar Ingles: " + Materias);
            
            // Eliminar un dato por el indice
            Materias.remove(2);
            System.out.println("Eliminar en el indice 2: " + Materias);
            
            // Eliminar el primer elemento
            Materias.removeFirst();
            System.out.println("Eliminar el primer elemento: " + Materias);
            
            // Eliminar el ultimo elemento
            Materias.removeLast();
            System.out.println("Eliminar el ultimo elemento: " + Materias);

            // Recorrer con un for la lista
            System.out.println("\nRecorrido con FOR clásico:");
            for (int i = 0; i < Materias.size(); i++) {
                System.out.println(Materias.get(i));
            }
         
            // Recorrer la lista con un for each
            System.out.println("\nRecorrido con FOR EACH:");
            Materias.forEach(System.out::println);

            // ==========================================
            // 7. CONTAR Y VERIFICAR
            // ==========================================
            System.out.println("\n--- 7. CONTAR Y VERIFICAR ---");
            int cantidad = Materias.size();
            System.out.println("Elementos restantes en la lista: " + cantidad);
            
            if (Materias.isEmpty()) {
                System.out.println("La lista esta completamente vacia.");
            } else {
                System.out.println("La lista contiene informacion activa.");
            }

            // ==========================================
            // 8. ELIMINAR TODOS LOS ELEMENTOS
            // ==========================================
            System.out.println("\n--- 8. ELIMINAR TODOS LOS ELEMENTOS ---");
            Materias.clear(); // Elimina todos los elementos en una sola operacion
            System.out.println("Lista despues de limpiar: " + Materias);
            System.out.println("¿La lista esta vacia?: " + (Materias.isEmpty() ? "Si, esta vacia" : "No"));

            // ==========================================
            // RETO ADICIONAL
            // ==========================================
            System.out.println("\n--- RETO ADICIONAL ---");
            // Agregamos varias materias, incluyendo tres que comiencen con "Piloto"
            Materias.add("Piloto Java");
            Materias.add("Sistemas Operativos");
            Materias.add("Piloto Python");
            Materias.add("Estadistica");
            Materias.add("Piloto Web");
            Materias.add("Fisica");

            System.out.println("Lista con nuevas materias (incluyendo Piloto):");
            Materias.forEach(System.out::println);

            // Eliminamos unicamente las materias que comiencen por la palabra "Piloto"
            Materias.removeIf(materia -> materia.startsWith("Piloto"));

            System.out.println("\nLista final despues de remover las materias 'Piloto':");
            Materias.forEach(System.out::println);
        }
    }
}