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

Link del diagrama eb Mermaid:
https://mermaid.live/edit#pako:eNq1W-tu2zgWfhXBwADKTlwkbdJ2jKKA6zhtgLQJmrQ_BvlDS7TDGVnUUpLRTrd5p8U-wrzYHt4kXo4UZ4HND1ciD2_n-p1D9cck4zmdzCZZQer6jJGNINu7MoG_X35JFtBIk2vByoxVpEg-8LpiDSk0gRrStSU_dKv8m5Z8uxLUds2Smwbm2DgEORM0yxgvkb6GFnTNS4500S1h2HQZqUjGcpIvyJbUs4SVjbsYzxouKLRfsrp5OFOvDw6BHEzLpqO4Nu8uzZqILTQTS3Nu3l2anFZENGQLY3m3mtPm0P4KnKYbIuxSqd3DLLFNBzG13nqqDzRL9KtLRwu2ZaUzLcuvu4k12zByMy_Lz8zMMemqrbPxefudR8OG5rdHcAZsaN2AXhCxANWp0wOvq6SCiM-04qKhV1krecbLFKbRbQ5tAby369JaksSy_3lXBqr-pW6JYDx5By-uktt2R8ffvCGruhEka96-dVSA5YYW0VJtFUgHqWhRsJz__w1lTbN78gnYtpWCgpFnxBXXVLEYmRB433xS25esjHrrrtc_oys9VjIwF3FDayUzpyejQqAdwNyWFOwv0Dsq1qywna7g3oO-cJHkNJmL7J7teJ18T-ZtA8djGRz07_-UriQ1eUfqOq0VCB3YIS03Pj7INCfCyDZtrYxNg7vpglJLV6cNqzjGjB0cC-ZbCJpTcK6kAB2NVOegmx8ZWZAdvaGZoA1JM_nijFpxXlBSopzc5wjWLVjaeGexVb4j2Z9t5YkPDK8hbdQXm90S6HIeuA8tL91lezx5UdU1VydDRDZf3F58vUI6PlzdXF_czi8vfp-fYf3zy9s50nw-v7xcLi7wIR_ffbmc3159vrjCbUcfY8h2TK8-UMDjmFsYm1AGle0WjPkDkxrPyKKQFkgQp7ARbcVvSLlpWUkxbwLqKTZ96NP9D09wKzXdtIJ_pDnLUG_lCXkWCD2K5POabUrFqSh61LwAL9Po6BHEycNEbVNvDiQhSVzDosKyqujixfJbBZuWu9Cbf0Bt6kYdL9WnxGzEhO-55mNq-Ilbk6MrGB-UPkQ64TJCa4RuCQymotLXSKCEhSelLpcsUx4JU4O__81ryRHBDEmAsxyoA1x23hyiey6UazxjdcVLtio61PVB96DAzIp8BKH9mgN6LXkt3b7A4BRsqaPgnpvKwIkKJWCD3fDh1-DQMsEqGY4xnVt-k8ORsYeJFwdAsIoS1aVe41LaPcoRviIe-Jo7By-ck05tpWojYNNwODUymCWmYdgxl2sqQCuI55Jto6dcvvBjrNIKFKhA7G_YWkVqXtJBD_MrySEiMQm4jKAU8sNYve3lOEscoboca_gWrJZJZfgqMxQ6IHGPxFOZjd7LcseLdnArJW9IjfqDGoYzcFKilf4g0_9Kl6QeBuUx77iQ-9budXhyIYKS9xpTYzbPdrSYZxmteWDNPRBfbitAE2B7nXoZNPAwiM1rFJN3M16UO2CQUkWg699cDlWCr0BG2rbaHKas7TOcwz4eYNNLO22rViK9NOA6OBHYY9aKmtfDeCR2XcanOu0ekyGxGVd_DYsfIfqDrgOSML5NwffWcMRiUBDTdmWMA1mg6hkzS3LegvNFMlKzxChCFHTLwe10tPsgRKMb7glRNen8aScoYR587zAoPun9jOW70pPNujWQnezAuBVZdIREEAkpjCH9qsYZt2zrDtvyBvKOQQhkQ74PTaYZL-u2kNAETREBYkuBf2Rlq7IX347BkGRRx0AiL-8iZUYLpENQf1DZ0h0578GTPJQ3ES_XTAD1XPo1hQ3SR0BNf0Ic0PTxTkvSs8MwGAbyXDpx84lS7QFCV7_pmx4CU7JYoK8bOY0uMVXhviPT0d8lMAGg7sK3en14AgTvKkT9dlPnNB72QZCpu_PUPZuPetyRfNVIu-4w84LLONHgSQ5AGTByWOfsXPafsyIuEl1zoXQs9WG6PO-gow4BnfHTfXPopl2W4NWRKHnJXW7EAIbnbMMXF8vjI8w2h9wEWNeO4jgcgji4R4YHCQcpuqJGRPpJgo8UgyBIShkhW5NWOu0BJ6_FKFtwVjrYzGqyg9DMlF6ddMpKQDVtZu1s0PudsaHCL8J9YCLbEbRQopnn7CodApTddl3m1y0kWWVOfYvynWvJdwTtjwXjLJd067kSwvbjSWpo9x6bwG1jMpRxdygZ3DHSg84BJbCywWsiZ3JZ1FtA53m3dkgxyqQB1gS6-9Hlyf5lWt3xXno93H8UZAWBfyhOg5_M_gxVFHxtxhA0pg3oq-TAQE1F0H-2jAr6WaWvmC4DQFOplbiRK6ePFAY1EWCCRtcHYJ9eTRDCttqOjuLeTLFI7O2IKw_bhtwU2S6Ea2N4lnWZQ-xM4rsb2mq3H9dUn2D0B17BQdp6vX_03ENIg-vG6ZkC1Vcip6UMvUIZivOKpatfJbtSxbRZol6GU3-nRGFRl2yJsJZsxKKYU_F4NC7IvKRwi58RMrbrLJ031PJqebRIxP8bmAfG2aKMquwcYDz9bPeeRqfw7KcEj9kT-9knksIoBOinL6opyl1M6QAVwHDv2kfziNMGTrMtyaMqH3gdwdcEr-bAen-orjjk6tSgGbmGpbaw1AFl2-AhYcABjbwrKvgGWyjMpBxGhvmQrr7gKVHch0h8VIa6eJR41SMtSq-s5Al0WCzSrYBU5pBBS7Q9Gq4XRAD2zyLRNXRbATebVmanUcSpVYcU_dU3Bu4lrAg5CwAHKqbtLVqkUrWkaHZS4Mv2bNVcSf2g84mD6y72iDimlOl_miDCW1uZ4d3QLSkxm5Bl0Qt5Swn7D7gvu85ZGbXnXRUb8-1SFfs6Nx6AQRHB-avL7ECh_OORFahLiM_7Vuzip-scdM-38BvOrIXIooLglKs9Ykij8672Mg7xsRroAEoXDC0-6drcnp9DFGwlg1-_9fRgf7bj1noukZAIAItqCjyuaX1qaQEPfBkHf1P12dDCvJtFXL9Xt6uGq69pIttiW13Uq5G-oTH2zm3D-3umDQKK7I5Su9VZEmzS959F1oL_vJWrSs5Hgja4BS8EdL5A7iXd8rIvVI6HS7MjTIrBboNLi9HU3sXCkSp_KVmDK_OIqDoG3RiSkEex5bv1UX0i3RKopamuoqbetMX-WAzkDHEa_xplANRpmYIGSRAVw-tRkZvO5TeIu0i3hk0w8VJ-0ZLmssZfkmao1AyWICBhEpgj_QyBXZcRdFP35drd5Phukkynb-HpH_DUX0TbK4VHBtivmqi6KXmM2KvwN7ASfWREnx1J2TwyQD75H7nMEkh8JIzVo_Sv_aLpzb-mU-fA95BQ5gQhsUccJOiw2giNd0vl0-nf4OsceaLuXsGXhf7tPnsIWdbX-meJvU8YGSKfwqKyJ5tulKRfBp8rYHR6G_3sln_EXGQn5JETdGFGOpsVdU9trvbHzkzknnIa0Adb8hQRgKGs52Z0dI0P9ubYOfMAqV8gpFvWjNN7pVmTeD1yXpPceMT6t7-jlvQe3pb0OsqEpC6DvAV07uLO79wl9Rqh75EczjhUobZZfcgs7Bqh7TUNBOYfM7wIGWWq7z0eHesL8ImDbb7Oyqxov-87yhGpKyJjKm4xOhyJ1UHDTaO10tAqvNqgoKAbKuNxN9IVskY2AUpTyJqT9VfdGEntc9aWkXzBqlpLr1uWn54MFE14AExbBkitEloPCW6psrm01UpddHCV3IjI03NNtc9WjEm7N-khGzuX7yxhIl6f70hyP30BJ1OrD20i2rvJ0bNnQzal0hpfvBooRsrpA8lQu-wwN0Js_EP0M-_Lp0FMoOGejIpl93mO_xHI0IhMWIgyKgRLXgmetxmdHE42guWTWSNaejgBfwl4DF4nCoXeTZp7ConxZAaPOV2TtmjuJnflTxhWkfJ3zrd2pODt5n4yW5Oihre2ygF9mv930JGoC5QFb8tmMnt1fKTmmMx-TL5NZtOTV789e_Hy9cnL01dHp6fHxy9PDyffof350dFvz56_Pjl5fnL6-vjF6Yufh5O_1Lovnr16eXxydHJ0dHxy-vzFyfHLn_8FBFhm5w
