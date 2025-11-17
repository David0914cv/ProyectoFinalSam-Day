package co.edu.uniquindio.poo.proyectosameday.model;

import java.util.ArrayList;
import java.util.List;

public class Repartidor extends Persona implements Observer{

    private EstadoDisponibilidad estado;
    private List<String> listNotifications;

    public Repartidor(String nombre, String telefono, String contrasena, String documento, EstadoDisponibilidad estado) {
        super(documento,nombre, telefono,Hash.hashear(contrasena));
        this.estado = estado;
        this.listNotifications = new ArrayList<>();
    }

    public void addListNotification(String notify){
        this.listNotifications.add(notify);
    }

    public EstadoDisponibilidad getEstado() {
        return estado;
    }

    public void setEstado(EstadoDisponibilidad estado) {
        this.estado = estado;
    }

    public List<String> getListNotifications() {
        return listNotifications;
    }

    public void setListNotifications(List<String> listNotifications) {
        this.listNotifications = listNotifications;
    }

    @Override
    public String toString() {
        return "Repartidor: "+getNombre();
    }

    @Override
    public void update(String notify) {
        addListNotification(notify);
    }
}
