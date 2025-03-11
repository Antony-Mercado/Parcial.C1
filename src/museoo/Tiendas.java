/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package museoo;

import java.util.*;

public class Tiendas {
    private String codigoArticulo;
    private String nombreArticulo;
    private String precioVenta;
    private String cantidadDisponible;
    private String proveedor;
    private String ubicacionTienda;
    private String categoriaArticulo;
    private String fechaIngreso;
    private String costoAdquisicion;
    private boolean destacado;
    
    private static List<Tiendas> inventario = new ArrayList<>();
    private static Map<String, List<Tiendas>> inventarioPorUbicacion = new HashMap<>();
    private static Map<String, List<Tiendas>> inventarioPorCategoria = new HashMap<>();
    private static List<String> registroVentas = new ArrayList<>();
    
    // Constructor vacío
    public Tiendas() {
    }
    
    // Constructor con parámetros básicos
    public Tiendas(String codigoArticulo, String nombreArticulo, String precioVenta, 
                  String cantidadDisponible, String proveedor, String ubicacionTienda) {
        this.codigoArticulo = codigoArticulo;
        this.nombreArticulo = nombreArticulo;
        this.precioVenta = precioVenta;
        this.cantidadDisponible = cantidadDisponible;
        this.proveedor = proveedor;
        this.ubicacionTienda = ubicacionTienda;
        this.fechaIngreso = new Date().toString();
        this.destacado = false;
    }
    
    // Constructor completo
    public Tiendas(String codigoArticulo, String nombreArticulo, String precioVenta, 
                  String cantidadDisponible, String proveedor, String ubicacionTienda,
                  String categoriaArticulo, String costoAdquisicion, boolean destacado) {
        this.codigoArticulo = codigoArticulo;
        this.nombreArticulo = nombreArticulo;
        this.precioVenta = precioVenta;
        this.cantidadDisponible = cantidadDisponible;
        this.proveedor = proveedor;
        this.ubicacionTienda = ubicacionTienda;
        this.categoriaArticulo = categoriaArticulo;
        this.fechaIngreso = new Date().toString();
        this.costoAdquisicion = costoAdquisicion;
        this.destacado = destacado;
    }
    
