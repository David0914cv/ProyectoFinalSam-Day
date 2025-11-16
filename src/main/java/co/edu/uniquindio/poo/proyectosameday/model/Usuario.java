package co.edu.uniquindio.poo.proyectosameday.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona implements Observer{

    private String correo;
    private List<String> listNotifications;

    public Usuario(String nombre, String documento, String telefono, String correo,String contrasena) {
        super(documento,nombre, telefono,Hash.hashear(contrasena));
        this.correo = correo;
        this.listNotifications = new ArrayList<>();
    }

    public void addListNotification(String notify){
        this.listNotifications.add(notify);
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<String> getListNotifications() {
        return listNotifications;
    }

    public void setListNotifications(List<String> listNotifications) {
        this.listNotifications = listNotifications;
    }

    @Override
    public String toString() {
        return "Usuario{\n" +
                "id= "+ getId() + "\n" +
                "correo= " + correo + '\n' +
                "documento= " + getDocumento() + '\n' +
                "nombre= "+ getNombre() + '\n' +
                "telefono= "+ getTelefono() + '\n' +
                "contraseña= "+getContrasena() + '\n' +
                '}';
    }

    @Override
    public void update(String notify) {
        addListNotification(notify);
    }
}
