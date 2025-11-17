package co.edu.uniquindio.poo.proyectosameday.controller;

import co.edu.uniquindio.poo.proyectosameday.model.*;
import co.edu.uniquindio.poo.proyectosameday.model.dtos.PersonaDTO;

public class AdminController {
    Empresa empresa;

    public AdminController(Empresa empresa) {
        this.empresa = empresa;
    }

    public void deleteUser (String id){
        empresa.deleteUser(id);
    }

    public PersonaDTO updateDealer(String id, String name, String cell){
        return empresa.updateDealer(id, name, cell);
    }

    public Persona createDealer(String document, String name, String cell, String password){

        if (empresa.getUsuario(document) != null || empresa.getAdministrador(document) != null) {
            return null;
        }

        Persona dealer = new Repartidor(name,cell,password,document, EstadoDisponibilidad.INACTIVO);

        for (int i = 0; i < empresa.getListPersonas().size(); i++) {
            if (dealer.getId().equals(empresa.getListPersonas().get(i).getId())){
                dealer = new Repartidor(name,cell,password,document, EstadoDisponibilidad.INACTIVO);
                i=0;
            }
        }

        empresa.agregarPersona(dealer);
        return dealer;

    }

    public void assignDealer(Administrador admin, EnvioComponent shape, Repartidor dealer){
        System.out.println("hola 2:"+shape.getId());
        AssignDealerFacade facade = new AssignDealerFacade(admin,new Notify());

        facade.assignDealer(this.empresa,shape,dealer,shape.getUsuario(),"Se ha asignado al envio con id: \n"+shape.getId()+"\nA el repartidor"+dealer.getNombre());
    }

}
