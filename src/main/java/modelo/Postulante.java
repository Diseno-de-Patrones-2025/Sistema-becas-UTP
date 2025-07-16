package modelo;

/**
 * Representa a un postulante en el sistema de becas. Un postulante es una persona que ha 
 * aplicado a una beca y contiene información personal como su nombre, apellido y correo electrónico.
 */
public class Postulante {
    private String nombre;
    private String apellido;
    private String dni;
    private String correo;
    private double puntaje;
    
    /**
     * Constructor vacío para inicializar un postulante sin datos.
     */
    public Postulante() {
        this.nombre = "";
        this.apellido = "";
        this.dni = "";
        this.correo = "";
        this.puntaje = 0.0;
    }
    
    /**
     * Constructor que inicializa un nuevo postulante con su información básica.
     * 
     * @param nombre El nombre del postulante.
     * @param apellido El apellido del postulante.
     * @param dni El DNI del postulante.
     * @param correo El correo electrónico del postulante.
     */
    public Postulante(String nombre, String apellido, String dni, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.puntaje = 0.0;
    }

    /**
     * Constructor que inicializa un nuevo postulante con toda su información incluyendo puntaje.
     * 
     * @param nombre El nombre del postulante.
     * @param apellido El apellido del postulante.
     * @param dni El DNI del postulante.
     * @param correo El correo electrónico del postulante.
     * @param puntaje El puntaje del postulante.
     */
    public Postulante(String nombre, String apellido, String dni, String correo, double puntaje) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.puntaje = puntaje;
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
     * Establece el nombre del postulante.
     * 
     * @param nombre El nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * Establece el apellido del postulante.
     * 
     * @param apellido El apellido a establecer.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    /**
     * Devuelve el DNI del postulante.
     * 
     * @return El DNI del postulante.
     */
    public String getDni() {
        return dni;
    }
    
    /**
     * Establece el DNI del postulante.
     * 
     * @param dni El DNI a establecer.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    /**
     * Devuelve el correo electrónico del postulante.
     * 
     * @return El correo electrónico del postulante.
     */
    public String getCorreo() {
        return correo;
    }
    
    /**
     * Establece el correo electrónico del postulante.
     * 
     * @param correo El correo electrónico a establecer.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    /**
     * Devuelve el puntaje del postulante.
     * 
     * @return El puntaje del postulante.
     */
    public double getPuntaje() {
        return puntaje;
    }
    
    /**
     * Establece el puntaje del postulante.
     * 
     * @param puntaje El puntaje a establecer.
     */
    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }
    
    /**
     * Devuelve una representación en cadena del postulante.
     * 
     * @return Una cadena que representa al postulante.
     */
    @Override
    public String toString() {
        return "Postulante{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", correo='" + correo + '\'' +
                ", puntaje=" + puntaje +
                '}';
    }
}
