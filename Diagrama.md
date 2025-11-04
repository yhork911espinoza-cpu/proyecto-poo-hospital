# 📘 Diagrama UML del Sistema Hospitalario

```mermaid
classDiagram
    %% Clase Principal Hospital
    class Hospital {
        -nombreHospital: String
        -direccion: String
        -telefono: String
        -email: String
        -capacidadCamas: int
        -doctores: List<Doctor>
        -pacientes: List<Paciente>
        -farmacias: List<Farmacia>
        -departamentos: List<Departamento>
        +agregarPaciente(paciente: Paciente)
        +agregarDoctor(doctor: Doctor)
        +eliminarPaciente(idPaciente: String)
        +eliminarDoctor(idDoctor: String)
        +buscarPaciente(idPaciente: String): Paciente
        +buscarDoctor(idDoctor: String): Doctor
        +gestionarCitas()
        +generarReporteOcupacion(): Report
        +listarDoctores(): List<Doctor>
    }

    %% Clase Usuario Base
    class Usuario {
        <<abstract>>
        -idUsuario: String
        -nombre: String
        -apellido: String
        -direccion: String
        -telefono: String
        -email: String
        -fechaNacimiento: Date
        -genero: String
        +getNombre(): String
        +setNombre(nombre: String)
        +iniciarSesion()
        +cerrarSesion()
        +actualizarPerfil()
    }

    %% Gestor de Archivos
    class GestorArchivos {
        -baseDatos: String
        +guardarUsuario(usuario: Usuario)
        +leerUsuarios(tipo: String)
        +validarCredenciales(idUsuario: String): Usuario
        +validarClaveSecreta(clave: String): boolean
        +actualizarUsuario(usuario: Usuario)
        +eliminarUsuario(idUsuario: String)
        +generarBackup()
        +restaurarBackup()
    }

    %% Estado Paciente
    class EstadoPaciente {
        -estadoActual: String
        +ACTIVO: String
        +HOSPITALIZADO: String
        +ALTA: String
        +FALLECIDO: String
        +AMBULATORIO: String
        +getEstado(): String
        +setEstado(estado: String)
    }

    %% Paciente
    class Paciente {
        -numeroHistoriaClinica: String
        -grupoSanguineo: String
        -alergias: List<String>
        -fechaNacimiento: Date
        -seguroMedico: String
        -estadoPaciente: EstadoPaciente
        -doctorAsignado: Doctor
        +solicitarCita(doctor: Doctor, fecha: Date): Cita
        +verHistorial(): List<ExpedienteMedico>
        +actualizarSeguro(seguro: String)
        +agregarAlergia(alergia: String)
        +getEstado(): EstadoPaciente
    }

    %% Doctor
    class Doctor {
        -especialidad: String
        -numeroLicencia: String
        -añosExperiencia: int
        -departamento: Departamento
        -horariosDisponibles: List<Horario>
        -pacientesAsignados: List<Paciente>
        +diagnosticar(paciente: Paciente): Diagnostico
        +recetarMedicamentos(paciente: Paciente): Prescripcion
        +solicitarExamen(paciente: Paciente, tipo: String): Examen
        +actualizarExpediente(expediente: ExpedienteMedico)
        +verAgenda(): List<Cita>
        +agregarHorario(horario: Horario)
    }

    %% Enfermera
    class Enfermera {
        -departamento: String
        -turno: String
        -certificaciones: List<String>
        +administrarMedicacion(paciente: Paciente, medicamento: Medicamento)
        +tomarSignosVitales(paciente: Paciente): SignosVitales
        +registrarEvolucion(paciente: Paciente, notas: String)
        +asistirCirugia(cirugia: Cirugia)
    }

    %% Administrador
    class Administrador {
        -areaGestion: String
        -nivelAcceso: int
        +gestionarEmpleados(): List<Usuario>
        +generarReportes(): Report
        +gestionarInventario(): Inventario
        +aprobarSolicitudes(solicitud: Solicitud)
        +gestionarPresupuesto()
        +asignarRecursos()
    }

    %% Departamento
    class Departamento {
        -idDepartamento: String
        -nombreDepartamento: String
        -jefeDepartamento: Doctor
        -personal: List<Usuario>
        -ubicacion: String
        -presupuesto: double
        +agregarPersonal(usuario: Usuario)
        +removerPersonal(idUsuario: String)
        +generarReporteDepartamento(): Report
        +solicitarRecursos(recursos: List<String>)
    }

    %% Cita Médica
    class CitaMedica {
        -idCita: String
        -paciente: Paciente
        -doctor: Doctor
        -fechaHora: DateTime
        -motivo: String
        -estado: EstadoCita
        -consultorio: String
        -duracionMinutos: int
        +programarCita()
        +cancelarCita()
        +reprogramarCita(nuevaFecha: DateTime)
        +confirmarAsistencia()
        +getEstado(): EstadoCita
    }

    %% Expediente Médico
    class ExpedienteMedico {
        -idExpediente: String
        -paciente: Paciente
        -diagnosticos: List<Diagnostico>
        -prescripciones: List<Prescripcion>
        -examenes: List<Examen>
        -cirugias: List<Cirugia>
        -alergias: List<String>
        +agregarDiagnostico(diagnostico: Diagnostico)
        +agregarPrescripcion(prescripcion: Prescripcion)
        +obtenerHistorialCompleto(): String
        +exportarPDF(): File
        +buscarPorFecha(fecha: Date): List
    }

    %% Diagnóstico
    class Diagnostico {
        -idDiagnostico: String
        -fecha: Date
        -descripcion: String
        -codigoCIE10: String
        -doctor: Doctor
        -gravedad: String
        -tratamiento: String
        +actualizarDiagnostico()
        +agregarNotas(notas: String)
    }

    %% Prescripción
    class Prescripcion {
        -idPrescripcion: String
        -fecha: Date
        -medicamentos: List<MedicamentoPrescrito>
        -instrucciones: String
        -duracionDias: int
        -doctor: Doctor
        -activa: boolean
        +agregarMedicamento(medicamento: MedicamentoPrescrito)
        +suspenderPrescripcion()
        +renovarPrescripcion()
    }

    %% Medicamento Prescrito
    class MedicamentoPrescrito {
        -medicamento: Medicamento
        -dosis: String
        -frecuencia: String
        -viaAdministracion: String
        -duracion: String
        +getDosis(): String
        +getFrecuencia(): String
    }

    %% Medicamento
    class Medicamento {
        -idMedicamento: String
        -nombre: String
        -nombreGenerico: String
        -laboratorio: String
        -stock: int
        -precio: double
        -fechaVencimiento: Date
        -requiereReceta: boolean
        +verificarStock(): boolean
        +actualizarStock(cantidad: int)
        +estaVencido(): boolean
    }

    %% Farmacia
    class Farmacia {
        -nombreFarmacia: String
        -ubicacion: String
        -inventario: List<Medicamento>
        -farmaceutico: Usuario
        +agregarMedicamento(medicamento: Medicamento)
        +dispensarPrescripcion(prescripcion: Prescripcion): boolean
        +verificarStock(medicamento: Medicamento): int
        +generarOrdenCompra(): OrdenCompra
        +registrarVenta(venta: Venta)
    }

    %% Examen
    class Examen {
        -idExamen: String
        -tipo: String
        -fecha: Date
        -resultado: String
        -estadoExamen: EstadoExamen
        -laboratorista: Usuario
        -paciente: Paciente
        -doctor: Doctor
        +realizarExamen()
        +registrarResultado(resultado: String)
        +enviarResultados()
    }

    %% Cirugía
    class Cirugia {
        -idCirugia: String
        -tipoCirugia: String
        -fecha: DateTime
        -duracionEstimada: int
        -quirofano: String
        -cirujano: Doctor
        -asistentes: List<Doctor>
        -enfermeras: List<Enfermera>
        -anestesiologo: Doctor
        -estado: EstadoCirugia
        +programarCirugia()
        +cancelarCirugia()
        +registrarResultado()
    }

    %% Signos Vitales
    class SignosVitales {
        -fecha: DateTime
        -presionArterial: String
        -frecuenciaCardiaca: int
        -temperatura: double
        -saturacionOxigeno: int
        -frecuenciaRespiratoria: int
        -peso: double
        -altura: double
        +registrarSignos()
        +esNormal(): boolean
    }

    %% Horario
    class Horario {
        -diaSemana: String
        -horaInicio: Time
        -horaFin: Time
        -disponible: boolean
        +estaDisponible(): boolean
        +marcarOcupado()
    }

    %% Habitación
    class Habitacion {
        -numeroHabitacion: String
        -tipo: TipoHabitacion
        -piso: int
        -ocupada: boolean
        -pacienteActual: Paciente
        -precioDiario: double
        +asignarPaciente(paciente: Paciente)
        +liberarHabitacion()
        +estaDisponible(): boolean
    }

    %% Factura
    class Factura {
        -idFactura: String
        -paciente: Paciente
        -fecha: Date
        -conceptos: List<ConceptoFactura>
        -subtotal: double
        -impuestos: double
        -total: double
        -estadoPago: EstadoPago
        +agregarConcepto(concepto: ConceptoFactura)
        +calcularTotal(): double
        +generarPDF(): File
        +registrarPago(monto: double)
    }

    %% Concepto Factura
    class ConceptoFactura {
        -descripcion: String
        -cantidad: int
        -precioUnitario: double
        -subtotal: double
        +calcularSubtotal(): double
    }

    %% Reporte
    class Report {
        -idReporte: String
        -titulo: String
        -fecha: Date
        -contenido: String
        -tipo: String
        -generadoPor: Usuario
        +generarPDF(): File
        +generarExcel(): File
        +enviarPorEmail(destinatario: String)
        +imprimir()
    }

    %% Relaciones
    Hospital "1" --> "*" Paciente: gestiona
    Hospital "1" --> "*" Doctor: emplea
    Hospital "1" --> "*" Departamento: tiene
    Hospital "1" --> "*" Farmacia: contiene
    Hospital "1" --> "1" GestorArchivos: utiliza

    Usuario <|-- Paciente
    Usuario <|-- Doctor
    Usuario <|-- Enfermera
    Usuario <|-- Administrador

    GestorArchivos --> Usuario: gestiona
    Paciente "1" --> "*" CitaMedica
    Paciente "1" --> "1" ExpedienteMedico
    Paciente --> EstadoPaciente
    Paciente "*" --> "1" Doctor
    Paciente "1" --> "*" Factura

    Doctor "1" --> "*" CitaMedica
    Doctor "*" --> "1" Departamento
    Doctor "1" --> "*" Horario
    Doctor "1" --> "*" Prescripcion
    Doctor "1" --> "*" Diagnostico
    Doctor "1" --> "*" Cirugia

    Enfermera --> SignosVitales
    Enfermera "*" --> "*" Cirugia

    CitaMedica --> EstadoCita
    CitaMedica "1" --> "1" Doctor
    CitaMedica "1" --> "1" Paciente

    ExpedienteMedico "1" --> "*" Diagnostico
    ExpedienteMedico "1" --> "*" Prescripcion
    ExpedienteMedico "1" --> "*" Examen
    ExpedienteMedico "1" --> "*" Cirugia

    Prescripcion "1" --> "*" MedicamentoPrescrito
    MedicamentoPrescrito "*" --> "1" Medicamento

    Farmacia "1" --> "*" Medicamento
    Farmacia --> Prescripcion

    Examen --> EstadoExamen
    Examen "*" --> "1" Paciente
    Examen "*" --> "1" Doctor

    Cirugia --> EstadoCirugia
    Cirugia "*" --> "1" Paciente

    Departamento "1" --> "*" Usuario

    Habitacion --> TipoHabitacion
    Habitacion "0..1" --> "1" Paciente

    Factura "1" --> "*" ConceptoFactura
    Factura --> EstadoPago
    Factura "*" --> "1" Paciente

    Hospital "1" --> "*" Report
    Administrador "1" --> "*" Report
    Departamento "1" --> "*" Report
