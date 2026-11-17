import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

// ============================================================================
// PASO 1, 2, 5 y 7: CLASE PACIENTE
// ============================================================================
// Implementa Comparable<Paciente> para que la PriorityQueue ordene por gravedad
// y use el orden de llegada como desempate (Paso 7 - Reto).
class Paciente implements Comparable<Paciente> {

    // PASO 1: Atributos privados
    private String nombre;
    private int gravedad; // 1: Leve, 2: Moderada, 3: Grave, 4: Muy grave

    // PASO 7 (RETO): Atributo para garantizar la atención justa (FIFO en caso de empate)
    private int ordenLlegada;

    // PASO 1 y 7: Constructor
    public Paciente(String nombre, int gravedad, int ordenLlegada) {
        this.nombre = nombre;
        this.gravedad = gravedad;
        this.ordenLlegada = ordenLlegada;
    }

    // PASO 1 y 7: Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGravedad() {
        return gravedad;
    }

    public void setGravedad(int gravedad) {
        this.gravedad = gravedad;
    }

    public int getOrdenLlegada() {
        return ordenLlegada;
    }

    // PASO 2: getGravedadTexto()
    // Convierte la gravedad numérica en su representación en texto exacta según la guía
    public String getGravedadTexto() {
        switch (gravedad) {
            case 1:
                return "Leve";
            case 2:
                return "Moderada";
            case 3:
                return "Grave";
            case 4:
                return "Muy grave";
            default:
                return "Desconocida";
        }
    }

    // PASO 2: toString()
    // Devuelve la representación requerida: "Nombre (TextoGravedad)" -> ej: "Juan (Leve)"
    @Override
    public String toString() {
        return nombre + " (" + getGravedadTexto() + ")";
    }

    // PASO 5 y 7: compareTo()
    // Define el orden dentro de la PriorityQueue
    @Override
    public int compareTo(Paciente otro) {
        // 1. Comparar primero por gravedad (mayor número = mayor prioridad)
        int compGravedad = Integer.compare(otro.gravedad, this.gravedad);

        // 2. Si la gravedad es distinta, retornamos ese resultado directamente
        if (compGravedad != 0) {
            return compGravedad;
        }

        // 3. PASO 7 (RETO): Si empatan en gravedad, desempatamos por el orden de llegada
        // El que llegó antes tiene un ordenLlegada menor y sale primero
        return Integer.compare(this.ordenLlegada, otro.ordenLlegada);
    }
}

// ============================================================================
// CLASE PRINCIPAL: SALA DE EMERGENCIAS
// ============================================================================
public class SalaEmergencias {

    public static void main(String[] args) {

        // Contador secuencial para el orden de llegada
        int contadorLlegada = 1;

        // --------------------------------------------------------------------
        // PASO 1 y 2: PUNTO DE CONTROL (Prueba inicial de Paciente)
        // --------------------------------------------------------------------
        Paciente pPrueba = new Paciente("Juan", 1, contadorLlegada);
        System.out.println(pPrueba.getNombre() + " - gravedad " + pPrueba.getGravedad());
        System.out.println(pPrueba);
        System.out.println();

        // --------------------------------------------------------------------
        // PASO 3 y 7: SALA DE ESPERA (Queue con LinkedList)
        // --------------------------------------------------------------------
        Queue<Paciente> salaEspera = new LinkedList<>();

        // Pacientes iniciales (Pasos 1-6)
        salaEspera.offer(new Paciente("Juan", 1, contadorLlegada++));
        salaEspera.offer(new Paciente("Raquel", 3, contadorLlegada++));
        salaEspera.offer(new Paciente("Ignacio", 2, contadorLlegada++));
        salaEspera.offer(new Paciente("Omar", 4, contadorLlegada++));
        salaEspera.offer(new Paciente("Beatriz", 3, contadorLlegada++));
        salaEspera.offer(new Paciente("Xochilt", 1, contadorLlegada++));

        // PASO 7 (RETO): Agregamos los 3 pacientes graves adicionales al final
        salaEspera.offer(new Paciente("Simón", 3, contadorLlegada++));
        salaEspera.offer(new Paciente("Rodolfo", 3, contadorLlegada++));
        salaEspera.offer(new Paciente("Brenda", 3, contadorLlegada++));

        System.out.println("Orden de llegada: " + salaEspera);

        // --------------------------------------------------------------------
        // PASO 4 y 5: TRIAGE (PriorityQueue)
        // --------------------------------------------------------------------
        PriorityQueue<Paciente> triage = new PriorityQueue<>();

        // Vaciamos la sala de espera trasladando cada paciente al triage
        while (!salaEspera.isEmpty()) {
            triage.offer(salaEspera.poll());
        }

        // Muestra el paciente más urgente sin removerlo
        System.out.println("Paciente mas urgente: " + triage.peek());
        System.out.println();

        // --------------------------------------------------------------------
        // PASO 6: ATENCIÓN E HISTORIAL (Stack)
        // --------------------------------------------------------------------
        Stack<Paciente> historial = new Stack<>();

        // Atendemos en orden de prioridad y apilamos en el historial
        while (!triage.isEmpty()) {
            Paciente atendido = triage.poll();
            System.out.println("Atendiendo a: " + atendido);
            historial.push(atendido);
        }

        System.out.println();
        // Muestra el último atendido (cima de la pila) y la cantidad total
        System.out.println("Ultimo paciente atendido: " + historial.peek());
        System.out.println("Total atendidos: " + historial.size());
    }
}
