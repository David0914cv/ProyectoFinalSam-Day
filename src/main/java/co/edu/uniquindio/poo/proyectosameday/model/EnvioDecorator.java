package co.edu.uniquindio.poo.proyectosameday.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class EnvioDecorator implements  EnvioComponent {

    protected Envio envio;

    public EnvioDecorator(Envio envio) {
        this.envio = envio;
    }

    @Override
    public String getId() {
        return envio.getId();
    }

    @Override
    public String getCiudadOrigen() {
        return envio.getCiudadOrigen();
    }

    @Override
    public String getCiudadDestino() {
        return envio.getCiudadDestino();
    }

    @Override
    public String getDireccionOrigen() {
        return envio.getDireccionOrigen();
    }

    @Override
    public String getDireccionDestino() {
        return envio.getDireccionDestino();
    }

    @Override
    public EstadoEnvio getEstado() {
        return envio.getEstado();
    }

    @Override
    public Paquete getPaquete() {
        return envio.getPaquete();
    }

    @Override
    public double getPrice() {
        return envio.getPrice();
    }

    @Override
    public LocalDateTime getFechaCreacion() {
        return envio.getFechaCreacion();
    }

    @Override
    public LocalDateTime getFechaEntrega() {
        return envio.getFechaEntrega();
    }

    @Override
    public Repartidor getRepartidor() {
        return envio.getRepartidor();
    }

    @Override
    public Usuario getUsuario() {
        return envio.getUsuario();
    }

    @Override
    public void setRepartidor(Repartidor repartidor) {
        envio.setRepartidor(repartidor);
    }

    @Override
    public void setUsuario(Usuario usuario) {
        envio.setUsuario(usuario);
    }

    @Override
    public void setPrice(double price) {
        envio.setPrice(price);
    }

    @Override
    public String getFechaEntregaFormateada() {
        return envio.getFechaEntregaFormateada();
    }
}
