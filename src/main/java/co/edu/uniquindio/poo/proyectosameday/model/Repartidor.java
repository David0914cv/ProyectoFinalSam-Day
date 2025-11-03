package co.edu.uniquindio.poo.proyectosameday.model;

public class Repartidor extends Persona{

    private String documento;
    private EstadoDisponibilidad estado;

    public Repartidor(String nombre, String telefono, String contrasena, String documento, EstadoDisponibilidad estado) {
        super(documento,nombre, telefono,Hash.hashear(contrasena));
        this.documento = documento;
        this.estado = estado;
    }

    public EstadoDisponibilidad getEstado() {
        return estado;
    }

    public void setEstado(EstadoDisponibilidad estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Repartidor{\n" +
                "documento=" + documento + '\n' +
                "estado=" + estado + '\n' +
                "id= "+ getId() + "\n" +
                "nombre= "+ getNombre() + '\n' +
                "telefono= "+ getTelefono() + '\n' +
                "contraseña= "+getContrasena() + '\n' +
                '}';
    }
}
