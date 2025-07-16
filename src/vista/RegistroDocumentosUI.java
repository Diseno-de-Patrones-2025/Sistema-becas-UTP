
package vista;

import controlador.GestorDocumentos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Postulante;
import modelo.Documentacion;

/**
 * La clase RegistroDocumentosUI es responsable de interactuar con el usuario
 * para registrar la documentación de un postulante en el sistema de becas.
 * 
 * Esta clase permite ingresar los datos del postulante, así como los documentos
 * asociados a su solicitud. Los datos se almacenan a través del gestor de documentos.
 */

public class RegistroDocumentosUI {
    private final GestorDocumentos gestorDocumentaciones;

    /**
     * Constructor de la clase RegistroDocumentosUI.
     * 
     * @param gestorDocumentaciones El objeto gestor de documentos que se encarga
     *                              de registrar y gestionar la documentación
     *                              de los postulantes en el sistema.
     */
    
    public RegistroDocumentosUI(GestorDocumentos gestorDocumentaciones) {
        this.gestorDocumentaciones=gestorDocumentaciones;
    }
    
    /**
     * Método que muestra el menú para registrar la documentación de un postulante.
     * Este método solicita al usuario que ingrese los datos del postulante y los documentos,
     * y luego utiliza el gestor de documentos para almacenar la información en el sistema.
     */
    
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del postulante: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el apellido del postulante: ");
        String apellido = sc.nextLine();
        System.out.print("Ingrese el correo del postulante: ");
        String correo = sc.nextLine();
        
        //Crea un objeto Postulante con los datos ingresados
        Postulante postulante = new Postulante(nombre, apellido, correo);
        
        //Solicita el número de documentos que se van a ingresar
        System.out.println("Cuantos documentos requiere ingresar?");
        int num_doc=sc.nextInt();
        sc.nextLine(); //Consumir el salto de línea restante
        
        //Lista que almacena los documentos
        List<String> documentos = new ArrayList<>();
        System.out.println("Ingrese los documentos:");
        for(int i=0;i<num_doc;i++){
            System.out.println("Documento N"+i+": ");
            String doc=sc.nextLine(); //Lee cada documento ingresado
            documentos.add(doc); //Agrega cada documento a la lista
        }
        
        //Crea un objeto Documentacion con el postulante y la lista de documentos
        Documentacion documentacion = new Documentacion (postulante,documentos);
        
        //Llama al gestor para agregar la documentación al sistema
        gestorDocumentaciones.agregarDocumentacion(documentacion);
        
        System.out.println("Documentación registrada exitosamente.");
    }
}
