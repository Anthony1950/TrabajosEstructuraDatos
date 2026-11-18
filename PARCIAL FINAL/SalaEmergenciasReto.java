import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/*
 * RETO 1: Que salga primero el MENOS grave
 * Estudiante: Samuel Cardozo  
 *
 * Qué debo hacer: Modificar compareTo para que el triage atienda
 * primero al paciente menos grave.
 * Pregunta: ¿Quién sale primero y quién de último?
 *
 * 1. Mi predicción (ANTES de ejecutar):
 * Creo que Juan saldrá primero, porque tiene gravedad 1 y es
 * el primero de los pacientes leves que se registró.
 * Pienso que Omar saldrá de último porque tiene gravedad 4.
 *
 * 2. Lo que salió en la consola:
 * En la consola apareció primero Juan (Leve), después Xochilt,
 * Ignacio, Raquel, Beatriz, y de último Omar (Muy grave).
 * El programa mostró 6 pacientes atendidos en total.
 *
 * 3. Por qué salió así:
 * Fue lo que esperaba porque cambié el orden de Integer.compare
 * en compareTo. Antes el programa priorizaba la gravedad más alta;
 * ahora da prioridad al número más bajo. Por eso los leves salen
 * primero y Omar, que tiene gravedad 4, queda al final.
 */

/*
 * ============================================================
 *  SALA DE EMERGENCIAS
 *  Estructura de Datos - UNIMINUTO
 * ============================================================
 *  Nombre completo: Samuel Cardozo
 *
 *  INSTRUCCIONES
 *  1. Ejecuta el programa y mira la salida en la consola.
 *  2. Responde las 8 preguntas (P1 a P8). Escribe tu respuesta
 *     en la línea "// R:" que está debajo de cada pregunta.
 *  3. Respuestas cortas: la respuesta y una frase de por qué.
 *  4. No borres ni cambies el código de este archivo.
 * ============================================================
 */
public class SalaEmergenciasReto {

    // Clase Paciente: el "molde" de cada paciente.
    // Va dentro de SalaEmergencias (por eso lleva static).
    static class Paciente implements Comparable<Paciente> {

        private String nombre;
        private int gravedad;   // 1 Leve, 2 Moderada, 3 Grave, 4 Muy grave

        public Paciente(String nombre, int gravedad) {
            this.nombre = nombre;
            this.gravedad = gravedad;
        }
        // P1. En "this.nombre = nombre", ¿cuál de los dos es el atributo
        //     del paciente y cuál es el dato que llegó entre paréntesis?
        // R: this.nombre es el atributo del paciente; nombre es el dato que recibe el constructor.

        public String getNombre() {
            return nombre;
        }

        public int getGravedad() {
            return gravedad;
        }

        public String getGravedadTexto() {
            switch (gravedad) {
                case 1: return "Leve";
                case 2: return "Moderada";
                case 3: return "Grave";
                case 4: return "Muy grave";
                default: return "Desconocida";
            }
        }
        // P2. Si un paciente tuviera gravedad 7, ¿qué texto mostraría? ¿Por qué?
        // R: Mostraría "Desconocida", porque el switch no tiene un caso para 7 y usa default.

        @Override
        public String toString() {
            return nombre + " (" + getGravedadTexto() + ")";
        }

        @Override
        public int compareTo(Paciente otro) {
            return Integer.compare(this.gravedad, otro.gravedad);
        }
        // P3. compareTo decide quién va primero en el triage.
        //     Si se escribiera Integer.compare(this.gravedad, otro.gravedad),
        //     ¿quién saldría primero: el más grave o el menos grave?
        // R: El menos grave, porque la comparación pondría primero el número más bajo.
    }

    public static void main(String[] args) {

        // ---------- 1. SALA DE ESPERA (Queue: orden de llegada) ----------
        Queue<Paciente> salaEspera = new LinkedList<>();
        salaEspera.offer(new Paciente("Juan", 1));
        salaEspera.offer(new Paciente("Raquel", 3));
        salaEspera.offer(new Paciente("Ignacio", 2));
        salaEspera.offer(new Paciente("Omar", 4));
        salaEspera.offer(new Paciente("Beatriz", 3));
        salaEspera.offer(new Paciente("Xochilt", 1));
        System.out.println("Orden de llegada: " + salaEspera);
        // P4. ¿Por qué Juan aparece de primero en la sala de espera?
        // R: Porque fue el primero en ingresar y la cola respeta el orden de llegada (FIFO).

        // ---------- 2. TRIAGE (PriorityQueue: el más grave primero) ----------
        PriorityQueue<Paciente> triage = new PriorityQueue<>();
        while (!salaEspera.isEmpty()) {
            triage.offer(salaEspera.poll());
        }
        System.out.println("Paciente mas urgente: " + triage.peek());
        System.out.println();
        // P5. Al terminar este while, ¿cuántos pacientes quedan en salaEspera? ¿Por qué?
        // R: Quedan 0, porque poll() saca cada paciente de la sala y offer() lo pasa al triage.

        // ---------- 3. ATENCIÓN E HISTORIAL (Stack: el último queda arriba) ----------
        Stack<Paciente> historial = new Stack<>();
        while (!triage.isEmpty()) {
            Paciente atendido = triage.poll();
            System.out.println("Atendiendo a: " + atendido);
            historial.push(atendido);
        }
        // P6. Juan llegó de primero, pero lo atienden de quinto. ¿Por qué?
        // R: Porque el triage prioriza la gravedad y Juan es leve (nivel 1), no el orden de llegada.

        System.out.println();
        System.out.println("Ultimo paciente atendido: " + historial.peek());
        System.out.println("Total atendidos: " + historial.size());
        // P7. ¿Por qué historial.peek() muestra a Xochilt y no a Omar?
        // R: Porque la pila guarda al último atendido en la cima; Xochilt se atendió de última.

        // P8. ¿Qué diferencia hay entre peek() y poll()? Da un ejemplo de este código.
        // R: peek() solo mira al más urgente (Omar); poll() lo extrae del triage para atenderlo.
    }
}
