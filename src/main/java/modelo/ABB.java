package modelo;

/**
 * Representa un nodo en un Árbol Binario de Búsqueda (ABB), que contiene un objeto
 * {@link Postulante} y tiene referencias a los nodos izquierdo y derecho.
 */

class NodoABB {
    private Postulante postulante;
    private NodoABB izquierdo, derecho;

    /**
     * Constructor que crea un nodo en el árbol binario con un postulante.
     * 
     * @param postulante El objeto postulante que se almacenará en el nodo.
     */
    
    public NodoABB(Postulante postulante) {
        this.postulante = postulante;
        this.izquierdo = null;
        this.derecho = null;
    }
    
    /**
     * Devuelve el postulante almacenado en el nodo.
     * 
     * @return El postulante asociado al nodo.
     */
    
    public Postulante getPostulante() {
        return postulante;
    }
    
    /**
     * Devuelve el nodo izquierdo del árbol binario.
     * 
     * @return
     */
    
    public NodoABB getIzquierdo() {
        return izquierdo;
    }
    
    /**
     * Establece el nodo izquierdo del árbol binario.
     * 
     * @param izquierdo El nodo izquierdo que se va a asignar.
     */
    
    public void setIzquierdo(NodoABB izquierdo) {
        this.izquierdo = izquierdo;
    }
    
    /**
     * Devuelve el nodo derecho del árbol binario.
     * 
     * @return El nodo derecho.
     */
    
    public NodoABB getDerecho() {
        return derecho;
    }

    /**
     * Establece el nodo derecho del árbol binario.
     * 
     * @param derecho El nodo derecho que se va a asignar.
     */
    
    public void setDerecho(NodoABB derecho) {
        this.derecho = derecho;
    }
}

/**
 * Representa un Árbol Binario de Búsqueda (ABB) de {@link Postulante}, donde se pueden
 * insertar, buscar y mostrar los postulantes en orden.
 */

public class ABB {
    private NodoABB raiz;
    
    /**
     * Constructor que crea un árbol binario vacío.
     */
    
    public ABB() {
        raiz = null;
    }
    
    /**
     * Inserta un postulante en el árbol binario de búsqueda.
     * 
     * @param postulante El postulante que se va a insertar en el árbol.
     */
    
    public void insertar(Postulante postulante) {
        raiz = insertarRecursivo(raiz, postulante);
    }
    
    /**
     * Método recursivo para insertar un postulante en el árbol binario de búsqueda.
     * 
     * @param nodo El nodo actual del árbol en el que se va a insertar el postulante.
     * @param postulante El postulante que se va a insertar.
     * @return El nodo actualizado después de insertar el postulante.
     */
    
    private NodoABB insertarRecursivo(NodoABB nodo, Postulante postulante) {
        if (nodo == null) {
            return new NodoABB(postulante);
        }
        if (postulante.getNombre().compareTo(nodo.getPostulante().getNombre()) < 0) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), postulante));
        } else {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), postulante));
        }
        return nodo;
    }
    
    /**
     * Busca un postulante por su nombre en el árbol binario de búsqueda.
     * 
     * @param nombre El nombre del postulante a buscar.
     * @return El postulante encontrado o null si no se encuentra.
     */
    
    public Postulante buscar(String nombre) {
        NodoABB nodo = buscarRecursivo(raiz, nombre);
        return (nodo != null) ? nodo.getPostulante() : null;
    }
    
    /**
     * Método recursivo para buscar un postulante en el árbol binario de búsqueda.
     * 
     * @param nodo El nodo actual del árbol donde se realiza la búsqueda.
     * @param nombre El nombre del postulante a buscar.
     * @return El nodo que contiene el postulante o null si no se encuentra.
     */
    
    private NodoABB buscarRecursivo(NodoABB nodo, String nombre) {
        if (nodo == null || nodo.getPostulante().getNombre().equals(nombre)) {
            return nodo;
        }
        if (nombre.compareTo(nodo.getPostulante().getNombre()) < 0) {
            return buscarRecursivo(nodo.getIzquierdo(), nombre);
        }
        return buscarRecursivo(nodo.getDerecho(), nombre);
    }
    
    /**
     * Muestra los postulantes en orden ascendente según su nombre.
     * 
     * Este método recorre el árbol en orden y muestra los postulantes.
     */
    
    public void mostrarInOrden() {
        mostrarInOrdenRecursivo(raiz);
    }
    
    /**
     * Método recursivo para mostrar los postulantes en orden ascendente.
     * 
     * @param nodo El nodo actual que se está recorriendo en el árbol.
     */
    
    private void mostrarInOrdenRecursivo(NodoABB nodo) {
        if (nodo != null) {
            mostrarInOrdenRecursivo(nodo.getIzquierdo());
            System.out.println(nodo.getPostulante().getNombre() + " " + nodo.getPostulante().getApellido());
            mostrarInOrdenRecursivo(nodo.getDerecho());
        }
    }
}
