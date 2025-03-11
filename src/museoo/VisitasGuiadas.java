/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package museoo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VisitasGuiadas {
    // Attributes
    private String codigoVisita;
    private String exhibicionSalas;
    private String guiaAsignado;
    private int numeroMaximoPermitidos;
    private LocalDateTime fechaHoraVisita;
    private int duracionMinutos;
    
    // Default constructor
    public VisitasGuiadas() {
    }
    
    // Parameterized constructor
    public VisitasGuiadas(String codigoVisita, String exhibicionSalas, String guiaAsignado, 
                          int numeroMaximoPermitidos, LocalDateTime fechaHoraVisita, int duracionMinutos) {
        this.codigoVisita = codigoVisita;
        this.exhibicionSalas = exhibicionSalas;
        this.guiaAsignado = guiaAsignado;
        this.numeroMaximoPermitidos = numeroMaximoPermitidos;
        this.fechaHoraVisita = fechaHoraVisita;
        this.duracionMinutos = duracionMinutos;
    }
    
    // Getters and Setters
    public String getCodigoVisita() {
        return codigoVisita;
    }

    public void setCodigoVisita(String codigoVisita) {
        this.codigoVisita = codigoVisita;
    }

    public String getExhibicionSalas() {
        return exhibicionSalas;
    }

    public void setExhibicionSalas(String exhibicionSalas) {
        this.exhibicionSalas = exhibicionSalas;
    }

    public String getGuiaAsignado() {
        return guiaAsignado;
    }

    public void setGuiaAsignado(String guiaAsignado) {
        this.guiaAsignado = guiaAsignado;
    }

    public int getNumeroMaximoPermitidos() {
        return numeroMaximoPermitidos;
    }

    public void setNumeroMaximoPermitidos(int numeroMaximoPermitidos) {
        this.numeroMaximoPermitidos = numeroMaximoPermitidos;
    }

    public LocalDateTime getFechaHoraVisita() {
        return fechaHoraVisita;
    }

    public void setFechaHoraVisita(LocalDateTime fechaHoraVisita) {
        this.fechaHoraVisita = fechaHoraVisita;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }
    
    // Utility methods
    public String obtenerHoraFin() {
        LocalDateTime horaFin = fechaHoraVisita.plusMinutes(duracionMinutos);
        return horaFin.format(DateTimeFormatter.ofPattern("HH:mm"));
    }
    
    public boolean estaDisponible(LocalDateTime fechaHoraConsulta) {
        LocalDateTime finVisita = fechaHoraVisita.plusMinutes(duracionMinutos);
        return fechaHoraConsulta.isBefore(fechaHoraVisita) || fechaHoraConsulta.isAfter(finVisita);
    }
    
    public String obtenerInformacionVisita() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "Visita guiada: " + codigoVisita + 
               "\nExhibición/Salas: " + exhibicionSalas + 
               "\nGuía: " + guiaAsignado + 
               "\nCapacidad máxima: " + numeroMaximoPermitidos + " personas" +
               "\nFecha y hora: " + fechaHoraVisita.format(formatter) + 
               "\nDuración: " + duracionMinutos + " minutos";
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "VisitasGuiadas{" + 
               "codigoVisita='" + codigoVisita + '\'' + 
               ", exhibicionSalas='" + exhibicionSalas + '\'' + 
               ", guiaAsignado='" + guiaAsignado + '\'' + 
               ", numeroMaximoPermitidos=" + numeroMaximoPermitidos + 
               ", fechaHoraVisita=" + (fechaHoraVisita != null ? fechaHoraVisita.format(formatter) : "no establecida") + 
               ", duracionMinutos=" + duracionMinutos + 
               '}';
    }
}
