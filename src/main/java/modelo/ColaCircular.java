package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una cola circular que gestiona solicitudes en el sistema de becas.
 * La cola tiene una capacidad fija y permite encolar, desencolar, y consultar las solicitudes.
 */

public class ColaCircular {
    private Solicitud[] cola;
    private int frente, finalCola, capacidad, tamaño;
    
    /**
     * Constructor que inicializa la cola con la capacidad especificada.
     * 
     * @param capacidad La capacidad máxima de la cola.
     */
    
    public ColaCircular(int capacidad) {
        this.capacidad = capacidad;
        cola = new Solicitud[capacidad];
        frente = 0;
        finalCola = -1;
        tamaño = 0;
    }

    /**
     * Verifica si la cola está vacía.
     * 
     * @return true si la cola está vacía, false si está llena.
     */
    
    public boolean estaVacia() {
        return tamaño == 0;
    }
    
    /**
     * Verifica si la cola está llena.
     * 
     * @return true si la cola está llena, false si está vacía.
     */
    
    public boolean estaLlena() {
        return tamaño == capacidad;
    }
    
    /**
     * Encola una nueva solicitud en la cola.
     * Si la cola está llena, no se agrega la solicitud y muestra un mensaje de error.
     * 
     * @param solicitud La solicitud que se va a agregar a la cola.
     */
    
    public void encolar(Solicitud solicitud) {
        if (estaLlena()) {
            System.out.println("La cola está llena. No se puede agregar más solicitudes.");
            return;
        }
        finalCola = (finalCola + 1) % capacidad;
        cola[finalCola] = solicitud;
        tamaño++;
    }
    
    /**
     * Desencola la solicitud del frente de la cola.
     * Si la cola está vacía, devuelve null y muestra un mensaje de error.
     * 
     * @return La solicitud desencolada, o null si la cola está vacía.
     */
    
    public Solicitud desencolar() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return null;
        }
        Solicitud solicitud = cola[frente];
        frente = (frente + 1) % capacidad;
        tamaño--;
        return solicitud;
    }
    
    /**
     * Obtiene todas las solicitudes actuales en la cola, en el orden en que están almacenadas.
     * Si la cola está organizada en forma circular, la lista será recorrida en dos partes.
     * 
     * @return Una lista de todas las solicitudes en la cola.
     */
    
    public List<Solicitud> getSolicitudes(){
        List<Solicitud> solicitudes = new ArrayList<>();
        if (frente<=finalCola){
            //Recorre la cola de frente a final
            for (int i=frente;i<=finalCola;i++)
                solicitudes.add(cola[i]);
        }else{
            //La cola está en forma circular, por lo que se recorre en dos partes
            for (int i = frente; i < capacidad; i++) 
                solicitudes.add(cola[i]);
            for (int i = 0; i <= finalCola; i++) 
                solicitudes.add(cola[i]);
        }
        return solicitudes;
    }
    
    /**
     * Obtiene la solicitud en el frente de la cola sin eliminarla.
     * Si la cola está vacía, devuelve null y muestra un mensaje de error.
     * 
     * @return La solicitud en el frente de la cola, o null si la cola está vacía.
     */
    
    public Solicitud obtenerFrente() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return null;
        }
        return cola[frente];
    }

    /**
     * Muestra las solicitudes en la cola, incluyendo el nombre del postulante y el estado de la solicitud.
     * Si la cola está vacía, muestra un mensaje indicando que no hay solicitudes.
     */
    
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("No hay solicitudes en la cola.");
            return;
        }
        System.out.println("Solicitudes en la cola:");
        for (int i = 0; i < tamaño; i++) {
            int index = (frente + i) % capacidad;
            Solicitud solicitud = cola[index];
            System.out.println(solicitud.getPostulante().getNombre() + " - Estado: " + solicitud.getEstado());
        }
    }
}
