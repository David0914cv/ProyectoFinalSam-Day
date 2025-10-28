package co.edu.uniquindio.poo.proyectosameday.model;

import java.time.LocalDateTime;

public class Envio implements EnvioComponent{

    private String ciudadOrigen,ciudadDestino, direccionOrigen, direccionDestino;
    private EstadoEnvio estado;
    private Paquete paquete;
    private double price;
    private LocalDateTime fechaCreacion,fechaEntrega;

    public Envio(String ciudadOrigen, String ciudadDestino, String direccionOrigen, String direccionDestino, EstadoEnvio estado, double price,
                 LocalDateTime fechaCreacion, LocalDateTime fechaEntrega) {

        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.direccionOrigen = direccionOrigen;
        this.direccionDestino = direccionDestino;
        this.estado = estado;
        this.price = price;
        this.fechaCreacion = fechaCreacion;
        this.fechaEntrega = fechaEntrega;

    }


    @Override
    public String getCiudadOrigen() {
        return this.ciudadOrigen;
    }

    @Override
    public String getCiudadDestino() {
        return this.ciudadDestino;
    }

    @Override
    public String getDireccionOrigen() {
        return this.direccionOrigen;
    }

    @Override
    public String getDireccionDestino() {
        return this.direccionDestino;
    }

    @Override
    public EstadoEnvio getEstado() {
        return this.estado;
    }

    @Override
    public Paquete getPaquete() {
        return this.paquete;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public LocalDateTime getFechaCreacion() {
        return this.fechaCreacion;
    }

    @Override
    public LocalDateTime getFechaEntrega() {
        return this.fechaEntrega;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public void setDireccionOrigen(String direccionOrigen) {
        this.direccionOrigen = direccionOrigen;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public void setEstado(EstadoEnvio estado) {
        this.estado = estado;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaEntrega(LocalDateTime fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
}
