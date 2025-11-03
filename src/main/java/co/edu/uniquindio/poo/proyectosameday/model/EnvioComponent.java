package co.edu.uniquindio.poo.proyectosameday.model;

import java.time.LocalDateTime;

public interface EnvioComponent {

    public String getCiudadOrigen();
    public String getCiudadDestino();
    public String getDireccionOrigen();
    public String getDireccionDestino();
    public EstadoEnvio getEstado();
    public Paquete getPaquete();
    public double getPrice();
    public LocalDateTime getFechaCreacion();
    public LocalDateTime getFechaEntrega();
    public void setPrice(double price);
    public Usuario getUsuario();
    public void setUsuario(Usuario usuario);
    public Repartidor getRepartidor();
    public void setRepartidor(Repartidor repartidor);
}
