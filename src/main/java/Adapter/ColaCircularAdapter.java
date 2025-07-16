package Adapter;

import java.util.Iterator;
import java.util.NoSuchElementException;

import modelo.ColaCircular;
import modelo.Solicitud;

/**
 * Adapter que permite iterar sobre una ColaCircular como si fuera una colección.
 * Implementa el patrón Adapter para proporcionar una interfaz Iterable a la ColaCircular.
 */
public class ColaCircularAdapter implements Iterable<Solicitud> {
    private final ColaCircular cola;
    
    /**
     * Constructor que recibe una ColaCircular a adaptar.
     * 
     * @param cola La cola circular a adaptar.
     */
    public ColaCircularAdapter(ColaCircular cola) {
        this.cola = cola;
    }
    
    /**
     * Retorna un iterador para recorrer las solicitudes de la cola.
     * 
     * @return Un iterador de solicitudes.
     */
    @Override
    public Iterator<Solicitud> iterator() {
        return new ColaIterator();
    }
    
    /**
     * Clase interna que implementa el iterador para la ColaCircular.
     */
    private class ColaIterator implements Iterator<Solicitud> {
        private int indiceActual;
        private int elementosRecorridos;
        
        /**
         * Constructor del iterador.
         */
        public ColaIterator() {
            this.indiceActual = cola.getFrente();
            this.elementosRecorridos = 0;
        }
        
        /**
         * Verifica si hay más elementos para iterar.
         * 
         * @return true si hay más elementos, false en caso contrario.
         */
        @Override
        public boolean hasNext() {
            return elementosRecorridos < cola.getTamaño();
        }
        
        /**
         * Retorna la siguiente solicitud en la iteración.
         * 
         * @return La siguiente solicitud.
         */
        @Override
        public Solicitud next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            
            Solicitud solicitud = cola.getSolicitudes()[indiceActual];
            indiceActual = (indiceActual + 1) % cola.getCapacidad();
            elementosRecorridos++;
            
            return solicitud;
        }
    }
}
