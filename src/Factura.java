
import java.io.File;
import java.time.LocalDate;

public class Factura {
    private String idFactura;
    private Paciente paciente;
    private LocalDate fecha;
    private List<ConceptoFactura> conceptos;
    private double subTotal;
    private double impuestos;
    private double total;
    private EstadoPago estadoPago;


    public void agregarConcepto(ConceptoFactura cancepto){}
    //public double calcularTotal(){}
    //public double calcularTotal(){}
    //public File generarPDF(){}
    public void registrarPago(double monto){}
}
