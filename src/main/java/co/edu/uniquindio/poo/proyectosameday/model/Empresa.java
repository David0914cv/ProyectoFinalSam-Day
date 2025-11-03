package co.edu.uniquindio.poo.proyectosameday.model;

import co.edu.uniquindio.poo.proyectosameday.model.dtos.AdministradorDTO;
import co.edu.uniquindio.poo.proyectosameday.model.dtos.PersonaDTO;
import co.edu.uniquindio.poo.proyectosameday.repository.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Empresa {
    private static Empresa empresa;
    private Database database;
    private String nombre,nit;
    private List<Persona> listPersonas;
    private List<Administrador> listAdministradores ;
    private List<EnvioComponent> listEnvios ;

    private Empresa(){
        this.nombre="Same-Day";
        this.nit="12345";
        this.listPersonas=new ArrayList<>();
        this.listAdministradores=new ArrayList<>();
        this.listEnvios=new ArrayList<>();
        this.database= Database.getInstance();
        cargarDatos();
    }

    public static Empresa getInstance(){
        if(empresa==null){
            empresa = new Empresa();
        }
        return empresa;
    }

    public void addEnvio(EnvioComponent envio){
        this.listEnvios.add(envio);
        this.database.addEnvio(envio);
    }

    public void agregarAdministrador(Administrador administrador){
        this.listAdministradores.add(administrador);
        this.database.addAdministrador(administrador);
    }

    public Administrador getAdministrador(String documento){
        for(Administrador admin:this.listAdministradores){
            if ( admin.getDocumento().equals(documento)){
                return admin;
            }
        }
        return null;
    }

    public void agregarPersona(Persona persona){
        this.listPersonas.add(persona);
        this.database.addPersona(persona);
    }

    public Persona getUsuario(String documento){
        for(Persona persona:this.listPersonas){
            if (persona.getDocumento().equals(documento)){
                return persona;
            }
        }
        return null;
    }

    public Persona getUserId(String documento){
        for(Persona persona:this.listPersonas){
            if (persona.getId().equals(documento)){
                return persona;
            }
        }
        return null;
    }

    public PersonaDTO loginUser(String documento, String contrasena){

        Persona user1 = getUsuario(documento);

        if(user1.getClass() == Usuario.class){
            return new PersonaDTO(user1.getId(),user1.getNombre(),"Usuario");
        }
        if(user1.getClass() == Repartidor.class){
            return new PersonaDTO(user1.getId(),user1.getNombre(),"Repartidor");
        }

        return null;

    }

    public AdministradorDTO loginAdministrador(String documento, String contrasena) {
        if (getAdministrador(documento) != null && getAdministrador(documento).getContrasena().equals(Hash.hashear(contrasena))) {
            return new AdministradorDTO(getAdministrador(documento).getDocumento(),getAdministrador(documento).getNombre());
        }
        return null;
    }

    public void cargarDatos(){
        this.listPersonas.addAll(database.getListPersonas());
        this.listAdministradores.addAll(database.getListAdministradores());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public List<Persona> getListPersonas() {
        return listPersonas;
    }

    public void setListPersonas(List<Persona> listPersonas) {
        this.listPersonas = listPersonas;
    }

    public List<Administrador> getListAdministradores() {
        return listAdministradores;
    }

    public void setListAdministradores(List<Administrador> listAdministradores) {
        this.listAdministradores = listAdministradores;
    }

    public List<EnvioComponent> getListEnvios() {
        return listEnvios;
    }

    public void setListEnvios(List<EnvioComponent> listEnvios) {
        this.listEnvios = listEnvios;
    }
}
