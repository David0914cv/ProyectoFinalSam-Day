package co.edu.uniquindio.poo.proyectosameday.controller;

import co.edu.uniquindio.poo.proyectosameday.model.Empresa;

import java.util.Map;

public class LoginUserController {
    Empresa empresa;

    public LoginUserController(Empresa empresa) {
        this.empresa = empresa;
    }

    public Map<String, String> login(String user, String correo, String password) {
        return empresa.iniciarSesion(user, correo, password);
    }
}
