package modelo;

/**
 * Representa una solicitud de beca realizada por un postulante en el sistema de becas.
 * Cada solicitud tiene un estado (pendiente, aprobada, rechazada) y un estado que indica 
 * si la solicitud ha sido procesada o no.
 */

public class Solicitud {
    private Postulante postulante;
    private String estado; //Ejemplo: pendiente, aprobada, rechazada
    private boolean procesada; //Verifica si fue procesada
    
    /**
     * Constructor que crea una nueva solicitud para un postulante con el estado inicial de "Pendiente".
     * La solicitud no está procesada al momento de su creación.
     * 
     * @param postulante El postulante que realiza la solicitud de beca.
     * @param estado El estado inicial de la solicitud (por defecto es "Pendiente").
     */
    
    public Solicitud(Postulante postulante, String estado) {
        this.postulante = postulante;
        this.estado="Pendiente"; //Inicialmente la solicitud está pendiente
        this.procesada=false; //Inicialmente no está procesada
    }
    
    /**
     * Devuelve el postulante que realizó la solicitud.
     * 
     * @return El postulante que realizó la solicitud.
     */
    
    public Postulante getPostulante() {
        return postulante;
    }
    
    /**
     * Devuelve el estado actual la solicitud.
     * 
     * @return El estado de la solicitud (por ejemplo: "Pendiente", "Aprobada", "Rechazada").
     */
    
    public String getEstado() {
        return estado;
    }
    
    /**
     * Establece un nuevo estado para la solicitud.
     * 
     * @param estado El nuevo estado de la solicitud.
     */
    
    public void setEstado(String estado) {
        this.estado=estado;
    }
    
    /**
     * Verifica si la solicitud ha sido procesada.
     * 
     * @return true si la solicitud ha sido procesada, false si no se ha procesado.
     */
    
    public boolean estaProcesada() {
        return procesada;
    }
    
    /**
     * Indica la solicitud como procesada.
     * Una vez procesada, el estado de la solicitud no se podrá cambiar.
     */
    
    public void procesar() {
        this.procesada=true;
    }
}

