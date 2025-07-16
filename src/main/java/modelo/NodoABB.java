package modelo;

/**
 * Representa un nodo en el Árbol Binario de Búsqueda (ABB).
 * Cada nodo contiene un postulante y referencias a sus hijos izquierdo y derecho.
 */
public class NodoABB {
    private Postulante postulante;
    private NodoABB izquierdo;
    private NodoABB derecho;
    
    /**
     * Constructor que inicializa un nodo con un postulante.
     * 
     * @param postulante El postulante que será almacenado en este nodo.
     */
    public NodoABB(Postulante postulante) {
        this.postulante = postulante;
        this.izquierdo = null;
        this.derecho = null;
    }
    
    /**
     * Obtiene el postulante almacenado en este nodo.
     * 
     * @return El postulante del nodo.
     */
    public Postulante getPostulante() {
        return postulante;
    }
    
    /**
     * Establece el postulante para este nodo.
     * 
     * @param postulante El postulante a establecer.
     */
    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }
    
    /**
     * Obtiene el hijo izquierdo de este nodo.
     * 
     * @return El nodo hijo izquierdo.
     */
    public NodoABB getIzquierdo() {
        return izquierdo;
    }
    
    /**
     * Establece el hijo izquierdo de este nodo.
     * 
     * @param izquierdo El nodo que será el hijo izquierdo.
     */
    public void setIzquierdo(NodoABB izquierdo) {
        this.izquierdo = izquierdo;
    }
    
    /**
     * Obtiene el hijo derecho de este nodo.
     * 
     * @return El nodo hijo derecho.
     */
    public NodoABB getDerecho() {
        return derecho;
    }
    
    /**
     * Establece el hijo derecho de este nodo.
     * 
     * @param derecho El nodo que será el hijo derecho.
     */
    public void setDerecho(NodoABB derecho) {
        this.derecho = derecho;
    }
}
