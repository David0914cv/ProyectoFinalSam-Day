package co.edu.uniquindio.poo.proyectosameday.controller;

import co.edu.uniquindio.poo.proyectosameday.model.Empresa;
import co.edu.uniquindio.poo.proyectosameday.model.dtos.PersonaDTO;
import co.edu.uniquindio.poo.proyectosameday.repository.Database;

public class FormUpdateController {
    Empresa empresa;

    public FormUpdateController(Empresa empresa) {
        this.empresa = empresa;
    }

    public PersonaDTO updateUser(String id, String name, String email, String cell){
        return empresa.updateUser(id, name, email, cell);
    }

}
