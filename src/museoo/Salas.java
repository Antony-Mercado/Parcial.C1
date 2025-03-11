/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package museoo;

import java.util.*;

public class Salas {
    private String idSala;
    private String nombreSala;
    private int capacidadMaxima;
    private String tipoSala;
    private String estadoSala;
    
    public Salas(String idSala, String nombreSala, int capacidadMaxima, String tipoSala, String estadoSala) {
        this.idSala = idSala;
        this.nombreSala = nombreSala;
        this.capacidadMaxima = capacidadMaxima;
        this.tipoSala = tipoSala;
        this.estadoSala = estadoSala;
    }
    
    // Getters
    public String getIdSala() { return idSala; }
    public String getNombreSala() { return nombreSala; }
    public int getCapacidadMaxima() { return capacidadMaxima; }
    public String getTipoSala() { return tipoSala; }
    public String getEstadoSala() { return estadoSala; }
    
    // Setters
    public void setIdSala(String idSala) { this.idSala = idSala; }
    public void setNombreSala(String nombreSala) { this.nombreSala = nombreSala; }
    public void setCapacidadMaxima(int capacidadMaxima) { this.capacidadMaxima = capacidadMaxima; }
    public void setTipoSala(String tipoSala) { this.tipoSala = tipoSala; }
    public void setEstadoSala(String estadoSala) { this.estadoSala = estadoSala; }
    
    @Override
    public String toString() {
        return "ID: " + idSala + 
               "\nNombre: " + nombreSala + 
               "\nCapacidad: " + capacidadMaxima + " personas" +
               "\nTipo: " + tipoSala + 
               "\nEstado: " + estadoSala;
    }
}

// Gestor de Salas
class GestorSalas {
    private List<Salas> listaSalas;
    
    public GestorSalas() {
        listaSalas = new ArrayList<>();
    }
    
    public void agregarSala(Salas sala) {
        listaSalas.add(sala);
        System.out.println("Sala agregada: " + sala.getNombreSala());
    }
    
    public Salas buscarSalaPorId(String id) {
        for (Salas sala : listaSalas) {
            if (sala.getIdSala().equals(id)) {
                return sala;
            }
        }
        return null;
    }
    
    public void mostrarSalas() {
        System.out.println("\n===== LISTA DE SALAS =====");
        if (listaSalas.isEmpty()) {
            System.out.println("No hay salas registradas.");
        } else {
            for (Salas sala : listaSalas) {
                System.out.println("\n" + sala);
                System.out.println("---------------------");
            }
        }
    }
    
    public void cambiarEstadoSala(String id, String nuevoEstado) {
        Salas sala = buscarSalaPorId(id);
        if (sala != null) {
            sala.setEstadoSala(nuevoEstado);
            System.out.println("Estado de sala actualizado: " + sala.getNombreSala() + " - " + nuevoEstado);
        } else {
            System.out.println("No se encontró ninguna sala con ID: " + id);
        }
    }
    
    public List<Salas> getListaSalas() {
        return listaSalas;
    }
}