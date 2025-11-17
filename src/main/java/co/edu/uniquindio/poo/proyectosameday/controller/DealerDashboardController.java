package co.edu.uniquindio.poo.proyectosameday.controller;

import co.edu.uniquindio.poo.proyectosameday.model.Empresa;
import co.edu.uniquindio.poo.proyectosameday.model.EstadoDisponibilidad;
import co.edu.uniquindio.poo.proyectosameday.model.Repartidor;

public class DealerDashboardController {
    Empresa empresa;

    public DealerDashboardController(Empresa empresa) {
        this.empresa = empresa;
    }

    public void updateStateDealer(Repartidor dealer, EstadoDisponibilidad state){
        this.empresa.updateStateDealer(dealer.getId(),  state);
    }
}
