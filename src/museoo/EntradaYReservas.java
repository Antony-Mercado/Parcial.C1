/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package museoo;

import java.util.*;

public class EntradaYReservas {
    private String numeroEntrada;
    private String tipoEntrada;
    private String fechaHoraVisita;
    private String metodoCompra;
    private String estadoEntrada;
    private String visitanteAsociado;
    private double precio;
    
    public EntradaYReservas(String numeroEntrada, String tipoEntrada, String fechaHoraVisita,
                            String metodoCompra, String estadoEntrada, String visitanteAsociado, double precio) {
        this.numeroEntrada = numeroEntrada;
        this.tipoEntrada = tipoEntrada;
        this.fechaHoraVisita = fechaHoraVisita;
        this.metodoCompra = metodoCompra;
        this.estadoEntrada = estadoEntrada;
        this.visitanteAsociado = visitanteAsociado;
        this.precio = precio;
    }
    
    // Getters
    public String getNumeroEntrada() { return numeroEntrada; }
    public String getTipoEntrada() { return tipoEntrada; }
    public String getFechaHoraVisita() { return fechaHoraVisita; }
    public String getMetodoCompra() { return metodoCompra; }
    public String getEstadoEntrada() { return estadoEntrada; }
    public String getVisitanteAsociado() { return visitanteAsociado; }
    public double getPrecio() { return precio; }
    
    // Setters
    public void setNumeroEntrada(String numeroEntrada) { this.numeroEntrada = numeroEntrada; }
    public void setTipoEntrada(String tipoEntrada) { this.tipoEntrada = tipoEntrada; }
    public void setFechaHoraVisita(String fechaHoraVisita) { this.fechaHoraVisita = fechaHoraVisita; }
    public void setMetodoCompra(String metodoCompra) { this.metodoCompra = metodoCompra; }
    public void setEstadoEntrada(String estadoEntrada) { this.estadoEntrada = estadoEntrada; }
    public void setVisitanteAsociado(String visitanteAsociado) { this.visitanteAsociado = visitanteAsociado; }
    public void setPrecio(double precio) { this.precio = precio; }
    
    @Override
    public String toString() {
        return "Número: " + numeroEntrada + 
               "\nTipo: " + tipoEntrada + 
               "\nFecha/Hora: " + fechaHoraVisita + 
               "\nMétodo de compra: " + metodoCompra + 
               "\nEstado: " + estadoEntrada + 
               "\nVisitante: " + visitanteAsociado + 
               "\nPrecio: $" + precio;
    }
}

// Gestor de Entradas y Reservas
class GestorEntradas {
    private List<EntradaYReservas> listaEntradas;
    private int contadorEntradas = 1000; // Contador para generar números de entrada únicos
    
    public GestorEntradas() {
        listaEntradas = new ArrayList<>();
    }
    
    public String generarNumeroEntrada() {
        return "ENT-" + (++contadorEntradas);
    }
    
    public void venderEntrada(String tipoEntrada, String fechaHoraVisita, String metodoCompra, 
                             String visitanteAsociado, double precio) {
        String numeroEntrada = generarNumeroEntrada();
        EntradaYReservas entrada = new EntradaYReservas(numeroEntrada, tipoEntrada, fechaHoraVisita, 
                                                       metodoCompra, "Válida", visitanteAsociado, precio);
        listaEntradas.add(entrada);
        System.out.println("Entrada vendida: " + numeroEntrada);
    }
    
    public void hacerReserva(String tipoEntrada, String fechaHoraVisita, String visitanteAsociado, double precio) {
        String numeroEntrada = generarNumeroEntrada();
        EntradaYReservas reserva = new EntradaYReservas(numeroEntrada, tipoEntrada, fechaHoraVisita, 
                                                       "Reserva", "Reservada", visitanteAsociado, precio);
        listaEntradas.add(reserva);
        System.out.println("Reserva realizada: " + numeroEntrada);
    }
    
    public EntradaYReservas buscarEntradaPorNumero(String numero) {
        for (EntradaYReservas entrada : listaEntradas) {
            if (entrada.getNumeroEntrada().equals(numero)) {
                return entrada;
            }
        }
        return null;
    }
    
    public void mostrarEntradas() {
        System.out.println("\n===== LISTA DE ENTRADAS Y RESERVAS =====");
        if (listaEntradas.isEmpty()) {
            System.out.println("No hay entradas registradas.");
        } else {
            for (EntradaYReservas entrada : listaEntradas) {
                System.out.println("\n" + entrada);
                System.out.println("---------------------");
            }
        }
    }
    
    public void cancelarEntrada(String numeroEntrada) {
        EntradaYReservas entrada = buscarEntradaPorNumero(numeroEntrada);
        if (entrada != null) {
            entrada.setEstadoEntrada("Cancelada");
            System.out.println("Entrada cancelada: " + numeroEntrada);
        } else {
            System.out.println("No se encontró la entrada: " + numeroEntrada);
        }
    }
    
    public List<EntradaYReservas> getListaEntradas() {
        return listaEntradas;
    }
}
