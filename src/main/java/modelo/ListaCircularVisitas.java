package modelo;

/**
 * Implementación de una lista circular para gestionar visitas.
 */
public class ListaCircularVisitas {
    private NodoVisita cabeza;
    private NodoVisita cola;
    private int tamaño;
    private int capacidad;
    
    /**
     * Constructor que inicializa la lista con una capacidad específica.
     * 
     * @param capacidad La capacidad máxima de la lista.
     */
    public ListaCircularVisitas(int capacidad) {
        this.cabeza = null;
        this.cola = null;
        this.tamaño = 0;
        this.capacidad = capacidad;
    }
    
    /**
     * Agrega una visita al final de la lista.
     * 
     * @param visita La visita a agregar.
     * @return true si se agregó exitosamente, false si la lista está llena.
     */
    public boolean agregar(Visita visita) {
        if (tamaño >= capacidad) {
            return false;
        }
        
        NodoVisita nuevoNodo = new NodoVisita(visita);
        
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            nuevoNodo.setSiguiente(cabeza);
        } else {
            cola.setSiguiente(nuevoNodo);
            nuevoNodo.setSiguiente(cabeza);
            cola = nuevoNodo;
        }
        
        tamaño++;
        return true;
    }
    
    /**
     * Obtiene todas las visitas en la lista.
     * 
     * @return Un array con todas las visitas.
     */
    public Visita[] obtenerVisitas() {
        if (tamaño == 0) {
            return new Visita[0];
        }
        
        Visita[] visitas = new Visita[tamaño];
        NodoVisita actual = cabeza;
        
        for (int i = 0; i < tamaño; i++) {
            visitas[i] = actual.getVisita();
            actual = actual.getSiguiente();
        }
        
        return visitas;
    }
    
    /**
     * Verifica si la lista está vacía.
     * 
     * @return true si está vacía, false en caso contrario.
     */
    public boolean estaVacia() {
        return tamaño == 0;
    }
    
    /**
     * Obtiene el tamaño actual de la lista.
     * 
     * @return El número de elementos en la lista.
     */
    public int getTamaño() {
        return tamaño;
    }
    
    /**
     * Clase interna para representar un nodo de la lista.
     */
    private static class NodoVisita {
        private Visita visita;
        private NodoVisita siguiente;
        
        public NodoVisita(Visita visita) {
            this.visita = visita;
            this.siguiente = null;
        }
        
        public Visita getVisita() {
            return visita;
        }
        
        public void setVisita(Visita visita) {
            this.visita = visita;
        }
        
        public NodoVisita getSiguiente() {
            return siguiente;
        }
        
        public void setSiguiente(NodoVisita siguiente) {
            this.siguiente = siguiente;
        }
    }
}
