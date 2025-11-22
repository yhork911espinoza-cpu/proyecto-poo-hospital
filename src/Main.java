
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        Hospital hospital1 = new Hospital(
                "Hospital San Martín",
                "Av. Los Próceres 145, Arequipa",
                "054-789456",
                "contacto@sanmartin.pe",
                250
        );//Creamos un obejto Hospital
        String separacion = "===========================================================================";

        //------------------------------------------------------------------------------------------
        //--------   INICIO DEL HOSPITAL -----------------------
        boolean comprobarMenuPrincipal = true;
        do {
            System.out.println(separacion);

            System.out.println(hospital1.getNombreHospital());
            System.out.println("1.- Iniciar sesión");
            System.out.println("2.- Registrarse (solo pacientes)");
            System.out.println("3.- Salir\n");
            System.out.print("Ingrese una opcion: ");
            int opcionInicio = lector.nextInt();
                if(opcionInicio==1){
                    System.out.println("Iniciar sesion:");
                }
                if(opcionInicio==2){
                    System.out.println("Registrar");
                }
                if(opcionInicio ==3){
                    System.out.println("Saliendo del Hospital");
                    comprobarMenuPrincipal = false;
                }

            System.out.println(separacion);
        } while (comprobarMenuPrincipal);
        //--------   FINAL DEL HOSPITAL  -------------------------
        //------------------------------------------------------------------------------------------
    }
}
