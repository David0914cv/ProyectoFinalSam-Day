package co.edu.uniquindio.poo.proyectosameday.model;

public class Cotizacion {
    private String ciudadOrigen,ciudadDestino;
    private int peso;
    private String dimensiones;
    private double price;

    private Cotizacion(Builder builder) {
        this.ciudadOrigen = builder.ciudadOrigen;
        this.ciudadDestino = builder.ciudadDestino;
        this.peso = builder.peso;
        this.dimensiones = builder.dimensiones;
        this.price = builder.price;
    }

    public void calcularPrecio(){

        if (ciudadOrigen.equals("CALARCA")) {
            setPrice(20000);
        }

    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cotizacion{" +
                "ciudadOrigen=" + ciudadOrigen +
                ", ciudadDestino=" + ciudadDestino +
                ", peso=" + peso +
                ", dimensiones='" + dimensiones + '\'' +
                ", price=" + price +
                '}';
    }

    public static class Builder{
        private String ciudadOrigen,ciudadDestino;
        private int peso;
        private String dimensiones;
        private double price;

        public Builder ciudadOrigen(String ciudadOrigen) {
            this.ciudadOrigen = ciudadOrigen;
            return this;
        }

        public Builder ciudadDestino(String ciudadDestino) {
            this.ciudadDestino = ciudadDestino;
            return this;
        }

        public Builder peso(int peso){
            this.peso=peso;
            return this;
        }

        public Builder dimensiones(String dimensiones){
            this.dimensiones=dimensiones;
            return this;
        }

        public Builder price(double price){
            this.price=price;
            return this;
        }

        public Cotizacion build(){
            return new Cotizacion(this);
        }
    }
}
