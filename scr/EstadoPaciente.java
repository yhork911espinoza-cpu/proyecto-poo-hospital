public enum EstadoPaciente {
    ACTIVO("Activo (En tratamiento)"),
    HOSPITALIZADO("Hospitalizado (Requiere cama)"),
    ALTA("Dado de Alta"),
    FALLECIDO("Fallecido"),
    AMBULATORIO("Ambulatorio (Consulta externa)");

    private final String descripcion;

    EstadoPaciente(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
