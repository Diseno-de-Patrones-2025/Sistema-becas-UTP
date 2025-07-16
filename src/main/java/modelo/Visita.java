package modelo;

/**
 * Representa una visita realizada a un postulante en el sistema de becas.
 * Cada visita está asociada a un postulante específico y contiene detalles sobre 
 * la fecha de la visita y las observaciones realizadas durante la misma.
 */

public class Visita {
    private Postulante postulante;
    private String fecha;
    private String observaciones;
    
    /**
     * Constructor que genera una nueva visita para un postulante, en una fecha específica
     * y con observaciones asociadas a la misma.
     * 
     * @param postulante El postulante al que se le realizó la visita.
     * @param fecha La fecha en que se realizó la visita.
     * @param observaciones Las observaciones realizadas durante la visita.
     */
    
    public Visita(Postulante postulante, String fecha, String observaciones) {
        this.postulante = postulante;
        this.fecha = fecha;
        this.observaciones = observaciones;
    }
    
    /**
     * Devuelve el postulante al que se le realizó la visita.
     * 
     * @return El postulante al que se le realizó la visita.
     */
    
    public Postulante getPostulante() {
        return postulante;
    }

    /**
     * Devuelve la fecha en que se realizó la visita.
     * 
     * @return La fecha de la visita.
     */
    
    public String getFecha() {
        return fecha;
    }

    /**
     * Devuelve las observaciones realizadas durante la visita.
     * 
     * @return Las observaciones realizadas en la visita.
     */
    
    public String getObservaciones() {
        return observaciones;
    }
}
