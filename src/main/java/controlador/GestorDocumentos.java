package controlador;

import java.util.ArrayList;
import modelo.Documentacion;
import java.util.List;
import java.util.Scanner;
import modelo.Postulante;

/**
 * La clase GestorDocumentos se encarga de gestionar la documentación asociada a los postulantes
 * en el sistema de becas. Permite agregar, mostrar y verificar la documentación de los postulantes.
 */

public class GestorDocumentos {
    private List<Documentacion> documentaciones; //Lista de documentos de postulantes

    /**
     * Constructor que inicializa la lista de documentaciones de postulantes.
     * Inicialmente la lista está vacía.
     */
    
    public GestorDocumentos() {
        this.documentaciones=new ArrayList<>();
    }
    
    /**
     * Agrega la documentación de un postulante al sistema.
     * 
     * @param documentacion El objeto Documentacion que contiene los datos de los documentos del postulante.
     */
    
    public void agregarDocumentacion(Documentacion documentacion) {
        documentaciones.add(documentacion);
        System.out.println("Documentación registrada para " + documentacion.getPostulante().getNombre());
    }
    
    /**
     * Muestra los documentos registrados de un postulante específico.
     * 
     * @param nombrePostulante El nombre del postulante cuyos documentos se desean mostrar.
     */
    
    public void mostrarDocumentos(String nombrePostulante) {
        boolean tieneDocumentos = false;  //Identifica si se encuentra al postulante
        // Verificar si la lista de documentaciones está vacía o es null
        if (documentaciones == null || documentaciones.isEmpty()) {
            System.out.println("No hay documentaciones registradas.");
            return;  // Salir del método si la lista está vacía o es null
        }
        //Recorre la lista de documentaciones para buscar al postulante
        for (Documentacion documentacion : documentaciones) {
            //Verifica que la documentacion y el postulante no sean null
            if (documentacion != null && documentacion.getPostulante() != null) {
                //Si se encuentra el postulante
                if (documentacion.getPostulante().getNombre().equals(nombrePostulante)) {
                    tieneDocumentos = true;
                    //Verifica si el postulante tiene documentos
                    if (documentacion.getDocumentos() == null || documentacion.getDocumentos().isEmpty()) {
                    //Si no tiene documentos, muestra un mensaje
                        System.out.println("El postulante " + nombrePostulante + " no tiene documentos registrados.");
                    } else {
                        //Si tiene documentos, los muestra
                        System.out.println("Documentos de " + documentacion.getPostulante().getNombre() + ":");
                        for (String documento : documentacion.getDocumentos()) {
                            System.out.println("- " + documento);
                        }
                    }
                    break;  //Termina el ciclo después de encontrar el postulante
                }
            }
        }
        //Si no se encuentra al postulante en la lista
        if (!tieneDocumentos) {
            System.out.println("Postulante no encontrado.");
        }
    }
    
    /**
     * Este método está defectuoso y no se recomienda su uso, ya que puede presentar errores
     * debido a la implementación de la verificación de documentación.
     * <p>
     * Actualmente, la verificación de la documentación se gestiona de forma diferente.
     * Se ha comentado este método para evitar problemas y mantener la compatibilidad con el sistema.
     * </p>
     * 
     * @deprecated Este método está defectuoso y no se recomienda su uso. 
     */
    
    /*public void comprobarDocumentacion() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el correo del postulante: ");
        String correo = sc.nextLine();

        Documentacion doc = documentos.get(correo);
        if (doc != null && doc.isVerificada()) {
            System.out.println("La documentación está verificada.");
        } else {
            System.out.println("La documentación no está verificada.");
        }
    }*/
}

