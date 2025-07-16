package modelo;

/**
 * Implementación de una cola circular para gestionar solicitudes.
 * Utiliza un array circular con capacidad fija.
 */
public class ColaCircular {
    private Solicitud[] solicitudes;
    private int frente;
    private int trasero;
    private int tamaño;
    private int capacidad;
    
    /**
     * Constructor que inicializa la cola con una capacidad específica.
     * 
     * @param capacidad La capacidad máxima de la cola.
     */
    public ColaCircular(int capacidad) {
        this.capacidad = capacidad;
        this.solicitudes = new Solicitud[capacidad];
        this.frente = 0;
        this.trasero = -1;
        this.tamaño = 0;
    }
    
    /**
     * Agrega una solicitud al final de la cola.
     * 
     * @param solicitud La solicitud a agregar.
     * @return true si se agregó exitosamente, false si la cola está llena.
     */
    public boolean encolar(Solicitud solicitud) {
        if (estaLlena()) {
            return false;
        }
        
        trasero = (trasero + 1) % capacidad;
        solicitudes[trasero] = solicitud;
        tamaño++;
        return true;
    }
    
    /**
     * Remueve y retorna la solicitud al frente de la cola.
     * 
     * @return La solicitud removida o null si la cola está vacía.
     */
    public Solicitud desencolar() {
        if (estaVacia()) {
            return null;
        }
        
        Solicitud solicitud = solicitudes[frente];
        solicitudes[frente] = null;
        frente = (frente + 1) % capacidad;
        tamaño--;
        return solicitud;
    }
    
    /**
     * Retorna la solicitud al frente de la cola sin removerla.
     * 
     * @return La solicitud al frente o null si la cola está vacía.
     */
    public Solicitud frente() {
        if (estaVacia()) {
            return null;
        }
        return solicitudes[frente];
    }
    
    /**
     * Verifica si la cola está vacía.
     * 
     * @return true si la cola está vacía, false en caso contrario.
     */
    public boolean estaVacia() {
        return tamaño == 0;
    }
    
    /**
     * Verifica si la cola está llena.
     * 
     * @return true si la cola está llena, false en caso contrario.
     */
    public boolean estaLlena() {
        return tamaño == capacidad;
    }
    
    /**
     * Obtiene el tamaño actual de la cola.
     * 
     * @return El número de elementos en la cola.
     */
    public int getTamaño() {
        return tamaño;
    }
    
    /**
     * Obtiene la capacidad máxima de la cola.
     * 
     * @return La capacidad máxima.
     */
    public int getCapacidad() {
        return capacidad;
    }
    
    /**
     * Obtiene el array interno de solicitudes (para uso del adapter).
     * 
     * @return El array de solicitudes.
     */
    public Solicitud[] getSolicitudes() {
        return solicitudes;
    }
    
    /**
     * Obtiene el índice del frente.
     * 
     * @return El índice del frente.
     */
    public int getFrente() {
        return frente;
    }
}
