
package aed_formulario_proyectofinal;
import java.util.Scanner;

public class Formulario {
        /**
         * 
         */
    public static void main (String[] args){
        Scanner scan=new Scanner(System.in);
        int a,b,c;
        System.out.println("Ingrese número a: ");
        a=scan.nextInt();
        System.out.println("Ingrese número b: ");
        b=scan.nextInt();
        c=a+b;
        System.out.println("Resultado: \n"+c);

    }
}
