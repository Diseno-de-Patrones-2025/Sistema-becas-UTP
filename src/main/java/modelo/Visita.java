package modelo;

import java.util.Date;

/**
 * Representa una visita en el sistema de becas.
 */
public class Visita {
    private String nombreVisitante;
    private String motivo;
    private Date fecha;
    private String estado;
    
    /**
     * Constructor para inicializar una visita.
     * 
     * @param nombreVisitante El nombre del visitante.
     * @param motivo El motivo de la visita.
     */
    public Visita(String nombreVisitante, String motivo) {
        this.nombreVisitante = nombreVisitante;
        this.motivo = motivo;
        this.fecha = new Date();
        this.estado = "Programada";
    }
    
    /**
     * Constructor completo para inicializar una visita.
     * 
     * @param nombreVisitante El nombre del visitante.
     * @param motivo El motivo de la visita.
     * @param fecha La fecha de la visita.
     * @param estado El estado de la visita.
     */
    public Visita(String nombreVisitante, String motivo, Date fecha, String estado) {
        this.nombreVisitante = nombreVisitante;
        this.motivo = motivo;
        this.fecha = fecha;
        this.estado = estado;
    }
    
    // Getters y setters
    public String getNombreVisitante() {
        return nombreVisitante;
    }
    
    public void setNombreVisitante(String nombreVisitante) {
        this.nombreVisitante = nombreVisitante;
    }
    
    public String getMotivo() {
        return motivo;
    }
    
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Visita{" +
                "nombreVisitante='" + nombreVisitante + '\'' +
                ", motivo='" + motivo + '\'' +
                ", fecha=" + fecha +
                ", estado='" + estado + '\'' +
                '}';
    }
}
