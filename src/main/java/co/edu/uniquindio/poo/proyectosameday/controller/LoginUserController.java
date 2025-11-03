package co.edu.uniquindio.poo.proyectosameday.controller;

import co.edu.uniquindio.poo.proyectosameday.model.Administrador;
import co.edu.uniquindio.poo.proyectosameday.model.Empresa;
import co.edu.uniquindio.poo.proyectosameday.model.dtos.AdministradorDTO;
import co.edu.uniquindio.poo.proyectosameday.model.dtos.PersonaDTO;

import java.util.Map;

public class LoginUserController {
    Empresa empresa;

    public LoginUserController(Empresa empresa) {
        this.empresa = empresa;
    }

    public PersonaDTO loginUser(String documento, String password) {
        return empresa.loginUser(documento, password);
    }

    public AdministradorDTO loginAdmin(String documento, String password) {
        return empresa.loginAdministrador(documento, password);
    }
}
