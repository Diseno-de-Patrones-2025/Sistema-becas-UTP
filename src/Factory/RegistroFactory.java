
package Factory;
import modelo.Postulante;
import modelo.Solicitud;
import java.util.Scanner;

/**
 *
 * @author rivmi
 */
public class RegistroFactory {
    /**
     * Crea un nuevo objeto Postulante, validando el formato del correo.
     * 
     * @param nombre
     * @param apellido
     * @param correo
     * 
     * @return
     */
    public static Postulante crearPostulante(String nombre, String apellido, String correo) {
        Scanner scan=new Scanner(System.in);
        while(true){
            try{
                if (!correoValido(correo))
                    throw new IllegalArgumentException("Correo invalido: " + correo);
                return new Postulante(nombre, apellido, correo);
            }catch(IllegalArgumentException e){
                System.out.println("Error: " +e.getMessage());
                System.out.println("Ingrese un correo valido: ");
                correo=scan.nextLine();
            }
        }
    }

    /**
     * 
     * @param postulante
     * 
     * @return
     */
    public static Solicitud crearSolicitud(Postulante postulante) {
       return new Solicitud(postulante);
    }

    /**
     * Verifica si el correo ingresado tiene un formato válido.
     */
    private static boolean correoValido(String correo) {
        return correo != null && correo.contains("@") && correo.contains(".");
    }
}
