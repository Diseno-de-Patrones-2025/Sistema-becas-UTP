package controlador;

import Adapter.ABBAdapter;
import Factory.PostulanteFactory;
import modelo.ABB;
import modelo.Postulante;

public class GestorPostulantes {
    private ABB arbolPostulantes;
    private final PostulanteFactory postulanteFactory;
    
    public GestorPostulantes() {
        arbolPostulantes = new ABB();
        postulanteFactory = new PostulanteFactory();
    }

    // Método para obtener un iterable de postulantes
    public Iterable<Postulante> obtenerPostulantes() {
        return new ABBAdapter(arbolPostulantes);
    }

    // Registra un nuevo postulante
    public void registrarPostulante(String nombre, String apellido, String dni, String correo) {
        Postulante postulante = postulanteFactory.crearPostulante(nombre, apellido, dni, correo);
        arbolPostulantes.insertar(postulante);
    }
    
    // Muestra todos los postulantes registrados
    public void mostrarPostulantes() {
        System.out.println("Postulantes registrados (en orden alfabético):");
        for (Postulante p : obtenerPostulantes()) {
            System.out.println(p.getNombre() + " " + p.getApellido() + " - Puntaje: " + p.getPuntaje());
        }
    }
    
    // Busca un postulante por nombre
    public void buscarPostulante(String nombre) {
        Postulante postulante = arbolPostulantes.buscar(nombre);
        if (postulante != null) {
            System.out.println("Postulante encontrado:");
            System.out.println("Nombre: " + postulante.getNombre());
            System.out.println("Apellido: " + postulante.getApellido());
            System.out.println("DNI: " + postulante.getDni());
            System.out.println("Correo: " + postulante.getCorreo());
            System.out.println("Puntaje: " + postulante.getPuntaje());
        } else {
            System.out.println("Postulante no encontrado.");
        }
    }

    // Verifica si existe un postulante por nombre
    public boolean existePostulante(String nombre) {
        return arbolPostulantes.buscar(nombre) != null;
    }

    // Asigna puntaje a un postulante existente
    public boolean asignarPuntaje(String nombre, double puntaje) {
        Postulante postulante = arbolPostulantes.buscar(nombre);
        if (postulante != null) {
            postulante.setPuntaje(puntaje);
            return true;
        }
        return false;
    }
    
    /**
     * Obtiene el árbol binario de búsqueda que contiene los postulantes.
     * Método agregado para soporte del GeneradorReportes.
     * 
     * @return El ABB con todos los postulantes registrados
     */
    public ABB getAbb() {
        return arbolPostulantes;
    }
}
