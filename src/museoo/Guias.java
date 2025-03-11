/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package museoo;

import java.util.*;

public class Guias {
    private String idGuia;
    private String nombreGuia;
    private String idiomaDomina;
    private String especialidad;
    private String horarioDisponibilidad;
    
    public Guias(String idGuia, String nombreGuia, String idiomaDomina, String especialidad, String horarioDisponibilidad) {
        this.idGuia = idGuia;
        this.nombreGuia = nombreGuia;
        this.idiomaDomina = idiomaDomina;
        this.especialidad = especialidad;
        this.horarioDisponibilidad = horarioDisponibilidad;
    }
    
    // Getters
    public String getIdGuia() { return idGuia; }
    public String getNombreGuia() { return nombreGuia; }
    public String getIdiomaDomina() { return idiomaDomina; }
    public String getEspecialidad() { return especialidad; }
    public String getHorarioDisponibilidad() { return horarioDisponibilidad; }
    
    // Setters
    public void setIdGuia(String idGuia) { this.idGuia = idGuia; }
    public void setNombreGuia(String nombreGuia) { this.nombreGuia = nombreGuia; }
    public void setIdiomaDomina(String idiomaDomina) { this.idiomaDomina = idiomaDomina; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public void setHorarioDisponibilidad(String horarioDisponibilidad) { this.horarioDisponibilidad = horarioDisponibilidad; }
    
    @Override
    public String toString() {
        return "ID: " + idGuia + 
               "\nNombre: " + nombreGuia + 
               "\nIdioma: " + idiomaDomina + 
               "\nEspecialidad: " + especialidad + 
               "\nHorario: " + horarioDisponibilidad;
    }
}

// Gestor de Guias
class GestorGuias {
    private List<Guias> listaGuias;
    
    public GestorGuias() {
        listaGuias = new ArrayList<>();
    }
    
    public void agregarGuia(Guias guia) {
        listaGuias.add(guia);
        System.out.println("Guía agregado: " + guia.getNombreGuia());
    }
    
    public Guias buscarGuiaPorId(String id) {
        for (Guias guia : listaGuias) {
            if (guia.getIdGuia().equals(id)) {
                return guia;
            }
        }
        return null;
    }
    
    public void mostrarGuias() {
        System.out.println("\n===== LISTA DE GUÍAS =====");
        if (listaGuias.isEmpty()) {
            System.out.println("No hay guías registrados.");
        } else {
            for (Guias guia : listaGuias) {
                System.out.println("\n" + guia);
                System.out.println("---------------------");
            }
        }
    }
    
    public void eliminarGuia(String id) {
        Guias guia = buscarGuiaPorId(id);
        if (guia != null) {
            listaGuias.remove(guia);
            System.out.println("Guía eliminado: " + guia.getNombreGuia());
        } else {
            System.out.println("No se encontró ningún guía con ID: " + id);
        }
    }
    
    public List<Guias> getListaGuias() {
        return listaGuias;
    }
}
