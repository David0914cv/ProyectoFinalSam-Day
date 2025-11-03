package co.edu.uniquindio.poo.proyectosameday.controller;

import co.edu.uniquindio.poo.proyectosameday.model.Empresa;
import co.edu.uniquindio.poo.proyectosameday.model.Persona;
import co.edu.uniquindio.poo.proyectosameday.model.Usuario;

public class RegisterUserController {

    Empresa empresa;

    public RegisterUserController(Empresa empresa) {
        this.empresa = empresa;
    }

    public Persona SignUp(String email,String document, String name, String cell, String password){

        if (empresa.getUsuario(document) != null || empresa.getAdministrador(document) != null) {
            return null;
        }

        Persona user = new Usuario(name,document, cell, email, password);

        for (int i = 0; i < empresa.getListPersonas().size(); i++) {
            if (user.getId().equals(empresa.getListPersonas().get(i).getId())){
                user = new Usuario(name,document, cell, email, password);
                i=0;
            }
        }

        empresa.agregarPersona(user);
        return user;

    }

}
