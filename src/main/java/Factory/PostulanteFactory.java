package Factory;

import modelo.Postulante;

/**
 * Factory concreto para la creación de objetos Postulante
 */
public class PostulanteFactory implements EntidadFactory<Postulante> {
    @Override
    public Postulante crearEntidad() {
        return new Postulante();
    }
    
    public Postulante crearPostulante(String nombre, String apellido, String dni, String correo) {
        return new Postulante(nombre, apellido, dni, correo);
    }
    
    public Postulante crearPostulanteConPuntaje(String nombre, String apellido, String dni, String correo, double puntaje) {
        return new Postulante(nombre, apellido, dni, correo, puntaje);
    }
}
