import java.util.Stack;

public class PilaPersonal {
    public static void main(String[] args) {

        Stack<Integer> pila = new Stack<>();

        // TODO 1: Mete con push() tus 3 datos en este orden:
        //         número de lista, día de cumpleaños, mes de cumpleaños.
        //         Después de cada push, llama a imprimirPila(pila);
        
        // Datos de ejemplo (reemplaza por tus datos reales si varían):
        // Ejemplo: Número de lista = 12, Día = 25, Mes = 7
        pila.push(12);
        imprimirPila(pila);

        pila.push(25);
        imprimirPila(pila);

        pila.push(7);
        imprimirPila(pila);


        // TODO 2: Busca tu número de lista con search() e imprime la posición.
        // Usando search() directamente dentro del System.out.println (sout):
        System.out.println("Posicion de mi numero de lista: " + pila.search(12) + "\n");


        // TODO 3: Vacía la pila de forma segura.
        //         Mientras NO esté vacía: saca con pop(), imprime "Se saco X"
        //         y llama a imprimirPila(pila);
        while (!pila.empty()) {
            int sacado = pila.pop();
            System.out.println("Se saco " + sacado);
            imprimirPila(pila);
        }
    }

    // Este método ya está completo: muestra la cima y el contenido
    private static void imprimirPila(Stack<Integer> pila) {
        if (pila.empty()) {
            System.out.println("La pila esta vacia\n");
        } else {
            System.out.println("Cima: " + pila.peek());
            System.out.println("Contenido: " + pila + "  <- la cima es el de la derecha\n");
        }
    }
}



//¿Por qué tu número de lista está en la posición 3 si fue el primero que metiste?
//Porque en Java el método search() cuenta las posiciones desde la cima (top) hacia el fondo, 
//empezando por la posición 1. Al ser el primer elemento ingresado, quedó en la 
//base de la pila.

//¿Qué pasaría si usaras while(true) en lugar de while(!pila.empty())?
//El bucle intentaría seguir haciendo pop() indefinidamente incluso cuando la pila ya estuviera vacía, 
//lo que generaría una excepción del tipo EmptyStackException haciendo que el programa colapse.