    // Getters y Setters
    public String getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(String codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public String getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(String precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(String cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getUbicacionTienda() {
        return ubicacionTienda;
    }

    public void setUbicacionTienda(String ubicacionTienda) {
        this.ubicacionTienda = ubicacionTienda;
    }
    
    public String getCategoriaArticulo() {
        return categoriaArticulo;
    }
    
    public void setCategoriaArticulo(String categoriaArticulo) {
        this.categoriaArticulo = categoriaArticulo;
    }
    
    public String getFechaIngreso() {
        return fechaIngreso;
    }
    
    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    public String getCostoAdquisicion() {
        return costoAdquisicion;
    }
    
    public void setCostoAdquisicion(String costoAdquisicion) {
        this.costoAdquisicion = costoAdquisicion;
    }
    
    public boolean isDestacado() {
        return destacado;
    }
    
    public void setDestacado(boolean destacado) {
        this.destacado = destacado;
    }
    
    // Métodos de gestión de inventario
    public void agregarAlInventario() {
        inventario.add(this);
        
        // Agregar a la categorización por ubicación
        inventarioPorUbicacion.computeIfAbsent(this.ubicacionTienda, k -> new ArrayList<>()).add(this);
        
        // Agregar a la categorización por categoría
        if (this.categoriaArticulo != null && !this.categoriaArticulo.isEmpty()) {
            inventarioPorCategoria.computeIfAbsent(this.categoriaArticulo, k -> new ArrayList<>()).add(this);
        }
    }
    
    public static Tiendas buscarArticulo(String codigo) {
        for (Tiendas articulo : inventario) {
            if (articulo.getCodigoArticulo().equals(codigo)) {
                return articulo;
            }
        }
        return null;
    }
    
    public static List<Tiendas> buscarArticuloPorNombre(String nombre) {
        List<Tiendas> resultados = new ArrayList<>();
        for (Tiendas articulo : inventario) {
            if (articulo.getNombreArticulo().toLowerCase().contains(nombre.toLowerCase())) {
                resultados.add(articulo);
            }
        }
        return resultados;
    }
    
    public boolean actualizarStock(int cantidadVendida) {
        int stockActual = Integer.parseInt(this.cantidadDisponible);
        if (stockActual >= cantidadVendida) {
            this.cantidadDisponible = String.valueOf(stockActual - cantidadVendida);
            return true;
        }
        return false;
    }
    
    public void registrarVenta(String idVisitante, int cantidad, String fecha) {
        String registro = "Venta: " + this.codigoArticulo + " - " + this.nombreArticulo +
                          " - Cantidad: " + cantidad + 
                          " - Cliente: " + idVisitante + 
                          " - Fecha: " + fecha +
                          " - Ingresos: " + (Float.parseFloat(this.precioVenta) * cantidad);
        registroVentas.add(registro);
        actualizarStock(cantidad);
    }
    
    public boolean necesitaReposicion() {
        return Integer.parseInt(this.cantidadDisponible) < 5;
    }
    
    public float calcularBeneficio() {
        float precio = Float.parseFloat(this.precioVenta);
        float costo = (this.costoAdquisicion != null && !this.costoAdquisicion.isEmpty()) 
                     ? Float.parseFloat(this.costoAdquisicion) : 0;
        return precio - costo;
    }
    
    public float calcularMargenBeneficio() {
        float precio = Float.parseFloat(this.precioVenta);
        float costo = (this.costoAdquisicion != null && !this.costoAdquisicion.isEmpty()) 
                     ? Float.parseFloat(this.costoAdquisicion) : 0;
        return (precio - costo) / precio * 100;
    }
    
    // Métodos estáticos para gestionar la colección
    public static List<Tiendas> getInventario() {
        return inventario;
    }
    
    public static List<Tiendas> getArticulosPorUbicacion(String ubicacion) {
        return inventarioPorUbicacion.getOrDefault(ubicacion, new ArrayList<>());
    }
    
    public static List<Tiendas> getArticulosPorCategoria(String categoria) {
        return inventarioPorCategoria.getOrDefault(categoria, new ArrayList<>());
    }
    
    public static List<Tiendas> getArticulosDestacados() {
        List<Tiendas> destacados = new ArrayList<>();
        for (Tiendas articulo : inventario) {
            if (articulo.isDestacado()) {
                destacados.add(articulo);
            }
        }
        return destacados;
    }
    
    public static List<Tiendas> getArticulosConBajoStock() {
        List<Tiendas> bajoStock = new ArrayList<>();
        for (Tiendas articulo : inventario) {
            if (articulo.necesitaReposicion()) {
                bajoStock.add(articulo);
            }
        }
        return bajoStock;
    }
    
    public static List<String> getRegistroVentas() {
        return registroVentas;
    }
    
    public static float calcularValorTotalInventario() {
        float total = 0;
        for (Tiendas articulo : inventario) {
            total += Float.parseFloat(articulo.getPrecioVenta()) * 
                     Integer.parseInt(articulo.getCantidadDisponible());
        }
        return total;
    }
    
    public static void generarReporteInventario() {
        System.out.println("=== REPORTE DE INVENTARIO ===");
        System.out.println("Total de artículos: " + inventario.size());
        System.out.println("Valor total: $" + calcularValorTotalInventario());
        System.out.println("Artículos con bajo stock: " + getArticulosConBajoStock().size());
        System.out.println("========================");
    }
    
    @Override
    public String toString() {
        return "Artículo: " + nombreArticulo + 
               "\nCódigo: " + codigoArticulo + 
               "\nPrecio: " + precioVenta + 
               "\nDisponible: " + cantidadDisponible + 
               "\nProveedor: " + proveedor + 
               "\nUbicación: " + ubicacionTienda +
               (categoriaArticulo != null ? "\nCategoría: " + categoriaArticulo : "") +
               (destacado ? "\n[DESTACADO]" : "") +
               (necesitaReposicion() ? "\n[BAJO STOCK]" : "");
    }
}
