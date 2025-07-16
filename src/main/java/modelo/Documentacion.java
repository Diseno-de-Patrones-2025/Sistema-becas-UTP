package modelo;

import java.util.List;

/**
 * Representa la documentación asociada a un postulante.
 */
public class Documentacion {
    private Postulante postulante;
    private List<String> documentos;
    private boolean verificada;
    
    /**
     * Constructor que inicializa la documentación con un postulante y lista de documentos.
     * 
     * @param postulante El postulante al que pertenece la documentación.
     * @param documentos La lista de documentos.
     */
    public Documentacion(Postulante postulante, List<String> documentos) {
        this.postulante = postulante;
        this.documentos = documentos;
        this.verificada = false;
    }
    
    /**
     * Obtiene el postulante asociado a esta documentación.
     * 
     * @return El postulante.
     */
    public Postulante getPostulante() {
        return postulante;
    }
    
    /**
     * Establece el postulante asociado a esta documentación.
     * 
     * @param postulante El postulante a establecer.
     */
    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }
    
    /**
     * Obtiene la lista de documentos.
     * 
     * @return La lista de documentos.
     */
    public List<String> getDocumentos() {
        return documentos;
    }
    
    /**
     * Establece la lista de documentos.
     * 
     * @param documentos La lista de documentos a establecer.
     */
    public void setDocumentos(List<String> documentos) {
        this.documentos = documentos;
    }
    
    /**
     * Verifica si la documentación está verificada.
     * 
     * @return true si está verificada, false en caso contrario.
     */
    public boolean isVerificada() {
        return verificada;
    }
    
    /**
     * Establece el estado de verificación de la documentación.
     * 
     * @param verificada El estado de verificación.
     */
    public void setVerificada(boolean verificada) {
        this.verificada = verificada;
    }
}
