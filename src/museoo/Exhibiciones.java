
package museoo;

import java.util.*;


public class Exhibiciones {
    private String codigoExhibicion;
    private String nombreExhibicion;
    private String tipoExhibicion;
    private String fechaInicio;
    private String ubicacionDentro;
    private String descripcionExhibicion;
    private String numeroVisitantesMaximos;
    private String duracion; // 2 horas
    
    public Exhibiciones(String duracion, String codigoExhibicion, String nombreExhibicion, String tipoExhibicion, 
                       String ubicacionDentro, String fechaInicio, String descripcionExhibicion, String numeroVisitantesMaximos){
        this.duracion = duracion;
        this.codigoExhibicion = codigoExhibicion;
        this.nombreExhibicion = nombreExhibicion;
        this.tipoExhibicion = tipoExhibicion;
        this.ubicacionDentro = ubicacionDentro;
        this.descripcionExhibicion = descripcionExhibicion;
        this.numeroVisitantesMaximos = numeroVisitantesMaximos;
        this.fechaInicio = fechaInicio;
    }
    
    // Improved getter naming convention
    public String getDuracion() { return duracion; }
    public String getCodigoExhibicion() { return codigoExhibicion; }
    public String getNombreExhibicion() { return nombreExhibicion; }
    public String getTipoExhibicion() { return tipoExhibicion; }
    public String getUbicacionDentro() { return ubicacionDentro; }
    public String getDescripcionExhibicion() { return descripcionExhibicion; }
    public String getNumeroVisitantesMaximos() { return numeroVisitantesMaximos; }
    public String getFechaInicio() { return fechaInicio; }
    
    @Override
    public String toString() {
        return "Código: " + codigoExhibicion + 
               "\nNombre: " + nombreExhibicion + 
               "\nTipo: " + tipoExhibicion + 
               "\nFecha de inicio: " + fechaInicio + 
               "\nUbicación: " + ubicacionDentro + 
               "\nDuración: " + duracion + 
               "\nVisitantes máximos: " + numeroVisitantesMaximos + 
               "\nDescripción: " + descripcionExhibicion;
    }
}

// Fixed GestorExhibiciones with proper generics
class GestorExhibiciones {
    private List<Exhibiciones> listaExhibiciones;

    public GestorExhibiciones() {
        listaExhibiciones = new ArrayList<>();
    }

    public void agregarExhibicion(Exhibiciones exhibicion) {
        listaExhibiciones.add(exhibicion);
        System.out.println("Exhibición agregada: " + exhibicion.getNombreExhibicion());
    }

    public void mostrarExhibiciones() {
        System.out.println("\n===== LISTA DE EXHIBICIONES =====");
        if (listaExhibiciones.isEmpty()) {
            System.out.println("No hay exhibiciones registradas.");
        } else {
            for (Exhibiciones exhibicion : listaExhibiciones) {
                System.out.println("\n" + exhibicion);
                System.out.println("---------------------");
            }
        }
    }
    
    public Exhibiciones buscarExhibicionPorCodigo(String codigo) {
        for (Exhibiciones exhibicion : listaExhibiciones) {
            if (exhibicion.getCodigoExhibicion().equals(codigo)) {
                return exhibicion;
            }
        }
        return null;
    }
    
    public void eliminarExhibicion(String codigo) {
        Exhibiciones exhibicion = buscarExhibicionPorCodigo(codigo);
        if (exhibicion != null) {
            listaExhibiciones.remove(exhibicion);
            System.out.println("Exhibición eliminada: " + exhibicion.getNombreExhibicion());
        } else {
            System.out.println("No se encontró ninguna exhibición con código: " + codigo);
        }
    }
    
    public List<Exhibiciones> getListaExhibiciones() {
        return listaExhibiciones;
    }
}
