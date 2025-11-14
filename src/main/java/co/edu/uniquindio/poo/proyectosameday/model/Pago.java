package co.edu.uniquindio.poo.proyectosameday.model;

import java.util.UUID;

public class Pago {
    private String id;
    private Usuario usuario;
    private EnvioComponent envio;

    public Pago(Usuario usuario, EnvioComponent envio) {
        this.id = UUID.randomUUID().toString();
        this.usuario = usuario;
        this.envio = envio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EnvioComponent getEnvio() {
        return envio;
    }

    public void setEnvio(EnvioComponent envio) {
        this.envio = envio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "id='" + id + '\'' +
                ", usuario=" + usuario +
                ", envio=" + envio +
                '}';
    }
}
