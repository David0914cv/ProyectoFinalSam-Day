package co.edu.uniquindio.poo.proyectosameday.controller;

import co.edu.uniquindio.poo.proyectosameday.model.Empresa;
import co.edu.uniquindio.poo.proyectosameday.model.EnvioComponent;
import co.edu.uniquindio.poo.proyectosameday.model.Pago;
import co.edu.uniquindio.poo.proyectosameday.model.Usuario;
import co.edu.uniquindio.poo.proyectosameday.model.dtos.PersonaDTO;
import co.edu.uniquindio.poo.proyectosameday.repository.Database;

public class PaymentMethodController {
    Empresa empresa;

    public PaymentMethodController(Empresa empresa) {
        this.empresa = empresa;
    }

    public void SetPay(Usuario usuario, EnvioComponent envio) {
        Pago pay = new Pago(usuario,envio);
        empresa.addPago(pay);
    }

    public void addEnvio(EnvioComponent envio) {
        empresa.addEnvio(envio);
    }

    public Usuario getUser(PersonaDTO user){
        return empresa.getUserId(user.getId());
    }
}
