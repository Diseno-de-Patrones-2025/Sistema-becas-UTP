package Adapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import modelo.ABB;
import modelo.NodoABB;
import modelo.Postulante;

/**
 * Adapter que permite iterar sobre un Árbol Binario de Búsqueda (ABB) como si fuera una colección.
 * Implementa el patrón Adapter para proporcionar una interfaz Iterable al ABB.
 */
public class ABBAdapter implements Iterable<Postulante> {
    private final ABB abb;
    
    /**
     * Constructor que recibe un ABB a adaptar.
     * 
     * @param abb El árbol binario de búsqueda a adaptar.
     */
    public ABBAdapter(ABB abb) {
        this.abb = abb;
    }
    
    /**
     * Retorna un iterador para recorrer los postulantes del ABB en orden.
     * 
     * @return Un iterador de postulantes.
     */
    @Override
    public Iterator<Postulante> iterator() {
        return new ABBIterator();
    }
    
    /**
     * Clase interna que implementa el iterador para el ABB.
     */
    private class ABBIterator implements Iterator<Postulante> {
        private final List<Postulante> postulantes;
        private int indiceActual;
        
        /**
         * Constructor del iterador que prepara la lista de postulantes en orden.
         */
        public ABBIterator() {
            postulantes = new ArrayList<>();
            indiceActual = 0;
            if (abb != null && !abb.estaVacio()) {
                llenarListaInOrden(abb.getRaiz());
            }
        }
        
        /**
         * Método recursivo que llena la lista con los postulantes en orden.
         * 
         * @param nodo El nodo actual del árbol.
         */
        private void llenarListaInOrden(NodoABB nodo) {
            if (nodo != null) {
                llenarListaInOrden(nodo.getIzquierdo());
                postulantes.add(nodo.getPostulante());
                llenarListaInOrden(nodo.getDerecho());
            }
        }
        
        /**
         * Verifica si hay más elementos para iterar.
         * 
         * @return true si hay más elementos, false en caso contrario.
         */
        @Override
        public boolean hasNext() {
            return indiceActual < postulantes.size();
        }
        
        /**
         * Retorna el siguiente postulante en la iteración.
         * 
         * @return El siguiente postulante.
         */
        @Override
        public Postulante next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return postulantes.get(indiceActual++);
        }
    }
}
