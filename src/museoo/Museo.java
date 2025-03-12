
package museoo;

import java.util.*;


public class Museo {
    
    private GestorEmpleados gestorEmpleados;
    private GestorEntradas gestorEntradas;
    private GestorEventos gestorEventos;
    private GestorExhibiciones gestorExhibiciones;
    private GestorGuias gestorGuias;
    private GestorSalas gestorSalas;
    
    
    public Museo() {
        
        this.gestorEmpleados = new GestorEmpleados();
        this.gestorEntradas = new GestorEntradas();
        this.gestorEventos = new GestorEventos();
        this.gestorExhibiciones = new GestorExhibiciones();
        this.gestorGuias = new GestorGuias();
        this.gestorSalas = new GestorSalas();
        
        System.out.println("Sistema de Gestión del Museo inicializado correctamente.");
    }
    
    
    public GestorEmpleados getGestorEmpleados() { return gestorEmpleados; }
    public GestorEntradas getGestorEntradas() { return gestorEntradas; }
    public GestorEventos getGestorEventos() { return gestorEventos; }
    public GestorExhibiciones getGestorExhibiciones() { return gestorExhibiciones; }
    public GestorGuias getGestorGuias() { return gestorGuias; }
    public GestorSalas getGestorSalas() { return gestorSalas; }
    
    
    public void mostrarEstadisticasGenerales() {
        System.out.println("\n===== ESTADÍSTICAS GENERALES DEL MUSEO =====");
        System.out.println("Total de empleados: " + gestorEmpleados.getListaEmpleados().size());
        System.out.println("Total de entradas vendidas: " + gestorEntradas.getListaEntradas().size());
        System.out.println("Total de eventos programados: " + gestorEventos.getListaEventos().size());
        System.out.println("Total de exhibiciones activas: " + gestorExhibiciones.getListaExhibiciones().size());
        System.out.println("Total de guías disponibles: " + gestorGuias.getListaGuias().size());
        System.out.println("Total de salas: " + gestorSalas.getListaSalas().size());
    }
    
    
    public void asignarGuiaAEvento(String idGuia, String codigoEvento) {
        Guias guia = gestorGuias.buscarGuiaPorId(idGuia);
        EventosEspeciales evento = gestorEventos.buscarEventoPorCodigo(codigoEvento);
        
        if (guia != null && evento != null) {
            System.out.println("Guía " + guia.getNombreGuia() + " asignado al evento " + evento.getNombreEvento());
        } else {
            if (guia == null) {
                System.out.println("No se encontró el guía con ID: " + idGuia);
            }
            if (evento == null) {
                System.out.println("No se encontró el evento con código: " + codigoEvento);
            }
        }
    }
    
    
    public void asignarSalaAExhibicion(String idSala, String codigoExhibicion) {
        Salas sala = gestorSalas.buscarSalaPorId(idSala);
        Exhibiciones exhibicion = gestorExhibiciones.buscarExhibicionPorCodigo(codigoExhibicion);
        
        if (sala != null && exhibicion != null) {
            if (sala.getEstadoSala().equals("Disponible")) {
                System.out.println("Sala " + sala.getNombreSala() + " asignada a la exhibición " + exhibicion.getNombreExhibicion());
                gestorSalas.cambiarEstadoSala(idSala, "Ocupada");
            } else {
                System.out.println("La sala " + sala.getNombreSala() + " no está disponible.");
            }
        } else {
            if (sala == null) {
                System.out.println("No se encontró la sala con ID: " + idSala);
            }
            if (exhibicion == null) {
                System.out.println("No se encontró la exhibición con código: " + codigoExhibicion);
            }
        }
    }
    
    
    public void generarInformeDiario(String fecha) {
        System.out.println("\n===== INFORME DIARIO: " + fecha + " =====");
        
        int contadorEntradas = 0;
        double ingresoTotal = 0;
        
        for (EntradaYReservas entrada : gestorEntradas.getListaEntradas()) {
            if (entrada.getFechaHoraVisita().startsWith(fecha) && 
                !entrada.getEstadoEntrada().equals("Cancelada")) {
                contadorEntradas++;
                ingresoTotal += entrada.getPrecio();
            }
        }
        
        System.out.println("Total de visitantes: " + contadorEntradas);
        System.out.println("Ingreso total: $" + ingresoTotal);
        
        System.out.println("\nEventos del día:");
        for (EventosEspeciales evento : gestorEventos.getListaEventos()) {
            if (evento.getFechaYHora().startsWith(fecha)) {
                System.out.println("- " + evento.getNombreEvento() + " (" + evento.getUbicacionMuseo() + ")");
            }
        }
    }
    
    
    public List<Guias> buscarGuiasPorIdioma(String idioma) {
        List<Guias> guiasDisponibles = new ArrayList<>();
        
        for (Guias guia : gestorGuias.getListaGuias()) {
            if (guia.getIdiomaDomina().contains(idioma)) {
                guiasDisponibles.add(guia);
            }
        }
        
        return guiasDisponibles;
    }
    
    
    public List<Salas> buscarSalasDisponibles() {
        List<Salas> salasDisponibles = new ArrayList<>();
        
        for (Salas sala : gestorSalas.getListaSalas()) {
            if (sala.getEstadoSala().equals("Disponible")) {
                salasDisponibles.add(sala);
            }
        }
        
        return salasDisponibles;
    }
    
    
    public static void main(String[] args) {
        Museo sistema = new Museo();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        
        
        sistema.getGestorEmpleados().agregarEmpleado(new Empleados("EMP001", "Juan Pérez", "Curador", "9:00-17:00", "555-1234", "juan@museo.com"));
        sistema.getGestorEmpleados().agregarEmpleado(new Empleados("EMP002", "María López", "Recepcionista", "8:00-16:00", "555-5678", "maria@museo.com"));
        
        sistema.getGestorGuias().agregarGuia(new Guias("G001", "Carlos Rodríguez", "Español, Inglés", "Arte Moderno", "10:00-18:00"));
        sistema.getGestorGuias().agregarGuia(new Guias("G002", "Ana Gómez", "Español, Francés", "Historia Antigua", "9:00-17:00"));
        
        sistema.getGestorSalas().agregarSala(new Salas("S001", "Sala Principal", 100, "Exposición", "Disponible"));
        sistema.getGestorSalas().agregarSala(new Salas("S002", "Sala Temporal", 50, "Exposición", "Disponible"));
        
        sistema.getGestorExhibiciones().agregarExhibicion(new Exhibiciones("2 horas", "EX001", "Arte Contemporáneo", "Permanente", "Sala Principal", "2025-03-01", "Exhibición de artistas emergentes", "80"));
        
        sistema.getGestorEventos().agregarEvento(new EventosEspeciales("EV001", "Noche de Museo", "Cultural", "2025-03-15 19:00", "Sala Principal", 100, 15.99));
        
        sistema.getGestorEntradas().venderEntrada("General", "2025-03-11 10:30", "Online", "Visitante", 12.50);
        sistema.getGestorEntradas().venderEntrada("Estudiante", "2025-03-11 14:00", "Taquilla", "Estudiante", 8.75);
        
        
        while (!salir) {
            System.out.println("\n===== SISTEMA DE GESTIÓN DEL MUSEO =====");
            System.out.println("1. Gestión de Empleados");
            System.out.println("2. Gestión de Entradas y Reservas");
            System.out.println("3. Gestión de Eventos Especiales");
            System.out.println("4. Gestión de Exhibiciones");
            System.out.println("5. Gestión de Guías");
            System.out.println("6. Gestión de Salas");
            System.out.println("7. Estadísticas Generales");
            System.out.println("8. Generar Informe Diario");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = 0;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduzca un número válido.");
                continue;
            }
            
            switch (opcion) {
                case 1:
                    sistema.getGestorEmpleados().mostrarEmpleados();
                    break;
                case 2:
                    sistema.getGestorEntradas().mostrarEntradas();
                    break;
                case 3:
                    sistema.getGestorEventos().mostrarEventos();
                    break;
                case 4:
                    sistema.getGestorExhibiciones().mostrarExhibiciones();
                    break;
                case 5:
                    sistema.getGestorGuias().mostrarGuias();
                    break;
                case 6:
                    sistema.getGestorSalas().mostrarSalas();
                    break;
                case 7:
                    sistema.mostrarEstadisticasGenerales();
                    break;
                case 8:
                    sistema.generarInformeDiario("2025-03-11");
                    break;
                case 9:
                    salir = true;
                    System.out.println("Gracias por usar el Sistema de Gestión del Museo.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
        
        scanner.close();
    }
}