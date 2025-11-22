
public class Main {

    public static void imprimirCentrado(String texto) {
        int ancho = 80; // ancho aproximado de consola
        int espacios = (ancho - texto.length()) / 2;

        if (espacios > 0) {
            System.out.println(" ".repeat(espacios) + texto);
        } else {
            System.out.println(texto);
        }
    }

    //---------------------------------------------------------------------------
    //---------------------------------------------------------------------------
    public static void main(String[] args) {
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
        imprimirCentrado(separacion);
        
        imprimirCentrado(hospital1.getNombreHospital());

        imprimirCentrado(separacion);
        //--------   FINAL DEL HOSPITAL  -------------------------
        //------------------------------------------------------------------------------------------
    }
}
