package modelo;

/**
 * Implementación de un Árbol Binario de Búsqueda (ABB) para gestionar postulantes.
 * Los postulantes se almacenan ordenados alfabéticamente por nombre.
 */
public class ABB {
    private NodoABB raiz;
    
    /**
     * Constructor que inicializa un árbol vacío.
     */
    public ABB() {
        this.raiz = null;
    }
    
    /**
     * Inserta un postulante en el árbol.
     * 
     * @param postulante El postulante a insertar.
     */
    public void insertar(Postulante postulante) {
        raiz = insertarRecursivo(raiz, postulante);
    }
    
    /**
     * Método recursivo para insertar un postulante en el árbol.
     * 
     * @param nodo El nodo actual.
     * @param postulante El postulante a insertar.
     * @return El nodo actualizado.
     */
    private NodoABB insertarRecursivo(NodoABB nodo, Postulante postulante) {
        if (nodo == null) {
            return new NodoABB(postulante);
        }
        
        int comparacion = postulante.getNombre().compareToIgnoreCase(nodo.getPostulante().getNombre());
        
        if (comparacion < 0) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), postulante));
        } else if (comparacion > 0) {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), postulante));
        }
        
        return nodo;
    }
    
    /**
     * Busca un postulante por nombre en el árbol.
     * 
     * @param nombre El nombre del postulante a buscar.
     * @return El postulante encontrado o null si no existe.
     */
    public Postulante buscar(String nombre) {
        return buscarRecursivo(raiz, nombre);
    }
    
    /**
     * Método recursivo para buscar un postulante por nombre.
     * 
     * @param nodo El nodo actual.
     * @param nombre El nombre a buscar.
     * @return El postulante encontrado o null si no existe.
     */
    private Postulante buscarRecursivo(NodoABB nodo, String nombre) {
        if (nodo == null) {
            return null;
        }
        
        int comparacion = nombre.compareToIgnoreCase(nodo.getPostulante().getNombre());
        
        if (comparacion == 0) {
            return nodo.getPostulante();
        } else if (comparacion < 0) {
            return buscarRecursivo(nodo.getIzquierdo(), nombre);
        } else {
            return buscarRecursivo(nodo.getDerecho(), nombre);
        }
    }
    
    /**
     * Obtiene la raíz del árbol.
     * 
     * @return El nodo raíz del árbol.
     */
    public NodoABB getRaiz() {
        return raiz;
    }
    
    /**
     * Verifica si el árbol está vacío.
     * 
     * @return true si el árbol está vacío, false en caso contrario.
     */
    public boolean estaVacio() {
        return raiz == null;
    }
}
