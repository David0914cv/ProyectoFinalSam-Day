package co.edu.uniquindio.poo.proyectosameday.model;

import jdk.swing.interop.SwingInterOpUtils;

import java.time.LocalDateTime;

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

        String[] parts = dimensiones.trim().toLowerCase().split("x");
        double dimension1=Double.parseDouble(parts[0]);
        double dimension2=Double.parseDouble(parts[1]);
        double dimension3=Double.parseDouble(parts[2]);

        double volumetricWeight = (dimension1*dimension2*dimension3) / 6000;
        double priceTotal;
        double baseRate = tarifaBase();

        System.out.println(baseRate);
        if (volumetricWeight > this.peso) {
            priceTotal = baseRate + (volumetricWeight *1500);
            setPrice(priceTotal);
            return;
        }

        priceTotal = baseRate + (this.peso *1500);
        setPrice(priceTotal);

    }

    public double tarifaBase() {

        if (ciudadOrigen.equalsIgnoreCase("CALARCA") && ciudadDestino.equalsIgnoreCase("ARMENIA")
        || ciudadOrigen.equalsIgnoreCase("ARMENIA") && ciudadDestino.equalsIgnoreCase("CALARCA")) {
            return 3000;
        }

        if (ciudadOrigen.equalsIgnoreCase("CALARCA") && ciudadDestino.equalsIgnoreCase("MONTENEGRO")
                || ciudadOrigen.equalsIgnoreCase("MONTENEGRO") && ciudadDestino.equalsIgnoreCase("CALARCA")) {
            return 3600;
        }

        if (ciudadOrigen.equalsIgnoreCase("CALARCA") && ciudadDestino.equalsIgnoreCase("CIRCASIA")
                || ciudadOrigen.equalsIgnoreCase("CIRCASIA") && ciudadDestino.equalsIgnoreCase("CALARCA")) {
            return 3900;
        }

        if (ciudadOrigen.equalsIgnoreCase("CALARCA") && ciudadDestino.equalsIgnoreCase("QUIMBAYA")
                || ciudadOrigen.equalsIgnoreCase("QUIMBAYA") && ciudadDestino.equalsIgnoreCase("CALARCA")) {
            return 6900;
        }

        if (ciudadOrigen.equalsIgnoreCase("CALARCA") && ciudadDestino.equalsIgnoreCase("TEBAIDA")
                || ciudadOrigen.equalsIgnoreCase("TEBAIDA") && ciudadDestino.equalsIgnoreCase("CALARCA")) {
            return 5100;
        }

        if (ciudadOrigen.equalsIgnoreCase("CALARCA") && ciudadDestino.equalsIgnoreCase("GENOVA")
                || ciudadOrigen.equalsIgnoreCase("GENOVA") && ciudadDestino.equalsIgnoreCase("CALARCA")) {
            return 16500;
        }

        if (ciudadOrigen.equalsIgnoreCase("CALARCA") && ciudadDestino.equalsIgnoreCase("PIJAO")
                || ciudadOrigen.equalsIgnoreCase("PIJAO") && ciudadDestino.equalsIgnoreCase("CALARCA")) {
            return 10200;
        }

        if (ciudadOrigen.equalsIgnoreCase("CALARCA") && ciudadDestino.equalsIgnoreCase("CORDOBA")
                || ciudadOrigen.equalsIgnoreCase("CORDOBA") && ciudadDestino.equalsIgnoreCase("CALARCA")) {
            return 8100;
        }

        if (ciudadOrigen.equalsIgnoreCase("CALARCA") && ciudadDestino.equalsIgnoreCase("SALENTO")
                || ciudadOrigen.equalsIgnoreCase("SALENTO") && ciudadDestino.equalsIgnoreCase("CALARCA")) {
            return 7800;
        }

        if (ciudadOrigen.equalsIgnoreCase("CALARCA") && ciudadDestino.equalsIgnoreCase("BUENAVISTA")
                || ciudadOrigen.equalsIgnoreCase("BUENAVISTA") && ciudadDestino.equalsIgnoreCase("CALARCA")) {
            return 9000;
        }

        if (ciudadOrigen.equalsIgnoreCase("CALARCA") && ciudadDestino.equalsIgnoreCase("FILANDIA")
                || ciudadOrigen.equalsIgnoreCase("FILANDIA") && ciudadDestino.equalsIgnoreCase("CALARCA")) {
            return 8700;
        }

        if (ciudadOrigen.equalsIgnoreCase("ARMENIA") && ciudadDestino.equalsIgnoreCase("MONTENEGRO")
                || ciudadOrigen.equalsIgnoreCase("MONTENGRO") && ciudadDestino.equalsIgnoreCase("ARMENIA")) {
            return 3900;
        }

        if (ciudadOrigen.equalsIgnoreCase("ARMENIA") && ciudadDestino.equalsIgnoreCase("QUIMBAYA")
                || ciudadOrigen.equalsIgnoreCase("QUIMBAYA") && ciudadDestino.equalsIgnoreCase("ARMENIA")) {
            return 6600;
        }

        if (ciudadOrigen.equalsIgnoreCase("ARMENIA") && ciudadDestino.equalsIgnoreCase("TEBAIDA")
                || ciudadOrigen.equalsIgnoreCase("TEBAIDA") && ciudadDestino.equalsIgnoreCase("ARMENIA")) {
            return 5400;
        }

        if (ciudadOrigen.equalsIgnoreCase("ARMENIA") && ciudadDestino.equalsIgnoreCase("CIRCASIA")
                || ciudadOrigen.equalsIgnoreCase("CIRCASIA") && ciudadDestino.equalsIgnoreCase("ARMENIA")) {
            return 3300;
        }

        if (ciudadOrigen.equalsIgnoreCase("ARMENIA") && ciudadDestino.equalsIgnoreCase("GENOVA")
                || ciudadOrigen.equalsIgnoreCase("GENOVA") && ciudadDestino.equalsIgnoreCase("ARMENIA")) {
            return 16500;
        }

        if (ciudadOrigen.equalsIgnoreCase("ARMENIA") && ciudadDestino.equalsIgnoreCase("PIJAO")
                || ciudadOrigen.equalsIgnoreCase("PIJAO") && ciudadDestino.equalsIgnoreCase("ARMENIA")) {
            return 10200;
        }

        if (ciudadOrigen.equalsIgnoreCase("ARMENIA") && ciudadDestino.equalsIgnoreCase("CORDOBA")
                || ciudadOrigen.equalsIgnoreCase("CORDOBA") && ciudadDestino.equalsIgnoreCase("ARMENIA")) {
            return 8100;
        }

        if (ciudadOrigen.equalsIgnoreCase("ARMENIA") && ciudadDestino.equalsIgnoreCase("SALENTO")
                || ciudadOrigen.equalsIgnoreCase("SALENTO") && ciudadDestino.equalsIgnoreCase("ARMENIA")) {
            return 7500;
        }

        if (ciudadOrigen.equalsIgnoreCase("ARMENIA") && ciudadDestino.equalsIgnoreCase("BUENAVISTA")
                || ciudadOrigen.equalsIgnoreCase("BUENAVISTA") && ciudadDestino.equalsIgnoreCase("ARMENIA")) {
            return 9000;
        }

        if (ciudadOrigen.equalsIgnoreCase("ARMENIA") && ciudadDestino.equalsIgnoreCase("FILANDIA")
                || ciudadOrigen.equalsIgnoreCase("FILANDIA") && ciudadDestino.equalsIgnoreCase("ARMENIA")) {
            return 8400;
        }

        if (ciudadOrigen.equalsIgnoreCase("CIRCASIA") && ciudadDestino.equalsIgnoreCase("SALENTO")
                || ciudadOrigen.equalsIgnoreCase("SALENTO") && ciudadDestino.equalsIgnoreCase("CIRCASIA")) {
            return 4500;
        }

        if (ciudadOrigen.equalsIgnoreCase("CIRCASIA") && ciudadDestino.equalsIgnoreCase("MONTENEGRO")
                || ciudadOrigen.equalsIgnoreCase("MONTENEGRO") && ciudadDestino.equalsIgnoreCase("CIRCASIA")) {
            return 4200;
        }

        if (ciudadOrigen.equalsIgnoreCase("CIRCASIA") && ciudadDestino.equalsIgnoreCase("QUIMBAYA")
                || ciudadOrigen.equalsIgnoreCase("QUIMBAYA") && ciudadDestino.equalsIgnoreCase("CIRCASIA")) {
            return 4500;
        }

        if (ciudadOrigen.equalsIgnoreCase("CIRCASIA") && ciudadDestino.equalsIgnoreCase("TEBAIDA")
                || ciudadOrigen.equalsIgnoreCase("TEBAIDA") && ciudadDestino.equalsIgnoreCase("CIRCASIA")) {
            return 8700;
        }

        if (ciudadOrigen.equalsIgnoreCase("CIRCASIA") && ciudadDestino.equalsIgnoreCase("CORDOBA")
                || ciudadOrigen.equalsIgnoreCase("CORDOBA") && ciudadDestino.equalsIgnoreCase("CIRCASIA")) {
            return 9000;
        }

        if (ciudadOrigen.equalsIgnoreCase("CIRCASIA") && ciudadDestino.equalsIgnoreCase("BUENAVISTA")
                || ciudadOrigen.equalsIgnoreCase("BUENAVISTA") && ciudadDestino.equalsIgnoreCase("CIRCASIA")) {
            return 9600;
        }

        if (ciudadOrigen.equalsIgnoreCase("CIRCASIA") && ciudadDestino.equalsIgnoreCase("PIJAO")
                || ciudadOrigen.equalsIgnoreCase("PIJAO") && ciudadDestino.equalsIgnoreCase("CIRCASIA")) {
            return 10200;
        }

        if (ciudadOrigen.equalsIgnoreCase("CIRCASIA") && ciudadDestino.equalsIgnoreCase("GENOVA")
                || ciudadOrigen.equalsIgnoreCase("GENOVA") && ciudadDestino.equalsIgnoreCase("CIRCASIA")) {
            return 18000;
        }

        if (ciudadOrigen.equalsIgnoreCase("SALENTO") && ciudadDestino.equalsIgnoreCase("FILANDIA")
                || ciudadOrigen.equalsIgnoreCase("FILANDIA") && ciudadDestino.equalsIgnoreCase("SALENTO")) {
            return 6000;
        }

        if (ciudadOrigen.equalsIgnoreCase("SALENTO") && ciudadDestino.equalsIgnoreCase("MONTENEGRO")
                || ciudadOrigen.equalsIgnoreCase("MONTENEGRO") && ciudadDestino.equalsIgnoreCase("SALENTO")) {
            return 8700;
        }

        if (ciudadOrigen.equalsIgnoreCase("SALENTO") && ciudadDestino.equalsIgnoreCase("QUIMBAYA")
                || ciudadOrigen.equalsIgnoreCase("QUIMBAYA") && ciudadDestino.equalsIgnoreCase("SALENTO")) {
            return 11100;
        }

        if (ciudadOrigen.equalsIgnoreCase("SALENTO") && ciudadDestino.equalsIgnoreCase("TEBAIDA")
                || ciudadOrigen.equalsIgnoreCase("TEBAIDA") && ciudadDestino.equalsIgnoreCase("SALENTO")) {
            return 11400;
        }

        if (ciudadOrigen.equalsIgnoreCase("SALENTO") && ciudadDestino.equalsIgnoreCase("CORDOBA")
                || ciudadOrigen.equalsIgnoreCase("CORDOBA") && ciudadDestino.equalsIgnoreCase("SALENTO")) {
            return 20100;
        }

        if (ciudadOrigen.equalsIgnoreCase("SALENTO") && ciudadDestino.equalsIgnoreCase("BUENAVISTA")
                || ciudadOrigen.equalsIgnoreCase("BUENAVISTA") && ciudadDestino.equalsIgnoreCase("SALENTO")) {
            return 20400;
        }

        if (ciudadOrigen.equalsIgnoreCase("SALENTO") && ciudadDestino.equalsIgnoreCase("PIJAO")
                || ciudadOrigen.equalsIgnoreCase("PIJAO") && ciudadDestino.equalsIgnoreCase("SALENTO")) {
            return 15900;
        }

        if (ciudadOrigen.equalsIgnoreCase("SALENTO") && ciudadDestino.equalsIgnoreCase("GENOVA")
                || ciudadOrigen.equalsIgnoreCase("GENOVA") && ciudadDestino.equalsIgnoreCase("SALENTO")) {
            return 24000;
        }

        if (ciudadOrigen.equalsIgnoreCase("FILANDIA") && ciudadDestino.equalsIgnoreCase("QUIMBAYA")
                || ciudadOrigen.equalsIgnoreCase("QUIMBAYA") && ciudadDestino.equalsIgnoreCase("FILANDIA")) {
            return 5100;
        }

        if (ciudadOrigen.equalsIgnoreCase("FILANDIA") && ciudadDestino.equalsIgnoreCase("MONTENEGRO")
                || ciudadOrigen.equalsIgnoreCase("MONTENEGRO") && ciudadDestino.equalsIgnoreCase("FILANDIA")) {
            return 5700;
        }

        if (ciudadOrigen.equalsIgnoreCase("FILANDIA") && ciudadDestino.equalsIgnoreCase("TEBAIDA")
                || ciudadOrigen.equalsIgnoreCase("TEBAIDA") && ciudadDestino.equalsIgnoreCase("FILANDIA")) {
            return 13500;
        }

        if (ciudadOrigen.equalsIgnoreCase("FILANDIA") && ciudadDestino.equalsIgnoreCase("BUENAVISTA")
                || ciudadOrigen.equalsIgnoreCase("BUENAVISTA") && ciudadDestino.equalsIgnoreCase("FILANDIA")) {
            return 16500;
        }

        if (ciudadOrigen.equalsIgnoreCase("FILANDIA") && ciudadDestino.equalsIgnoreCase("PIJAO")
                || ciudadOrigen.equalsIgnoreCase("PIJAO") && ciudadDestino.equalsIgnoreCase("FILANDIA")) {
            return 18900;
        }

        if (ciudadOrigen.equalsIgnoreCase("FILANDIA") && ciudadDestino.equalsIgnoreCase("CORDOBA")
                || ciudadOrigen.equalsIgnoreCase("CORDOBA") && ciudadDestino.equalsIgnoreCase("FILANDIA")) {
            return 19800;
        }

        if (ciudadOrigen.equalsIgnoreCase("FILANDIA") && ciudadDestino.equalsIgnoreCase("GENOVA")
                || ciudadOrigen.equalsIgnoreCase("GENOVA") && ciudadDestino.equalsIgnoreCase("FILANDIA")) {
            return 23700;
        }

        if (ciudadOrigen.equalsIgnoreCase("QUIMBAYA") && ciudadDestino.equalsIgnoreCase("MONTENEGRO")
                || ciudadOrigen.equalsIgnoreCase("MONTENEGRO") && ciudadDestino.equalsIgnoreCase("QUIMBAYA")) {
            return 3000;
        }

        if (ciudadOrigen.equalsIgnoreCase("QUIMBAYA") && ciudadDestino.equalsIgnoreCase("TEBAIDA")
                || ciudadOrigen.equalsIgnoreCase("TEBAIDA") && ciudadDestino.equalsIgnoreCase("QUIMBAYA")) {
            return 8700;
        }

        if (ciudadOrigen.equalsIgnoreCase("QUIMBAYA") && ciudadDestino.equalsIgnoreCase("CORDOBA")
                || ciudadOrigen.equalsIgnoreCase("CORDOBA") && ciudadDestino.equalsIgnoreCase("QUIMBAYA")) {
            return 13800;
        }

        if (ciudadOrigen.equalsIgnoreCase("QUIMBAYA") && ciudadDestino.equalsIgnoreCase("BUENAVISTA")
                || ciudadOrigen.equalsIgnoreCase("BUENAVISTA") && ciudadDestino.equalsIgnoreCase("QUIMBAYA")) {
            return 15000;
        }

        if (ciudadOrigen.equalsIgnoreCase("QUIMBAYA") && ciudadDestino.equalsIgnoreCase("PIJAO")
                || ciudadOrigen.equalsIgnoreCase("PIJAO") && ciudadDestino.equalsIgnoreCase("QUIMBAYA")) {
            return 15900;
        }

        if (ciudadOrigen.equalsIgnoreCase("QUIMBAYA") && ciudadDestino.equalsIgnoreCase("GENOVA")
                || ciudadOrigen.equalsIgnoreCase("GENOVA") && ciudadDestino.equalsIgnoreCase("QUIMBAYA")) {
            return 18000;
        }

        if (ciudadOrigen.equalsIgnoreCase("MONTENEGRO") && ciudadDestino.equalsIgnoreCase("TEBAIDA")
                || ciudadOrigen.equalsIgnoreCase("TEBAIDA") && ciudadDestino.equalsIgnoreCase("MONTENEGRO")) {
            return 8700;
        }

        if (ciudadOrigen.equalsIgnoreCase("MONTENEGRO") && ciudadDestino.equalsIgnoreCase("CORDOBA")
                || ciudadOrigen.equalsIgnoreCase("CORDOBA") && ciudadDestino.equalsIgnoreCase("MONTENEGRO")) {
            return 11400;
        }

        if (ciudadOrigen.equalsIgnoreCase("MONTENEGRO") && ciudadDestino.equalsIgnoreCase("BUENAVISTA")
                || ciudadOrigen.equalsIgnoreCase("BUENAVISTA") && ciudadDestino.equalsIgnoreCase("MONTENEGRO")) {
            return 11000;
        }

        if (ciudadOrigen.equalsIgnoreCase("MONTENEGRO") && ciudadDestino.equalsIgnoreCase("PIJAO")
                || ciudadOrigen.equalsIgnoreCase("PIJAO") && ciudadDestino.equalsIgnoreCase("MONTENEGRO")) {
            return 13200;
        }

        if (ciudadOrigen.equalsIgnoreCase("MONTENEGRO") && ciudadDestino.equalsIgnoreCase("GENOVA")
                || ciudadOrigen.equalsIgnoreCase("GENOVA") && ciudadDestino.equalsIgnoreCase("MONTENEGRO")) {
            return 18000;
        }

        if (ciudadOrigen.equalsIgnoreCase("TEBAIDA") && ciudadDestino.equalsIgnoreCase("PIJAO")
                || ciudadOrigen.equalsIgnoreCase("PIJAO") && ciudadDestino.equalsIgnoreCase("TEBAIDA")) {
            return 11700;
        }

        if (ciudadOrigen.equalsIgnoreCase("TEBAIDA") && ciudadDestino.equalsIgnoreCase("CORDOBA")
                || ciudadOrigen.equalsIgnoreCase("CORDOBA") && ciudadDestino.equalsIgnoreCase("TEBAIDA")) {
            return 13800;
        }

        if (ciudadOrigen.equalsIgnoreCase("TEBAIDA") && ciudadDestino.equalsIgnoreCase("BUENAVISTA")
                || ciudadOrigen.equalsIgnoreCase("BUENAVISTA") && ciudadDestino.equalsIgnoreCase("TEBAIDA")) {
            return 15000;
        }

        if (ciudadOrigen.equalsIgnoreCase("TEBAIDA") && ciudadDestino.equalsIgnoreCase("GENOVA")
                || ciudadOrigen.equalsIgnoreCase("GENOVA") && ciudadDestino.equalsIgnoreCase("TEBAIDA")) {
            return 18000;
        }

        if (ciudadOrigen.equalsIgnoreCase("BUENAVISTA") && ciudadDestino.equalsIgnoreCase("CORDOBA")
                || ciudadOrigen.equalsIgnoreCase("CORDOBA") && ciudadDestino.equalsIgnoreCase("BUENAVISTA")) {
            return 5400;
        }

        if (ciudadOrigen.equalsIgnoreCase("BUENAVISTA") && ciudadDestino.equalsIgnoreCase("PIJAO")
                || ciudadOrigen.equalsIgnoreCase("PIJAO") && ciudadDestino.equalsIgnoreCase("BUENAVISTA")) {
            return 6000;
        }

        if (ciudadOrigen.equalsIgnoreCase("BUENAVISTA") && ciudadDestino.equalsIgnoreCase("GENOVA")
                || ciudadOrigen.equalsIgnoreCase("GENOVA") && ciudadDestino.equalsIgnoreCase("BUENAVISTA")) {
            return 10000;
        }

        if (ciudadOrigen.equalsIgnoreCase("CORDOBA") && ciudadDestino.equalsIgnoreCase("PIJAO")
                || ciudadOrigen.equalsIgnoreCase("PIJAO") && ciudadDestino.equalsIgnoreCase("CORDOBA")) {
            return 9300;
        }

        if (ciudadOrigen.equalsIgnoreCase("CORDOBA") && ciudadDestino.equalsIgnoreCase("GENOVA")
                || ciudadOrigen.equalsIgnoreCase("GENOVA") && ciudadDestino.equalsIgnoreCase("CORDOBA")) {
            return 13200;
        }

        if (ciudadOrigen.equalsIgnoreCase("PIJAO") && ciudadDestino.equalsIgnoreCase("GENOVA")
                || ciudadOrigen.equalsIgnoreCase("GENOVA") && ciudadDestino.equalsIgnoreCase("PIJAO")) {
            return 12000;
        }

        return 1000;
    }

    public EnvioComponent createShipping(String type,String addressOrigin,String addressDestination,Usuario user){
        LocalDateTime date = LocalDateTime.now();

        if(date.getHour() >= 16){
            date = date.plusDays(1).withHour(9).withMinute(0).withSecond(0).withNano(0);
        }else{
            date = date.plusHours(4);
        }

        return EnvioFactory.newInstance(type, this.ciudadOrigen, this.ciudadDestino,addressOrigin,addressDestination,EstadoEnvio.SOLICITADO, this.price,date,user);
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
