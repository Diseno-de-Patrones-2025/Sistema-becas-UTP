package vista;

import controlador.GestorDocumentos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Postulante;
import modelo.Documentacion;

/**
 * Interfaz de usuario para registrar documentación
 */
public class RegistroDocumentosUI {
    private final GestorDocumentos gestorDocumentaciones;

    public RegistroDocumentosUI(GestorDocumentos gestorDocumentaciones) {
        this.gestorDocumentaciones = gestorDocumentaciones;
    }
    
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del postulante: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el apellido del postulante: ");
        String apellido = sc.nextLine();
        System.out.print("Ingrese el DNI del postulante: ");
        String dni = sc.nextLine();
        System.out.print("Ingrese el correo del postulante: ");
        String correo = sc.nextLine();
        
        Postulante postulante = new Postulante(nombre, apellido, dni, correo);
        
        System.out.println("Cuantos documentos requiere ingresar?");
        int num_doc = sc.nextInt();
        sc.nextLine();
        
        List<String> documentos = new ArrayList<>();
        System.out.println("Ingrese los documentos:");
        for(int i = 0; i < num_doc; i++){
            System.out.println("Documento N°" + (i + 1) + ": ");
            String doc = sc.nextLine();
            documentos.add(doc);
        }
        
        Documentacion documentacion = new Documentacion(postulante, documentos);
        gestorDocumentaciones.agregarDocumentacion(documentacion);
        System.out.println("Documentación registrada exitosamente.");
    }
}
