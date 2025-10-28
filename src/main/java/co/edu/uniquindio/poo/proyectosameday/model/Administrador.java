package co.edu.uniquindio.poo.proyectosameday.model;

public class Administrador {
    private String documento,nombre,contrasena;

    public Administrador(String documento, String nombre, String contrasena) {
        this.documento = documento;
        this.nombre = nombre;
        this.contrasena = Hash.hashear(contrasena);
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "documento= " + documento + '\n' +
                ", nombre= " + nombre + '\n' +
                ", contrasena= " + contrasena + '\n' +
                '}';
    }
}
