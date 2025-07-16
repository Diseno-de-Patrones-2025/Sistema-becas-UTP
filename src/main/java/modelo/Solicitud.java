package modelo;

import java.util.Date;

/**
 * Representa una solicitud de beca en el sistema.
 * Contiene información sobre el postulante, el programa solicitado, 
 * la fecha de solicitud y el estado actual.
 */
public class Solicitud {
    private Postulante postulante;
    private String programa;
    private Date fecha;
    private String estado;
    
    /**
     * Constructor vacío para inicializar una solicitud sin datos.
     */
    public Solicitud() {
        this.postulante = null;
        this.programa = "";
        this.fecha = new Date();
        this.estado = "Pendiente";
    }
    
    /**
     * Constructor que inicializa una solicitud con postulante, programa y fecha.
     * 
     * @param postulante El postulante que hace la solicitud.
     * @param programa El programa de beca solicitado.
     * @param fecha La fecha de la solicitud.
     */
    public Solicitud(Postulante postulante, String programa, Date fecha) {
        this.postulante = postulante;
        this.programa = programa;
        this.fecha = fecha;
        this.estado = "Pendiente";
    }
    
    /**
     * Constructor que inicializa una solicitud con todos los datos incluido el estado.
     * 
     * @param postulante El postulante que hace la solicitud.
     * @param programa El programa de beca solicitado.
     * @param fecha La fecha de la solicitud.
     * @param estado El estado inicial de la solicitud.
     */
    public Solicitud(Postulante postulante, String programa, Date fecha, String estado) {
        this.postulante = postulante;
        this.programa = programa;
        this.fecha = fecha;
        this.estado = estado;
    }
    
    /**
     * Obtiene el postulante de la solicitud.
     * 
     * @return El postulante.
     */
    public Postulante getPostulante() {
        return postulante;
    }
    
    /**
     * Establece el postulante de la solicitud.
     * 
     * @param postulante El postulante a establecer.
     */
    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }
    
    /**
     * Obtiene el programa de la solicitud.
     * 
     * @return El programa solicitado.
     */
    public String getPrograma() {
        return programa;
    }
    
    /**
     * Establece el programa de la solicitud.
     * 
     * @param programa El programa a establecer.
     */
    public void setPrograma(String programa) {
        this.programa = programa;
    }
    
    /**
     * Obtiene la fecha de la solicitud.
     * 
     * @return La fecha de la solicitud.
     */
    public Date getFecha() {
        return fecha;
    }
    
    /**
     * Establece la fecha de la solicitud.
     * 
     * @param fecha La fecha a establecer.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    /**
     * Obtiene el estado de la solicitud.
     * 
     * @return El estado actual.
     */
    public String getEstado() {
        return estado;
    }
    
    /**
     * Establece el estado de la solicitud.
     * 
     * @param estado El estado a establecer.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    /**
     * Devuelve una representación en cadena de la solicitud.
     * 
     * @return Una cadena que representa la solicitud.
     */
    @Override
    public String toString() {
        return "Solicitud{" +
                "postulante=" + postulante.getNombre() + " " + postulante.getApellido() +
                ", programa='" + programa + '\'' +
                ", fecha=" + fecha +
                ", estado='" + estado + '\'' +
                '}';
    }
}
