/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package museoo;

import java.util.*;

public class EventosEspeciales {
    private String codigoEvento;
    private String nombreEvento;
    private String tipoEvento;
    private String fechaYHora;
    private String ubicacionMuseo;
    private int capacidadMaximaAsistentes;
    private double precioEntrada;
    
    public EventosEspeciales(String codigoEvento, String nombreEvento, String tipoEvento, 
                             String fechaYHora, String ubicacionMuseo, int capacidadMaximaAsistentes,
                             double precioEntrada) {
        this.codigoEvento = codigoEvento;
        this.nombreEvento = nombreEvento;
        this.tipoEvento = tipoEvento;
        this.fechaYHora = fechaYHora;
        this.ubicacionMuseo = ubicacionMuseo;
        this.capacidadMaximaAsistentes = capacidadMaximaAsistentes;
        this.precioEntrada = precioEntrada;
    }
    
    // Getters
    public String getCodigoEvento() { return codigoEvento; }
    public String getNombreEvento() { return nombreEvento; }
    public String getTipoEvento() { return tipoEvento; }
    public String getFechaYHora() { return fechaYHora; }
    public String getUbicacionMuseo() { return ubicacionMuseo; }
    public int getCapacidadMaximaAsistentes() { return capacidadMaximaAsistentes; }
    public double getPrecioEntrada() { return precioEntrada; }
    
    // Setters
    public void setCodigoEvento(String codigoEvento) { this.codigoEvento = codigoEvento; }
    public void setNombreEvento(String nombreEvento) { this.nombreEvento = nombreEvento; }
    public void setTipoEvento(String tipoEvento) { this.tipoEvento = tipoEvento; }
    public void setFechaYHora(String fechaYHora) { this.fechaYHora = fechaYHora; }
    public void setUbicacionMuseo(String ubicacionMuseo) { this.ubicacionMuseo = ubicacionMuseo; }
    public void setCapacidadMaximaAsistentes(int capacidadMaximaAsistentes) { this.capacidadMaximaAsistentes = capacidadMaximaAsistentes; }
    public void setPrecioEntrada(double precioEntrada) { this.precioEntrada = precioEntrada; }
    
    @Override
    public String toString() {
        return "Código: " + codigoEvento + 
               "\nNombre: " + nombreEvento + 
               "\nTipo: " + tipoEvento + 
               "\nFecha y Hora: " + fechaYHora + 
               "\nUbicación: " + ubicacionMuseo + 
               "\nCapacidad: " + capacidadMaximaAsistentes + " asistentes" +
               "\nPrecio: $" + precioEntrada;
    }
}

// Gestor de Eventos Especiales
class GestorEventos {
    private List<EventosEspeciales> listaEventos;
    
    public GestorEventos() {
        listaEventos = new ArrayList<>();
    }
    
    public void agregarEvento(EventosEspeciales evento) {
        listaEventos.add(evento);
        System.out.println("Evento agregado: " + evento.getNombreEvento());
    }
    
    public EventosEspeciales buscarEventoPorCodigo(String codigo) {
        for (EventosEspeciales evento : listaEventos) {
            if (evento.getCodigoEvento().equals(codigo)) {
                return evento;
            }
        }
        return null;
    }
    
    public void mostrarEventos() {
        System.out.println("\n===== LISTA DE EVENTOS ESPECIALES =====");
        if (listaEventos.isEmpty()) {
            System.out.println("No hay eventos registrados.");
        } else {
            for (EventosEspeciales evento : listaEventos) {
                System.out.println("\n" + evento);
                System.out.println("---------------------");
            }
        }
    }
    
    public void eliminarEvento(String codigo) {
        EventosEspeciales evento = buscarEventoPorCodigo(codigo);
        if (evento != null) {
            listaEventos.remove(evento);
            System.out.println("Evento eliminado: " + evento.getNombreEvento());
        } else {
            System.out.println("No se encontró ningún evento con código: " + codigo);
        }
    }
    
    public List<EventosEspeciales> getListaEventos() {
        return listaEventos;
    }
}

