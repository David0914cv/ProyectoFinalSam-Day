package co.edu.uniquindio.poo.proyectosameday.controller;

import co.edu.uniquindio.poo.proyectosameday.model.Cotizacion;
import co.edu.uniquindio.poo.proyectosameday.model.Empresa;

public class QuoteShippingController {

    Empresa empresa;

    public QuoteShippingController(Empresa empresa) {
        this.empresa = empresa;
    }

    public Cotizacion calculatePrice(String cityOrigin, String cityDestination, int weight, String dimensions) {

        Cotizacion price = new Cotizacion.Builder()
                .ciudadOrigen(cityOrigin)
                .ciudadDestino(cityDestination)
                .peso(weight)
                .dimensiones(dimensions)
                .build();

        price.calcularPrecio();

        return price;
    }

}
