package co.edu.uniquindio.poo.proyectosameday.controller;

import co.edu.uniquindio.poo.proyectosameday.model.Empresa;
import co.edu.uniquindio.poo.proyectosameday.model.Persona;
import co.edu.uniquindio.poo.proyectosameday.model.Usuario;

public class RegisterUserController {

    Empresa empresa;

    public RegisterUserController(Empresa empresa) {
        this.empresa = empresa;
    }

    public void SignUp(String email, String name, String cell, String password){
        Persona user = new Usuario(name, cell, email, password);

        for (int i = 0; i < empresa.getListPersonas().size(); i++) {
            if (user.getId().equals(empresa.getListPersonas().get(i).getId())){
                user = new Usuario(name, cell, email, password);
                i=-1;
            }
        }

        empresa.agregarPersona(user);

    }

}
