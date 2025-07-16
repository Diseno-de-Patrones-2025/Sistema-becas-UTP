package controlador;

import java.util.ArrayList;
import modelo.Documentacion;
import java.util.List;
import modelo.Postulante;

/**
 * La clase GestorDocumentos se encarga de gestionar la documentación asociada a los postulantes
 * en el sistema de becas.
 */
public class GestorDocumentos {
    private List<Documentacion> documentaciones;

    public GestorDocumentos() {
        this.documentaciones = new ArrayList<>();
    }
    
    // Verifica si un postulante tiene documentos registrados
    public boolean tieneDocumentos(String nombrePostulante) {
        if (documentaciones == null || documentaciones.isEmpty()) {
            return false;
        }
        for (Documentacion documentacion : documentaciones) {
            if (documentacion != null && documentacion.getPostulante() != null) {
                if (documentacion.getPostulante().getNombre().equals(nombrePostulante)) {
                    return documentacion.getDocumentos() != null && !documentacion.getDocumentos().isEmpty();
                }
            }
        }
        return false;
    }
    
    public void agregarDocumentacion(Documentacion documentacion) {
        documentaciones.add(documentacion);
        System.out.println("Documentación registrada para " + documentacion.getPostulante().getNombre());
    }
    
    public void mostrarDocumentos(String nombrePostulante) {
        boolean tieneDocumentos = false;
        if (documentaciones == null || documentaciones.isEmpty()) {
            System.out.println("No hay documentaciones registradas.");
            return;
        }
        for (Documentacion documentacion : documentaciones) {
            if (documentacion != null && documentacion.getPostulante() != null) {
                if (documentacion.getPostulante().getNombre().equals(nombrePostulante)) {
                    tieneDocumentos = true;
                    if (documentacion.getDocumentos() == null || documentacion.getDocumentos().isEmpty()) {
                        System.out.println("El postulante " + nombrePostulante + " no tiene documentos registrados.");
                    } else {
                        System.out.println("Documentos de " + documentacion.getPostulante().getNombre() + ":");
                        for (String documento : documentacion.getDocumentos()) {
                            System.out.println("- " + documento);
                        }
                    }
                    break;
                }
            }
        }
        if (!tieneDocumentos) {
            System.out.println("Postulante no encontrado.");
        }
    }
}
