package co.edu.uniquindio.poo.proyectosameday.repository;

import co.edu.uniquindio.poo.proyectosameday.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static  Database db;

    private List<String> listCiudades;
    private List<Persona> listPersonas;
    private List<Administrador> listAdministradores ;
    private List<EnvioComponent> listEnvios ;
    private List<Pago> listPagos ;

    private Database() {
        this.listCiudades = new ArrayList<>();
        this.listPersonas = new ArrayList<>();
        this.listAdministradores = new ArrayList<>();
        this.listEnvios = new ArrayList<>();
        this.listPagos = new ArrayList<>();
        cargarCiudades();
        cargarPersonas();
        cargarAdministradores();
        cargarEnvios();
    }

    public static Database getInstance(){
        if(db == null){
            db = new Database();
        }
        return db;
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

    public Usuario getUserDocument(String documento){
        for(Persona persona:this.listPersonas){
            if (persona.getDocumento().equals(documento)){
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

    public void addPago(Pago pago){
        this.listPagos.add(pago);
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

    public List<EnvioComponent> getListShapesDate(LocalDate date){
        List<EnvioComponent> listShapes = new ArrayList<>();

        for (EnvioComponent shape:this.listEnvios){
            if(shape.getFechaEntrega().isAfter(date.atTime(12,0))){
                listShapes.add(shape);
            }
        }

        return listShapes;
    }

    public List<EnvioComponent> getListShapesState(String state){
        List<EnvioComponent> listShapes = new ArrayList<>();

        for (EnvioComponent shape:this.listEnvios){
            if(state.equalsIgnoreCase("Solicitado")){
                if(shape.getEstado() == EstadoEnvio.SOLICITADO){
                    listShapes.add(shape);
                }
            }

            if (state.equalsIgnoreCase("Asignado")){
                if(shape.getEstado() == EstadoEnvio.ASIGNADO){
                    listShapes.add(shape);
                }
            }

            if(state.equalsIgnoreCase("En ruta")){
                if(shape.getEstado() == EstadoEnvio.EN_RUTA){
                    listShapes.add(shape);
                }
            }

            if (state.equalsIgnoreCase("Entregado")) {
                if(shape.getEstado() == EstadoEnvio.ENTREGADO){
                    listShapes.add(shape);
                }
            }

            if (state.equalsIgnoreCase("Incidencia")){
                if(shape.getEstado() == EstadoEnvio.INCIDENCIA){
                    listShapes.add(shape);
                }
            }
        }

        return listShapes;
    }

    public void deleteUser(String id){
        this.listPersonas.removeIf(persona -> persona.getId().equals(id));
    }

    public List<Usuario> getListUsers(){
        List<Usuario> listUsers = new ArrayList<>();
        for (Persona user: this.listPersonas){
            if (user.getClass() == Usuario.class){
                listUsers.add((Usuario) user);
            }
        }

        return listUsers;
    }

    public List<Repartidor> getListDealers(){
        List<Repartidor> listUsers = new ArrayList<>();
        for (Persona user: this.listPersonas){
            if (user.getClass() == Repartidor.class){
                listUsers.add((Repartidor) user);
            }
        }

        return listUsers;
    }

    public void addEnvio(EnvioComponent envio){
        this.listEnvios.add(envio);
    }

    public void addPersona(Persona persona){
        this.listPersonas.add(persona);
    }

    public void addAdministrador(Administrador administrador){
        this.listAdministradores.add(administrador);
    }

    public void cargarAdministradores(){
        Administrador admin1 = new Administrador("1010","Jorge Ivan Quintero","123");
        listAdministradores.add(admin1);
    }

    public void cargarPersonas(){
        Persona user1 = new Usuario("David","2020","30154447565","dabeats0914@gmail.com","123");
        Persona rp1= new Repartidor("Nico","3124579888","123","3030", EstadoDisponibilidad.ACTIVO);

        this.listPersonas.add(user1);
        this.listPersonas.add(rp1);

    }


    public void cargarEnvios(){
        EnvioComponent shape = EnvioFactory.newInstance("normal","CALARCA","ARMENIA","calle 40#20-12","carrera 14 #21-54",EstadoEnvio.SOLICITADO,15000, LocalDateTime.now().plusHours(4),getUserDocument("2020"));
        this.listEnvios.add(shape);
    }

    public void cargarCiudades(){
        listCiudades.add("CALARCA");
        listCiudades.add("ARMENIA");
        listCiudades.add("CIRCASIA");
        listCiudades.add("FILANDIA");
        listCiudades.add("SALENTO");
        listCiudades.add("PIJAO");
        listCiudades.add("MONTENEGRO");
        listCiudades.add("TEBAIDA");
        listCiudades.add("CORDOBA");
        listCiudades.add("QUIMBAYA");
        listCiudades.add("GENOVA");
        listCiudades.add("BUENAVISTA");
    }

    public List<Pago> getListPagos() {
        return listPagos;
    }

    public void setListPagos(List<Pago> listPagos) {
        this.listPagos = listPagos;
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

    public List<String> getListCiudades() {
        return listCiudades;
    }

    public void setListCiudades(List<String> listCiudades) {
        this.listCiudades = listCiudades;
    }

    public List<EnvioComponent> getListEnvios() {
        return listEnvios;
    }

    public void setListEnvios(List<EnvioComponent> listEnvios) {
        this.listEnvios = listEnvios;
    }
}
