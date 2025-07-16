package modelo;

/**
 * Representa a un postulante en el sistema de becas. Un postulante es una persona que ha 
 * aplicado a una beca y contiene información personal como su nombre, apellido y correo electrónico.
 */

public class Postulante {
    private String nombre;
    private String apellido;
    private String correo;
    
    //Constructor, getters y setters
    
    /**
     * Constructor que inicializa un nuevo postulante con su nombre, apellido y correo electrónico.
     * 
     * @param nombre El nombre del postulante.
     * @param apellido El apellido del postulante.
     * @param correo El correo electrónico del postulante.
     */

    public Postulante(String nombre, String apellido, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    /**
     * Devuelve el nombre del postulante.
     * 
     * @return El nombre del postulante.
     */
    
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Devuelve el apellido del postulante.
     * 
     * @return El apellido del postulante.
     */
    
    public String getApellido() {
        return apellido;
    }
    
    /**
     * Devuelve el correo electrónico del postulante.
     * 
     * @return El correo electrónico del postulante.
     */
    
    public String getCorreo() {
        return correo;
    }
}
