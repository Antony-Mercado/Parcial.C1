/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package museoo;

import java.util.*;
import java.text.*;

public class Visitantes {
    private String IdVisitante;
    private String NombreCompleto;
    private String Cedula;
    private String numeroContacto;
    private String correo;
    private String historialVisitas;
    private String descuentosMembresias;
    private String fechaNacimiento;
    private String nacionalidad;
    private String idiomaPrincipal;
    private String prefExhibiciones;
    private String fechaRegistro;
    private List<String> comprasRealizadas;
    private List<String> visitasGuiadasReservadas;
    
    private static Map<String, Visitantes> registroVisitantes = new HashMap<>();
    private static Map<String, List<Visitantes>> visitantesPorNacionalidad = new HashMap<>();
    private static Map<String, List<Visitantes>> visitantesPorMembresia = new HashMap<>();
    
    // Constructor vacío
    public Visitantes() {
        this.fechaRegistro = new Date().toString();
        this.comprasRealizadas = new ArrayList<>();
        this.visitasGuiadasReservadas = new ArrayList<>();
    }
    
    // Constructor básico
    public Visitantes(String IdVisitante, String NombreCompleto, String Cedula, 
                     String numeroContacto, String correo, String historialVisitas, 
                     String descuentosMembresias) {
        this.IdVisitante = IdVisitante;
        this.NombreCompleto = NombreCompleto;
        this.Cedula = Cedula;
        this.numeroContacto = numeroContacto;
        this.correo = correo;
        this.historialVisitas = historialVisitas;
        this.descuentosMembresias = descuentosMembresias;
        this.fechaRegistro = new Date().toString();
        this.comprasRealizadas = new ArrayList<>();
        this.visitasGuiadasReservadas = new ArrayList<>();
    }
    
    // Constructor completo
    public Visitantes(String IdVisitante, String NombreCompleto, String Cedula, 
                     String numeroContacto, String correo, String historialVisitas, 
                     String descuentosMembresias, String fechaNacimiento, 
                     String nacionalidad, String idiomaPrincipal, String prefExhibiciones) {
        this.IdVisitante = IdVisitante;
        this.NombreCompleto = NombreCompleto;
        this.Cedula = Cedula;
        this.numeroContacto = numeroContacto;
        this.correo = correo;
        this.historialVisitas = historialVisitas;
        this.descuentosMembresias = descuentosMembresias;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.idiomaPrincipal = idiomaPrincipal;
        this.prefExhibiciones = prefExhibiciones;
        this.fechaRegistro = new Date().toString();
        this.comprasRealizadas = new ArrayList<>();
        this.visitasGuiadasReservadas = new ArrayList<>();
    }
    
    // Getters y Setters
    public String getIdVisitante() {
        return IdVisitante;
    }

    public void setIdVisitante(String IdVisitante) {
        this.IdVisitante = IdVisitante;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getHistorialVisitas() {
        return historialVisitas;
    }

    public void setHistorialVisitas(String historialVisitas) {
        this.historialVisitas = historialVisitas;
    }

    public String getDescuentosMembresias() {
        return descuentosMembresias;
    }

    public void setDescuentosMembresias(String descuentosMembresias) {
        this.descuentosMembresias = descuentosMembresias;
        
        // Actualizar el mapa de visitantes por membresía
        if (this.descuentosMembresias != null && !this.descuentosMembresias.isEmpty()) {
            visitantesPorMembresia.computeIfAbsent(this.descuentosMembresias, k -> new ArrayList<>()).add(this);
        }
    }
    
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public String getNacionalidad() {
        return nacionalidad;
    }
    
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
        
        // Actualizar el mapa de visitantes por nacionalidad
        if (this.nacionalidad != null && !this.nacionalidad.isEmpty()) {
            visitantesPorNacionalidad.computeIfAbsent(this.nacionalidad, k -> new ArrayList<>()).add(this);
        }
    }
    
    public String getIdiomaPrincipal() {
        return idiomaPrincipal;
    }
    
    public void setIdiomaPrincipal(String idiomaPrincipal) {
        this.idiomaPrincipal = idiomaPrincipal;
    }
    
    public String getPrefExhibiciones() {
        return prefExhibiciones;
    }
    
    public void setPrefExhibiciones(String prefExhibiciones) {
        this.prefExhibiciones = prefExhibiciones;
    }
    
    public String getFechaRegistro() {
        return fechaRegistro;
    }
    
    public List<String> getComprasRealizadas() {
        return comprasRealizadas;
    }
    
    public List<String> getVisitasGuiadasReservadas() {
        return visitasGuiadasReservadas;
    }
    
    // Métodos de gestión de visitantes
    public void registrarVisitante() {
        registroVisitantes.put(this.IdVisitante, this);
        
        // Registrar por nacionalidad si está disponible
        if (this.nacionalidad != null && !this.nacionalidad.isEmpty()) {
            visitantesPorNacionalidad.computeIfAbsent(this.nacionalidad, k -> new ArrayList<>()).add(this);
        }
        
        // Registrar por membresía si está disponible
        if (this.descuentosMembresias != null && !this.descuentosMembresias.isEmpty()) {
            visitantesPorMembresia.computeIfAbsent(this.descuentosMembresias, k -> new ArrayList<>()).add(this);
        }
    }
    
    public static Visitantes buscarVisitante(String id) {
        return registroVisitantes.get(id);
    }
    
    public static Visitantes buscarPorCedula(String cedula) {
        for (Visitantes visitante : registroVisitantes.values()) {
            if (visitante.getCedula().equals(cedula)) {
                return visitante;
            }
        }
        return null;
    }
    
