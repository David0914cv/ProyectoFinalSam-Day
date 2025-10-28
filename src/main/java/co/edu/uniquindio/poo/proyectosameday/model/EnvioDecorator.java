package co.edu.uniquindio.poo.proyectosameday.model;

import java.time.LocalDateTime;

public abstract class EnvioDecorator implements  EnvioComponent {

    protected Envio envio;

    public EnvioDecorator(Envio envio) {
        this.envio = envio;
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
    public void setPrice(double price) {
        envio.setPrice(price);
    }
}
