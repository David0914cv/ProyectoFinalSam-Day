package co.edu.uniquindio.poo.proyectosameday.model;

public class Usuario extends Persona {

    private String correo;

    public Usuario(String nombre, String telefono, String correo,String contrasena) {
        super(nombre, telefono,Hash.hashear(contrasena));
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Usuario{\n" +
                "id= "+ getId() + "\n" +
                "correo= " + correo + '\n' +
                "nombre= "+ getNombre() + '\n' +
                "telefono= "+ getTelefono() + '\n' +
                "contraseña= "+getContrasena() + '\n' +
                '}';
    }
}
