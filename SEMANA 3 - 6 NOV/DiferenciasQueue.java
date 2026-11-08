import java.util.LinkedList;
import java.util.Queue;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;

public class DiferenciasQueue {
    public static void main(String[] args) {
        // PAR 1: add() vs offer() -> se nota cuando la cola está LLENA
        // ArrayBlockingQueue tiene capacidad fija: aquí solo caben 3
        Queue<Integer> limitada = new ArrayBlockingQueue<>(3);
        limitada.offer(10);
        limitada.offer(20);
        limitada.offer(30);
        System.out.println("Cola llena: " + limitada);

        // offer() no lanza excepción: devuelve false
        System.out.println("offer(40) devolvio: " + limitada.offer(40));

        // add() sí lanza excepción
        try {
            limitada.add(50);
        } catch (IllegalStateException e) {
            System.out.println("add(50) lanzo: " + e);
        }

        // PAR 2 y 3: poll()/remove() y peek()/element() -> se nota cuando está VACÍA
        Queue<Integer> vacia = new LinkedList<>();
        Integer r1 = vacia.poll(); // Integer, no int: puede ser null
        Integer r2 = vacia.peek();
        System.out.println("\npoll() en cola vacia: " + r1);
        System.out.println("peek() en cola vacia: " + r2);

        try {
            vacia.remove();
        } catch (NoSuchElementException e) {
            System.out.println("remove() lanzo: " + e);
        }

        try {
            vacia.element();
        } catch (NoSuchElementException e) {
            System.out.println("element() lanzo: " + e);
        }
    }
}

//Pregunta del Paso 4: Un banco tiene cupo máximo de turnos. ¿Usarías add u offer para dar turnos? ¿Por qué?
//Definitivamente offer(). Si el sistema del banco se llena, offer() me devuelve un false y con eso puedo mostrarle un mensaje amigable al usuario
//(tipo "Sistema lleno, intente más tarde"). Con add(), el programa simplemente se caería arrojando una excepción feísima (IllegalStateException) si no se maneja //adecuadamente.