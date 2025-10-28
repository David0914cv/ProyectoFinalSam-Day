package co.edu.uniquindio.poo.proyectosameday.model;

import java.util.UUID;

public class Paquete {
    private String id,peso,dimensiones;

    public Paquete(String peso, String dimensiones) {
        this.id= UUID.randomUUID().toString();
        this.peso = peso;
        this.dimensiones = dimensiones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "id='" + id + '\'' +
                ", peso='" + peso + '\'' +
                ", dimensiones='" + dimensiones + '\'' +
                '}';
    }
}