    public static List<Visitantes> buscarPorNombre(String nombre) {
        List<Visitantes> resultado = new ArrayList<>();
        for (Visitantes visitante : registroVisitantes.values()) {
            if (visitante.getNombreCompleto().toLowerCase().contains(nombre.toLowerCase())) {
                resultado.add(visitante);
            }
        }
        return resultado;
    }
    
    public void agregarVisita(String fechaVisita) {
        if (this.historialVisitas == null || this.historialVisitas.isEmpty()) {
            this.historialVisitas = fechaVisita;
        } else {
            this.historialVisitas += ", " + fechaVisita;
        }
    }
    
    public boolean tieneDescuento() {
        return descuentosMembresias != null && !descuentosMembresias.isEmpty();
    }
    
    public float calcularDescuento() {
        if (!tieneDescuento()) {
            return 0f;
        }
        
        // Lógica según tipo de membresía
        switch (descuentosMembresias.toLowerCase()) {
            case "premium":
                return 0.25f; // 25% de descuento
            case "anual":
                return 0.15f; // 15% de descuento
            case "estudiante":
                return 0.20f; // 20% de descuento
            case "tercera edad":
                return 0.30f; // 30% de descuento
            default:
                return 0.10f; // 10% por defecto para otras membresías
        }
    }
    
    public void registrarCompra(String detalleCompra) {
        comprasRealizadas.add(detalleCompra);
    }
    
    public void reservarVisitaGuiada(String codigoVisita) {
        visitasGuiadasReservadas.add(codigoVisita);
    }
    
    public void cancelarReservaVisitaGuiada(String codigoVisita) {
        visitasGuiadasReservadas.remove(codigoVisita);
    }
    
    public int calcularEdad() {
        if (fechaNacimiento == null || fechaNacimiento.isEmpty()) {
            return -1; // No se puede calcular
        }
        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaNac = sdf.parse(fechaNacimiento);
            Date ahora = new Date();
            
            long diferenciaMs = ahora.getTime() - fechaNac.getTime();
            long edadEnMillis = diferenciaMs;
            
            return (int) (edadEnMillis / (1000L * 60 * 60 * 24 * 365));
        } catch (ParseException e) {
            return -1; // Error en el formato de fecha
        }
    }
    
    public boolean esVisitanteRecurrente() {
        if (historialVisitas == null || historialVisitas.isEmpty()) {
            return false;
        }
        
        // Si tiene más de 3 visitas registradas
        return historialVisitas.split(",").length >= 3;
    }
    
    // Métodos estáticos para gestionar la colección
    public static List<Visitantes> obtenerTodosVisitantes() {
        return new ArrayList<>(registroVisitantes.values());
    }
    
    public static List<Visitantes> obtenerVisitantesPorNacionalidad(String nacionalidad) {
        return visitantesPorNacionalidad.getOrDefault(nacionalidad, new ArrayList<>());
    }
    
    public static List<Visitantes> obtenerVisitantesPorMembresia(String tipoMembresia) {
        return visitantesPorMembresia.getOrDefault(tipoMembresia, new ArrayList<>());
    }
    
    public static int contarVisitantesRecurrentes() {
        int contador = 0;
        for (Visitantes visitante : registroVisitantes.values()) {
            if (visitante.esVisitanteRecurrente()) {
                contador++;
            }
        }
        return contador;
    }
    
    public static List<Visitantes> obtenerVisitantesMenoresDeEdad() {
        List<Visitantes> menores = new ArrayList<>();
        for (Visitantes visitante : registroVisitantes.values()) {
            int edad = visitante.calcularEdad();
            if (edad >= 0 && edad < 18) {
                menores.add(visitante);
            }
        }
        return menores;
    }
    
    public static void generarReporteVisitantes() {
        System.out.println("=== REPORTE DE VISITANTES ===");
        System.out.println("Total de visitantes registrados: " + registroVisitantes.size());
        System.out.println("Visitantes recurrentes: " + contarVisitantesRecurrentes());
        System.out.println("Nacionalidades registradas: " + visitantesPorNacionalidad.size());
        System.out.println("========================");
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(IdVisitante)
          .append("\nNombre: ").append(NombreCompleto)
          .append("\nCédula: ").append(Cedula)
          .append("\nContacto: ").append(numeroContacto)
          .append("\nCorreo: ").append(correo);
        
        if (fechaNacimiento != null && !fechaNacimiento.isEmpty()) {
            sb.append("\nFecha de nacimiento: ").append(fechaNacimiento);
            int edad = calcularEdad();
            if (edad >= 0) {
                sb.append(" (").append(edad).append(" años)");
            }
        }
        
        if (nacionalidad != null && !nacionalidad.isEmpty()) {
            sb.append("\nNacionalidad: ").append(nacionalidad);
        }
        
        if (idiomaPrincipal != null && !idiomaPrincipal.isEmpty()) {
            sb.append("\nIdioma: ").append(idiomaPrincipal);
        }
        
        sb.append("\nHistorial de visitas: ").append(historialVisitas != null ? historialVisitas : "Sin visitas registradas");
        
        if (descuentosMembresias != null && !descuentosMembresias.isEmpty()) {
            sb.append("\nMembresía: ").append(descuentosMembresias)
              .append(" (").append(calcularDescuento() * 100).append("% descuento)");
        }
        
        if (!comprasRealizadas.isEmpty()) {
            sb.append("\nCompras: ").append(comprasRealizadas.size());
        }
        
        if (!visitasGuiadasReservadas.isEmpty()) {
            sb.append("\nVisitas guiadas reservadas: ").append(visitasGuiadasReservadas.size());
        }
        
        if (esVisitanteRecurrente()) {
            sb.append("\n[VISITANTE RECURRENTE]");
        }
        
        return sb.toString();
    }
}