package co.edu.uniquindio.poo.proyectosameday.repository;

import co.edu.uniquindio.poo.proyectosameday.model.*;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static  Database db;

    private List<String> listCiudades;
    private List<Persona> listPersonas;
    private List<Administrador> listAdministradores ;
    private List<EnvioComponent> listEnvios ;

    private Database() {
        this.listCiudades = new ArrayList<>();
        this.listPersonas = new ArrayList<>();
        this.listAdministradores = new ArrayList<>();
        this.listEnvios = new ArrayList<>();
        cargarCiudades();
        cargarPersonas();
        cargarAdministradores();
    }

    public static Database getInstance(){
        if(db == null){
            db = new Database();
        }
        return db;
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
        Administrador admin1 = new Administrador("789","Jorge Ivan Quintero","qwerty");
        listAdministradores.add(admin1);
    }

    public void cargarPersonas(){
        Persona user1 = new Usuario("David","2020","30154447565","dabeats0914@gmail.com","123");
        Persona rp1= new Repartidor("Nico","3124579888","1234","1010", EstadoDisponibilidad.ACTIVO);

        this.listPersonas.add(user1);
        this.listPersonas.add(rp1);

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
