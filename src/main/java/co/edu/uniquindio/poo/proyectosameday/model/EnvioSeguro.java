package co.edu.uniquindio.poo.proyectosameday.model;

import java.time.LocalDateTime;

public class EnvioSeguro extends EnvioDecorator {

    public EnvioSeguro(Envio envio) {
        super(envio);
    }

    @Override
    public String getCiudadOrigen() {
        return super.getCiudadOrigen();
    }

    @Override
    public String getCiudadDestino() {
        return super.getCiudadDestino();
    }

    @Override
    public String getDireccionOrigen() {
        return super.getDireccionOrigen();
    }

    @Override
    public String getDireccionDestino() {
        return super.getDireccionDestino();
    }

    @Override
    public EstadoEnvio getEstado() {
        return super.getEstado();
    }

    @Override
    public Paquete getPaquete() {
        return super.getPaquete();
    }

    @Override
    public double getPrice() {
        setPrice(super.getPrice()+2000);
        return super.getPrice();
    }

    @Override
    public Repartidor getRepartidor() {
        return super.getRepartidor();
    }

    @Override
    public Usuario getUsuario() {
        return super.getUsuario();
    }

    @Override
    public LocalDateTime getFechaCreacion() {
        return super.getFechaCreacion();
    }

    @Override
    public LocalDateTime getFechaEntrega() {
        return super.getFechaEntrega();
    }

}
