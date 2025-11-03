package co.edu.uniquindio.poo.proyectosameday.controller;

import co.edu.uniquindio.poo.proyectosameday.model.*;
import co.edu.uniquindio.poo.proyectosameday.model.dtos.PersonaDTO;

import java.time.LocalDateTime;

public class SendingUserController {

    Empresa empresa;

    public SendingUserController(Empresa empresa){
        this.empresa = empresa;
    }

    public EnvioComponent createSendingUser(String type, Cotizacion cotizacion, String addressOrigin, String addressDestination, PersonaDTO user){
        Persona resp = empresa.getUserId(user.getId());

        EnvioComponent envio = cotizacion.createShipping(type,addressOrigin,addressDestination,(Usuario) resp);
        empresa.addEnvio(envio);

        return envio;
    }

}
