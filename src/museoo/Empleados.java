package museoo;

import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class Empleados {
    private String idEmpleados;
    private String nombre;
    private String cargo;
    private String horarioTrabajo;
    private String telefonoContacto;
    private String correoElectronico;
    
    public Empleados(String idEmpleados, String nombre, String cargo, String horarioTrabajo, 
                     String telefonoContacto, String correoElectronico) {
        this.idEmpleados = idEmpleados;
        this.nombre = nombre;
        this.cargo = cargo;
        this.horarioTrabajo = horarioTrabajo;
        this.telefonoContacto = telefonoContacto;
        this.correoElectronico = correoElectronico;
    }
    
    // Getters
    public String getIdEmpleados() { return idEmpleados; }
    public String getNombre() { return nombre; }
    public String getCargo() { return cargo; }
    public String getHorarioTrabajo() { return horarioTrabajo; }
    public String getTelefonoContacto() { return telefonoContacto; }
    public String getCorreoElectronico() { return correoElectronico; }
    
    // Setters
    public void setIdEmpleados(String idEmpleados) { this.idEmpleados = idEmpleados; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    public void setHorarioTrabajo(String horarioTrabajo) { this.horarioTrabajo = horarioTrabajo; }
    public void setTelefonoContacto(String telefonoContacto) { this.telefonoContacto = telefonoContacto; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }
    
    @Override
    public String toString() {
        return "ID: " + idEmpleados + 
               "\nNombre: " + nombre + 
               "\nCargo: " + cargo + 
               "\nHorario: " + horarioTrabajo + 
               "\nTeléfono: " + telefonoContacto + 
               "\nCorreo: " + correoElectronico;
    }
}

// Gestor de Empleados
class GestorEmpleados {
    private List<Empleados> listaEmpleados;
    
    public GestorEmpleados() {
        listaEmpleados = new ArrayList<>();
    }
    
    public void agregarEmpleado(Empleados empleado) {
        listaEmpleados.add(empleado);
        System.out.println("Empleado agregado: " + empleado.getNombre());
    }
    
    public List<Empleados> getListaEmpleados() {
        return listaEmpleados;
    }
    
    public Empleados buscarEmpleadoPorId(String id) {
        for (Empleados emp : listaEmpleados) {
            if (emp.getIdEmpleados().equals(id)) {
                return emp;
            }
        }
        return null;
    }
    
    public void mostrarEmpleados() {
        System.out.println("\n===== LISTA DE EMPLEADOS =====");
        if (listaEmpleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (Empleados emp : listaEmpleados) {
                System.out.println("\n" + emp);
                System.out.println("---------------------");
            }
        }
    }
    
    public void eliminarEmpleado(String id) {
        Empleados emp = buscarEmpleadoPorId(id);
        if (emp != null) {
            listaEmpleados.remove(emp);
            System.out.println("Empleado eliminado: " + emp.getNombre());
        } else {
            System.out.println("No se encontró ningún empleado con ID: " + id);
        }
    }
}
