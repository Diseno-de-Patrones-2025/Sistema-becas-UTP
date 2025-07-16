package controlador;

import modelo.ABB;
import modelo.Postulante;

/**
 * La clase GestorPostulantes se encarga de gestionar la información de los postulantes
 * en el sistema de becas. Permite registrar, buscar y mostrar los postulantes utilizando
 * un árbol binario de búsqueda (ABB).
 */

public class GestorPostulantes {
    private ABB arbolPostulantes;
    
    /**
     * Constructor que inicializa el árbol binario de búsqueda (ABB) para almacenar los postulantes.
     */
    
    public GestorPostulantes() {
        arbolPostulantes = new ABB();
    }

    /**
     * Registra un nuevo postulante en el sistema, insertándolo en el árbol binario de búsqueda.
     * 
     * @param postulante El objeto Postulante que se desea registrar en el sistema.
     */
    
    public void registrarPostulante(Postulante postulante) {
        arbolPostulantes.insertar(postulante);
    }
    
    /**
     * Busca un postulante por su nombre en el árbol de postulantes y muestra la información
     * si se encuentra registrado.
     * 
     * @param nombre El nombre del postulante a buscar en el sistema.
     */
    
    public void buscarPostulante(String nombre) {
        Postulante postulante = arbolPostulantes.buscar(nombre);
        if (postulante != null) {
            System.out.println("Postulante encontrado: " + postulante.getNombre() + " " + postulante.getApellido());
        } else {
            System.out.println("Postulante no encontrado.");
        }
    }
    
    /**
     * Muestra todos los postulantes registrados en el sistema, ordenados alfabéticamente
     * según su nombre, utilizando el recorrido InOrden del árbol binario de búsqueda.
     */

    public void mostrarPostulantes() {
        System.out.println("Postulantes registrados (en orden alfabético):");
        arbolPostulantes.mostrarInOrden();
    }
    
    /**
     * Obtiene el árbol binario de búsqueda que contiene los postulantes.
     * Método agregado para soporte del GeneradorReportes y UnifiedSystemAdapter.
     * 
     * @return El ABB con todos los postulantes registrados
     */
    public ABB getAbb() {
        return arbolPostulantes;
    }
    
    /**
     * Obtiene una lista de todos los postulantes registrados.
     * Método agregado para facilitar el análisis y reportes.
     * 
     * @return Lista de postulantes ordenados alfabéticamente
     */
    public java.util.List<Postulante> obtenerTodosLosPostulantes() {
        java.util.List<Postulante> lista = new java.util.ArrayList<>();
        // Usar el adapter para obtener los postulantes ordenados
        Adapter.ABBAdapter adapter = new Adapter.ABBAdapter(arbolPostulantes);
        for (Postulante p : adapter) {
            lista.add(p);
        }
        return lista;
    }
}
