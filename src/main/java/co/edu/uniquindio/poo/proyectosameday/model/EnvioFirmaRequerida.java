package co.edu.uniquindio.poo.proyectosameday.model;

import java.time.LocalDateTime;

public class EnvioFirmaRequerida extends EnvioDecorator {
    public EnvioFirmaRequerida(Envio envio) {
        super(envio);
    }

    @Override
    public String getId() {
        return super.getId();
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
        setPrice(super.getPrice()+1500);
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

    @Override
    public String getFechaEntregaFormateada() {
        return super.getFechaEntregaFormateada();
    }

}
