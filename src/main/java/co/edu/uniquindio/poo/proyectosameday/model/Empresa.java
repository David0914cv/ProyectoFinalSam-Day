package co.edu.uniquindio.poo.proyectosameday.model;

import co.edu.uniquindio.poo.proyectosameday.model.dtos.AdministradorDTO;
import co.edu.uniquindio.poo.proyectosameday.model.dtos.PersonaDTO;
import co.edu.uniquindio.poo.proyectosameday.repository.Database;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private static Empresa empresa;
    private Database database;
    private String nombre,nit;
    private List<Persona> listPersonas;
    private List<Administrador> listAdministradores ;
    private List<EnvioComponent> listEnvios ;
    private List<Pago> listPagos ;

    private Empresa(){
        this.nombre="Same-Day";
        this.nit="12345";
        this.listPersonas=new ArrayList<>();
        this.listAdministradores=new ArrayList<>();
        this.listEnvios=new ArrayList<>();
        this.listPagos=new ArrayList<>();
        this.database= Database.getInstance();
        cargarDatos();
    }

    public static Empresa getInstance(){
        if(empresa==null){
            empresa = new Empresa();
        }
        return empresa;
    }

    public void addPago(Pago pago){
        this.listPagos.add(pago);
        this.database.addPago(pago);
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

    public Usuario getUserId(String documento){
        for(Persona persona:this.listPersonas){
            if (persona.getId().equals(documento)){
                if (persona.getClass() == Usuario.class){
                    return (Usuario) persona;
                }
            }
        }
        return null;
    }

    public Repartidor getDealerId(String documento){
        for(Persona persona:this.listPersonas){
            if (persona.getId().equals(documento)){
                if (persona.getClass() == Repartidor.class){
                    return (Repartidor) persona;
                }
            }
        }
        return null;
    }

    public PersonaDTO updateUser(String id, String name, String email, String cell){
        for (int i = 0; i < listPersonas.size(); i++) {
            if (listPersonas.get(i).getId().equals(id)){
                if (listPersonas.get(i).getClass() == Usuario.class){
                    Usuario user = (Usuario) listPersonas.get(i);
                    user.setCorreo(email);
                    user.setNombre(name);
                    user.setTelefono(cell);
                    listPersonas.set(i, user);
                    database.setListPersonas(this.listPersonas);
                    return new PersonaDTO(user.getId(), user.getNombre(), "Usuario");
                }
            }
        }
        return null;
    }

    public PersonaDTO updateDealer(String id, String name, String cell){
        for (int i = 0; i < listPersonas.size(); i++) {
            if (listPersonas.get(i).getId().equals(id)){
                if (listPersonas.get(i).getClass() == Repartidor.class){
                    Repartidor dealer = (Repartidor) listPersonas.get(i);
                    dealer.setNombre(name);
                    dealer.setTelefono(cell);
                    listPersonas.set(i, dealer);
                    database.setListPersonas(this.listPersonas);
                    return new PersonaDTO(dealer.getId(), dealer.getNombre(), "Repartidor");
                }
            }
        }
        return null;
    }

    public void deleteUser(String id){
        this.listPersonas.removeIf(persona -> persona.getId().equals(id));
        database.deleteUser(id);
    }

    public List<EnvioComponent> getListEnviosUser(String id){
        List<EnvioComponent> listEnvios = new ArrayList<>();
        for (EnvioComponent envio:this.listEnvios){
            if (envio.getUsuario().getId().equals(id)){
                listEnvios.add(envio);
            }
        }
        return listEnvios;
    }

    public PersonaDTO loginUser(String documento, String contrasena){

        Persona user1 = getUsuario(documento);
        if (user1 == null) {
            return null;
        }
        if(user1.getClass() == Usuario.class && user1.getContrasena().equals(Hash.hashear(contrasena))){
            return new PersonaDTO(user1.getId(),user1.getNombre(),"Usuario");
        }
        if(user1.getClass() == Repartidor.class && user1.getContrasena().equals(Hash.hashear(contrasena))){
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
        this.listEnvios.addAll(database.getListEnvios());
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
