/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Representa un nodo en un Árbol Binario de Búsqueda (ABB), que contiene un objeto
 * {@link Postulante} y tiene referencias a los nodos izquierdo y derecho.
 */

public class NodoABB {
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

