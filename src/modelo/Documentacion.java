package modelo;

import java.util.List;

/**
 * Representa la documentación de un postulante en el sistema de becas.
 * Contiene la información sobre los documentos presentados por el postulante
 * y si la documentación ha sido verificada.
 */

public class Documentacion {
    private Postulante postulante;
    private boolean verificada;
    private List<String> documentos;
    
    /**
     * Constructor para crear un objeto de documentación para un postulante.
     * Inicializa la verificación como falsa, ya que la documentación aún no ha sido verificada.
     * 
     * @param postulante El postulante al que pertenece la documentación.
     * @param documentos La lista de documentos que el postulante ha presentado.
     */
    
    public Documentacion(Postulante postulante, List<String> documentos) {
        this.postulante = postulante;
        this.documentos = documentos;
        this.verificada = false; // Inicialmente no verificada
    }
    
    /**
     * Devuelve el postulante asociado a esta documentación.
     * 
     * @return El postulante asociado a esta documentación.
     */
    
    public Postulante getPostulante() {
        return postulante;
    }
    
    /**
     * Devuelve la lista de documentos presentados por el postulante.
     * 
     * @return Una lista de los nombres de los documentos presentados.
     */
    
    public List<String> getDocumentos() {
        return documentos;
    }
}